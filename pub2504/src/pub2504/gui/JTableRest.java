package pub2504.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

// https://jsonplaceholder.typicode.com/todos 데이터 REST 통신을 통한
// javax.swing.JTable 연동

public class JTableRest extends JFrame {

	// End Point
	private final String API_URL = "https://jsonplaceholder.typicode.com/todos";

	// 통신 객체 (HTTP Client : HTTP 요청을 보내고 응답받는 객체)
	private final OkHttpClient client = new OkHttpClient();

	// Java 객체 <=> JSON 문자열 변환용 Gson
	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	// UI : JTable
	private JTable table;

	// Model(Data) : DefaultTableModel
	private DefaultTableModel model;

	public JTableRest() {
		init();
	}

	// 초기화 메소드
	private void init() {

		setTitle("JTable Rest API 연동"); // 프레임 제목
		setSize(800, 500); // 프레임 크기
		setDefaultCloseOperation(EXIT_ON_CLOSE); // X버튼 누르면 종료
		setLocationRelativeTo(null); // 프레임 위치를 모니터 정중앙에 배치

		// DefaultTableModel 설정
		// 1번째 파라미터 컬럼명들, 2번째 파라미터는 0 = 행의 수(처음)
		model = new DefaultTableModel(new String[] { "userId", "id", "title", "completed" }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) { // 셀 편집가능여부 return
				return column != 1; // id는 수정 불가
			}
		};

		// JTable 설정
		table = new JTable(model);

		// 테이블을 스크롤 가능하도록 스크롤페인에 붙이고 스크롤페인을 프레임의 CENTER에 붙힘
		add(new JScrollPane(table), BorderLayout.CENTER);

		// 버튼 패널
		JPanel btnPanel = new JPanel();
		JButton getBtn = new JButton("GET");
		JButton postBtn = new JButton("POST");
		JButton putBtn = new JButton("PUT");
		JButton delBtn = new JButton("DELETE");
		btnPanel.add(getBtn);
		btnPanel.add(postBtn);
		btnPanel.add(putBtn);
		btnPanel.add(delBtn);

		// 버튼 패널을 프레임의 SOUTH에 붙임
		add(btnPanel, BorderLayout.SOUTH);

		// 버튼 이벤트리스너 등록
		getBtn.addActionListener(e -> loadTodos());
		postBtn.addActionListener(e -> openAddDialog());
		putBtn.addActionListener(e -> updateTodo());
		delBtn.addActionListener(e -> deleteTodo());

		setVisible(true);

	} // init()

	// GET요청 : 데이터 로딩 메소드
	private void loadTodos() {

		// request 요청 객체 만들기
		Request request = new Request.Builder().url(API_URL).build();

		// 요청, 요청처리 콜백
		client.newCall(request).enqueue(new Callback() {
			// 응답성공시 수행할 콜백메소드
			@Override
			public void onResponse(Call arg0, Response response) throws IOException {
				// 응답바디를 JSON 문자열로 추출
				String json = Objects.requireNonNull(response.body().string());
				// JSON 문자열을 List<Todo> 로 변환
				List<Todo> todos = gson.fromJson(json, new TypeToken<List<Todo>>() {
				}.getType());
				SwingUtilities.invokeLater(() -> {
					// 기존 데이터 제거
					model.setRowCount(0);
					// List내의 Todo들을 테이블의 행을 추가
					for (Todo todo : todos) {
						model.addRow(
								new Object[] { todo.getUserId(), todo.getId(), todo.getTitle(), todo.isCompleted() });
					}
				});
			}

			// 응답실패시 수행할 콜백메소드
			@Override
			public void onFailure(Call arg0, IOException ioe) {
				showError("데이터 로딩 실패!" + ioe.getMessage());
			}
		});
	} // loadTodos()

	// POST요청 : 사용자 입력을 통해 새로운 Todo 생성
	private void openAddDialog() {

		// 새로운 다이얼로그 : 부모컴포넌트, 제목, 모달(modal)여부
		JDialog dialog = new JDialog(this, "Todo 추가", true);
		dialog.setSize(300, 250);
		dialog.setLayout(new GridLayout(4, 2));

		JTextField tfUserId = new JTextField();
		JTextField tfTitle = new JTextField();
		JCheckBox cbCompleted = new JCheckBox();

		dialog.add(new JLabel("userId: "));
		dialog.add(tfUserId);
		dialog.add(new JLabel("title: "));
		dialog.add(tfTitle);
		dialog.add(new JLabel("complted: "));
		dialog.add(cbCompleted);

		JButton ok = new JButton("추가");
		JButton cancel = new JButton("취소");

		dialog.add(ok);
		dialog.add(cancel);

		// 추가 버튼 누르면
		ok.addActionListener(e -> {
			// 사용자 입력 데이터를 Todo 객체로 생성
			Todo todo = new Todo(Integer.parseInt(tfUserId.getText()), 0, tfTitle.getText(), cbCompleted.isSelected());

			// 요청바디 생성
			RequestBody body = RequestBody.create(MediaType.get("application/json"), // 요청 데이터 JSON
					gson.toJson(todo) // todo 객체를 JSON 문자열로
			);

			// 요청 생성
			Request request = new Request.Builder().url(API_URL).post(body).build();

			// POST 요청 전송
			client.newCall(request).enqueue(new Callback() {
				@Override
				public void onResponse(Call call, Response response) throws IOException {
					SwingUtilities.invokeLater(() -> {
						JOptionPane.showMessageDialog(dialog, "Todo 추가 완료!");
						dialog.dispose(); // 입력창 닫기 (메모리에서 해제)
						loadTodos(); // 목록을 다시 갱신
					});
				}

				@Override
				public void onFailure(Call call, IOException ioe) {
					showError("Todo 추가 실패: " + ioe.getMessage());
				}
			});
		});

		// 취소버튼 누르면 입력창 닫기
		cancel.addActionListener(e -> dialog.dispose());
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);

	}// openAddDialog()

	// PUT 요청 : JTable 에서 수정된 Todo 를 전송
	private void updateTodo() {

		int row = table.getSelectedRow(); // 선택한 행 번호
		if (row == -1) {
			showError("수정할 행을 선택하세요!");
			return;
		}

		// 수정할 Todo
		Todo todo = new Todo(
				// model.getValueAt(행번호, 열번호) : 행/열의 값을 획득
				Integer.parseInt(model.getValueAt(row, 0).toString()),
				Integer.parseInt(model.getValueAt(row, 1).toString()), model.getValueAt(row, 2).toString(),
				Boolean.parseBoolean(model.getValueAt(row, 3).toString()));

		// 요청바디
		RequestBody body = RequestBody.create(MediaType.get("application/json"), gson.toJson(todo));

		// 요청 객체
		Request request = new Request.Builder().url(API_URL + "/" + todo.getId()).put(body).build();

		// 요청
		client.newCall(request).enqueue(new Callback() {
			@Override
			public void onResponse(Call call, Response response) throws IOException {
				SwingUtilities.invokeLater(() -> {
					JOptionPane.showMessageDialog(null, "수정 완료!");
				});
			}

			@Override
			public void onFailure(Call call, IOException ioe) {
				showError("수정 실패! " + ioe.getMessage());
			}
		});

	} // updateTodo()

	// 삭제 요청 메소드
	private void deleteTodo() {

		int row = table.getSelectedRow();
		if (row == -1) {
			showError("수정할 행을 선택하세요!");
			return;
		}

		String selectId = model.getValueAt(row, 1).toString();

		Request request = new Request.Builder().url(API_URL + "/" + selectId).delete().build();

		client.newCall(request).enqueue(new Callback() {
			@Override
			public void onResponse(Call call, Response response) throws IOException {
				SwingUtilities.invokeLater(() -> {
					JOptionPane.showMessageDialog(null, "삭제 완료!");
				});
			}

			@Override
			public void onFailure(Call call, IOException ioe) {
				showError("삭제 요청이 실패 했습니다. " + ioe.getMessage());
			}
		});

	} // deleteTodo()

	// 에러 메세지출력 메소드
	private void showError(String msg) {
		SwingUtilities.invokeLater(() -> {
			// 부모컴포넌트, 메세지, 제목, 메세지타입 상수
			JOptionPane.showMessageDialog(this, msg, "오류", JOptionPane.ERROR_MESSAGE);
		});
	} // showErro()

	public static void main(String[] args) {
		// JTableRest 클래스의 생성자를 EDT (Event Dispatch Thread)에서 실행
		// Why? Java 의 swing 은 단일 스레드 모델을 따르기 때문에 비동기처리하기 위해
		SwingUtilities.invokeLater(JTableRest::new);
	} // main

} // class

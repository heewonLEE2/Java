package pub2504.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class StudentRest {

	private static final OkHttpClient client = new OkHttpClient();
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	public static List<Student> studentsList = new ArrayList<Student>();
	private static StudentUI studentUI = new StudentUI();

	// Get 요청 메소드 // StudentList를 반환 해서 사용
	public static void getStudent(String API_URL) {
		Request request = new Request.Builder().url(API_URL).get().build();

		client.newCall(request).enqueue(new Callback() {
			@Override
			public void onResponse(Call call, Response response) throws IOException {
				String json = Objects.requireNonNull(response.body().string());
				studentsList = gson.fromJson(json, new TypeToken<List<Student>>() {
				}.getType());
				SwingUtilities.invokeLater(() -> {
					// 기존 데이터 제거
					StudentUI.model.setRowCount(0);
					// List내의 Todo들을 테이블의 행을 추가
					for (Student st : studentsList) {
						StudentUI.model.addRow(new Object[] { st.getId(), st.getName(), st.getScore().getKor(),
								st.getScore().getEng(), st.getScore().getMath(),
								st.getScore().getKor() + st.getScore().getEng() + st.getScore().getMath(),
								(st.getScore().getKor() + st.getScore().getEng() + st.getScore().getMath()) / 3 });
					}
				});
			}

			@Override
			public void onFailure(Call call, IOException ioe) {
				ioe.printStackTrace();
			}
		});
	} // getRest()

	// POST 요청
	public static void postStudent(String API_URL, Student student) {

		// 요청바디 생성
		RequestBody body = RequestBody.create(MediaType.get("application/json"), // 요청 데이터 JSON
				gson.toJson(student) // student 객체를 JSON 문자열로
		);

		// 요청 생성
		Request request = new Request.Builder().url(API_URL).post(body).build();

		// POST 요청 전송 완료/실패 콜백
		client.newCall(request).enqueue(new Callback() {
			@Override
			public void onResponse(Call call, Response response) throws IOException {
				SwingUtilities.invokeLater(() -> {
					JOptionPane.showMessageDialog(StudentUI.dialog, "Todo 추가 완료!");
					StudentUI.dialog.dispose(); // 입력창 닫기 (메모리에서 해제)
					getStudent(API_URL);
				});
			}

			@Override
			public void onFailure(Call call, IOException ioe) {
				ioe.printStackTrace();
			}
		});

	} // postRest()

	// DELETE 요청
	public static void deleteStudent(String API_URL) {
		
		int row = StudentUI.table.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(null, "행을 선택해주세요!!");
			return;
		}
		
		String selectId = StudentUI.model.getValueAt(row, 0).toString();
		
		Request request = new Request.Builder().url(API_URL+"/"+selectId).delete().build();
		
		client.newCall(request).enqueue(new Callback() {
			@Override
			public void onResponse(Call call, Response response) throws IOException {
				SwingUtilities.invokeLater(()->{
					JOptionPane.showMessageDialog(null, "삭제 완료!");
					getStudent(API_URL);
				});
			}
			@Override
			public void onFailure(Call call, IOException ioe) {
				ioe.printStackTrace();
			}
		});
	}
	
	// PUT 요청
	public static void modifyStudent(String API_URL, Student student) {
		
		int row = StudentUI.table.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(null, "행을 선택해주세요!!");
			return;
		}
		
		String selectId = StudentUI.model.getValueAt(row, 0).toString();
		
		// 요청바디 생성
		RequestBody body = RequestBody.create(MediaType.get("application/json"), // 요청 데이터 JSON
				gson.toJson(student) // student 객체를 JSON 문자열로
		);

		// 요청 생성
		Request request = new Request.Builder().url(API_URL+"/"+selectId).put(body).build();
		
		// PUT 요청 전송 완료/실패 콜백
		client.newCall(request).enqueue(new Callback() {
			@Override
			public void onResponse(Call call, Response response) throws IOException {
				SwingUtilities.invokeLater(() -> {
					JOptionPane.showMessageDialog(null, "수정 완료!");
					getStudent(API_URL);
				});
			}

			@Override
			public void onFailure(Call call, IOException ioe) {
				ioe.printStackTrace();
			}
		});
		
	} // modifyStudent()
	
} // class














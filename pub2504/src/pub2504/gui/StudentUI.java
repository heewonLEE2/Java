package pub2504.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StudentUI extends JFrame{

	public StudentUI() {
	}
	// UI : JTable
	public static JTable table;
	
	// Model(Data) : DefaultTableModel
	public static DefaultTableModel model;
	
	// dialog 버튼
	public static JDialog dialog;
	public static JTextField tfUserName;
	public static JTextField tfUserKor;
	public static JTextField tfUserEng;
	public static JTextField tfUserMath;
	
		// 초기화 메소드
		public void init() {
			
			setTitle("JTable MyJson Server Rest API 연동"); // 프레임 제목
			setSize(800,600); // 프레임 크기
			setDefaultCloseOperation(EXIT_ON_CLOSE); // X버튼 누르면 종료
			setLocationRelativeTo(null); // 프레임 위치를 모니터 정중앙에 배치
			
			// DefaultTableModel 설정
			// 1번째 파라미터 컬럼명들, 2번째 파라미터는 0 = 행의 수(처음)
			model = new DefaultTableModel(new String[] {"id", "name", "kor", "math","eng" , "sum", "avg"},0) {
				@Override
				public boolean isCellEditable(int row, int column) { // 셀 편집가능여부 return
					return column != 0 && column !=5 && column !=6; // id는 수정 불가
				}
			};
			
			// JTable 설정
			table = new JTable(model);
			
			// 테이블을 스크롤 가능하도록 스크롤페인에 붙이고 스크롤페인을 프레임의 CENTER에 붙힘
			add(new JScrollPane(table), BorderLayout.CENTER);
			
			// 버튼 패널
			JPanel btnPanel = new JPanel();
			JButton  getBtn = new JButton("GET");
			JButton  postBtn = new JButton("POST");
			JButton  putBtn = new JButton("PUT");
			JButton  delBtn = new JButton("DELETE");
			btnPanel.add(getBtn);
			btnPanel.add(postBtn);
			btnPanel.add(putBtn);
			btnPanel.add(delBtn);
			
			// 버튼 패널을 프레임의 SOUTH에 붙임
			add(btnPanel, BorderLayout.SOUTH);
			
			// 버튼 이벤트리스너 등록
			getBtn.addActionListener(e->new StudentEvent().loadStudents());
			postBtn.addActionListener(e->new StudentEvent().postStudents());
			putBtn.addActionListener(e->new StudentEvent().modifyStudent());
			delBtn.addActionListener(e->new StudentEvent().delStudent());
			
			setVisible(true);
			
		} // init()
	
		// post dailog 메소드
		public void veiwDailog() {
			// 새로운 다이얼로그 : 부모컴포넌트, 제목, 모달(modal)여부
			dialog = new JDialog(this, "Student 추가", true);
			dialog.setSize(400, 300);
			dialog.setLayout(new GridLayout(5, 2));
			
			tfUserName = new JTextField();
			tfUserKor = new JTextField();
			tfUserEng = new JTextField();
			tfUserMath = new JTextField();
			
			dialog.add(new JLabel("userName: "));
			dialog.add(tfUserName);
			dialog.add(new JLabel("userKor: "));
			dialog.add(tfUserKor);
			dialog.add(new JLabel("userEng: "));
			dialog.add(tfUserEng);
			dialog.add(new JLabel("userMath: "));
			dialog.add(tfUserMath);
			
			JButton ok = new JButton("추가");
			JButton cancel = new JButton("취소");
			
			dialog.add(ok);
			dialog.add(cancel);
			
			ok.addActionListener(e->new StudentEvent().addStudent());
			
			cancel.addActionListener(e-> dialog.dispose());
			dialog.setLocationRelativeTo(this);
			dialog.setVisible(true);
		}
		
} // class





















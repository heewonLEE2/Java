package pub2504.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StudentEvent {

	StudentUI studentUI = new StudentUI();
	
	
	// 버튼 이벤트리스너 등록
	
	//StudentUI.getBtn.addActionListener(e->new StudentEvent().loadStudents());
	//	studentUI.postBtn addActionListener(e->new StudentEvent().postStudents());
	//	studentUI.putBtn addActionListener(e->new StudentEvent().modifyStudent());
	//	studentUI.delBtn addActionListener(e->new StudentEvent().delStudent());
	
	

	
	
	
	// GET 버튼 클릭
	public void loadStudents() {
		StudentRest.getStudent(StudentMain.API_URL);
	} // loadStudents()
	
	// POST 버튼 클릭 화면 Dailog 보여주기
	public void postStudents() {
		studentUI.veiwDailog();
	} // postStudents()
	
	
	// POST Dailog 에서 추가 버튼 누르면
	public void addStudent(){
		
		Student student = new Student(
				StudentUI.table.getRowCount()+1 +"",
				studentUI.tfUserName.getText(),
				new Score(Integer.parseInt(studentUI.tfUserKor.getText()) ,
								Integer.parseInt(studentUI.tfUserEng.getText()),
								Integer.parseInt(studentUI.tfUserMath.getText())
							)
				);
		
		StudentRest.postStudent(StudentMain.API_URL, student);
	} // addStudent()
	
	// DELETE 요청 버튼 클릭 이벤트
	public void delStudent() {
		StudentRest.deleteStudent(StudentMain.API_URL);
	}
	
	// PUT 요청 버튼 클릭 이벤트
	public void modifyStudent() {
		
		int row = StudentUI.table.getSelectedRow();
		String selectId = StudentUI.model.getValueAt(row, 0).toString();
		
		Student student = new Student(
				selectId,
				StudentUI.model.getValueAt(row, 1).toString(),
				new Score(Integer.parseInt(StudentUI.model.getValueAt(row, 2).toString()) ,
								Integer.parseInt(StudentUI.model.getValueAt(row, 3).toString()),
								Integer.parseInt(StudentUI.model.getValueAt(row, 4).toString())
							)
				);
		
		StudentRest.modifyStudent(StudentMain.API_URL, student);
		
	}// modifyStudent()
	
} // class

	
	
	
	
	
	
	
	
	
package pub2504.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ScoreMain {
	
	static List<Student> studentList = new ArrayList<Student>();
	
	public static void main(String[] args) {
		
		addStudent("홍길동",new Score(80,90,100));
		addStudent("강감찬",new Score(70,60,80));
		addStudent("이순신",new Score(80,60,40));
		
		Scanner scanner = new Scanner(System.in);
		
		StringTokenizer st = null;
		st = new StringTokenizer(scanner.next());
		
		
		for(int i =0; i < studentList.size(); i++) {
			System.out.println(studentList.get(i));
		}
	} // main
	
	// 학생, 점수 추가
	static void addStudent(String name, Score score) {
		studentList.add(new Student(name, score));
	} // addStudent()

	
} // class























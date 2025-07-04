package pub2504.exoop;

public class StudentMain {

	public static void main(String[] args) {

		printScore(makeStudent("홍길동", 100, 80, 90));
		printScore(makeStudent("강감찬", 80, 60, 80));
		printScore(makeStudent("이순신", 60, 60, 90));
		
	} // main
	// 학생 생성
	private static Student_2 makeStudent(String name, int korea, int english, int math) {
		Student_2 student1 = new Student_2(name);
		student1.setScore(student1.new Score(korea,english,math));
		
		return student1;
	}
	
	private static void printScore(Student_2 student) {
		System.out.println(student);
	}
	
} // class

package pub2504.exoop;

public class Subject {

	private String subject;
	private GradePolicy gradePolicy;
	
	public Subject() {
	}
	// 과목 생성자
	public Subject(String subject, GradePolicy gradePolicy) {
		this.subject = subject;
		this.gradePolicy = gradePolicy;
	}

	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public GradePolicy getGradePolicy() {
		return gradePolicy;
	}
	public void setGradePolicy(GradePolicy gradePolicy) {
		this.gradePolicy = gradePolicy;
	}
} // class

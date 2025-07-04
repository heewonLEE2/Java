package pub2504.exoop;

public class Enrollment{

	private int score;
	private Subject subject;
	
	public Enrollment(Subject subject, int score) {
		this.subject = subject;
		this.score = score;
	}

	
	public int getScore() {
		return score;
	}
	public Subject getSubject() {
		return subject;
	}
} // class

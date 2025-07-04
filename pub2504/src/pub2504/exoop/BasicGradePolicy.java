package pub2504.exoop;

public class BasicGradePolicy implements GradePolicy{

	public BasicGradePolicy() {
	}
	
	@Override
	public String calcScore(int score) {
		if(score >= 90) return "A";
		else if(score >= 80) return "B";
		else if(score >= 70) return "C";
		else if(score >= 60) return "D";
		else return "F";
	}
} // class

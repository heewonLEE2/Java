package pub2504.exoop;

public class PFGradePolicy implements GradePolicy{

	public PFGradePolicy() {
	}
	
	@Override
	public String calcScore(int score) {
		if(score >= 70) return "PASS";
		else return "FAIL";
	}
	
} // class

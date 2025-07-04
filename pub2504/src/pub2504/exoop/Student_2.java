package pub2504.exoop;

public class Student_2 {

	private String name;
	private Score score;

	public Student_2() {
	}
	// Student 생성자
	public Student_2(String name) {
		this.name = name;
	}
	public Student_2(String name, Student_2.Score score) {
		this(name);
		this.score = score;
	}
	
	// 함계 평균 메소드 출력
	void scoreSum() {
		System.out.println(name + " 학생의 점수 합계는 : " + this.score.sum);
	}
	void scoreAvg() {
		System.out.println(name + " 학생의 점수 평균은 : " + this.score.avg);
	}
	
	// Score inner class
	public class Score {

		private int korea;
		private int english;
		private int math;
		private int sum;
		private float avg;
		
		public Score() {
		}
		// 생성자
		public Score(int korea, int english, int math) {
			this.korea = korea;
			this.english = english;
			this.math = math;
			this.sum = korea + english + math;
			this.avg = this.sum / 3;
		}
		public int getKorea() {
			return korea;
		}
		public void setKorea(int korea) {
			this.korea = korea;
		}
		public int getEnglish() {
			return english;
		}
		public void setEnglish(int english) {
			this.english = english;
		}
		public int getMath() {
			return math;
		}
		public void setMath(int math) {
			this.math = math;
		}
		public int getSum() {
			return sum;
		}
		public void setSum(int sum) {
			this.sum = sum;
		}
		public float getAvg() {
			return avg;
		}
		public void setAvg(float avg) {
			this.avg = avg;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student_2.Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return name + "님의 성적 합계 : " + score.sum + " 성적 평균 : " + score.avg;
				
	}
	
} // Student class

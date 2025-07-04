package pub2504.collection;

public class Student{

	private String name;
	private Score score;
	
	public Student() {
	}

	public Student(String name, Score score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "이름은 : " + name + "입니다. \n" +
					"국어 : " + score.getKor() +
					" 영어 : " + score.getEng() +
					" 수학 : " + score.getMath() +
					" 총점 : " + score.getSum();
	}
}

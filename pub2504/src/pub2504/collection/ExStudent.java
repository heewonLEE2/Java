package pub2504.collection;

import java.util.Objects;

public class ExStudent {

	private String name;
	private int score;
	
	public ExStudent() {
	}
	public ExStudent(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return name + "님은 " + score + "점 입니다.!";
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.name.equals(((ExStudent)obj).getName())
				&& this.score==((ExStudent)obj).getScore();
	}
	
	// hashCode()에서 name, score 를 기반으로 해시값을 생성하도록
	@Override
	public int hashCode() {
		return Objects.hash(name,score);
	}
}












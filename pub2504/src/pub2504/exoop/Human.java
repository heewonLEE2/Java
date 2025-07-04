package pub2504.exoop;

public class Human  extends AbstractAnimal{
	
	public Human() {
	}

	public Human(String name, int age) {
		super(name, age);
	}

	@Override
	public void eat() {
		System.out.println("이름이 : " + name + "이고, 나이는 : " + age + "살인 사람이 풀과,고기를 먹습니다.");
	}

}

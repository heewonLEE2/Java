package pub2504.exoop;

public class Cow extends AbstractAnimal{

	public Cow() {
	}
	
	public Cow(String name, int age) {
		super(name, age);
	}
	
	
	@Override
	public void eat() {
		System.out.println(age + "살이고 이름이" + name + 
				"인 소가 풀을 먹습니다.");
}
}

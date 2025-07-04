package pub2504.exoop;

public class Lion extends AbstractAnimal{
	
	public Lion() {
	}
	
	public Lion(String name, int age) {
		super(name, age);
	}
	
	@Override
	public void eat() {
		System.out.println(age + "살이고 이름이 " + name + 
										"인 사자가 고기를 먹습니다.");
	}
}

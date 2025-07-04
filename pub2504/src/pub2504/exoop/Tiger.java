package pub2504.exoop;

public class Tiger extends AbstractAnimal {
	
	public Tiger() {
	}

	public Tiger(String name, int age) {
		super(name,age);
	}
	
	@Override
	public void eat() {
		System.out.println(age + "살이고 이름이" + name + 
										"인 호랑이가 고기를 먹습니다.");
	}
}
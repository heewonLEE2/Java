package pub2504.exoop;

public abstract class AbstractAnimal extends AbstractLivingThing implements IEat, ISleep{

	public AbstractAnimal() {
	}
	
	public AbstractAnimal(String name, int age) {
		super(name, age);
	}

	@Override
	public void breathe() {
		System.out.println("생물인 " + name + "가 숨을 쉬고 있습니다.");
	}
	
	@Override
	public void sleep() {
		System.out.println("생물인 " + name + "가 잠을 자고 있습니다.");
	}

	// eat() 추상화 메소드
	public abstract void eat();
	
} // class

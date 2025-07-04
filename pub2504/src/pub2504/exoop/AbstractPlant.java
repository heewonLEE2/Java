package pub2504.exoop;

public abstract class AbstractPlant extends AbstractLivingThing{

	public AbstractPlant() {
	}

	public AbstractPlant(String name, int age) {
		super(name, age);
	}

	@Override
	public void breathe() {
		System.out.println("식물인 "+name + " 숨을 쉬고 있습니다.");
	}
	
} // class

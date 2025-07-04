package pub2504.exoop;

public abstract class AbstractLivingThing implements IBreate{

	String name;
	int age;
	
	public AbstractLivingThing() {
	}

	public AbstractLivingThing(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public abstract void breathe();
}

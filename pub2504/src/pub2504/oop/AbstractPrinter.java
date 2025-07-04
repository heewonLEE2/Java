package pub2504.oop;

public abstract class AbstractPrinter implements IPrinter, Cloneable {

	String sort; // 종류
	String company; // 제조사
	String name; // 이름
	int price; // 가격

	public AbstractPrinter() {
	}

	public AbstractPrinter(String sort, String company, String name, int price) {
		this.sort = sort;
		this.company = company;
		this.name = name;
		this.price = price;
	}

	// IPrinter 에 있는 turnOn을 구현했다.
	@Override
	public void turnOn() {
		System.out.println(name + " 프린터의 전원을 켜다!");
	}

	// IPrinter 에 있는 print 부분을 여기서는 구현을 하지 못해서 추상 메소드 상태로 남겨둔다.
	// 이런 추상적인 부분 때문에 abstract class 로 객체를 만들지 못한다.
	@Override
	public abstract void print();

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	// IPrinter 에 있는 turnOff을 구현했다.
	@Override
	public void turnOff() {
		System.out.println(name + " 프린터의 전원을 끄다!");
	}
} // class
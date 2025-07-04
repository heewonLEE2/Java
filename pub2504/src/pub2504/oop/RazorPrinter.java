package pub2504.oop;

// AbstractPrinter 에 있는 print(); 를 무조건 강제적으로 구현해야한다. 일반 클래스 이므로 추상적인게 남으면 안된다.
public class RazorPrinter extends AbstractPrinter implements Cloneable {

	public RazorPrinter(String sort, String company, String name, int price) {
		super(sort, company, name, price);
		this.sort = "레이져프린터";
	}

	@Override
	public void print() {
		System.out.println(sort + " 타입의" + name + " 프린터는 레이져를 이용해 출력하고 가격은 " + price + "원 입니다.");
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
} // class
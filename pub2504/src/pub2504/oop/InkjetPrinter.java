package pub2504.oop;

// AbstractPrinter 에 있는 print(); 를 무조건 강제적으로 구현해야한다. 일반 클래스 이므로 추상적인게 남으면 안된다.
public class InkjetPrinter extends AbstractPrinter implements Cloneable{

	public InkjetPrinter(String sort, String company, String name, int price){
		super(sort, company, name, price);
		this.sort = "잉크젯프린터";
	}
	
	@Override
	public void print() {
		System.out.println(
				sort + " 타입의" +
				name + " 프린터는 잉크를 이용해 출력하고 가격은 " +
				price + "원 입니다."
				);
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
} // class
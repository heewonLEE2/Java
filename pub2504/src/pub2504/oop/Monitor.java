package pub2504.oop;

// 모니터를 추상화
public class Monitor {

	private String name; // 제품명 
	private int price; // 가격
	private int inch; // 화면 크기

	public Monitor() {
	}

	public Monitor(String name, int price, int inch) {
		super();
		this.name = name;
		this.price = price;
		this.inch = inch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}
	
} // class

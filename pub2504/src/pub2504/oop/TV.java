package pub2504.oop;


// TV is a Product
public class TV extends Product{

	boolean hasDisplay; // 화면 보유 여부 
	
	TV(String company, String name, int price, boolean hasDisplay){
		super(company, name, price);
		this.hasDisplay = hasDisplay;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+ super.toString() + ", 디스플레이 : " + (hasDisplay ? "있음":"없음")  + "]";
	}
} // class

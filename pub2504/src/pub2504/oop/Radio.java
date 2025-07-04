package pub2504.oop;

// Radio is a Product
public class Radio extends Product{

	boolean hasAntena; // 안테나 보유 여부
	
	
	Radio(String company, String name, int price, boolean hasAntena){
		super(company, name, price);
		this.hasAntena = hasAntena;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName()  + super.toString() + ", 디스플레이 : " + (hasAntena ? "있음":"없음")  + "]";
	}
	
} // class

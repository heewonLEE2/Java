package pub2504.oop;

// 제품 추상화
public class Product {
	
	String company; // 제조회사명
	String name; //제품명
	int price; // 가격
	
	Product(String company, String name, int price){
		this.company = company;
		this.name= name;
		this.price= price;
	}
	
	@Override
	public String toString() {
		return "[회사명: " + this.company +
				  ", 제품명: " + this.name +
				  ", 가격: " + this.price
				;
	}
	
} // class

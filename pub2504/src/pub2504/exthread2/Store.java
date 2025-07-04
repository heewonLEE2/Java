package pub2504.exthread2;

public class Store {

	private String[] food = {"스파게티", "피자", "치킨", "떡볶이"};
	
	public Store() {
	}
	public Store(String[] food) {
		this.food = food;
	}
	public String[] getFood() {
		return food;
	}
	public void setFood(String[] food) {
		this.food = food;
	}
	
	
}

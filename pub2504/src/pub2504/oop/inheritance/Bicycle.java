package pub2504.oop.inheritance;

public class Bicycle extends Vehicle {
	
	private boolean hasChain; // 자전거 체인 여부
	
	Bicycle(String name, boolean hasEngine, boolean hasChain){
		super(name,hasEngine);
		this.hasChain = hasChain;
	}
	
	@Override
	String getInfo() {
		return 	"자전거 이름: " + name + 
					", 자전거 엔진보유 여부: " + hasEngine +
					", 자전거 체인보유 여부: " + hasChain
					;
	}
	
	@Override
	public String toString() {
		return "자전거";
	}
	
} // class

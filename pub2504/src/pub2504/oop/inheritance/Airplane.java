package pub2504.oop.inheritance;

public class Airplane extends Vehicle{

	private boolean hasWing; // 날개 보유 여부
	
	Airplane(String name, boolean hasEngine, boolean hasWing){
		super(name, hasEngine);
		this.hasWing = hasWing;
	};
	
	@Override
	String getInfo() {
		return   "비행기 이름: " + name +
					", 자동차 엔진보유 여부: " + hasEngine +
					", 날개 보유 여부: " + hasWing
					;
	}
	
	@Override
	public String toString() {
		return "비행기";
	}
	
} // class

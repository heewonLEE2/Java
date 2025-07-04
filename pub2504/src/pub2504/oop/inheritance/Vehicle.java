package pub2504.oop.inheritance;

public class Vehicle {

	String name; // 탈 것의 이름
	boolean hasEngine; // 탈 것의 엔진 보유 여부
	
	Vehicle(String name, boolean hasEngine){
		this.name = name;
		this.hasEngine = hasEngine;
	}
	
	String getInfo() {
		return "탈것 이름: " + name + ", 탈것 엔진보유 여부: " + hasEngine;
	}
	
	@Override
	public String toString() {
		return "탈 것";
	}
	
} // class

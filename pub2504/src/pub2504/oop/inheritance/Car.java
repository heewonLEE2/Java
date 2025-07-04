package pub2504.oop.inheritance;

public class Car extends Vehicle{

	private int tireCount; // 자동차 타이어의 개수
	
	Car(String name, boolean hasEngine, int tireCount){
		super(name,hasEngine);
		this.tireCount = tireCount;
	}
	
	// @Override Annotation(어노테이션)
	// 오버라이딩한 메소드인지를 컴파일 단계에서 체크하기 위한 어노테이션
	// => 개발자의 실수 방지용
	@Override
	String getInfo() {
		return   "자동차 이름: " + name +
					", 자동차 엔진보유 여부: " + hasEngine +
					", 자동차 바퀴수: " + tireCount
					;
	}
	
	@Override
	public String toString() {
		return "자동차";
	}
	
} // class

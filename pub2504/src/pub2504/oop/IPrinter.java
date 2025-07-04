package pub2504.oop;

// 역할 : 프린터라면 공통적으로 가지고 있는 기능들에 대한 설계
public interface IPrinter {

	// 프린터 켜기 (한줄 한줄이 메소드 시그니쳐, 메소드 프로토타입)
	public abstract void turnOn();
	
	// 출력
	public abstract void print();
	
	// 프린터 끄기
	public abstract void turnOff();
} 
package pub2504.dp;

// Print 인터페이스를 구현해서 인터페이스 내의 모든 추상메소드를
// 오버라이딩해야 객체를 생성할 수 있는 강제성을 부여 받음

// PrintAdaptor 라는 Print 인터페이스를 기본 구현 해 놓은 추상 클래스를
// 상속 받는다면 필요한 메소드만 오버라이딩 할 수 있게 됨

// => 어덥터 패턴의 예

public class ConcretePrint extends PrintAdaptor{

	@Override
	public void print() {
		System.out.println("print만 오버라이딩함!");
	}
	
}
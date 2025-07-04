package pub2504.oop;

public class PhoneFactoryMain {

	// PhoneFactory 를 통해서 전화를 생산하세요!
	
	public static void main(String[] args) {
		
		// PhoneFactory 인터페이스 타입의 객체를
		// 익명 innerClass 를 통해서 생성할 수 있다.
		// 이때 생성된 익명 innerClass는 PhoneFactory 인터페이스 타입니다.!
		// phone 변수의 타입은 PhoneFactory
		// phone 변수가 가지고 있는 참조는 생성된 PhoneFactory 타입 객체의 참조
		PhoneFactory phone = new PhoneFactory() {
			@Override
			public void makePhone() {
				System.out.println("폰 생성");
			}
		};
		phone.makePhone();
		
		
		
	} // main
} // class
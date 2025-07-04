package pub2504.oop;

public class OuterMain {

	public static void main(String[] args) {
		
		// Outer 객체 생성
		Outer outerObj = new Outer();
		outerObj.print();
		
		System.out.println();
		
		// static inner class 객체 생성
		Outer.SIClass outerSIClassObj = new Outer.SIClass();
		outerSIClassObj.print();
		
		System.out.println();
		
		// 실습 : non-static inner class 객체 생성 print 메소드 호출
		Outer outerObj2 = new Outer();
		// new 생성자 메소드여서 객체뒤에 . 로 메서드 호출 가능?
		Outer.NSIClass outerNSIClassObj = outerObj2.new NSIClass();
		
		outerNSIClassObj.print();
	} // main
} // class
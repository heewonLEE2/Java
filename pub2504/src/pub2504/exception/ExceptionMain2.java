package pub2504.exception;

public class ExceptionMain2 {

	public static void main(String[] args){
		
		System.out.println("main 메소드 호출됨!");
		
		// 5. main 메소드에서 try~catch로 처리
//		try {
//			a();
//		} catch(ArithmeticException ae) {
//			System.out.println("main 메소드에서 예외를 처리함!");
//		}
		// 6. main에서 예외처리를 하지 않음
		// JVM에 예외가 전달되고 예외처리가 되지않음
		// => main에서는 무조건 예외가 처리되어야 함
//		a();
	} // main
	
	private static void a() throws ArithmeticException{
		System.out.println("a메소드 호출됨!");
		
		// 3. a메소드에서 try ~ catch로 처리
//		try {
//			b();
//		} catch(ArithmeticException ae) {
//			System.out.println("a메소드에서 예외를 처리함!");
//		}
		// 4. a메소드를 호출한 main메소드에 예외처리를 위임(throws)
		b();
		
	} // a
	
	// b를 호출할 때 발생할 예외처리를 b를 호출한 메소드한테 예외처리를 던진다.
	private static void b() throws ArithmeticException{
		
		System.out.println("b메소드 호출됨!");
		
		// 1. b메소드에서   try~catch로 처리
//		try {
//			// ArithmeticException 발생
//			int i = 10/0;
//		} catch(ArithmeticException ae) {
//			System.out.println("b 메소드에서 예외를 처리함!");
//		}
		// 2. b메소드를 호출한 a메소드에 예외처리를 위임(throws)
		int i = 10/0;
		
		System.out.println("예외처리 이후에 수행할 코드들...");
		
	} // b
} // class
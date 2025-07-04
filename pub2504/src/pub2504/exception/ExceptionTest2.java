package pub2504.exception;

import java.util.Scanner;

public class ExceptionTest2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		// 1번 사용할 떄는 변수는 만들지 말자
		try {
			System.out.println(scanner.nextInt() / scanner.nextInt());
		} catch(ArithmeticException ae) {
			ae.printStackTrace();
		}finally {
			scanner.close();
		}
	} // main
} // class

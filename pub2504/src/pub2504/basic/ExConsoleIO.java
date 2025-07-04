package pub2504.basic;

import java.util.Scanner;

public class ExConsoleIO {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String str1 = scanner.next();
		String str2 = scanner.next();
		String str3 = scanner.next();

		int boolNum = 0;
		// 문자열 비교는 String.eaquals() 메소드 (String 은 참조 타입이여서)
		// 기본타입값 같은지 비교 ==
		if (str1.equals("true")||str1.equals("false")) boolNum ++; 
		if (str2.equals("true")||str2.equals("false")) boolNum ++; 
		if (str3.equals("true")||str3.equals("false")) boolNum ++; 

		System.out.println("입력하신 데이터의 불리언 갯수는 : " + boolNum);

		scanner.close();
	}
}
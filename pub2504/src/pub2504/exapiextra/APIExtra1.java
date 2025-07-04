package pub2504.exapiextra;

import java.util.Scanner;

public class APIExtra1 {

	//APIExtra1.java : 문자열을 한 줄 입력받아서 문자열의 길이를 출력
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("문자열을 입력하세요");
		String strArr = scanner.next();  
		System.out.println("입력하신 문자열 길이는 : " + strArr.length());
		
		scanner.close();
	} //main
	
} // class

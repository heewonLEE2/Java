package pub2504.exapiextra;

import java.util.Scanner;

public class APIExtra3 {
	
		// APIExtra3.java : 문자 5개를 입력하면 3번째 입력한 문자의 아스키코드값을 출력
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("문자 5개를 입력하세요");
		// 입력받은 문자열 저장
		String str = scanner.next();
		// 문자열 길이
		int strLeng = str.length();
		// char 배열을 만들어서 문자열 하나하나 저장
		char[] charArr = new char[strLeng];
		// 배열에 추가
		for(int i =0; i<strLeng; i++) {
			charArr[i] = str.charAt(i);
		}
		// 인덱스 2번째 문자열 byte로 변환
		System.out.println("3번째 입력한 문자의 아스키코드 값은 : "+(byte)charArr[2]);
		
		
		scanner.close();
	} // main
} // class

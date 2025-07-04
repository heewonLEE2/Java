package pub2504.exapiextra;

import java.util.Scanner;

public class APIExtra7 {

	// APIExtra7.java : 영문 대소문자를 포함한 문자열을 입력하면 대문자는 소문자로 소문자로 대문자로
	// 변환하여 출력
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("영문 대소문자를 포함한 문자열을 입력하세요");
		String str = scanner.next();
		int strLeng = str.length();
		// 입력한 문자를 byte로 변환해서 배열 저장
		byte[] byteArr_1 = new byte[strLeng];
		// 입력한 문자들 대소문자 바꾸고 저장할 배열
		
		// 아스키코드 기준 97 이상이면 소문자, 대소문자 차이는 32이기 때문에 32를 빼고 더해서 저장
		for(int i=0; i<strLeng; i++) {
			if((byte)str.charAt(i)>=97) {
				byteArr_1[i] =  (byte) ((byte)str.charAt(i) - 32);
			}else{
				byteArr_1[i] =  (byte) ((byte)str.charAt(i) + 32);
			}
		}
		
		// byteArr_1 배열을 순환해 char타입으로 변경 후 출력
		for(byte bt : byteArr_1) {
			System.out.print((char)bt);
		}

		scanner.close();
	} // main
} // class








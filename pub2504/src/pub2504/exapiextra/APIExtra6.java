package pub2504.exapiextra;

import java.util.Scanner;

public class APIExtra6 {

	//APIExtra6.java : 문자 10개를 공백과 함께 입력하면 모두 합쳐진 문자열을 출력 (StringBuilder 사용)
	public static void main(String[] args) {
		
		String line = Util.getLineText(1)[0];
		
		char[] chArr = line.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		
		for(char ch : chArr) {
			if(ch !=' ') {
				sb.append(ch);
			}
		}
		
		System.out.println(sb);
		
	} // main
} // class

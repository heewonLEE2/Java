package pub2504.exapiextra;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class APIExtra5 {

	
	//APIExtra5.java : 문자열을 두 줄 입력하고 첫번째 문자열내에 두번째 문자열이 몇 개 존재하는지 출력
	public static void main(String[] args) {
			
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("첫번째 줄을 입력하세요");
		String str1 = scanner.next();
		System.out.println("두번째 줄을 입력하세요");
		String str2 = scanner.next();
		
		// 문자열이 몇 개 존재하는지 합계와 인덱스 지정
		int sum = 0;
		int index = -1;
		
		// 포함 하면 sum을 올리자
		while((index=str1.indexOf(str2,index)+1)>0) {
			sum++;
		}

		System.out.println(sum);
		
		scanner.close();
	} // main
} // class

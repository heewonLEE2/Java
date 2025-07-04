package pub2504.exapiextra;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class APIExtra4 {

	// APIExtra4.java : 문자열을 두 줄 입력하고 첫번째 문자열내에 두번째 문자열이 존재하는지 출력
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("처음 줄을 입력하세요");
		String str1 = scanner.next();
		
		System.out.println("두번째 줄을 입력하세요");
		String str2 = scanner.next();
		
		Pattern str2_p = Pattern.compile(str2+"+");
		Matcher str2_m = str2_p.matcher(str1);
		if(str2_m.find()) {
			System.out.println("두번째 줄의 문자열이 첫번째 문자열에 포함이 되네요!");
		}else {
			System.out.println("포함되어 있지 않습니다.!!!!!");
		}
		
		
		scanner.close();
	} // main
} // class

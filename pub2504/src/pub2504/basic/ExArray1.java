package pub2504.basic;

import java.util.Scanner;

public class ExArray1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String[] strArr = new String[5];
		
		int strArrLeng =strArr.length;
		
		for(int i =0; i < strArrLeng; i++) {
			strArr[i] = scanner.next();
		}
		
		for(String str : strArr) {
			System.out.println(str);
		}
		scanner.close();
	} // main
} // class

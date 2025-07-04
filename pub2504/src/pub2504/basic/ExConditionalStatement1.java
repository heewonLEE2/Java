package pub2504.basic;

import java.util.Scanner;

public class ExConditionalStatement1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("첫번째 숫자를 입력하세요");
		int num1 = scanner.nextInt();
		System.out.println("두번째 숫자를 입력하세요");
		int num2 = scanner.nextInt();
		
		// if 문
		if ((num1 + num2) > 10) {
			System.out.println("10보다 큽니다.");
		} else {
			System.out.println("10보다 크지 않습니다.");
		}

		scanner.close();

	} // main
} // class

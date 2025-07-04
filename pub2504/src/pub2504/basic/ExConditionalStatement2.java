package pub2504.basic;

import java.util.Scanner;

public class ExConditionalStatement2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("1~100까지의 숫자를 입력하세요");
		int num = scanner.nextInt();

		if (num > 100) {
			System.out.println("!!!!!!!!!!!!!1~100까지의 숫자를 입력해주세요!!!!!!!!!!!!!!");
			return;
		} else if (num >= 91) {
			System.out.println("당신의 학점은 A 입니다.");
		} else if (num >= 81) {
			System.out.println("당신의 학점은 B 입니다.");
		} else if (num >= 71) {
			System.out.println("당신의 학점은 C 입니다.");
		} else if (num >= 61) {
			System.out.println("당신의 학점은 D 입니다.");
		} else
			System.out.println("당신의 학점은 F 입니다.");

	} // main
}// class

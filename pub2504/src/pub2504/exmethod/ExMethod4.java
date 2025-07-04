package pub2504.exmethod;

import java.util.Scanner;

public class ExMethod4 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("별의 갯수를 입력하세요");
		starMake(scanner.nextInt());

		scanner.close();
	} // main

	static void starMake(int num) {

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	} // starMake

} // class

package pub2504.exthread2;

import java.util.Scanner;

public class ExThread3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("text를 입력하세요!");
		String str = scanner.nextLine();
		scanner.close();
		
		new LogThread(str).start();
		
		
	} // main
} // class














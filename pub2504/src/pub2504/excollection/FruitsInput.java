package pub2504.excollection;

import java.util.Scanner;

public class FruitsInput {
	
	public static String input() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("과일 이름을 입력하세요");
		
		String fruit = scanner.nextLine();
		
		scanner.close();
		
		return fruit;
	}
	
} // class

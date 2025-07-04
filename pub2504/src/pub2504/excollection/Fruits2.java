package pub2504.excollection;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Fruits2 {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("과일 5개를 입력하세요");
		Set<String> fruitSet = new HashSet<String>();
		
		
		while(fruitSet.size() < 5) {
			fruitSet.add(scanner.next());
		}
		
		for(String set : fruitSet) {
			System.out.println(set);
		}
		
		scanner.close();
	} // main
} // class

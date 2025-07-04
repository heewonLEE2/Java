package pub2504.excollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fruits1 {

	public static void main(String[] args) {

		List<String> strList = new ArrayList<String>();
		System.out.println("과일 이름을 5개입력하세요");
		Scanner scanner = new Scanner(System.in);
		
		while(strList.size() < 5) {
			strList.add(scanner.next());
		}
		
		scanner.close();
		
		for(String str : strList) {
			System.out.println(str);
		}
		
//		System.out.println(FruitsInput.input());
		
	} // main
} // class

package pub2504.exmethod;

import java.util.Scanner;

public class ExMethod3 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수 2개를 입력한뒤, + = * / 4개중 하나를 입력해 계산 하세요");
		System.out.println(calc(scanner.nextInt(),scanner.nextInt(),scanner.next()));
		
		scanner.close();
	} // main
	
	static int calc(int num1, int num2, String str) {
		
		int sum = 0;
		
		// switch case 문으로 생각해 보기 , 기능별로 나누기
		if(str.equals("+")) {
			sum = num1+num2;
		}else if(str.equals("*")) {
			sum = num1*num2;
		}else if(str.equals("-")) {
			sum = num1-num2;
		}else if(str.equals("/")) {
			sum = num1/num2;
		}
		return sum;
	} // calc
	
} // class
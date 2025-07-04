package pub2504.exmethod;

public class ExMethod1 {

	public static void main(String[] args) {
		
		printNum(10,30);
		printNum(30,10);
		printNum(5,6);
		printNum(2,30);
		
	} // main
	
	private static void printNum(int num1, int num2) {
		if(num1 > num2) System.out.println("앞에 입력한 "+ num1 + " 이 큽니다.");
		else if(num2 > num1)System.out.println("뒤에 입력한 " + num2 + " 이 더 큽니다.");
		else System.out.println("같은 수 입니다.");
	}
	
	
} // class

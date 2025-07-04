package pub2504.api;

public class MathTest {

	public static void main(String[] args) {
		System.out.println(Math.abs(-10)); // 절대값
		System.out.println(Math.floor(3.14)); // 주어진 수보다 작지만 가장 큰 실수
		System.out.println(Math.ceil(3.14)); // 주어진 수보다 크지만 가장 작은 실수
		System.out.println(Math.max(10, 5));  // 최대값
		System.out.println(Math.min(10, 5)); // 최소값
		System.out.println(Math.pow(2, 5)); // 2^5
		System.out.println(Math.random()); // 0.0보다 크거나 같고 1.0보다 작은 임의의 실수
		
		// 실습
		// 1~45 사이의 임의의 정수
		System.out.println((int)(Math.random()*45)+1);
		
		// 100부터 500 사이의 임의의 3의 배수
		int randomNum = (int)(Math.random()*500)+1;
		if(randomNum%3 ==0 && randomNum > 100) System.out.println(randomNum);
		else System.out.println("꽝");
		
		int min = 102;
		int max = 498;
		int count = (max - min) /3 +1;
		int randomIndex = (int)(Math.random()*count);
		System.out.println(min + randomIndex *3);
		
		
	} // main
} // class
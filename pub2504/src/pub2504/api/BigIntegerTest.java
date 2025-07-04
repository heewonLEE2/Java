package pub2504.api;

import java.math.BigInteger;

/*
	BigInteger : long보다 큰 범위의 정수를 다룰 때
	BigDecimal : double보다 큰 범위의 실수를 다룰 때 
  
*/

public class BigIntegerTest {

	public static void main(String[] args) {

		BigInteger bi1 = new BigInteger("984984984984984811119889453511298489");
		BigInteger bi2 = new BigInteger("984984984984984811119889453511298489");

		System.out.println(bi1.add(bi2)); // 덧셈
		System.out.println(bi1.subtract(bi2)); // 뺼셈
		System.out.println(bi1.multiply(bi2)); // 곱섭
		System.out.println(bi1.divide(bi2)); // 나눗셈
		System.out.println(bi1.remainder(bi2)); // 나머지
	} // main
} // class
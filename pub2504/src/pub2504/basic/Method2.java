package pub2504.basic;

public class Method2 {

	public static void main(String[] args) {

		// not-static method 는 클래스로 접근 불가
		// Method2.print("Java")
		// Method2.add(3,5)

		Method2 method2 = new Method2();
		method2.print("Java");
		System.out.println(method2.add(3, 5));
	} // main

	void print(String str) {
		System.out.println(str);
	}

	int add(int a, int b) {
		return a + b;
	}
} // class

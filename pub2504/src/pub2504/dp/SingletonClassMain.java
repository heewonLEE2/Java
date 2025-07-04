package pub2504.dp;

public class SingletonClassMain {

	public static void main(String[] args) {
		
		// 싱글턴 객체 생성
		// 같은 객체, 객체가 1개만 생성된다.
		SingletonClass obj1 = SingletonClass.getInstance();
		System.out.println(obj1.hashCode()); // 617901222
		
		SingletonClass obj2 = SingletonClass.getInstance();
		System.out.println(obj2.hashCode()); // 617901222
		
	} // main
} // class
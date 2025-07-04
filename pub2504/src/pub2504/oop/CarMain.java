package pub2504.oop;

// class 폴더 뒤에 main을 붙혀서 실행 클래스라는 걸 말한다.
public class CarMain {

	public static void main(String[] args) {
		
		// Car 타입 객체 생성
		// 1. Car 타입 객체가 메모리에 생성됨
		// 2. 생성된 객체의 메모리 주소(address)를 해시 알고리즘을 사용해 참조로 변환
		// 3. 변환된 참조값을 bmw라는 객체참조변수에 저장
		Car bmw = new Car();
		
		// pub2504.oop.Car@24d46ca6
		// 타입@16진수로 변환한 참조값 (4바이트)
		// bmw뒤에 .toString() 생략된 것
		// Car 클래스에는 toString 메소드가 없음 => Object 클래스의 toString을 사용 
		System.out.println(bmw);
		// Object 클래스의 hashCode를 사용해서 객체의 참조값을 출력 (10진수)
		System.out.println(bmw.hashCode());
		
		Car bentz = new Car();
		// pub2504.oop.Car@4517d9a3 // bmw, bentz 2개는 다른 객체
		System.out.println(bentz);
		System.out.println(bentz.hashCode());

		// Object 클래스의 equals를 사용해서 두개의 참조값 비교
		System.out.println(bmw.equals(bentz)); // false
		
		// 객체의 멤버변수에 값 할당
		// static
		bmw.carCount = 1;
		// non-static
		bmw.company = "BMW KOREA";
		bmw.model = "520D";
		bmw.name = "BMW";
		bmw.price = 1000;
		
		// static
		bentz.carCount = 2;
		// non-static
		bentz.company = "BENTZ KOREA";
		bentz.model = "AMG";
		bentz.name = "BENTZ";
		bentz.price = 2000;
		
		Car.carCount = 3;
		
		// static 변수의 값은 모든 객체가 공유
		System.out.println(bmw.carCount); // 3 클래스에서, 객체에서 접근해 값을 바꿀수 있다.
		System.out.println(bentz.carCount); // 3
		
		// non-static 변수의 값은 객체마다 저장
		bmw.price = 1500;
		bentz.price = 2500;
		System.out.println(bmw.price); // 1500
		System.out.println(bentz.price); // 2500
		
		// static메소드는 클래스로도 객체로도 접근 가능
		System.out.println(Car.getCarCount());
		System.out.println(bmw.getCarCount());
		System.out.println(bentz.getCarCount());
		
		 // non-static 메소드는 객체로만 접근 가능
		// System.out.println(Car.getPrice());
		 System.out.println(bmw.getPrice()); // 1500
		 System.out.println(bentz.getPrice()); // 2500
		
	} // main
} // class
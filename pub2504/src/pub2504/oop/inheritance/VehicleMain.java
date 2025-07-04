package pub2504.oop.inheritance;

public class VehicleMain {

	public static void main(String[] args) {
		
		// v1변수는 Vehicle 타입, 가지고 있는 참조는 Vehicle 타입 
		Vehicle v1 = new Vehicle("탈것", false);
		System.out.println(v1); // Vehicle toString() 호출됨
		System.out.println(v1.getInfo()); // Vehicle getInfo() 호출됨
		
		// v2변수는 Vehicle 타입, 가지고 있는 참조는 Car 타입
		Vehicle v2 = new Car("BMW", true, 4);
		System.out.println(v2); // Car toString() 호출됨
		System.out.println(v2.getInfo()); // Car getInfo() 호출됨
		
		// 실습
		// v3 변수는 Vehicle 타입, 가지고 있는 참조는 Bicycle 타입
		Vehicle v3 = new Bicycle("씽씽이", false, true);
		System.out.println(v3); // Bicycle toString() 호출됨
		System.out.println(v3.getInfo()); // Bicycle getInfo() 호출됨
		
		// 실습
		// Airplane 클래스를 생성하고  Vehicle 을  상속받아 toStirng 과 getInfo를
		// 오버라이딩한 후 Airplane 객체를 하나 생성해서 toString 과 getInfo 를 호출/출력
		Vehicle v4 = new Airplane("뱅기", true, true);
		System.out.println(v4); // Airplane toString() 호출됨
		System.out.println(v4.getInfo()); // Airplane getInfo() 호출됨
		
		// 실습
		// Bentz1 ~ Bentz1000 까지 1000개의 Car 를 생성
		// 씽씽이1 ~ 씽씽이1000 까지 1000개의 Bicycle 객체를 생성
		// 잘나러1 ~ 잘날어1000까지 1000개의 Airplane 객체를 생성
		// 3000개의 정보를 출력
		
		// 덜 좋은 코드
//		int count = 1000;
//		Car[] cArr = new Car[1000];
//		Bicycle[] bArr = new Bicycle[1000];
//		Airplane[] aArr = new Airplane[1000];
//		
//		for(int i =0; i<count; i++) {
//			cArr[i] = new Car("Bentz"+(i+1), true, 4);
//			bArr[i] = new Bicycle("씽씽이"+(i+1), false, true);
//			aArr[i] = new Airplane("잘날어"+(i+1), true, true);
//			System.out.println(cArr[i].getInfo());
//			System.out.println(bArr[i].getInfo());
//			System.out.println(aArr[i].getInfo());
//		}
		
		// 좀 더 좋은 코드
		int count = 3000;

		// 같은 타입(상위 타입) 으로 묶을 수 있다.
		Vehicle[] vArr = new Vehicle[count];
		
		for(int i =0; i<count; i=i+3) {
			vArr[i] = new Car("Bentz"+(i/3+1), true, 4);
			vArr[i+1] = new Bicycle("씽씽이"+(i/3+1), false, true);
			vArr[i+2] = new Airplane("잘날어"+(i/3+1), true, true);
		}
		
		for(Vehicle v : vArr) {
			// Car.getInfo(), Bicycle.getInfo(), Airplane.getInfo() 이렇게 호출 하지않고
			// 상위 타입인  Vehicle.getInfo()로 호출을 하여도 각각의 참조 타입이 가지고 있는
			// getInfo()를 호출 한다.
			System.out.println(v.getInfo());
		}
		
	} // main
} // class












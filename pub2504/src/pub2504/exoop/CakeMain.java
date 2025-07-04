package pub2504.exoop;

public class CakeMain {

	public static void main(String[] args) {
		makeAndPrint("모카");
		makeAndPrint("초코");
		makeAndPrint("바나나");
	} // main
	
	private static void makeAndPrint(String cakeName) {
		ICake cake = new ICake() {
			@Override
			public void makeCake() {
				System.out.println(cakeName + " 케이크가 만들어 졌습니다.");
			}
		};
		cake.makeCake();
	} // makeAndPrint()
	
} // class

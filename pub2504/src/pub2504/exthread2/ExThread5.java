package pub2504.exthread2;

public class ExThread5 {
	
	// flag 변수를 활용해 조리중에는 배달 불가하게 만들기
	boolean flag = true;
	// {"스파게티", "피자", "치킨", "떡볶이"} 중에 랜덤으로 음식 만들기 위한 변수
	int ranNum;
	// 주문 번호 10번까지 위한 변수
	int orderNum = 1;
	
	public static void main(String[] args) {
		
		Store store = new Store();
		ExThread5 et5 = new ExThread5();
		
		
		new ChefThread(store.getFood(),et5).start();
		new DeliveryThread(store.getFood(),et5).start();
		
	} // main
} // class

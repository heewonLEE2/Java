package pub2504.exthread2;

public class ChefThread extends Thread {

	private String[] store;
	private ExThread5 et5;

	public ChefThread() {
	}

	public ChefThread(String[] store, ExThread5 et5) {
		this.store = store;
		this.et5 = et5;
	}

	@Override
	public void run() {
		
		while (true) {
			
			synchronized (et5) {
				// 배달 중이면 대기
				while (!et5.flag) { 
					try {
						et5.wait();
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
				}
				// 랜덤으로 음식 조리
				int ranNum = (int) (Math.random() * 4);
				et5.ranNum = ranNum;
				System.out.println("[주문번호 : " + et5.orderNum + "번]" + store[et5.ranNum] + "를(을) 조리 중입니다.");
				
				// 3초후 조리 완료
				try {
					Thread.sleep(3000);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
				System.out.println("[주문번호 : " + et5.orderNum + "번]" + store[et5.ranNum] + "가(이) 만들어 졌습니다.");
				System.out.println();
				 // 배달 가능
				et5.flag = false;
				et5.notifyAll();
			} // sync
			
		} // while
	} // run

} // class

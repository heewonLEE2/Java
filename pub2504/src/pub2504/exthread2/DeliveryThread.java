package pub2504.exthread2;

public class DeliveryThread extends Thread {

	private String[] store;
	private ExThread5 et5;

	public DeliveryThread() {
	}

	public DeliveryThread(String[] store, ExThread5 et5) {
		this.store = store;
		this.et5 = et5;
	}

	@Override
	public void run() {
		
		while (true) {
			
			synchronized (et5) {
				// 조리 중이면 대기
				while (et5.flag) { 
					try {
						et5.wait();
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
				}
				// 떡볶이는 배달 불가
				if(et5.ranNum == 3) {
					
					System.out.println("떡볶이는 배달할 수 없습니다.!");
					System.out.println();
					et5.orderNum++;
					
					// 조리 가능
					et5.flag = true;
					et5.notifyAll();
				}else {
					// 배달중 2초 대기
					System.out.println("[주문번호 : " + et5.orderNum + "번]" + store[et5.ranNum] + "를(을) 배달중 입니다.");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
					// 배달 완료 후 orderNum 을 올린다.
					System.out.println("[주문번호 : " + et5.orderNum + "번]" + store[et5.ranNum] + "가(이) 배달 완료 되었습니다.!");
					System.out.println();
					et5.orderNum++;
					
					// 배달 10건 완료후 시스템 종료
					if (et5.orderNum == 11) {
						System.out.println("10건의 주문을 완료 했습니다.");
						System.exit(0);
					}
					// 조리 가능
					et5.flag = true;
					et5.notifyAll();
					
				} // else
			} // sync
		} // while
	} // run

} // class

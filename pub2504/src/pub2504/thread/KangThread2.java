package pub2504.thread;

public class KangThread2 extends Thread {

	private Account2 kangAccount2;

	public KangThread2(Account2 account2) {
		this.kangAccount2 = account2;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			// 동기화 블럭 : KangThread2 가 Accoun2 객체를 사용중일 때는
			// HongThread2 가 Accoun2 객체를 사용하지 못하도록 동기화
			synchronized (kangAccount2) {
				kangAccount2.setMoney(kangAccount2.getMoney() + 500);
			}

//			// 동기화 메소드 사용(모든 객체가 동기화가 되기 때문에 동기화 블럭이 자주 사용됨)
//			kangAccount2.deposit();

			System.out.println("강감찬의 계좌에서 500월 입금!");
			System.out.println(kangAccount2 + "\n");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	} // run

} // class

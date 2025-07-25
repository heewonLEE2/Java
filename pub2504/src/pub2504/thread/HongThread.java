package pub2504.thread;

public class HongThread extends Thread {

	private Account hongAccount;

	public HongThread() {
		this.hongAccount = new Account("홍길동 계좌", 10000);
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			hongAccount.setMoney(hongAccount.getMoney() - 1000);
			System.out.println("홍길동의 계좌에서 1000원 출금!");
			System.out.println(hongAccount + "\n");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

		} // for
	} // run
} // class

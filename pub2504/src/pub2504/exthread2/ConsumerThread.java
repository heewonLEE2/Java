package pub2504.exthread2;

public class ConsumerThread extends Thread {

	private TVFactory tvfactory;

	public ConsumerThread() {
	}

	public ConsumerThread(TVFactory tvfactory) {
		this.tvfactory = tvfactory;
	}

	@Override
	public void run() {

		if (tvfactory.getNum() == 0) {
			try {
				wait(); // 제품이 생산할 때 까지 대기
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		} else {
			while(tvfactory.getNum() != 0) {
				int ranNum = (int) (Math.random() * 6) + 3;
				
				synchronized (tvfactory) {
					tvfactory.setNum(tvfactory.getNum() - ranNum);
				}
				System.out.println("판매한 티비의 수는 : " + ranNum);
				System.out.println("현재 남은 티비의 수는 : " + tvfactory.getNum());
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		}
		

	} // run

} // class

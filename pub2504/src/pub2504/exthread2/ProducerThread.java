package pub2504.exthread2;

public class ProducerThread extends Thread {

	private TVFactory tvfactory;

	public ProducerThread() {
	}

	public ProducerThread(TVFactory tvfactory) {
		this.tvfactory = tvfactory;
	}

	@Override
	public void run() {
			while (tvfactory.getNum() < 1000) {
				
				int ranNum = (int) (Math.random() * 6) + 5;
				
				synchronized (tvfactory) {
					tvfactory.setNum(tvfactory.getNum() + ranNum);
				}
				System.out.println("생산한 티비의 수는" + ranNum);
				System.out.println("현재 남은 티비의 수는 : " + tvfactory.getNum());
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}

		
	} // run()

} // class

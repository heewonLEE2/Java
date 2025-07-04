package pub2504.exthread2;

public class LowerThread extends Thread {

	ExThread2 ex2;
	
	public LowerThread(ExThread2 ex2) {
		this.ex2 = ex2;
	}
	
	@Override
	public void run() {
		
		int lowerNum = 97;
		
		while (true) {
			
			if(ex2.flag == false) {
				for (int i = lowerNum; i < 123; i++) {
					System.out.println((char) lowerNum);
					lowerNum += 1;
					ex2.flag = true;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
					
				} // for
			}
		} // while
	} // run()
} // class

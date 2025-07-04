package pub2504.exthread2;

public class UpperThread extends Thread {

	ExThread2 ex2;

	public UpperThread(ExThread2 ex2) {
		this.ex2 = ex2;
	}
	@Override
	public void run() {
		
		int upperNum = 65;
		
		while (true) {
			
			if(ex2.flag == true) {
				
				for (int i = upperNum; i < 91; i++) {
					System.out.println((char) upperNum);
					upperNum += 1;
					
					ex2.flag = false;
					
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

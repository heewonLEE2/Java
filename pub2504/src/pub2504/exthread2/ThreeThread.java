package pub2504.exthread2;

public class ThreeThread extends Thread{

	
	@Override
	public void run() {
		int num = 3;
		
		while(true){
			System.out.println("3의 배수 입니다." + num);
			num += 3;
			try {
				sleep(100);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		} // while
	} // run()
} // class

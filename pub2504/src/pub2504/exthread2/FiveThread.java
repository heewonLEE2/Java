package pub2504.exthread2;

public class FiveThread extends Thread{

	@Override
	public void run() {
		int num = 5;
		
		while(true){
			System.out.println("5의 배수 입니다." + num);
			num += 5;
			try {
				sleep(100);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		} // while
	} // run()
}

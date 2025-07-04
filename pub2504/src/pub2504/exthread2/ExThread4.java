package pub2504.exthread2;

public class ExThread4 {

	public static void main(String[] args) {
		
		TVFactory tvFactory = new TVFactory("삼송티비", 100);
		
		new ProducerThread(tvFactory).start();
		new ConsumerThread(tvFactory).start();
		
		
	} // main
} // class

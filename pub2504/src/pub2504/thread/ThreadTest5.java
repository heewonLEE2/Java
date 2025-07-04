package pub2504.thread;

public class ThreadTest5 {

	public static void main(String[] args) {

		Product product = new Product();

		// 생산자(producer) Thread : 제품을 3개 생산
		Thread producer = new Thread(() -> {
			for (int i = 1; i <= 3; i++) {
				product.produce("제품" + i);
			}
		}); // producer

		// 소비자(consumer) Thread : 제품을 3개 소비하는
		Thread consumer = new Thread(() -> {
			for (int i = 1; i <= 3; i++) {
				product.consume();
			}
		}); // consumer

		producer.start();
		consumer.start();

	} // main
} // class

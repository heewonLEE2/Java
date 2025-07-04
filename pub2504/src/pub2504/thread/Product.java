package pub2504.thread;

// 제품
public class Product {

	// 제품명
	private String product;

	// 제품을 생산하는 메소드
	public synchronized void produce(String product) {
		while (this.product != null) {
			try {
				wait(); // 제품이 소비될 때 까지 대기
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		} // while
		this.product = product;
		System.out.println("제품 생산 : " + product);
		notify(); // 제품을 소비하라고 알림

	} // produce()

	// 제품을 소비하는 메소드
	public synchronized String consume() {
		while (this.product == null) {
			try {
				wait(); // 제품이 생산할 때 까지 대기
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		} // while
		String result = this.product;
		this.product = null;
		System.out.println("제품 소비 : " + result);
		notify(); // 제품을 생산하고 알림
		return result;

	} // consume()

} // class
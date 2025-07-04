package pub2504.thread;

public class ThreadTest6 {

	public static void main(String[] args) {

		Thread wt1 = new WorkerThread("작업1", 2000);
		Thread wt2 = new WorkerThread("작업2", 3000);
		Thread wt3 = new WorkerThread("작업3", 1000);

		wt1.start();
		wt2.start();
		wt3.start();

		try {
			wt1.join(); // wt1 Thread 의 작업이 종료될 때 까지 main Thread 가 기다린다.
			wt2.join(); // wt2 Thread 의 작업이 종료될 때 까지 main Thread 가 기다린다.
			wt3.join(); // wt3 Thread 의 작업이 종료될 때 까지 main Thread 가 기다린다.
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

		// 위에 join() 문이 없으면 main 은 제일 먼저 종료된다.
		// join() 은 다른 Thread 작업이 끝날때 까지 기다렸다가 바로 실행.
		System.out.println("main thread 종료됨! (=main 메소드 종료됨)");

	} // main
} // class

package pub2504.thread;

public class NumberPrintThread extends Thread {

	@Override
	public void run() {

		for (int i = 1; i < 6; i++) {

			System.out.println(i);

			System.out.println("현재 쓰레드그룹에서 활동중인 쓰레드의 개수 : " + Thread.activeCount()); // 2 main 포함
			System.out.println("현재 실행중인 쓰레드 : " + Thread.currentThread()); // Thread[Thread-0,5,main]
			System.out.println("현재 쓰레드 아이디 : " + this.getId()); // 15
			System.out.println("현재 쓰레드 이름 : " + this.getName()); // Thread-0
			System.out.println("현재 쓰레드 우선순위 : " + this.getPriority()); // 5
			System.out.println("현재 쓰레드 상태 : " + this.getState()); // RUNNABLE
			System.out.println("현재 쓰레드 그룹명 : " + this.getThreadGroup().getName()); // main
			System.out.println("현재 쓰레드가 활동중인지 : " + this.isAlive()); // true
			System.out.println("현재 쓰레드가 데몬쓰레드인지 : " + this.isDaemon()); // false
			System.out.println("현재 쓰레드가 인터럽트 되었는지 : " + this.isInterrupted()); // false

			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

		}
	}

}

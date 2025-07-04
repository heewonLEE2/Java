package pub2504.exthread2;

public class ExThread2 {

	boolean flag =true;
	
	public static void main(String[] args) {
		
		ExThread2 et2 = new ExThread2(); 
		new UpperThread(et2).start();
		new LowerThread(et2).start();
		
	}
}

package pub2504.basic;

public class ExLoopStatement1 {

	public static void main(String[] args) {

		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d단 입니다. %d", i, i * j);
				System.out.println();
			}
		}

	} // main
} // class

package pub2504.basic;

public class ExLoopStatement2 {

	public static void main(String[] args) {

		// 1번
		for (int i = 0; i < 5; i++) { // 줄의 수
			for (int j = 0; j < i + 1; j++) { // 별의 수
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println();
		// 2번
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println();
		// 3번
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("  ");
			}
			for (int j = 0; j < 5 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println();
		// 4번
		for (int i = 0; i < 5; i++) {
			for (int j = 4 - i; j > 0; j--) {
				System.out.print("  ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println();
		// 5번
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i % 4 == 0 || j % 4 == 0) {
					System.out.print("*");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}

		System.out.println();
		// 6번
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i == j || 4 - i == j) {
					System.out.print("*");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}

		System.out.println();
		// 7번
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				if (i%4==0 || j%4 == 0 ) {
//					System.out.print("*");
//				} else {
//					System.out.print("  ");
//				}
//			}
//			System.out.println();
//		}

		// 보너스 실습 1
		// oo*oo
		// o***o
		// *****
		// o***o
		// oo*oo

		int total = 5; // 줄
		int middle = total/ 2; // 중간 값
		int kEnd = 0; // k반복의 끝 값 = 공백의 수
		int jEnd = 0; // j반복의 끝 값 = 별의수
		
		for (int i = 0; i < total; i++) {
			if(i<=middle) {
				kEnd = middle -i;
				jEnd = 2*i + 1;
			}else {
				kEnd = i - middle;
				jEnd = (total*2-1) - 2*i;
			}
			for(int k=0; k<kEnd; k++) System.out.print("o");
			for(int j =0; j <jEnd; j++) System.out.print("*");
			for(int k=0; k<kEnd; k++) System.out.print("o");
			System.out.println();
		}

	}// main
}
// class

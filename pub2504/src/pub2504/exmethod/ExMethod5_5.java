package pub2504.exmethod;

public class ExMethod5_5 {

	public static void main(String[] args) {

		String[][] strArr = { { "홍길동", "90", "80", "70", "0", "0.0" }, { "강감찬", "80", "70", "60", "0", "0.0" },
				{ "이순신", "70", "60", "50", "0", "0.0" } };

		for (int i = 0; i < strArr.length; i++) {
			for (int j = 0; j < strArr[0].length; j++) {
				System.out.print(strArr[i][j] + " ");
			}
			System.out.println();
		}
	} // main

	private static String calcTotal(String[][] strArr) {

		int strArrLeng = strArr.length;
		int strArr0Leng = strArr[0].length;

		int total = 0;
		float avg = 0.0f;
		for (int i = 0; i < strArrLeng; i++) {
			for (int j = 1; j < strArr0Leng - 2; j++) {
				total += Integer.parseInt(strArr[i][j]);
			}
			avg = total / 3;
			strArr[i][4] = String.valueOf(total);
			strArr[i][5] = String.valueOf(avg);
		}

		return null;
	} // calcTotal

} // class

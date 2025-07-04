package pub2504.exapiextra;

public class APIExtra8 {
	// APIExtra8.java : 영문 대소문자, 숫자, 기호를 포함한 문자열을 입력하면 대문자, 소문자, 숫자, 기호의
	// 개수를 출력

	public static void main(String[] args) {

		String line = Util.getLineText(1)[0];

		char[] chArr = line.toCharArray();

		int[] countArr = new int[4];

		for (char ch : chArr) {
			byte b = (byte) ch;
			if (b > 64 && b < 91) {
				countArr[0]++;
			} else if (b > 96 && b < 123) {
				countArr[1]++;
			} else if (b > 47 && b < 58) {
				countArr[2]++;
			} else {
				countArr[3]++;
			}
		}

		System.out.printf("대문자:%d, 소문자:%d, 숫자:%d, 기호:%d", countArr[0], countArr[1], countArr[2], countArr[3]);

	} // main
} // class

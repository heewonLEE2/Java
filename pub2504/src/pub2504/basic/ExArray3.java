package pub2504.basic;

public class ExArray3 {

	public static void main(String[] args) {

		// int i = Integer.parseInt(문자열);
		String[][] student = { 
				{"홍길동","90","80","70"},
				{"강감찬","80","70","60"},
				{"이순신","60","50","40"} 
				};

		int scoreLeng = student[0].length;
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		
			for(int i=1; i<scoreLeng; i++) {
				sum1 += Integer.parseInt(student[0][i]);
				sum2 += Integer.parseInt(student[1][i]);
				sum3 += Integer.parseInt(student[2][i]);
			}
		if(sum1 > 200) {
			System.out.printf("%s님의 총첨은 %d 입니다." , student[0][0], sum1);
		}
		if(sum2 > 200) {
			System.out.printf("%s님의 총첨은 %d 입니다." , student[1][0], sum2);
		}
		if(sum3 > 200) {
			System.out.printf("%s님의 총첨은 %d 입니다." , student[2][0], sum2);
		}

	} // main
} // class

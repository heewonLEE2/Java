package pub2504.exapiextra;

public class APIExtra2 {
	
	// APIExtra2.java : "Hello Java"라는 문자열내의 문자들의 아스키코드값의 총합을 출력
	public static void main(String[] args) {

		String str = "Hello Java";
		// 공백 제거
		String str1 = str.replace(" ", "");
		// 공백제거된 문자열 길이
		int strLeng = str1.length();
		// 아스키 코드 합계
		int sum = 0; 

		// 문자열을 charAt으로 만든걸 byte 와 시켜서 sum 합계 늘리기
		for (int i = 0; i < strLeng; i++) {
			sum += (byte)str1.charAt(i);
		}
		System.out.println("공백을 제외한 문자열 아스키코드의 합은 : " + sum);
		
	} // main
} // class

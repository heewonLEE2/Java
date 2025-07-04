package pub2504.api;

import java.util.StringTokenizer;

public class ExString {

	public static void main(String[] args) {

		// 실습 1
		// 문자열내 한글 개수 출력
		String str1 = "안녕하세요! Java 재밌나요?";

		int str1Leng = str1.length();
		int nkLeng = str1.replaceAll("[가-힣]", "").length(); // 한글이 아닌 문자 수
		System.out.println("한글 개수 : " + (str1Leng - nkLeng));
 
		// 실습 2 // 아스키코드 확인해서
		// 문자열내 홀수번째 인덱스에 소문자들을 문자들을 출력
		String str2 = "Hello! Java Programming!";
		int str2Leng = str2.length();
		for(int i =0; i<str2Leng; i++) {
			char ch = str2.charAt(i);
			byte b = (byte)ch;
			if(i%2==1 && b>=97 && b <= 122) {
				System.out.println(ch);
			}
		}
		
		// 실습 3
		// 문자열을 , 기준으로 분리하고 분리된 각 문자열과 문자열의 길이를 출력
		String str3 = "Apple,Banana,Orange,Grape";
		String[] str3Arr = str3.split(",");
		int str3ArrLeng = str3.length();
//		for(int i=0; i<str3ArrLeng; i++) {
//			System.out.println(str3Arr[i]+"," + str3Arr[i].length());
//		}
		
		StringTokenizer st3 = new StringTokenizer(str3, ",");
		while(st3.hasMoreTokens()) {
			System.out.print(st3.nextToken().length());
		}
		
		System.out.println();
		// 실습 4
		// 문자열내 단어의 수를 출력
		String str4 = "    Java is a powerful programming language   ";
		StringTokenizer st1 = new StringTokenizer(str4.trim());
		System.out.println(st1.countTokens());
		
		// 양끝 공백 제거, 중간 공백 없애고, 문자열길이 출력
		System.out.println(str4.trim().replaceAll(" ","").length());
		
		
		// 실습 5
		// 문자열내 중복문자는 한번만 출력
		String str5 = "This is Java Programming";
		int str5Leng = str5.length();
		char[] noDupArr = new char[str5Leng];
		int noDupIdx = 0;
		for(int i=0; i<str5Leng; i ++) {
			char ch = str5.charAt(i);
			boolean isDup = false;
			for(int j=0; j<noDupIdx; i++) {
				if(noDupArr[i] == ch) {
					isDup = true;
					break;
				}
			}
			if(!isDup) {
				noDupArr[noDupIdx] = ch;
				noDupIdx++;
			}
		}
		for(int i =0; i < noDupIdx; i++) {
			System.out.println(noDupArr[i]);
		}
		
		
		// 실습 6
		// 주민등록번호 문자열에서 생년월일을 아래 형식으로 출력
		// 생년월일 : 1999년 1월 16일
		String str6 = "990116-1234567";
		String shortYear = str6.substring(0,2);
		String month= str6.substring(2,4);
		String date= str6.substring(4,6);
		System.out.printf("생년월일 : 19%s년 %s월 %s일",shortYear,
				month.startsWith("0") ? month.charAt(1): month,
						date);
		
		System.out.println();
		// 실습 7
		// 문자열내 숫자들의 합을 출력
		String str7 = "Today is 12th event in 2025";
		// 합계
		int sum = 0;		
		// 숫자를 제외한 문자열 다 제외한 후 split로 하나씩 나눠서 배열에 저장
		String[] str7Arr = str7.replaceAll("\\D","").split("");
		
		// 문자로된 숫자들 정수로 바꿔서 합계 출력
		for(String st : str7Arr) {
			sum+= Integer.parseInt(st);
		}
		System.out.println(sum);
		
		// 실습 8
		// 문자열내 a문자의 인덱스들을 출력
		String str8 = "Banana is a very delicious and amazing";

		int index = -1;
		
		while((index=str8.indexOf("a",index+1))>=0) {
			System.out.println("인덱스" + index + "번에 있습니다.");
		}
		
		// 실습 9
		// 문자열내 두번째 Java 문자열의 인덱스를 출력
		String str9 = "I love Java. I hate Java";
		int firstIdx = str9.indexOf("Jave");
		System.out.println(str9.indexOf("Jave",firstIdx+1));
		
		
		
		// 실습 10
		// 문자열에서 확장자를 추출하여 출력
		String str10 = "document.final.version.pdf";
		int lastDotIdx = str10.lastIndexOf(".");
		System.out.println(str10.substring(lastDotIdx+1));
		
	} // main
} // class





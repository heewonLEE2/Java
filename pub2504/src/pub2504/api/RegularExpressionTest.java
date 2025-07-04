package pub2504.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 정규표현식 (Regular Expression)
 * 정해진 패턴문자열들을 사용해서 문자열내의 문자열을 검색, 치환에 사용되는 표현식
 * ^ : 문자열의 시작
 * [^문자열] : 문자열이 아닌 것
 * $ : 문자열의 끝
 * . : 임의의 한 문자
 * * : 문자가 0개 이상 발생
 * + : 문자가 1개 이상 발생
 * ? : 문자가 0개 또는 1개 발생
 * [] : 문자의 집합 범위
 * {} : 문자열의 반복 회수
 * | : or
 * \b : 단어의 경계
 * \B : 단어가 아닌 것의 경계
 * \s : 공백문자
 * \S : 공백문자가 아닌 문자
 * \w : word (영문대소문자, 숫자, _)
 * \W : word가 아닌 것
 * \d : 숫자 = [0-9]
 * \D : 숫자가 아닌 것
 * \\ : "\"문자 자체 
 */
public class RegularExpressionTest {

	public static void main(String[] args) {

		// String 클래스의 matches메소드 : 문자열이 패턴을 따르면 true
		String str1 = "abcde";
		System.out.println(str1.matches("abc")); // false
		System.out.println(str1.matches("abcde")); // true

		String str2 = "010-1234-5678";
		System.out.println(str2.matches("\\d{3}-\\d{4}-\\d{4}")); // true
		System.out.println(str2.matches("\\d{3}-\\d{3}-\\d{4}")); // false

		String str3 = "12345";
		System.out.println(str3.matches("\\d{5}")); // true
		System.out.println(str3.matches("[0-9]{5}")); // true

		String str4 = "abc123";
		String str5 = "ABC123";
		System.out.println(str4.matches("[a-zA-Z]{3}[0-9]{3}")); // true
		System.out.println(str4.matches("[a-zA-Z]{3}\\d{3}")); // true

		String str6 = "안녕 자바";
		System.out.println(str6.matches("[가-힣]{2}\s[가-힣]{2}")); // true

		// java.util.regex 패키지
		// Pattern : 정규표현식 패턴 클래스
		// Matcher : 패턴에 맞는지 체크하는 메소드가 있는 클래스

		// Pattern
		// Pattern.compile(패턴문자열, 플래그) : 패턴 생성
		// Pattern.CASE_INSENSITIVE, Pattern.MULTILINE : 여러 라인의 시작과 끝 탐색
		// Pattern.DOTALL : . 이 개행 문자도 포함하도록

		// 대소문자 구별없이 a가 0개이상으로 시작하고 b로 끝나는 패턴
		Pattern p = Pattern.compile("^a*b$", Pattern.CASE_INSENSITIVE); // CASE_INSENSITIVE 대소문자 구별안하고
		// Matcher
		Matcher m1 = p.matcher("ab");
		System.out.println(m1.matches()); // true
		Matcher m2 = p.matcher("bb");
		System.out.println(m2.matches()); // false
		Matcher m3 = p.matcher("aaab");
		System.out.println(m3.matches()); // true

		System.out.println("---------------------------");
		// 정규표현식 실습 1
		// 아래 문자열에서 숫자만 남겨서 출력
		String rstr1 = "전화 : 010-1234-5678";
		System.out.println(rstr1.replaceAll("\\D", ""));

		// 정규표현식 실습 2
		// 아래 문자열을 공백 기준으로 단어들을 분리해서 출력
		String rstr2 = "Java is powerful and simple";
		String[] rstr2Words = rstr2.split("\\s");

		for (String rstr2Word : rstr2Words) {
			System.out.println(rstr2Word);
		}

		// 정규표현식 실습 3 (Pattern 사용)
		// 아래 문자열이 Java라는 단어를 포함하고 있는지 출력
		String rstr3 = "I love Java Programming";
		Pattern rstr3_pattern = Pattern.compile("Java");
		Matcher rstr3_matcher = rstr3_pattern.matcher(rstr3);

		System.out.println(rstr3_matcher.find() ? "포함" : "미포함");

		// 정규표현식 실습 4
		// 아래 문자열에서 소문자만 제거 후 출력
		String rstr4 = "Java123abcDEF";
		Pattern rstr4_p = Pattern.compile("[a-z]?");
		Matcher rstr4_m = rstr4_p.matcher(rstr4);
		
		System.out.println(rstr4_m.replaceAll(""));
		
		
		// 정규표현식 실습 5
		// 아래 문자열이 휴대폰 번호 형식이 맞는지 확인 후 출력
		String rstr5 = "010-1234-5678";
		Pattern rstr5_pattern =Pattern.compile("\\d{3}-\\d{4}-\\d{4}");
		Matcher rstr5_matcher = rstr5_pattern.matcher(rstr5);
		System.out.println(rstr5_matcher.matches() ? "휴대폰 번호 맞음" : "휴대폰 번호 아님");
		
		// 정규표현식 실습 6
		// 아래 문자열에서 HTML 태그를 제거 후 출력
		String rstr6 = "<p>Hello<br><b>World</b>";
		Pattern rstr6_p = Pattern.compile("(<\\w+>)|(</\\w+>)"); //"<[^>]*>"
		Matcher rstr6_m = rstr6_p.matcher(rstr6);
		System.out.println(rstr6_m.replaceAll(""));
	
		// 정규표현식 실습 7
		// 아래 문자열에서 여러개의 공백을 하나로 변경 후 출력
		String rstr7 = "Java      is      easy";
		Pattern rstr7_p = Pattern.compile("\\s+");
		Matcher rstr7_m = rstr7_p.matcher(rstr7);
		System.out.println(rstr7_m.replaceAll(" "));
		//System.out.println(rstr7.replaceAll("\\s+", " ");
		
		// 정규표현식 실습 8
		// 아래 배열의 문자열들에 모두 매칭되는 전화번호 정규표현식 패턴만들기
		// 전화번호 :  숫자2개나3개-숫자3개나4개-숫자4개
		String[] telArr = { "02-123-4567", "031-123-4567", "02-1234-5678", "031-1234-5678" };
		Pattern telArr_p = Pattern.compile("\\d{2,3}-\\d{3,4}-\\d{4}");
		
		for(String str : telArr) { 
			Matcher telArr_m = telArr_p.matcher(str);
			if(telArr_m.matches()) {
				System.out.println("비밀번호 형식에 맞습니다.!");
			}else {
				System.out.println("비밀번호 형식에 맞지 않습니다.!");
			}
		}
		// 정규표현식 실습 9
		// 아래 배열의 문자열들에 모두 매칭되는 주민등록번호 정규표현식 패턴만들기
		// 주민등록번호 : 년도2자리월2자리일2자리-남녀구분1자리숫자6자리
		// 년도:00~99, 월:01~12, 일:01~31, 남녀구분:1~4중하나
		String[] ssnArr = { "100101-3234567", "001231-4234567", "900101-1234567", "800101-2234567", "701301-1234567",
				"601201-5234567" };
		Pattern ssnArr_p = Pattern.compile("^\\d{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])-[1-4]\\d{6}$");
		for(String str : ssnArr) {
			Matcher ssnArr_m = ssnArr_p.matcher(str);
			if(ssnArr_m.matches()) {
				System.out.println("주민번호 형식에 맞습니다.!");
			}else {
				System.out.println("주민번호 형식에 맞지 않습니다.!");
			}
		}
		//"^\\d{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])-[1-4]\\d{6}$"
		
		// 정규표현식 실습 10
		// 아래 문자열의 다양한 날짜 형식들을 "YYYY-MM-DD" 형식으로 출력
		String rstr10 = "오늘은 2025-06-13이고, 작년엔 2024.06.12에 회의를 했고, 다음 회의는 2025/06/15입니다.";
		String repStr = rstr10.replaceAll("[./]", "-");
		Pattern pattern10 = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
		Matcher matcher10 = pattern10.matcher(repStr);
		while(matcher10.find()) {
			System.out.println(matcher10.group());
		}
		
	} // main
} // class







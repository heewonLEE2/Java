package pub2504.api;

import java.util.Calendar;
import java.util.Scanner;

public class ExDate2 {

	
	public static void main(String[] args) {

		// 원하는 년도, 월 입력받기
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("보고싶은 년도를 입력하세요");
		int inputYear = scanner.nextInt();
		System.out.println("보고싶은 월을 입력하세요");
		int inputMonth = scanner.nextInt();
		
		Calendar cal =  Calendar.getInstance();
		// 입력한 년월의 1일 설정
		cal.set(inputYear, inputMonth,1);
		
		System.out.println(cal);
		
		// 1일의 요일 숫자
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		// 월의 마지막 날
		int lastDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		System.out.println(inputYear + "년" + inputMonth +"달력입니다.\n"+"일\t월\t화\t수\t목\t금\t토");
		
	      // 요일값-1만큼 탭 만들기
	      for (int i=1; i<dayOfWeek; i++) System.out.print("\t");
	      
	      for (int i=1; i<=lastDayOfMonth; i++) {
	         System.out.print(i + "\t"); // 날짜 표시 (1일부터 말일까지)
	         if ((dayOfWeek+(i-1))%7 == 0) System.out.println(); // 7개마다 줄바꿈
	      }      
		
		scanner.close();
		
	} // main
} // class











package pub2504.api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ExDate1 {

	
	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		
		// 한국
		
		// 한국
		cal.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
		printDate("한국 서울", cal);
		
		// 영국
		cal.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		printDate("영국 런던", cal);
		
		// 미국
		cal.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
		printDate("미국 LA", cal);
		
		// 타임존을 호주로
		cal.setTimeZone(TimeZone.getTimeZone("Australia/Stdney"));
		printDate("호주 시드니", cal);
		

		
		
	
		
	}

	private static void printDate(String string, Calendar cal) {
		// TODO Auto-generated method stub
		
	}
}
















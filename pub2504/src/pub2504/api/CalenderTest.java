package pub2504.api;

import java.util.Calendar;

public class CalenderTest {

	public static void main(String[] args) {
		
		// 캘린더 객체 생성
		Calendar cal = Calendar.getInstance();
		// java.util.GregorianCalendar[time=1749791522694,areFieldsSet=true,areAllFieldsSet=true,
		// lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,
		// useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,
		// ERA=1,YEAR=2025,MONTH=5,WEEK_OF_YEAR=24,WEEK_OF_MONTH=2,DAY_OF_MONTH=13,
		// DAY_OF_YEAR=164,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=2,
		// HOUR_OF_DAY=14,MINUTE=12,SECOND=2,MILLISECOND=694,ZONE_OFFSET=32400000,
		// DST_OFFSET=0]
		System.out.println(cal.getTime());
		
		// 밀리초 시간 (1970년 1월 1일 0시 0분  0초 0밀리초부터 현재까지 1씩 센 값 = epoch time = unix time)
		System.out.println(cal.getTimeInMillis());
		
		// 타임존
		System.out.println(cal.getTimeZone());
		
		// 현재 날짜/시간 정보
		System.out.println(cal.get(Calendar.YEAR)); // 년
		System.out.println(cal.get(Calendar.MONTH) +1); // 월은 0부터 시작하므로
		System.out.println(cal.get(Calendar.DAY_OF_MONTH)); // 한달에서 며칠째
		System.out.println(cal.get(Calendar.HOUR_OF_DAY)); // 하루 중 시간 0~23
		System.out.println(cal.get(Calendar.MINUTE)); // 분
		System.out.println(cal.get(Calendar.SECOND)); // 초
		System.out.println(cal.get(Calendar.MILLISECOND)); // 밀리초
		
		// 특정 날짜 설정
		cal.set(2024, Calendar.JANUARY,1); // Calendar.JANUARY = int 0 값과 같음
		System.out.println(cal.get(Calendar.YEAR)); 
		System.out.println(cal.get(Calendar.MONTH) +1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		
		// 날짜 더하기
		cal.add(Calendar.YEAR, 3); // 3년 후
		cal.add(Calendar.MONTH,3); // 3개월 후
		cal.add(Calendar.DAY_OF_MONTH,7); // 7일 후
		System.out.println(cal.get(Calendar.YEAR)); 
		System.out.println(cal.get(Calendar.MONTH) +1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		
		// 날짜 빼기
		cal.add(Calendar.YEAR, -3); // 3년 전
		cal.add(Calendar.MONTH, -3); // 3개월 전
		cal.add(Calendar.DAY_OF_MONTH,-7); // 7일 전
		System.out.println(cal.get(Calendar.YEAR)); 
		System.out.println(cal.get(Calendar.MONTH) +1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		
	} // main
} // class
package pub2504.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
	[Stream API]
	- Java8 부터 도입
	- 컬렉션의 요소들을 함수형 방식으로 처리할 수 있도록 지원하는 API
	- 반복문을 사용하는 방식보다 가독성, 선언적 코드 스타일, 병렬처리 용이성의 장점을 제공
	- Stream(스트림)이란 데이터의 흐름
	- 컬렉션과 배열 등에서 스트림을 얻어 다양한 처리가 가능
	- 스트림은 한번만 소비가 가능 (지나간 스트림은 돌아오지 않는다)
	- 중간연산(Intermediate Operation) 과 최종연산(Terminal Operation) 으로 구성
	- Stream API 구성
		생성 : 컬렉션, 배열 등에서 스트림 생성 예)list.stream()
		중간연산 : 스트림을 변환 예) filter(), map() ...
		최종연산 : 결과 도출 예) collect(), forEach() ...  
		
	- 중간연산 메소드
		filter() : 조건에 맞는 요소를 필터링 예) stream.filter(s -> s.length() >3)
		map() : 요소를 반환 예) stream.map(String::toUpperCase)
		sorted() : 요소 순서 정렬 예) stream.sorted()
		distinct() : 요소 중복 제거 예) stream.distinct()
		limit(n) : n 개 요소만 추출 예) stream.limit(5)
		skip(n) : 처음에 나오는 n 개 건너뛰기 예) stream.skip(2)
		peek() : 디버깅용 중간처리 예) stream.peek(System.out::println)
	- 최종연산 메소드
		forEach() : 각 요소에 대해 작업 수행 예) stream.forEach(System.out::println)
		collect() : 연산 결과를 수집 예) stream.collect(Collectors.toList())
		reduce() : 누적 연산 stream.reduce("",String::concat) // 문자열 붙히기, 합계 연산등
		count() : 요소 수 반환 예) stream.count() // 최종적으로 중간연산에 만족하는 요소 수 반환
		anyMatch() : 조건을 만족하는 요소 존재하는지 여부 예) stream.anyMatch(s -> s.contains("Java"))
		allMatch() : 전체 요소가 모두 조건을 만족하는지 여부 예) stream.allMatch(s -> s.length() > 0)
		noneMatch() : 조건을 만족하는 요소가 없는지 여부 예) stream.noneMatch(s -> s==null)
		findFirst() : 첫번째 요소 반환 예) stream.findFirst()
 */

public class StreamAPI {

	public static void main(String[] args) {

		// Stream 생성
		List<String> strList = Arrays.asList("Java", "Python", "C++");
		Stream<String> strStream = strList.stream(); // 단일 스트림
		Stream<String> parallelStream = strList.parallelStream(); // 병렬 스트림 (몇 만개 이상, 몇 백만개... 등 작업)

		// 배열로 스트림 생성
		String[] sArr = { "Java", "Hello", "Good", "Sorry", "Hi" };
		Stream<String> sArrStream = Arrays.stream(sArr);

		// 수집결과 Stream 을 List, Set, Map 으로 만들기
		List<String> sList = sArrStream.collect(Collectors.toList());
		System.out.println(sList);

		sArrStream = Arrays.stream(sArr);
		Set<String> sSet = sArrStream.collect(Collectors.toSet());
		System.out.println(sSet);

		sArrStream = Arrays.stream(sArr);
		Map<String, Integer> sMap = sList.stream().collect(Collectors.toMap(str -> str, str -> str.length()));
		System.out.println(sMap);

		// 그룹핑
		List<String> gList = Arrays.asList("apple", "banana", "kiwi", "pear", "grape", "melon", "peach");
		Map<Integer, List<String>> groupedByLength = gList.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(groupedByLength);

		// 집계
		long count = gList.stream().collect(Collectors.counting());
		System.out.println(count);

		// 병렬 처리 (데이터가 많은 경우 효율이 있음)
		gList.parallelStream().filter(s -> s.length() > 4).forEach(System.out::println);

		// 메소드 체이닝
		List<String> nameList = Arrays.asList("홍길동", "강감찬", "홍길동", "이순신", "최영", "권율");
		List<String> resultList = nameList.stream() // nameList 를 stream 으로 만들기
				.filter(name -> name.length() >= 3) // 각 name.length 가 3 이상 필터
				.distinct() // 각 데이터들의 중복 제거 (구별한다)
				.sorted() // 오름차순 정렬 - 인자에 Comparator 구현하면 내림차순 정렬 가능
				.map(name -> name + "님") // 각 name 에 "님" 자를 붙힘
				.collect(Collectors.toList()); // 최종 결과를 List 에 담는다.
		System.out.println(resultList);
		
		System.out.println("==========================");
		// 실습 : 아래 학생리스트에서 점수가 70점 이상인 학생들의 리스트를 출력
		class Student {
			private String name;
			private int score;
			public Student() {
			}
			public Student(String name, int score) {
				this.name = name;
				this.score = score;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getScore() {
				return score;
			}
			public void setScore(int score) {
				this.score = score;
			}
			@Override
			public String toString() {
				return name + "님은 " + "70점 이상입니다. 점수는 : " + score;
			}
		} // Student class
		
		List<Student> studentList = Arrays.asList(
		         new Student("홍길동", 90),
		         new Student("강감찬", 100),
		         new Student("이순신", 60),
		         new Student("최영", 70)
				);
		List<String> studentStrList = studentList.stream()
				.filter(e->e.score >=70).map(Student::getName).collect(Collectors.toList());
		studentStrList.stream().forEach(System.out::println);
		
		
	} // main
} // class

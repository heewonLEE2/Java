package pub2504.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
	[Stream API] 실습


*/

public class ExStreamAPI {

	public static void main(String[] args) {

		List<ExStudent> students = Arrays.asList(new ExStudent("Alice", 85), new ExStudent("Bob", 67),
				new ExStudent("Charlie", 90), new ExStudent("David", 75), new ExStudent("Eve", 90),
				new ExStudent("Frank", 45), new ExStudent("Bob", 67), new ExStudent("Grace", 70));

		Stream<ExStudent> resultStudents = students.stream();
		resultStudents
				// 4-1. 성적 내림차순 정렬
				// .sorted(Comparator.comparing(ExStudent::getScore).reversed())

				// 1. 70점 이상인 학생들
				.filter(student -> student.getScore() >= 70)
				// 2. 이름을 대문자로 변경
				.map(s -> s.getName().toUpperCase())
				// 3. 중복 제거
				.distinct()
				// 4. 이름 내림차순 정렬
				.sorted(Comparator.reverseOrder())

				// 5. 처음 한명 건너뛰기
				.skip(1)

				// 6. 3명만 추출
				.limit(3)

				// 7. 중간값 출력
				// .peek(n -> System.out.println("Peek: " + n))

				// 8. 리스트 수집
				// .collect(Collectors.toList())
				.forEach(System.out::println);

		// 9. 학생 수 출력
		System.out.println(students.stream().count());

		// 10. 평균 점수 출력
		System.out.println(students.stream().collect(Collectors.averagingInt(ExStudent::getScore)));

		// 11. 최대 점수 출력
		System.out.println(students.stream().mapToInt(ExStudent::getScore).max().orElse(0));
		System.out.println(students.stream().max(Comparator.comparing(ExStudent::getScore)).get());

		// 12.최소 점수 출력
		System.out.println(students.stream().mapToInt(ExStudent::getScore).min().orElse(0));
		System.out.println(students.stream().min(Comparator.comparing(ExStudent::getScore)).get());

		// 13. 100점인 학생이 있는지? 모두 30점 이상인지? 음수인 점수가 없는지?
		System.out.println(students.stream().anyMatch(e -> e.getScore() == 100) ? "백점인 학생이 있습니다." : "백점인 학생은 없습니다.");

		System.out.println(students.stream().allMatch(e -> e.getScore() >= 30) ? "모두 30점 이상입니다." : "모두 30점 이상이 아닙니다.");
		System.out.println(students.stream().anyMatch(e -> e.getScore() > 0) ? "음수인 점수 없음" : "음수인 점수 있음");

		// 14. 점수가 70점에서 80점 사이인 사람 중 첫번째 학생
		// findFirst()의 반환타입은 Optional<Object> : null 방지 Object
		// Optional 에서 원래 값 추출하려면 get()
		System.out.println(students.stream().filter(e -> e.getScore() >= 70 && e.getScore() <= 80)
				.map(ExStudent::getName).findFirst().get());

		// 15. 점수의 총합
		System.out.println(students.stream().map(ExStudent::getScore).reduce(0, Integer::sum));

		// 16. 점수별로 그룹핑된 학생 이름을 출력
		Map<Integer, List<String>> grouped = students.stream().distinct().collect(Collectors
				.groupingBy(ExStudent::getScore, Collectors.mapping(ExStudent::getName, Collectors.toList())));
		System.out.println(grouped);
		grouped.forEach((score, name) -> {
			System.out.println("점수 : " + score + ", 학생 : " + name);
		});

	} // main
} // class

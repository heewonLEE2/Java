package pub2504.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;

public class CollectionsTest {

	public static void main(String[] args) {
		
		// Collections 의 static 상수
		System.out.println(Collections.EMPTY_LIST);
		System.out.println(Collections.EMPTY_SET);
		System.out.println(Collections.EMPTY_MAP);
		
		System.out.println(Collections.emptyList());
		System.out.println(Collections.emptySet());
		System.out.println(Collections.emptyMap());
		System.out.println(Collections.emptyIterator());
		
		List<String> nameList = new ArrayList<String>();
		nameList.add("홍길동");
		nameList.add("강감찬");
		nameList.add("이순신");

		// 컬렉션에 요소 추가
		Collections.addAll(nameList, "장보고");
		Collections.addAll(nameList, "권율","최영","이성계");
		System.out.println(nameList);
		
		// 컬렉션 복사
		// copyList nameList 의 사이즈(요소의 수) 만큼의 공간을 확보해야 복사가 가능
		// copyList 가 7개의 공간을 확보하고 각 공간을 null 로 초기화 함
		List<String> copyList
			= new ArrayList<String>(Collections.nCopies(nameList.size(), null));
		
		System.out.println(copyList); // [null, null, null, null, null, null, null]
		Collections.copy(copyList, nameList); // 복사본, 원본
		System.out.println(copyList); // [홍길동, 강감찬, 이순신, 장보고, 권율, 최영, 이성계]
		
		// 컬렉션 채우기
		List<String> copyList2
		= new ArrayList<String>(Collections.nCopies(nameList.size(), null));
		Collections.fill(copyList2, "김유신");
		System.out.println(copyList2); // [김유신, 김유신, 김유신, 김유신, 김유신, 김유신, 김유신]
		
		// 컬렉션 열거자
		// Enumeration : java 1.0 부터 있었고 Iterator 의 하위 호환 버젼
		// 						  hasMoreElements, nextElement 메소드 제공
		// 						  지금은 사용되지 않지만 예전 버젼 java 와의 호환을 위한 존재
		
		Enumeration<String> en = Collections.enumeration(nameList);
		while (en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
		
		// 컬렉션 요소 대체
		Collections.replaceAll(copyList2, "김유신", "최영");
		System.out.println(copyList2); // [최영, 최영, 최영, 최영, 최영, 최영, 최영]
		
		// 컬렉션 순서를 180도 뒤집음
		Collections.reverse(nameList);
		System.out.println(nameList);
		
		// 컬렉션 요소 순서 랜덤하게 섞음
		Collections.shuffle(nameList);
		System.out.println(nameList);
		
		// ******************************************* //
		// 컬렉션 정렬  *************중요*************
		// ******************************************* //		
		
		// Collections 의 sort 메소드 : 컬렉션을 정렬하는 메소드
		// public static <T extends Comparable<? super T>> void sort(List<T> list)
		// Collectons.sort(정렬할 컬렉션, Comparator 구현한 클래스)
		
		// Comparator 인터페이스의 compare(T t1, T t2) 반환타입은 int
		// 앞 파라미터의 값이 크면 양수(1)을 반환
		// 두 파라미터의 값이 같으면 0
		// 뒷 파라미터의 값이 크면 음수(-1)을 반환

		List<Integer> intList = new ArrayList<Integer>();
		Collections.addAll(intList, 5,10,1,6,9);
		
		Collections.sort(intList, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i1 - i2; // 오름 차순 정렬
				// return i2 - i1; // 내림 차순 정렬
			}
		});
		System.out.println(intList); // [1, 5, 6, 9, 10]
	} // main
} // class
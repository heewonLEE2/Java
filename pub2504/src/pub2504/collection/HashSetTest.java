package pub2504.collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		
		Set<String> nameSet = new HashSet<String>();
		
		// 요소 추가
		nameSet.add("홍길동");
		nameSet.add("이순신");
		nameSet.add("강감찬");
		
		System.out.println(nameSet); // [홍길동, 강감찬, 이순신]
		
		// 컬렉션 추가
		Set<String> subSet = new HashSet<String>();
		subSet.add("장보고");
		subSet.add("권율");
		nameSet.addAll(subSet);
		//  순서없이 들어간다. Set 은 순서가 없기때문
		System.out.println(nameSet); // [홍길동, 장보고, 권율, 강감찬, 이순신]
		
		// 요소 포함 여부
		System.out.println(nameSet.contains("장보고")); //true

		// 셋이 비어 있는지
		System.out.println(nameSet.isEmpty()); // false
		
		// 요소 제거
		nameSet.remove("권율");
		System.out.println(nameSet); // [홍길동, 장보고, 강감찬, 이순신]
		
		//Object[]로 변경
		Object[] objArr = nameSet.toArray();
		for(Object obj : objArr) {
			System.out.println(obj);
		}
		
		// Set 은 중복 저장 불허
		nameSet.add("홍길동");
		System.out.println(nameSet); // 같은 요소는 추가가 안된다.
	} // main
} // class
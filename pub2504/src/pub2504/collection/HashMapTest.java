package pub2504.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		
		Map<Integer, String> stdMap = new HashMap<Integer, String>();
		
		// 엔트리 추가 wrapper 가 만들어져서 기본타입인 Integer 가 참조타입으로 들어갈 수 있다.
		stdMap.put(1, "홍길동");
		stdMap.put(2, "장보고");
		stdMap.put(3, "이순신");
		stdMap.put(2, "강감찬"); // 기존 키를 사용해 저장하면 기존 값은 없어짐
		System.out.println(stdMap); // {1=홍길동, 2=강감찬, 3=이순신}
		
		// 키 포함 여부
		System.out.println(stdMap.containsKey(1)); // true
		System.out.println(stdMap.containsValue("유관순")); // false
		
		// 키에 해당하는 값 반환 * 이 기능을 주로 쓰려고 map 을 사용한다. *
		System.out.println(stdMap.get(3)); // 이순신
		
		// 엔트리가 없는지
		System.out.println(stdMap.isEmpty()); // false
		
		// 맵에 맵을 추가
		Map<Integer, String> subMap = new HashMap<Integer, String>();
		subMap.put(4, "유관순");
		subMap.put(5, "권율");
		subMap.putAll(stdMap);
		System.out.println(subMap); // {1=홍길동, 2=강감찬, 3=이순신, 4=유관순, 5=권율}
		
		// 키에 해당하는 엔트리 제거
		subMap.remove(1);
		System.out.println(subMap);
		
		// 맵의 엔트리 수
		System.out.println(subMap.size());
		
		// 모든 엔트리 제거
		subMap.clear();
		System.out.println(subMap); // {} Empty map 이다
		
		// 엔트리 셋
		Set<Map.Entry<Integer, String>> entrySet = stdMap.entrySet();
		// 엔트리 셋을 반복시키기 위한 반복자
		Iterator<Map.Entry<Integer, String>> it = entrySet.iterator();
		
		while(it.hasNext()) { // 다음번 반복할 요소가 있는 동안 반복
			Map.Entry<Integer, String> entry = it.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		// 실습 : 맵에서 키 셋을 추출해서 키들을 반복 출력
		Set<Integer> entrySet2 = stdMap.keySet();
		Iterator<Integer> setIt = entrySet2.iterator();
		
		while(setIt.hasNext()) {
			System.out.println(setIt.next());
		}
		
		// 실습 : 맵에서 값들을 추출해서 값들을 반복 출력
		Collection<String> valueSet1 = stdMap.values();
		Iterator<String> valueIt = valueSet1.iterator();
		
		while(valueIt.hasNext()) {
			System.out.println(valueIt.next());
		}
	} // main
} // class
package pub2504.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		
		//String 들을 저장하는 ArrayList
		List<String> fruitList = new ArrayList<String>();
		
		fruitList.add("사과");
		fruitList.add("딸기");
		fruitList.add("포도");
		
		System.out.println(fruitList); // [사과, 딸기, 포도]
		
		List<String> subList = new ArrayList<String>();
		subList.add("복숭아");
		subList.add("참외");
		
		// 컬렉션에 컬렌션을 추가
		fruitList.addAll(subList);
		System.out.println(fruitList); // [사과, 딸기, 포도, 복숭아, 참외]
		
		// 요소 모두 제거
		subList.clear();
		
		// 요소를 포함하고 있는지
		System.out.println(fruitList.contains("포도")); // true
		
		// 인덱스에 해당하는 요소를 반환
		System.out.println(fruitList.get(0)); // 사과
		
		// 요소 인덱스 반환
		System.out.println(fruitList.indexOf("딸기")); // 1
		
		// 요소가 없는지 확인
		System.out.println(fruitList.isEmpty()); // false
		System.out.println(subList.isEmpty()); // true
		
		// 요소가 위치한 마지막 인덱스
		fruitList.add("포도");
		System.out.println(fruitList.lastIndexOf("포도")); // 5
		
		// 요소 제거
		fruitList.remove("딸기");
		System.out.println(fruitList); // [사과, 포도, 복숭아, 참외, 포도]
		
		// 요소 모두 제거
		subList.add("복숭아");
		subList.add("참외");
		fruitList.removeAll(subList);
		System.out.println(fruitList); // [사과, 포도, 포도]
		
		// 요소 변경
		fruitList.set(2, "복숭아");
		System.out.println(fruitList); // [사과, 포도, 복숭아]
		
		// 요소 개수
		System.out.println(fruitList.size()); // 3
		
		// List 를 Object[]로 변경
		Object[] objArr = fruitList.toArray();
		for(Object obj : objArr) {
			System.out.println(obj);
		}
		
		// Object[]을 List 로 변경
		List<Object> objList = Arrays.asList(objArr);
		for(Object obj : objList) {
			System.out.println(obj);
		}
	} // main
} // class
package pub2504.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PersonInfo1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Map<String, Integer> personInfo = new HashMap<String, Integer>();
		
		while(personInfo.size() < 3) {
			System.out.println("이름을 입력하세요");
			String personName = scanner.next();
			
			System.out.println("나이를 입력하세요");
			int personAge = scanner.nextInt();
			personInfo.put(personName, personAge);
		}
		
		// 엔트리 셋 사용
//		Set<Map.Entry<String, Integer>> personSet = personInfo.entrySet();
//		Iterator<Map.Entry<String, Integer>> personIt = personSet.iterator();
//		
//		while(personIt.hasNext()) {
//			Map.Entry<String, Integer> entry = personIt.next();
//			System.out.println(entry.getKey() + "님의 나이는 : " + entry.getValue() + "살");
//		}
		
		
		// 키셋 사용
		Set<String> keySet = personInfo.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key + personInfo.get(key));
		}
		
		
		scanner.close();
	} // main
} // class









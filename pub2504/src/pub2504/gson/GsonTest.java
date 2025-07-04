package pub2504.gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/* 
	GSON
 	- Google 에서 만든 Java JSON Library
 	- toJson() : 자바 객체 -> JSON 문자열
 	- fromJson() : JSON 문자열 -> 자바객체
 	- 비슷한 라이브러리 : Jackson, SimpleJson ...
*/

public class GsonTest {

	public static void main(String[] args) {

		// Gson 객체 생성법 1)
		Gson gson1 = new Gson();

		// Gson 객체 생성법 2)
		Gson gson2 = new GsonBuilder().create();

		// Gson 객체 생성법 3)
		Gson gson3 = new GsonBuilder().setPrettyPrinting().create(); // 들여쓰기 정렬해서

		// JsonObject 객체 생성
		JsonObject jsonObject = new JsonObject();

		// JsonObject 에 키/값 추가
		jsonObject.addProperty("name", "홍길동"); // {"name" : "홍길동"}
		jsonObject.addProperty("age", 30); // {"age" : 30}

		// JsonObject 를 Json 문자열로 변환
		String jsonStr = gson3.toJson(jsonObject);
		// System.out.println(jsonStr);

		// Java 객체를 Json 문자열로 변환
		Person person1 = new Person("홍길동", 30);
		String personJsonStr = gson3.toJson(person1);
		// System.out.println(personJsonStr);

		// Json 문자열을 Java 객체로 변환
		String jsonStr2 = "{\"name\" : \"강감찬\",\"age\": 30}";
		// Json 문자열, 변환타입
		Person person2 = gson3.fromJson(jsonStr2, Person.class);
		// System.out.println(person2);

		// List 객체를 Json 문자열로 변환
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("홍길동", 30));
		personList.add(new Person("이순신", 40));
		personList.add(new Person("강감찬", 50));

		String jsonStr3 = gson3.toJson(personList);
		// System.out.println(jsonStr3);

		// Json 문자열을 List 객체로 변환
		List<Person> personList2 = gson3.fromJson(jsonStr3, new TypeToken<ArrayList<Person>>() {
		}.getType());
		// personList2.stream().forEach(System.out::println);

		// Map 객체를 Json 문자열로 변환
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "유관순");
		map.put("age", "20");
		map.put("gender", "여성");
		String mapStr = gson3.toJson(map);
		// System.out.println(mapStr);

		// Json 문자열을 Map 객체로 변환
		Map<String, String> map2 = gson3.fromJson(mapStr, Map.class);
		for (Map.Entry<String, String> entry : map2.entrySet()) {
			// System.out.println(entry);
		}

		// 실습 : Person 들의 Map 을 생성해서 JSON 문자열로 변환 후 다시 Map 으로 변환
		Map<String, Person> personMap = new HashMap<String, Person>();
		personMap.put("1번", new Person("홍길동1", 10));
		personMap.put("2번", new Person("홍길동2", 20));
		personMap.put("3번", new Person("홍길동3", 30));

		String mapStr2 = gson3.toJson(personMap);
		// System.out.println(mapStr2);

		Map<String, Person> jsonFromMap = gson3.fromJson(mapStr2, new TypeToken<Map<String, Person>>() {
		}.getType());
		for (Map.Entry<String, Person> entry : jsonFromMap.entrySet()) {
			System.out.println(entry);
		}

	} // main
} // class

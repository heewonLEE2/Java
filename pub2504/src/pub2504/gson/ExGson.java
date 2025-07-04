package pub2504.gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/* 
	[Gson 변환 실습]
	https://jsonplaceholder.typicode.com/users 데이터를 가져와서
	Java List 로 변환 후 email이 .com 으로 끝나는 사용자들의 정보를 출력
*/

public class ExGson {

	public static void main(String[] args) {

		BufferedReader br = null;

		try {

			// 데이터 가져오기 및 bufferedReader 만들기
			URI uri = new URI("https://jsonplaceholder.typicode.com/users");
			URL url = uri.toURL();
			URLConnection connect = url.openConnection();
			InputStream is = connect.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

			// JSON 문자열 들을 저장할 jsonStr
			String jsonStr = "";
			String line = "";

			while ((line = br.readLine()) != null) {
				jsonStr += line;
			}
			// System.out.println(jsonStr); // 출력

			// gson 객체 생성
			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			// User 저장할 List 생성
			ArrayList<User> userList
					= gson.fromJson(
						jsonStr,
						new TypeToken<ArrayList<User>>() {}.getType());
			
//		userList.stream()
//		.filter(e-> e.getWebsite().matches("^\\S+.com$"))
//		.forEach(System.out::println);

		userList.stream()
		.filter(e->e.getName().matches("L+\\w+"))
		.forEach(e-> System.out.println("L 로 시작하는 이름의 " + e.getName()+" 님의  " + e.getAddress().getGeo()));
	
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

		
	} // main
} // class











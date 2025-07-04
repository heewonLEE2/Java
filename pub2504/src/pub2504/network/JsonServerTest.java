package pub2504.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonServerTest {

	public static void main(String[] args) {

		URI uri = null;
		URL url = null;
		URLConnection conn = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			uri = new URI("http://localhost:7777/todos");
			url = uri.toURL();
			conn = url.openConnection();

			if (conn != null) {
				is = conn.getInputStream();
				isr = new InputStreamReader(is);
				br = new BufferedReader(isr);
				String jsonStr = "";
				String lineStr = "";
				while ((lineStr = br.readLine()) != null) {
					jsonStr += lineStr;
				}

				// gson 라이브러리를 통해 json 문자열을 자바객체로(List<Todo>)로 변환 후 출력
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				List<Todo> todoList = gson.fromJson(jsonStr, new TypeToken<List<Todo>>() {
				}.getType());

				todoList.stream().forEach(System.out::println);
			}

		} catch (URISyntaxException urise) {
			urise.printStackTrace();
		} catch (MalformedURLException murle) {
			murle.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	} // main
} // class

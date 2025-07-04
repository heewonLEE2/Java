package pub2504.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.MalformedInputException;

public class URLTest {

	public static void main(String[] args) {

		URI uri = null;
		URL url = null;
		URLConnection conn = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {

			uri = new URI("https://news.naver.com/"); // URI 객체 생
			url = uri.toURL(); // URL 로 변환
			conn = url.openConnection(); // URLConnection 획득
			
			if (conn != null) { // 연결 되었다면
				is = conn.getInputStream(); // InputStream 획득
				isr = new InputStreamReader(is); // Reader 획득
				br = new BufferedReader(isr); // BufferedReader 획득

				StringBuilder sb = new StringBuilder();
				String lineStr = "";
				while ((lineStr = br.readLine()) != null) { // 읽어들인 라인이 있다면 화면에 출력
					sb.append(lineStr).append("\n");
				}
				
				System.out.println(sb);
			}

		} catch (URISyntaxException urise) {
			urise.printStackTrace();
		} catch (MalformedInputException murle) {
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

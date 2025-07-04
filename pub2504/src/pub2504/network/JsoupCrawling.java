package pub2504.network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/*
	[Jsoup 라이브러리]
		- mvnrepository.com 에서 jsoup.jar 다운로드
		- Java 기반의 HTML 파싱 및 웹 크롤링 라이브러리
		- 웹페이지를 크롤링하고 DOM을 탐색 및 조작하는데 사용
		- BeautifulSoup 의 자바 버전
		- 주요 기능 : HTML 파싱, DOM 탐색/조작, 데이터 추출, POST/GET 요청 
 */

public class JsoupCrawling {

	public static void main(String[] args) {

		// 학원 홈페이지내 웹페이지 이미지 가져오기
		String koreaUrl = "http://www.koreaisacademy.com/curriculum/app/app.asp";

		try {

			int interval = (int) (Math.random() * 1000) + 1500;

			Document docKorea = Jsoup.connect(koreaUrl).userAgent("Mozilla/5.0 (Windosw NT 10.0; Win64; x64)")
					.timeout(interval).get();

			Elements images = docKorea.select("img");

			for (Element image : images) {
				System.out.println(image.absUrl("src"));
				imagePrint(image.absUrl("src"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	} // main

	// 이미지 저장 메소드
	private static void imagePrint(String imageSrc) {
		String fileName = imageSrc.substring(imageSrc.lastIndexOf(".") + 1); // 파일 이름
		
		File file = new File("C:\\pub2504\\files\\koreaitimage\\");

		// jpg, png 일때만 파일 저장
		if (imageSrc.endsWith("jpg") || imageSrc.endsWith("png")) {

			try {
				// url 설정 및 connection 연걸
				URL url = new URI(imageSrc).toURL();
				URLConnection conn = url.openConnection();

				// 연결된 conn 에서 inputStream 가져오기
				BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
				byte[] b = bis.readAllBytes();

				BufferedOutputStream bos = new BufferedOutputStream(
						new FileOutputStream(file + imageSrc.substring(imageSrc.lastIndexOf("/"))));

				bos.write(b);
				bos.flush();

				bis.close();
				bos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // if
	} // imagePrint
} // class

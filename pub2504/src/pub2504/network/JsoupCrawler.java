package pub2504.network;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;

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

public class JsoupCrawler {

	public static void main(String[] args) {

		// HTML 문자열 파싱
		String html = "<html><body><h1>안녕!</h1><p>좋은 아침!</p></body></html>";

		// Document 객체 얻기
		Document doc = Jsoup.parse(html); // HTML 문자열 파싱해서 Document 객체 생성

		Element h1 = doc.selectFirst("h1"); // 첫번째 h1 엘리먼트
		System.out.println("제목 : " + h1.text());

		Element p = doc.selectFirst("p"); // 첫번째 p 엘리먼트
		System.out.println("내용 : " + p.text());

		// 웹페이지 크롤링
		String url = "https://news.naver.com/breakingnews/section/103/237";

		try {
			int interval = (int)(Math.random()*1000) +1500;
			
			Document docNews = Jsoup.connect(url)
					 // userAgent 설정 웹에서 봇으로 인지하고 정보를 안줄 수 있기 때문에 설정
					.userAgent("Mozilla/5.0 (Windosw NT 10.0; Win64; x64)")
					.timeout(interval) // 5초간 딜레이 (사람인것 처럼...)(일정한 간격으로 요청을 하면 의심함 interval 을 이용)
					.get(); // URL 연결해서 Document 객체 생성
			// strong Elements 중에서 클래스가 sa_text_strong인 엘리먼트들
			Elements titles = docNews.select("strong.sa_text_strong");
			for (Element title : titles) {
//				System.out.println("제목 : " + title.text());
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		// 학원 홈페이지내 웹페이지 이미지 가져오기
		String koreaUrl = "http://www.koreaisacademy.com/curriculum/app/app.asp";
		
		// 이미지 처리 사용
		BufferedImage bi= null;
		URL imgUrl = null;
		HttpURLConnection conn = null;
		InputStream is = null;
		OutputStream os = null;
		
		
		try {
			
			int interval = (int)(Math.random()*1000) +1500;
			
			Document docKorea = Jsoup.connect(koreaUrl)
					.userAgent("Mozilla/5.0 (Windosw NT 10.0; Win64; x64)")
					.timeout(interval) 
					.get();
			Elements images = docKorea.select("img");
			
			for(int i=0; i< images.size(); i++) {
				
				try {
					String src = images.get(i).absUrl("src");
					
					imgUrl= new URL(src);
					//System.out.println(imgUrl);
					// URL 에서 connection 을 연결해서 inputStream을 가져와서 바이트에 저장
					conn = (HttpURLConnection) imgUrl.openConnection();
					is = conn.getInputStream();
					byte b[] = is.readAllBytes();
					
					// 파일 저장 형식
					FileOutputStream outFile = new FileOutputStream("C:\\pub2504\\files\\koreaitimage"
							+ "\\"+ src.substring(src.lastIndexOf("/")+1));
					outFile.write(b);
					outFile.flush();
					
					// buffered 이미지 사용
//					conn.setRequestProperty("Referer", src);
//					bi = ImageIO.read(conn.getInputStream());
//					
//					FileOutputStream outFile
//					= new FileOutputStream("C:\\pub2504\\files\\koreaitimage\\image_" +(i+1) + ".png");
//					
//					ImageIO.write(bi, "png" , outFile);
					
				} catch(Exception urise) {
					urise.printStackTrace();
				}
			}
			// 실습 : 이미지들을 C:\\pub2504\\files\\koreaitimage 폴더에 저장 
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			try {
				is.close();
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		
	} // main
} // class
























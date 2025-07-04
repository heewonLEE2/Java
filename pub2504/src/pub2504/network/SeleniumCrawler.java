package pub2504.network;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Selenium
// https://www.selenium.dev/downloads/  => selenium 다운, API 페이지
// zip 파일 다운로드 => 압축 해제 => jar 추출
// build path 에 jar 들을 추가
// Chrome Driver 설치(https://storage.googleapis.com/chrome-for-testing-public/138.0.7204.92/win64/chromedriver-win64.zip) 다운 링크
// driver 폴더에 exe 파일 옮기기

public class SeleniumCrawler {

	public static void main(String[] args) {

		// 크롬 드라이버 경로 설정 (시스템 설정 chromedriver 위치 설정)
		System.setProperty("webdriver.chrome.driver", "C:\\pub2504\\driver\\chromedriver.exe");

		// 크롬드라이버 객체 생성
		WebDriver driver = new ChromeDriver();

		try {

			// 크롬 드라이버를 통해서 사이트 접속(연결)
			driver.get("https://pixabay.com/photos/");

			// 접속하는 시간동안 잠시 대기
			Thread.sleep(2000);

			// 모든 img 엘리먼트를 리스트로 획득
			List<WebElement> imageElements = driver.findElements(By.cssSelector("img"));

			// 모든 img 엘리먼트의 src 속성의 값 출력
			for (WebElement image : imageElements) {
				String src = image.getAttribute("src");
				if (src != null && !src.isEmpty()) {
					System.out.println("이미지 경로명 : " + src);
				}

			} // for(WebElement image : imageElements)

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			driver.quit(); // 드라이버 종료
		}

	} // main
} // class

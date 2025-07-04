package pub2504.network;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// [실습] Selenium 을 활용해서 직방(zigbang.com) 웹사이트내의
// 			역삼동 매매/전,월세 정보를 크롤링하여 매물명과 가격정보를
//			yeoksam.csv 로 저장

public class ExSeleniumLand {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\pub2504\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		PrintWriter pw = null;
		File file = new File("C:\\pub2504\\files\\yeoksam.csv");

		try {

			Map<String, String> yeoksamMap = new HashMap<String, String>();

			driver.get("https://www.zigbang.com/home/apt/items/11680101");
			Thread.sleep(2000);

			List<WebElement> nameList = new ArrayList<WebElement>();
			List<WebElement> priceList = new ArrayList<WebElement>();

			// 이름 정보
			for (int i = 2; i < 50; i++) {
				nameList.addAll(driver.findElements(
						By.cssSelector("#__next > div.sc-633280a0-0.gaWHVb > div > div.sc-f98dc6d6-2.gxoAju > "
								+ "div > div > div.css-1dbjc4n.r-150rngu.r-14lw9ot.r-eqz5dr.r-16y2uox.r-1wbh5a2.r-11yh6sk.r-1rnoaur.r-1sncvnh >"
								+ "div > div:nth-child(" + i + ") > div.css-1dbjc4n.r-1loqt21.r-1otgn73.r-lrvibr > "
								+ "div.css-1563yu1.r-1tyxmls.r-1wbh5a2.r-1w6e6rj.r-159m18f.r-1b43r93.r-b88u0q.r-rjixqe")));
			}
			// 가격정보
			for (int i = 2; i < 50; i++) {
				priceList.addAll(driver.findElements(By.cssSelector(
						"#__next > div.sc-633280a0-0.gaWHVb > div > div.sc-f98dc6d6-2.gxoAju > div > div > "
								+ "div.css-1dbjc4n.r-150rngu.r-14lw9ot.r-eqz5dr.r-16y2uox.r-1wbh5a2.r-11yh6sk.r-1rnoaur.r-1sncvnh > div > "
								+ "div:nth-child(" + i + ") > div.css-1dbjc4n.r-1loqt21.r-1otgn73.r-lrvibr > "
								+ "div.zuix2-tp-top16.zuix2-tp-right20.zuix2-tp-bottom16.zuix2-tp-left20.css-1dbjc4n.r-1awozwy > "
								+ "div.css-1dbjc4n.r-1mlwlqe.r-eqz5dr.r-16y2uox.r-1wbh5a2.r-1777fci > "
								+ "div.css-1563yu1.r-aw03qq.r-1wbh5a2.r-1w6e6rj.r-159m18f.r-1i10wst.r-b88u0q.r-vrz42v.r-fdjqy7.r-13wfysu.r-q42fyq.r-1ad0z5i")));
			}

			// 각 정보들 List 에 추가
			for (WebElement ele : nameList) {
				String eleName = ele.getText();
				System.out.println(eleName);
			}
			for (WebElement ele : priceList) {
				String elePrice = ele.getText();
				System.out.println(elePrice);
			}

			// Map 에 저장
			for (int i = 0; i < nameList.size(); i++) {
				yeoksamMap.put(nameList.get(i).getText(), priceList.get(i).getText());
			}

			// 파일 입력 stream생성
			pw = new PrintWriter(file, "UTF-8");

			// Map 에 잘 저장 되었는지 확인 파일에 쓰기
			Set<Map.Entry<String, String>> entrySet = yeoksamMap.entrySet();
			for (Map.Entry<String, String> entry : entrySet) {

				String line = entry.getKey() + "," + entry.getValue();
				// String entryName = entry.getKey();
				// String entryPrice = entry.getValue();
				// System.out.println("매물명 : " + entryName + " || 가격은 : " + entryPrice + "
				// 입니다.!" );
				pw.write(line + "\n");
				pw.flush();
				System.out.println("파일 저장이 완료 되었습니다.");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				driver.quit(); // 드라이버 종료
				pw.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	} // main
} // class

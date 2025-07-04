package pub2504.network;

import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.http.UrlPath;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// [Selenium 을 활용한 자동로그인]
// https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

public class SeleniumAutoLogin {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\pub2504\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Waiting 시간 설정
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			// 웹브라우져 시작하고 로딩
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

			// 접속하는 시간동안 잠시 대기
			Thread.sleep(3000);
			driver.manage().window().maximize();

			Thread.sleep(3000);
			// 아이디 입력 input 엘리먼트
			WebElement usernameInput = driver.findElement(By.name("username"));
			// 아이디 입력
			usernameInput.sendKeys("Admin");

			Thread.sleep(1000);
			// 패스워드 입력 input 엘리먼트
			WebElement userpasswordInput = driver.findElement(By.name("password"));
			// 패스워드 입력
			userpasswordInput.sendKeys("admin123");

			Thread.sleep(1000);
			// 로그인 btn 엘리먼트
			WebElement loginBtn = driver.findElement(By.className("oxd-button"));
			loginBtn.click();

			Thread.sleep(3000);

			// [실습] 사용자 추가
			// 1. 페이지 이동
			// https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser
			// 2. Username 입력, User Role 선택, Employee Name 입력, Status 선택 후
			// 3. Add 눌러서 사용자 추가

			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser");
			Thread.sleep(3000);

			// User role 선택 클릭
			driver.findElement(By.cssSelector(".oxd-select-text--arrow")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("div.oxd-select-dropdown")).click();
			Thread.sleep(1000);

			// Employee Name 입력
			WebElement employeeInput = driver.findElement(By.cssSelector(
					"div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(2) > div > div:nth-child(2) > div > div > input"));
			employeeInput.sendKeys("a");
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.oxd-autocomplete-dropdown")))
					.click();

			// status 선택 클릭
			driver.findElement(By.cssSelector(
					"#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(3) > div > div:nth-child(2) > div > div"))
					.click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("div.oxd-select-dropdown")).click();
			Thread.sleep(1000);

			// Username 입력
			WebElement regiUserNameInput = driver.findElement(By.cssSelector(
					"div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(4) > div > div:nth-child(2) > input"));
			regiUserNameInput.sendKeys("heewser12");
			Thread.sleep(1000);

			// password 등록 input
			WebElement regipasswordInput = driver.findElement(By.cssSelector(
					"#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-row.user-password-row > div > div.oxd-grid-item.oxd-grid-item--gutters.user-password-cell > div > div:nth-child(2) > input"));
			regipasswordInput.sendKeys("admin1234");
			Thread.sleep(1000);
			WebElement regipasswordCheckInput = driver.findElement(By.cssSelector(
					"#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-row.user-password-row > div > div:nth-child(2) > div > div:nth-child(2) > input"));
			regipasswordCheckInput.sendKeys("admin1234");
			Thread.sleep(1000);

			// save 버튼 클릭
			driver.findElement(By.cssSelector(
					"#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"))
					.click();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// driver.quit(); // 드라이버 종료
		}

	} // main
} // class

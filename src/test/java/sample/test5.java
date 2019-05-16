package sample;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test5 {

	public WebDriver driver = null;
	public String appURL = "https://google.com";

	@Parameters("browsername")

	@BeforeTest
	public void testSetUp(String bname) {

		Date d = new Date();

		System.out.println("bname is " + bname + " " + d);
		System.out.println("thread id is " + Thread.currentThread().getId());

		if (bname.equalsIgnoreCase("chrome")) {
			// WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (bname.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

	}

	@Test(enabled = true)
	public void verifyTittle() throws InterruptedException {

		driver.navigate().to(appURL);
		String getTitle = driver.getTitle();
		System.out.println(getTitle);

	}

	/*
	 * @Test(enabled = true) public void verifyTittle1() throws InterruptedException
	 * {
	 * 
	 * driver.get("https://preapp.avlview.com"); String getTitle =
	 * driver.getTitle(); System.out.println(getTitle);
	 * 
	 * }
	 */

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

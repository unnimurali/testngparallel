package sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test1 {

	public WebDriver driver = null;
	public String appURL = "https://preapp.avlview.com";

	@Parameters("browsername")

	@BeforeTest
	public void testSetUp(String bname) {

		System.out.println("bname is " + bname);
		System.out.println("thread id is " + Thread.currentThread().getId());

		if (bname.equalsIgnoreCase("chrome")) {
			// WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (bname.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

	}

	@Test(enabled = true)
	public void verifyTittle() throws InterruptedException {

		// WebDriverManager.chromedriver().version("2.40").arch32().proxy("192.168.1.224:8080").setup();

		// driver.get("https://google.com");
		// Thread.sleep(3000);
		driver.navigate().to(appURL);
		String getTitle = driver.getTitle();
		System.out.println(getTitle);
		// Assert.assertEquals(getTitle, "Google");
		// driver.quit();

	}

	/*
	 * @Test(enabled = true) public void verifyTittle1() {
	 * 
	 * driver.navigate().to(appURL); String getTitle = driver.getTitle();
	 * System.out.println(getTitle); // Assert.assertEquals(getTitle, "Google");
	 * driver.quit();
	 * 
	 * }
	 */

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

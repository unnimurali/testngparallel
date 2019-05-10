package sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test2 {

	// public WebDriver driver = null;
	// public String appURL = "https://preapp.avlview.com";

	@Test(enabled = true)
	public void verifyTittle() throws InterruptedException {

		System.out.println("thread id is " + Thread.currentThread().getId());

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// driver.get("https://google.com");
		// driver.navigate().to(appURL);
		driver.get("https://preapp.avlview.com");
		// Thread.sleep(3000);
		String getTitle = driver.getTitle();
		System.out.println(getTitle);
		// Assert.assertEquals(getTitle, "Google");
		// driver.quit();
		driver.close();

	}

	@Test(enabled = true)
	public void verifylogin() throws InterruptedException {

		System.out.println("thread id is " + Thread.currentThread().getId());

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://google.com");
		// driver.navigate().to(appURL);
		// Thread.sleep(3000);
		String getTitle = driver.getTitle();
		// String getTitle = driver.findElement(By.xpath("//span[text()='Sign
		// in']")).getText();
		System.out.println(getTitle);
		// Assert.assertEquals(getTitle, "Google");
		// driver.quit();
		driver.close();

	}

	/*
	 * @AfterTest public void tearDown() { driver.close(); }
	 */

}

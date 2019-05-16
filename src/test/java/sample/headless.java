package sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class headless {

	@Test(enabled = true)
	public void verifyTittle() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("headless");

		WebDriver driver = new ChromeDriver(opt);

		driver.get("https://preapp.avlview.com");

		String getTitle = driver.getTitle();
		System.out.println(getTitle);

		driver.close();
		driver.quit();

	}

}

package sample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test3 {

	public WebDriver driver = null;
	public String appURL = "https://preapp.avlview.com";

	public static final String uname = "tranqtesting2";
	public static final String akey = "8f7698b8-7704-4be4-be71-13d1f9c6ba0c";

	// public static final String url = "https://" + uname + ":" + akey +
	// "@ondemand.saucelabs.com:443/wd/hub";
	public static final String url = "https://" + uname + ":" + akey + "@ondemand.saucelabs.com/wd/hub";

	@Parameters({ "browsername", "version", "platform" })

	@BeforeClass
	public void testSetUp(String bname, String version, String platform) throws MalformedURLException {

		System.out.println("bname is " + bname);
		System.out.println("thread id is " + Thread.currentThread().getId());

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("browserName", bname);
		dc.setCapability("version", version);
		dc.setCapability("platform", platform);
		System.out.println(url);
		driver = new RemoteWebDriver(new URL(url), dc);

	}

	@Test(enabled = true)
	public void verifyTittle() throws InterruptedException {

		driver.navigate().to(appURL);
		String getTitle = driver.getTitle();
		System.out.println(getTitle);
		Assert.assertEquals(getTitle, "Version 7.0.4");
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

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}

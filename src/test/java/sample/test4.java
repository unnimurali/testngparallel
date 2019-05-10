package sample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class test4 {

	private WebDriver driver;

	@Test
	public void shouldOpenChrome() throws MalformedURLException {

		String sauceUserName = "tranqtesting2";
		String sauceAccessKey = "c4f42f39-ad30-4720-929b-05a5a4b2e8dc";
		String sauceURL = "https://" + sauceUserName + ":" + sauceAccessKey + "@ondemand.saucelabs.com/wd/hub";

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("username", sauceUserName);
		capabilities.setCapability("accessKey", sauceAccessKey);
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("platform", "Windows 10");
		capabilities.setCapability("version", "59.0");
		capabilities.setCapability("build", "Onboarding Sample App - Java-TestNG");
		capabilities.setCapability("name", "3-cross-browser");
		capabilities.setCapability("tunnelIdentifier", "demo-java-tunnel");

		driver = new RemoteWebDriver(new URL(sauceURL), capabilities);
		/**
		 * Don't forget to enter in your application's URL in place of
		 * 'https://www.saucedemo.com'.
		 */
		driver.navigate().to("https://www.saucedemo.com");
		Assert.assertTrue(true);

	}

	/**
	 * Below we are performing 2 critical actions. Quitting the driver and passing
	 * the test result to Sauce Labs user interface.
	 */
	@AfterMethod
	public void cleanUpAfterTestMethod(ITestResult result) {
		((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
		driver.quit();
	}

}

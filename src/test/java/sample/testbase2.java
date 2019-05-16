package sample;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class testbase2 {

	private RemoteWebDriver driver;

	public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();

	public WebDriver getdriver() {
		return dr.get();
	}

	public void setWebDriver(RemoteWebDriver driver) {
		dr.set(driver);
	}

	public void openbrowsers(String browser) throws MalformedURLException {
		/*
		 * if (browser.equalsIgnoreCase("chrome")) { //
		 * WebDriverManager.chromedriver().setup();
		 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
		 * + "\\src\\main\\resources\\drivers\\chromedriver.exe"); driver = new
		 * ChromeDriver(); } else if (browser.equalsIgnoreCase("ff")) {
		 * System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
		 * "\\src\\main\\resources\\drivers\\geckodriver.exe"); driver = new
		 * FirefoxDriver();
		 * 
		 * }
		 */

		Date d = new Date();

		System.out.println("bname is " + browser + " " + d);

		DesiredCapabilities dc = null;
		if (browser.equalsIgnoreCase("ff")) {
			dc = DesiredCapabilities.firefox();
			dc.setBrowserName("firefox");
			dc.setPlatform(Platform.ANY);
		} else if (browser.equalsIgnoreCase("chrome")) {
			dc = DesiredCapabilities.chrome();
			dc.setBrowserName("chrome");
			dc.setPlatform(Platform.ANY);
		}

		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);

		setWebDriver(driver);

	}

	public void quit() {
		getdriver().quit();
	}

}

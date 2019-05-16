package sample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class gridtest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);

		ChromeOptions opt = new ChromeOptions();
		opt.merge(cap);

		String huburl = "http://192.168.0.16:4444/wd/hub";

		WebDriver drv = new RemoteWebDriver(new URL(huburl), opt);

		drv.get("https://google.com");

		System.out.println(drv.getTitle());

		drv.quit();

	}

}

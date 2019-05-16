package sample;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test6 extends testbase1 {

	@Parameters("browsername")
	@BeforeMethod
	public void beforeMethod(String browser) throws MalformedURLException {
		long id = Thread.currentThread().getId();
		System.out.println("Before test-method. Thread id is: " + id);
		openbrowsers(browser);

	}

	@Test
	public void testMethodsOne() {
		long id = Thread.currentThread().getId();
		System.out.println("Simple test-method One. Thread id is: " + id);

		getdriver().get("https://google.com");
		System.out.println(getdriver().getTitle());

		// driver.get("https://google.com");

	}

	@Test
	public void testMethodsTwo() {
		long id = Thread.currentThread().getId();
		System.out.println("Simple test-method Two. Thread id is: " + id);

		getdriver().get("https://cricbuzz.com");
		System.out.println(getdriver().getTitle());

	}

	@Test
	public void testMethodsThree() {
		long id = Thread.currentThread().getId();
		System.out.println("Simple test-method Three. Thread id is: " + id);

		getdriver().get("https://preapp.avlview.com");
		System.out.println(getdriver().getTitle());

	}

	@AfterMethod
	public void afterMethod() {
		long id = Thread.currentThread().getId();
		System.out.println("After test-method. Thread id is: " + id);
		quit();
	}

}

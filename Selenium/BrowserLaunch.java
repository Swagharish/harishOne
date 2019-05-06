package com.selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch {
	static WebDriver driver;

	public static void chromeLaunch() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\harish\\eclipse-workspace\\FirstTest\\Dirver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://www.facebook.com");
		driver.quit();

	}

	public static void fireFoxLaunch() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\harish\\eclipse-workspace\\FirstTest\\Dirver\\geckodriver.exe");
		driver = new FirefoxDriver();

	}

	public static void main(String[] args) throws Throwable {
		chromeLaunch();
		fireFoxLaunch();

	}
}

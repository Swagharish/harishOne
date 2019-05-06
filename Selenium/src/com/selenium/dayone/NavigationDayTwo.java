package com.selenium.dayone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDayTwo {

	public static void chromeLaunch() throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\harish\\eclipse-workspace\\Selenium\\Dirver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		// to launch application
		driver.get("https://www.google.com/");

		driver.manage().window().maximize();
		// navigate to
		driver.navigate().to("https://www.facebook.com/");
		// navigate back
		driver.navigate().back();
		// navigate forward
		driver.navigate().forward();
		// navigate refresh
		driver.navigate().refresh();
		// to get the page title
		String title = driver.getTitle();
		System.out.println("page title is" + title);
		// to get current URL
		String currenturl = driver.getCurrentUrl();
		System.out.println("current url is" + currenturl);
		// to get text from webelements
		// i[@class='fb_logo img sp_DM94Tzbs4_7 sx_0d58d6']
		WebElement fbheader = driver.findElement(By.xpath("//i[contains(@class,'fb_logo')]"));
		String text = fbheader.getText();
		System.out.println(text);
		// to get the vaules that are passed to the webelements
		WebElement Words = driver.findElement(By.xpath("//div[contains(@class,'_5iyx')]"));
		String attributes = Words.getAttribute("value");
		System.out.println(attributes);

	}

	public static void main(String[] args) throws Throwable {
		chromeLaunch();

	}

}

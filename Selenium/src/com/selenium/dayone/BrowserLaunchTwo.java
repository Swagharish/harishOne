package com.selenium.dayone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunchTwo {

	private static void chrome_Launch() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\harish\\eclipse-workspace\\Selenium\\Dirver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// To launch any application

		driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");

		// To Wait

		Thread.sleep(5000);

		// TO find element

		WebElement email = driver.findElement(By.id("identifierId"));

		// To pass values

		email.sendKeys("harishraj731@gmail.com");

		WebElement Next = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content"));

		Next.click();

		Thread.sleep(5000);

		WebElement password = driver.findElement(By.name("password"));

		password.sendKeys("8148181680");

		// driver.findElement(By.xpath("//span[@class=RveJvd snByac]"));
		// xpath //tagname [@attributename = attribute value]

		WebElement logIn = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]"));

		logIn.click();
	}

	public static void main(String[] args) throws Throwable {
		chrome_Launch();

	}
}

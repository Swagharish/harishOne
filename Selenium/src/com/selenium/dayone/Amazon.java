package com.selenium.dayone;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	public static void chromeLaunch() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\harish\\eclipse-workspace\\Selenium\\Dirver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(6000);

		WebElement search = driver.findElement(By.name("field-keywords"));
		search.sendKeys("Redmi 6");
		search.click();
		Thread.sleep(8000);

		String a = driver.getWindowHandle();
		System.out.println(a);

		WebElement Firstproduct = driver
				.findElement(By.xpath("//div[@id='resultsCol']/div/div/ul/li/div/div[2]/div/div[2]/div/div/a/h2"));
		Firstproduct.click();

		Thread.sleep(8000);
		Set<String> b = driver.getWindowHandles();
		System.out.println(b);
		String y = null;
		for (String x : b) {
			if (!x.equals(a)) {
				y = x;
			}
		}
		driver.switchTo().window(y);
		WebElement addtocart = driver.findElement(By.xpath("//input[@value='Add to Cart']"));
		addtocart.click();

	}

	public static void main(String[] args) throws Throwable {
		chromeLaunch();
	}
}

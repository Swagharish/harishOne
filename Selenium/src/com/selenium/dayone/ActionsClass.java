package com.selenium.dayone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {

	public static void chromeLaunch() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\harish\\eclipse-workspace\\Selenium\\Dirver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://artoftesting.com/sampleSiteForSelenium.html");
		Thread.sleep(5000);
		
		WebElement dblClick = driver.findElement(By.id("dblClkBtn"));
	//	WebElement drop = driver.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
		Actions ac = new Actions(driver);
		
//		ac.dragAndDrop(drag, drop).build().perform();
		
		ac.doubleClick(dblClick).build().perform();
	}

	public static void main(String[] args) throws Throwable {
		chromeLaunch();
	}

}

package com.selenium.dayone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonAddToCart {

	public static void chromeLaunch() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\harish\\eclipse-workspace\\Selenium\\Dirver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		Thread.sleep(5000);
		WebElement dresses = driver.findElement(By.xpath("(//a[text()='Dresses'])[2]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(dresses).build().perform();
		Thread.sleep(5000);
		// driver.findElement(By.xpath("(//a[@title='Casual Dresses'])[2]")).click();
		// Thread.sleep(5000);
		// driver.findElement(By.xpath("//img[@title='Printed Dress']")).click();
		// driver.findElement(By.xpath("//span[text()='Add to cart']")).click();
		WebElement casualdresses = driver.findElement(By.xpath("(//a[@title='Casual Dresses'])[2]"));
		casualdresses.click();
		Thread.sleep(5000);
		WebElement printeddresses = driver.findElement(By.xpath("//img[@title='Printed Dress']"));
		printeddresses.click();
		WebElement addtocart = driver.findElement(By.xpath("//span[text()='Add to cart']"));
		addtocart.click();

	}

	public static void main(String[] args) throws Throwable {
		chromeLaunch();
	}

}

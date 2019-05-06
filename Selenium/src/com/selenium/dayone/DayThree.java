package com.selenium.dayone;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DayThree {

	public static void chromeLaunch() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\harish\\eclipse-workspace\\Selenium\\Dirver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?id_product=3&controller=product");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		/*
		 * WebElement signin =
		 * driver.findElement(By.xpath("//a[contains(@title,'Log in')]"));
		 * signin.click();
		 */
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Add to cart']")).click();
		;
		/*
		 * WebElement Signin = driver.findElement(By.name("email")); JavascriptExecutor
		 * js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].scrollIntoView();", Signin);
		 * Thread.sleep(3000); WebElement Search =
		 * driver.findElement(By.name("search_query")); // JavascriptExecutor jx =
		 * (JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].scrollIntoView();", Search); WebElement Email
		 * = driver.findElement(By.id("email"));
		 * Email.sendKeys("harishraj111@gmail.com"); 
		 *   WebElement password =
		 * driver.findElement(By.name("passwd")); password.sendKeys("9884215616");
		 * WebElement LogIn = driver.findElement(By.name("SubmitLogin")); LogIn.click();
		 * WebElement dresses =
		 * driver.findElement(By.xpath("//a[@title='Dresses'][2]")); Actions x = new
		 * Actions(driver); x.moveToElement(dresses).build().perform();
		 * Thread.sleep(3000); WebElement casualdresses =
		 * driver.findElement(By.xpath("//a[@title='Casual Dresses'][2]"));
		 * casualdresses.click();
		 */

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs (OutputType.FILE);
		File DestFile = new File("C:\\Users\\harish\\eclipse-workspace\\Selenium\\Lib\\test.png");
		FileUtils.copyFile(srcFile, DestFile);

	}

	public static void main(String[] args) throws Throwable {
		chromeLaunch();
	}

}

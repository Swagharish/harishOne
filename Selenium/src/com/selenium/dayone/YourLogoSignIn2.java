package com.selenium.dayone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class YourLogoSignIn2 {

	public static void chrome_Launch() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\harish\\eclipse-workspace\\Selenium\\Dirver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	/*	WebElement sigin = driver.findElement(By.xpath("//a[@rel='nofollow']"));
		sigin.click();
		WebElement Id = driver.findElement(By.id("email_create"));
		Id.sendKeys("harishrghjkj731@gmail.com");
		WebElement createanaccount = driver.findElement(By.name("SubmitCreate"));
		createanaccount.click();
		Thread.sleep(4000);
		WebElement checkbox = driver.findElement(By.name("id_gender"));
		checkbox.click();
		WebElement firstname = driver.findElement(By.name("customer_firstname"));
		firstname.sendKeys("Harish");
		WebElement lastname = driver.findElement(By.id("customer_lastname"));
		lastname.sendKeys("Gunasekar");
		// WebElement Email = driver.findElement(By.name("email"));
		// Email.sendKeys("harishraj137@gmail.com");
		WebElement password = driver.findElement(By.id("passwd"));
		password.sendKeys("9884215616");
		WebElement days = driver.findElement(By.name("days"));
		WebElement month = driver.findElement(By.name("months"));
		WebElement year = driver.findElement(By.name("years"));

		Select dayDD = new Select(days);
		dayDD.selectByValue("4");
		
		Select monthDD = new Select(month);
		monthDD.selectByIndex(3);
		
		Select yearDD = new Select(year);
		yearDD.selectByVisibleText("2019  ");*/
		WebElement dresses = driver.findElement(By.xpath("(//a[@title='Dresses'])[2]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(dresses).build().perform();
		
		
	}

	public static void main(String[] args) throws Throwable {
		chrome_Launch();

	}

}

package com.selenium.dayone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YourLogoSignIn {

	public static void chrome_Launch() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\harish\\eclipse-workspace\\Selenium\\Dirver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement sigin = driver.findElement(By.xpath("//a[@rel='nofollow']"));
		sigin.click();
		WebElement Id = driver.findElement(By.id("email_create"));
		Id.sendKeys("harishraj111@gmail.com");
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
		WebElement Daysdrop = driver.findElement(By.id("uniform-days"));
		Daysdrop.click();
		WebElement days = driver.findElement(By.name("days"));
		days.sendKeys("24");
		days.click();
		WebElement monthdrop = driver.findElement(By.id("uniform-months"));
		monthdrop.click();
		WebElement month = driver.findElement(By.name("months"));
		month.sendKeys("November");
		month.click();
		WebElement yeardrop = driver.findElement(By.id("uniform-years"));
		yeardrop.click();
		WebElement year = driver.findElement(By.name("years"));
		year.sendKeys("2000");
		year.click();
		WebElement addressfirstname = driver.findElement(By.name("firstname"));
		addressfirstname.sendKeys("harish");
		WebElement addresslastname = driver.findElement(By.name("lastname"));
		addresslastname.sendKeys("gunasekar");
		WebElement company = driver.findElement(By.id("company"));
		company.sendKeys("greenstech");
		WebElement address = driver.findElement(By.id("address1"));
		address.sendKeys("No:1 annanagar");
		WebElement address2 = driver.findElement(By.name("address2"));
		address2.sendKeys("2nd avenue");
		WebElement cityname = driver.findElement(By.name("city"));
		cityname.sendKeys("Chennai");
		WebElement statedrop = driver.findElement(By.id("uniform-id_state"));
		statedrop.click();
		WebElement state = driver.findElement(By.name("id_state"));
		state.sendKeys("Indiana");
		state.click();
		WebElement postalcode = driver.findElement(By.name("postcode"));
		postalcode.sendKeys("60001");
		// WebElement code = driver.findElement(By.name("postcode"));
		// code.sendKeys("6000");
		WebElement countrydrop = driver.findElement(By.id("uniform-id_country"));
		countrydrop.click();
		WebElement country = driver.findElement(By.name("id_country"));
		country.sendKeys("United States");
		country.click();
		WebElement additionslinfo = driver.findElement(By.id("other"));
		additionslinfo.sendKeys("Nothing");
		WebElement homephone = driver.findElement(By.id("phone"));
		homephone.sendKeys("0448878857");
		WebElement mobilephone = driver.findElement(By.name("phone_mobile"));
		mobilephone.sendKeys("9884687878");
		// WebElement address3 = driver.findElement(By.id("alias"));
		// address3.sendKeys("annanagar");
		WebElement register = driver.findElement(By.name("submitAccount"));
		register.click();

	}

	public static void main(String[] args) throws Throwable {
		chrome_Launch();

	}

}

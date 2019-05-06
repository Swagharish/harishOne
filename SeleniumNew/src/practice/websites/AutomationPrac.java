package practice.websites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class AutomationPrac {
	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\harish\\eclipse-workspace\\SeleniumNew\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		WebElement mouseHover = driver.findElement(By.xpath("//img[@class='logo img-responsive']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(mouseHover).build().perform();

		Thread.sleep(2000);

		WebElement signIn = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
		signIn.click();

		WebElement email = driver.findElement(By.xpath("(//input[contains(@type,'text')])[2]"));
		email.sendKeys("harishraj@gmail.com");

		WebElement createanaccountbtn = driver
				.findElement(By.xpath("//button[@class='btn btn-default button button-medium exclusive']"));
		createanaccountbtn.click();

		Thread.sleep(3000);
		driver.quit();

	}

}

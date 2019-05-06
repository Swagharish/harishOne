package seperate.methods.practice;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.java.swing.plaf.windows.resources.windows;

public class AllConcepts {

	static WebDriver driver;

	public static void browserLaunch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\harish\\eclipse-workspace\\SeleniumNew\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static void waitForVisibiltyOfElement() {

		browserLaunch();
		// Get Url
		driver.get("https://www.facebook.com/");
		// Implicitlywait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// explicitlywait
		WebElement Email = driver.findElement(By.id("email"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(Email));

	}

	public static void mouseHover() throws Throwable {
		browserLaunch();
		driver.get("https://www.facebook.com/");
		// MouseHover
		WebElement Hover = driver.findElement(By.xpath("//a[@title='Go to Facebook home']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(Hover).build().perform();
		Thread.sleep(3000);

		// GetAtrributes
		String attribute = Hover.getAttribute("title");
		System.out.println(attribute);

		// GetText
		String gettext = Hover.getText();
		System.out.println(gettext);

		// GetCurrentUrl
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

	}

	public static void scrollDownAndUp() throws Throwable {
		browserLaunch();
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);

		// Normal method 1
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");

		// Normal method 1
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-100)");

		// using element method
		Thread.sleep(2000);
		WebElement up = driver.findElement(By.xpath("//a[@title='Go to Facebook home']"));
		js.executeScript("arguments[0].scrollIntoView();", up);

	}

	public static void sendandclick() throws Throwable {
		browserLaunch();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("harish");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.navigate().to("https://www.toolsqa.com/automation-practice-table/");

	}

	public static void dropDown() throws Throwable {
		browserLaunch();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement days = driver.findElement(By.id("day"));
		WebElement months = driver.findElement(By.id("month"));
		WebElement years = driver.findElement(By.id("year"));

		Select ab = new Select(days);
		ab.selectByIndex(1);

		Select ab1 = new Select(months);
		ab1.selectByValue("11");

		Select ab2 = new Select(years);
		ab2.selectByVisibleText("1996");

		driver.navigate().refresh();

		// Firstselectedopton
		WebElement months1 = driver.findElement(By.id("month"));
		Select ab3 = new Select(months1);
		WebElement firstSelectedOpt = ab3.getFirstSelectedOption();
		System.out.println(firstSelectedOpt.getText());

		// GetOptions
		Thread.sleep(3000);
		List<WebElement> opt = ab3.getOptions();
		for (WebElement allopt : opt) {
			System.out.println(allopt.getText());
		}

		// RadioButtons
		Thread.sleep(3000);
		driver.findElement(By.id("u_0_9")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		WebElement male = driver.findElement(By.id("u_0_a"));
		male.click();

	}

	public static void takeScreenShotPic() throws Throwable {

		browserLaunch();
		driver.get("https://www.facebook.com/");
		TakesScreenshot x = (TakesScreenshot) driver;
		File source = x.getScreenshotAs(OutputType.FILE);
		File save = new File("C:\\Users\\harish\\eclipse-workspace\\SeleniumNew\\Dummy\\photo.png");
		FileUtils.copyFile(source, save);

	}

	public static void doubleClickContextClickAndRobotClass() throws Throwable {
		browserLaunch();
		driver.get("https://www.facebook.com/");
		WebElement DD = driver.findElement(By.name("birthday_day"));

		WebDriverWait a = new WebDriverWait(driver, 5);
		a.until(ExpectedConditions.visibilityOf(DD));

		Actions ab = new Actions(driver);
		ab.doubleClick(DD).build().perform();
		driver.navigate().refresh();
		

		//driver.navigate().refresh();
		//driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		Thread.sleep(3000);
		Actions ab1 = new Actions(driver);
		ab1.contextClick(DD).build().perform();

	}

	public static void main(String[] args) throws Throwable {
		// browserLaunch();
		// waitForVisibiltyOfElement();
		// mouseHover();
		// scrollDownAndUp();
		// sendandclick();
		// dropDown();
		// takeScreenShotPic();
		doubleClickContextClickAndRobotClass();

	}
}

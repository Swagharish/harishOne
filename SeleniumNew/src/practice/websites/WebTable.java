package practice.websites;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void printAllDatas() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\harish\\eclipse-workspace\\SeleniumNew\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.toolsqa.com/automation-practice-table/");
		// driver.get("https://www.toolsqa.com/automation-practice-table/");
		driver.manage().window().maximize();

		List<WebElement> Trows = driver.findElements(By.tagName("tr"));
		for (WebElement rows : Trows) {
			List<WebElement> Tdata = driver.findElements(By.tagName("td"));

			for (WebElement datas : Tdata) {
				System.out.println(datas.getText());

			}
			break;
		}
		driver.close();
	}

	public static void printParticularValue() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\harish\\eclipse-workspace\\SeleniumNew\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.toolsqa.com/automation-practice-table/");
		driver.manage().window().maximize();
		// WebElement singleData =
		// driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr[2]/td[1]"));
		// System.out.println(singleData.getText());

		String s = driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr[2]/td[1]")).getText();
		System.out.println(s);
	}

	public static void main(String[] args) {
		printAllDatas();
		printParticularValue();

	}

}

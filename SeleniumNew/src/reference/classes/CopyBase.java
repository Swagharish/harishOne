package reference.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.helper.FileReaderManager;

public class CopyBase {

	public static WebDriver driver;

	public static WebDriver browerLaunch(String browerName) throws Exception {

		try {
			if (browerName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\reource\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (browerName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\reource\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browerName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\src\\test\\reource\\Drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} else {
				throw new Exception("Browser name id not valid");
			}

			return driver;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void getUrl(String url) throws Throwable {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			// int implicitWait =
			// FileReaderManager.getInstance().getConfigReader().getImplicitWait();
			// driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static boolean elementDisplayed(WebElement element) {
		boolean displayed = false;
		try {
			displayed = element.isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
		return displayed;

	}

	public static boolean elementEnabled(WebElement element) {
		try {
			boolean enabled = element.isEnabled();
			return enabled;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static boolean elementSelected(WebElement element) {
		try {
			boolean selected = element.isSelected();
			return selected;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void waituntilElementVisibility(WebElement element) {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 50);
			wb.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void elementClear(WebElement element) {
		try {
			waituntilElementVisibility(element);
			if (elementDisplayed(element) && elementEnabled(element)) {
				element.clear();

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void inputValuestoElement(WebElement element, String value) {
		try {
			waituntilElementVisibility(element);
			if (elementDisplayed(element) && elementEnabled(element)) {
				elementClear(element);
				element.sendKeys(value);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void elementClick(WebElement element) {
		try {
			waituntilElementVisibility(element);
			element.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static String getElementText(WebElement element) {
		try {
			waituntilElementVisibility(element);
			String text = element.getText();
			return text;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static String getElementTextAttribute(WebElement element) {
		try {
			waituntilElementVisibility(element);
			String attribute = element.getAttribute("value");
			return attribute;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static String getTitle() {
		try {
			String title = driver.getTitle();
			return title;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void selectValuesfromDD(WebElement element, String options, String value) {
		try {
			waituntilElementVisibility(element);
			Select sc = new Select(element);
			if (options.equalsIgnoreCase("value")) {
				sc.selectByValue(value);
			} else if (options.equalsIgnoreCase("visibletext")) {
				sc.selectByVisibleText(value);
			} else if (options.equalsIgnoreCase("index")) {
				sc.selectByIndex(Integer.parseInt(value));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void movetoElement(WebElement element) {
		try {
			waituntilElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.moveToElement(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public void dragAndDrop(WebElement source, WebElement target) {
		try {
			waituntilElementVisibility(source);
			Actions ac = new Actions(driver);
			ac.dragAndDrop(source, target).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void doubleClick(WebElement element) {
		try {
			waituntilElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.doubleClick(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void contextClick(WebElement element) {
		try {
			waituntilElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.contextClick(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void elementClickusingActions(WebElement element) {
		try {
			waituntilElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.click(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void elementinputValuesusingActions(WebElement element, String value) {
		try {
			waituntilElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.sendKeys(element, value).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public void scrollUpandScrollDownusingElement(WebElement element) {
		try {
			waituntilElementVisibility(element);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void scrollUpandDownusingCoordinates(String width, String height) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(" + width + "," + height + ")");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static File takeScreenShot(String fileName) throws IOException {
		try {
			File f = new File(System.getProperty("user.dir") + "\\src\\test\\reource\\library\\" + fileName + ".png");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File temp = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(temp, f);
			return f;

		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void scrolltoBottomPage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void waitforAlertISPresent() {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 50);
			wb.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void simpleAlert() {
		try {
			waitforAlertISPresent();
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void confirmAlert(String option) {
		try {
			waitforAlertISPresent();
			Alert alert = driver.switchTo().alert();
			if (option.equalsIgnoreCase("confirm")) {
				alert.accept();
			} else if (option.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void promptAlert(String options, String values) {
		try {
			waitforAlertISPresent();
			Alert alert = driver.switchTo().alert();
			if (options.equalsIgnoreCase("confirm")) {
				alert.sendKeys(values);
				alert.accept();

			} else if (options.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}

	}

	public static void navigationtoUrl(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void navigationCommands(String options) {
		try {
			if (options.equalsIgnoreCase("back")) {
				driver.navigate().back();
			} else if (options.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			} else if (options.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void switchtoIframe(String options, Object value) {
		try {
			if (options.equalsIgnoreCase("index")) {
				driver.switchTo().frame(Integer.parseInt((String) value));
			} else if (options.equalsIgnoreCase("name")) {
				driver.switchTo().frame((String) value);
			} else if (options.equalsIgnoreCase("element")) {
				driver.switchTo().frame((WebElement) value);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void switchtoDefualtContent() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void switchtoSecondWindow() {
		try {
			String cId = driver.getWindowHandle();
			Set<String> pId = driver.getWindowHandles();
			for (String x : pId) {
				if (!x.equals(cId)) {
					driver.switchTo().window(x);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void switchtoMultipleWindow(int index) {
		try {
			String cId = driver.getWindowHandle();
			Set<String> pId = driver.getWindowHandles();
			List<String> li = new ArrayList<String>();
			li.addAll(pId);
			driver.switchTo().window(li.get(index));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}

	}

	public static void getValuesfromWebtable(String element, int i) {
		try {
			WebElement table = driver.findElement(By.xpath(element));
			List<WebElement> findElements = table.findElements(By.xpath("//tr[0]//td[" + i + "]"));
			for (WebElement x : findElements) {
				System.out.println(x.getText());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static String getValuesfromExcel(String fileName, String sheetname, int rownum, int cellnum)
			throws Throwable {

		try {
			File f = new File(System.getProperty("user.dir") + "\\src\\test\\reource\\library\\" + fileName + ".xlsx");
			FileInputStream fin = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fin);
			Sheet sheet = wb.getSheet(sheetname);
			Cell cell = sheet.getRow(rownum).getCell(cellnum);
			CellType cellType = cell.getCellType();
			String string = null;
			if (cellType.equals(CellType.STRING)) {
				string = cell.getStringCellValue();
			} else if (cellType.equals(CellType.NUMERIC)) {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				string = String.valueOf(l);
			}
			return string;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}

	}

	public static void setValuetoExcel(String fileName, String sheetname, int rownum, int cellnum, String value) {

		try {
			File f = new File(System.getProperty("user.dir") + "\\src\\test\\reource\\library\\" + fileName + ".xlsx");
			FileInputStream fin = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fin);
			Sheet sheet = wb.getSheet(sheetname);
			Cell cell = sheet.getRow(rownum).getCell(cellnum);
			if (cell == null) {
				Cell createCell = sheet.getRow(rownum).createCell(cellnum);
				createCell.setCellValue(value);
			} else {
				cell.setCellValue(value);
			}
			FileOutputStream fout = new FileOutputStream(f);
			wb.write(fout);
			fout.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}

	}

	public static String jdbcConnection(int key, String dbName, String userName, String password, String query)
			throws Throwable {
		Map<Integer, String> mpData = new HashMap<Integer, String>();
		// String dbName = "jdbc:mysql://localhost:3306/credentials";
		// String userName = "root";
		// String password = "secret";
		// String query ="SELECT * FROM credentials.userdatas";
		// Initiate driver
		Class.forName("com.mysql.jdbc.Driver");
		// get connection
		Connection con = DriverManager.getConnection(dbName, userName, password);
		// create statement
		Statement createStatement = con.createStatement();
		// execute query
		ResultSet resultSet = createStatement.executeQuery(query);
		// result set
		while (resultSet.next()) {
			String uN = resultSet.getString(1);
			String pW = resultSet.getString(2);
			String id = resultSet.getString(3);
			mpData.put(Integer.parseInt(id), uN + "=" + pW);
		}
		String string = mpData.get(key);
		con.close();

		return string;

	}

	public static void driverQuit() {
		driver.quit();
	}

}

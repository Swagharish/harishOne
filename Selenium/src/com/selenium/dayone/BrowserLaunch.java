package com.selenium.dayone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch {
	
	public static void chrome_Launch() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\harish\\eclipse-workspace\\Selenium\\Dirver\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("http://wallpaperwide.com/");
	
	}  
	
	public static void main(String[] args) {
		chrome_Launch();
	}
	

}

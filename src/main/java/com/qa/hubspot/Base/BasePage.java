package com.qa.hubspot.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	 public WebDriver driver;
	public  Properties prop;
	public static ThreadLocal<WebDriver> tdriver=new ThreadLocal<WebDriver>();
	
	public WebDriver intialize_driver(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\katta\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		tdriver.set(driver);
		return getDriver(); 
		
		}
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}
	public Properties intialize_Properties(){
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("C:\\Users\\katta\\workspace\\RivisionPageObjectModel\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("C:\\Users\\katta\\chromedriver.exe") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}
	
	
	
	
	
	
	
	
	
	

}

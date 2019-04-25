package com.qa.huspot.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.Constants.Constants;
import com.qa.hubspot.Pages.HomePage;
import com.qa.hubspot.Pages.LoginPage;
import com.qa.hubspot.Pages.ProfileAndPreferencesPage;

public class ProfileAndPreferencesPageTest {
	
	public BasePage basepage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginpage;
	public HomePage homepage;
	public ProfileAndPreferencesPage profilepage;
	
	@BeforeMethod
	public void setUp(){
		basepage=new BasePage();
		prop=basepage.intialize_Properties();
		driver=basepage.intialize_driver();
		driver.get(prop.getProperty("url"));
		loginpage=new LoginPage(driver);
		homepage=loginpage.login(prop.getProperty("username_app"),prop.getProperty("password_app"));
		profilepage=homepage.getUserLink();
	
	}
	@Test(priority=3)
	public void verifygetProfileAndPreferencesPageTitleTest(){
		String title=profilepage.getProfileAndPreferencesPageTitle();
	System.out.println("the profile and preferences page title is:"+title);
	Assert.assertEquals(title,Constants.PROFILE_PAGE_TITLE);
	}
	@Test(priority=2)
	public void verifygetProfileAndPreferencesPageTextTest(){
		String text=profilepage.getProfileAndPreferencesPageText();
		System.out.println(text);
	Assert.assertEquals(text,"Profile & Preferences");
	}
	@Test(priority=1)
	public void verifygetNaveenNameElementTextTest(){
	String elementText=profilepage.getNaveenNameElementText();
	System.out.println("the Element text is:"+elementText);
	Assert.assertEquals(elementText,"Naveen Test");
		}
	
	
	@AfterMethod
	public void closeTheBrowser(){
		driver.quit();
	}
	
	
	
	

}

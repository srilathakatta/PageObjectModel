package com.qa.huspot.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.Constants.Constants;
import com.qa.hubspot.Pages.ContactsPage;
import com.qa.hubspot.Pages.HomePage;
import com.qa.hubspot.Pages.LoginPage;
import com.qa.hubspot.Pages.ProfileAndPreferencesPage;

public class HomeTest {
	public BasePage basepage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginpage;
	public HomePage homepage;
	public ProfileAndPreferencesPage profilepage;
	public ContactsPage contactspage;
	
	@BeforeMethod
	public void setUp(){
		basepage=new BasePage();
		prop=basepage.intialize_Properties();
		driver=basepage.intialize_driver();
		driver.get(prop.getProperty("url"));
		loginpage=new LoginPage(driver);
		
		homepage=loginpage.login(prop.getProperty("username_app"),prop.getProperty("password_app"));
	}
	@Test
	public void verifyContactsTabTest(){
		contactspage=homepage.getContactsLink();
	}
@Test
	public void verifygetHomaPageTitleTest(){
		String title=homepage.getHomaPageTitle();
		System.out.println("home page title is:"+title);
		Assert.assertEquals(title,Constants.HOME_PAGE_TITLE);
	}
@Test
	public void verifygetUserLinkTest(){
		profilepage=homepage.getUserLink();
		
}

	@AfterMethod
	public void closeTheBrowser(){
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

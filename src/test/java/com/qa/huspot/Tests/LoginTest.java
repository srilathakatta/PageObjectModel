package com.qa.huspot.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.Constants.Constants;
import com.qa.hubspot.Pages.LoginPage;

public class LoginTest {
	public BasePage basepage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginpage;
	
	@BeforeMethod
	public void setUp(){
		basepage=new BasePage();
		prop=basepage.intialize_Properties();
		driver=basepage.intialize_driver();
		driver.get(prop.getProperty("url"));
		loginpage=new LoginPage(driver);
		
		}
	@Test
	public void verifygetLoginPageTitleTest(){
		String title=loginpage.getLoginPageTitle();
	System.out.println("login page title is:"+title);
	Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
	
	}
	@Test
	public void verifySignInWithGoogleTest(){
		Assert.assertTrue(loginpage.verifySignInWithGoogle());
		String text=loginpage.getSignInWithGoogleText();
		System.out.println("the text is:"+text);
		Assert.assertEquals(text,Constants.LOGIN_PAGE_TEXT);
	}
	
	@Test
	public void verifyPrivacyPolicyTest(){
		Assert.assertTrue(loginpage.verifyPrivacyPolicy());
		String privacyPolicyText=loginpage.getPrivacyPolicyText();
		System.out.println(privacyPolicyText);
		Assert.assertEquals(privacyPolicyText,Constants.LINK_TEXT);
		
	}
	
	@Test
	public void verifyCorrectCredentialsTest(){
		loginpage.login(prop.getProperty("username_app"), prop.getProperty("username_app"));
	}
	@AfterMethod
	public void cliseTheBrowser(){
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

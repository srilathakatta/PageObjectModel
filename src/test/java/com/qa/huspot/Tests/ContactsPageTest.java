package com.qa.huspot.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.Constants.Constants;
import com.qa.hubspot.Pages.ContactsPage;
import com.qa.hubspot.Pages.HomePage;
import com.qa.hubspot.Pages.LoginPage;

import com.qa.hubspot.util.TestUtil;

public class ContactsPageTest {
	
	
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homepage;
	public ContactsPage contactspage;
	@BeforeMethod
	public void setUp(){
	 basePage=new BasePage();
	 prop=basePage.intialize_Properties();
	 driver=basePage.intialize_driver();
	 driver.get(prop.getProperty("url"));
 loginPage=new LoginPage(driver);
 homepage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
 contactspage=homepage.getContactsLink();
	}
	
	@DataProvider(name= "getContactsTestData")
	public Object[][] getContactsTestData() {
		Object contactsData[][] = TestUtil.getTestData(Constants.SHEET_NAME);
		return contactsData;
	}
	@Test(dataProvider= "getContactsTestData")
	public void createNewContactsTest(String email,String firstName,String lastName, String jobTitle){
		contactspage.createNewContact(email, firstName, lastName, jobTitle);
		
	}

	@AfterMethod
	public void closeTheBrwoser(){
		driver.quit();
	}
	}

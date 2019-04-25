package com.qa.hubspot.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.Constants.Constants;
import com.qa.hubspot.util.TestUtil;

public class HomePage extends BasePage {

	@FindBy(className="account-name ")
	WebElement userLink;
	@FindBy(className="user-info-preferences")
	WebElement profileLink;
	@FindBy(id="nav-primary-contacts-branch")
	WebElement firstContactsTab;
	@FindBy(id="nav-secondary-contacts")
	WebElement secondContactsTab;
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public String getHomaPageTitle(){
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleContains(Constants.HOME_PAGE_TITLE));
		return driver.getTitle();
	}
	public ProfileAndPreferencesPage getUserLink(){
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(userLink));
		userLink.click();
		TestUtil.shortWait();
		profileLink.click();
		return new ProfileAndPreferencesPage(driver);
		
		}
	public ContactsPage getContactsLink(){
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(firstContactsTab));
		firstContactsTab.click();
		TestUtil.shortWait();
		secondContactsTab.click();
		return new ContactsPage(driver);
	}
	
	
	
	
	
	
}

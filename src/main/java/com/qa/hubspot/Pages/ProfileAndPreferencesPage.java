package com.qa.hubspot.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.Constants.Constants;

public class ProfileAndPreferencesPage extends BasePage {

	@FindBy(className="private-header__heading")
	WebElement profilePageHeader;
	@FindBy(xpath="//span[text()='Naveen Test']")
	WebElement naveenName;
	
	public ProfileAndPreferencesPage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}	
	
	public String getProfileAndPreferencesPageTitle(){
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleContains(Constants.PROFILE_PAGE_TITLE));
		return driver.getTitle();
	}
	
	public String getProfileAndPreferencesPageText(){
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(profilePageHeader));
		return profilePageHeader.getText();
		
	}
	public String getNaveenNameElementText(){
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(naveenName));
		return naveenName.getText();
	}
	
	
	
	
	
}

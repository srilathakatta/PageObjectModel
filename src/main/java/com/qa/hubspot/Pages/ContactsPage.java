package com.qa.hubspot.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.Base.BasePage;

public class ContactsPage extends BasePage {
	
	@FindBy(xpath="//span[text()='Create contact']")
	WebElement contactTab;
	
	@FindBy(xpath="//input[@id='uid-ctrl-1']")
	WebElement emailId;
	
	@FindBy(id="uid-ctrl-2")
	WebElement firstName;
	
	@FindBy(id="uid-ctrl-3")
	WebElement lastName;
	
	@FindBy(id="uid-ctrl-5")
	WebElement jobTitle;
	
	@FindBy(xpath="//li//span[text()='Create contact']")
	WebElement secondaryContactTab;
	
	public ContactsPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void createNewContact(String emailid,String firstname,String lastname,String jobtitle){
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(contactTab));
		contactTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(emailId));
		emailId.sendKeys(emailid);
		wait.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys(firstname);
		wait.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.sendKeys(lastname);
		wait.until(ExpectedConditions.elementToBeClickable(jobTitle));
		jobTitle.sendKeys(jobtitle);
		wait.until(ExpectedConditions.elementToBeClickable(secondaryContactTab));
		secondaryContactTab.click();
	}
	
	
	
	
	
}

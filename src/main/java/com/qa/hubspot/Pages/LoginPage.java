package com.qa.hubspot.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.Base.BasePage;

public class LoginPage extends BasePage{
	
	@FindBy(id="username")
	WebElement userName;
	@FindBy(id="password")
	WebElement passWord;
	@FindBy(id="loginBtn")
	WebElement loginButton;
	@FindBy(xpath="//i18n-string[text()='Privacy Policy']")
	WebElement privacyPolicy;
	@FindBy(className="buttonText")
	WebElement signInWithGoogle;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	//Methods:
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	public boolean verifySignInWithGoogle(){
		return signInWithGoogle.isDisplayed();
		}
	public String getSignInWithGoogleText(){
		return signInWithGoogle.getText();
	}
	public boolean verifyPrivacyPolicy(){
		return privacyPolicy.isDisplayed();
	}
	public String getPrivacyPolicyText(){
		return privacyPolicy.getText();
	}
	public HomePage login(String un,String pwd){
		userName.sendKeys(un);
		passWord.sendKeys(pwd);
		loginButton.click();
		return new HomePage(driver);
		
	}
	
	}

package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	

	//Page Factory - OR:
	@FindBy(xpath="//input[@formcontrolname='name']")
	WebElement username;
	
	@FindBy(xpath="//input[@formcontrolname='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='btn btnColor btn-block auth-form-btn']")
	WebElement loginBtn;
		
	@FindBy(xpath="//div[@class='brand-logo']//img")
	WebElement kargoLogo;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return kargoLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		    	
		return new HomePage();
	}
	
}

package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class FreightForwarderMasterListingPage extends TestBase {

	// Open Orgnaze and Masters
	
		@FindBy(xpath = "//span[contains(text(),' Organize ')]")
		@CacheLookup
		WebElement Organize;

		@FindBy(xpath = "//a[contains(text(),' Masters ')][1]")
		WebElement Masters;
		
		@FindBy(xpath = "//a[contains(text(),' Finance ')][1]")
		WebElement Finance;
		

		@FindBy(xpath = "//a[@href='/freight-forwarder/list']")
		WebElement FreightForwarder;
	
	
	// Initializing the Page Objects:
	public FreightForwarderMasterListingPage() {
		PageFactory.initElements(driver, this);
	}
	


	
	public void clickOnFreightForwarderListingPage() throws InterruptedException{
		Actions action = new Actions(driver);
		action.moveToElement(Organize).build().perform();
		action.moveToElement(Masters).build().perform();
		action.moveToElement(Finance).build().perform();
		Thread.sleep(1000);
		FreightForwarder.click();
		
	}
	
	
	public String veryfyFreightForwarderLisingpage(){
		return driver.getCurrentUrl();
		
	}
	

}

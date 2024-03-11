package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class AircraftMasterListingPage extends TestBase {

	// Open Orgnaze and Masters
	
		@FindBy(xpath = "//span[contains(text(),' Organize ')]")
		@CacheLookup
		WebElement Organize;

		@FindBy(xpath = "//a[contains(text(),' Masters ')][1]")
		WebElement Masters;
		
		@FindBy(xpath = "//a[contains(text(),' Operation ')][1]")
		WebElement Finance;
		

		@FindBy(xpath = "//a[@href='/aircraft/list']")
		WebElement aircraft;
	
	
	// Initializing the Page Objects:
	public AircraftMasterListingPage() {
		PageFactory.initElements(driver, this);
	}
	


	
	public void clickOnaircraftListingPage() throws InterruptedException{
		Actions action = new Actions(driver);
		action.moveToElement(Organize).build().perform();
		action.moveToElement(Masters).build().perform();
		action.moveToElement(Finance).build().perform();
		Thread.sleep(1000);
		aircraft.click();
		
	}
	
	
	public String veryfyaircraftLisingpage(){
		return driver.getCurrentUrl();
		
	}
	

}
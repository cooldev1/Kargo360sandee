package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class Supplier_GSTIN_MasterListingPage extends TestBase {

	// Open Orgnaze and Masters
	
		@FindBy(xpath = "//span[contains(text(),' Organize ')]")
		@CacheLookup
		WebElement Organize;

		@FindBy(xpath = "//a[contains(text(),' Ratefiling ')]")
		WebElement Ratefiling;
		

		@FindBy(xpath = "//a[@href='/supplier-gstin/list']")
		WebElement supplier_gstin;
	
	
	// Initializing the Page Objects:
	public Supplier_GSTIN_MasterListingPage() {
		PageFactory.initElements(driver, this);
	}
	


	
	public void clickOnSupplier_GSTINListingPage() throws InterruptedException{
		Actions action = new Actions(driver);
		action.moveToElement(Organize).build().perform();
		action.moveToElement(Ratefiling).build().perform();
		Thread.sleep(1000);
		supplier_gstin.click();
		
	}
	
	
	public String veryfySupplier_GSTINLisingpage(){
		return driver.getCurrentUrl();
		
	}
	

}

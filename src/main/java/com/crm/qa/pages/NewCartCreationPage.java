package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class NewCartCreationPage extends TestBase {
	
// to click on new Cart button	
	@FindBy(xpath = "//*[@title='Create Cart']")
	WebElement NewCart_btn;
	
	@FindBy(xpath = "//*[@title='Refresh']")
	WebElement Refresh_btn;
	
	@FindBy(xpath = "//*[@title='Advanced Filters']")
	WebElement advance_fltr;
	
	// Initializing the Page Objects:
		public NewCartCreationPage() {
			PageFactory.initElements(driver, this);
		}

		
		public void veryfyNewCartpage(){
			 driver.findElement(By.xpath("//*[@title='Create Cart']")).click();
			
		}
		
		public  void Clickonadvancefltr() throws InterruptedException{
			Thread.sleep(1000);
			advance_fltr.click();
			
		}
}

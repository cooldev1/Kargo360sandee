package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Ariport_WarehouseCreationPage extends TestBase {
	
// to click on new Region button	
	@FindBy(xpath = "//*[@title='Create Airport']")
	WebElement State_btn;
	
	@FindBy(xpath = "//*[@title='Refresh']")
	WebElement Refresh_btn;
	
	@FindBy(xpath = "//*[@title='Advanced Filters']")
	WebElement advance_fltr;
	
	// Initializing the Page Objects:
		public Ariport_WarehouseCreationPage() {
			PageFactory.initElements(driver, this);
		}

		
		public  void Clickonadvancefltr() throws InterruptedException{
			Thread.sleep(1000);
			advance_fltr.click();
			
		}



		public void veryfyNewAriport_Warehousepage() {
			// TODO Auto-generated method stub
			driver.findElement(By.xpath("//*[@title='Create Airport']")).click();
		}
}

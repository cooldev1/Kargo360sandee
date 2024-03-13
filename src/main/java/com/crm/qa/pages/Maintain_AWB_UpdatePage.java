package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Maintain_AWB_UpdatePage extends TestBase {
	
// to click on new Region button	
	@FindBy(id = "parent_1")
	WebElement Order;
	
	@FindBy(xpath = "//*[@title='Refresh']")
	WebElement Refresh_btn;
	
	@FindBy(xpath = "//*[@title='Search']")
	WebElement Search_btn;
	
	@FindBy(xpath = "//*[@href='/maintain-awb']")
	WebElement  Maintain_Page_AWB;
	
	@FindBy(xpath = "//*[@title='Advanced Filters']")
	WebElement advance_fltr;
	
	// Initializing the Page Objects:
		public Maintain_AWB_UpdatePage() {
			PageFactory.initElements(driver, this);
		}


		public void ClickOnMaintain_AWB() throws InterruptedException{
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.id("parent_1"))).build().perform();;
			Maintain_Page_AWB.click();	
		}
		


		public void Clickonadvancefltr() throws InterruptedException {
			// TODO Auto-generated method stub
			Thread.sleep(1000);
			advance_fltr.click();
		}
		

		

}

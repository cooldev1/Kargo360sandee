package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class A2A_Booking_Page extends TestBase {
	

	@FindBy(id = "parent_1")
	WebElement Order;
	
	@FindBy(xpath = "//*[@title='Refresh']")
	WebElement Refresh_btn;
	
	@FindBy(xpath = "//*[@title='Search']")
	WebElement Search_btn;
	
	@FindBy(xpath = "//*[@href='/create-booking']")
	WebElement  new_order;
	
	@FindBy(xpath = "//*[@title='Advanced Filters']")
	WebElement advance_fltr;
	
//To Booking Fail xPath
	
	//To Select Org Station on top BOM Name	
	@FindBy(xpath = "//*[@formcontrolname='station_code']")
	String Org_B;
	
	//To Select Des Station 	
		@FindBy(xpath = "//input[@name='destination']")
		String Des__B;
		
	//To Select Commudity Station 	
		@FindBy(xpath = "//input[@name='commodity_code']")
		String Com_B;
	
	//To Select Shipper Station 	
		@FindBy(xpath = "//input[@name='shipperCode']")
		String ship_B;
	
	//To Select Consignee  Station 	
		@FindBy(xpath = "//input[@name='consigneeCode']")
		String con_B;		
	
    //To Select Customer   Station 	
		@FindBy(xpath = "//input[@name='customer']")
		String cus_B;		
	
	//To Select Pieces    Station 	
		@FindBy(xpath = "//input[@name='total_pieces']")
		String pic_B;		
		
	//TO Enter Gross Weight
		@FindBy(xpath = "//input[@name='gross_weight']")
		String gweight_B;	
		
	//TO Enter demision
				@FindBy(xpath = "//table[@class='table deminsion-table']//child::tbody//child::tr[1]//child::td[2]//input")
				String dl_B;		
		
				@FindBy(xpath = "//table[@class='table deminsion-table']//child::tbody//child::tr[1]//child::td[3]//input")
				String dw_B;
			
				@FindBy(xpath = "//table[@class='table deminsion-table']//child::tbody//child::tr[1]//child::td[4]//input")
				String dh_B;
				
	//To Shipper Invoice 
				 @FindBy(xpath = "input[@name='invoice_number']")
					String shpinv_B;
	
	//To DV for Carriage
				 @FindBy(xpath = "//input[@name='dv_for_carriage']")
				 String dvchr_B;
				 
				 
	// Initializing the Page Objects:
		public A2A_Booking_Page() {
			PageFactory.initElements(driver, this);
		}


		public void ClickOnNew_order_AWB() throws InterruptedException{
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.id("parent_1"))).build().perform();;
			new_order.click();	
		}
		


		public void Clickonadvancefltr() throws InterruptedException {
			// TODO Auto-generated method stub
			Thread.sleep(1000);
			advance_fltr.click();
		}
		

		public void enterCon_shiperDetails(String org,String des,String com,String ship,String con, String pic, String weight,String dl,String dw,String dh,String shpinv,String dvchr) throws InterruptedException {
			// TODO Auto-generated method stub
			driver.findElement(By.xpath(Org_B)).sendKeys(org);
			driver.findElement(By.xpath(Des__B)).sendKeys(des);
			driver.findElement(By.xpath(Com_B)).sendKeys(com);
			driver.findElement(By.xpath(ship_B)).sendKeys(ship);
			driver.findElement(By.xpath(con_B)).sendKeys(con);
			driver.findElement(By.xpath(pic_B)).sendKeys(pic);
			driver.findElement(By.xpath(gweight_B)).sendKeys(weight);
			driver.findElement(By.xpath(dl_B)).sendKeys(dl);
			driver.findElement(By.xpath(dw_B)).sendKeys(dw);
			driver.findElement(By.xpath(dh_B)).sendKeys(dh);
			driver.findElement(By.xpath(shpinv_B)).sendKeys(shpinv);
			driver.findElement(By.xpath(dvchr_B)).sendKeys(dvchr);
			
		}

}

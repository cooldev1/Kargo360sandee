/*
 * @author Naveen Khunteta
 * 
 */

package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CartMasterListingPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.CustomListener;
import com.crm.qa.util.TestUtil;

@Listeners(CustomListener.class)
public class FreightForwarder_MasterListingPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TestBase TestBase;
	CartMasterListingPage Cartlistingpage;
	NewCartcreationPageTest NewCartCreationPage;
	
	com.crm.qa.pages.FreightForwarderMasterListingPage FreightForwarderMasterListingPage;
	
//	String sheetName = "contacts";
	
	   
	public FreightForwarder_MasterListingPageTest(){
			super();
			
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		Cartlistingpage = new CartMasterListingPage();
		loginPage = new LoginPage();
		
		FreightForwarderMasterListingPage = new com.crm.qa.pages.FreightForwarderMasterListingPage();
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	@Test(priority=1)
	public void verifyhomepage() throws InterruptedException{
		homePage.verifyHomePageurl();
	}
	
	@Test(priority=2)
	public void verifyFreightForwarderListingpage() throws InterruptedException{
		homePage.verifyHomePageurl();
		FreightForwarderMasterListingPage.clickOnFreightForwarderListingPage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/freight-forwarder/list");
	}
		

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}

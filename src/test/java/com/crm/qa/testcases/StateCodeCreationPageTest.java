package com.crm.qa.testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CartMasterListingPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.CustomListener;
import com.crm.qa.util.TestUtil;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

@Listeners(CustomListener.class)
public class StateCodeCreationPageTest  extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TestBase TestBase;
	com.crm.qa.pages.StateMasterListingPage StateMasterListingPage;
	com.crm.qa.pages.StateCodeCreationPage StateCodeCreationPage;
	

	public StateCodeCreationPageTest(){
		super();
		}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		StateMasterListingPage = new com.crm.qa.pages.StateMasterListingPage();
		StateCodeCreationPage = new com.crm.qa.pages.StateCodeCreationPage();
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority=1)
	public void verifyhomepage() throws InterruptedException{
		homePage.verifyHomePageurl();
	}
	
	@Test(priority=2)
	public void verifyStateListingpage() throws InterruptedException{
		homePage.verifyHomePageurl();
		StateMasterListingPage.clickOnStateListingPage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/state/list");
	}
	
	@Test(priority=3)
	public void ClickonNewStateButton() throws InterruptedException{
		homePage.verifyHomePageurl();
		StateMasterListingPage.clickOnStateListingPage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/state/list");
		StateCodeCreationPage.Clickonadvancefltr();
		StateCodeCreationPage.veryfyNewStatepage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/state/create");
	}
	
	@Test(priority=4)
	public void StateCreationPossitiveflow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		StateMasterListingPage.clickOnStateListingPage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/state/list");
		StateCodeCreationPage.Clickonadvancefltr();
		StateCodeCreationPage.veryfyNewStatepage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/state/create");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\State Master.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(0);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {
         
         String state_code  =  sheet.getRow(i).getCell(0).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='state_code']")).sendKeys(state_code );
         System.out.println("This is my data value:- "+state_code );
         
         String state_name  =  sheet.getRow(i).getCell(1).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='state_name']")).sendKeys(state_name);
         System.out.println("This is my data value:- "+state_name);
           
         String country =  sheet.getRow(i).getCell(2).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='country_code']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='country_code']")).sendKeys(country,Keys.ENTER);
         System.out.println("This is my data value:- "+country);
         
         String state_type =  sheet.getRow(i).getCell(3).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='state_type']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='state_type']")).sendKeys(state_type,Keys.ENTER);
         System.out.println("This is my data value:- "+state_type);
         
         String status =  sheet.getRow(i).getCell(4).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='status']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='status']")).sendKeys(status,Keys.ENTER);
         System.out.println("This is my data value:- "+status);
           
         
            driver.findElement(By.xpath("//*[@title='Submit']")).click();
             Thread.sleep(2000);
             
             String ErrorMsg = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
             System.out.println(ErrorMsg);
     
     		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/state/list");
             
             
            }
         }
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	}
	


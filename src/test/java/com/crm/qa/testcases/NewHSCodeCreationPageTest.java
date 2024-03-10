package com.crm.qa.testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CartMasterListingPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
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

public class NewHSCodeCreationPageTest  extends TestBase {

	

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TestBase TestBase;
	com.crm.qa.pages.NewHSCodeCreationPage NewHSCodeCreationPage;
	com.crm.qa.pages.HSCodeMasterListingPage HSCodeMasterListingPage;
	
	//com.crm.qa.pages.NewFreightFowarderCreationPage NewFreightFowarderCreationPage;
	//com.crm.qa.pages.FreightForwarderMasterListingPage FreightForwarderMasterListingPage;
	public NewHSCodeCreationPageTest(){
		super();
		}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		
		NewHSCodeCreationPage = new com.crm.qa.pages.NewHSCodeCreationPage();
		HSCodeMasterListingPage = new com.crm.qa.pages.HSCodeMasterListingPage();

		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority=1)
	public void verifyhomepage() throws InterruptedException{
		homePage.verifyHomePageurl();
	}
	
	@Test(priority=2)
	public void verifyFreightForwarderListingpage() throws InterruptedException{
		homePage.verifyHomePageurl();
		HSCodeMasterListingPage.clickOnFreightForwarderListingPage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/hs-code/list");
	}
	
	@Test(priority=3)
	public void ClickonNewFreightForwarderButton() throws InterruptedException{
		homePage.verifyHomePageurl();
		HSCodeMasterListingPage.clickOnFreightForwarderListingPage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/hs-code/list");
		NewHSCodeCreationPage.Clickonadvancefltr();
		NewHSCodeCreationPage.veryfyNewHSCodepage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/hs-code/create");
	}
	
	@Test(priority=4)
	public void FreightForwarderCreationPossitiveflow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		HSCodeMasterListingPage.clickOnFreightForwarderListingPage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/hs-code/list");
		NewHSCodeCreationPage.Clickonadvancefltr();
		NewHSCodeCreationPage.veryfyNewHSCodepage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/hs-code/create");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\HSCode Master.xlsx";
        
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
         
         String HSCode  =  sheet.getRow(i).getCell(0).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='hs_code']")).sendKeys(HSCode );
         System.out.println("This is my data value:- "+HSCode );
         
         String HS_Description  =  sheet.getRow(i).getCell(1).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='hs_description']")).sendKeys(HS_Description);
         System.out.println("This is my data value:- "+HS_Description);
           
         String status =  sheet.getRow(i).getCell(2).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='status']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='status']")).sendKeys(status,Keys.ENTER);
         System.out.println("This is my data value:- "+status);
           
         
             driver.findElement(By.xpath("//*[@title='Submit']")).click();
             Thread.sleep(2000);
             
             String ErrorMsg = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
             System.out.println(ErrorMsg);
     
     		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/hs-code/list");
             
             
            }
         }
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	}
	


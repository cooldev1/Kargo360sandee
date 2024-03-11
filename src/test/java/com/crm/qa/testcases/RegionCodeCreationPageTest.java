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

public class RegionCodeCreationPageTest  extends TestBase {

	

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TestBase TestBase;
	com.crm.qa.pages.RegionCodeCreationPage RegionCodeCreationPage;
	com.crm.qa.pages.RegionMasterListingPage RegionMasterListingPage;

	public RegionCodeCreationPageTest(){
		super();
		}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		RegionCodeCreationPage = new com.crm.qa.pages.RegionCodeCreationPage();
		RegionMasterListingPage = new com.crm.qa.pages.RegionMasterListingPage();
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority=1)
	public void verifyhomepage() throws InterruptedException{
		homePage.verifyHomePageurl();
	}
	
	@Test(priority=2)
	public void verifyRegionListingpage() throws InterruptedException{
		homePage.verifyHomePageurl();
		RegionMasterListingPage.clickOnRegionListingPage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/region/list");
	}
	
	@Test(priority=3)
	public void ClickonNewRegionButton() throws InterruptedException{
		homePage.verifyHomePageurl();
		RegionMasterListingPage.clickOnRegionListingPage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/region/list");
		RegionCodeCreationPage.Clickonadvancefltr();
		RegionCodeCreationPage.veryfyNewRegionpage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/region/create");
	}
	
	@Test(priority=4)
	public void RegionCreationPossitiveflow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		RegionMasterListingPage.clickOnRegionListingPage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/region/list");
		RegionCodeCreationPage.Clickonadvancefltr();
		RegionCodeCreationPage.veryfyNewRegionpage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/region/create");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\Region Master.xlsx";
        
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
         
         String RegionCode  =  sheet.getRow(i).getCell(0).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='region_code']")).sendKeys(RegionCode );
         System.out.println("This is my data value:- "+RegionCode );
         
         String RegionName  =  sheet.getRow(i).getCell(1).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='region_name']")).sendKeys(RegionName);
         System.out.println("This is my data value:- "+RegionName);
           
         String Country =  sheet.getRow(i).getCell(2).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='country_code']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='country_code']")).sendKeys(Country,Keys.ENTER);
         System.out.println("This is my data value:- "+Country);
         
         String status =  sheet.getRow(i).getCell(3).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='is_active']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='is_active']")).sendKeys(status,Keys.ENTER);
         System.out.println("This is my data value:- "+status);
           
         
            driver.findElement(By.xpath("//*[@title='Submit']")).click();
             Thread.sleep(2000);
             
             String ErrorMsg = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
             System.out.println(ErrorMsg);
     
     		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/region/list");
             
             
            }
         }
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	}
	

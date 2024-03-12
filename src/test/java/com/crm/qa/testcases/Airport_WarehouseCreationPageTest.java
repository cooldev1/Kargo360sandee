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
import com.crm.qa.util.WebEventListener;

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
public class Airport_WarehouseCreationPageTest  extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TestBase TestBase;
	com.crm.qa.pages.Airport_WarehouseMasterListingPage Airport_WarehouseMasterListingPage;
	com.crm.qa.pages.Ariport_WarehouseCreationPage Ariport_WarehouseCreationPage;
	public Airport_WarehouseCreationPageTest(){
		super();
		}
	

	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		Airport_WarehouseMasterListingPage = new com.crm.qa.pages.Airport_WarehouseMasterListingPage();
		Ariport_WarehouseCreationPage = new com.crm.qa.pages.Ariport_WarehouseCreationPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority=1)
	public void verifyhomepage() throws InterruptedException{
		homePage.verifyHomePageurl();
	}
	
	@Test(priority=2)
	public void verifyAirport_WarehouseListingpage() throws InterruptedException{
		homePage.verifyHomePageurl();
		Airport_WarehouseMasterListingPage.clickOnAirportListingPage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/airport/list");
	}
	
	@Test(priority=3)
	public void ClickonNewAirport_WarehouseButton() throws InterruptedException{
		homePage.verifyHomePageurl();
		Airport_WarehouseMasterListingPage.clickOnAirportListingPage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/airport/list");
		Ariport_WarehouseCreationPage.Clickonadvancefltr();
		Ariport_WarehouseCreationPage.veryfyNewAriport_Warehousepage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/airport/create");
	}
	
	@Test(priority=4)
	public void WarehouseCreationPossitiveflow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		Airport_WarehouseMasterListingPage.clickOnAirportListingPage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/airport/list");
		Ariport_WarehouseCreationPage.Clickonadvancefltr();
		Ariport_WarehouseCreationPage.veryfyNewAriport_Warehousepage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/airport/create");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\WarehouseMaster.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(0);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= Lastrow; i++) {
         
        	 String type =  sheet.getRow(i).getCell(2).getStringCellValue();
             driver.findElement(By.xpath("//*[@formcontrolname='type']")).click();
             driver.findElement(By.xpath("//*[@formcontrolname='type']")).sendKeys(type,Keys.ENTER);
             System.out.println("This is my data value:- "+type);
        	
         String Code  =  sheet.getRow(i).getCell(0).getStringCellValue();
         Thread.sleep(2000);
         driver.findElement(By.xpath("//*[@formcontrolname='code']")).sendKeys(Code );
         System.out.println("This is my data value:- "+Code );
         
         String name  =  sheet.getRow(i).getCell(1).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(name);
         System.out.println("This is my data value:- "+name);
           
        
         
         String Airport_Code =  sheet.getRow(i).getCell(3).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='mapping_code']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='mapping_code']")).sendKeys(Airport_Code,Keys.ENTER);
         System.out.println("This is my data value:- "+Airport_Code);
         
//         String pincode =  sheet.getRow(i).getCell(5).getStringCellValue();
//         driver.findElement(By.xpath("//*[@formcontrolname='postal_code']")).sendKeys(pincode,Keys.ENTER);
//         System.out.println("This is my data value:- "+pincode);
         
         String Full_Address =  sheet.getRow(i).getCell(5).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='address']")).sendKeys(Full_Address,Keys.ENTER);
         System.out.println("This is my data value:- "+Full_Address);
         
         String City =  sheet.getRow(i).getCell(6).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='city_code']")).sendKeys(City,Keys.ENTER);
         System.out.println("This is my data value:- "+City);
         
         String Country_Code =  sheet.getRow(i).getCell(7).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='country_code']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='country_code']")).sendKeys(Country_Code,Keys.ENTER);
         System.out.println("This is my data value:- "+Country_Code);
       //  Thread.sleep(2000);
         
         String State =  sheet.getRow(i).getCell(8).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='state_code']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='state_code']")).sendKeys(State,Keys.ENTER);
         System.out.println("This is my data value:- "+State);
           
         String Region =  sheet.getRow(i).getCell(9).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='region_code']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='region_code']")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
         driver.findElement(By.xpath("//*[@formcontrolname='region_code']")).sendKeys(Region,Keys.ENTER);
         System.out.println("This is my data value:- "+Region);
         
         String Status =  sheet.getRow(i).getCell(10).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='is_active']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='is_active']")).sendKeys(Status,Keys.ENTER);
         System.out.println("This is my data value:- "+Status);
         
         String UOM =  sheet.getRow(i).getCell(11).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='uom']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='uom']")).sendKeys(UOM,Keys.ENTER);
         System.out.println("This is my data value:- "+UOM);
         
         String Time_Zone =  sheet.getRow(i).getCell(12).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='time_zone']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='time_zone']")).sendKeys(Time_Zone,Keys.ENTER);
         System.out.println("This is my data value:- "+Time_Zone);
         
            
         
            driver.findElement(By.xpath("//*[@title='Submit']")).click();
             Thread.sleep(2000);
             
             String ErrorMsg = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
             System.out.println(ErrorMsg);
     
     		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/airport/list");
             
             
            }
         }
	
	@Test(priority=5)
	public void AirportCreationPossitiveflow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		Airport_WarehouseMasterListingPage.clickOnAirportListingPage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/airport/list");
		Ariport_WarehouseCreationPage.Clickonadvancefltr();
		Ariport_WarehouseCreationPage.veryfyNewAriport_Warehousepage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/airport/create");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\Airport Master.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(0);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= Lastrow; i++) {
        	
        	 String type =  sheet.getRow(i).getCell(2).getStringCellValue();
             driver.findElement(By.xpath("//*[@formcontrolname='type']")).click();
             driver.findElement(By.xpath("//*[@formcontrolname='type']")).sendKeys(type,Keys.ENTER);
             System.out.println("This is my data value:- "+type);	
         
         String Code  =  sheet.getRow(i).getCell(0).getStringCellValue();
         Thread.sleep(2000);
         driver.findElement(By.xpath("//*[@formcontrolname='code']")).sendKeys(Code );
         System.out.println("This is my data value:- "+Code );
         
         String name  =  sheet.getRow(i).getCell(1).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(name);
         System.out.println("This is my data value:- "+name);
           
        
//         
//         String Airport_Code =  sheet.getRow(i).getCell(3).getStringCellValue();
//         driver.findElement(By.xpath("//*[@formcontrolname='mapping_code']")).click();
//         driver.findElement(By.xpath("//*[@formcontrolname='mapping_code']")).sendKeys(Airport_Code,Keys.ENTER);
//         System.out.println("This is my data value:- "+Airport_Code);
//         
//         String pincode =  sheet.getRow(i).getCell(5).getStringCellValue();
//         driver.findElement(By.xpath("//*[@formcontrolname='postal_code']")).sendKeys(pincode,Keys.ENTER);
//         System.out.println("This is my data value:- "+pincode);
         
         String Full_Address =  sheet.getRow(i).getCell(4).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='address']")).sendKeys(Full_Address,Keys.ENTER);
         System.out.println("This is my data value:- "+Full_Address);
         
         String City =  sheet.getRow(i).getCell(5).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='city_code']")).sendKeys(City,Keys.ENTER);
         System.out.println("This is my data value:- "+City);
         
         String Country_Code =  sheet.getRow(i).getCell(6).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='country_code']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='country_code']")).sendKeys(Country_Code,Keys.ENTER);
         System.out.println("This is my data value:- "+Country_Code);
       //  Thread.sleep(2000);
         
         String State =  sheet.getRow(i).getCell(7).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='state_code']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='state_code']")).sendKeys(State,Keys.ENTER);
         System.out.println("This is my data value:- "+State);
           
         String Region =  sheet.getRow(i).getCell(8).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='region_code']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='region_code']")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
         driver.findElement(By.xpath("//*[@formcontrolname='region_code']")).sendKeys(Region,Keys.ENTER);
         System.out.println("This is my data value:- "+Region);
         
         String Status =  sheet.getRow(i).getCell(9).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='is_active']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='is_active']")).sendKeys(Status,Keys.ENTER);
         System.out.println("This is my data value:- "+Status);
         
         String UOM =  sheet.getRow(i).getCell(10).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='uom']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='uom']")).sendKeys(UOM,Keys.ENTER);
         System.out.println("This is my data value:- "+UOM);
         
         String Time_Zone =  sheet.getRow(i).getCell(11).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='time_zone']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='time_zone']")).sendKeys(Time_Zone,Keys.ENTER);
         System.out.println("This is my data value:- "+Time_Zone);
         
            
         
            driver.findElement(By.xpath("//*[@title='Submit']")).click();
             Thread.sleep(2000);
             
             String ErrorMsg = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
             System.out.println(ErrorMsg);
     
     		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/airport/list");
             
             
            }
         }

	
		@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	}
	


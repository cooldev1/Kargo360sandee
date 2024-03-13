package com.crm.qa.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

@Listeners(CustomListener.class)
public class Void_AWBPageTest  extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TestBase TestBase;
	com.crm.qa.pages.Void_AWB_UpdatePage Void_AWB_UpdatePage;
	
	public Void_AWBPageTest(){
		super();
		}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		Void_AWB_UpdatePage = new com.crm.qa.pages.Void_AWB_UpdatePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}
//
//	@Test(priority=1)
//	public void verifyhomepage() throws InterruptedException{
//		homePage.verifyHomePageurl();
//	}
//	
//	@Test(priority=2)
//	public void verifyMaintain_AWB_gpage() throws InterruptedException{
//		homePage.verifyHomePageurl();
//		Void_AWB_UpdatePage.ClickOnNew_order_AWB();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
//	}
	
	
	@Test(priority=3)
	public void Maintain_AWB_Reporcessflow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		Thread.sleep(1000);
		Void_AWB_UpdatePage.ClickOnNew_order_AWB();
		
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\Void_AWB.xlsx";
        
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
        
        	
        	 String AWB_No  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
     		driver.findElement(By.xpath("//*[@formcontrolname='awb_number']")).sendKeys(AWB_No,Keys.ENTER);
     		 System.out.println("This is my data value:- "+AWB_No);
     		Thread.sleep(2000);
     		
     		     		
     // To click on Shipper Details 		
         driver.findElement(By.xpath("//*[contains(@class,'icon-accordian ng-tns-c250-')][1]")).click();
         
    // To click on "Addtl. Info" in shipper details    
       //  Thread.sleep(2000);
         driver.findElement(By.xpath("//*[@data-target='#voidModal']")).click();
         
      //Cargo Details
         
    // To Select Shipment Type in popup box
         
         driver.findElement(By.xpath("//*[@name='void_shippment_type']")).click();
         driver.findElement(By.xpath("//*[@name='void_shippment_type']")).sendKeys("Bulk");
    
         driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
  		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  		
   // To Select "Service Cargo Class" Type in popup box
  	//	Thread.sleep(1000);
         driver.findElement(By.xpath("//*[@name='void_service_cargo_class']")).click();
         driver.findElement(By.xpath("//*[@name='void_service_cargo_class']")).sendKeys("Void");   
        
         driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
  		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  		
      // To Select "Irreg. Code" Type in PopUp box
  	//	Thread.sleep(1000);
         driver.findElement(By.xpath("//*[@name='void_irreg_code']")).click();
         driver.findElement(By.xpath("//*[@name='void_irreg_code']")).sendKeys("98-Others"); 
      
         driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
  		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  		
   // To Select "Remark " Type in PopUp box
  	//	Thread.sleep(1000);
         driver.findElement(By.xpath("//*[@name='void_remark']")).click();
         driver.findElement(By.xpath("//*[@name='void_remark']")).sendKeys("Docket Void");         
         driver.findElement(By.xpath("//*[@name='void_remark']")).sendKeys(Keys.TAB,Keys.ENTER);    
     		Thread.sleep(2000);
     //		driver.findElement(By.xpath("//*[@type='submit']")).click();
     		
     
     		//To Capture the PopUp msg when we submit 
            
     	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
     		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
         System.out.println("Whai is error msg:- "+popupText );
    
        
         String[] parts = popupText.split("AWB"); // Split the text using "is" as a delimiter
         String newText = parts[1]; // Access the part after "is"
         System.out.println(newText);
          
 		Assert.assertEquals("/AXB Void Successfully",newText);
             Thread.sleep(3000);
            }
        }
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	}
	


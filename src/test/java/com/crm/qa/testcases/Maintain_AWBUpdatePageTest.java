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
public class Maintain_AWBUpdatePageTest  extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TestBase TestBase;
	com.crm.qa.pages.Maintain_AWB_UpdatePage Maintain_AWB_UpdatePage;
	
	public Maintain_AWBUpdatePageTest(){
		super();
		}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		Maintain_AWB_UpdatePage = new com.crm.qa.pages.Maintain_AWB_UpdatePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

//	@Test(priority=1)
//	public void verifyhomepage() throws InterruptedException{
//		homePage.verifyHomePageurl();
//	}
//	
//	@Test(priority=2)
//	public void verifyMaintain_AWBgpage() throws InterruptedException{
//		homePage.verifyHomePageurl();
//		Maintain_AWB_UpdatePage.ClickOnMaintain_AWB();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/maintain-awb");
//	}
	
	
	@Test(priority=3)
	public void Maintain_AWB_Reporcessflow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		Maintain_AWB_UpdatePage.ClickOnMaintain_AWB();
		Maintain_AWB_UpdatePage.Clickonadvancefltr();
	//	Thread.sleep(1000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/maintain-awb");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\Maintain_AWB.xlsx";
        
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
        
        	
//         String Prefix  =  sheet.getRow(i).getCell(0).getStringCellValue();
//         driver.findElement(By.xpath("//*[@formcontrolname='Prefix']")).sendKeys(Prefix );
//         System.out.println("This is my data value:- "+Prefix );
         
         String AWB_No  =  sheet.getRow(i).getCell(2).getStringCellValue();
         driver.findElement(By.xpath("//*[contains(@class,'form-group has-float-label ng-tns-')]//input[@formcontrolname='awb_number']")).sendKeys(AWB_No);
         System.out.println("This is my data value:- "+AWB_No);
           
         driver.findElement(By.xpath("//*[@title='Search']")).click();
         Thread.sleep(1000);
         
       //To ScrollInto page
//	     driver.findElement(By.xpath("//*[@title='Search']")).sendKeys(Keys.PAGE_DOWN);
//         Thread.sleep(1000);
//         driver.findElement(By.xpath("//*[@title='Search']")).sendKeys(Keys.PAGE_DOWN);
//         Thread.sleep(1000);
         driver.findElement(By.xpath("//*[@id='mat-checkbox-1']")).click();
         
         driver.findElement(By.xpath("//*[contains(text(),'Check')]")).click();
         Thread.sleep(1000);
         driver.findElement(By.xpath("//*[@title='Save']")).click();
         //    Thread.sleep(2000);
         
         //To Capture the PopUp msg when we submit 
         
         	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
             String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
             System.out.println("Whai is error msg:- "+popupText );
        
            
             String[] parts = popupText.split("AWB"); // Split the text using "is" as a delimiter
             String newText = parts[1]; // Access the part after "is"
             System.out.println(newText);
              
     		Assert.assertEquals(" Detail Has Been Updated Successfully.",newText);
         
     		 driver.findElement(By.xpath("//*[@title='Search']")).sendKeys(Keys.PAGE_UP);
             Thread.sleep(1000);
//             driver.findElement(By.xpath("//*[@title='Search']")).sendKeys(Keys.PAGE_UP);
//            
     		Thread.sleep(1000);
     		driver.findElement(By.xpath("//*[@title='Refresh']")).click();
     		
     		
             
            }
        }
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	}
	


package com.crm.qa.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@Listeners(CustomListener.class)
public class Supplier_GSTINCreationPageTest  extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TestBase TestBase;
	com.crm.qa.pages.Supplier_GSTIN_MasterListingPage Supplier_GSTIN_MasterListingPage;
	com.crm.qa.pages.Supplier_GSTINCreationPage Supplier_GSTINCreationPage;
	
	public Supplier_GSTINCreationPageTest(){
		super();
		}
	

	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		Supplier_GSTIN_MasterListingPage = new com.crm.qa.pages.Supplier_GSTIN_MasterListingPage();
		Supplier_GSTINCreationPage = new com.crm.qa.pages.Supplier_GSTINCreationPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

//	@Test(priority=1)
//	public void verifyhomepage() throws InterruptedException{
//		homePage.verifyHomePageurl();
//	}
//	
//	@Test(priority=2)
//	public void verifySupplier_GSTIN_Listingpage() throws InterruptedException{
//		homePage.verifyHomePageurl();
//		Supplier_GSTIN_MasterListingPage.clickOnSupplier_GSTINListingPage();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/supplier-gstin/list");
//	}
//	
//	@Test(priority=3)
//	public void ClickonNewSupplier_GSTINButton() throws InterruptedException{
//		homePage.verifyHomePageurl();
//		Supplier_GSTIN_MasterListingPage.clickOnSupplier_GSTINListingPage();
//		Thread.sleep(2000);
//		
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/supplier-gstin/list");
//		Supplier_GSTINCreationPage.Clickonadvancefltr();
//		Supplier_GSTINCreationPage.veryfyNewSupplier_GSTINpage();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/supplier-gstin/create");
//	}
	
	@Test(priority=4)
	public void Supplier_GSTIN_Possitiveflow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		Supplier_GSTIN_MasterListingPage.clickOnSupplier_GSTINListingPage();
		Thread.sleep(2000);
		
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/supplier-gstin/list");
		Supplier_GSTINCreationPage.Clickonadvancefltr();
		Supplier_GSTINCreationPage.veryfyNewSupplier_GSTINpage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/supplier-gstin/create");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\Supplier GSTIN Master.xlsx";
        
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
         
        
        	
         String name  =  sheet.getRow(i).getCell(0).getStringCellValue();
        // Thread.sleep(2000);
         driver.findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(name );
         System.out.println("This is my data value:- "+name );
         
         String country  =  sheet.getRow(i).getCell(1).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='country']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='country']")).sendKeys(country,Keys.ENTER);
         System.out.println("This is my data value:- "+country);
           
         String state =  sheet.getRow(i).getCell(2).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='state']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='state']")).sendKeys(state,Keys.ENTER);
         System.out.println("This is my data value:- "+state);
         
         String address =  sheet.getRow(i).getCell(3).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='address']")).sendKeys(address,Keys.ENTER);
         System.out.println("This is my data value:- "+address);
         
         String tax_reg_no =  sheet.getRow(i).getCell(4).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='tax_reg_no']")).sendKeys(tax_reg_no,Keys.ENTER);
         System.out.println("This is my data value:- "+tax_reg_no);
         
         String status =  sheet.getRow(i).getCell(5).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='status']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='status']")).sendKeys(status,Keys.ENTER);
         System.out.println("This is my data value:- "+status);
         
// TO Valid form date  
       //To Get Today Date
         int d = 0;
		  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
		  	Date SystemDate = new Date();
			String Dateofsystem = formatdate.format(SystemDate);	
			System.out.println(Dateofsystem);
			String arr[]=Dateofsystem.split("/");
			String days = arr[0];		
			int s = (int) Integer.parseInt(days);
			String day=String.valueOf(s+d); 
			System.out.println("This is the current day for today date"+ s);
		  
//To Click the Datepicker in Route From Date
		  JavascriptExecutor js =(JavascriptExecutor)driver;
		  WebElement datepicker = driver.findElement(By.xpath("//*[@formcontrolname='valid_from']"));
		  js.executeScript("arguments[0].click()", datepicker);
		  Thread.sleep(1000);
		  
//To click the date in route date
		  
		  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
		  for(WebElement ele:alldaate) 
		  {
			  String dt = ele.getText();
			  System.out.println(dt);
			  

			   if(dt.equals(day))
			  {
				  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
				  
				  ele.click();
				  break;
			  }
			 
		  }		  
// To Select valid date

		//To Get Today Date
	         int d1 = 0;
			  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
			  	Date SystemDate1 = new Date();
				String Dateofsystem1 = formatdate1.format(SystemDate1);	
				System.out.println(Dateofsystem1);
				String arr1[]=Dateofsystem1.split("/");
				String days1 = arr1[0];		
				int s1 = (int) Integer.parseInt(days1);
				String day1=String.valueOf(s1+d1); 
				System.out.println("This is the current day for today date"+ s);
			  
	//To Click the Datepicker in Route From Date
			  JavascriptExecutor js1 =(JavascriptExecutor)driver;
			  WebElement datepicker1 = driver.findElement(By.xpath("//*[@formcontrolname='valid_to']"));
			  js1.executeScript("arguments[0].click()", datepicker1);
			  Thread.sleep(1000);
			  
	//To click the date in route date
			  
			  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
			  for(WebElement ele1:alldaate1) 
			  {
				  String dt1 = ele1.getText();
				  System.out.println(dt1);
				  

				   if(dt1.equals(day1))
				  {
					  System.out.println("inside of if condiction "+day1 +"calender day:-" + dt1);
					  
					  ele1.click();
					  break;
				  }
				 
			  }		  
	  
         
     
         
         String GSTIN_Type =  sheet.getRow(i).getCell(8).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='gstin_type']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='gstin_type']")).sendKeys(GSTIN_Type,Keys.ENTER);
         System.out.println("This is my data value:- "+GSTIN_Type);
           
         String Pincode =  sheet.getRow(i).getCell(9).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='pincode']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='pincode']")).sendKeys(Pincode,Keys.ENTER);
         System.out.println("This is my data value:- "+Pincode);
         
           
            
         
            driver.findElement(By.xpath("//*[@title='Submit']")).click();
             Thread.sleep(2000);
             
             String ErrorMsg = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
             System.out.println(ErrorMsg);
     
     		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/supplier-gstin/list");
             
             
            }
         }
	

	
		@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	}
	


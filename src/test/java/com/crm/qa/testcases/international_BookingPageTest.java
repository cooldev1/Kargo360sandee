package com.crm.qa.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Listeners(CustomListener.class)
public class international_BookingPageTest  extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TestBase TestBase;
	com.crm.qa.pages.international_Booking_Page international_Booking_Page;
	
			
	public international_BookingPageTest(){
		super();
		}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		international_Booking_Page = new com.crm.qa.pages.international_Booking_Page();
		
	}

	@Test(priority=1)
	public void verifyhomepage() throws InterruptedException{
		homePage.verifyHomePageurl();
	}
	
	@Test(priority=2)
	public void verify_Int_Booking_gpage() throws InterruptedException{
		homePage.verifyHomePageurl();
		international_Booking_Page = new com.crm.qa.pages.international_Booking_Page();
		Thread.sleep(2000);
		international_Booking_Page.ClickOnNew_order_AWB();
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
	}
	
	
	@Test(priority=3)
	public void international_Import_With_HAWB_Lag_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		international_Booking_Page = new com.crm.qa.pages.international_Booking_Page();
		Thread.sleep(2000);
		international_Booking_Page.ClickOnNew_order_AWB();
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\international_Booking.xlsx";
        
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

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(org);
     		 System.out.println("This is my data value:- "+org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(des);
   		 System.out.println("This is my data value:- "+des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(2000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
    
    // To Enter Freight Forwarde  	
          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).click();
          	 Thread.sleep(2000);
          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).sendKeys("A",Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
      		 System.out.println("This is my data value:- "+gweight_B); 		 
				
	//select Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
 	//Select Route Destination
				//  String des  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
   //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
//Select Truck Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
					Thread.sleep(2000);
					System.out.println("Testing");
   //To Add HAWB Details
					driver.findElement(By.xpath("//*[contains(@class,'ng-star-inserted btn btnColor ml-5')]")).click();
					Thread.sleep(1000);
					
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,"1");
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB, pis);
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,gweight_B);
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,"Description");
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,ship);
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,con,Keys.ARROW_DOWN, Keys.ENTER);
					Thread.sleep(3000);	
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ARROW_DOWN,Keys.ENTER);
					driver.findElement(By.xpath("//*[@title='Add HAWB']")).sendKeys(Keys.TAB,Keys.ENTER);
					Thread.sleep(1000);					
					
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AWB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
            }
        }
	
	@Test(priority=4)
	public void international_Import_Gen_Single_Lag_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		international_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\international_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(1);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(org);
     		 System.out.println("This is my data value:- "+org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(des);
   		 System.out.println("This is my data value:- "+des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(2000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
	
  // To Enter Freight Forwarde  	
          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).click();
          	 Thread.sleep(2000);
          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).sendKeys("A",Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
      		 System.out.println("This is my data value:- "+gweight_B);			 
		
				
	//select Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
 	//Select Route Destination
				//  String des  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
   //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
//Select Truck Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
					Thread.sleep(2000);
					System.out.println("Testing");
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AWB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      				
            }
        }
	
	@Test(priority=5)
	public void international_Export_CNS_Single_lag_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		international_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\international_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(2);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(org);
     		 System.out.println("This is my data value:- "+org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(des);
   		 System.out.println("This is my data value:- "+des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(2000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);

	 // To Enter Freight Forwarde  	
	          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).click();
	          	 Thread.sleep(2000);
	          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).sendKeys("A",Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
	          	 System.out.println("This is my data value:- "+gweight_B);	
				 

				
	//select Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
 	//Select Route Destination
				//  String des  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
   //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
//Select Truck Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
					Thread.sleep(2000);
					System.out.println("Testing");
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AWB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      							  
		
            }
        }

	@Test(priority=6)
	public void international_Export_COU_Single_Lag_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		international_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\international_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(3);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(org);
     		 System.out.println("This is my data value:- "+org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(des);
   		 System.out.println("This is my data value:- "+des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(2000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);

	// To Enter Freight Forwarde  	
	          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).click();
	          	 Thread.sleep(2000);
	          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).sendKeys("A",Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
	          	 System.out.println("This is my data value:- "+gweight_B);			 
				 
				
	//select Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
 	//Select Route Destination
				//  String des  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
   //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
//Select Truck Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
					Thread.sleep(2000);
					System.out.println("Testing");
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AWB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  Thread.sleep(2000);
//					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      							  
			    	  
			    	  
            }
        }
	
	@Test(priority=7)
	public void international_Booking_Import_Gen_Double_leg_Gen_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		international_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\international_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(4);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(org);
     		 System.out.println("This is my data value:- "+org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(des);
   		 System.out.println("This is my data value:- "+des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(3000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
		
  // To Enter Freight Forwarde  	
	          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).click();
	          	 Thread.sleep(2000);
	          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).sendKeys("A",Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
	   	 System.out.println("This is my data value:- "+gweight_B);	
				
//----------select Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
		//Select via airport
				  String via_airport  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(via_airport);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
        //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
       //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
		
//-----------Flight Selection in Second Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
					 select1.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				//  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d1 = 0;
					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate1 = new Date();
						String Dateofsystem1 = formatdate1.format(SystemDate1);	
						//System.out.println(Dateofsystem1);
						String arr1[]=Dateofsystem1.split("/");
						String days1 = arr1[0];		
						int s1 = (int) Integer.parseInt(days1);
						String day1=String.valueOf(s1+d1); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
					  js1.executeScript("arguments[0].click()", datepicker1);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele1:alldaate1) 
					  {
						  String dt1 = ele1.getText();
						//  System.out.println(dt1);
						  

						   if(dt1.equals(day1))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele1.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
					
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AWB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		
					  	  
		
            }
        }
			    	  
	@Test(priority=8)
	public void international_Booking_Import_Double_leg_HAWB_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		international_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\international_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(5);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(org);
     		 System.out.println("This is my data value:- "+org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(des);
   		 System.out.println("This is my data value:- "+des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(3000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
		
  // To Enter Freight Forwarde  	
	          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).click();
	          	 Thread.sleep(2000);
	          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).sendKeys("A",Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
	          	 System.out.println("This is my data value:- "+gweight_B);	

	   	 
//----------select Flight in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
		//Select Route Destination
				  String via_airport  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(via_airport);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
        //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
       //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
		
//-----------Flight Selection in Second Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
					 select1.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				 // String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d1 = 0;
					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate1 = new Date();
						String Dateofsystem1 = formatdate1.format(SystemDate1);	
						//System.out.println(Dateofsystem1);
						String arr1[]=Dateofsystem1.split("/");
						String days1 = arr1[0];		
						int s1 = (int) Integer.parseInt(days1);
						String day1=String.valueOf(s1+d1); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
					  js1.executeScript("arguments[0].click()", datepicker1);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele1:alldaate1) 
					  {
						  String dt1 = ele1.getText();
						//  System.out.println(dt1);
						  

						   if(dt1.equals(day1))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele1.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
 //To Add HAWB Details
					driver.findElement(By.xpath("//*[contains(@class,'ng-star-inserted btn btnColor ml-5')]")).click();
					Thread.sleep(1000);
					
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,"1");
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB, pis);
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,gweight_B);
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,"Description");
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,ship);
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,con,Keys.ARROW_DOWN, Keys.ENTER);
					Thread.sleep(3000);	
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ARROW_DOWN,Keys.ENTER);
					driver.findElement(By.xpath("//*[@title='Add HAWB']")).sendKeys(Keys.TAB,Keys.ENTER);
					Thread.sleep(1000);					

					
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AWB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		
					  	  
		
            }
        }
            
	@Test(priority=9)
	public void international_Booking_Export_Double_leg_Gen_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		international_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\international_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(6);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(org);
     		 System.out.println("This is my data value:- "+org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(des);
   		 System.out.println("This is my data value:- "+des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(3000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
		
  // To Enter Freight Forwarde  	
	          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).click();
	          	 Thread.sleep(2000);
	          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).sendKeys("A",Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
	          	 System.out.println("This is my data value:- "+gweight_B);	

	   	 
//----------select Flight in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
		//Select Route Destination
				  String Via_Airport  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Via_Airport);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
        //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
       //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
		
//-----------Flight Selection in Second Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
					 select1.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				//  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d1 = 0;
					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate1 = new Date();
						String Dateofsystem1 = formatdate1.format(SystemDate1);	
						//System.out.println(Dateofsystem1);
						String arr1[]=Dateofsystem1.split("/");
						String days1 = arr1[0];		
						int s1 = (int) Integer.parseInt(days1);
						String day1=String.valueOf(s1+d1); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
					  js1.executeScript("arguments[0].click()", datepicker1);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele1:alldaate1) 
					  {
						  String dt1 = ele1.getText();
						//  System.out.println(dt1);
						  

						   if(dt1.equals(day1))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele1.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
					
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AWB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		Thread.sleep(3000);
					  	  
		
        }
    }
	
	@Test(priority=10)
	public void international_Booking_Export_Dubleleg_Gen_HAWB_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		international_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\international_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(7);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(org);
     		 System.out.println("This is my data value:- "+org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(des);
   		 System.out.println("This is my data value:- "+des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(3000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
  
// To Enter Freight Forwarde  	
	          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).click();
	          	 Thread.sleep(2000);
	          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).sendKeys("A",Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
	          	 System.out.println("This is my data value:- "+gweight_B);	
		
				
//----------select Flight in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
		//Select Route Destination
				  String via_airport  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(via_airport);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
        //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
       //Select Flight number Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
		
//-----------Second Flight Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
					 select1.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				 // String via_airport1  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d1 = 0;
					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate1 = new Date();
						String Dateofsystem1 = formatdate1.format(SystemDate1);	
						//System.out.println(Dateofsystem1);
						String arr1[]=Dateofsystem1.split("/");
						String days1 = arr1[0];		
						int s1 = (int) Integer.parseInt(days1);
						String day1=String.valueOf(s1+d1); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
					  js1.executeScript("arguments[0].click()", datepicker1);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele1:alldaate1) 
					  {
						  String dt1 = ele1.getText();
						//  System.out.println(dt1);
						  

						   if(dt1.equals(day1))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele1.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					//-----------Flight Selection in Second Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
					
	 //To Add HAWB Details
					driver.findElement(By.xpath("//*[contains(@class,'ng-star-inserted btn btnColor ml-5')]")).click();
					Thread.sleep(1000);
					
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,"1");
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB, pis);
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,gweight_B);
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,"Description");
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,ship);
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,con,Keys.ARROW_DOWN, Keys.ENTER);
					Thread.sleep(3000);	
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ARROW_DOWN,Keys.ENTER);
					driver.findElement(By.xpath("//*[@title='Add HAWB']")).sendKeys(Keys.TAB,Keys.ENTER);
					Thread.sleep(1000);							
					
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AWB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(3000);
					  	  		
        

        }
    }

	@Test(priority=11)
	public void international_Booking_Export_Duble_leg_AVI_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		international_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\international_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(8);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(org);
     		 System.out.println("This is my data value:- "+org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(des);
   		 System.out.println("This is my data value:- "+des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(3000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
  
// To Enter Freight Forwarde  	
	          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).click();
	          	 Thread.sleep(2000);
	          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).sendKeys("A",Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
	          	 System.out.println("This is my data value:- "+gweight_B);	
		
				
//----------select Flight in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
		//Select Route Destination
				  String via_airport  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(via_airport);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
        //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
       //Select Truck number Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
		
//-----------Second Flight Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
					 select1.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				//  String via_Airport1  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d1 = 0;
					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate1 = new Date();
						String Dateofsystem1 = formatdate1.format(SystemDate1);	
						//System.out.println(Dateofsystem1);
						String arr1[]=Dateofsystem1.split("/");
						String days1 = arr1[0];		
						int s1 = (int) Integer.parseInt(days1);
						String day1=String.valueOf(s1+d1); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
					  js1.executeScript("arguments[0].click()", datepicker1);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele1:alldaate1) 
					  {
						  String dt1 = ele1.getText();
						//  System.out.println(dt1);
						  

						   if(dt1.equals(day1))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele1.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					//-----------Flight Selection in Second Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
					
					
					
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AWB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		Thread.sleep(3000);
					  	  		
        

        }
    }
	
	@Test(priority=12)
	public void international_Booking_Export_Single_leg_GEN_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		international_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\international_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(9);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(org);
     		 System.out.println("This is my data value:- "+org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(des);
   		 System.out.println("This is my data value:- "+des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(3000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);

 // To Enter Freight Forwarde  	
	          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).click();
	          	 Thread.sleep(2000);
	          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).sendKeys("A",Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
	          	 System.out.println("This is my data value:- "+gweight_B);	
				 
				 
				
//----------select Flight in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
		//Select Route Destination
				//  String Via_airport  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
        //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
       //Select Flight number Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
		
					
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AWB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		Thread.sleep(3000);

        }
    }

	@Test(priority=13)
	public void international_Booking_Export_Single_leg_Gen_HAWB_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		international_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\international_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(10);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(org);
     		 System.out.println("This is my data value:- "+org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(des);
   		 System.out.println("This is my data value:- "+des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(3000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);

 // To Enter Freight Forwarde  	
	          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).click();
	          	 Thread.sleep(2000);
	          	 driver.findElement(By.xpath("//*[@name='freight_forwarder']")).sendKeys("A",Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
	          	 System.out.println("This is my data value:- "+gweight_B);	
				 
				 
				
//----------select Flight in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
		//Select Route Destination
				//  String Via_airport  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
        //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
       //Select Flight number Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
					Thread.sleep(2000);

	//To Add HAWB Details
					driver.findElement(By.xpath("//*[contains(@class,'ng-star-inserted btn btnColor ml-5')]")).click();
					Thread.sleep(1000);
					
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,"1");
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB, pis);
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,gweight_B);
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,"Description");
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,ship);
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,con,Keys.ARROW_DOWN, Keys.ENTER);
					Thread.sleep(3000);	
					driver.findElement(By.xpath("//*[@name='isChecked']")).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ARROW_DOWN,Keys.ENTER);
					driver.findElement(By.xpath("//*[@title='Add HAWB']")).sendKeys(Keys.TAB,Keys.ENTER);
					Thread.sleep(1000);		
					
		
					
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AWB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		Thread.sleep(3000);

        }
    }
	
	
//	@Test(priority=16)
//	public void A2A_Postpaid_DGR_First_Leg_flow() throws InterruptedException, IOException{
//		homePage.verifyHomePageurl();
//		A2A_Booking_Page.ClickOnNew_order_AWB();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
//		
//		// Specify the path to your Excel file
//        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\A2A_Booking.xlsx";
//        
//     // Create a FileInputStream to read the Excel file
//        FileInputStream fis = new FileInputStream(new File(excelFilePath));
//        
//        // Create a workbook object
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        
//        // Get the first sheet (index 0)
//        XSSFSheet sheet = workbook.getSheetAt(13);
//        
//       int Lastrow = sheet.getLastRowNum();
//       
//       System.out.println("This is the last row count:- "+Lastrow);
//        // Iterate through rows
//        for (int i = 1; i<= 1; i++) {
//
//            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//  	
//        // To Enter Orging on top of the booking page	
//        	 String org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(org);
//     		 System.out.println("This is my data value:- "+org);
//     		//Thread.sleep(1000);
//     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//    // To Enter Destination  on top of the booking page	
//       	 String des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
//       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(des);
//   		 System.out.println("This is my data value:- "+des);
//    	// Thread.sleep(1000);
//    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//      // To Enter Commodity Code  on top of the booking page	
//          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
//      		 System.out.println("This is my data value:- "+com);
//       		Thread.sleep(2000);  
//       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//       		
//      // To Enter Shipper  on top of the booking page	
//         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
//     		 System.out.println("This is my data value:- "+ship);
//      		Thread.sleep(1000);		
//      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//      		
//      // To Enter Consignee   on top of the booking page	
//        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
//    		 System.out.println("This is my data value:- "+con);
//     		   		
//    	
//    // To Enter Pieces    on top of the booking page	
//       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
//   		 System.out.println("This is my data value:- "+pis);
//    		 	
//     
//    // To Enter Gross Weight (Kg)  on top of the booking page	
//          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
//      		 System.out.println("This is my data value:- "+gweight_B);
//       				
//    //Gross Weight Window Open
//				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
//				Thread.sleep(2000);
//				
//				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_l); //Length
//				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_h); //Width
//				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height
//
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
//				 Thread.sleep(1000);
//				 
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
//				 Thread.sleep(1000);
//		
//				
//	//select Flight in route
//					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
//					 select.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
// 	//Select Route Destination
//				//  String des  =  sheet.getRow(i).getCell(13).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//   //To Get Today Date
//				 		int d = 0;
//					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate = new Date();
//						String Dateofsystem = formatdate.format(SystemDate);	
//						//System.out.println(Dateofsystem);
//						String arr[]=Dateofsystem.split("/");
//						String days = arr[0];		
//						int s = (int) Integer.parseInt(days);
//						String day=String.valueOf(s+d); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js =(JavascriptExecutor)driver;
//					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
//					  js.executeScript("arguments[0].click()", datepicker);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele:alldaate) 
//					  {
//						  String dt = ele.getText();
//						//  System.out.println(dt);
//						  
//
//						   if(dt.equals(day))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele.click();
//							  break;
//						  }
//						 
//					  }
//					  
////Select Truck Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
//					Thread.sleep(2000);
//					System.out.println("Testing");
////To Add DGR Details
//					driver.findElement(By.xpath("//*[contains(@class,'ng-star-inserted btn btnColor ml-5')]")).click();
//					Thread.sleep(1000);
//					
//					driver.findElement(By.xpath("//*[@name='unid']")).sendKeys("1");
//					driver.findElement(By.xpath("//*[@name='shc']")).sendKeys(com);
//					driver.findElement(By.xpath("//*[@name='class']")).sendKeys("1");
//					
//					driver.findElement(By.xpath("//input[@name='description']")).sendKeys("DGR");
//					driver.findElement(By.xpath("//*[@name='pieces']")).sendKeys(pis);
//					driver.findElement(By.xpath("//*[@name='weight']")).sendKeys(gweight_B);
//					driver.findElement(By.xpath("//*[@name='imp_code']")).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);
//					Thread.sleep(1000);
////To Save Booking
//				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
//				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      	Thread.sleep(11000);	
//			      	
//					  
//		     		//To Capture the PopUp msg when we submit 
//		            
//		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
//		         System.out.println("Whai is error msg:- "+popupText );
//		    
//		        
//		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
//		         String newText = parts[0]; // Access the part after "is"
//		         
//		         String[] parts1 = newText.split("AWB"); // Split the text using "is" as a delimiter
//		         String newText1 = parts1[1]; // Access the part after "is"
//		         System.out.println(newText1);
//		          
//		 		Assert.assertEquals(" Saved ",newText1);
//		           
//					 
// // To Execute The AWB		  
//					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
//					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			    	  Thread.sleep(11000);	
// //To Accpet the AWB
//						
//					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
//					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
//					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
//					  
//					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);					  
//		
//            }
//        }
//	
//	@Test(priority=17)
//	public void A2ABooking_Postpaid_Gen_Single_Leg_flow() throws InterruptedException, IOException{
//		homePage.verifyHomePageurl();
//		A2A_Booking_Page.ClickOnNew_order_AWB();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
//		
//		// Specify the path to your Excel file
//        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\A2A_Booking.xlsx";
//        
//     // Create a FileInputStream to read the Excel file
//        FileInputStream fis = new FileInputStream(new File(excelFilePath));
//        
//        // Create a workbook object
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        
//        // Get the first sheet (index 0)
//        XSSFSheet sheet = workbook.getSheetAt(14);
//        
//       int Lastrow = sheet.getLastRowNum();
//       
//       System.out.println("This is the last row count:- "+Lastrow);
//        // Iterate through rows
//        for (int i = 1; i<= 1; i++) {
//
//            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//  	
//        // To Enter Orging on top of the booking page	
//        	 String org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(org);
//     		 System.out.println("This is my data value:- "+org);
//     		//Thread.sleep(1000);
//     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//    // To Enter Destination  on top of the booking page	
//       	 String des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
//       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(des);
//   		 System.out.println("This is my data value:- "+des);
//    	// Thread.sleep(1000);
//    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//      // To Enter Commodity Code  on top of the booking page	
//          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
//      		 System.out.println("This is my data value:- "+com);
//       		Thread.sleep(2000);  
//       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//       		
//      // To Enter Shipper  on top of the booking page	
//         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
//     		 System.out.println("This is my data value:- "+ship);
//      		Thread.sleep(1000);		
//      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//      		
//      // To Enter Consignee   on top of the booking page	
//        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
//    		 System.out.println("This is my data value:- "+con);
//     		   		
//    	
//    // To Enter Pieces    on top of the booking page	
//       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
//   		 System.out.println("This is my data value:- "+pis);
//    		 	
//     
//    // To Enter Gross Weight (Kg)  on top of the booking page	
//          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
//      		 System.out.println("This is my data value:- "+gweight_B);
//       				
//    //Gross Weight Window Open
//				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
//				Thread.sleep(2000);
//				
//				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_l); //Length
//				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_h); //Width
//				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height
//
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
//				 Thread.sleep(1000);
//				 
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
//				 Thread.sleep(1000);
//		
//				
//	//select Flight in route
//					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
//					 select.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
// 	//Select Route Destination
//				//  String des  =  sheet.getRow(i).getCell(13).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//   //To Get Today Date
//				 		int d = 0;
//					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate = new Date();
//						String Dateofsystem = formatdate.format(SystemDate);	
//						//System.out.println(Dateofsystem);
//						String arr[]=Dateofsystem.split("/");
//						String days = arr[0];		
//						int s = (int) Integer.parseInt(days);
//						String day=String.valueOf(s+d); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js =(JavascriptExecutor)driver;
//					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
//					  js.executeScript("arguments[0].click()", datepicker);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele:alldaate) 
//					  {
//						  String dt = ele.getText();
//						//  System.out.println(dt);
//						  
//
//						   if(dt.equals(day))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele.click();
//							  break;
//						  }
//						 
//					  }
//					  
////Select Truck Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
//					Thread.sleep(2000);
//					System.out.println("Testing");
////To Save Booking
//				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
//				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      	Thread.sleep(11000);	
//			      	
//					  
//		     		//To Capture the PopUp msg when we submit 
//		            
//		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
//		         System.out.println("Whai is error msg:- "+popupText );
//		    
//		        
//		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
//		         String newText = parts[0]; // Access the part after "is"
//		         
//		         String[] parts1 = newText.split("AWB"); // Split the text using "is" as a delimiter
//		         String newText1 = parts1[1]; // Access the part after "is"
//		         System.out.println(newText1);
//		          
//		 		Assert.assertEquals(" Saved ",newText1);
//		           
//					 
// // To Execute The AWB		  
//					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
//					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			    	  Thread.sleep(11000);	
// //To Accpet the AWB
//						
//					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
//					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
//					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
//					  
//					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      				
//            }
//        }
//	
//	@Test(priority=18)
//	public void A2ABooking_PostPaid_Po_Mail_S_Single_Leg_flow() throws InterruptedException, IOException{
//		homePage.verifyHomePageurl();
//		A2A_Booking_Page.ClickOnNew_order_AWB();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
//		
//		// Specify the path to your Excel file
//        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\A2A_Booking.xlsx";
//        
//     // Create a FileInputStream to read the Excel file
//        FileInputStream fis = new FileInputStream(new File(excelFilePath));
//        
//        // Create a workbook object
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        
//        // Get the first sheet (index 0)
//        XSSFSheet sheet = workbook.getSheetAt(15);
//        
//       int Lastrow = sheet.getLastRowNum();
//       
//       System.out.println("This is the last row count:- "+Lastrow);
//        // Iterate through rows
//        for (int i = 1; i<= 1; i++) {
//
//            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//  	
//        // To Enter Orging on top of the booking page	
//        	 String org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(org);
//     		 System.out.println("This is my data value:- "+org);
//     		//Thread.sleep(1000);
//     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//    // To Enter Destination  on top of the booking page	
//       	 String des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
//       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(des);
//   		 System.out.println("This is my data value:- "+des);
//    	// Thread.sleep(1000);
//    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//      // To Enter Commodity Code  on top of the booking page	
//          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
//      		 System.out.println("This is my data value:- "+com);
//       		Thread.sleep(2000);  
//       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//       		
//      // To Enter Shipper  on top of the booking page	
//         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
//     		 System.out.println("This is my data value:- "+ship);
//      		Thread.sleep(1000);		
//      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//      		
//      // To Enter Consignee   on top of the booking page	
//        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
//    		 System.out.println("This is my data value:- "+con);
//     		   		
//    	
//    // To Enter Pieces    on top of the booking page	
//       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
//   		 System.out.println("This is my data value:- "+pis);
//    		 	
//     
//    // To Enter Gross Weight (Kg)  on top of the booking page	
//          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
//      		 System.out.println("This is my data value:- "+gweight_B);
//       				
//    //Gross Weight Window Open
//				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
//				Thread.sleep(2000);
//				
//				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_l); //Length
//				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_h); //Width
//				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height
//
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
//				 Thread.sleep(1000);
//				 
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
//				 Thread.sleep(1000);
//		
//				
//	//select Flight in route
//					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
//					 select.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
// 	//Select Route Destination
//				//  String des  =  sheet.getRow(i).getCell(13).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//   //To Get Today Date
//				 		int d = 0;
//					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate = new Date();
//						String Dateofsystem = formatdate.format(SystemDate);	
//						//System.out.println(Dateofsystem);
//						String arr[]=Dateofsystem.split("/");
//						String days = arr[0];		
//						int s = (int) Integer.parseInt(days);
//						String day=String.valueOf(s+d); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js =(JavascriptExecutor)driver;
//					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
//					  js.executeScript("arguments[0].click()", datepicker);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele:alldaate) 
//					  {
//						  String dt = ele.getText();
//						//  System.out.println(dt);
//						  
//
//						   if(dt.equals(day))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele.click();
//							  break;
//						  }
//						 
//					  }
//					  
////Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
//					Thread.sleep(2000);
//					System.out.println("Testing");
////To Save Booking
//				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
//				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      	Thread.sleep(11000);	
//			      	
//					  
//		     		//To Capture the PopUp msg when we submit 
//		            
//		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
//		         System.out.println("Whai is error msg:- "+popupText );
//		    
//		        
//		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
//		         String newText = parts[0]; // Access the part after "is"
//		         
//		         String[] parts1 = newText.split("AWB"); // Split the text using "is" as a delimiter
//		         String newText1 = parts1[1]; // Access the part after "is"
//		         System.out.println(newText1);
//		          
//		 		Assert.assertEquals(" Saved ",newText1);
//		           
//					 
// // To Execute The AWB		  
//					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
//					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			    	  Thread.sleep(11000);	
// //To Accpet the AWB
//						
//					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
//					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
//					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
//					  
//					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      							  
//		
//            }
//        }
//
//	@Test(priority=19)
//	public void A2ABooking_Postpaid_Walking_Single_Leg_flow() throws InterruptedException, IOException{
//		homePage.verifyHomePageurl();
//		A2A_Booking_Page.ClickOnNew_order_AWB();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
//		
//		// Specify the path to your Excel file
//        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\A2A_Booking.xlsx";
//        
//     // Create a FileInputStream to read the Excel file
//        FileInputStream fis = new FileInputStream(new File(excelFilePath));
//        
//        // Create a workbook object
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        
//        // Get the first sheet (index 0)
//        XSSFSheet sheet = workbook.getSheetAt(16);
//        
//       int Lastrow = sheet.getLastRowNum();
//       
//       System.out.println("This is the last row count:- "+Lastrow);
//        // Iterate through rows
//        for (int i = 1; i<= 1; i++) {
//
//            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//  	
//        // To Enter Orging on top of the booking page	
//        	 String org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(org);
//     		 System.out.println("This is my data value:- "+org);
//     		//Thread.sleep(1000);
//     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//    // To Enter Destination  on top of the booking page	
//       	 String des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
//       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(des);
//   		 System.out.println("This is my data value:- "+des);
//    	// Thread.sleep(1000);
//    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//      // To Enter Commodity Code  on top of the booking page	
//          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
//      		 System.out.println("This is my data value:- "+com);
//       		Thread.sleep(2000);  
//       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//       		
//      // To Enter Shipper  on top of the booking page	
//         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
//     		 System.out.println("This is my data value:- "+ship);
//      		Thread.sleep(1000);		
//      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//      		
//      // To Enter Consignee   on top of the booking page	
//        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
//    		 System.out.println("This is my data value:- "+con);
//     		   		
//    	
//    // To Enter Pieces    on top of the booking page	
//       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
//   		 System.out.println("This is my data value:- "+pis);
//    		 	
//     
//    // To Enter Gross Weight (Kg)  on top of the booking page	
//          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
//      		 System.out.println("This is my data value:- "+gweight_B);
//       				
//    //Gross Weight Window Open
//				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
//				Thread.sleep(2000);
//				
//				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_l); //Length
//				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_h); //Width
//				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height
//
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
//				 Thread.sleep(1000);
//				 
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
//				 Thread.sleep(1000);
//		
//				
//	//select Flight in route
//					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
//					 select.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
// 	//Select Route Destination
//				//  String des  =  sheet.getRow(i).getCell(13).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//   //To Get Today Date
//				 		int d = 0;
//					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate = new Date();
//						String Dateofsystem = formatdate.format(SystemDate);	
//						//System.out.println(Dateofsystem);
//						String arr[]=Dateofsystem.split("/");
//						String days = arr[0];		
//						int s = (int) Integer.parseInt(days);
//						String day=String.valueOf(s+d); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js =(JavascriptExecutor)driver;
//					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
//					  js.executeScript("arguments[0].click()", datepicker);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele:alldaate) 
//					  {
//						  String dt = ele.getText();
//						//  System.out.println(dt);
//						  
//
//						   if(dt.equals(day))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele.click();
//							  break;
//						  }
//						 
//					  }
//					  
////Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
//					Thread.sleep(2000);
//					System.out.println("Testing");
////To Save Booking
//				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
//				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      	Thread.sleep(11000);	
//			      	
//					  
////To Capture the PopUp msg when we submit 
//		            
//		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
//		         System.out.println("Whai is error msg:- "+popupText );
//		    
//		        
//		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
//		         String newText = parts[0]; // Access the part after "is"
//		         
//		         String[] parts1 = newText.split("AWB"); // Split the text using "is" as a delimiter
//		         String newText1 = parts1[1]; // Access the part after "is"
//		         System.out.println(newText1);
//		          
//		 		Assert.assertEquals(" Saved ",newText1);
//		           
//					 
// // To Execute The AWB		  
//					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
//					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			    	  Thread.sleep(11000);	
// //To Accpet the AWB
//						
//					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
//					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
//					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
//					  Thread.sleep(2000);
////					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
////			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      							  
////To Collect Button
//			  
//			    	  driver.findElement(By.xpath("//button[@title='Collect']")).click();
//			    	  Thread.sleep(2000);
//			    	  driver.findElement(By.xpath("//*[@title='Pay']")).isDisplayed();
//			    	  Thread.sleep(2000);
//			    	  driver.findElement(By.xpath("//*[@title='Pay']")).click();
//			    	  Thread.sleep(3000);
//			    	//To Capture the Collect Msg PopUp
//			            
//				     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//				         String Collectmsg  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
//				         System.out.println("Whai is error msg:- "+Collectmsg );
//				    
//				        
//				         String[] partc = Collectmsg.split("Collecion"); // Split the text using "is" as a delimiter
//				         String newTextmsg = partc[1]; // Access the part after "is"
//				         
////				         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
////				         String newText1 = parts1[1]; // Access the part after "is"
//				         System.out.println(newTextmsg);
//				          
//				 		Assert.assertEquals(" Successfully Submitted",newTextmsg);
//			    	  
//			    	  
//			    	  
//            }
//        }
//	
//	@Test(priority=20)
//	public void A2ABooking_PostPaid_Double_leg_Gen_flow() throws InterruptedException, IOException{
//		homePage.verifyHomePageurl();
//		A2A_Booking_Page.ClickOnNew_order_AWB();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
//		
//		// Specify the path to your Excel file
//        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\A2A_Booking.xlsx";
//        
//     // Create a FileInputStream to read the Excel file
//        FileInputStream fis = new FileInputStream(new File(excelFilePath));
//        
//        // Create a workbook object
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        
//        // Get the first sheet (index 0)
//        XSSFSheet sheet = workbook.getSheetAt(17);
//        
//       int Lastrow = sheet.getLastRowNum();
//       
//       System.out.println("This is the last row count:- "+Lastrow);
//        // Iterate through rows
//        for (int i = 1; i<= 1; i++) {
//
//            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//  	
//        // To Enter Orging on top of the booking page	
//        	 String org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(org);
//     		 System.out.println("This is my data value:- "+org);
//     		//Thread.sleep(1000);
//     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//    // To Enter Destination  on top of the booking page	
//       	 String des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
//       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(des);
//   		 System.out.println("This is my data value:- "+des);
//    	// Thread.sleep(1000);
//    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//      // To Enter Commodity Code  on top of the booking page	
//          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
//      		 System.out.println("This is my data value:- "+com);
//       		Thread.sleep(3000);  
//       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//       		
//      // To Enter Shipper  on top of the booking page	
//         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
//     		 System.out.println("This is my data value:- "+ship);
//      		Thread.sleep(1000);		
//      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//      		
//      // To Enter Consignee   on top of the booking page	
//        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
//    		 System.out.println("This is my data value:- "+con);
//     		   		
//    	
//    // To Enter Pieces    on top of the booking page	
//       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
//   		 System.out.println("This is my data value:- "+pis);
//    		 	
//     
//    // To Enter Gross Weight (Kg)  on top of the booking page	
//          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
//      		 System.out.println("This is my data value:- "+gweight_B);
//       				
//    //Gross Weight Window Open
//				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
//				Thread.sleep(2000);
//				
//				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_l); //Length
//				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_h); //Width
//				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height
//
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
//				 Thread.sleep(1000);
//				 
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
//				 Thread.sleep(1000);
//		
//				
////----------select Flight in route
//					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
//					 select.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//		//Select Route Destination
//				  String Via_airport  =  sheet.getRow(i).getCell(13).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Via_airport);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//        //To Get Today Date
//				 		int d = 0;
//					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate = new Date();
//						String Dateofsystem = formatdate.format(SystemDate);	
//						//System.out.println(Dateofsystem);
//						String arr[]=Dateofsystem.split("/");
//						String days = arr[0];		
//						int s = (int) Integer.parseInt(days);
//						String day=String.valueOf(s+d); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js =(JavascriptExecutor)driver;
//					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
//					  js.executeScript("arguments[0].click()", datepicker);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele:alldaate) 
//					  {
//						  String dt = ele.getText();
//						//  System.out.println(dt);
//						  
//
//						   if(dt.equals(day))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele.click();
//							  break;
//						  }
//						 
//					  }
//					  
//       //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
//					Thread.sleep(2000);
//					
//		
////-----------Flight Selection in Second Leg
//
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//				//To Select second leg Flight	
//					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
//					 select1.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				  //String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d1 = 0;
//					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate1 = new Date();
//						String Dateofsystem1 = formatdate1.format(SystemDate1);	
//						//System.out.println(Dateofsystem1);
//						String arr1[]=Dateofsystem1.split("/");
//						String days1 = arr1[0];		
//						int s1 = (int) Integer.parseInt(days1);
//						String day1=String.valueOf(s1+d1); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
//					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
//					  js1.executeScript("arguments[0].click()", datepicker1);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele1:alldaate1) 
//					  {
//						  String dt1 = ele1.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt1.equals(day1))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele1.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//					
//					
////To Save Booking
//				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
//				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      	Thread.sleep(11000);	
//			      	
//					  
//		     		//To Capture the PopUp msg when we submit 
//		            
//		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
//		         System.out.println("Whai is error msg:- "+popupText );
//		    
//		        
//		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
//		         String newText = parts[0]; // Access the part after "is"
//		         
//		         String[] parts1 = newText.split("AWB"); // Split the text using "is" as a delimiter
//		         String newText1 = parts1[1]; // Access the part after "is"
//		         System.out.println(newText1);
//		          
//		 		Assert.assertEquals(" Saved ",newText1);
//		           
//					 
// // To Execute The AWB		  
//					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
//					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			    	  Thread.sleep(11000);	
// //To Accpet the AWB
//						
//					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
//					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
//					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
//					  
//					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      		
//					  	  
//		
//            }
//        }
//			    	  
//	@Test(priority=21)
//	public void A2A_Postpaid_Duble_leg_PoMail_flow() throws InterruptedException, IOException{
//		homePage.verifyHomePageurl();
//		A2A_Booking_Page.ClickOnNew_order_AWB();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
//		
//		// Specify the path to your Excel file
//        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\A2A_Booking.xlsx";
//        
//     // Create a FileInputStream to read the Excel file
//        FileInputStream fis = new FileInputStream(new File(excelFilePath));
//        
//        // Create a workbook object
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        
//        // Get the first sheet (index 0)
//        XSSFSheet sheet = workbook.getSheetAt(18);
//        
//       int Lastrow = sheet.getLastRowNum();
//       
//       System.out.println("This is the last row count:- "+Lastrow);
//        // Iterate through rows
//        for (int i = 1; i<= 1; i++) {
//
//            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//  	
//        // To Enter Orging on top of the booking page	
//        	 String org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(org);
//     		 System.out.println("This is my data value:- "+org);
//     		//Thread.sleep(1000);
//     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//    // To Enter Destination  on top of the booking page	
//       	 String des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
//       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(des);
//   		 System.out.println("This is my data value:- "+des);
//    	// Thread.sleep(1000);
//    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//      // To Enter Commodity Code  on top of the booking page	
//          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
//      		 System.out.println("This is my data value:- "+com);
//       		Thread.sleep(3000);  
//       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//       		
//      // To Enter Shipper  on top of the booking page	
//         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
//     		 System.out.println("This is my data value:- "+ship);
//      		Thread.sleep(1000);		
//      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//      		
//      // To Enter Consignee   on top of the booking page	
//        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
//    		 System.out.println("This is my data value:- "+con);
//     		   		
//    	
//    // To Enter Pieces    on top of the booking page	
//       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
//   		 System.out.println("This is my data value:- "+pis);
//    		 	
//     
//    // To Enter Gross Weight (Kg)  on top of the booking page	
//          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
//      		 System.out.println("This is my data value:- "+gweight_B);
//       				
//    //Gross Weight Window Open
//				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
//				Thread.sleep(2000);
//				
//				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_l); //Length
//				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_h); //Width
//				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height
//
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
//				 Thread.sleep(1000);
//				 
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
//				 Thread.sleep(1000);
//		
//				
////----------select Flight in route
//					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
//					 select.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//		//Select Route Destination
//				  String via_Airport  =  sheet.getRow(i).getCell(13).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(via_Airport);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//        //To Get Today Date
//				 		int d = 0;
//					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate = new Date();
//						String Dateofsystem = formatdate.format(SystemDate);	
//						//System.out.println(Dateofsystem);
//						String arr[]=Dateofsystem.split("/");
//						String days = arr[0];		
//						int s = (int) Integer.parseInt(days);
//						String day=String.valueOf(s+d); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js =(JavascriptExecutor)driver;
//					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
//					  js.executeScript("arguments[0].click()", datepicker);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele:alldaate) 
//					  {
//						  String dt = ele.getText();
//						//  System.out.println(dt);
//						  
//
//						   if(dt.equals(day))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele.click();
//							  break;
//						  }
//						 
//					  }
//					  
//       //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
//					Thread.sleep(2000);
//					
//		
////-----------Flight Selection in Second Leg
//
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//				//To Select second leg Flight	
//					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
//					 select1.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				 // String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d1 = 0;
//					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate1 = new Date();
//						String Dateofsystem1 = formatdate1.format(SystemDate1);	
//						//System.out.println(Dateofsystem1);
//						String arr1[]=Dateofsystem1.split("/");
//						String days1 = arr1[0];		
//						int s1 = (int) Integer.parseInt(days1);
//						String day1=String.valueOf(s1+d1); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
//					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
//					  js1.executeScript("arguments[0].click()", datepicker1);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele1:alldaate1) 
//					  {
//						  String dt1 = ele1.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt1.equals(day1))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele1.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//					
//					
////To Save Booking
//				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
//				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      	Thread.sleep(11000);	
//			      	
//					  
//		     		//To Capture the PopUp msg when we submit 
//		            
//		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
//		         System.out.println("Whai is error msg:- "+popupText );
//		    
//		        
//		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
//		         String newText = parts[0]; // Access the part after "is"
//		         
//		         String[] parts1 = newText.split("AWB"); // Split the text using "is" as a delimiter
//		         String newText1 = parts1[1]; // Access the part after "is"
//		         System.out.println(newText1);
//		          
//		 		Assert.assertEquals(" Saved ",newText1);
//		           
//					 
// // To Execute The AWB		  
//					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
//					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			    	  Thread.sleep(11000);	
// //To Accpet the AWB
//						
//					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
//					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
//					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
//					  
//					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      		
//					  	  
//		
//            }
//        }
//            
//	@Test(priority=22)
//	public void A2A_Postpaid_Duble_leg_Walking_flow() throws InterruptedException, IOException{
//		homePage.verifyHomePageurl();
//		A2A_Booking_Page.ClickOnNew_order_AWB();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
//		
//		// Specify the path to your Excel file
//        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\A2A_Booking.xlsx";
//        
//     // Create a FileInputStream to read the Excel file
//        FileInputStream fis = new FileInputStream(new File(excelFilePath));
//        
//        // Create a workbook object
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        
//        // Get the first sheet (index 0)
//        XSSFSheet sheet = workbook.getSheetAt(19);
//        
//       int Lastrow = sheet.getLastRowNum();
//       
//       System.out.println("This is the last row count:- "+Lastrow);
//        // Iterate through rows
//        for (int i = 1; i<= 1; i++) {
//
//            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//  	
//        // To Enter Orging on top of the booking page	
//        	 String org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(org);
//     		 System.out.println("This is my data value:- "+org);
//     		//Thread.sleep(1000);
//     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//    // To Enter Destination  on top of the booking page	
//       	 String des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
//       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(des);
//   		 System.out.println("This is my data value:- "+des);
//    	// Thread.sleep(1000);
//    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//      // To Enter Commodity Code  on top of the booking page	
//          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
//      		 System.out.println("This is my data value:- "+com);
//       		Thread.sleep(3000);  
//       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//       		
//      // To Enter Shipper  on top of the booking page	
//         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
//     		 System.out.println("This is my data value:- "+ship);
//      		Thread.sleep(1000);		
//      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//      		
//      // To Enter Consignee   on top of the booking page	
//        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
//    		 System.out.println("This is my data value:- "+con);
//     		   		
//    	
//    // To Enter Pieces    on top of the booking page	
//       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
//   		 System.out.println("This is my data value:- "+pis);
//    		 	
//     
//    // To Enter Gross Weight (Kg)  on top of the booking page	
//          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
//      		 System.out.println("This is my data value:- "+gweight_B);
//       				
//    //Gross Weight Window Open
//				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
//				Thread.sleep(2000);
//				
//				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_l); //Length
//				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_h); //Width
//				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height
//
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
//				 Thread.sleep(1000);
//				 
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
//				 Thread.sleep(1000);
//		
//				
////----------select Flight in route
//					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
//					 select.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//		//Select Route Destination Via
//				  String Vai_Airport  =  sheet.getRow(i).getCell(13).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Vai_Airport);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//        //To Get Today Date
//				 		int d = 0;
//					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate = new Date();
//						String Dateofsystem = formatdate.format(SystemDate);	
//						//System.out.println(Dateofsystem);
//						String arr[]=Dateofsystem.split("/");
//						String days = arr[0];		
//						int s = (int) Integer.parseInt(days);
//						String day=String.valueOf(s+d); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js =(JavascriptExecutor)driver;
//					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
//					  js.executeScript("arguments[0].click()", datepicker);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele:alldaate) 
//					  {
//						  String dt = ele.getText();
//						//  System.out.println(dt);
//						  
//
//						   if(dt.equals(day))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele.click();
//							  break;
//						  }
//						 
//					  }
//					  
//       //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
//					Thread.sleep(2000);
//					
//		
////-----------Flight Selection in Second Leg
//
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//				//To Select second leg Flight	
//					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
//					 select1.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				//  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d1 = 0;
//					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate1 = new Date();
//						String Dateofsystem1 = formatdate1.format(SystemDate1);	
//						//System.out.println(Dateofsystem1);
//						String arr1[]=Dateofsystem1.split("/");
//						String days1 = arr1[0];		
//						int s1 = (int) Integer.parseInt(days1);
//						String day1=String.valueOf(s1+d1); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
//					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
//					  js1.executeScript("arguments[0].click()", datepicker1);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele1:alldaate1) 
//					  {
//						  String dt1 = ele1.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt1.equals(day1))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele1.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//					
////To Save Booking
//				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
//				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      	Thread.sleep(11000);	
//			      	
//					  
//		     		//To Capture the PopUp msg when we submit 
//		            
//		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
//		         System.out.println("Whai is error msg:- "+popupText );
//		    
//		        
//		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
//		         String newText = parts[0]; // Access the part after "is"
//		         
//		         String[] parts1 = newText.split("AWB"); // Split the text using "is" as a delimiter
//		         String newText1 = parts1[1]; // Access the part after "is"
//		         System.out.println(newText1);
//		          
//		 		Assert.assertEquals(" Saved ",newText1);
//		           
//					 
// // To Execute The AWB		  
//					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
//					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			    	  Thread.sleep(11000);	
// //To Accpet the AWB
//						
//					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
//					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
//					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
//					  
//					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      		Thread.sleep(3000);
//					  	  
//		
//        
////To Collect Button
//	  
//	    	  driver.findElement(By.xpath("//button[@title='Collect']")).click();
//	    	  Thread.sleep(2000);
//	    	  driver.findElement(By.xpath("//*[@title='Pay']")).isDisplayed();
//	    	  Thread.sleep(2000);
//	    	  driver.findElement(By.xpath("//*[@title='Pay']")).click();
//	    	  Thread.sleep(3000);
//	    	//To Capture the Collect Msg PopUp
//	            
//		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		         String Collectmsg  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
//		         System.out.println("Whai is error msg:- "+Collectmsg );
//		    
//		        
//		         String[] partc = Collectmsg.split("Collecion"); // Split the text using "is" as a delimiter
//		         String newTextmsg = partc[1]; // Access the part after "is"
//		         
////		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
////		         String newText1 = parts1[1]; // Access the part after "is"
//		         System.out.println(newTextmsg);
//		          
//		 		Assert.assertEquals(" Successfully Submitted",newTextmsg);
//
//
//        }
//    }
//	
//	@Test(priority=23)
//	public void A2A_Postpaid_Triple_leg_Gen_flow() throws InterruptedException, IOException{
//		homePage.verifyHomePageurl();
//		A2A_Booking_Page.ClickOnNew_order_AWB();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
//		
//		// Specify the path to your Excel file
//        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\A2A_Booking.xlsx";
//        
//     // Create a FileInputStream to read the Excel file
//        FileInputStream fis = new FileInputStream(new File(excelFilePath));
//        
//        // Create a workbook object
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        
//        // Get the first sheet (index 0)
//        XSSFSheet sheet = workbook.getSheetAt(20);
//        
//       int Lastrow = sheet.getLastRowNum();
//       
//       System.out.println("This is the last row count:- "+Lastrow);
//        // Iterate through rows
//        for (int i = 1; i<= 1; i++) {
//
//            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//  	
//        // To Enter Orging on top of the booking page	
//        	 String org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(org);
//     		 System.out.println("This is my data value:- "+org);
//     		//Thread.sleep(1000);
//     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//    // To Enter Destination  on top of the booking page	
//       	 String des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
//       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(des);
//   		 System.out.println("This is my data value:- "+des);
//    	// Thread.sleep(1000);
//    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//      // To Enter Commodity Code  on top of the booking page	
//          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
//      		 System.out.println("This is my data value:- "+com);
//       		Thread.sleep(3000);  
//       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//       		
//      // To Enter Shipper  on top of the booking page	
//         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
//     		 System.out.println("This is my data value:- "+ship);
//      		Thread.sleep(1000);		
//      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//      		
//      // To Enter Consignee   on top of the booking page	
//        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
//    		 System.out.println("This is my data value:- "+con);
//     		   		
//    	
//    // To Enter Pieces    on top of the booking page	
//       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
//   		 System.out.println("This is my data value:- "+pis);
//    		 	
//     
//    // To Enter Gross Weight (Kg)  on top of the booking page	
//          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
//      		 System.out.println("This is my data value:- "+gweight_B);
//       				
//    //Gross Weight Window Open
//				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
//				Thread.sleep(2000);
//				
//				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_l); //Length
//				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_h); //Width
//				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height
//
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
//				 Thread.sleep(1000);
//				 
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
//				 Thread.sleep(1000);
//		
//				
////----------select Flight in route
//					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
//					 select.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//		//Select Route Destination
//				  String Vai_airport  =  sheet.getRow(i).getCell(13).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Vai_airport);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//        //To Get Today Date
//				 		int d = 0;
//					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate = new Date();
//						String Dateofsystem = formatdate.format(SystemDate);	
//						//System.out.println(Dateofsystem);
//						String arr[]=Dateofsystem.split("/");
//						String days = arr[0];		
//						int s = (int) Integer.parseInt(days);
//						String day=String.valueOf(s+d); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js =(JavascriptExecutor)driver;
//					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
//					  js.executeScript("arguments[0].click()", datepicker);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele:alldaate) 
//					  {
//						  String dt = ele.getText();
//						//  System.out.println(dt);
//						  
//
//						   if(dt.equals(day))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele.click();
//							  break;
//						  }
//						 
//					  }
//					  
//       //Select Flight number Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
//					Thread.sleep(2000);
//					
//		
////-----------First Flight Leg
//
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//				//To Select second leg Flight	
//					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
//					 select1.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				  String via_airport1  =  sheet.getRow(i).getCell(14).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(via_airport1);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d1 = 0;
//					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate1 = new Date();
//						String Dateofsystem1 = formatdate1.format(SystemDate1);	
//						//System.out.println(Dateofsystem1);
//						String arr1[]=Dateofsystem1.split("/");
//						String days1 = arr1[0];		
//						int s1 = (int) Integer.parseInt(days1);
//						String day1=String.valueOf(s1+d1); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
//					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
//					  js1.executeScript("arguments[0].click()", datepicker1);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele1:alldaate1) 
//					  {
//						  String dt1 = ele1.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt1.equals(day1))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele1.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//					//-----------Flight Selection in Second Leg
//
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//					
////-----------To Select Third leg Flight	
//					Select select2 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[1]//select")));
//					 select2.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				//  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d2 = 0;
//					  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate2 = new Date();
//						String Dateofsystem2 = formatdate2.format(SystemDate2);	
//						//System.out.println(Dateofsystem1);
//						String arr2[]=Dateofsystem2.split("/");
//						String days2 = arr2[0];		
//						int s2 = (int) Integer.parseInt(days2);
//						String day2=String.valueOf(s2+d2); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js2 =(JavascriptExecutor)driver;
//					  WebElement datepicker2 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[6]//input"));
//					  js2.executeScript("arguments[0].click()", datepicker2);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele2:alldaate2) 
//					  {
//						  String dt2 = ele2.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt2.equals(day2))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele2.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//
//					
//					
//					
////To Save Booking
//				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
//				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      	Thread.sleep(11000);	
//			      	
//					  
//		     		//To Capture the PopUp msg when we submit 
//		            
//		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
//		         System.out.println("Whai is error msg:- "+popupText );
//		    
//		        
//		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
//		         String newText = parts[0]; // Access the part after "is"
//		         
//		         String[] parts1 = newText.split("AWB"); // Split the text using "is" as a delimiter
//		         String newText1 = parts1[1]; // Access the part after "is"
//		         System.out.println(newText1);
//		          
//		 		Assert.assertEquals(" Saved ",newText1);
//		           
//					 
// // To Execute The AWB		  
//					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
//					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			    	  Thread.sleep(11000);	
// //To Accpet the AWB
//						
//					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
//					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
//					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
//					  
//					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      		Thread.sleep(3000);
//					  	  		
//        
//
//        }
//    }
//
//	@Test(priority=24)
//	public void A2A_Postpaid_Triple_leg_POMail_flow() throws InterruptedException, IOException{
//		homePage.verifyHomePageurl();
//		A2A_Booking_Page.ClickOnNew_order_AWB();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
//		
//		// Specify the path to your Excel file
//        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\A2A_Booking.xlsx";
//        
//     // Create a FileInputStream to read the Excel file
//        FileInputStream fis = new FileInputStream(new File(excelFilePath));
//        
//        // Create a workbook object
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        
//        // Get the first sheet (index 0)
//        XSSFSheet sheet = workbook.getSheetAt(21);
//        
//       int Lastrow = sheet.getLastRowNum();
//       
//       System.out.println("This is the last row count:- "+Lastrow);
//        // Iterate through rows
//        for (int i = 1; i<= 1; i++) {
//
//            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//  	
//        // To Enter Orging on top of the booking page	
//        	 String org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(org);
//     		 System.out.println("This is my data value:- "+org);
//     		//Thread.sleep(1000);
//     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//    // To Enter Destination  on top of the booking page	
//       	 String des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
//       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(des);
//   		 System.out.println("This is my data value:- "+des);
//    	// Thread.sleep(1000);
//    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//      // To Enter Commodity Code  on top of the booking page	
//          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
//      		 System.out.println("This is my data value:- "+com);
//       		Thread.sleep(3000);  
//       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//       		
//      // To Enter Shipper  on top of the booking page	
//         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
//     		 System.out.println("This is my data value:- "+ship);
//      		Thread.sleep(1000);		
//      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//      		
//      // To Enter Consignee   on top of the booking page	
//        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
//    		 System.out.println("This is my data value:- "+con);
//     		   		
//    	
//    // To Enter Pieces    on top of the booking page	
//       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
//   		 System.out.println("This is my data value:- "+pis);
//    		 	
//     
//    // To Enter Gross Weight (Kg)  on top of the booking page	
//          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
//      		 System.out.println("This is my data value:- "+gweight_B);
//       				
//    //Gross Weight Window Open
//				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
//				Thread.sleep(2000);
//				
//				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_l); //Length
//				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_h); //Width
//				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height
//
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
//				 Thread.sleep(1000);
//				 
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
//				 Thread.sleep(1000);
//		
//				
////----------select Flight in route
//					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
//					 select.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//		//Select Route Destination
//				  String via_apirport  =  sheet.getRow(i).getCell(13).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(via_apirport);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//        //To Get Today Date
//				 		int d = 0;
//					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate = new Date();
//						String Dateofsystem = formatdate.format(SystemDate);	
//						//System.out.println(Dateofsystem);
//						String arr[]=Dateofsystem.split("/");
//						String days = arr[0];		
//						int s = (int) Integer.parseInt(days);
//						String day=String.valueOf(s+d); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js =(JavascriptExecutor)driver;
//					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
//					  js.executeScript("arguments[0].click()", datepicker);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele:alldaate) 
//					  {
//						  String dt = ele.getText();
//						//  System.out.println(dt);
//						  
//
//						   if(dt.equals(day))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele.click();
//							  break;
//						  }
//						 
//					  }
//					  
//       //Select Truck number Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
//					Thread.sleep(2000);
//					
//		
////-----------Second Flight Leg
//
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//				//To Select second leg Flight	
//					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
//					 select1.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				  String via_airport1  =  sheet.getRow(i).getCell(14).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(via_airport1);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d1 = 0;
//					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate1 = new Date();
//						String Dateofsystem1 = formatdate1.format(SystemDate1);	
//						//System.out.println(Dateofsystem1);
//						String arr1[]=Dateofsystem1.split("/");
//						String days1 = arr1[0];		
//						int s1 = (int) Integer.parseInt(days1);
//						String day1=String.valueOf(s1+d1); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
//					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
//					  js1.executeScript("arguments[0].click()", datepicker1);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele1:alldaate1) 
//					  {
//						  String dt1 = ele1.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt1.equals(day1))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele1.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//					//-----------Flight Selection in Second Leg
//
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//					
////-----------To Select Third leg Flight	
//					Select select2 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[1]//select")));
//					 select2.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				//  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d2 = 0;
//					  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate2 = new Date();
//						String Dateofsystem2 = formatdate2.format(SystemDate2);	
//						//System.out.println(Dateofsystem1);
//						String arr2[]=Dateofsystem2.split("/");
//						String days2 = arr2[0];		
//						int s2 = (int) Integer.parseInt(days2);
//						String day2=String.valueOf(s2+d2); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js2 =(JavascriptExecutor)driver;
//					  WebElement datepicker2 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[6]//input"));
//					  js2.executeScript("arguments[0].click()", datepicker2);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele2:alldaate2) 
//					  {
//						  String dt2 = ele2.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt2.equals(day2))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele2.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//
//					
//										
////To Save Booking
//				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
//				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      	Thread.sleep(11000);	
//			      	
//					  
//		     		//To Capture the PopUp msg when we submit 
//		            
//		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
//		         System.out.println("Whai is error msg:- "+popupText );
//		    
//		        
//		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
//		         String newText = parts[0]; // Access the part after "is"
//		         
//		         String[] parts1 = newText.split("AWB"); // Split the text using "is" as a delimiter
//		         String newText1 = parts1[1]; // Access the part after "is"
//		         System.out.println(newText1);
//		          
//		 		Assert.assertEquals(" Saved ",newText1);
//		           
//					 
// // To Execute The AWB		  
//					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
//					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			    	  Thread.sleep(11000);	
// //To Accpet the AWB
//						
//					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
//					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
//					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
//					  
//					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      		Thread.sleep(3000);
//					  	  		
//        
//
//        }
//    }
//	@Test(priority=25)
//	public void D2D_Postpaid_Triple_leg_WLK_flow() throws InterruptedException, IOException{
//		homePage.verifyHomePageurl();
//		A2A_Booking_Page.ClickOnNew_order_AWB();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
//		
//		// Specify the path to your Excel file
//        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\A2A_Booking.xlsx";
//        
//     // Create a FileInputStream to read the Excel file
//        FileInputStream fis = new FileInputStream(new File(excelFilePath));
//        
//        // Create a workbook object
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        
//        // Get the first sheet (index 0)
//        XSSFSheet sheet = workbook.getSheetAt(22);
//        
//       int Lastrow = sheet.getLastRowNum();
//       
//       System.out.println("This is the last row count:- "+Lastrow);
//        // Iterate through rows
//        for (int i = 1; i<= 1; i++) {
//
//            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//  	
//        // To Enter Orging on top of the booking page	
//        	 String org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(org);
//     		 System.out.println("This is my data value:- "+org);
//     		//Thread.sleep(1000);
//     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//    // To Enter Destination  on top of the booking page	
//       	 String des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
//       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(des);
//   		 System.out.println("This is my data value:- "+des);
//    	// Thread.sleep(1000);
//    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//      // To Enter Commodity Code  on top of the booking page	
//          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
//      		 System.out.println("This is my data value:- "+com);
//       		Thread.sleep(3000);  
//       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//       		
//      // To Enter Shipper  on top of the booking page	
//         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
//     		 System.out.println("This is my data value:- "+ship);
//      		Thread.sleep(1000);		
//      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//      		
//      // To Enter Consignee   on top of the booking page	
//        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
//    		 System.out.println("This is my data value:- "+con);
//     		   		
//    	
//    // To Enter Pieces    on top of the booking page	
//       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
//   		 System.out.println("This is my data value:- "+pis);
//    		 	
//     
//    // To Enter Gross Weight (Kg)  on top of the booking page	
//          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
//      		 System.out.println("This is my data value:- "+gweight_B);
//       				
//    //Gross Weight Window Open
//				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
//				Thread.sleep(2000);
//				
//				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_l); //Length
//				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_h); //Width
//				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height
//
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
//				 Thread.sleep(1000);
//				 
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
//				 Thread.sleep(1000);
//		
//				
////----------select Flight in route
//					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
//					 select.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//		//Select Route Destination
//				  String Via_Airport  =  sheet.getRow(i).getCell(13).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Via_Airport);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//        //To Get Today Date
//				 		int d = 0;
//					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate = new Date();
//						String Dateofsystem = formatdate.format(SystemDate);	
//						//System.out.println(Dateofsystem);
//						String arr[]=Dateofsystem.split("/");
//						String days = arr[0];		
//						int s = (int) Integer.parseInt(days);
//						String day=String.valueOf(s+d); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js =(JavascriptExecutor)driver;
//					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
//					  js.executeScript("arguments[0].click()", datepicker);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele:alldaate) 
//					  {
//						  String dt = ele.getText();
//						//  System.out.println(dt);
//						  
//
//						   if(dt.equals(day))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele.click();
//							  break;
//						  }
//						 
//					  }
//					  
//       //Select Truck number Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
//					Thread.sleep(2000);
//					
//		
////-----------Second Flight Leg
//
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//				//To Select second leg Flight	
//					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
//					 select1.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				  String via_Airport1  =  sheet.getRow(i).getCell(14).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(via_Airport1);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d1 = 0;
//					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate1 = new Date();
//						String Dateofsystem1 = formatdate1.format(SystemDate1);	
//						//System.out.println(Dateofsystem1);
//						String arr1[]=Dateofsystem1.split("/");
//						String days1 = arr1[0];		
//						int s1 = (int) Integer.parseInt(days1);
//						String day1=String.valueOf(s1+d1); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
//					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
//					  js1.executeScript("arguments[0].click()", datepicker1);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele1:alldaate1) 
//					  {
//						  String dt1 = ele1.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt1.equals(day1))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele1.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//					//-----------Flight Selection in Second Leg
//
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//					
////-----------To Select second leg Flight	
//					Select select2 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[1]//select")));
//					 select2.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				  //String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d2 = 0;
//					  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate2 = new Date();
//						String Dateofsystem2 = formatdate2.format(SystemDate2);	
//						//System.out.println(Dateofsystem2);
//						String arr2[]=Dateofsystem2.split("/");
//						String days2 = arr2[0];		
//						int s2 = (int) Integer.parseInt(days2);
//						String day2=String.valueOf(s2+d2); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js2 =(JavascriptExecutor)driver;
//					  WebElement datepicker2 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[6]//input"));
//					  js2.executeScript("arguments[0].click()", datepicker2);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele2:alldaate2) 
//					  {
//						  String dt2 = ele2.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt2.equals(day2))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele2.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//
//					
//					
////To Save Booking
//				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
//				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      	Thread.sleep(11000);	
//			      	
//					  
//		     		//To Capture the PopUp msg when we submit 
//		            
//		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
//		         System.out.println("Whai is error msg:- "+popupText );
//		    
//		        
//		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
//		         String newText = parts[0]; // Access the part after "is"
//		         
//		         String[] parts1 = newText.split("AWB"); // Split the text using "is" as a delimiter
//		         String newText1 = parts1[1]; // Access the part after "is"
//		         System.out.println(newText1);
//		          
//		 		Assert.assertEquals(" Saved ",newText1);
//		           
//					 
// // To Execute The AWB		  
//					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
//					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			    	  Thread.sleep(11000);	
// //To Accpet the AWB
//						
//					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
//					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
//					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
//					  
//					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      		Thread.sleep(3000);
//
////To Collect Button
//			      	  
//			      	    	  driver.findElement(By.xpath("//button[@title='Collect']")).click();
//			      	    	  Thread.sleep(2000);
//			      	    	  driver.findElement(By.xpath("//*[@title='Pay']")).isDisplayed();
//			      	    	  Thread.sleep(2000);
//			      	    	  driver.findElement(By.xpath("//*[@title='Pay']")).click();
//			      	    	  Thread.sleep(3000);
//			      	    	//To Capture the Collect Msg PopUp
//			      	            
//			      		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      		         String Collectmsg  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
//			      		         System.out.println("Whai is error msg:- "+Collectmsg );
//			      		    
//			      		        
//			      		         String[] partc = Collectmsg.split("Collecion"); // Split the text using "is" as a delimiter
//			      		         String newTextmsg = partc[1]; // Access the part after "is"
//			      		         
////			      		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
////			      		         String newText1 = parts1[1]; // Access the part after "is"
//			      		         System.out.println(newTextmsg);
//			      		          
//			      		 		Assert.assertEquals(" Successfully Submitted",newTextmsg);
//			      					  	  		
//        
//
//        }
//}
//	
	
//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//	}
	
	}
	


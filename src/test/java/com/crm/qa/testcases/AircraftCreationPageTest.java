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
public class AircraftCreationPageTest  extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TestBase TestBase;
	com.crm.qa.pages.AircraftMasterListingPage AircraftMasterListingPage;
	com.crm.qa.pages.AircraftCreationPage AircraftCreationPage;
	
	public AircraftCreationPageTest(){
		super();
		}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		AircraftMasterListingPage = new com.crm.qa.pages.AircraftMasterListingPage();
		AircraftCreationPage = new com.crm.qa.pages.AircraftCreationPage();		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority=1)
	public void verifyhomepage() throws InterruptedException{
		homePage.verifyHomePageurl();
	}
	
	@Test(priority=2)
	public void verifyAircraftListingpage() throws InterruptedException{
		homePage.verifyHomePageurl();
		AircraftMasterListingPage.clickOnaircraftListingPage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/aircraft/list");
	}
	
	@Test(priority=3)
	public void ClickonNewAircraftButton() throws InterruptedException{
		homePage.verifyHomePageurl();
		AircraftMasterListingPage.clickOnaircraftListingPage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/aircraft/list");
		AircraftCreationPage.Clickonadvancefltr();
		AircraftCreationPage.veryfyNewAircraftpage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/aircraft/create");
	}
	
	@Test(priority=4)
	public void AircraftCreationPossitiveflow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		AircraftMasterListingPage.clickOnaircraftListingPage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/aircraft/list");
		AircraftCreationPage.Clickonadvancefltr();
		AircraftCreationPage.veryfyNewAircraftpage();
		
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/aircraft/create");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\Aircraft Master.xlsx";
        
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
         
         String Manufacturer  =  sheet.getRow(i).getCell(0).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='manufacturer']")).sendKeys(Manufacturer );
         System.out.println("This is my data value:- "+Manufacturer );
         
         String aircraft_type  =  sheet.getRow(i).getCell(1).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='aircraft_type']")).sendKeys(aircraft_type);
         System.out.println("This is my data value:- "+aircraft_type);
           
         String version =  sheet.getRow(i).getCell(2).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='version']")).sendKeys(version,Keys.ENTER);
         System.out.println("This is my data value:- "+version);
         
         String mtow =  sheet.getRow(i).getCell(3).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='mtow']")).sendKeys(mtow,Keys.ENTER);
         System.out.println("This is my data value:- "+mtow);
         
         String Unit =  sheet.getRow(i).getCell(4).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='maxzerofuel_wt_d_d']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='maxzerofuel_wt_d_d']")).sendKeys(Unit,Keys.ENTER);
         System.out.println("This is my data value:- "+Unit);
         
         String MaxZeroFuel_Wt =  sheet.getRow(i).getCell(5).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='maxzerofuel_wt']")).sendKeys(MaxZeroFuel_Wt,Keys.ENTER);
         System.out.println("This is my data value:- "+MaxZeroFuel_Wt);
         
         String Unit1 =  sheet.getRow(i).getCell(6).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='max_bulk_cap_vol_cubic']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='max_bulk_cap_vol_cubic']")).sendKeys(Unit1,Keys.ENTER);
         System.out.println("This is my data value:- "+Unit1);
         
         String Body_Type =  sheet.getRow(i).getCell(7).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='bodytype']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='bodytype']")).sendKeys(Body_Type,Keys.ENTER);
         System.out.println("This is my data value:- "+Body_Type);
           
         String Pax_Cap =  sheet.getRow(i).getCell(8).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='pax_cap']")).sendKeys(Pax_Cap,Keys.ENTER);
         System.out.println("This is my data value:- "+Pax_Cap);
         
//         String ULD_Pos =  sheet.getRow(i).getCell(9).getStringCellValue();
//         driver.findElement(By.xpath("//*[@formcontrolname='uld_pos']")).sendKeys(ULD_Pos,Keys.ENTER);
//         System.out.println("This is my data value:- "+ULD_Pos);
         
         String Landing_Wt =  sheet.getRow(i).getCell(10).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='landing_wt']")).sendKeys(Landing_Wt,Keys.ENTER);
         System.out.println("This is my data value:- "+Landing_Wt);
         
         String Unit2 =  sheet.getRow(i).getCell(11).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='landing_wt_d_d']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='landing_wt_d_d']")).sendKeys(Unit2,Keys.ENTER);
         System.out.println("This is my data value:- "+Unit2);
         
         String Cargo_Cap =  sheet.getRow(i).getCell(12).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='cargo_cap']")).sendKeys(Cargo_Cap,Keys.ENTER);
         System.out.println("This is my data value:- "+Cargo_Cap);
         
         String Unit3 =  sheet.getRow(i).getCell(13).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='cargo_cap_d_d']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='cargo_cap_d_d']")).sendKeys(Unit3,Keys.ENTER);
         System.out.println("This is my data value:- "+Unit3);
         
         String Max_Bulk_Cap_Wt =  sheet.getRow(i).getCell(14).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='max_bulk_cap_wt']")).sendKeys(Max_Bulk_Cap_Wt,Keys.ENTER);
         System.out.println("This is my data value:- "+Max_Bulk_Cap_Wt);
         
         String Unit4 =  sheet.getRow(i).getCell(15).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='max_bulk_cap_wt_d_d']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='max_bulk_cap_wt_d_d']")).sendKeys(Unit4,Keys.ENTER);
         System.out.println("This is my data value:- "+Unit4);
         
         String Max_Bulk_Cap_vol =  sheet.getRow(i).getCell(16).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='max_bulk_cap_volume']")).sendKeys(Max_Bulk_Cap_vol,Keys.ENTER);
         System.out.println("This is my data value:- "+Max_Bulk_Cap_vol);
         
         
         String Cubic =  sheet.getRow(i).getCell(17).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='max_volume_cubic_vol']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='max_volume_cubic_vol']")).sendKeys(Cubic,Keys.ENTER);
         System.out.println("This is my data value:- "+Cubic);
         
         
         String Max_Volum =  sheet.getRow(i).getCell(18).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='max_volume']")).sendKeys(Max_Volum,Keys.ENTER);
         System.out.println("This is my data value:- "+Max_Volum);
         
         String Cubic1 =  sheet.getRow(i).getCell(19).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='max_volume_cubic']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='max_volume_cubic']")).sendKeys(Cubic1,Keys.ENTER);
         System.out.println("This is my data value:- "+Cubic1);
         
         String Restr_Wt_Pc =  sheet.getRow(i).getCell(20).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='restr_wt_pc']")).sendKeys(Restr_Wt_Pc,Keys.ENTER);
         System.out.println("This is my data value:- "+Restr_Wt_Pc);
         
         String Unit5 =  sheet.getRow(i).getCell(21).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='restr_wt_pc_d_d']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='restr_wt_pc_d_d']")).sendKeys(Unit5,Keys.ENTER);
         System.out.println("This is my data value:- "+Unit5);
         
         String Max_Dim_pc_L =  sheet.getRow(i).getCell(22).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='max_dim_pc_l']")).sendKeys(Max_Dim_pc_L,Keys.ENTER);
         System.out.println("This is my data value:- "+Max_Dim_pc_L);
         
         String Max_Dim_pc_B =  sheet.getRow(i).getCell(23).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='max_dim_pc_b']")).sendKeys(Max_Dim_pc_B,Keys.ENTER);
         System.out.println("This is my data value:- "+Max_Dim_pc_B);
         
         String Max_Dim_pc_h =  sheet.getRow(i).getCell(24).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='max_dim_pc_h']")).sendKeys(Max_Dim_pc_h,Keys.ENTER);
         System.out.println("This is my data value:- "+Max_Dim_pc_h);
         
         String Unit6 =  sheet.getRow(i).getCell(25).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='max_dim_d_d']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='max_dim_d_d']")).sendKeys(Unit6,Keys.ENTER);
         System.out.println("This is my data value:- "+Unit6);
         
         String Status =  sheet.getRow(i).getCell(26).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='is_active']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='is_active']")).sendKeys(Status,Keys.ENTER);
         System.out.println("This is my data value:- "+Status);
         
//         String GL_code =  sheet.getRow(i).getCell(27).getStringCellValue();
//         driver.findElement(By.xpath("//*[@formcontrolname='gl_code']")).click();
//         driver.findElement(By.xpath("//*[@formcontrolname='gl_code']")).sendKeys(GL_code,Keys.ENTER);
//         System.out.println("This is my data value:- "+GL_code);
         
         String Count =  sheet.getRow(i).getCell(28).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='count']")).sendKeys(Count,Keys.TAB);
         System.out.println("This is my data value:- "+Count);
         
         
         String Tail_Number =  sheet.getRow(i).getCell(29).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='tail_number']")).sendKeys(Tail_Number,Keys.ENTER);
         System.out.println("This is my data value:- "+Tail_Number);
         
         String Status1 =  sheet.getRow(i).getCell(30).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='status']")).sendKeys(Status1,Keys.ENTER);
         System.out.println("This is my data value:- "+Status1);
         
         
         
            driver.findElement(By.xpath("//*[@title='Submit']")).click();
             Thread.sleep(2000);
             
             String ErrorMsg = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
             System.out.println(ErrorMsg);
     
     		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/aircraft/list");
             
             
            }
         }
	
//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//	}
	
	}
	


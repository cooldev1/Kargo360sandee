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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@Listeners(CustomListener.class)
public class NewCountrycreationPageTest  extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TestBase TestBase;
	com.crm.qa.pages.CountryMasterListingPage CountryMasterListingPage;
	com.crm.qa.pages.NewCountryCreationPage NewCountryCreationPage;
	
	public NewCountrycreationPageTest(){
		super();
		}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		CountryMasterListingPage = new com.crm.qa.pages.CountryMasterListingPage();
		loginPage = new LoginPage();
		NewCountryCreationPage = new com.crm.qa.pages.NewCountryCreationPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority=1)
	public void verifyhomepage() throws InterruptedException{
		homePage.verifyHomePageurl();
	}
	
	@Test(priority=2)
	public void verifyCountryListingpage() throws InterruptedException{
		homePage.verifyHomePageurl();
		CountryMasterListingPage.clickOnCountryListingPage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/country/list");
	}
	
	@Test(priority=3)
	public void ClickonNewCountryButton() throws InterruptedException{
		homePage.verifyHomePageurl();
		CountryMasterListingPage.clickOnCountryListingPage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/country/list");
			NewCountryCreationPage.Clickonadvancefltr();
			NewCountryCreationPage.veryfyNewCountrypage();
	    Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/country/create");
	}
	
	@Test(priority=4)
	public void CountryCreationPossitiveflow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		CountryMasterListingPage.clickOnCountryListingPage();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/country/list");
		NewCountryCreationPage.Clickonadvancefltr();
		NewCountryCreationPage.veryfyNewCountrypage();
        Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/country/create");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\Countray Master.xlsx";
        
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
         
         String Country_code =  sheet.getRow(i).getCell(0).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='code']")).sendKeys(Country_code);
         System.out.println("This is my data value:- "+Country_code);
         
         String Country_Name =  sheet.getRow(i).getCell(2).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(Country_Name);
         System.out.println("This is my data value:- "+Country_Name);
         
         String Currency_Code =  sheet.getRow(i).getCell(3).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='currency_code']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='currency_code']")).sendKeys(Currency_Code);
         System.out.println("This is my data value:- "+Currency_Code);
         
         String status =  sheet.getRow(i).getCell(7).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='status']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='status']")).sendKeys(status,Keys.ENTER);
         System.out.println("This is my data value:- "+status);
         
         String cass =  sheet.getRow(i).getCell(8).getStringCellValue();
         driver.findElement(By.xpath("//*[@formcontrolname='cass']")).click();
         driver.findElement(By.xpath("//*[@formcontrolname='cass']")).sendKeys(cass,Keys.ENTER);
         System.out.println("This is my data value:- "+cass);
         
         
            driver.findElement(By.xpath("//*[@title='Submit']")).click();
             Thread.sleep(2000);
             String ErrorMsg = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
             System.out.println(ErrorMsg);
             Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/country/list");
             
            }
         }
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
	


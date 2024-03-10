package com.crm.qa.testcases;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestBase TestBase;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		TestBase = new TestBase();
		//prop = new Properties();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Kargo360");
		
	}
	
	
	@Test(priority=2)
	public void invalidLogin() throws InterruptedException{
        String wronguser = "sandy@spicejet.com";
        String wrongpass = "123456";
        driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(wronguser);
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(wrongpass);
        driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']")).click();
        Thread.sleep(3000);
        String loginUrl = prop.getProperty("url")+"/login";        
        Assert.assertEquals(loginUrl, driver.getCurrentUrl());
        System.out.println("Invalid Login Username and Password");
	}
	
	@Test(priority=3)
	public void invalidUser() throws InterruptedException{
        String wronguser = "sandy@spicejet.com";
        String wrongpass = "Pass@321";
        driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(wronguser);
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(wrongpass);
        driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']")).click();
        Thread.sleep(3000);
        String loginUrl = prop.getProperty("url")+ "/login";        
        Assert.assertEquals(loginUrl, driver.getCurrentUrl());
        System.out.println("Invalid Username");
	}
	
	@Test(priority=4)
	public void invalidPass() throws InterruptedException{
        String wronguser = "Devendra.singh1@spicejet.com";
        String wrongpass = "Pass@99";
        driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(wronguser);
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(wrongpass);
        driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']")).click();
        Thread.sleep(3000);
        
        String loginUrl = prop.getProperty("url")+"/login";
        System.out.println(loginUrl);
        Assert.assertEquals(loginUrl, driver.getCurrentUrl());
        System.out.println("Invalid Password");
	}
	
	@Test(priority=5)
	public void noCredentials() throws InterruptedException{
        String wronguser = "";
        String wrongpass = "";
        driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(wronguser);
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(wrongpass);
        driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']")).click();
        Thread.sleep(3000);
        String loginUrl =prop.getProperty("url")+ "/login";        
        Assert.assertEquals(loginUrl, driver.getCurrentUrl());
        System.out.println("Kindly Enter Username");
	}
	
	
	
	@Test(priority=6)
	public void loginTest() throws InterruptedException{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	//	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Thread.sleep(2000);
		String homePageUrl = driver.getCurrentUrl();
		Assert.assertEquals(homePageUrl,prop.getProperty("url")+ "/dashboard");
		takeScreenshotAtEndOfTest();
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){		
	driver.quit();
	}

	private void takeScreenshotAtEndOfTest() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}

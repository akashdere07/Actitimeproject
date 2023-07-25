package com.ActtimeGenericLibrary;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Baseclass {
public static WebDriver driver;
	
	@BeforeSuite
	public void databaseConnection(){
		Reporter.log("database connected",true);
	}
	
	@BeforeClass
	public void launchBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Reporter.log("Browser is Launch",true);
	}
	
@BeforeMethod
public void login() throws InterruptedException {
	driver.get("https://demo.actitime.com/login.do");
	driver.findElement(By.id("username")).sendKeys("admin");
	driver.findElement(By.name("pwd")).sendKeys("manager");
	driver.findElement(By.xpath("//div[.='Login ']")).click();
	Thread.sleep(3000);
	Reporter.log("logged in succesfully",true);
}
//
//@Test
//public void createCustomer() {
//	Reporter.log("Customer Created successfully",true);
//}

@AfterMethod
public void logOut() {
	driver.findElement(By.id("logoutLink")).click();
	Reporter.log("logged out successfully",true);
}

@AfterClass
public void closeBrowser(){
	driver.close();
	Reporter.log("Browser is close succesfully",true);
}

@AfterSuite
public void databaseDisconnection() {

	Reporter.log("datbase closed",true);
}
}

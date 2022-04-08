package com.testNg;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class testNgGmoOnline {
	 public WebDriver driver;
	 
  @Test(priority=1)
  public void ValidateGmoOnlinesuccessfully() {
	  System.out.println("inside testCase1");
	  String title = driver.getTitle();
	  System.out.println("title:"+title);
	  Assert.assertEquals(title, "Welcome to Green Mountain Outpost");
  }
  
  @Test(priority=2)
  public void EnterGmoOnline() {
	  System.out.println("inside EnterGmoOnline");
	  driver.findElement(By.name("bSubmit")).click();
	  driver.findElement(By.xpath("//input[@name='QTY_BACKPACKS']")).sendKeys("5");
	  driver.findElement(By.name("bSubmit")).click();
	  String title = driver.findElement(By.xpath("//h1[contains(text(),'Place')]")).getText();
	  System.out.println("title:"+title);
	  Assert.assertEquals(title, "Place Order");
	  
  }
 
  
  @Test(priority=3)
  public void PriceCalculation() {
	  System.out.println("inside PriceCalculation");
	 String UnitPrice =  driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[4]")).getText();
	 System.out.println("UnitPrice: "+UnitPrice);
	 String UnitPriceExtactedValue = UnitPrice.substring(2).trim();
	 System.out.println("UnitPriceExtactedValue: "+UnitPriceExtactedValue);
	 Float UnitPrice_FLoatCalculation = Float.parseFloat(UnitPriceExtactedValue)*5;
	 System.out.println("UnitPrice_FLoatCalculation "+UnitPrice_FLoatCalculation);
	 
	 String TotalPriceFromWebPage = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[5]")).getText();
	 System.out.println("TotalPriceFromWebPage: "+TotalPriceFromWebPage);
	 String TotalPriceFromWebPageWithout$ =TotalPriceFromWebPage.substring(2).trim();
	 Float TotalPriceInFloatFromWebPage = Float.parseFloat(TotalPriceFromWebPageWithout$);
	 System.out.println("TotalPriceInFloatFromWebPage:"+TotalPriceInFloatFromWebPage);
	 
	 Assert.assertEquals(UnitPrice_FLoatCalculation, TotalPriceInFloatFromWebPage);
	
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("inside beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("inside afterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("inside beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("inside afterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("inside beforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("inside afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("inside beforeSuite");
	  WebDriverManager.chromedriver().setup();
	 
	  driver = new ChromeDriver();
	  driver.get("http://demo.borland.com/gmopost/");
	  driver.manage().window().maximize();
	  //Implicit Wait : It is a global waiting mechanism which is applicable for all web Elements 
	  //for a maximum of specified time durations
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("inside afterSuite");
  }

}

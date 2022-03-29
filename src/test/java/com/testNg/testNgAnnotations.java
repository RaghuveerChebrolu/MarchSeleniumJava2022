package com.testNg;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class testNgAnnotations {
	 public WebDriver driver;
	 
  @Test(priority=1)
  public void ValidateAmzonLoadedsuccessfully() {
	  System.out.println("inside testCase1");
	  String title = driver.getTitle();
	  System.out.println("title:"+title);
  }
  
  
  @Test(priority=2)
  public void SearchForSamsunGMobiles() {
	  System.out.println("inside testCase2");
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung mobiles");
	  driver.findElement(By.id("nav-search-submit-button")).click();
  }
	/*
	 * @Test public void testCase3() { System.out.println("inside testCase3"); }
	 * 
	 * @Test public void testCase4() { System.out.println("inside testCase4"); }
	 * 
	 * @Test public void testCase5() { System.out.println("inside testCase5"); }
	 */
  
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
	  driver.get("https://www.amazon.in/");
	  driver.manage().window().maximize();
	 
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("inside afterSuite");
  }

}

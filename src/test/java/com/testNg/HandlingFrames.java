package com.testNg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Utility.library_CommonBusinessFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class HandlingFrames extends library_CommonBusinessFunctions{
	@Test(priority = 1)
	public void ValidateFrames() {
		System.out.println("ValidateFrames");
		driver.navigate().to(objProp.getProperty("FramesURL"));
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.switchTo().frame("singleframe");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hi How ar you doing?");
		driver.switchTo().defaultContent(); //to come out of iframe, i.e coming out of inner html document
		driver.findElement(By.xpath("//*[text()='Iframe with in an Iframe']")).click();
		
		WebElement frameElementOuterFrame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(frameElementOuterFrame);
		WebElement frameElementInnerFrame = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(frameElementInnerFrame);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(objProp.getProperty("framewithInFrame"));
		driver.switchTo().defaultContent();
		
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
		LaunchBrowser();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("inside beforeSuite");
		ReadProppertiesFile();

	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("inside afterSuite");
	}

}

package com.testNg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Utility.ObjectRepository;
import com.Utility.constants;
import com.Utility.library_CommonBusinessFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
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

public class HandlingWindows extends library_CommonBusinessFunctions{
	@Test(priority = 1)
	public void HandlingWindows() throws InterruptedException {
		System.out.println("HandlingWindows");
		driver.navigate().to(objProp.getProperty("nxtgenaiacademyURL"));
		String ParentWindow = driver.getWindowHandle();
		library_CommonBusinessFunctions.FindElement(ObjectRepository.NewBrowserWindow).click();
		Set<String> AllWindows = driver.getWindowHandles();
		for(String IndividualWindowHandle : AllWindows) {
			driver.switchTo().window(IndividualWindowHandle);
			Thread.sleep(7000);
			String Title = driver.getTitle();
			System.out.println("Title: "+Title);
			if(Title.equals(constants.NewBrowserWindowTitle)) {
				//driver.manage().window().maximize();
				library_CommonBusinessFunctions.FindElement(ObjectRepository.MenuInsideNew_BrowserWindow).click();
				library_CommonBusinessFunctions.FindElement(ObjectRepository.AboutMeInNewbrowserWindow).click();
				String text = library_CommonBusinessFunctions.FindElement(ObjectRepository.TechTalkInsideNewbrowserWindow).getText();
				Assert.assertEquals(text, constants.textofNewBrowserWindowTechTalk);
				driver.close();
			}
		}
		driver.switchTo().window(ParentWindow);
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

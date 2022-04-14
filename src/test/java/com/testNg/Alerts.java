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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Alerts extends library_CommonBusinessFunctions{
	@Test(priority = 1)
	public void ValidateAlerts() {
		System.out.println("inside testCase1");
		//Alert
		driver.navigate().to(objProp.getProperty("AlertURL"));
		driver.findElement(By.id("alertButton")).click();
		/*
		 * Explicit Wait : It is the waiting mechanism applicable for one webElement .It
		 * is going to wait until the expected conditions are satisfied with maximum
		 * time duration of specified seconds.
		 */
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert objAlert = driver.switchTo().alert();
		String Alert1Text = objAlert.getText();
		System.out.println("Alert1Text: "+Alert1Text);
		//Assert.assertEquals  ->  Hard Assertion
		//SoftAssert -> soft Assertion
		//Assert.assertEquals(Alert1Text,objProp.getProperty("Alert1Text"));  
		//objAlert.accept();
		SoftAssert objSoftAssert = new SoftAssert();
		objSoftAssert.assertEquals(Alert1Text, objProp.getProperty("Alert1Text"));
		objAlert.accept();
		
		//Timer Alert
		driver.findElement(By.id("timerAlertButton")).click();	
		wait.until(ExpectedConditions.alertIsPresent());
		Alert ObjTimerAlert = driver.switchTo().alert();
		String textObjTimerAlert  = ObjTimerAlert.getText();
		System.out.println("textObjTimerAlert: "+textObjTimerAlert);
		Assert.assertEquals(textObjTimerAlert, objProp.getProperty("Alert2Text"));
		ObjTimerAlert.accept();
		
		//Confirmation Alert
		driver.findElement(By.id("confirmButton")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert ObjConfiramtionAlert = driver.switchTo().alert();
		ObjConfiramtionAlert.dismiss();
		
		String cancelMessage = driver.findElement(By.id("confirmResult")).getText();
		System.out.println("cancelMessage:"+cancelMessage);
		Assert.assertEquals(cancelMessage, objProp.getProperty("Alert3ResultTextCancel"));
		
		//promptBox Alert
		driver.findElement(By.id("promtButton")).click();
		Alert ObjpromptBoxAlert = driver.switchTo().alert();
		ObjpromptBoxAlert.sendKeys(objProp.getProperty("Alert4Textbox"));   
		ObjpromptBoxAlert.accept();
		
		String PromptAlerMessage = driver.findElement(By.id("promptResult")).getText();
		System.out.println("PromptAlerMessage:"+PromptAlerMessage);
		Assert.assertEquals(PromptAlerMessage, objProp.getProperty("Alert4Result"));
		
		objSoftAssert.assertAll();
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

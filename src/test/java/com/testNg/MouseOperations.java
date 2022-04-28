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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MouseOperations extends library_CommonBusinessFunctions{
	@Test(priority = 1)
	public void MouseOperationsRightClick() {
		System.out.println("MouseOperationsRightClick");
		driver.navigate().to(objProp.getProperty("mouseOpeartionRightClick"));
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		WebElement Rightclick = library_CommonBusinessFunctions.FindElement(ObjectRepository.MouseOpearationRightcClick);
		Actions objActions = new Actions(driver);
		objActions.contextClick(Rightclick).build().perform();
		String textOfPasteFromWebPage = library_CommonBusinessFunctions.FindElement(ObjectRepository.MouseOpearationPasteOption).getText();
		Boolean FlagFromWebPage = textOfPasteFromWebPage.toLowerCase().contains("paste");
		library_CommonBusinessFunctions.FindElement(ObjectRepository.MouseOpearationPasteOption).click();
		Alert objALert = driver.switchTo().alert();
		String TextOfAlert = objALert.getText();
		System.out.println("TextOfAlert:"+TextOfAlert.toLowerCase());
		Boolean flagFromAlert = TextOfAlert.contains("paste");
		Assert.assertEquals(FlagFromWebPage,flagFromAlert);
		objALert.accept();
	}
	
	@Test(priority = 2)
	public void MouseOperationsDoubleClick() throws InterruptedException {
		System.out.println("MouseOperationsDoubleClick");
		driver.navigate().to(objProp.getProperty("mouseOpeartionDoubleClick"));
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Scroll vertically down by 550 pixels
		//js.executeScript("window.scrollBy(0, 550)");
		//Scroll vertically up by 400 pixels
		//js.executeScript("window.scrollBy(0, -400)");
		//Scroll horizontally right by 350 pixels
		//js.executeScript("window.scrollBy(350, 0)");
		//Scroll horizontally left by 400 pixels
		//js.executeScript("window.scrollBy(-600, 0)");
		
		WebElement frameElement = library_CommonBusinessFunctions.FindElement(ObjectRepository.MouseOperationFrame);
		js.executeScript("arguments[0].scrollIntoView();", frameElement);
		driver.switchTo().frame(frameElement);
		Thread.sleep(5000);
		Actions objActions = new Actions(driver);
		WebElement DoubleClickBox = library_CommonBusinessFunctions.FindElement(ObjectRepository.MouseOperationDoubleClickBox);
		objActions.doubleClick(DoubleClickBox).build().perform();
		
		Color BackGroundColor = Color.fromString(library_CommonBusinessFunctions.FindElement(ObjectRepository.MouseOperationDoubleClickBox)
				.getCssValue("background-color"));
		System.out.println("BackGroundColor:" + BackGroundColor);
		String ActualBackGroundColor = BackGroundColor.asRgba();
		System.out.println("ActualBackGroundColor:" + ActualBackGroundColor);
		Assert.assertEquals(ActualBackGroundColor, "rgba(255, 255, 0, 1)");
		driver.switchTo().defaultContent();//to come out of the frame
		System.out.println("came out of frame of doube click");
		//Screenshot(driver);
		
	}

	@Test(priority=3)
	public void ValidateDragAndDrop() {
		System.out.println("ValidateDragAndDrop");
		driver.get(objProp.getProperty("mouseOperationDragAndDrop"));
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement FrameDragAndDrop = library_CommonBusinessFunctions.FindElement(ObjectRepository.MouseOperationFrame);
		js.executeScript("arguments[0].scrollIntoView();", FrameDragAndDrop);
		
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(FrameDragAndDrop));
		try {
			boolean flag = library_CommonBusinessFunctions.FindElement(ObjectRepository.MouseOperationFrame).isEnabled();
			if(flag==true) {
				driver.switchTo().frame(FrameDragAndDrop);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		
		WebElement Source = library_CommonBusinessFunctions.FindElement(ObjectRepository.MouseOperationDrag);
		WebElement Destination = library_CommonBusinessFunctions.FindElement(ObjectRepository.MouseOperationDrop);
		
		Actions objActions = new Actions(driver);
		//objActions.dragAndDrop(Source, Destination).build().perform();
		objActions.clickAndHold(Source);
		objActions.moveToElement(Destination).build().perform();

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

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
	public void MouseOperationsDoubleClick() {
		System.out.println("MouseOperationsDoubleClick");
		driver.navigate().to(objProp.getProperty("mouseOpeartionDoubleClick"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Scroll vertically down by 550 pixels
		//js.executeScript("window.scrollBy(0, 550)");
		//Scroll vertically up by 400 pixels
		//js.executeScript("window.scrollBy(0, -400)");
		//Scroll horizontally right by 350 pixels
		//js.executeScript("window.scrollBy(350, 0)");
		//Scroll horizontally left by 400 pixels
		//js.executeScript("window.scrollBy(-600, 0)");
		
		WebElement frameElement = library_CommonBusinessFunctions.FindElement(ObjectRepository.MouseOperationDoubleClickFrame);
		js.executeScript("arguments[0].scrollIntoView();", frameElement);
		
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

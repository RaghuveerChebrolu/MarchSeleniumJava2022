package com.testNg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Utility.ObjectRepository;
import com.Utility.library_CommonBusinessFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class WebTable extends library_CommonBusinessFunctions {
	@Test(priority = 1)
	public void WebTable() {
		System.out.println("inside WebTable");
		driver.navigate().to(objProp.getProperty("WebTableURL"));
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll vertically down by 500 pixels
		js.executeScript("window.scrollBy(0, 500)");
		List<WebElement> AllLastNames = library_CommonBusinessFunctions.FindElements(ObjectRepository.WebTableLastNames);
		int count = AllLastNames.size();
		for(int i= 0 ;i<count;i++) {
			String lastName = AllLastNames.get(i).getText();
			System.out.println(lastName);
			int row = i+1;
			if(lastName.equalsIgnoreCase("Vance")) {
				String Position = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+row+"]/td[4]")).getText();
				String Office = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+row+"]/td[5]")).getText();
				String StartDate = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+row+"]/td[6]")).getText();
				String Salary = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+row+"]/td[7]")).getText();
				String FirstName = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+row+"]/td[2]")).getText();
				System.out.println("The contents of "+row+"row are:");
				System.out.println("FirstName:"+FirstName+"lastName:"+lastName+" Position: "+Position +" Office:"+Office+" StartDate"+
				StartDate+"Salary: "+Salary);
				break;
			}
		}
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

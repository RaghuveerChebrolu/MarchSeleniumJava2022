package com.testNg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Utility.ObjectRepository;
import com.Utility.library_CommonBusinessFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class ValidateDataDriven extends library_CommonBusinessFunctions {
	HashMap<String,String> Hmap=new HashMap<String,String>();//Creating HashMap 
	@Test(priority = 1)
	public void DataDrivenFromExcel() throws Exception {
		System.out.println("inside DataDrivenFromExcel");
		
		driver.navigate().to(objProp.getProperty("AutomationRegister"));
	//	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		waitForPageToLoad();
		File ObjFile = new File (System.getProperty("user.dir")+"//src//test//resources//AutomationDemoSIte.xlsx");
		//Taking File for Reading purpose
		FileInputStream objFileInput = new FileInputStream(ObjFile);
		//Use below 2 classes XSSFWorkbook and XSSFSheet if excel file extension is .xlsx 
		XSSFWorkbook objXSSSFWorkbook = new XSSFWorkbook(objFileInput);
		XSSFSheet objXSSFSheet = objXSSSFWorkbook.getSheet("TestData");
		//Use below 2 classes XSSFWorkbook and XSSFSheet if excel file extension is .xls 
		//HSSFWorkbook objHSSFWorkbook = new HSSFWorkbook(objFileInput);
		//HSSFSheet objHSSFSheet = objHSSFWorkbook.getSheet("TestData");
		
		int Rows = objXSSFSheet.getLastRowNum();
		for(int RowNumber =1 ; RowNumber<=Rows ; RowNumber++) {
			Hmap = ReadExcelFile(objXSSFSheet,RowNumber);
			
			
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

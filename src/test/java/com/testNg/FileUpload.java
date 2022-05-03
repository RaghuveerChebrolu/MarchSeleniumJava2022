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
import java.util.List;
import java.util.Properties;
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

public class FileUpload extends library_CommonBusinessFunctions {
	@Test(priority = 1)
	public void FileUpload() throws Exception {
		System.out.println("inside WebTable");
		driver.navigate().to(objProp.getProperty("FileUpload"));
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		WebElement BrowseButton = library_CommonBusinessFunctions.FindElement(ObjectRepository.FileUploadBrowseButton);
		Actions objActions = new Actions(driver);
		objActions.click(BrowseButton).build().perform();
		StringSelection objStringSelection = new StringSelection(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Sample.jpg");
		Clipboard objClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		objClipboard.setContents(objStringSelection, null);
		Transferable objTransferable = objClipboard.getContents(null);
		if (objTransferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
			try {
				System.out.println(objTransferable.getTransferData(DataFlavor.stringFlavor));
			} catch (UnsupportedFlavorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Robot objRobot = new Robot();
			objRobot.delay(250);
			objRobot.keyPress(KeyEvent.VK_ENTER);
			objRobot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			objRobot.keyPress(KeyEvent.VK_CONTROL);
			objRobot.keyPress(KeyEvent.VK_V);
			Thread.sleep(2000);
			objRobot.keyRelease(KeyEvent.VK_V);
			objRobot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
			objRobot.keyPress(KeyEvent.VK_ENTER);
			objRobot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean DeleteButtonFlag = library_CommonBusinessFunctions.FindElement(ObjectRepository.FileUploadRemoveButton).isEnabled();
		if(DeleteButtonFlag=true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(false, true);
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

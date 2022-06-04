package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class library_CommonBusinessFunctions {
	public static Properties objProp = new Properties();
	public static WebDriver driver;
	public static ExtentHtmlReporter Extent_HtmlReporter;
	public static ExtentReports Extent_Reports ;
	public static ExtentTest Extent_Test ;
	public static HashMap<String,String> Hmap=new HashMap<String,String>();//Creating HashMap 
	
	/*
	 * ExtentHtmlReporter : responsible for look and feel of the report ,we can
	 * specify the report name , document title , theme of the report
	 * 
	 * ExtentReports : used to create entries in your report , create test cases in
	 * report , who executed the test case, environment name , browser
	 * 
	 * ExtentTest : update pass fail and skips and logs the test cases results
	 */

	public static void ReadProppertiesFile() {
		// TODO Auto-generated method stub
		try {
			File obj = new File(System.getProperty("user.dir") + "//src//test//resources//Configiration.Properties");
			System.out.println(System.getProperty("user.dir"));
			FileInputStream objFileInputStream = new FileInputStream(obj);
			objProp.load(objFileInputStream);
			System.out.println("browser:" + objProp.get("browser"));
			System.out.println("GMOurl:" + objProp.get("GmoOnLineUrl"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void LaunchBrowser() {
		String browser = objProp.getProperty("browser");
		switch (browser) {
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			ChromeOptions objChromeOptions = new ChromeOptions();
			objChromeOptions.setAcceptInsecureCerts(true);
			// driver= new ChromeDriver(objChromeOptions);
			Map<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.prompt_for_download", false);
			chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
			objChromeOptions.setExperimentalOption("prefs", chromePrefs);
			driver = new ChromeDriver(objChromeOptions);
			break;
		case "Safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
		default:
			// System.out.println("Consonant");
		}
		driver.get(objProp.getProperty("GmoOnLineUrl"));
		driver.manage().window().maximize();
		// Implicit Wait : It is a global waiting mechanism which is applicable for all
		// web Elements
		// for a maximum of specified time durations
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	public static WebElement FindElementUsingHeadLess(WebDriver unitDriver, String OrepLocator) {
		By search = null;
		System.out.println(OrepLocator);
		String locator = OrepLocator.split("&")[0];
		String value = OrepLocator.split("&")[1];
		System.out.println(locator);
		System.out.println(value);
		if (locator.equals("name")) {
			search = By.name(value);
		} else if (locator.equals("id")) {
			search = By.id(value);
		} else if (locator.equals("xpath")) {
			search = By.xpath(value);
		} else if (locator.equals("tagName")) {
			search = By.tagName(value);
		} else if (locator.equals("className")) {
			search = By.className(value);
		} else if (locator.equals("partialLinkText")) {
			search = By.partialLinkText(value);
		} else if (locator.equals("cssSelector")) {
			search = By.cssSelector(value);
		} else if (locator.equals("linkText")) {
			search = By.linkText(value);
		}
		return unitDriver.findElement(search);
	}
	
	public static WebElement FindElement(String OrepLocator) {
		By search = null;
		System.out.println(OrepLocator);
		String locator = OrepLocator.split("&")[0];
		String value = OrepLocator.split("&")[1];
		System.out.println(locator);
		System.out.println(value);
		if (locator.equals("name")) {
			search = By.name(value);
		} else if (locator.equals("id")) {
			search = By.id(value);
		} else if (locator.equals("xpath")) {
			search = By.xpath(value);
		} else if (locator.equals("tagName")) {
			search = By.tagName(value);
		} else if (locator.equals("className")) {
			search = By.className(value);
		} else if (locator.equals("partialLinkText")) {
			search = By.partialLinkText(value);
		} else if (locator.equals("cssSelector")) {
			search = By.cssSelector(value);
		} else if (locator.equals("linkText")) {
			search = By.linkText(value);
		}
		return driver.findElement(search);
	}
	
	public static List<WebElement> FindElements(String OrepLocator) {
		By search = null;
		System.out.println(OrepLocator);
		String locator = OrepLocator.split("&")[0];
		String value = OrepLocator.split("&")[1];
		System.out.println(locator);
		System.out.println(value);
		if (locator.equals("name")) {
			search = By.name(value);
		} else if (locator.equals("id")) {
			search = By.id(value);
		} else if (locator.equals("xpath")) {
			search = By.xpath(value);
		} else if (locator.equals("tagName")) {
			search = By.tagName(value);
		} else if (locator.equals("className")) {
			search = By.className(value);
		} else if (locator.equals("partialLinkText")) {
			search = By.partialLinkText(value);
		} else if (locator.equals("cssSelector")) {
			search = By.cssSelector(value);
		} else if (locator.equals("linkText")) {
			search = By.linkText(value);
		}
		return driver.findElements(search);
	}
	
	public static void waitForPageToLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		// explicit wait -> Applicable for one webEllement
		WebDriverWait wait = new WebDriverWait(driver, 60);// 60 seconds
		wait.until(pageLoadCondition);
	}
	
	public static void StartExtentReport() {
		Extent_HtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReportV4.html");
		Extent_HtmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
		Extent_HtmlReporter.config().setReportName("Functional Testing"); // Name of the report
		Extent_HtmlReporter.config().setTheme(Theme.DARK);
		
		Extent_Reports = new ExtentReports();
		Extent_Reports.attachReporter(Extent_HtmlReporter);

		// Passing General information
		Extent_Reports.setSystemInfo("Host name", "localhost");
		Extent_Reports.setSystemInfo("Environemnt", "QA");
		Extent_Reports.setSystemInfo("user", "Raghuveer");
		Extent_Reports.setSystemInfo("broswer", objProp.getProperty("browser"));
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		}
	

	public static HashMap<String, String> ReadExcelFile(XSSFSheet objXSSFSheet, int rowNumber) {
		DataFormatter objFormatter = new DataFormatter();
		Hmap.put("RunMode",objXSSFSheet.getRow(rowNumber).getCell(0).getStringCellValue());
		Hmap.put("TestCaseName",objXSSFSheet.getRow(rowNumber).getCell(1).getStringCellValue());
		Hmap.put("FirstName",objXSSFSheet.getRow(rowNumber).getCell(2).getStringCellValue());
		Hmap.put("LastName",objXSSFSheet.getRow(rowNumber).getCell(3).getStringCellValue());
		Hmap.put("Address",objXSSFSheet.getRow(rowNumber).getCell(4).getStringCellValue());
		Hmap.put("EmailAddress",objXSSFSheet.getRow(rowNumber).getCell(5).getStringCellValue());
		
		Hmap.put("PhoneNumber",objFormatter.formatCellValue(objXSSFSheet.getRow(rowNumber).getCell(6)));
		
		Hmap.put("Gender",objXSSFSheet.getRow(rowNumber).getCell(7).getStringCellValue());
		Hmap.put("Hobbies",objXSSFSheet.getRow(rowNumber).getCell(8).getStringCellValue());
		Hmap.put("Languages",objXSSFSheet.getRow(rowNumber).getCell(9).getStringCellValue());
		Hmap.put("Skills",objXSSFSheet.getRow(rowNumber).getCell(10).getStringCellValue());
		Hmap.put("Country",objXSSFSheet.getRow(rowNumber).getCell(11).getStringCellValue());
		Hmap.put("SelectCountry",objXSSFSheet.getRow(rowNumber).getCell(12).getStringCellValue());
		
		Hmap.put("DOB_YY",objFormatter.formatCellValue(objXSSFSheet.getRow(rowNumber).getCell(13)));
		
		Hmap.put("DOB_MM",objXSSFSheet.getRow(rowNumber).getCell(14).getStringCellValue());
		
		Hmap.put("DOB_DD",objFormatter.formatCellValue(objXSSFSheet.getRow(rowNumber).getCell(15)));
		
		Hmap.put("Password",objXSSFSheet.getRow(rowNumber).getCell(16).getStringCellValue());
		Hmap.put("confirmPassword",objXSSFSheet.getRow(rowNumber).getCell(17).getStringCellValue());
		return Hmap;
	}
	
	public static void WriteIntoExcelFile(XSSFWorkbook objXSSSFWorkbook, XSSFSheet objXSSFSheet, int rowNumber) {
		XSSFCellStyle CellStyle = objXSSSFWorkbook.createCellStyle();
		objXSSFSheet.getRow(rowNumber).createCell(18).setCellValue("Pass");
		objXSSFSheet.getRow(rowNumber).createCell(18).setCellStyle(CellStyle);
	}


	public static void SelectValueFromDropDown(List<WebElement> AllDropDownItems, String DropDownValue) {
		// TODO Auto-generated method stub
		int NumberOFDropDownItems = AllDropDownItems.size();
		for (int i = 0; i < NumberOFDropDownItems; i++) {
			String IndividualDropDownValue = AllDropDownItems.get(i).getText();
			if (IndividualDropDownValue.equalsIgnoreCase(DropDownValue)) {
				AllDropDownItems.get(i).click();
				break;
			}
		}
	}
	
	public void ValidatingLinks(String individualUrl) throws IOException {
		// TODO Auto-generated method stub
		try {
			URL objURL = new URL(individualUrl);
			HttpURLConnection objHttpURLConnection = (HttpURLConnection)objURL.openConnection();
			objHttpURLConnection.connect();
			int ResponseCode = objHttpURLConnection.getResponseCode();
			if(ResponseCode>=200 && ResponseCode <=399) {
				System.out.println(individualUrl +"is a vliad Link with Response Code "+ResponseCode);
			}else if(ResponseCode>=400 && ResponseCode <=599) {
				System.out.println(individualUrl +"is a InVliad Link with Response Code "+ResponseCode);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

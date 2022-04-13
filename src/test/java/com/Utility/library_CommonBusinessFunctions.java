package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class library_CommonBusinessFunctions {
	public static Properties objProp = new Properties();
	public static WebDriver driver;

	public void ReadProppertiesFile() {
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
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
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

}

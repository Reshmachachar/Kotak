package com.kotak.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public WebDriverWait wait;
	public Actions act;
	public Properties pro;

	//@BeforeClass
	public  WebDriver initiliseDriver() throws IOException    
	{
		pro=new Properties();
		String path=System.getProperty("user.dir")+"./src/test/java/com/kotak/utilities/config.properties";

		FileInputStream file1=new FileInputStream(path);	
		pro.load(file1); 
		
		ChromeOptions co = new ChromeOptions();
		String Browsername=pro.getProperty("browser");
		if(Browsername.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(co);

		}
		wait = new WebDriverWait(driver,Duration.ofMillis(3000));
		act=new Actions(driver);
		return driver;
		}

	public static String takesScreenshot(String testName,WebDriver driver) throws IOException
	{        
		String filepath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";		
		File fType=(File)((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(fType, new File(filepath));
		return filepath;
		
	}

/*
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
*/
}

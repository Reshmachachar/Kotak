package com.kotak.TestCases;

import static org.testng.Assert.assertEquals;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverAction;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.kotak.common.TestBase;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.kotak.pages.KotakHomepage;
import com.kotak.utilities.TestData;
public class KotakHomePageTest extends TestBase {


    KotakHomepage homepage;
	public KotakHomePageTest() throws IOException 
	{
		driver=initiliseDriver();
	}
	@Test()
	public void TC01_ExplorePoduct() throws InterruptedException, IOException
	{
		driver.get(pro.getProperty("baseUrl"));
		homepage=new KotakHomepage(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		Double p=TestData.Principal;
		Double r=TestData.rate;
		Double y=TestData.year;
		
    //click on explore product 
		
		Actions act=new Actions(driver);
		act.moveToElement(homepage.getExploreProduct()).perform();
		
	//click on loan 
		homepage.getLoan().click();
		
  //click on personal loan 
		homepage.getPersonalLoan().click();
		//System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getCurrentUrl(),homepage.personalLoanUrl);

	//click on EMI Calculator 
		homepage.getEMICalculator().click();
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(),homepage.EMIUrl);
		
	//get loan Data from excel file 
		System.out.println("principal"+p);
		System.out.println("rate"+r);
		System.out.println("year"+y);
//		public getExcelData(Double p,Double r,Double y)
//		{
//		homepage.getLoanAmount().clear();
//		homepage.getLoanAmount().sendKeys(p);
//		homepage.getInterest_rate().clear();
//		homepage.getInterest_rate().sendKeys(r);
//		
//		homepage.getLoan_Amount().clear();
//		homepage.getLoan_Amount().sendKeys(y);
//			
//		}
		
		
	}
	
	
	}


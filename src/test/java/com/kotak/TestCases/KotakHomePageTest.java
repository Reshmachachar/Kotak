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
public class KotakHomePageTest extends TestBase {


    KotakHomepage homepage;
	public KotakHomePageTest() throws IOException 
	{
		driver=initiliseDriver();
	}
	
	@Test
	public void TC01_ExplorePoduct() throws InterruptedException, IOException
	{
		
		driver.get(pro.getProperty("baseUrl"));
		homepage=new KotakHomepage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
    //click on explore product 
		Actions act=new Actions(driver);
		act.moveToElement(homepage.getExploreProduct()).perform();
		
	//click on loan 
		homepage.getLoan().click();
		
  //click on personal loan 
		homepage.getPersonalLoan().click();

	//click on EMI Calculator 
		homepage.getEMICalculator().click();
		
		
	}
	
	
	}


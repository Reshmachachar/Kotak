package com.kotak.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KotakHomepage {

	WebDriver ldriver;
	public KotakHomepage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
//click on Explore Product 
	@FindBy(xpath="//li[@class='dropdown analytics-links']") WebElement exploreProduct;
	
	public WebElement getExploreProduct() {
		return exploreProduct;
	}

	//click on loan
	@FindBy(xpath="//ul[@class='tabs-list drop-tabs-list']//li[4]")WebElement loan;
	public WebElement getLoan() {
		return loan;
	}

	//click on personal loan 
	@FindBy(xpath="//header/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[4]/div[1]/div[1]/ul[1]/li[3]/a[1]") WebElement personalLoan;
	public WebElement getPersonalLoan() {
		return personalLoan;
	}

	//click on EMI Calculator tan 
	@FindBy(xpath="//a[@data-id='calculator1520598575344']") WebElement EMICalculator;
	
	public WebElement getEMICalculator() {
		return EMICalculator;
	}

	
	
	
	
}
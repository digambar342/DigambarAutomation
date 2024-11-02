package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;


public class TimeSheet extends TestBase{
	
	@FindBy(xpath="//div[contains(text(),'Change Branch and Asset')]")
	public static WebElement TimesheetPopUpTitle;
	@FindBy(xpath="//select[@class='ng-pristine ng-valid' and @ng-options='branch.branchName for branch in branchLocationList']")
	public static WebElement branches; 
	@FindBy(xpath="//select[@class='ng-pristine ng-valid' and @ng-options='location.locationName for location in locationList']")
	public static WebElement locations; 
	@FindBy(xpath="//input[@ng-model='cubicleNo']")
	public static WebElement cubicleNo; 
	
	
	public TimeSheet()
	{
		PageFactory.initElements(driver, this);
	}
	public static String getTimesheetPageTitle()
	{
		System.out.println("entered to function");
		return driver.getTitle();
	}
	public static boolean getTimesheetPopUpTitle()
	{
		return TimesheetPopUpTitle.isDisplayed();
	}
	public static void waitforTimesheettoLoad()
	{
		TestUtil.explicitWait(TimesheetPopUpTitle);
	}
	public static void enterValues(String brnches,String lction,String cbcleNo) throws Exception
	{
		branches.sendKeys(brnches);
		locations.sendKeys(lction);
		cubicleNo.sendKeys(cbcleNo);
		
	}
}

package com.qa.tests;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.TimeSheet;
import com.qa.util.TestUtil;

public class TimeSheetTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TimeSheet timeSheet;
	
	@BeforeMethod
	public void openTimeSheetTest() throws Exception
	{
		TestBase.openBrowser();
		loginPage = new LoginPage();
		LoginPage.login();
		homePage = new HomePage();
		HomePage.clickOnCross();
		Thread.sleep(2000);
		HomePage.clickOnTimesheet();
		
		Thread.sleep(4000);
		String currentWindow=driver.getWindowHandle();
		TestUtil.switchToWindow(currentWindow);			
	}	
	@Test(priority=1)
	public static void verifyTimesheetPopUpTitle() throws Exception
	{
	
		Assert.assertTrue(TimeSheet.getTimesheetPopUpTitle());
	}
	@Test(priority=2)
	public void verifyTimesheetpageTitle() 
	{
		TimeSheet.waitforTimesheettoLoad();
		Assert.assertEquals(TimeSheet.getTimesheetPageTitle(),"Home");
	}
	@DataProvider
	public static Object[][] readExcel() throws Exception
	{
		Object[][] data = TestUtil.readExcel("Sheet1");
		return data;	
	}
	@Test(priority=3,dataProvider="readExcel")
	public static void enterValues(String branches,String location,String cubicleNo) throws Exception
	{
		TimeSheet.enterValues(branches, location, cubicleNo);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}

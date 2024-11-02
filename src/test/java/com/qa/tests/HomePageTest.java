package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	
	@BeforeMethod
	public void openHomePageTest() throws Exception {
		TestBase.openBrowser();
		loginPage = new LoginPage();
		homePage = new HomePage();
		LoginPage.login();
	}
	@Test(priority=1)
	public void verifyHomepageTitle() throws Exception
	{
		Thread.sleep(5000);
		Assert.assertEquals(HomePage.getPageTitle(), "Home : Ultimatix - Digitally Connected !");
	}
	@Test(priority=2)
	public void verifyLogoutButton() {
		Assert.assertTrue(HomePage.getLogout());
	}
	@Test(priority=3)
	public void verifyBrokenLinks() throws Exception
	{
		HomePage.clickOnCross();
		Thread.sleep(2000);
		HomePage.checkBrokenLinks();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown() throws Exception
	{
		Thread.sleep(3000);
		driver.close();
	}
}

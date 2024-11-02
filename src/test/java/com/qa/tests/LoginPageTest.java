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

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	
	
	@BeforeMethod
	public void openLoginPageTest() throws Exception
	{
		TestBase.openBrowser();
		loginPage = new LoginPage();
	}
	@Test(priority=1)
	public void verifyLoginPageTitle()
	{
		String loginPageTitle= LoginPage.getLoginPageTitle();
		Assert.assertEquals(loginPageTitle,"Ultimatix - Digitally Connected !");
	}
	@Test(priority=2)
	public void verifyLogo()
	{
		Assert.assertTrue(LoginPage.getLogo());
	}
	@Test(priority=3)
	public void verifyFooter()
	{
		Assert.assertTrue(LoginPage.getFooterImg());
	}
	@Test(priority=4)
	public void verifyLogin() throws Exception 
	{
		LoginPage.login();
		Thread.sleep(6000);
		Assert.assertEquals(HomePage.getPageTitle(), "Home : Ultimatix - Digitally Connected !");
	}
	
	@AfterMethod
	public void tearDown() throws Exception
	{
		Thread.sleep(3000);
		driver.close();
	}
}

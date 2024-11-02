package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.MyDocuments;
import com.qa.util.TestUtil;

public class MyDocumentTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	MyDocuments myDocuments;
	@BeforeTest()
	public void openMyDocumentPage() throws Exception
	{
		TestBase.openBrowser();
		loginPage= new LoginPage();
		LoginPage.login();
		homePage=new HomePage();
		HomePage.clickOnMyDocs();
		TestUtil.switchToWindow(driver.getWindowHandle());
		myDocuments=new MyDocuments();
	}
/*	@Test(priority=1)
	public void verifyMyDocsPageTitle()
	{
		Assert.assertEquals(MyDocuments.getMyDocPageTitle(), "My Document");
	}*/
	@Test(priority=2)
	public void checkLetterDownload() throws Exception
	{
		MyDocuments.clickOnCompensation();
		MyDocuments.clickOnCompensationLetter();
		MyDocuments.clickOnDownloadAndSave();
	}
}

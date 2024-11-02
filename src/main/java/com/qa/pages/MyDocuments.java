package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class MyDocuments extends TestBase {
	@FindBy(xpath="//h4[contains(text(),'Compensation')]")
	public static WebElement compensation;
	@FindBy(xpath="//img[@ng-click='getCompensation(value[2],value[3])']")
	public static WebElement compensationLetter;
	
	public MyDocuments()
	{
		PageFactory.initElements(driver, this);
	}
	
	public static String getMyDocPageTitle()
	{
		return driver.getTitle();
	}
	public static void clickOnCompensation() throws Exception
	{
		TestUtil.explicitWait(compensation);
		Thread.sleep(10000);
		compensation.click();
	}
	public static void clickOnCompensationLetter() throws Exception
	{
		TestUtil.explicitWait(compensationLetter);
		Thread.sleep(5000);
		compensationLetter.click();
	}
	public static void clickOnDownloadAndSave() throws Exception
	{
		System.out.println("entered download page");
		Thread.sleep(3000);
		Screen s = new Screen();
		Pattern downLoadImg= new Pattern("DownLoadCompensationLtr.jpg");
		s.wait(downLoadImg, 2000);
		s.click();
		Pattern saveImg = new Pattern("save.jpg");
		s.wait(saveImg, 3000);
		s.click();
		
	}
	
	
}

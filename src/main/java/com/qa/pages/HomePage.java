package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class HomePage extends TestBase{

	//#################### Object Repository##########
	//public static WebElement logOut = driver.findElement(By.xpath("//div[contains(text(),' Logout ')]"));
	
	
	
	
	//###############################
	@FindBy(xpath="//div[contains(text(),' Logout ')]")
	public static WebElement logOut;
	@FindBy(xpath="//a[@class='trendApps' and contains(text(),'Timesheet Entry')]")
	public static WebElement timeSheet;
	@FindBy(xpath="//a[@class='trendApps' and contains(text(),'iEvolve')]")
	public static WebElement iEvolve;
	@FindBy(xpath="//a[@class='trendApps' and contains(text(),'GESS')]")
	public static WebElement gess;
	@FindBy(xpath="//a[@class='trendApps' and contains(text(),'My Documents')]")
	public static WebElement myDocuments;
	@FindBy(xpath="//span[@class='ui-button-icon ui-icon ui-icon-closethick']")
	public static WebElement toBeclosed;
	@FindBy(tagName="a")
	public static List<WebElement> anchorTaglinkLists;
	@FindBy(tagName="img")
	public static List<WebElement> imgTaglinkLists;
				
		
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public static String getPageTitle()
	{
		return driver.getTitle();
	}
	public static boolean getLogout()
	{
		return logOut.isDisplayed();
	}
	public static TimeSheet clickOnTimesheet()
	{
		timeSheet.click();
		return new TimeSheet();
	}
	public static IEvolve clickOnIEvolve()
	{
		iEvolve.click();
		return new IEvolve();
	}
	public static GESS clickOnGESS()
	{
		gess.click();
		return new GESS();
	}
	public static MyDocuments clickOnMyDocs()
	{
		TestUtil.explicitWait(myDocuments);
		myDocuments.click();
		return new MyDocuments();
	}
	public static void clickOnCross()
	{
		toBeclosed.click();
	}
	public static void checkBrokenLinks() throws Exception
	{
		List<WebElement> allLinklists =new ArrayList<WebElement>();
		allLinklists.addAll(anchorTaglinkLists);
		allLinklists.addAll(imgTaglinkLists);
		System.out.println(allLinklists.size());
		TestUtil.checkBrokenLinks(allLinklists);
		
	}
	
	
	
}

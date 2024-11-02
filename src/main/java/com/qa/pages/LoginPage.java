package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class LoginPage extends TestBase{
	
	
	//#######Object Repository########
	//public static WebElement tcsLogo= driver.findElement(By.xpath("//div[@id='tcs_logo']"));
	//public static WebElement ultiMatixImg = driver.findElement(By.xpath("//img[@src='/utxLogin/img/ultimatix_logo.gif']"));
	//public static WebElement footerImg = driver.findElement(By.id("login_footer"));
	//public static WebElement userName = driver.findElement(By.id("USER"));
	//public static WebElement passWord = driver.findElement(By.id("PASSWORD"));
	//public static WebElement loginButton = driver.findElement(By.className("login_button"));
	//##############################//
	@FindBy(xpath="//div[@id='tcs_logo']")
	public static WebElement tcsLogo;
	@FindBy(xpath="//img[@src='/utxLogin/img/ultimatix_logo.gif']")
	public static WebElement ultiMatixImg;
	@FindBy(id="login_footer")
	public static WebElement footerImg;
	@FindBy(id="USER")
	public static WebElement userName;
	@FindBy(id="PASSWORD")
	public static WebElement passWord;
	@FindBy(className="login_button")
	public static WebElement loginButton;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public static String getLoginPageTitle(){
		return driver.getTitle();		
	}
	public static boolean getLogo()
	{
		return ultiMatixImg.isDisplayed();
	}
	public static boolean getFooterImg()
	{
		return footerImg.isDisplayed();
	}
	public static HomePage login() throws Exception
	{
		userName.sendKeys(TestUtil.readProperties("Username"));
		passWord.sendKeys(TestUtil.readProperties("Password"));
		loginButton.click();
		return new HomePage();
	}
	
}

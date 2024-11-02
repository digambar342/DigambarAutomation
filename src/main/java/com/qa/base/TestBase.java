package com.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver = null;
	
	public static void openBrowser() throws Exception {
		String chromeDriverPath= TestUtil.readProperties("ChromeDriverPath");
		String ffDriverPath= TestUtil.readProperties("GeckoDriverPath");
		Long implicitWaitTime = Long.parseLong(TestUtil.readProperties("implicitWaitTime"));
		
	if(TestUtil.readProperties("Browser").equals("Chrome"))
	{
	System.setProperty("webdriver.chrome.driver",chromeDriverPath);
	driver = new ChromeDriver();
	}
	else if(TestUtil.readProperties("Browser").equals("FF"))
	{
		System.setProperty("webdriver.gecko.driver",ffDriverPath);
		driver = new FirefoxDriver();
	}
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(implicitWaitTime,TimeUnit.SECONDS);
	
	driver.get(TestUtil.readProperties("URL"));
}
}
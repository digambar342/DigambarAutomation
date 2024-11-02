package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static String readProperties(String key) throws Exception {
		 File file = new File("C:\\Users\\DIGAMBAR\\workspace_Oxygen\\selenium_pom_ultimatix\\src\\main\\java\\com\\qa\\config\\config.properties");
		 FileInputStream fi = new FileInputStream (file);
		 Properties prop = new Properties();
		 prop.load(fi);
		 return prop.getProperty(key);		 
	}
	public static void explicitWait(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		
	}
	public static void switchToWindow(String currentWindow)
	{
		Set <String> windowHandles = driver.getWindowHandles();
		for(String window:windowHandles)
		{
			if(! window.equals(currentWindow))
			{
				driver.switchTo().window(window);
			}
		}
	}
	public static Object[][] readExcel(String sheetName) throws Exception
	{
		File file = new File("C:\\Users\\DIGAMBAR\\Desktop\\UltiMatix_Test.xls");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new HSSFWorkbook(inputStream);
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		System.out.println("totalrows="+rowCount);
		Object [][] excelValues = new Object[rowCount][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<rowCount;i++)
		{
			Row row =sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++)
			{
				
				Cell cell=row.getCell(j);
				excelValues[i][j]=cell.getStringCellValue();
				System.out.println(excelValues[i][j]);
			}break;	
		}
	
		return excelValues;	
		
	}
	
	public static void checkBrokenLinks(List<WebElement> linkLists) throws Exception, Exception
	{
		
		int totalNoOfLinks = linkLists.size();
		System.out.println("Total No of links in the page="+totalNoOfLinks );
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		for(WebElement link:linkLists)
		{
			if(link.getAttribute("href") != null && link.getAttribute("href").contains("http"))
			{
				
				activeLinks.add(link);
			}
		}
		System.out.println("Total no of active links = "+activeLinks.size());
		
		for(WebElement activeLink:activeLinks)
		{
			String url = activeLink.getAttribute("href");
			HttpURLConnection huc = (HttpURLConnection)(new URL(url).openConnection());
			huc.connect();
			int respCode = huc.getResponseCode();
			if(respCode >= 400 )
			{
				System.out.println(url+" ------------- This URL is a broken Link");
			}
			else
			{
				System.out.println(url+" ------------- This URL is a correct Link");
			}
			huc.disconnect();
		}
		
		
		
	}
	
	
	
}

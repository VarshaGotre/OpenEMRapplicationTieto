package com.tieto.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.tieto.base.WebDriverWrapper;
//import com.tieto.pages.DashboardPage;
//import com.tieto.pages.LoginPage;
//import com.tieto.utilities.ExcelUtils;

public class LoginTest extends WebDriverWrapper {
	
	
	@Test
	public void countlinksTest()
	{
		int a = driver.findElements(By.tagName("a")).size();
		Assert.assertEquals(a,1);
		
	}
	
	@DataProvider
	public Object[][] invalidData()
	{
		Object[][] obj= new Object[2][4];
		obj[0][0] = "john";
		obj[0][1] = "john123";
		obj[0][2] = "French(std)";
		obj[0][3]= "Invalid username or pwd";
		
		obj[1][0] = "peter";
		obj[1][1] = "peter123";
		obj[1][2] = "Armenian";
		obj[1][3]= "Invalid username or pwd";
		
		return obj;
	}
	@Test(priority=2, dataProvider="invalidData")
	public void invalidCredentialsTest(String uname,String password,String language,String expectedValue)
	{
//data provider
		
		
		
		
		
		
		
//		driver.findElement(By.id("authUser")).sendKeys("admin123");	
//		driver.findElement(By.id("clearPass")).sendKeys("pass");
//		Select selectLanguage = new Select(driver.findElement(By.name("languageChoice")));	
//		selectLanguage.selectByVisibleText("English (Indian)");	
//	
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		
//		String actualValue = driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).getText();
//		// Assert.assertEquals(actualValue,"Invalid username or password");
//		Assert.assertEquals(actualValue.trim(),"Invalid username or password"); // alternate
//		
//		Assert.assertTrue(actualValue.contains("Invalid username or password")); // alternate to trim or if there is huge text in error message
		
	}
	
	@DataProvider 
	public Object[][] validCredentialsData() throws IOException
	{
		Object[][] main=ExcelUtils.excelRead("testdata/OpenEmrData.xlsx","validCredentialsData");
		return main;
		
	}
	@Test(dataProvider = "validCredentialsData")
	public void validCredentialsTest(String username,String password,String language,String expectedValue)
	{
		//Non Static code the below 3 lines
		//we are calling non-static method of LoginPage class into non-static method of LoginTest class
		//..so need to call by creating object of LoginPage class
		LoginPage login = new LoginPage(driver);
			
		login.enterUsername(username);
		login.enterPassword(password);
		
		//Static code : we are calling static into non static so need to call by using classname
//		LoginPage.enterUsername(driver,"admin");
//		LoginPage.enterPassword(driver,"pass");
		
		//Reuse of this below code in LoginPage
//		driver.findElement(By.id("authUser")).sendKeys("admin");	
//		driver.findElement(By.id("clearPass")).sendKeys("pass");
		
//		Select selectLanguage = new Select(driver.findElement(By.name("languageChoice")));	
//		selectLanguage.selectByVisibleText("English (Indian)");	
	
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		
//		WebDriverWait wait = new WebDriverWait(driver,40);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Message Center']")));
		
		login.language(language);
		login.submit();
		DashboardPage page =new DashboardPage(driver);
		page.waitForPresenceMessage();
		String actualValue =page.dashboardTitle();
		
		
	
//		String actualValue = driver.getTitle();
//		Reporter.log(actualValue);
		
		
		Assert.assertEquals(actualValue,expectedValue);
		
		
	}

}

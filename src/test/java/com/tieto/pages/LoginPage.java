	package com.tieto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LoginPage {
	
	//Static method code
//	private static By userLocator=By.id("authUser");
//	private static By pwdLocator=By.id("clearPass");
//	
//	private WebDriver driver;
//	
//	
//	public static void enterUsername(WebDriver driver,String username)
//	{
//		driver.findElement(userLocator).sendKeys(username);
//	}
//	
//	
//	public static void enterPassword(WebDriver driver,String pwd)
//	{
//		driver.findElement(pwdLocator).sendKeys(pwd);
//	}
	
	//Non Static method:
	
	private By userLocator=By.id("authUser");
	private By pwdLocator=By.id("clearPass");
	private By langLocator=By.name("languageChoice");
	private By submitLocator=By.xpath("//button[@type='submit']");
	private By errorLocator=By.xpath("//div[contains(text(),'Invalid')]");
	private WebDriver driver;
			
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		
	}

	public void enterUsername(String username)
	{
		driver.findElement(userLocator).sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(pwdLocator).sendKeys(password);
	}
	
	public void language(String lang)
    {
    	Select selectLanguage = new Select(driver.findElement(langLocator));	
		selectLanguage.selectByVisibleText(lang);	
    }
	
	public void submit()
	{
		driver.findElement(submitLocator).click();
		
	}
	
	public String errorMessage()
	{
		return driver.findElement(errorLocator).getText();
	}
	
		
		//		Reporter.log(actualValue);
	}
    


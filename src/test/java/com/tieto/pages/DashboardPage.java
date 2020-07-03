package com.tieto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	private By messageCenter=By.xpath("//span[text()='Message Center']");
	private WebDriver driver;
	
	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForPresenceMessage()
	{
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.presenceOfElementLocated(messageCenter));
	}
	
	public String dashboardTitle()
	{
		return driver.getTitle();
	}

}

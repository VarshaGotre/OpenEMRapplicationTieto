package com.tieto.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.tieto.base.WebDriverWrapper;

public class AddPatientTest extends WebDriverWrapper {
	
	@Test
	public void createPatientTest()
	{
		driver.findElement(By.id("authUser")).sendKeys("admin123");	
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		Select selectLanguage = new Select(driver.findElement(By.name("languageChoice")));	
		selectLanguage.selectByVisibleText("English (Indian)");	
	
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//fill the patient
		//verify
		
	}

}

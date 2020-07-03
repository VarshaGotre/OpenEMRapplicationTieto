package com.tieto.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class WebDriverWrapper {
	protected WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeMethod
	public void init(@Optional("ch")String name)  // if we are not passing browser value in xml then it will take this optional value i.e. ch
	{
		System.out.println(name);
		System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","driver/geckodriver.exe");
		System.setProperty("webdriver.ie.driver","driver/Internetdriverserver.exe");
		
		//String baseUrl=prop.getProperty("url");
		//System.out.println(baseUrl);
		
		if(name.equalsIgnoreCase("ff"))
		{
			driver=new FirefoxDriver();
		}
		else if(name.equalsIgnoreCase("ie"))
		{
			driver=new InternetExplorerDriver();
		}
		else
		{
		 driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.openemr.io/a/openemr/interface/login/login.php?site=default");
	}
	
	@AfterMethod
	public void end()
	{
		driver.quit();
	}

}

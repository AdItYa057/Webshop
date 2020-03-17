package com.cts.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;

import java.io.File;
import java.util.Date;

public class LaunchWebBrowser {

	protected static WebDriver driver;
	
	public static void LaunchWebDriver(String browsername)
	{
//		if(browsername.equalsIgnoreCase("ff"))
//		{
//			System.setProperty("", "");
//		}
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void ending()
	{
		Date date = new Date();
		String datestr = date.toString();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		screenshot.renameTo(new File("screenshots/image"+datestr+".png"));
		
		driver.quit();
		}


}
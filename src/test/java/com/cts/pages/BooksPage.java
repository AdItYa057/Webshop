package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BooksPage {
	WebDriver driver;
	private By bookLocator = By.linkText("Fiction");
	private By priceLocator = By.xpath("//span[@class='price-value-27']");
	
	public BooksPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickonBook(String bookname)
	{
		driver.findElement(bookLocator).click();
	}

	public String getBookPrice()
	{
		String price = driver.findElement(priceLocator).getText();
		return price;

	}
}

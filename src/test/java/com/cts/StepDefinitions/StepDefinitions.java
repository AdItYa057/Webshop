package com.cts.StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cts.base.LaunchWebBrowser;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	WebDriver driver;

	@Given("I have a browser with DemoWebShop Application")
	public void i_have_a_browser_with_DemoWebShop_Application() {
		// Write code here that turns the phrase above into concrete actions
//		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//		driver.get("http://demowebshop.tricentis.com/");
		LaunchWebBrowser.LaunchWebDriver("ch");
		this.driver = LaunchWebBrowser.driver;

	}

	@When("I enter gender as {string} and firstname as {string} and lastname as {string} and email as {string} and password as {string} and confirmpassword as {string}")
	public void i_enter_gender_as_and_firstname_as_and_lastname_as_and_email_as_and_password_as_and_confirmpassword_as(
			String gender, String firstname, String lastname, String email, String password, String confirmPassword)
			throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// driver.findElement(By.xpath("//span[text()='Sign In']")).click();

		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		if (gender.equalsIgnoreCase("Male"))
			driver.findElement(By.id("gender-male")).click();
		else
			driver.findElement(By.id("gender-female")).click();

//		driver.findElement(By.xpath("//a[text()='Register']")).click();

		driver.findElement(By.id("FirstName")).sendKeys(firstname);
		driver.findElement(By.id("LastName")).sendKeys(lastname);
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);

		driver.findElement(By.id("register-button")).click();

	}

	@Then("my account must be registered with the Application")
	public void my_account_must_be_registered_with_the_Application() {
		// Write code here that turns the phrase above into concrete actions
//		String regmsg =	driver.findElement(By.xpath("//div[@class='result']")).getText();
//		Assert.assertEquals("Your registration is complete",regmsg);	

		boolean ele = driver.findElement(By.xpath("//input[@value='Continue']")).isDisplayed();
		Assert.assertTrue("Not registered", ele);
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

	}

	@When("I enter email as {string} and enter password as {string} and click on Login")
	public void i_enter_email_as_and_enter_password_as_and_click_on_Login(String email, String password) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//a[text()='Log in']")).click();

		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);

		driver.findElement(By.xpath("//input[@value='Log in']")).click();

	}

	@Then("I must login to the portal")
	public void i_must_login_to_the_portal() {
		// Write code here that turns the phrase above into concrete actions
		boolean logoutele = driver.findElement(By.xpath("//a[text()='Log out']")).isDisplayed();
		Assert.assertTrue("Invalid Credentials", logoutele);
	}

	@When("I enter {string} in search bar and click on search")
	public void i_enter_in_search_bar_and_click_on_search(String string) {
		// Write code here that turns the phrase above into concrete actions

		driver.findElement(By.id("small-searchterms")).sendKeys("Fiction");

		driver.findElement(By.xpath("//input[@value='Search']")).click();

	}

	@Then("I must get the products related to Fiction")
	public void i_must_get_the_products_related_to_Fiction() {
		// Write code here that turns the phrase above into concrete actions
		if (driver.getPageSource().toLowerCase().contains("fiction"))
			System.out.println("Got the products related to search");
		else
			Assert.fail("Got wrong product suggestions");

	}

	@When("I click on Books in the Homepage and select {string} book")
	public void i_click_on_Books_in_the_Homepage_and_select_book(String bookname) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//a[contains(text(),'Books')]")).click();

		driver.findElement(By.linkText(bookname)).click();
	}

	@Then("I must get the price of the book")
	public void i_must_get_the_price_of_the_book() {
		// Write code here that turns the phrase above into concrete actions

		String price = driver.findElement(By.xpath("//span[@class='price-value-27']")).getText();
		System.out.println(price);
	}

	@When("I click on Computers in the Homepage and click on {string} and select {string}")
	public void i_click_on_Computers_in_the_Homepage_and_click_on_and_select(String computerType, String computer) {
		// Write code here that turns the phrase above into concrete actions
		
		driver.findElement(By.xpath("//a[contains(text(),'Computers')]")).click();
		driver.findElement(By.linkText(computerType)).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'14.1-inch Laptop')]")).click();
	}

	@Then("I must get navigated to the laptop page and must be ale to get product specifications")
	public void i_must_get_navigated_to_the_laptop_page_and_must_be_ale_to_get_product_specifications() {
		// Write code here that turns the phrase above into concrete actions
		WebElement table = driver.findElement(By.xpath("//table[@class='data-table']"));
		List<WebElement> elements = table.findElements(By.tagName("td"));
		for(WebElement ele :elements)
		{
			System.out.println(ele.getText());
		}
		
	}
	
}
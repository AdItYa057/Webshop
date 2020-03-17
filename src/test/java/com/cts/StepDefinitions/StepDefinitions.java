package com.cts.StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://demowebshop.tricentis.com/");
	}

	@When("I enter gender as {string} and firstname as {string} and lastname as {string} and email as {string} and password as {string} and confirmpassword as {string}")
	public void i_enter_gender_as_and_firstname_as_and_lastname_as_and_email_as_and_password_as_and_confirmpassword_as(
			String gender, String firstname, String lastname, String email, String password, String confirmPassword) {
		// Write code here that turns the phrase above into concrete actions
		// driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		if (gender.equalsIgnoreCase("Male"))
			driver.findElement(By.id("gender-male")).click();
		else
			driver.findElement(By.id("gender-female")).click();

		driver.findElement(By.xpath("//a[text()='Register']")).click();

		driver.findElement(By.id("FirstName")).sendKeys(firstname);
		driver.findElement(By.id("LastName")).sendKeys(lastname);
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);

	}

	@When("select gender as Female")
	public void select_gender_as_Female() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("my account must be registered with the Application")
	public void my_account_must_be_registered_with_the_Application() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("I give valid credentials and click on Login")
	public void i_give_valid_credentials_and_click_on_Login() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("I must login to the portal")
	public void i_must_login_to_the_portal() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("I enter Fiction in search bar and click on search")
	public void i_enter_Fiction_in_search_bar_and_click_on_search() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("I must get the suggestions of the products")
	public void i_must_get_the_suggestions_of_the_products() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("I click on Books in the Homepage")
	public void i_click_on_Books_in_the_Homepage() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("I must get navigated to the Books page and must be able to select books")
	public void i_must_get_navigated_to_the_Books_page_and_must_be_able_to_select_books() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("I click on Computers in the Homepage")
	public void i_click_on_Computers_in_the_Homepage() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("I must get navigated to the Computers page and must be ale to select computers")
	public void i_must_get_navigated_to_the_Computers_page_and_must_be_ale_to_select_computers() {
		// Write code here that turns the phrase above into concrete actions

	}
}
package com.salesmanager.cucumber.sk;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestSteps {

	private WebDriverWait wait;
	private WebDriver driver;

	@Before("@selenium")
	public void setUp() throws Throwable {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        //driver = new ChromeDriver();
        
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		driver = new RemoteWebDriver( new URL("http://dockerselenium.azurewebsites.net/wd/hub"), capability);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1920,1080));
		
		wait = new WebDriverWait(driver, 10);
	
	}

	@Given("^the user is on the main page$")
	public void userIsOnMainPage() {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop");
	}

	@When("^adding the item to the cart$")
	public void viewBookDetails() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 250);");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[1]/div/div[1]/a/img")));
		driver.findElement(By.xpath("//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[1]/div/div[1]/a/img")).click();
		jse.executeScript("scroll(0, 500);");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='input-3']/div/button")));
		driver.findElement(By.xpath("//*[@id='input-3']/div/button")).click();
		jse.executeScript("scroll(0, -250);");
	}

	@Then("^the user should be able to checkout via the mincart$")
	public void checkIfOnMainPage() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='miniCartSummary']/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='miniCartDetails']/li/div/a")).click();
		Thread.sleep(1000);
		assertEquals("check if in cart", "Node Web Development", driver.findElement(By.xpath("//*[@id='mainCartTable']/tbody/tr[1]/td[1]/div/div[2]/span/strong")).getText());
	}

	@Given("^I am on main page$")
	public void mainPage() throws InterruptedException {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='customerAccount']/button/span")));
	}

	@When("^I sign in with valid credentials$")
	public void signIn() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='customerAccount']/button/span")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='signin_userName']")));
		driver.findElement(By.xpath("//*[@id='signin_userName']")).sendKeys("JohnDoe");
		driver.findElement(By.xpath("//*[@id='signin_password']")).sendKeys("helloworld");
		driver.findElement(By.xpath("//*[@id='login-button']")).click();
	}

	@Then("^I will be successfully logged in$")
	public void checkIfSuccessfullySignedIn() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='customerAccount']/button/span/span")));
		driver.findElement(By.xpath("//*[@id='customerAccount']/button/span")).click();
		assertEquals("Check if signed in", "My Account", driver.findElement(By.xpath("//*[@id='customerAccount']/ul/li[1]/a")).getText());
	}

	@Given("^There is an item in the cart$")
	public void there_is_an_item_in_the_cart() {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[1]/div/div[1]/a/img")));
		driver.findElement(By.xpath("//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[1]/div/div[1]/a/img")).click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 250);");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='input-2']/div/button")));
		driver.findElement(By.xpath("//*[@id='input-2']/div/button")).click();
		jse.executeScript("scroll(0, -250);");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='miniCartSummary']/font/strong")));
		driver.findElement(By.xpath("//*[@id='miniCartSummary']/span")).click();
	}

	@When("^I press the remove item-button$")
	public void i_press_the_remove_item_button() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='2']/td[4]/button")));
		driver.findElement(By.xpath("//*[@id='2']/td[4]/button")).click();
	}

	@Then("^The item should be removed from the cart$")
	public void the_item_should_be_removed_from_the_cart() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='miniCartSummary']")));
		assertEquals("check if cart is empty", "SHOPPING CART (0)", driver.findElement(By.xpath("//*[@id='miniCartSummary']")).getText());
	}

	@Given("^I dont have a registered account$")
	public void i_dont_have_a_registered_account() throws InterruptedException {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop");
		Thread.sleep(2000);
	}

	@When("^I try to sign in with invalid credentials$")
	public void i_try_to_sign_in_with_invalid_credentials() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='customerAccount']/button/span")));
		driver.findElement(By.xpath("//*[@id='customerAccount']/button/span")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='signin_userName']")));
		driver.findElement(By.xpath("//*[@id='signin_userName']")).sendKeys("Test");
		driver.findElement(By.xpath("//*[@id='signin_password']")).sendKeys("Test");
		driver.findElement(By.xpath("//*[@id='login-button']")).click();
		Thread.sleep(1000);

	}

	@Then("^I should be denied logging in$")
	public void i_should_be_denied_logging_in() {
		assertEquals("check if login failed", "Login Failed. Username or Password is incorrect.", driver.findElement(By.xpath("//*[@id='loginError']")).getText());
	}

	@When("^I create an account$")
	public void i_create_an_account() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='customerAccount']/button/span")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='registerLink']")));
		driver.findElement(By.xpath("//*[@id='registerLink']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='firstName']")));
		String s = RandomStringUtils.randomAlphabetic(8);
		driver.findElement(By.id("firstName")).sendKeys("tester");
		driver.findElement(By.id("lastName")).sendKeys("testersson");
		new Select (driver.findElement(By.id("gender"))).selectByVisibleText("Male");
		new Select (driver.findElement(By.id("registration_country"))).selectByVisibleText("Sweden");
		driver.findElement(By.id("hidden_zones")).sendKeys("teststate");
		driver.findElement(By.id("userName")).sendKeys(s);
		driver.findElement(By.id("email")).sendKeys(s + "@email.com");
		driver.findElement(By.id("password")).sendKeys("testing");
		driver.findElement(By.id("passwordAgain")).sendKeys("testing");
		driver.findElement(By.xpath("//*[@id='submitRegistration']")).click();
	}

	@Then("^An account should be created$")
	public void an_account_should_be_created() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='main-content']/div/div/div[1]/div/span/p")));
		driver.findElement(By.xpath("//*[@id='main-content']/div/div/div[1]/div/ul/li[2]/a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='main-content']/div/div[1]/div[1]/span/p")));
		String actualString = driver.findElement(By.xpath("//*[@id='main-content']/div/div[1]/div[1]")).getText();
		assertTrue(actualString.contains("tester testersson\nteststate, Sweden"));
	}

	@Given("^I am somewhere on main page$")
	public void i_am_somewhere_on_main_page() {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='searchField']")));
	}

	@When("^I use the search function to find a product$")
	public void i_use_the_search_function_to_find_a_product() throws InterruptedException {
		driver.findElement(By.id("searchField")).sendKeys("spring in action");
		driver.findElement(By.xpath("//*[@id='header-top-second']/div/div[2]/button/span")).click();
		Thread.sleep(2000);
	}

	@Then("^I will be shown a list of search results$")
	public void i_will_be_shown_a_list_of_search_results() {
		String actualString = driver.getPageSource();
		assertTrue(actualString.contains("search results"));
	}

	@Given("^I am signed in with new account$")
	public void i_am_signed_in() throws InterruptedException {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='customerAccount']/button/span")));
		driver.findElement(By.xpath("//*[@id='customerAccount']/button/span")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='registerLink']")));
		driver.findElement(By.xpath("//*[@id='registerLink']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='firstName']")));
		String s = RandomStringUtils.randomAlphabetic(8);
		driver.findElement(By.id("firstName")).sendKeys("tester");
		driver.findElement(By.id("lastName")).sendKeys("testersson");
		new Select (driver.findElement(By.id("gender"))).selectByVisibleText("Male");
		new Select (driver.findElement(By.id("registration_country"))).selectByVisibleText("Sweden");
		driver.findElement(By.id("hidden_zones")).sendKeys("teststate");
		driver.findElement(By.id("userName")).sendKeys(s);
		driver.findElement(By.id("email")).sendKeys(s + "@email.com");
		driver.findElement(By.id("password")).sendKeys("testing");
		driver.findElement(By.id("passwordAgain")).sendKeys("testing");
		driver.findElement(By.xpath("//*[@id='submitRegistration']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='site-branding']/div/h1/a")));
		driver.findElement(By.xpath("//*[@id='site-branding']/div/h1/a")).click();	
	}

	@Given("^browse to a specific product$")
	public void browse_to_a_specific_product() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[2]/div/div[1]/a/img")));
		driver.findElement(By.xpath("//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[2]/div/div[1]/a/img")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='shop']/section/div/div/aside/div/div/div/ul/li[3]/a")));
		driver.findElement(By.xpath("//*[@id='shop']/section/div/div/aside/div/div/div/ul/li[3]/a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='reviewButton']")));
		driver.findElement(By.xpath("//*[@id='reviewButton']")).click();
	}

	@When("^I write a review$")
	public void i_write_a_review() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='review']/p")));
		driver.findElement(By.xpath("//*[@id='description']")).sendKeys("Very Good!");
		driver.findElement(By.xpath("//*[@id='rateMe']/img[4]")).click();
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 150);");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='review']/button")));
		driver.findElement(By.xpath("//*[@id='review']/button")).click();	
	}

	@Then("^The review should be saved and displayed to me$")
	public void the_review_should_be_saved_and_displayed_to_me() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='store.success']")));
		assertEquals("check if review is successfull", "You have successfully created a product review", driver.findElement(By.xpath("//*[@id='store.success']")).getText());
		assertEquals("check review text", "Very Good!", driver.findElement(By.xpath("//*[@id='review']/div[2]/div[1]/blockquote/p")).getText());		
	}

	@After("@selenium")
	public void tearDown(){
		driver.quit();
	}
}

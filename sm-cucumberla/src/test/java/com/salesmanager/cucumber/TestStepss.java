package com.salesmanager.cucumber;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class TestStepss {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver","C:\\SeleniumGecko\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	@After
	public void setup2(){
		driver.close();
		
	}
	
	// KOLLA ALLA OM DET FINNS ASSERTS OCH LÄGG IN PÅ THEN
	
	
  @Given("^I am on the startpage$")
	public void i_am_on_the_startpage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	  driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
	}

	
	@When("^I click on the Default store button$")
	public void i_click_on_the_Default_store_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement book2 = driver.findElement(By.xpath((".//*[@id='site-branding']/div/h1/a")));
		book2.click();

	    //throw new PendingException(); ta bort pendingexception när jag e färdig!
	}

	@Then("^I should see the main page$")
	public void i_should_see_the_main_page() throws Throwable {
		assertEquals("Shopizer Demo - Default store", driver.getTitle());
	  
	}

	@When("^I click on the Computer Books button$")
	public void i_click_on_the_Computer_Books_button() throws Throwable {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
 		WebElement storeLink = driver.findElement(By.xpath((".//*[@id='topMain']/li[1]/a/span")));
 		storeLink.click();
	  
	}

	@Then("^I should be redirected to the page with computer books$")
	public void i_should_be_redirected_to_the_page_with_computer_books() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
	

	@When("^I select the book \"([^\"]*)\" by clicking on it$")
	public void i_select_the_book_by_clicking_on_it(String arg1) throws Throwable {
		//driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
		WebElement book = driver.findElement(By.xpath((".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[2]/div/div[1]/a/img")));
		book.click();
	} 
			//"//*[contains(@src, 'google')]"
	
	@Then("^The books details are shown$")
	public void the_books_details_are_shown() throws Throwable {
		assertEquals("The Big Switch", driver.findElement(By.xpath((".//*[@id='shop']/section/div/h1"))));
	    //throw new PendingException();
	}

	
	@Given("^I am on the Shopizer website$")
	public void i_am_on_the_Shopizer_website() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}

	@When("^I write the name of a book in the searchfield$")
	public void i_write_the_name_of_a_book_in_the_searchfield() throws Throwable {
		//driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
		WebElement book = driver.findElement(By.xpath((".//*[@id='searchField']")));
		book.click();
	    
	}

	@Then("^The book shows if it exists in the book database$")
	public void the_book_shows_if_it_exists_in_the_book_database() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^I click on the shopping cart button$")
	public void i_click_on_the_shopping_cart_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^The shopping cart opens and i can see what is in it$")
	public void the_shopping_cart_opens_and_i_can_see_what_is_in_it() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
		WebElement book = driver.findElement(By.xpath((".//*[@id='open-cart']")));
		book.click();
	   
	}

	@When("^I click on the sign in button$")
	public void i_click_on_the_sign_in_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
		WebElement book = driver.findElement(By.xpath((".//*[@id='customerAccount']/button")));
		book.click();
	   
	}

	@Then("^I fill in my username and password to log in$")
	public void i_fill_in_my_username_and_password_to_log_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^I click on the contact us button$")
	public void i_click_on_the_contact_us_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, -250);");
		WebElement book = driver.findElement(By.xpath((".//*[@id='navbar-collapse-2']/ul/li[2]/a")));
		book.click();
	   
	}

	@Then("^a contact form to fill in appears$")
	public void a_contact_form_to_fill_in_appears() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^I have chosen a book and put it in the cart$")
	public void i_have_chosen_a_book_and_put_it_in_the_cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement book = driver.findElement(By.xpath(("//*[contains(@src, 'google')]")));
		book.click();

		Thread.sleep(3000);
		
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		
		Thread.sleep(3000);
		
		WebElement book5 = driver.findElement(By.xpath((".//*[@id='input-6']/div/button")));
		book5.click();
		
		Thread.sleep(3000);
		
		Actions actions2 = new Actions(driver);
		actions2.keyUp(Keys.CONTROL).sendKeys(Keys.HOME).perform();
	    //throw new PendingException();
	}

	@Then("^I purchase the book by checking out$")
	public void i_purchase_the_book_by_checking_out() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(By.id("open-cart")));
	
	WebElement book7 = driver.findElement(By.id("open-cart"));
	
	book7.click();
	
	Thread.sleep(3000);
	WebElement book8 = driver.findElement(By.xpath((".//*[@id='miniCartDetails']/li/div/a")));
	
	book8.click();
	
	Thread.sleep(3000);

	WebElement book9 = driver.findElement(By.id("checkoutButton"));
	
	book9.click();
	    //throw new PendingException();
	}
	
	@Then("^I remove the book from the cart again$")
	public void i_remove_the_book_from_the_cart_again() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^I choose a book by adding it to the cart, open the cart and check out$")
	public void i_choose_a_book_by_adding_it_to_the_cart_open_the_cart_and_check_out() throws Throwable {
		WebElement book = driver.findElement(By.xpath(("//*[contains(@src, 'google')]")));
		book.click();

		Thread.sleep(3000);
		
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		
		Thread.sleep(3000);
		
		WebElement book5 = driver.findElement(By.xpath((".//*[@id='input-6']/div/button")));
		book5.click();
		
		Thread.sleep(3000);
		
		Actions actions2 = new Actions(driver);
		actions2.keyUp(Keys.CONTROL).sendKeys(Keys.HOME).perform();
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(By.id("open-cart")));
	
	WebElement book7 = driver.findElement(By.id("open-cart"));
	
	book7.click();
	
	Thread.sleep(3000);
		
	WebElement book8 = driver.findElement(By.xpath((".//*[@id='miniCartDetails']/li/div/a")));
		
	book8.click();
	
	Thread.sleep(3000);

	WebElement book9 = driver.findElement(By.id("checkoutButton"));
	
	book9.click();
	
	   // throw new PendingException();
	}

	@Then("^I am taken to the till$")
	public void i_am_taken_to_the_till() throws Throwable {
		assertEquals("Review your order", driver.getTitle());
	    //throw new PendingException();
	}

}

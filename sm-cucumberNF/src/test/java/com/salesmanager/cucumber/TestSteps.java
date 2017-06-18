package com.salesmanager.cucumber;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.Before; //måste importeras då det inte är en feature-fil.

public class TestSteps {
	
	WebDriver driver;
	@Before
	public void setup() {
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Niklas\\Desktop\\Automatiserad testning\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Niklas\\Desktop\\Automatiserad testning\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1920, 1080));
	}


	
	
	@Given("I want to access the shopizer website")
	public void i_want_to_write_a_step_with_precondition() throws Throwable {
	    driver.get("https://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
	    throw new PendingException();
	}
	
	@When("^I click on the book that is named The big Switch$")
	public void some_other_precondition() throws Throwable {
		WebElement book2 = driver.findElement(By.xpath("//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[1]/div/div[1]/a/img"));
		book2.click();
	    
	}
	@When("^I click on the book that is named Spring in Action$")
	public void chooseSpringinAction() throws InterruptedException {
		WebElement book2 = driver.findElement(By.xpath("//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[3]/div/div[1]/a/img"));
		book2.click();
	}
	@When("^I click on the book that is called Node Web Development$")
	public void chooseNodeWebDevelopment() throws InterruptedException {
		WebElement book2 = driver.findElement(By.xpath("//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[2]/div/div[1]/a/img"));
		book2.click();
	}
	
	
	
	@Then("^I can see the product details for the book Spring in Action$")
	public void choose_Spring_in_action() throws Throwable {
	assertEquals("Spring in Action", driver.getTitle());
	}
	
	@Then("^I can see the product details for the book Node Web Development$")
	public void choose_Node_Web_Development() throws Throwable {
	assertEquals("Node Web Development", driver.getTitle());
	}
	
	@When("^I type in the URL to the shopizer site and press enter$")
	public void i_complete_action() throws Throwable {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
	   
	}

	@When("^I click on the book that is named $")
	public void some_other_action() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^yet another action$")
	public void yet_another_action() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I get access to the shopizer site$")
	public void i_validate_the_outcomes() throws Throwable {
		assertEquals("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/", driver.getCurrentUrl());  
	}

	@Then("^I see the product details for that book$")
	public void check_FirstBook() throws Throwable {
		assertEquals("The Big Switch", driver.getTitle());
	  
	}

	@Given("^I want to write a step with name(.*)$")
	public void i_want_to_write_a_step_with_name(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I check for the (\\d+) in step$")
	public void i_check_for_the_in_step(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I verify the success in step$")
	public void i_verify_the_success_in_step() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I verify the Fail in step$")
	public void i_verify_the_Fail_in_step() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^I am on the startpage$")
	public void i_am_on_the_startpage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop");

	}

	@When("^I click on a product$")
	public void i_click_on_a_product() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		WebElement book = driver.findElement(By.xpath( "//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[2]/div/div[1]/a/img"));
		book.click();
		Thread.sleep(1000);
	}

	@Then("^I should se product details$")
	public void i_should_se_product_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		assertEquals("The Big Switch", driver.getTitle());
	}
	@And("^click on the add to cart button$")
	public void click_on_the_add_to_cart_button() throws Throwable{
	WebElement button = driver.findElement(By.xpath("//*[@id='input-1']/div/button"));
	button.click(); //webelement får inte heta book i detta fall då det är upptaget.
    }
	
	@And("^I click on the cart symbol on top of the web page$")
	public void display_cart_contents() throws Throwable{
	Thread.sleep(3000);
	WebElement cartSymbol = driver.findElement(By.xpath("//*[@id='open-cart']"));
	cartSymbol.click(); 
	
	} 
	
	@And("^click on the Big Switch's add to cart button$")
	public void click_Big_Switch_add_to_cart() throws Throwable{
	WebElement button = driver.findElement(By.xpath("//*[@id='input-6']/div/button"));
	button.click(); 
	
	}
	@And("^I click on the checkout button$")
	public void AddToCartAndCheckout() throws Throwable  { 
	WebElement checkout = driver.findElement(By.xpath("//*[@id='miniCartDetails']/li/div/a"));
	checkout.click();
	}
	@And("^I click on the continue shopping button$")
	public void click_on_continue_shopping_button() throws Throwable {
	WebElement continueShopping = driver.findElement(By.xpath("//*[@id='mainCartTable']/tfoot/tr/td[1]/a[2]"));
	continueShopping.click();
	}
	
	@And("^I click on the place order button$")
	public void place_order() throws Throwable {
	WebElement placeOrder = driver.findElement(By.xpath("//*[@id='checkoutButton']"));
	placeOrder.click();
	}
	
	@Then("^I am directed to the checkout page$")
	public void directed_to_checkout_page() throws Throwable {
	assertEquals("Place your order", driver.getTitle());
	
}
	@Then("^I am directed to the start page$")
	public void directed_to_start_page() throws Throwable {
	assertEquals("Shopizer Demo - Default store", driver.getTitle());
	}
	
	@Then("^I am redirected to the checkout confirmation page$")
	public void checkout_redirection() throws Throwable {
	assertEquals("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/order/checkout.html", driver.getCurrentUrl());
	}
	
	}


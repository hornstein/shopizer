package com.salesmanager.cucumber;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import com.salesmanager.cucumber.steps.*;
public class TestSteps {

	BuyerSteps user;
	
//WebDriver driver;

@Before

/*
public void setup() {
	System.setProperty("webdriver.gecko.driver","C:\\SeleniumGecko\\geckodriver.exe");
	driver = new FirefoxDriver();
}

@After
public void setup2(){
	driver.close();
	
}
*/


	/*@Given("^I am on the Shopizer website$")
	public void i_am_on_the_Shopizer_website() throws Throwable {
		
		WebElement book = driver.findElement(By.xpath((".//*[@id='searchField']")));
		book.click();
	    //throw new PendingException();
	}*/

	@When("^I write the name of a book in the searchfield$")
	public void i_write_the_name_of_a_book_in_the_searchfield() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^The book shows if it exists in the book database$")
	public void the_book_shows_if_it_exists_in_the_book_database() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}


	@Given("^I am on the startpage$")
	public void i_am_on_the_startpage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		user.opens_home_page();
		//driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
	}

	@When("^I select the book \"([^\"]*)\" by clicking on it$")
	public void i_select_the_book_by_clicking_on_it(String arg1) throws Throwable {
		WebElement book = driver.findElement(By.xpath(("//*[contains(@src, 'google')]")));
		book.click();
	}


	@Then("^The books details are shown$")
	public void the_books_details_are_shown() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 assertEquals("The Big Switch", driver.getTitle());
	}

	@When("^I click on the cart$")
	public void i_click_on_the_cart() throws Throwable {
		
		user.click_on_cart();
		
		//WebElement book = driver.findElement(By.xpath((".//*[@id='open-cart']")));
		//book.click();
		//WebElement cart = driver.findElement(By.id("miniCartDetails"));
	    
	}

	@Then("^The cart details are shown$")
	public void the_cart_details_are_shown() throws Throwable {
	    
	}


}

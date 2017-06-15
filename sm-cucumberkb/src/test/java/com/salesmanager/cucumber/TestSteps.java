package com.salesmanager.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class TestSteps {
	@Given("^I am on the Shopizer website$")
	public void i_am_on_the_Shopizer_website() throws Throwable {
		WebElement book = driver.findElement(By.xpath((".//*[@id='searchField']")));
		book.click();
	    //throw new PendingException();
	}

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
}
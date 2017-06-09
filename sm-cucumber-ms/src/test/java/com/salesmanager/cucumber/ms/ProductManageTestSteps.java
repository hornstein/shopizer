package com.salesmanager.cucumber.ms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class  ProductManageTestSteps extends ParentPage{
	WebDriver driver;
	JavascriptExecutor js;
	
	@Before("@product")
	public void setup() throws Throwable{
		ParentPage.init();
	}
	
	@After("@product")
	public void exit(){
		ParentPage.close();
	}
	
	@Given("^I navigate to the home page$")
	public void navigateToHomePage(){
		MainStuff.goToTheHomePage();
	} 
	
	@And("^I choose a book with title contains \"(.*)\"$")
	public void chooseBookWithTitleContains(String name){
		ProductStuff.goToProductPage(name);
	}
	
	@And("^I add the book to the shoppingcart$")
	public void addBookToTheShoppingcart(){
		ProductStuff.addToCart();
		
	}
	
	@Then("^I verify that the book is added to the shoppingcart$")
	public void verifyBookAdded() throws InterruptedException{
		ProductStuff.verifyBookInCart();
	}
	
	@When("^I click on delete th book should desappear from shoppingcart$")
	public void deleteFromShoppingcart() throws InterruptedException{
		ProductStuff.remove();
	}
	
	@Then("^I checkout$")
	public void checkout() throws InterruptedException{
		ProductStuff.checkout();
	}
	
	@And("^I place order$")
	public void placeOrder(){
		ProductStuff.placeOrder();
	}
	
	@When("^The book name is entered in the search field and i click on search the book page should show up$")
	public void searchForABook(){
		MainStuff.goToTheHomePage();
		ProductStuff.search();
	}
}

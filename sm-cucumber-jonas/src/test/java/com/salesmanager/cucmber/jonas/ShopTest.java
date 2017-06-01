package com.salesmanager.cucmber.jonas;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShopTest {
	WebDriver driver;
	
	@Before("@Selenium")
	public void setup(){
	System.setProperty("webdriver.gecko.driver", "/Users/jonaslindberg/Tools/Geckodriver/geckodriver"); //geckodriver för att kunna hitta sidan. Sedan vart man lagt geckodriver.
	driver = new FirefoxDriver();
	}
		
		@Given("^I am on shopizer website$")
		public void shopizerHomePage(){
			driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/product/the-big-switch.html");
		}
		@And("^I click on defaultstore$")
		public void defaultStore(){
			WebElement storeLink = driver.findElement(By.linkText("Default store")); 
			storeLink.click();
		}
		@Then("^I should be on the defaultstore page$")
		public void checkDefaultStorePage() throws InterruptedException{
			Thread.sleep(2000);
			assertEquals("Shopizer Demo - Default store", driver.getTitle()); 
			System.out.println(driver.getTitle());
			driver.close();
		}
	}
	


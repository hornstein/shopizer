package com.salesmanager.cucumber;

import static org.junit.Assert.assertEquals;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.Before;
import cucumber.api.java.After;

import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestSteps {
	
WebDriver driver;
private String baseUrl;

@Before("@selenium")
public void setUp() throws Throwable {
//	DesiredCapabilities capability = DesiredCapabilities.firefox();
//	capability.setBrowserName("firefox");
//	driver = new RemoteWebDriver( new URL("http://dockerselenium.azurewebsites.net/wd/hub"), capability);
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	driver.manage().window().setSize(new Dimension(1920,1080));
    baseUrl = "http://jenkins2017.westeurope.cloudapp.azure.com:8080";

	System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
	driver = new ChromeDriver();

}


	@Given("^I am on start page$")
	public void i_am_on_start_page() throws Throwable {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
	    
	}

	@When("^I select Spring in action$")
	public void i_select_Spring_in_action() throws Throwable {
		WebElement book = driver.findElement(By.xpath("//*[contains(@src,'spring')]"));
		book.click();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 250);");
		WebElement addToCart = driver.findElement(By.className("addToCartButton"));
		addToCart.click();
		
		
		Thread.sleep(2000);
		jse.executeScript("scroll(0, -250);");
		WebElement shoppingBag = driver.findElement(By.xpath(".//*[@id='open-cart']"));
		Thread.sleep(2000);
		shoppingBag.click();
		driver.findElement(By.xpath("//*[@id='miniCartDetails']/li/div/a")).click();
	    
	}

	@Then("^The book I selected is placed in the shoppingcart$")
	public void the_book_I_selected_is_placed_in_the_shoppingcart() throws Throwable {
		Thread.sleep(5000);
		assertEquals("Review your order",driver.findElement(By.xpath(".//*[@id='main-content']/div/h1")).getText());
		
		driver.quit();
		
	    
	}

	@When("^I select Spring in action and The big Switch$")
	public void i_select_Spring_in_action_and_The_big_Switch() throws Throwable {
		WebElement storeLink = driver.findElement(By.linkText("Default store")	);
		storeLink.click();
		
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 350);");
		WebElement book2 = driver.findElement(By.xpath(".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[2]/div/div[1]/a/img"));
		book2.click();
		
		Thread.sleep(1000);
		jse.executeScript("scroll(0, 350);");
		WebElement addToCart2 = driver.findElement(By.xpath(".//*[@id='input-6']/div/button"));
		addToCart2.click();
		
		Thread.sleep(1000);
		jse.executeScript("scroll(0, -350);");
		WebElement goToCart = driver.findElement(By.xpath(".//*[@id='open-cart']"));
		goToCart.click();
		WebElement goToCart2 = driver.findElement(By.xpath(".//*[@id='miniCartDetails']/li/div/a"));
		goToCart2.click();
		
		
	    
	}

	@Then("^The books I selected is placed in the shoppingcart$")
	public void the_books_I_selected_is_placed_in_the_shoppingcart() throws Throwable {
		Thread.sleep(2000);
		assertEquals("Review your order",driver.findElement(By.xpath(".//*[@id='main-content']/div/h1")).getText());
		
		driver.quit();
	    
	}
	@Given("^the user is logged out$")
	public void the_user_is_logged_out() throws Throwable {
	    driver.get(baseUrl + "/shop/customer/logout");
	}

	@When("^the user register with \"(.*)\"$")
	public void the_user_register_with(String name) throws Throwable {
	    driver.get(baseUrl + "/shop/customer/registration.html");
	    driver.findElement(By.id("firstName")).clear();
	    driver.findElement(By.id("firstName")).sendKeys(name);
	    driver.findElement(By.id("lastName")).clear();
	    driver.findElement(By.id("lastName")).sendKeys("Test");
	    driver.findElement(By.id("hidden_zones")).clear();
	    driver.findElement(By.id("hidden_zones")).sendKeys("Test");
	    driver.findElement(By.id("userName")).clear();	    
	    driver.findElement(By.id("userName")).sendKeys(java.util.UUID.randomUUID().toString());
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("3bitstest@gmail.com");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("Password123");
	    driver.findElement(By.id("passwordAgain")).clear();
	    driver.findElement(By.id("passwordAgain")).sendKeys("Password123");
	    driver.findElement(By.id("submitRegistration")).click();
	}
	
	@Then("^the user should receive a greeting with \"([^\"]*)\"$")
	public void the_user_should_receive_a_greeting_with(String name) throws Throwable {
		Thread.sleep(10000);
		String username = driver.findElement(By.xpath("//*[@id='customerAccount']/button/span/span")).getText();
		assertEquals(username, name.toUpperCase());
	}


	@After("@selenium")
	public void tearDown(){
		driver.quit();
	}
}
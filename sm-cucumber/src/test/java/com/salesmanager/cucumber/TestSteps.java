package com.salesmanager.cucumber;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestSteps {

	private WebDriver driver;

	@Before("@selenium")
	public void setUp() throws MalformedURLException{
//		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.16.1-win64\\geckodriver.exe");
//		driver = new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//				DesiredCapabilities capability = DesiredCapabilities.firefox();
//				capability.setBrowserName("firefox");
//				driver = new RemoteWebDriver( new URL("http://dockerselenium.azurewebsites.net/wd/hub"), capability);
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				driver.manage().window().setSize(new Dimension(1920,1080));

				DesiredCapabilities capability = DesiredCapabilities.chrome();
				capability.setBrowserName("chrome");
				driver = new RemoteWebDriver( new URL("http://chrome.azurewebsites.net/wd/hub"), capability);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().setSize(new Dimension(1920,1080));
	}


	@Given("^I am on the start page$")
	public void i_am_on_the_start_page() throws Throwable {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop");
		//driver.get("http://shopizer.azurewebsites.net/shop/customer/logout");
	}

	@When("^I add a book$")
	public void i_add_a_book() throws Throwable {
		//WebElement element = driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[2]/div/div[1]/div/div[1]/a"));
		WebElement element = driver.findElement(By.xpath(".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[3]/div/div[1]/a"));
		Actions builder = new Actions(driver);
		Action mouseOverBook = builder.moveToElement(element,0,0).build();
		mouseOverBook.perform();

		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@productid='1']"))));

		WebElement book = driver.findElement(By.xpath(".//*[@productid='1']"));
		book.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Could not go to sleep. Read me a story!");
			e.printStackTrace();
		}
	}

	@Then("^It shows up in shopping cart$")
	public void it_shows_up_in_shopping_cart() throws Throwable {
		driver.findElement(By.id("open-cart")).click();

		WebElement rwe;
		//rwe = ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='6']/td[2]")))));
		rwe = ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.id("miniCartDetails")))));

		assertTrue(rwe!=null);
	}


	@When("^I click check out$")
	public void i_click_check_out() throws Throwable {

//		WebElement element = driver.findElement(By.partialLinkText("Checkout"));
//		element.click();
		driver.findElement(By.xpath("//*[@id='miniCartDetails']/li/div/a")).click();

	}

	@Then("^I am taken to the check out page$")
	public void i_am_taken_to_the_check_out_page() throws Throwable {
		String s = "Place your order";
		final String temp = s.toLowerCase();

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {

				return d.getTitle().toLowerCase().startsWith(temp);
			}
		});

		assertEquals("Place your order", driver.getTitle()); 
	}

	@When("^I change quatity in cart$")
	public void i_change_quatity_in_cart() throws Throwable {
		driver.findElement(By.name("quantity")).clear();
		driver.findElement(By.name("quantity")).sendKeys("2");
		driver.findElement(By.linkText("Recalculate")).click();

		//Could not find a better way, so go to sleep..
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Could not go to sleep. Read me a story!");
			e.printStackTrace();
		}		
	}

	@Then("^The total is updated accordingly$")
	public void the_total_is_updated_accordingly() throws Throwable {
		String price = driver.findElement(By.xpath(".//*[@id='mainCartTable']/tbody/tr[1]/td[3]/strong")).getText().substring(3);
		String sum = driver.findElement(By.xpath(".//*[@id='mainCartTable']/tbody/tr[3]/td[3]/strong")).getText().substring(3);

		assertEquals(Double.parseDouble(sum), Double.parseDouble(price)*2, 0);
	}

	@When("^I click continue shopping$")
	public void i_click_continue_shopping() throws Throwable {
		driver.findElement(By.partialLinkText(" Continue shopping")).click();		
	}

	@Then("^I am taken to the start page$")
	public void i_am_taken_to_the_start_page() throws Throwable {
		String s = "Shopizer Demo";
		final String temp = s.toLowerCase();

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith(temp);
			}
		});

		assertEquals(s+" - Default store", driver.getTitle()); 
	}

	@Given("^I click Sign In$")
	public void i_click_Sign_In() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='customerAccount']/button")).click();
	}

	@When("^I click Not yet registered$")
	public void i_click_Not_yet_registered() throws Throwable {
		driver.findElement(By.partialLinkText("Not yet registered?")).click();
	}

	@Then("^I am taken to the register page$")
	public void i_am_taken_to_the_register_page() throws Throwable {
		WebElement rwe;
		rwe = ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='registrationForm']")))));

		assertTrue(rwe!=null);
	}

	@After("@selenium")
	public void tearDown(){
		driver.quit();
	}
}

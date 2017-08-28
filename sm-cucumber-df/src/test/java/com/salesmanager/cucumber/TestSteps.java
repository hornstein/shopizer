package com.salesmanager.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.*;
import cucumber.api.junit.Cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestSteps {
	
	private WebDriver driver;
	private String baseUrl;

	@Before("@selenium")
	public void setUp() throws Throwable {
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		driver = new RemoteWebDriver( new URL("http://dockerselenium.azurewebsites.net/wd/hub"), capability);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1920,1080));
	    baseUrl = "http://jenkins2017.westeurope.cloudapp.azure.com:8080";
	}
	
	@Given("^I navigated to the shopizer-site$")
	public void shouldNavigateToShopizer() throws Throwable {
		System.out.println("Navigating to baseurl");
		driver.get(baseUrl);
	}

	@When("^I click on nodebook$")
	public void shouldClickOnNodeBook() throws Throwable {
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@class='product-image']//*[contains(@src, 'node')]")).click();
	}
	
	@And("^I click on 'add to cart nodebook'$")
	public void shouldClickAddToCartNodeBook() throws Throwable {
		Thread.sleep(750);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
        driver.findElement(By.xpath(".//*[@id='input-2']/div/button")).click();
	}
	
	@And("^I assert that its in the cart with the correct price Node.$")
	public void checkCorrectPriceNodeBook() throws Throwable {
		assertEquals("CAD29.99", driver.findElement(By.xpath(".//*[@id='mainCartTable']/tbody/tr[3]/td[3]/strong")).getText());
	}
	

	@When("^I Click on googlebook$")
	public void shouldClickOnGoogleBook() throws Throwable {
		System.out.println("PoC attempt #2");
		driver.findElement(By.className("col-sm-4")).click();
	}
	// 2 new methods added! One 'When' and One 'And'.
	@When("^I click on springbook$")
	public void shouldClickOnSpringBook() throws Throwable {
		System.out.println("pocTest");
		driver.findElement(By.xpath("//*[@class='product-image']//*[contains(@src, 'spring')]")).click();
	}
	// Also a new method
	@And("^I click on 'add to cart GoogleBook''$")
	public void shouldClickAddToCartGoogleBook() throws Throwable {
		Thread.sleep(750);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
        driver.findElement(By.xpath(".//*[@id='input-1']/div/button")).click();
	}

	@And("^I click on 'add to cart'$")
	public void shouldClickAddToCart() throws Throwable {
		System.out.println("PoC attempt #3");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(350,350)");
        Thread.sleep(1337);
		driver.findElement(By.xpath(".//*[@id='input-6']/div/button")).click();
	}


	@Then("^I validate that the book is added to the shoppingcart$")
	public void checkThatBookIsInCart() throws Throwable {
		System.out.println("PoC attempt #4");
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/cart/shoppingCart.html");
		assertEquals("Place your order", driver.getTitle());
	}
	

	@And("^I assert that its in the cart with the correct price Google.$")
	public void checkCorrectPriceGoogleBook() throws Throwable {
		System.out.println("PoC attempt #5");
		assertEquals("CAD18.99", driver.findElement(By.xpath(".//*[@id='mainCartTable']/tbody/tr[1]/td[3]/strong")).getText());
	}
	//new method
	@And("^I assert that the book is in the cart with the correct price Spring")
	public void checkCorrectPriceSpringBook() throws Throwable {
		assertEquals("CAD39.99", driver.findElement(By.xpath(".//*[@id='mainCartTable']/tbody/tr[2]/td[3]/strong")).getText());
	}
	
	@When("^I click on business-link$")
	public void clickOnBussinessHTML() throws Throwable {
		Thread.sleep(250);
		driver.findElement(By.xpath(".//*[@id='topMain']/li[2]/a/span")).click();
	}
	
	@And("^I assert that we landed on the correct page.$")
	public void assertLandingPage() throws Throwable {
		assertEquals("", driver.getTitle());
	}
	
	@And("^I scroll down on that page$")
	public void scrollingDown() throws Throwable {
		Thread.sleep(250);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("javascript:window.scrollBy(350,350)");
	    Thread.sleep(250);
	}
	@Then("^I assert that we're on the right page, and the googlebook image has enlarged$")
	public void assertingEnlargeGoogleBook() throws Throwable {
		driver.findElement(By.xpath("//div[@id='largeImg']/img")).click();
		assertEquals("The Big Switch", driver.getTitle());
		assertEquals("", driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div/figure/figcaption/div/div[1]")).getText());
	}
	@Then("^I assert that we're on the right page, and the springbook image has enlarged$")
	public void assertingEnlargeSpringBook() throws Throwable {
		Thread.sleep(250);
        driver.findElement(By.xpath("//div[@id='largeImg']/img")).click();
        assertEquals("Spring in Action", driver.getTitle());
	}
	
	@Then("^I assert that we're on the right page, and the nodebook image has enlarged$")
	public void assertingEnlargeNodeBook() throws Throwable {
		Thread.sleep(100);
		driver.findElement(By.xpath("//div[@id='largeImg']/img")).click();
        Thread.sleep(100);
        assertEquals("Node Web Development", driver.getTitle());
	}
	
	@When("^I click on paasbook$")
	public void clickOnPaasBook() throws Throwable {
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@class='product-image']//*[contains(@src, 'paas')]")).click();
	}
	
	@And("^I click on 'add to cart paasbook'$")
	public void addToCartPaasBook() throws Throwable {
		Thread.sleep(750);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(350,350)");
        driver.findElement(By.xpath(".//*[@id='input-3']/div/button")).click();
	}
	
	@Then("^I validate that the paas book has been added to the cart$")
	public void validatePaasBookAddedToCart() throws Throwable{
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/cart/shoppingCart.html");
        assertEquals("Place your order", driver.getTitle());
	}
	
	@And("^I assert that the book is in the cart, and the right price for paas book$")
	public void assertingPriceForPaasBook() throws Throwable {
		Thread.sleep(123);
		assertEquals("CAD19.99", driver.findElement(By.xpath(".//*[@id='mainCartTable']/tbody/tr[3]/td[3]/strong")).getText());
	}
	
	@Given("^I navigated to the paasbookURL$")
	public void paasBookUrl() throws Throwable {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/category/computer-books.html/ref=c:1");
	}
	
	@And("^I click on the paasbook$")
	public void clickOnPaasBook2() throws Throwable {
		Thread.sleep(123);
		driver.findElement(By.xpath(".//*[@id='productsContainer']/div[3]/div")).click();
	}
	
	@Then("^I scrolldown and assert that paasbook image is enlarged$")
	public void scrollAndEnlargePaasBookWithAssert() throws Throwable {
		Thread.sleep(250);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(350,350)");
        Thread.sleep(250);
        driver.findElement(By.xpath("//div[@id='largeImg']/img")).click();
        assertEquals("Programming for PAAS", driver.getTitle());
	}
	
	@Then("^I do a specialscrolling on that page to click contactfor$")
	public void specialScrollingContactPage() throws Throwable {
		Thread.sleep(75);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(400,500)");
	}
	
	@Then("^I click on the contactform link and encounter a javascript-alert-error$")
	public void clickToContactFormWithError() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='footer-section']/div[2]/div/div[3]/div/ul/li[4]/a")).click();
		//Bug found, as it prompts "ZERO_RESULTS"
		fail();
	}
}

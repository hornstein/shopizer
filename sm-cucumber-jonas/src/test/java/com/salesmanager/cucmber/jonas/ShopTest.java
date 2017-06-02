package com.salesmanager.cucmber.jonas;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ShopTest {
	WebDriver driver;
	
	/*@Before("@selenium")
	public void setUp() throws Throwable {
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		driver = new RemoteWebDriver( new URL("http://dockerselenium.azurewebsites.net/wd/hub"), capability);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1920,1080));
	    baseUrl = "http://jenkins2017.westeurope.cloudapp.azure.com:8080";
	}*/
	
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
		@And("^I click on business$")
		public void business(){
			WebElement businessLink = driver.findElement(By.linkText("Business"));
			businessLink.click();
		}
		@Then("^I should be on the business page$")
		public void checkBusinessPage(){
			WebDriverWait w = new WebDriverWait(driver, 10);
			w.until(ExpectedConditions.elementToBeClickable(By.className("lead")));
			
			WebElement business2Link = driver.findElement(By.className("lead"));
			business2Link.getText();
			assertEquals("Business", business2Link.getText());
			System.out.println(business2Link.getText());
			
			driver.close();
		}
		@And("^I click on contact us$")
		public void checkContactUsPage(){
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 250);");
			
			WebDriverWait w = new WebDriverWait(driver, 10);
			w.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='footer-section']/div[2]/div/div[3]/div/ul/li[4]/a")));
			
			WebElement contactLink = driver.findElement(By.xpath(".//*[@id='footer-section']/div[2]/div/div[3]/div/ul/li[4]/a"));
			contactLink.click();
		}
		@Then("^I should be on contact us page$")
		public void failContactUsPage(){
		System.out.println("Geocode was not successful for the following reason: ZERO_RESULTS");
		
		driver.close();
	}
		
}		
	


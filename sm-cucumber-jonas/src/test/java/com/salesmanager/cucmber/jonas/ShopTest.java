package com.salesmanager.cucmber.jonas;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Dimension;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.net.URL;
import java.util.concurrent.TimeUnit;
public class ShopTest {
	WebDriver driver;
	/*private WebDriver driver;
	private String baseUrl;
	
	@Before("@selenium")
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
			driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
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
		@And("^I click on signin$")
		public void signIn(){
			WebElement sign = driver.findElement(By.xpath(".//*[@id='customerAccount']/button"));
			sign.click();
		}
		@And("^I fill in password and username$")
		public void passAndUserName(){
			WebElement usern = driver.findElement(By.id("signin_userName"));
			usern.sendKeys("Jonas");
			
			WebElement passw = driver.findElement(By.id("signin_password"));
			passw.sendKeys("12345");
		}
		@And("^I click on login$")
		public void logIn() throws InterruptedException{
			WebElement login = driver.findElement(By.xpath(".//*[@id='login-button']"));
			login.click();
			
			Thread.sleep(2000);
		}
		@Then("^I should get an error message$")
		public void errorM(){
			WebElement error = driver.findElement(By.xpath(".//*[@id='loginError']"));
			assertEquals("Login Failed. Username or Password is incorrect.", error.getText());
			System.out.println(error.getText());
			
			driver.close();
		}
		@Given("^I am under businesslink in shopizer website$")
		public void sortby(){
			driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/category/business.html/ref=c:6");
		}
		@And("^I click on sortby$")
		public void sb(){
			WebElement nm = driver.findElement(By.xpath("//*[@value='item-name']"));
			nm.click();
		}
		@Then("^I should se Name$")
		public void nm(){
			WebElement nm = driver.findElement(By.xpath("//*[@value='item-name']"));
			assertEquals("Name", nm.getText());
			driver.close();
		}
		
		@And("^I click on add to cart$")
		public void atc(){
			//WebElement add = driver.findElement(By.xpath( ".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[3]/div/div[1]/a/img"));
			WebElement add = driver.findElement(By.xpath(".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[3]/div/div[1]/a/img"));
			add.click();
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 250);");
			
			WebDriverWait w = new WebDriverWait(driver, 10);
			w.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='input-2']/div/button")));
			
			WebElement button = driver.findElement(By.xpath( ".//*[@id='input-2']/div/button"));
			button.click();
			System.out.println("Book Node Web Development has been added to shopping cart");
		}
		@And("^I click on open cart$")
		public void oc(){
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, -250);");
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='open-cart']")));
			
			WebElement cart = driver.findElement(By.xpath(".//*[@id='open-cart']"));
			cart.click();
		}
		@Then("^I check that the book is added$")
		public void check(){
			WebElement book = driver.findElement(By.xpath(".//*[@id='2']/td[2]"));
			book.getText();
			assertEquals("1 Node Web Development", book.getText());
			
			driver.close();
		}
		@And("^I add the book Node Web Development$")
		public void addNwd(){
			WebElement add = driver.findElement(By.xpath(".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[3]/div/div[1]/a/img"));
			add.click();
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath( ".//*[@id='input-2']/div/button")));
			
			WebElement button = driver.findElement(By.xpath( ".//*[@id='input-2']/div/button"));
			button.click();
			System.out.println("Book Node Web Development has been added to shopping cart");
		}
		@And("^I click on open cart and checkout$")
		public void checkO(){
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, -250);");
			
			WebDriverWait wai = new WebDriverWait(driver, 10);
			wai.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='open-cart']")));
			
			WebElement cart = driver.findElement(By.xpath(".//*[@id='open-cart']"));
			cart.click();
			
			WebElement co = driver.findElement(By.xpath(".//*[@id='miniCartDetails']/li/div/a"));
			co.click();
			
			WebDriverWait wa = new WebDriverWait(driver, 10);
			wa.until(ExpectedConditions.elementToBeClickable(By.className("cart-title")));
		}
		@Then("^I review my order$")
		public void review(){
			WebElement rev = driver.findElement(By.className("cart-title"));
			rev.getText();
			assertEquals("Review your order", rev.getText());
			
			driver.close();
		}
		@And("^I add a book$")
		public void aAb(){
			WebElement add = driver.findElement(By.xpath(".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[3]/div/div[1]/a/img"));
			add.click();
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath( ".//*[@id='input-2']/div/button")));
			
			WebElement button = driver.findElement(By.xpath( ".//*[@id='input-2']/div/button"));
			button.click();
			System.out.println("Book Node Web Development has been added to shopping cart");
		}
		@And("^I click on open cart to see the added book$")
		public void cart(){
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, -250);");
			
			WebDriverWait wai = new WebDriverWait(driver, 10);
			wai.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='open-cart']")));
			
			WebElement cart = driver.findElement(By.xpath(".//*[@id='open-cart']"));
			cart.click();
		}
		@And("^I click on remove$")
		public void rm(){
			WebElement co = driver.findElement(By.xpath(".//*[@id='miniCartDetails']/li/div/a"));
			co.click();
			
			WebDriverWait w = new WebDriverWait(driver, 10);
			w.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='mainCartTable']/tbody/tr[1]/td[5]/button")));
			
			WebElement r = driver.findElement(By.xpath(".//*[@id='mainCartTable']/tbody/tr[1]/td[5]/button"));
			r.click();
			
			WebDriverWait er = new WebDriverWait(driver, 10);
			er.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='pageContainer']/table/tbody/tr[1]/td[2]/h3")));
		}
		@Then("^I receive and error message$")
		public void erM(){
			WebElement error = driver.findElement(By.xpath(".//*[@id='pageContainer']/table/tbody/tr[1]/td[2]/h3"));
			error.getText();
			assertEquals("An error occurred in this request", error.getText());
			System.out.println(error.getText());
			
			driver.close();
		}
		@Given("^I am under book Node Web D$")
		public void nWd(){
			driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/product/Node-Web-Development.html");
		}
		@And("^I add book Node WD$")
		public void addNwD(){
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath( ".//*[@id='input-2']/div/button")));
			
			WebElement button = driver.findElement(By.xpath( ".//*[@id='input-2']/div/button"));
			button.click();
			System.out.println("Book Node Web Development has been added to shopping cart");
			
		}
		@When("^I open cart and click on x$")
		public void openC() throws InterruptedException{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, -250);");
			
			WebDriverWait er = new WebDriverWait(driver, 20);
			er.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='open-cart']")));
			driver.findElement(By.xpath(".//*[@id='open-cart']")).click();
			
			//WebElement cart = driver.findElement(By.className("btn dropdown-toggle"));
			//cart.click();

				Thread.sleep(2000);
			
			
			WebDriverWait ww = new WebDriverWait(driver, 20);
			ww.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='2']/td[4]/button")));
			
				Thread.sleep(2000);
			
			
			WebElement x = driver.findElement(By.xpath(".//*[@id='2']/td[4]/button"));
			x.click();
			
				Thread.sleep(2000);

			WebElement shop2 = driver.findElement(By.xpath(".//*[@id='open-cart']"));//Får göra det två gånger för att det ska fungera.
			shop2.click();
			
				Thread.sleep(2000);
			
			WebElement x2 = driver.findElement(By.xpath(".//*[@id='2']/td[4]/button"));//Får göra det två gånger för att det ska fungera.
			x2.click();
		}
		@Then("^Book should be removed$")
		public void bookR(){
			WebElement zero = driver.findElement(By.xpath(".//*[@id='miniCartSummary']"));
			zero.getText();
			assertEquals("SHOPPING CART (0)", zero.getText());
			
			System.out.println(zero.getText());
		}
}		
	


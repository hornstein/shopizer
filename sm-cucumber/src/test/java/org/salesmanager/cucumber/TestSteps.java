package org.salesmanager.cucumber;

//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class TestSteps {
	
	private WebDriver driver;
	private String baseUrl;
	
	@Before("@Selenium")
	public void setUp() throws Throwable {
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		driver = new RemoteWebDriver( new URL("http://dockerselenium.azurewebsites.net/wd/hub"), capability);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1920,1080));
	    baseUrl = "http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop";
	}
	@Given("^I am at the home page on Shopizer$")
	public void shopizer_homepage() {
		driver.get(baseUrl + "/shop/");
	  }

	@When("^I Click on the book The Big Switch$")
	public void click_on_spring_in_action() {
		WebElement button = driver.findElement(By.xpath("//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[2]/div/div[1]/a/img"));
		button.click();
	}

	@And("I click on the add to cart button$")
	public void click_on_add_to_cart() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		//jse2.executeScript("window.scrollBy(0, 500)", "");
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-6']/div/button")));
		element.click();
	}
		@And("I open the cart$")
		public void open_cart() {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			JavascriptExecutor jse2 = (JavascriptExecutor)driver;
			jse2.executeScript("window.scrollBy(0, -500)", "");
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='open-cart']")));
			element.click();
		}
	
	
	@Then("I validate that the book is in the shopping cart$")
	public void validate_book_in_shopping_cart() throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("window.scrollBy(0, -500)", "");
		Thread.sleep(2000);
		WebElement element= driver.findElement(By.xpath("//*[@id='6']/td[2]"));
		element.getText();
		assertEquals("1 The Big Switch", element.getText());	
		driver.close();
	}

	@And("I click on computer books$")
	public void check_web_books () throws InterruptedException {
		WebElement element = driver.findElement(By.xpath(".//*[@id='topMain']/li[1]/a/span"));
		element.click();
	}
	
	@And("Click on button Web$")
	public void click_web_button () throws InterruptedException {
		WebElement element = driver.findElement(By.xpath(".//*[@id='topMain']/li[1]/ul/li/div/div/ul/li/a"));
		element.click();
	}

	@Then("^I verify i am on that page$")
	public void verify_page() throws InterruptedException {
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(".//*[@id='mainContent']/header/div[1]/div/h2"));
		element.getText();
		assertEquals("Web", element.getText());
		driver.close();
	}
	
	@And("I Click computer books$")
	public void computer_books () throws InterruptedException {
		WebElement element = driver.findElement(By.xpath(".//*[@id='topMain']/li[1]/a/span"));
		element.click();
	}
	
	@And("I click on cbooks$")
	public void click_cbooks () throws InterruptedException {
		WebElement element = driver.findElement(By.xpath(".//*[@id='topMain']/li[1]/a/span"));
		element.click();
	}
	
	@And("I Click on the author$")
	public void click_on_author () throws InterruptedException {
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("window.scrollBy(0, 200)", "");
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//*[@id='shop']/sidebar/ul[2]/li[3]/a"));
		element.click();
	}
	
	@Then("I verify i only see books from him$")
	public void verify_books () throws InterruptedException {
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("window.scrollBy(0, 200)", "");
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(".//*[@id='productsContainer']/div/div/div[2]/div/div/h3"));
		element.getText();
		assertEquals("Programming for PAAS", element.getText());
		driver.close();
	}
	
	@And("I click on sort by$")
	public void sort_by () throws InterruptedException {
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//*[@id='filter']"));
		element.click();
	}
	
	@And("I select price$")
	public void select_price () throws InterruptedException {
	WebElement element = driver.findElement(By.xpath(".//*[@id='filter']/option[3]"));
		element.click();
	}
	
	@Then("I verify they are ordered by price")
	public void verify_price_order () throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//*[@id='filter']/option[3]"));
		element.getText();
		assertEquals("Price", element.getText());
		driver.close();	
	}
	
	@And("I remove the book from the cart$")
	public void remove_book_from_cart () throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//*[@id='6']/td[4]/button"));
		Thread.sleep(2000);
		element.click();
		
	}
	
	@Then("I verify the book is removed$")
	public void verify_book_is_removed () throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//*[@id='open-cart']"));
		element.getText();
		assertEquals("SHOPPING CART (0)", element.getText());
		driver.close();
	}
	
	@And("I click on checkout$")
	public void click_on_checkout () throws InterruptedException {
		
		WebElement element = driver.findElement(By.xpath("//*[@id='miniCartDetails']/li/div/a"));
		element.click();
	}
	
	@Then("I verify i am in checkout$")
	public void verify_checkout () throws InterruptedException {
		Thread.sleep(2000);
		WebElement element= driver.findElement(By.xpath("//*[@id='mainCartTable']/tbody/tr[1]/td[1]/div/div[2]/span/strong"));
		element.getText();
		assertEquals("The Big Switch", element.getText());	
		driver.close();
	}

}

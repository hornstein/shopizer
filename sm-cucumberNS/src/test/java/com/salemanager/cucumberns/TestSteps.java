package com.salemanager.cucumberns;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.Before;
import cucumber.api.java.After;

import static org.junit.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestSteps {

	private WebDriver driver;
	//private String baseUrl;
	/*
	@Before("@selenium")
	public void setUp() throws Throwable {
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		System.setProperty("webdriver.gecko.driver", 
				"C:\\FoxDriver\\geckodriver.exe");
		//driver = new RemoteWebDriver( new URL("http://dockerselenium.azurewebsites.net/wd/hub"), capability);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().window().setSize(new Dimension(1920,1080));
	   //baseUrl = "http://jenkins2017.westeurope.cloudapp.azure.com:8080";
	    
		
	}*/
	@Before("@selenium")
	public void testBefore() {
		try {
			System.setProperty("webdriver.gecko.driver", "C:\\FoxDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 

@Given("^the user is in home page$")
public void the_user_is_in_home_page() throws Throwable {
	driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080");
}
    
@When("^the user enter Contact us$")
public void the_user_enter_Contact_us() throws Throwable {
	driver.findElement(By.linkText("Contact us")).click(); 
}

@When("^the user remove the error$")
public void the_user_remove_the_error() throws Throwable {
	Thread.sleep(5000);
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);  
	
}

@When("^the user give name \"([^\"]*)\"$")
public void the_user_give_name(String arg1) throws Throwable {
	driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("Kalle");
}

@When("^the user give Email address \"([^\"]*)\"$")
public void the_user_give_Email_address(String arg1) throws Throwable {
	driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("Kalle@yahoo.nu");    
}

@When("^the user give Subject \"([^\"]*)\"$")
public void the_user_give_Subject(String arg1) throws Throwable {
	driver.findElement(By.xpath(".//*[@id='subject']")).sendKeys("Kalle is back");  
}

@When("^the user give Coments \"([^\"]*)\"$")
public void the_user_give_Coments(String arg1) throws Throwable {
	driver.findElement(By.xpath(".//*[@id='comment']")).sendKeys("Kalle have a quation");    
}

@When("^the user  enter send$")
public void the_user_enter_send() throws Throwable {
	driver.findElement(By.xpath(".//*[@id='submitContact']")).click();  
}

@Then("^the user get confirmation$")
public void the_user_get_confirmation() throws Throwable {
	WebElement senCont = driver.findElement(By.xpath(".//*[@id='store.success']"));
	String successText = "Your message has been sent";
	System.out.println(senCont.getText());
	(new WebDriverWait(driver, 10)).until(ExpectedConditions.textToBePresentInElement(senCont, successText));
	assertEquals(successText, senCont.getText());    
}
//==============================================================================================

@When("^the user choose the book$")
public void the_user_choose_the_book() throws Throwable {
	driver.findElement(By.xpath(".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[3]/div/div[1]/a/img"))
	.click(); 
	driver.findElement(By.xpath(".//*[@id='input-1']/div/button"))
	.click();
	Thread.sleep(1000);
	/*WebElement addToCartButton = driver.findElement(By.linkText("Add to cart"));
	Actions action = new Actions(driver);
	action.moveToElement(addToCartButton).build().perform();
	addToCartButton.click();*/
}

@When("^the user go to chart$")
public void the_user_go_to_chart() throws Throwable {
	driver.findElement(By.xpath(".//*[@id='open-cart']")).click();
	Thread.sleep(1000);
}

@When("^the user go to checkout$")
public void the_user_go_to_checkout() throws Throwable {
	//driver.findElement(By.xpath(".//*[@id='open-cart']")).click();
	//Thread.sleep(1000);
}

@When("^the user chenge quantity to ten$")
public void the_user_chenge_quantity_to_ten() throws Throwable {
	WebElement checkoutButton = driver.findElement(By.xpath(".//*[@id='miniCartDetails']/li/div/a"));
	checkoutButton.click();
	Thread.sleep(2000);
	WebElement editDt = driver.findElement(By.name("quantity"));
	editDt.clear(); // clears the text
	editDt.sendKeys("10");
	Thread.sleep(2000);
}

@Then("^the total price is changed$")
public void the_total_price_is_changed() throws Throwable {
	driver.findElement(By.xpath(".//*[@id='mainCartTable']/tfoot/tr/td[1]/a[1]")).click();
	Thread.sleep(1000);
	WebElement el = driver.findElement(By.xpath(".//*[@id='mainCartTable']/tbody/tr[3]/td[3]/strong"));

	System.out.println(el.getText());
	assertEquals("CAD399.90", el.getText());
	Thread.sleep(1000);
}

@After("@selenium")
public void tearDown(){
	driver.quit();
}
//==============================================================================================
@Given("^the user is in the home page$")
public void the_user_is_in_the_home_page() throws Throwable {
	
}

@When("^the user find the book$")
public void the_user_find_the_book() throws Throwable {
	driver.findElement(By.xpath(".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[1]/div/div[1]/a/img"))
	.click();
	Thread.sleep(1000); 
}

@When("^the user add book to chart$")
public void the_user_add_book_to_chart() throws Throwable {
	driver.findElement(By.xpath(".//*[@id='input-2']/div/button")).click();
	Thread.sleep(1000);
	JavascriptExecutor jse1 = (JavascriptExecutor) driver;
	jse1.executeScript("scroll(0, 0);");
	Thread.sleep(1000);
}

@When("^the user is in cahrt$")
public void the_user_is_in_cahrt() throws Throwable {
	
	driver.findElement(By.xpath(".//*[@id='open-cart']")).click();
	Thread.sleep(1000);
}

@Then("^the user compair if exixt$")
public void the_user_compair_if_exixt() throws Throwable {
	
	WebElement ef1 = driver.findElement(By.xpath(".//*[@id='2']/td[2]"));

	System.out.println(ef1.getText());
	assertEquals("1 Node Web Development", ef1.getText());

	Thread.sleep(1000);
}

}

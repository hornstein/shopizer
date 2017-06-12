package com.salesmanager.cucumber.alo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;


public class FindAndAddToCartSteps {
  
  WebDriver driver;
  String baseUrl;
  
   @Before("@selenium")
   public void setup() throws Throwable {
    DesiredCapabilities capability = DesiredCapabilities.firefox();
    capability.setBrowserName("firefox");
    driver = new RemoteWebDriver( new URL("http://dockerselenium.azurewebsites.net/wd/hub"), capability);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().setSize(new Dimension(1920,1080));
    baseUrl = "http://jenkins2017.westeurope.cloudapp.azure.com:8080";
  }

   
/*  @Before()
  public void getDriver() {
    if (driver == null) {
      System.setProperty("webdriver.gecko.driver", "C:\\programmes\\iNet\\geckodriver\\geckodriver.exe");
      System.setProperty("webdriver.firefox.bin", "C:\\programmes\\iNet\\moz\\firefox.exe");
      driver = new FirefoxDriver();
      System.out.println("got a driver....");
    }
  }*/
  
  @Given("^customer is on main page$")
  public void customer_is_on_main_page() throws Throwable {
    driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
//    driver.get("http://localhost:8080/shop");
    assertEquals("Shopizer Demo - Default store", driver.getTitle());
      
  }

  @When("^goes to product page \"([^\"]*)\"$")
  public void goes_to_product_page(String bookTitle) throws Throwable {
    WebElement book = driver.findElement(By.xpath("//*[contains(@src,'" + bookTitle + "')]"));
    try {
      Thread.sleep(2000);      
    } catch (InterruptedException ie) {
      ie.printStackTrace();
      //ie.getMessage();
    }
    book.click();    
    try {
      Thread.sleep(2000);      
    } catch (InterruptedException ie) {
      ie.printStackTrace();
      //ie.getMessage();
    }
    System.out.println("MainPage executed: " + driver.getTitle());
    /**
     * Add a title assert!! 
     */
  }

  @When("^adds item to cart$")
  public void adds_item_to_cart() throws Throwable {   
    try {    
      Thread.sleep(1000);
    } catch (InterruptedException ie) {
      ie.getMessage();
    }
    WebElement addToCart = driver.findElement(By.className("addToCartButton"));
    addToCart.click();
    try {    
      Thread.sleep(1000);
    } catch (InterruptedException ie) {
      ie.getMessage();
    }
    WebElement dropBtn = driver.findElement(By.id("open-cart"));
//  System.out.println("db: " + dropBtn.getText());
    assertFalse("SHOPPING CART (0)".equals(dropBtn.getText()));
    System.out.println("Cart not empty");

  }

  @Then("^product \"([^\"]*)\" is added to cart$")
  public void product_is_added_to_cart(String bookTitle) throws Throwable {
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("scroll(0, -250);");
    WebElement dropBtn = driver.findElement(By.id("open-cart"));
    dropBtn.click();
    try {
      Thread.sleep(500);
    } catch (InterruptedException ie){
      ie.getMessage();
    }
    WebElement shopListImage = driver.findElement(By.xpath("//*[@class='cart-product']//*[contains(@src,'" + bookTitle + "')]"));
    String s = shopListImage.toString();
    boolean trueEndings = s.endsWith("@src,'" + bookTitle + "')]]");
    assertTrue(trueEndings);   
   
  }
}

package com.salesmanager.cucumber.alo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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

/*import static org.junit.Assert.assertEquals;
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
import org.openqa.selenium.remote.RemoteWebDriver;*/

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class PlaceOrderSteps {
  
//  FindAndAddToCartSteps faatc;
  RemoteWebDriver driver;
  String baseUrl;
  
  
  @Before("@selenium_5")
  public void setup() throws Throwable {
   DesiredCapabilities capability = DesiredCapabilities.firefox();
   capability.setBrowserName("firefox");
   driver = new RemoteWebDriver( new URL("http://dockerselenium.azurewebsites.net/wd/hub"), capability);
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   driver.manage().window().setSize(new Dimension(1920,1080));
   baseUrl = "http://jenkins2017.westeurope.cloudapp.azure.com:8080";
   System.out.println("before PlaceOrder");
 }
/*     @Before("@selenium_5")
  public void getDriver() {
    if (driver == null) {
      System.setProperty("webdriver.gecko.driver", "C:\\programmes\\iNet\\geckodriver\\geckodriver.exe");
      System.setProperty("webdriver.firefox.bin", "C:\\programmes\\iNet\\moz\\firefox.exe");
      driver = new FirefoxDriver();
      System.out.println("got a driver....");
    }
  }*/
  
  @Given("^i have item \"([^\"]*)\" in cart$")
  public void i_have_item_in_cart(String bookTitle) throws Throwable {
/*    faatc.customer_is_on_main_page();
    faatc.goes_to_product_page(bookTitle);
    faatc.adds_item_to_cart();
    faatc.product_is_added_to_cart(bookTitle);*/
    driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
    
    WebElement book = driver.findElement(By.xpath("//*[contains(@src,'" + bookTitle + "')]"));
    try {
      Thread.sleep(2000);      
    } catch (InterruptedException ie) {
      ie.printStackTrace();
    }
    book.click();
    System.out.println("book clicked");
    try {
      Thread.sleep(2000);      
    } catch (InterruptedException ie) {
      ie.printStackTrace();
    }
    System.out.println("on page: " + driver.getTitle());
    
    try {    
      Thread.sleep(2000);
    } catch (InterruptedException ie) {
      ie.getMessage();
    }
    WebElement addToCart = driver.findElement(By.className("addToCartButton"));
    addToCart.click();   
    System.out.println("added to cart");
    try {    
      Thread.sleep(1000);
    } catch (InterruptedException ie) {
      ie.getMessage();
    }
    WebElement dropBtn = driver.findElement(By.id("open-cart"));
    assertFalse("SHOPPING CART (0)".equals(dropBtn.getText()));
    System.out.println("Cart not empty");
    
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("scroll(0, -250);");
    WebElement dropBtn2 = driver.findElement(By.id("open-cart"));
    dropBtn2.click();
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

  @When("^i go to checkout with \"([^\"]*)\" copy of \"([^\"]*)\"$")
  public void i_go_to_checkout_with(int nrOfBooks, String bookTitle) throws Throwable {
    WebElement checkoutBtn = driver.findElement(By.className("btn-success"));
    checkoutBtn.click();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException ie){
      ie.getMessage();
    }    
    WebElement shopListImag = driver.findElement(By.xpath("//*[contains(@src,'"+ bookTitle + "')]"));
    assertNotNull(shopListImag.toString());
    WebElement bookCount = driver.findElement(By.className("quantity"));
    assertEquals(Integer.toString(nrOfBooks), bookCount.getAttribute("value"));
    System.out.println("book(s) in cart: " + bookCount.getAttribute("value"));  
  }

  @Then("^i can place the order$")
  public void i_can_place_the_order() throws Throwable {
    WebElement placeOrderBtn = driver.findElement(By.id("checkoutButton"));
    placeOrderBtn.click();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException ie){
      ie.getMessage();
    }
//    assertEquals("Place your order", driver.getTitle());
    String s = driver.getCurrentUrl();
    assertTrue(s.endsWith("checkout.html"));
  }



  
}

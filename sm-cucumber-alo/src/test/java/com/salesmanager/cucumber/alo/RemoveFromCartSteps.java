package com.salesmanager.cucumber.alo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RemoveFromCartSteps {
  
//  FindAndAddToCartSteps faatc;
//  PlaceOrderSteps pos;
  RemoteWebDriver driver;
  String baseUrl;

  
  @Before("@selenium_6")
  public void setup() throws Throwable {
   DesiredCapabilities capability = DesiredCapabilities.firefox();
   capability.setBrowserName("firefox");
   driver = new RemoteWebDriver( new URL("http://dockerselenium.azurewebsites.net/wd/hub"), capability);
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   driver.manage().window().setSize(new Dimension(1920,1080));
   baseUrl = "http://jenkins2017.westeurope.cloudapp.azure.com:8080";
   System.out.println("before RemoveFromCart");
 }
/*    @Before("@selenium_6")
  public void getDriver() {
    if (driver == null) {
      System.setProperty("webdriver.gecko.driver", "C:\\programmes\\iNet\\geckodriver\\geckodriver.exe");
      System.setProperty("webdriver.firefox.bin", "C:\\programmes\\iNet\\moz\\firefox.exe");
      driver = new FirefoxDriver();
      System.out.println("got a driver....");
    }
  }*/
  
  @Given("^i have two items in cart$")
  public void i_have_two_items_in_cart() throws Throwable {
/*    faatc.customer_is_on_main_page();
    faatc.goes_to_product_page("google");
    faatc.adds_item_to_cart();
    faatc.product_is_added_to_cart("google");
    faatc.adds_item_to_cart();
    faatc.product_is_added_to_cart("google");
    pos.i_go_to_checkout(2, "google");*/
    System.out.println("shopping");
    driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
    //assertEquals("Shopizer Demo - Default store", driver.getTitle());
    try {
      Thread.sleep(10000);      
    } catch (InterruptedException ie) {
      ie.printStackTrace();
    }
 //   WebElement book = driver.findElement(By.xpath("//*[contains(@src,'google')]"));
    String bookTitle = "spring";
    WebElement book = driver.findElement(By.xpath("//*[contains(@src,'" + bookTitle + "')]"));
    
    book.click();
    try {
      Thread.sleep(2000);      
    } catch (InterruptedException ie) {
      ie.printStackTrace();
    }
    System.out.println("on prod page");
    addingToCart("spring");
    addingToCart("spring");
    
    WebElement checkoutBtn = driver.findElement(By.className("btn-success"));
    checkoutBtn.click();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException ie){
      ie.getMessage();
    }    
    WebElement shopListImag = driver.findElement(By.xpath("//*[contains(@src,'google')]"));
    assertNotNull(shopListImag.toString());
    WebElement bookCount = driver.findElement(By.className("quantity"));
    System.out.println("book(s) in cart: " + bookCount.getAttribute("value"));
    assertEquals(2, Integer.parseInt(bookCount.getAttribute("value")));
  }
  public void addingToCart(String bookTitle) {
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
    System.out.println("book added");
    assertTrue(trueEndings);
  }
  
  
  @When("^i remove one of them$")
  public void i_remove_one_of_them() throws Throwable {
    WebElement quantity = driver.findElement(By.className("quantity"));
    String newNr = "1";
    quantity.clear();
    quantity.sendKeys(newNr);
//    assertEquals(1, quantity.getAttribute("value"));
    WebElement reCalc = driver.findElement(By.linkText("Recalculate"));
    reCalc.click();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException ie){
      ie.getMessage();
    }
    assertNotNull(reCalc);
  }

  @Then("^i have only one left$")
  public void i_have_only_one_left() throws Throwable {
    WebElement newPrice = driver.findElement(By.xpath(".//*[@id='mainCartTable']/tbody/tr[2]/td[3]/strong"));
    System.out.println("t: " + newPrice.getText());
    assertEquals("CAD39.99", newPrice.getText());
    /**
     * Do it!
     */
  }

}

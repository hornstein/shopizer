
package com.salesmanager.cucumber.alo;

import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class GotoHouseHomeSteps {
  

  RemoteWebDriver driver;
  String baseUrl;
  
   @Before("@selenium_4")
   public void setup() throws Throwable {
    DesiredCapabilities capability = DesiredCapabilities.firefox();
    capability.setBrowserName("firefox");
    driver = new RemoteWebDriver( new URL("http://dockerselenium.azurewebsites.net/wd/hub"), capability);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().setSize(new Dimension(1920,1080));
    baseUrl = "http://jenkins2017.westeurope.cloudapp.azure.com:8080";
    System.out.println("before gotoHouseHome");
  }
/*   @Before("@selenium_4")
   public void getDriver() {
     if (driver == null) {
       System.setProperty("webdriver.gecko.driver", "C:\\programmes\\iNet\\geckodriver\\geckodriver.exe");
       System.setProperty("webdriver.firefox.bin", "C:\\programmes\\iNet\\moz\\firefox.exe");
       driver = new FirefoxDriver();
       System.out.println("got a driver....");
     }
   }*/
  @Given("^i am on another page from home page$")
  public void i_am_on_another_page_from_home_page() throws Throwable {
    driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
    System.out.println("on shop page");
    assertEquals("Shopizer Demo - Default store", driver.getTitle());
    System.out.println("getTitle");
    WebElement book = driver.findElement(By.xpath("//*[contains(@src,'node')]"));
    book.click();    
    try {
      Thread.sleep(500);      
    } catch (InterruptedException ie) {
      ie.printStackTrace();
      //ie.getMessage();
    }
  }

  @When("^i click the house icon$")
  public void i_click_the_house_icon() throws Throwable {
    WebElement houseHome = driver.findElement(By.xpath(".//*[@id='shop']/div/div/div/div/ol/li[1]/a"));
    houseHome.click();
    try {
      Thread.sleep(2000);      
    } catch (InterruptedException ie) {
      ie.printStackTrace();
    }
  }

  @Then("^i get to home page$")
  public void i_get_to_home_page() throws Throwable {
    assertEquals("Shopizer Demo - Default store", driver.getTitle());
  }

}

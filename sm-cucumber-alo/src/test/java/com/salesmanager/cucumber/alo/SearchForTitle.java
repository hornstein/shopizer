package com.salesmanager.cucumber.alo;

import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class SearchForTitle {
  
  RemoteWebDriver driver;
  String baseUrl;
  
  String bookTitle;
  
  
  @Before("@selenium_7")
  public void setup() throws Throwable {
    DesiredCapabilities capability = DesiredCapabilities.firefox();
    capability.setBrowserName("firefox");
    driver = new RemoteWebDriver( new URL("http://dockerselenium.azurewebsites.net/wd/hub"), capability);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().setSize(new Dimension(1920,1080));
    baseUrl = "http://jenkins2017.westeurope.cloudapp.azure.com:8080";
  }
   
/*   @Before("@selenium_7")
   public void getDriver() {
     if (driver == null) {
       System.setProperty("webdriver.gecko.driver", "C:\\programmes\\iNet\\geckodriver\\geckodriver.exe");
       System.setProperty("webdriver.firefox.bin", "C:\\programmes\\iNet\\moz\\firefox.exe");
       driver = new FirefoxDriver();
       System.out.println("got a driver....");
     }
   }
   */
 
  @Given("^customer starts on main page$")
  public void customer_starts_on_main_page() throws Throwable {
    driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
    System.out.println("about to start search");
    assertEquals("Shopizer Demo - Default store", driver.getTitle());
  }

  @When("^customer enters \"([^\"]*)\" in search bar$")
  public void customer_enters_in_search_bar(String bookTitle) throws Throwable {
    driver.findElement(By.id("searchField")).sendKeys(bookTitle);
    driver.findElement(By.className("searchButton")).click();
    try {    
      Thread.sleep(2000);
    } catch (InterruptedException ie) {
      ie.getMessage();
    }

  }

  @Then("^product page \"([^\"]*)\" is shown$")
  public void product_page_is_shown(String bookTitle) throws Throwable {
    String s [] = bookTitle.split("\\s+");
    String dashed = "";
    for (String str : s) {
      dashed += str;
      dashed += "-";
    }
    dashed = dashed.substring(0, dashed.length() - 1);
    dashed += ".html";

    assertEquals("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/product/"  
        + dashed, driver.getCurrentUrl());

  }
}

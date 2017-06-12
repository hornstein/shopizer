package com.salesmanager.cucumber.alo;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class CreateNewLoginSteps {
  
  RemoteWebDriver driver;
  String baseUrl;
  FindAndAddToCartSteps faatc;
  GotoContactSteps gcs;
  
  
  @Before("@selenium_2") 
  public void setup() throws Throwable {
    DesiredCapabilities capability = DesiredCapabilities.firefox();
    capability.setBrowserName("firefox");
    driver = new RemoteWebDriver( new URL("http://dockerselenium.azurewebsites.net/wd/hub"), capability);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().setSize(new Dimension(1920,1080));
    baseUrl = "http://jenkins2017.westeurope.cloudapp.azure.com:8080";
    System.out.println("before CreateNewLogin");
  }

  @Given("^a user uses an unique id$")
  public void a_user_uses_an_unique_id() throws Throwable {
   // faatc.customer_is_on_main_page();
    driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
    assertEquals("Shopizer Demo - Default store", driver.getTitle());
  
    WebElement openView = driver.findElement(By.xpath(".//*[@id='customerAccount']/button"));
    openView.click();
    WebElement notYetReg = driver.findElement(By.xpath(".//*[@id='registerLink']"));
    notYetReg.click();
//    gcs.waitForElementByXPath(".//*[@id='firstName']");
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='firstName']")));
 
    
    WebElement fName = driver.findElement(By.xpath(".//*[@id='firstName']"));
    fName.sendKeys("Aaa");
    WebElement sName = driver.findElement(By.xpath(".//*[@id='lastName']"));
    sName.sendKeys("Bbb");
    WebElement gender = driver.findElement(By.id("gender"));
    gender.click();
    driver.findElement(By.xpath(".//*[@id='gender']/option[2]")).click();
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("scroll(0, 100);");
    driver.findElement(By.xpath(".//*[@id='hidden_zones']")).sendKeys("Västra Götaland");
    try {    
      Thread.sleep(2000);
    } catch (InterruptedException ie) {
      ie.getMessage();
    }
    driver.findElement(By.xpath(".//*[@id='userName']")).sendKeys(java.util.UUID.randomUUID().toString());
    driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("aloformat@gmail.com");
    driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("abcabc");
    driver.findElement(By.xpath(".//*[@id='passwordAgain']")).sendKeys("abcabc");
    driver.findElement(By.name("register")).click();
    try {    
      Thread.sleep(2000);
    } catch (InterruptedException ie) {
      ie.getMessage();
    }
  }

  @When("^user has a new account$")
  public void user_has_a_new_account() throws Throwable {
    driver.findElement(By.className("box-title")).click();

  }

  @Then("^user is taken to dash-board page$")
  public void user_is_taken_to_dash_board_page() throws Throwable {
    assertEquals("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/customer/dashboard.html", driver.getCurrentUrl());
    

  }


}

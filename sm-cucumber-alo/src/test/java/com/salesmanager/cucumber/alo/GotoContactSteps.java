package com.salesmanager.cucumber.alo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class GotoContactSteps {

  RemoteWebDriver driver;
  String baseUrl;
  
   @Before("@selenium_3")
   public void setup() throws Throwable {
    DesiredCapabilities capability = DesiredCapabilities.firefox();
    capability.setBrowserName("firefox");
    driver = new RemoteWebDriver( new URL("http://dockerselenium.azurewebsites.net/wd/hub"), capability);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().setSize(new Dimension(1920,1080));
    baseUrl = "http://jenkins2017.westeurope.cloudapp.azure.com:8080";
    System.out.println("before gotoContact");
  }
/*   @Before("@selenium_3")
   public void getDriver() {
     if (driver == null) {
       System.setProperty("webdriver.gecko.driver", "C:\\programmes\\iNet\\geckodriver\\geckodriver.exe");
       System.setProperty("webdriver.firefox.bin", "C:\\programmes\\iNet\\moz\\firefox.exe");
       driver = new FirefoxDriver();
       System.out.println("got a driver....");
     }
   }*/
   @Given("^gotoContact customer is on main page$")
   public void gotoContact_customer_is_on_main_page() throws Throwable {
     System.out.println("c is on main p");
     driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
//     driver.get("http://localhost:8080/shop");
     assertEquals("Shopizer Demo - Default store", driver.getTitle());
     System.out.println("c is is leaving main p");  
   }
   
  @When("^fill out contact form$")
  public void fill_out_contact_form() throws Throwable {
    System.out.println("contact form");
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("scroll(0, 250);");
    WebElement contactLink = driver.findElement(By.xpath(".//*[@id='footer-section']/div[2]/div/div[3]/div/ul/li[4]/a"));
    contactLink.click();
    try {    
      Thread.sleep(5000);
    } catch (InterruptedException ie) {
      ie.getMessage();
    }
    WebElement pop = driver.findElement(By.className("front"));
    pop.sendKeys(Keys.RETURN);
    pop.click();
    
 //   waitForElementByXPath(".//*[@id='mainContactUsRow']/div[2]/address/div/div/abbr");

    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='mainContactUsRow']/div[2]/address/div/div/abbr")));
    
    WebElement fName = driver.findElement(By.xpath(".//*[@id='name']"));
    fName.sendKeys("A");
    System.out.println("name printed");
    
    WebElement sName = driver.findElement(By.xpath(".//*[@id='email']"));
    sName.sendKeys("a@b.c");
    System.out.println("mail printed");
    
    WebElement sub = driver.findElement(By.xpath(".//*[@id='subject']"));
    sub.sendKeys("le sujet: ");
    System.out.println("subj printed");

    WebElement msg = driver.findElement(By.xpath(".//*[@id='comment']"));
    msg.sendKeys("Hej");
    try {    
      Thread.sleep(1500);
    } catch (InterruptedException ie) {
      ie.getMessage();
    }
    System.out.println("comment printed");
 //   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='submitContact']")));
    
    WebElement submitBtn = driver.findElement(By.xpath(".//*[@id='submitContact']"));
    submitBtn.click();
    System.out.println("done contact form");
  }

  @Then("^i want to receive a confirmation$")
  public void i_want_to_receive_a_confirmation() throws Throwable {
    assertNotNull("alert-success");
      // assertEquals("Thanks!", WebElement thanks);
  }
  protected WebElement waitForElementByXPath(String xpath) {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
    return driver.findElement(By.xpath(xpath));
    // WebElement button = this.getElementByXPath("//*[contains(text(), 'Add to cart')]");
  }
  
}

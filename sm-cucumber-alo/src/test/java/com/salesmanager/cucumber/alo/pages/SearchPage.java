package com.salesmanager.cucumber.alo.pages;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
  
  WebDriver driver;

  @Before
  public void setup() {
    System.setProperty("webdriver.gecko.driver", "C:\\programmes\\iNet\\geckodriver\\geckodriver.exe");
    System.setProperty("webdriver.firefox.bin", "C:\\programmes\\iNet\\moz\\firefox.exe");
    driver = new FirefoxDriver(); 
    driver.get("http://www.google.com");
  }

/*  @After
  public void tearDown() {
    driver.quit();
  }*/
  
  
  
  public void search(String search) {
    WebElement element = driver.findElement(By.name("q"));
    // Enter something to search for
    //element.sendKeys("Cheese!");
    element.sendKeys(search);
    // Now submit the form. WebDriver will find the form for us from the element
    element.submit();
  }
  
  public void verify(String result) {
    final String temp = result.toLowerCase();
    // Check the title of the page
    System.out.println("Page title is: " + driver.getTitle());
    
    // Google's search is rendered dynamically with JavaScript.
    // Wait for the page to load, timeout after 10 seconds
    new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver d) {
            return d.getTitle().toLowerCase().startsWith(temp);
        }
    });

    // Should see: "cheese! - Google Search"
    System.out.println("Page title is: " + driver.getTitle());
    assertEquals(result + " - Sök på Google", driver.getTitle()); 
  }
  

}

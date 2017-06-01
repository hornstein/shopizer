package com.salesmanager.cucumber.alo.pages;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParentPage {
  
  protected static WebDriver driver;
  
  protected WebElement waitForElementByXPath(String xpath) {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
    return driver.findElement(By.xpath(xpath));
    // WebElement button = this.getElementByXPath("//*[contains(text(), 'Add to cart')]");
  }
  
  @Before
  public static void setup() {
    if (driver == null) {
      System.setProperty("webdriver.gecko.driver", "C:\\programmes\\iNet\\geckodriver\\geckodriver.exe");
      System.setProperty("webdriver.firefox.bin", "C:\\programmes\\iNet\\moz\\firefox.exe");
      driver = new FirefoxDriver();
      System.out.println("Setup in ParentPage done........");
    }
  }
  @After
  public static void tearDown() {
    driver.quit();
  }
}

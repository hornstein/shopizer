package com.salesmanager.cucumber.alo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CheckoutPage extends ParentPage {
  
  public CheckoutPage() {
    super();
  }

  public void testVerifyBookIsAdded (String bookName) {
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("scroll(0, -250);");
    WebElement dropBtn = driver.findElement(By.id("open-cart"));
    dropBtn.click();
    try {
      Thread.sleep(500);
    } catch (InterruptedException ie){
      ie.getMessage();
    }
    WebElement shopListImage = driver.findElement(By.xpath("//*[@class='cart-product']//*[contains(@src,'" + bookName + "')]"));
    String s = shopListImage.toString();
    boolean trueEndings = s.endsWith("@src,'" + bookName + "')]]");
    assertTrue(trueEndings);   
   }
}

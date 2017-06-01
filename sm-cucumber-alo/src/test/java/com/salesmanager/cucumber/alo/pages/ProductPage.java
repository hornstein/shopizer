package com.salesmanager.cucumber.alo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class ProductPage extends ParentPage{

  public ProductPage() {
    super();
  }
  
  public void testAddToCart() {
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
//    System.out.println("db: " + dropBtn.getText());
    assertFalse("SHOPPING CART (0)".equals(dropBtn.getText()));
    System.out.println("Cart not empty");

    
/*    WebElement addToCart = driver.findElement(By.className("addToCartButton"));
    addToCart.click();*/
//    assertEquals("Spring in action", driver.getTitle());
//    JavascriptExecutor jse = (JavascriptExecutor)driver;
//    jse.executeScript("scroll(0, -250);");

/*    Thread.sleep(2000);

    WebElement dropBtn = driver.findElement(By.id("open-cart"));
    dropBtn.click();

    Thread.sleep(1000);
    
    WebElement shopList = driver.findElement(By.className("cart-product"));
//    System.out.println(shopList.getText());

    Thread.sleep(1000);
    WebElement shopListImage = driver.findElement(By.xpath(".//*[@id='1']/td[1]/img"));*/
//    WebElement shopImage = driver.findElement(By.xpath("//*[@class='cart-product']//*[contains(@src,'spring')]"));
/*    System.out.println("t: " + shopImage.getText());
    System.out.println("tagN: " + shopImage.getTagName()); 
    System.out.println("toS: " + shopImage.toString());
    System.out.println("c: " + shopImage.getClass());
    assertNotNull(shopListImage);
 */   
  }
  
  public void addToCart2() {
    WebElement button = driver.findElement(By.xpath("//*[containts(text(), 'Add to cart')]"));
    button.click();
  }
}

package com.salesmanager.cucumber.alo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.salesmanager.cucumber.alo.pages.ParentPage;

import static org.junit.Assert.*;

public class ReviewOrder extends ParentPage {
  
  public ReviewOrder() {
    super();
  }
  
  public void testFormControlRemove(String onePrice, String newNr) {
    WebElement quantity = driver.findElement(By.className("quantity"));
    quantity.clear();
    quantity.sendKeys(newNr);
  //  quantity.submit();
    assertEquals(newNr, quantity.getAttribute("value"));
    WebElement reCalc = driver.findElement(By.linkText("Recalculate"));
    reCalc.click();
    assertNotNull(reCalc);
    WebElement newPrice = driver.findElement(By.xpath(".//*[@id='mainCartTable']/tbody/tr[3]/td[3]/strong"));
    System.out.println(newPrice.getAttribute("value"));
    System.out.println(newPrice.toString());
    System.out.println(newPrice.getText());
    //assertEquals(onePrice, newPrice.getAttribute("value"));
  }
  
  public void testGotoCheckoutWithBooks(String nrOfBooks, String bookName) {
    WebElement checkoutBtn = driver.findElement(By.className("btn-success"));
    checkoutBtn.click();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException ie){
      ie.getMessage();
    }
  /*  WebElement headerX = driver.findElement(By.className("cart-title"));
    System.out.println("headerX toS: " + headerX.toString());  
    WebElement header = driver.findElement(By.xpath(".//*[@id='main-content']/div/h1"));
    System.out.println("header toS: " + header.toString());*/
  //  assertEquals("Review your order", header);
    
    WebElement shopListImag = driver.findElement(By.xpath("//*[contains(@src,'"+ bookName + "')]"));
    /*WebElement shopListImage = driver.findElement(By.xpath(".//*[@id='mainCartTable']/tbody/tr[1]/td[1]/div/div[1]/img"));
    //WebElement shopListImg = driver.findElement(By.xpath("//*[@class='cart-product']//*[contains(@src,'spring')]"));*/
    /*System.out.println("shopListImag, gT: " + shopListImag.getText());
    System.out.println("shopListImag, gTn: " + shopListImag.getTagName());
    System.out.println("shopListImag, tS: " + shopListImag.toString());
    System.out.println("shopListImag, gc: " + shopListImag.getClass());*/
    assertNotNull(shopListImag.toString());
    
  //  WebElement  = driver.findElement(By.xpath(".//*[@id='mainCartTable']/tbody/tr[1]/td[2]"));
    WebElement bookCount = driver.findElement(By.className("quantity"));
    assertEquals(nrOfBooks, bookCount.getAttribute("value"));
    System.out.println("book(s) in cart: " + bookCount.getAttribute("value"));
  }
  
  public void testPlaceOrder() {
    WebElement placeOrderBtn = driver.findElement(By.id("checkoutButton"));
    /*System.out.println("pob gTa: " + placeOrderBtn.getTagName());
    System.out.println("pob gTX: " + placeOrderBtn.getText());
    System.out.println("pob tS: " + placeOrderBtn.toString());*/
    placeOrderBtn.click();
    assertEquals("Place your order", driver.getTitle());
    assertNotNull(driver.findElement(By.id("thank you")));
  }
  

/*  System.out.println("shopListImage: " + shopListImage.getText());
  System.out.println(shopListImage.getTagName());
  System.out.println(shopListImage.toString());
  System.out.println(shopListImage.getClass());

  System.out.println("shopListImg: " + shopListImg.getText());
  System.out.println(shopListImg.getTagName());
  System.out.println(shopListImg.toString());
  System.out.println(shopListImg.getClass());*/
  
}



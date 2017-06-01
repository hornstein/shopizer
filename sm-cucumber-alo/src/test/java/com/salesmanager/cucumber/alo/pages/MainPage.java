package com.salesmanager.cucumber.alo.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class MainPage extends ParentPage {
  
  public MainPage() {
    super();
//    skapa driver
  }
  
  public void testSearchField(String searchTxt) {
    driver.findElement(By.id("searchField")).sendKeys(searchTxt);
    driver.findElement(By.className("searchButton")).click();
    try {    
      Thread.sleep(2000);
    } catch (InterruptedException ie) {
      ie.getMessage();
    }
    assertEquals("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/product/Spring-in-Action.html", driver.getCurrentUrl());
  }
  
  public void testCreateUser() {
    WebElement openView = driver.findElement(By.xpath(".//*[@id='customerAccount']/button"));
    openView.click();
    WebElement notYetReg = driver.findElement(By.xpath(".//*[@id='registerLink']"));
    notYetReg.click();
    super.waitForElementByXPath(".//*[@id='firstName']");
    WebElement fName = driver.findElement(By.xpath(".//*[@id='firstName']"));
    fName.sendKeys("Aaa");
    WebElement sName = driver.findElement(By.xpath(".//*[@id='lastName']"));
    sName.sendKeys("Bbb");
    WebElement gender = driver.findElement(By.id("gender"));
    gender.click();
    driver.findElement(By.xpath(".//*[@id='gender']/option[2]")).click();
//    driver.findElement(By.xpath(".//*[@id='gender']/option[@value='F']")).submit();
    ////tagname[@attribute='value']
    //.//*[@id='gender']/option[2]
//    WebElement country = driver.findElement(By.xpath(".//*[@id='registration_country']"));
//    country.sendKeys("Oman");

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
    driver.findElement(By.className("box-title")).click();
    assertEquals("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/customer/dashboard.html", driver.getCurrentUrl());
  }
  
  
  public void testGotoContactPage() {
    JavascriptExecutor jse = (JavascriptExecutor) ParentPage.driver;
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
    super.waitForElementByXPath(".//*[@id='mainContactUsRow']/div[2]/address/div/div/abbr");
    WebElement fName = driver.findElement(By.xpath(".//*[@id='name']"));
    fName.sendKeys("A");
    WebElement sName = driver.findElement(By.xpath(".//*[@id='email']"));
    sName.sendKeys("a@b.c");
    WebElement sub = driver.findElement(By.xpath(".//*[@id='subject']"));
    sub.sendKeys("le sujet: ");
    WebElement msg = driver.findElement(By.xpath(".//*[@id='comment']"));
    msg.sendKeys("Hej");
    WebElement submitBtn = driver.findElement(By.xpath(".//*[@id='submitContact']"));
    submitBtn.click();
    // hur testar jag av det här
 }
  
  public void testGotoFirstPage() {
    driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
//    System.out.println("Shopizer Demo - Default store: " + driver.getTitle());
    assertEquals("Shopizer Demo - Default store", driver.getTitle());
  }
  
  public void testGotoHouseHome() {
//
    WebElement houseHome = driver.findElement(By.xpath(".//*[@id='shop']/div/div/div/div/ol/li[1]/a"));
    houseHome.click();
    try {
      Thread.sleep(2000);      
    } catch (InterruptedException ie) {
      ie.printStackTrace();
    }
    assertEquals("Shopizer Demo - Default store", driver.getTitle());
//    assertEquals("", driver.);
  }

  public void testGotoProductPage(String bookTitle) {
//    WebElement book = driver.findElement(By.className(bookTitle));
//    WebElement book = driver.findElement(By.xpath("//*[contains(@src,bookTitle)]"));
    WebElement book = driver.findElement(By.xpath("//*[contains(@src,'" + bookTitle+ "')]"));
    try {
      Thread.sleep(2000);      
    } catch (InterruptedException ie) {
      ie.printStackTrace();
      //ie.getMessage();
    }
    book.click();    
    try {
      Thread.sleep(2000);      
    } catch (InterruptedException ie) {
      ie.printStackTrace();
      //ie.getMessage();
    }
    System.out.println("MainPage executed: " + driver.getTitle());
  }
  
}

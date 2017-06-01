package com.salesmanager.cucumber.alo;

import com.salesmanager.cucumber.alo.pages.CheckoutPage;
import com.salesmanager.cucumber.alo.pages.MainPage;
import com.salesmanager.cucumber.alo.pages.ParentPage;
import com.salesmanager.cucumber.alo.pages.ProductPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopTest {

  ParentPage parentP;
  MainPage mainP = new MainPage();
  ProductPage prodP = new ProductPage();
  CheckoutPage checkP = new CheckoutPage();
  ReviewOrder revO = new ReviewOrder();
  // kör skapandet i metoderna nedan
  
  @Before
  public void setup2() { 
    System.out.println("In setup2");
    ParentPage.setup();  
  }
  @After
  public void shutDown() {
 //   ParentPage.tearDown();
  }
  
  /**
   * Söka efter titel
   */
  @Test
  public void testSearchFunction() {
    mainP.testGotoFirstPage();
    mainP.testSearchField("Spring in Action");
  }
  
  /**
   * Skapa ett konto på Shopizer
   */
  @Test
  public void testCreateLogin() {
    mainP.testGotoFirstPage();
    mainP.testCreateUser();
  }
  
  /**
   * Add two books to cart and then remove one, 
   * checking the recalculate funcion works (downwards)
   */
  @Test
  public void testRemoveFromCartRecalculate() {
    mainP.testGotoFirstPage();
    mainP.testGotoProductPage("google");
    prodP.testAddToCart();
    prodP.testAddToCart();
    checkP.testVerifyBookIsAdded("google");
    revO.testGotoCheckoutWithBooks("2", "google");
    revO.testFormControlRemove("CAD18.99", "1");
  }
  
  /**
   * Go to start page via house icon
   */
  @Test
  public void testGotoHouseHomePage() {
    mainP.testGotoFirstPage();
    mainP.testGotoProductPage("node");
    mainP.testGotoHouseHome();
  }
    
  /**
   * Contact the company 
   */
  @Test
  public void testGotoContactPage() {
    mainP.testGotoFirstPage();
    mainP.testGotoContactPage();
  }
  
  /**
   * En/ Flera bok/ böcker i korgen, lägg order
   */
  @Test
  public void testPlaceOrderSingleBook(){
    mainP.testGotoFirstPage();
    mainP.testGotoProductPage("spring");
    prodP.testAddToCart();
    checkP.testVerifyBookIsAdded("spring");
    revO.testGotoCheckoutWithBooks("1", "spring");
    revO.testPlaceOrder();
  }
  @Test
  public void testPlaceOrderMultipleBooks(){
    mainP.testGotoFirstPage();
    mainP.testGotoProductPage("spring");
    prodP.testAddToCart();
    prodP.testAddToCart();
    prodP.testAddToCart();
    checkP.testVerifyBookIsAdded("spring");
    revO.testGotoCheckoutWithBooks("3", "spring");
  }
  
  /**
   * Plocka boken 'spring in action', lägg i korg o bekräfta detta
   */
  @Test
  public void testFindAndAddToCart() {
    mainP.testGotoFirstPage();
    mainP.testGotoProductPage("spring");
    prodP.testAddToCart();
    checkP.testVerifyBookIsAdded("spring");
  }
  
  // ------------------------------
  
/*    JavascriptExecutor jse = (JavascriptExecutor) ParentPage.driver;
    jse.executeScript("scroll(0, -250);");
    WebElement dropBtn = ParentPage.driver.findElement(By.id("open-cart"));
    dropBtn.click();

    try {
      Thread.sleep(1000);
    } catch (InterruptedException ie){
      ie.getMessage();
    }

    CheckoutPage.verifyBookIsAdded("spring");*/
    
    
    
    
/*    WebElement shopListImage = ParentPage.driver.findElement(By.xpath("//*[@class='cart-product']//*[contains(@src,'spring')]"));
    String s = shopListImage.toString();
    boolean trueEndings = s.endsWith("@src,'spring')]]");
    assertTrue(trueEndings);*/
    
//  assertEquals("Spring in action", shopListImage.getText());
//    assertEquals("spring", ParentPage.driver.findElement(By.xpath("//*[@class='cart-product']//*[contains(@src,'spring')]")));
/*
 * java.lang.AssertionError: expected:<spring> but was:
 * <[[FirefoxDriver: firefox on ANY (0acd2237-39f2-4223-a7e7-0c85da5c1e8f)] -> 
 * xpath: //*[@class='cart-product']//*[contains(@src,'spring')]]>
 * 
 */
  
  //  CheckoutPage.verifyBookIsAdded("spring");
       
  
/*
  public void addToCart_2() {   
    WebElement button = driver.findElement(By.xpath("//*[containts(text(), 'Add to cart')]"));
    button.click();
  }*/
/*  @Before
  public void setup() {
    System.setProperty("webdriver.gecko.driver", "C:\\programmes\\iNet\\geckodriver\\geckodriver.exe");
    System.setProperty("webdriver.firefox.bin", "C:\\programmes\\iNet\\moz\\firefox.exe");
    driver = new FirefoxDriver(); 
    driver.get("http://www.google.com");
  }*/
/*  @Test
  public void addToCart() {

    driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
    WebElement book = driver.findElement(By.xpath("//*[contains(@src,'spring')]"));
    book.click();
  Thread.sleep(6000);
//    (new WebDriverWait(driver, 10)).until();
    
    WebElement addToCart = driver.findElement(By.className("addToCartButton"));
    addToCart.click();
//    assertEquals("Spring in action", driver.getTitle());
//    JavascriptExecutor jse = (JavascriptExecutor)driver;
//    jse.executeScript("scroll(0, -250);");

    Thread.sleep(2000);

    WebElement dropBtn = driver.findElement(By.id("open-cart"));
    dropBtn.click();

    Thread.sleep(1000);
    
    WebElement shopList = driver.findElement(By.className("cart-product"));
    System.out.println(shopList.getText());

    Thread.sleep(1000);
    WebElement shopListImage = driver.findElement(By.xpath(".//*[@id='1']/td[1]/img"));
//    WebElement shopImage = driver.findElement(By.xpath("//*[@class='cart-product']//*[contains(@src,'spring')]"));
//    System.out.println("t: " + shopImage.getText());
//    System.out.println("tagN: " + shopImage.getTagName()); 
//    System.out.println("toS: " + shopImage.toString());
//    System.out.println("c: " + shopImage.getClass());
    assertNotNull(shopListImage);
    
  }*/

}

package com.salesmanager.cucumberjp;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopizerTest {
	
	WebDriver driver;
	String google = "https://www.google.se/";
	static final String HOME_URL = "http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop";
	
	static final String GECKODRIVER_LOCATION = "C:"+"\\"+"Users"+"\\"+"jpierre560"+"\\"+"Documents"+
				"\\"+"Automatiserad Testning"+"\\"+"geckodriver-v0.16.1-win64"+"\\"+"geckodriver.exe";
	boolean logged_in = false;
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", GECKODRIVER_LOCATION);
		driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(HOME_URL);
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().equals("Shopizer Demo - Default store");
			}
		});
		
	}

	@After
	public void tearDown() throws Exception {
		logoutIfPossible();
		driver.quit();
	}
	
	public void logInToExistingAccount() throws Exception {
		String readyUsername = "jpAutomatiseradTestning";
		String readyPassword = "testPassword";
		
		WebElement signinButton = driver.findElement(By.xpath(".//*[@id='customerAccount']/button"));
		signinButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement usernameInput = driver.findElement(By.id("signin_userName"));
		wait.until(ExpectedConditions.visibilityOf(usernameInput));
		usernameInput.sendKeys(readyUsername);
		WebElement passwordInput = driver.findElement(By.id("signin_password"));
		passwordInput.sendKeys(readyPassword);
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
		Thread.sleep(6000);
		logged_in = true;
		driver.get(HOME_URL);
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().equals("Shopizer Demo - Default store");
			}
		});
	}
	
	public void logoutIfPossible() throws Exception{
		if(logged_in){
			driver.navigate().to(HOME_URL);
			WebElement signinButton = driver.findElement(By.xpath(".//*[@id='customerAccount']/button"));
			Actions action = new Actions(driver);
			action.moveToElement(signinButton);
			signinButton.click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement logoutButton = driver.findElement(By.xpath(".//*[@id='customerAccount']/ul/li[2]/a"));
			wait.until(ExpectedConditions.visibilityOf(logoutButton));
			logoutButton.click();
			Thread.sleep(5000);
		}

	}
	
	public interface RiskyTests{
		
	}
	
	@Test
	public void findHome(){
		driver.findElement(By.linkText("Home")).click();
		assertEquals(driver.getTitle(), "Shopizer Demo - Default store");
	}
	 
	 @Category(RiskyTests.class)
	 @Test
	 public void cartOrderCorrectSum(){
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 
		 WebElement theBigSwitchStart = driver.findElement(By.xpath(".//img[contains(@src, 'google.jpg')]"));
		 Actions action = new Actions(driver);
		 action.moveToElement(theBigSwitchStart).perform();
		 try{
			 Thread.sleep(3000);
		 }catch  (Exception e){
			 System.out.println("Trouble sleeping");
		 }
		 WebElement theBigSwitchAddToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/a[2]")));
		 theBigSwitchAddToCart.click();
		 
		 jse.executeScript("scrollBy(0,0)");
		 WebElement openCartButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("open-cart"))));
		 try{
			 Thread.sleep(3000);
		 }catch  (Exception e){
			 System.out.println("Trouble sleeping");
		 }
		 action.moveToElement(openCartButton).build().perform();
		 openCartButton.click();
		 try{
			 Thread.sleep(3000);
		 }catch  (Exception e){
			 System.out.println("Trouble sleeping");
		 }
		 WebElement goToCheckout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Checkout")));
		 action.moveToElement(goToCheckout).build().perform();
		 goToCheckout.click();
		 (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d){
				return d.getTitle().equals("Place your order");
			}
		 });
		 try{
			 Thread.sleep(3000);
		 }catch  (Exception e){
			 System.out.println("Trouble sleeping");
		 }
		 //perBookPrice krånglar ibland
		 WebElement perBookPrice = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@data-th='Price']"))));
		 String priceOfBook = perBookPrice.getText();
		 
		 assertEquals(priceOfBook, "CAD18.99"); //Verifierar att boken som kommer användas kostar 18.99
		 
		 WebElement enterQuantity = driver.findElement(By.name("quantity"));
		 enterQuantity.click();
		 enterQuantity.clear();
		 enterQuantity.sendKeys("3");
		 
		 String intendedSum = "CAD56.97";
		 WebElement recalculateButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Recalculate"))));
		 recalculateButton.click();
		 
		 wait.until(ExpectedConditions.textToBe(By.xpath(".//*[@id='mainCartTable']/tbody/tr[1]/td[4]/strong"), intendedSum));
		 WebElement checkoutTotalAfterRecal = driver.findElement(By.xpath(".//*[@id='mainCartTable']/tbody/tr[1]/td[4]/strong"));
		 String calculatedSum = checkoutTotalAfterRecal.getText();

		 assertEquals(calculatedSum, intendedSum);
	 }
	 
	 @Test
	 public void removeBookFromCartStartpage() {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 
		 WebElement startpageNodeWebDev = driver.findElement(By.xpath(".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[3]/div/div[2]/div/div[1]"));
		 Actions action = new Actions(driver);
		 action.moveToElement(startpageNodeWebDev).build().perform();
		 WebElement nodeWebDevAddToCart = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[3]/div/div[2]/div/div[2]/a[2]"))));
		 nodeWebDevAddToCart.click();
		 try{
			 Thread.sleep(4000);
		 }catch (Exception e){
			 System.out.println("Sleep problem");
		 }
		 /*
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("scrollBy(0,0)");
		 */
		 WebElement openCart = driver.findElement(By.id("open-cart"));
		 wait.until(ExpectedConditions.elementToBeClickable(openCart));
		 action.moveToElement(openCart).build().perform();
		 openCart.click();
		 
		 List<WebElement> cartProduct = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.tagName("td"))));
		 assertTrue(cartProduct.get(1).getText().toLowerCase().contains("node web development"));
		 
		 //Första tryckningen på X
		 WebElement removeFromCart = cartProduct.get(3);
		 wait.until(ExpectedConditions.visibilityOf(removeFromCart));
		 removeFromCart.click();
		 
		//Andra tryckningen på X
		 wait.until(ExpectedConditions.elementToBeClickable(openCart));
		 action.moveToElement(openCart).build().perform();
		 openCart.click();
		 cartProduct = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.tagName("td"))));
		 removeFromCart = cartProduct.get(3);
		 wait.until(ExpectedConditions.visibilityOf(removeFromCart));
		 removeFromCart.click();
		 
		 //Kollar att det inte finns något i korgen
		 wait.until(ExpectedConditions.elementToBeClickable(openCart));
		 action.moveToElement(openCart).build().perform();
		 openCart.click();
		 WebElement emptyCart = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("miniCartDetails"))));
		 assertTrue(emptyCart.getText().toLowerCase().equals("no items in your shopping cart"));
	 }
	 
	 @Test
	 public void removeBookFromCartCheckout(){
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 WebElement theBigSwitchStart = driver.findElement(By.xpath(".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[1]/div/div[1]/a/img"));
		 Actions action = new Actions(driver);
		 action.moveToElement(theBigSwitchStart).build().perform();
		 WebElement theBigSwitchAddToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[1]/div/div[2]/div/div[2]/a[2]"))); //driver.findElement(By.xpath(".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[1]/div/div[2]/div/div[2]/a[2]"));
		 theBigSwitchAddToCart.click();
		 try{
			 Thread.sleep(4000);
		 }catch (Exception e){
			 System.out.println("Sleep problem");
		 }
		 /*
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("scrollBy(0,0)");
		 */
		 WebElement openCartButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("open-cart"))));
		 action.moveToElement(openCartButton).build().perform();
//		 try{
		 WebElement miniCartDisplay = driver.findElement(By.id("miniCartDetails"));
		 openCartButton.click();
		 wait.until(ExpectedConditions.visibilityOf(miniCartDisplay));
		 action.moveToElement(miniCartDisplay);
//		 }catch (TimeoutException te){
//			 for(int i = 0; i<100; i++){
//				 WebDriverWait shorterWait = new WebDriverWait(driver, 3);
//				 action.moveToElement(openCartButton);
//				 openCartButton.click();
//				 try{
//					 Thread.sleep(2000);
//				 }catch (Exception e){
//					 System.out.println("Sleep problem");
//				 }
//				 WebElement miniCartDisplay = driver.findElement(By.id("miniCartDetails"));
//				 shorterWait.until(ExpectedConditions.visibilityOf(miniCartDisplay));
//				 action.moveToElement(miniCartDisplay);
//			 }
//		 }
//		 try{
		 	 try{
		 		 Thread.sleep(3000);
		 	 }catch (Exception e){
		 		 System.out.println("Sleep problem");
		 	 }
			 WebElement goToCheckout =  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Checkout"))));
			 action.moveToElement(goToCheckout).build().perform();
			 goToCheckout.click(); 
//		 }catch (TimeoutException te){
//			 for(int i = 0; i<100; i++){
//				 WebDriverWait shorterWait = new WebDriverWait(driver, 3);
//				 action.moveToElement(openCartButton);
//				 openCartButton.click();
//				 WebElement miniCartDisplay = driver.findElement(By.id("miniCartDetails"));
//				 shorterWait.until(ExpectedConditions.visibilityOf(miniCartDisplay));
//				 action.moveToElement(miniCartDisplay);
//				 WebElement goToCheckout =  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Checkout"))));
//				 action.moveToElement(goToCheckout).build().perform();
//				 goToCheckout.click();  
//			 }
//		 }
		 (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d){
				return d.getTitle().equals("Place your order");
			}
		 });
		 
		 WebElement removeInCheckout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='mainCartTable']/tbody/tr[1]/td[5]/button")));
		 removeInCheckout.click();
		 (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d){
					return d.getCurrentUrl().endsWith("/shop/cart/removeShoppingCartItem.html");
					//Webbsidan når inte längre
				}
			 });
		 driver.navigate().to(HOME_URL);
		 
		 //Här fick jag initialisera vissa element på startsidan på nytt pga att
		 //försök att använda samma variabler igen resulterade i StaleElementReferenceExceptions
		 WebElement newOpenCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("open-cart")));
		 assertEquals(newOpenCartButton.getText().toLowerCase(), "shopping cart (0)");
		 newOpenCartButton.click();
		 WebElement newCartDisplay = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("miniCartDetails"))));
		 wait.until(ExpectedConditions.visibilityOf(newCartDisplay));
		 assertEquals(newCartDisplay.getText().toLowerCase(), "no items in your shopping cart");
		 
	 }
	 
	 @Category(RiskyTests.class)
	 @Test
	 public void writeReviewForBook() throws Exception{
		 logInToExistingAccount();
		 WebElement theBigSwitchStart = driver.findElement(By.xpath(".//img[contains(@src, 'google.jpg')]"));
		 Actions action = new Actions(driver);
		 action.moveToElement(theBigSwitchStart).build().perform();
		 try{
			 Thread.sleep(3000);
		 }catch  (Exception e){
			 System.out.println("Trouble sleeping");
		 }
		 
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 WebElement theBigSwitchDetails = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/a[1]"))));
		 theBigSwitchDetails.click();
		 (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return d.getCurrentUrl().endsWith("shop/product/the-big-switch.html");
				}
			});
		 
		 List<WebElement> bookPageTabs;
		 int doWhileCounter = 0;
		 do{
			 bookPageTabs = driver.findElements(By.xpath(".//*[@id='shop']/section/div/div/aside/div/div/div/ul/li/a[@role='tab']"));
			 doWhileCounter++;
		 }while((bookPageTabs.size()<1) && (doWhileCounter<20));
		 bookPageTabs.get(2).click();
		 WebElement writeReviewButton = driver.findElement(By.id("reviewButton"));
		 wait.until(ExpectedConditions.elementToBeClickable(writeReviewButton));
		 writeReviewButton.click();
		 (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return d.getCurrentUrl().contains("/shop/customer/review");
				}
			});
		 try{
			 Thread.sleep(3000);
		 }catch (Exception e){
			 System.out.println("Sleep problem");
		 }
		 WebElement descriptionBox = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("description"))));

		 descriptionBox.click();
		 descriptionBox.sendKeys("This book is good");
		 
		 WebElement fourStarRating = driver.findElement(By.xpath(".//*[@id='rateMe']/img[4]"));
		 fourStarRating.click();
		 
		 WebElement submitButton = driver.findElement(By.xpath(".//*[@id='review']/button"));
		 submitButton.click();
		 
		 String submitResultUrl = "http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/customer/review/submit.html";
		 (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return d.getCurrentUrl().endsWith("shop/customer/review/submit.html");
				}
			});
		 assertEquals(submitResultUrl, driver.getCurrentUrl());
	 }
	 
	 @Test
	 public void chooseBookFromCategory(){
		 WebElement computerBooksStart = driver.findElement(By.linkText("Computer Books"));
		 Actions action = new Actions(driver);
		 action.moveToElement(computerBooksStart).build().perform();
		 WebElement webBooks = driver.findElement(By.linkText("Web"));
		 webBooks.click();
		 
		 (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				WebElement bookCategory = driver.findElement(By.xpath(".//*[@id='mainContent']/header/div[1]/div/h2"));
				return bookCategory.getText().equals("Web");
			}
		 });
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.elementToBeClickable(By.className("product-img")));
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("scrollBy(0,80)");
		
		 List<WebElement> images = driver.findElements(By.className("product-img"));
		 WebElement springBookInCategory = images.get(1);
		 action.moveToElement(springBookInCategory).build().perform();
		 WebElement springDetails = driver.findElement(By.xpath(".//*[contains(@href,'Spring')]"));
		 springDetails.click();
		 (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return d.getCurrentUrl().contains("shop/product/Spring-in-Action.html");
				}
			 });
		 assertEquals("Spring in Action",driver.getTitle());
	 }

	 @Test
	 public void loginTest() throws Exception{
		 logInToExistingAccount();
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 WebElement loginTab = driver.findElement(By.xpath(".//*[@id='customerAccount']/button"));
		 Actions action = new Actions(driver);
		 action.moveToElement(loginTab).build().perform();
		 loginTab.click();
		 
		 WebElement myAccountButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='customerAccount']/ul/li[1]/a")));
		 wait.until(ExpectedConditions.elementToBeClickable(myAccountButton));
		 myAccountButton.click();
		 (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d){
					return d.getCurrentUrl().endsWith("/shop/customer/dashboard.html");
				}
			 });
		 
		 assertEquals(driver.getCurrentUrl(), "http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/customer/dashboard.html");
	 }
	 
	 @Test
	 public void incorrectLogin(){
		 String readyUsername = "jpAutomatiseradTestning";
		 
		 WebElement signinButton = driver.findElement(By.xpath(".//*[@id='customerAccount']/button"));
		 signinButton.click();
		 
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 WebElement usernameInput = driver.findElement(By.id("signin_userName"));
		 wait.until(ExpectedConditions.visibilityOf(usernameInput));
		 usernameInput.sendKeys(readyUsername);
		 
		 WebElement passwordInput = driver.findElement(By.id("signin_password"));
		 passwordInput.sendKeys("Wrong");
		 
		 WebElement loginButton = driver.findElement(By.id("login-button"));
		 Actions action = new Actions(driver);
		 action.moveToElement(loginButton);
		 loginButton.click();
		
		 WebElement errorWindow = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("loginError"))));
		 assertTrue(errorWindow.isDisplayed());
	 }
	 
	 @RunWith(Categories.class)
	 @IncludeCategory(RiskyTests.class)
	 @SuiteClasses({
		 ShopizerTest.class
	 })
	 public static class RunRiskyTests{
		 
	 }
}

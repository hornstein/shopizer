package com.salesmanager.cucumberjp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class TestSteps {
	
	WebDriver driver;
	Actions action;
	static final String HOME_URL = "http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop";
	
	//Ändra om du kör med Geckodriver
	static final String GECKODRIVER_LOCATION = "C:"+"\\"+"Users"+"\\"+"jpierre560"+"\\"+"Documents"+
				"\\"+"Automatiserad Testning"+"\\"+"geckodriver-v0.16.1-win64"+"\\"+"geckodriver.exe";
	boolean logged_in;
	String bookImageSrc;
	String bookTitle;
	double bookPrice;
	
	@Before
	public void setUp() throws Exception {

	  logged_in = false;
	//Mina inställningar; fungerade på min dator
//	System.setProperty("webdriver.gecko.driver", GECKODRIVER_LOCATION);
//	driver = new FirefoxDriver();
//	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	
	//Inställningarna som stod i RegisterCustomerSteps.java på ITHSDistans;
	//*Hörde under lektionen att vi skulle använda RemoteWebDriver, och det var de enda
	//RemoteWebDriver-värdena som jag kunde hitta
	DesiredCapabilities capability = DesiredCapabilities.firefox();
	capability.setBrowserName("firefox");
	driver = new RemoteWebDriver( new URL("http://dockerselenium.azurewebsites.net/wd/hub"), capability);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().setSize(new Dimension(1920,1080));
		
		action = new Actions(driver);
		bookImageSrc = "";
		bookTitle = "";
		bookPrice = 0.0;
	}
	
	@After
	public void tearDown() throws Exception {
		logoutIfPossible();
		driver.quit();
	}
	
	public void setBookImageSrc(String bookImageSrc){
		this.bookImageSrc = bookImageSrc;
	}
	
	public void setBookPrice(double bookPrice){
		this.bookPrice = bookPrice;
	}
	
	public double getListedValue(WebElement element){
		double price = 0.0;
		String listedPrice = element.getText();
		String parsedPrice = "";
		for(int i = 3; i < listedPrice.length(); i++){
			parsedPrice = parsedPrice + listedPrice.charAt(i);
		}
		price = Double.parseDouble(parsedPrice);
		return price;
	}
	
	public int getDivNr(String bookImageSrc){
		int divNr = 0;
		if(bookImageSrc.equals("spring")){
			divNr = 1;
		}
		else if(bookImageSrc.equals("google")){
			divNr = 2;
		}
		else if(bookImageSrc.equals("node")){
			divNr = 3;
		}
		return divNr;
	}
	
	public String getIntendedBookTitle(String bookImageSrc){
		String intendedBookTitle = "";
		if(bookImageSrc.equals("spring")){
			intendedBookTitle = "Spring in Action";
		}
		else if(bookImageSrc.equals("google")){
			intendedBookTitle = "The Big Switch";
		}
		else if(bookImageSrc.equals("node")){
			intendedBookTitle = "Node Web Development";
		}
		return intendedBookTitle;
	}
	
	public void logoutIfPossible() throws Exception{
		if(logged_in){
			driver.navigate().to(HOME_URL);
			WebElement signinButton = driver.findElement(By.xpath(".//*[@id='customerAccount']/button"));
			//Actions action = new Actions(driver);
			action.moveToElement(signinButton);
			signinButton.click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement logoutButton = driver.findElement(By.xpath(".//*[@id='customerAccount']/ul/li[2]/a"));
			wait.until(ExpectedConditions.visibilityOf(logoutButton));
			logoutButton.click();
			Thread.sleep(5000);
		}

	}
	
	@Given("^I have gone to the start page$")
  	public void goToStartpage() throws Throwable {
	  driver.get(HOME_URL);
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().equals("Shopizer Demo - Default store");
			}
		});
  }
  
	@Then("^I want to press the Details button$")
	public void goToBookPage() throws Throwable{
		
		if(driver.getCurrentUrl().contains("shop/category/")){
			List<WebElement> bookDetailsCategory = driver.findElements(By.xpath("//*[contains(text(), 'Details')]"));
			if(bookImageSrc.equals("spring")){
				(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(bookDetailsCategory.get(0)));
				bookDetailsCategory.get(0).click();
			}
			else if(bookImageSrc.equals("node")){
				(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(bookDetailsCategory.get(1)));
				bookDetailsCategory.get(1).click();
			}
		}
		else if (driver.getCurrentUrl().contains("/category/")==false){
			List<WebElement> bookDetailsStartpage = driver.findElements(By.xpath("//*[contains(text(), 'Details')]"));
			if(bookImageSrc.equals("spring")){
				(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(bookDetailsStartpage.get(0)));
				bookDetailsStartpage.get(0).click();
			}
			else if (bookImageSrc.equals("google")){
				(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(bookDetailsStartpage.get(1)));
				bookDetailsStartpage.get(1).click();
			}
			else if (bookImageSrc.equals("node")){
				(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(bookDetailsStartpage.get(2)));
				bookDetailsStartpage.get(2).click();
			}
		}
		else{
			WebElement bookDetails = driver.findElement(By.xpath(("//*[contains(text(), 'Details')]")));
			(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(bookDetails));
			 bookDetails.click();
		}
	}
  
	@Then("^I want to choose to open the review tab$")
	public void openReviewTab() throws Throwable{
		List<WebElement> bookPageTabs;
		int doWhileCounter = 0;
		 do{
			 bookPageTabs = driver.findElements(By.xpath(".//*[@id='shop']/section/div/div/aside/div/div/div/ul/li/a[@role='tab']"));
			 doWhileCounter++;
		 }while((bookPageTabs.size()<1) && (doWhileCounter<20));
		 bookPageTabs.get(2).click();
	}
  
	@Then("^I write a text review for the book$")
	public void writeReviewForBook() throws Throwable{
	  WebElement descriptionBox = driver.findElement(By.id("description"));
	  descriptionBox.click();
	  descriptionBox.sendKeys("This book is good");
  }
  
	@Then("^I want to verify that the review has been submitted$")
	public void verifyReviewSubmit() throws Throwable{
	  String submitResultUrl = "http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/customer/review/submit.html";
		 (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return d.getCurrentUrl().endsWith("shop/customer/review/submit.html");
				}
			});
		 assertEquals(submitResultUrl, driver.getCurrentUrl());
	}
  
	@Then("^I want to follow the Home link$")
	public void followHomeLink() throws Throwable{
	  driver.findElement(By.linkText("Home")).click();
	}
  
	@Then("^I choose a book with \"(.*)\" in the title at the start page$")
	public void chooseBookFromStartpage(String bookImageSrc) throws Throwable{
		setBookImageSrc(bookImageSrc);
		//((JavascriptExecutor) driver).executeScript("scroll(0,80);");
	  WebElement startpageBook = driver.findElement(By.xpath(".//img[contains(@src, '"+bookImageSrc+"')]"));
		 Actions action = new Actions(driver);
		 action.moveToElement(startpageBook).build().perform();
	}
  
	@Then("^I add the book to my cart$")
	public void addBookToCart() throws Throwable{
		Thread.sleep(1500);
		int divNr = getDivNr(bookImageSrc);
	  WebElement bookAddToCart = driver.findElement(By.xpath(".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div["+divNr+"]/div/div[2]/div/div[2]/a[2]"));
	  action.moveToElement(bookAddToCart).build().perform();
	  (new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(bookAddToCart));
		 bookAddToCart.click();
		 try{
			 Thread.sleep(4000);
		 }catch (Exception e){
			 System.out.println("Sleep problem");
		 }
	}
  
	@Then("^I open the cart tab$")
	public void openCartTab() throws Throwable{
	  WebElement openCartButton = driver.findElement(By.id("open-cart"));
		 action.moveToElement(openCartButton).build().perform();
		 openCartButton.click();
	}
  
	@Then("^I click the button to remove the book twice$")
	public void removeBookFromCartTab() throws Throwable{
		//Första tryckningen på X
		WebElement openCartButton = driver.findElement(By.id("open-cart"));
		List<WebElement> cartProduct = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.tagName("td"))));
		 WebElement removeFromCart = cartProduct.get(3);
		 (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOf(removeFromCart));
		 removeFromCart.click();
		 
		//Andra tryckningen på X
		 (new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(openCartButton));
		 action.moveToElement(openCartButton).build().perform();
		 openCartButton.click();
		 cartProduct = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.tagName("td"))));
		 removeFromCart = cartProduct.get(3);
		 (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOf(removeFromCart));
		 removeFromCart.click();
	}
  
	@Then("^I verify that the cart in the tab is empty$")
	public void verifyCartTabEmpty() throws Throwable{
	  driver.navigate().to(HOME_URL);
		 //Här fick jag initialisera vissa element på startsidan på nytt pga att
		 //försök att använda samma variabler igen resulterade i StaleElementReferenceExceptions
	  	String emptyCart = "shopping cart (0)";
		 WebElement newOpenCartButton = driver.findElement(By.id("open-cart"));
		 assertEquals(newOpenCartButton.getText().toLowerCase(), emptyCart);
		 newOpenCartButton.click();
		 WebElement newCartDisplay = driver.findElement(By.id("miniCartDetails"));
		 //wait.until(ExpectedConditions.visibilityOf(newCartDisplay));
		 assertEquals(newCartDisplay.getText().toLowerCase(), "no items in your shopping cart");
	}
  
	@Then("^I click the checkout button on the cart tab$")
	public void clickCheckoutOnCartTab() throws Throwable{
	  WebElement goToCheckout =  driver.findElement(By.linkText("Checkout"));
		 action.moveToElement(goToCheckout).build().perform();
		 goToCheckout.click(); 
	}
  
	@Then("^I click the button to remove the book from the cart in checkout$")
	public void clickRemoveButtonInCheckout() throws Throwable{
	  WebElement removeInCheckout = driver.findElement(By.xpath(".//*[@id='mainCartTable']/tbody/tr[1]/td[5]/button"));
		 removeInCheckout.click();
	}
  
	@Then("^I verify that I am taken to an error site about book removal$")
	public void verifyBookRemoveErrorPage() throws Throwable{
	  (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d){
				return d.getCurrentUrl().endsWith("/shop/cart/removeShoppingCartItem.html");
				//Webbsidan når inte längre
			}
		 });
	}
  
	@Then("^I verify that the price for one book is (\\d*\\.?\\d+)$")
	public void lookUpPriceForOneBook(double bookPrice) throws Throwable{
	  WebElement perBookPrice = driver.findElement(By.xpath(".//*[@data-th='Price']"));
		 String priceOfBook = perBookPrice.getText();
		 setBookPrice(bookPrice);
		 
		 assertEquals(priceOfBook, ("CAD" + bookPrice));
	}
  
  @Then("^I verify that the listed total price is the sum of the books in the cart$")
  public void verifyTotalPriceInCheckout() throws Throwable{
	  String intendedSum = "CAD"+(bookPrice*3);
	  (new WebDriverWait(driver, 10)).until(ExpectedConditions.textToBe(By.xpath(".//*[@id='mainCartTable']/tbody/tr[1]/td[4]/strong"), intendedSum));
		 WebElement checkoutTotalAfterRecal = driver.findElement(By.xpath(".//*[@id='mainCartTable']/tbody/tr[1]/td[4]/strong"));
		 String calculatedSum = checkoutTotalAfterRecal.getText();
		 assertEquals(calculatedSum, intendedSum);
  }
  
  @Then("^I go to the My Account page$")
  public void goToMyAccount() throws Throwable{
	WebElement loginTab = driver.findElement(By.xpath(".//*[@id='customerAccount']/button"));
	Actions action = new Actions(driver);
	action.moveToElement(loginTab).build().perform();
	loginTab.click();
		 
	WebElement myAccountButton = driver.findElement(By.xpath(".//*[@id='customerAccount']/ul/li[1]/a"));
	//wait.until(ExpectedConditions.elementToBeClickable(myAccountButton));
	myAccountButton.click();
  }

  @Then("^I verify that I am in the My Account page$")
  public void verifyMyAccountPage() throws Throwable{
	  Thread.sleep(3000);
	  assertEquals(driver.getCurrentUrl(), "http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/customer/dashboard.html");
  }

  @Then("^I open the login tab$")
  public void openLoginTab() throws Throwable{
	  WebElement signinButton = driver.findElement(By.xpath(".//*[@id='customerAccount']/button"));
	  action.moveToElement(signinButton).build().perform();
	  signinButton.click();
  }

  @Then("^I submit the login info$")
  public void submitLoginInfo() throws Throwable{
	  WebElement loginButton = driver.findElement(By.id("login-button"));
	  action.moveToElement(loginButton);
	  loginButton.click();
  }
  
  @Then("^I verify that an error message about the login appears$")
  public void verifyLoginErrorMessage() throws Throwable{
	  try{
		  Thread.sleep(2000);
	  }catch (Exception e){
		  System.out.println("Trouble sleeping");
	  }
	  WebElement errorWindow = driver.findElement(By.id("loginError"));
	  assertTrue(errorWindow.isDisplayed());
  }
  
  @Then("^I want to go to the Category page$")
  public void goToCategoryPage() throws Throwable{
	  WebElement computerBooksStart = driver.findElement(By.linkText("Computer Books"));
	  action.moveToElement(computerBooksStart).build().perform();
	  WebElement webBooks = driver.findElement(By.linkText("Web"));
	  webBooks.click();
  }
  
  @Then("^I enter a username and a wrong password$")
  public void enterLoginWithWrongPassword() throws Throwable{
	  String readyUsername = "jpAutomatiseradTestning";
	  WebElement usernameInput = driver.findElement(By.id("signin_userName"));
	  usernameInput.sendKeys(readyUsername);
	  WebElement passwordInput = driver.findElement(By.id("signin_password"));
	  passwordInput.sendKeys("Wrong");
  }
  
  @And("^I have logged in to an existing account$")
  public void logInToExistingAccount() throws Throwable{
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

  @And("^I verify that I have come to that books page$")
  public void verifyBookPage() throws Throwable{
	  Thread.sleep(5000);
	  String intendedTitle = getIntendedBookTitle(bookImageSrc);
	  //assertTrue(driver.getCurrentUrl().contains("/shop/product/"));
	  assertEquals(intendedTitle, driver.getTitle());
  }

  @And("^I choose to write a review about the book$")
  public void chooseToWriteReview() throws Throwable{
	  WebElement writeReviewButton = driver.findElement(By.id("reviewButton"));
		 (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(writeReviewButton));
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
  }

  @And("^I give the book a star rating$")
  public void giveStarRating() throws Throwable{
	  WebElement fourStarRating = driver.findElement(By.xpath(".//*[@id='rateMe']/img[4]"));
	  fourStarRating.click();
  }

  @And("^I increase the number of copies of that book in the cart$")
  public void increaseNumberOfBooksInCheckout() throws Throwable{
	  WebElement enterQuantity = driver.findElement(By.name("quantity"));
		 enterQuantity.click();
		 enterQuantity.clear();
		 enterQuantity.sendKeys("3");
  }
  
  @And("^I press the button for recalculating the price$")
  public void pressRecalculate() throws Throwable{
	  WebElement recalculateButton = driver.findElement(By.linkText("Recalculate"));
		 recalculateButton.click();
  }
  
  @And("^I want to verify that I reached the start page$")
  public void verifyReachStartPage() throws Throwable{
	  assertEquals(driver.getTitle(), "Shopizer Demo - Default store");
  }

  @When("^I choose a book at the start page$")
  public void chooseBookAtStartPage() throws Throwable{
	  WebElement theBigSwitchStart = driver.findElement(By.xpath(".//img[contains(@src, 'google.jpg')]"));
		 Actions action = new Actions(driver);
		 action.moveToElement(theBigSwitchStart).build().perform();
		 try{
			 Thread.sleep(3000);
		 }catch  (Exception e){
			 System.out.println("Trouble sleeping");
		 }
  }

  @When("^I submit the review$")
  public void submitReview() throws Throwable{
	  WebElement submitButton = driver.findElement(By.xpath(".//*[@id='review']/button"));
		 submitButton.click();
  }

  @When("^The cart tab is open$")
  public void theCartTabIsOpen() throws Throwable{
	  WebElement miniCartDisplay = driver.findElement(By.id("miniCartDetails"));
	  //wait.until(ExpectedConditions.visibilityOf(miniCartDisplay));
		 action.moveToElement(miniCartDisplay);
		 try{
	 		 Thread.sleep(3000);
	 	 }catch (Exception e){
	 		 System.out.println("Sleep problem");
	 	 }
  }

  @When("^I verify that I am on the checkout page$")
  public void verifyOnCheckoutPage() throws Throwable{
	  (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d){
				return d.getTitle().equals("Place your order");
			}
		 });
  }

  @When("^I choose a book whose title contains \"(.*)\" from the Category page$")
  public void chooseBookAtCategoryPage(String bookImageSrc) throws Throwable{
	  WebElement bookImage = driver.findElement(By.xpath(".//img[(@class='product-img') and (contains(@src, '"+bookImageSrc+"'))]"));
	  action.moveToElement(bookImage).build().perform(); //Ger WebDriverException: Failed to decode marionette
  }
}

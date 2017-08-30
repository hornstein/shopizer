package com.salesmanager.cucmber.jonas.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

//@DefaultUrl("http://bluebottle.westeurope.cloudapp.azure.com:8080")
@DefaultUrl("http://jenkins2017.westeurope.cloudapp.azure.com:8080")

public class Homepage extends PageObject{
	
	public void clickDefaultStore() {
		WebElement storeLink = getDriver().findElement(By.linkText("Default store")); 
		storeLink.click();
	}
	public void checkDefaultStorePage() throws InterruptedException{
		Thread.sleep(2000);
		assertEquals("Shopizer Demo - Default store", getDriver().getTitle()); 
		System.out.println(getDriver().getTitle());
		getDriver().close();
	}
	public void ClickOnBusiness(){
		
		WebDriverWait w = new WebDriverWait(getDriver(), 10);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='topMain']/li[2]/a/span")));
		
		WebElement businessLink = getDriver().findElement(By.xpath(".//*[@id='topMain']/li[2]/a/span"));
		businessLink.click();
	}
	public void checkBusinessPage(){
		WebDriverWait w = new WebDriverWait(getDriver(), 10);
		w.until(ExpectedConditions.elementToBeClickable(By.className("lead")));
		
		WebElement business2Link = getDriver().findElement(By.className("lead"));
		business2Link.getText();
		assertEquals("Business", business2Link.getText());
		System.out.println(business2Link.getText());
		
		getDriver().close();
	}
	public void checkContactUsPage(){
		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		jse.executeScript("scroll(0, 250);");
		
		WebDriverWait w = new WebDriverWait(getDriver(), 10);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='footer-section']/div[2]/div/div[3]/div/ul/li[4]/a")));
		
		WebElement contactLink = getDriver().findElement(By.xpath(".//*[@id='footer-section']/div[2]/div/div[3]/div/ul/li[4]/a"));
		contactLink.click();
	}
	public void failContactUsPage(){
		System.out.println("Geocode was not successful for the following reason: ZERO_RESULTS");
		getDriver().close();
	}
	public void signIn(){
		WebElement sign = getDriver().findElement(By.xpath(".//*[@id='customerAccount']/button"));
		sign.click();
	}
	public void passAndUserName(){
		WebElement usern = getDriver().findElement(By.id("signin_userName"));
		usern.sendKeys("Jonas");
		
		WebElement passw = getDriver().findElement(By.id("signin_password"));
		passw.sendKeys("12345");
	}
	public void logIn() throws InterruptedException{
		WebElement login = getDriver().findElement(By.xpath(".//*[@id='login-button']"));
		login.click();
		
		Thread.sleep(2000);
	}
	public void errorM(){
		WebElement error = getDriver().findElement(By.xpath(".//*[@id='loginError']"));
		assertEquals("Login Failed. Username or Password is incorrect.", error.getText());
		System.out.println(error.getText());
		
		getDriver().close();
	}
	public void sortby(){
		getDriver().get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/category/business.html/ref=c:6");
	}
	public void sb(){
		WebElement nm = getDriver().findElement(By.xpath("//*[@value='item-name']"));
		nm.click();
	}
	public void nm(){
		WebElement nm = getDriver().findElement(By.xpath("//*[@value='item-name']"));
		assertEquals("Name", nm.getText());
		getDriver().close();
	}
	public void atc(){
		//WebElement add = driver.findElement(By.xpath( ".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[3]/div/div[1]/a/img"));
		WebElement add = getDriver().findElement(By.xpath(".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[3]/div/div[1]/a/img"));
		add.click();
		
		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		jse.executeScript("scroll(0, 250);");
		
		WebDriverWait w = new WebDriverWait(getDriver(), 10);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='input-2']/div/button")));
		
		WebElement button = getDriver().findElement(By.xpath( ".//*[@id='input-2']/div/button"));
		button.click();
		System.out.println("Book Node Web Development has been added to shopping cart");
	}
	public void oc(){
		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		jse.executeScript("scroll(0, -250);");
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='open-cart']")));
		
		WebElement cart = getDriver().findElement(By.xpath(".//*[@id='open-cart']"));
		cart.click();
	}
	public void check(){
		WebElement book = getDriver().findElement(By.xpath(".//*[@id='2']/td[2]"));
		book.getText();
		assertEquals("1 Node Web Development", book.getText());
		
		getDriver().close();
	}
	public void addNwd(){
		WebElement add = getDriver().findElement(By.xpath(".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[3]/div/div[1]/a/img"));
		add.click();
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath( ".//*[@id='input-2']/div/button")));
		
		WebElement button = getDriver().findElement(By.xpath( ".//*[@id='input-2']/div/button"));
		button.click();
		System.out.println("Book Node Web Development has been added to shopping cart");
	}
	public void checkO(){
		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		jse.executeScript("scroll(0, -250);");
		
		WebDriverWait wai = new WebDriverWait(getDriver(), 10);
		wai.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='open-cart']")));
		
		WebElement cart = getDriver().findElement(By.xpath(".//*[@id='open-cart']"));
		cart.click();
		
		WebElement co = getDriver().findElement(By.xpath(".//*[@id='miniCartDetails']/li/div/a"));
		co.click();
		
		WebDriverWait wa = new WebDriverWait(getDriver(), 10);
		wa.until(ExpectedConditions.elementToBeClickable(By.className("cart-title")));
	}
	public void review(){
		WebElement rev = getDriver().findElement(By.className("cart-title"));
		rev.getText();
		assertEquals("Review your order", rev.getText());
		
		getDriver().close();
	}
	public void aAb(){
		WebElement add = getDriver().findElement(By.xpath(".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[3]/div/div[1]/a/img"));
		add.click();
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath( ".//*[@id='input-2']/div/button")));
		
		WebElement button = getDriver().findElement(By.xpath( ".//*[@id='input-2']/div/button"));
		button.click();
		System.out.println("Book Node Web Development has been added to shopping cart");
	}
	public void cart(){
		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		jse.executeScript("scroll(0, -250);");
		
		WebDriverWait wai = new WebDriverWait(getDriver(), 10);
		wai.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='open-cart']")));
		
		WebElement cart = getDriver().findElement(By.xpath(".//*[@id='open-cart']"));
		cart.click();
	}
	public void rm(){
		WebElement co = getDriver().findElement(By.xpath(".//*[@id='miniCartDetails']/li/div/a"));
		co.click();
		
		WebDriverWait w = new WebDriverWait(getDriver(), 10);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='mainCartTable']/tbody/tr[1]/td[5]/button")));
		
		WebElement r = getDriver().findElement(By.xpath(".//*[@id='mainCartTable']/tbody/tr[1]/td[5]/button"));
		r.click();
		
		WebDriverWait er = new WebDriverWait(getDriver(), 10);
		er.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='pageContainer']/table/tbody/tr[1]/td[2]/h3")));
	}
	public void erM(){
		WebElement error = getDriver().findElement(By.xpath(".//*[@id='pageContainer']/table/tbody/tr[1]/td[2]/h3"));
		error.getText();
		assertEquals("An error occurred in this request", error.getText());
		System.out.println(error.getText());
		
		getDriver().close();
	}
	public void nWd(){
		getDriver().get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/product/Node-Web-Development.html");
	}
	public void addNwD(){
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath( ".//*[@id='input-2']/div/button")));
		
		WebElement button = getDriver().findElement(By.xpath( ".//*[@id='input-2']/div/button"));
		button.click();
		System.out.println("Book Node Web Development has been added to shopping cart");
		
	}
	public void openC() throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		jse.executeScript("scroll(0, -250);");
		
		WebDriverWait er = new WebDriverWait(getDriver(), 20);
		er.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='open-cart']")));
		getDriver().findElement(By.xpath(".//*[@id='open-cart']")).click();
		
		//WebElement cart = driver.findElement(By.className("btn dropdown-toggle"));
		//cart.click();

			Thread.sleep(2500);
		
		WebDriverWait ww = new WebDriverWait(getDriver(), 20);
		ww.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='2']/td[4]/button")));
		
			Thread.sleep(2500);
		
		
		WebElement x = getDriver().findElement(By.xpath(".//*[@id='2']/td[4]/button"));
		x.click();
		
			Thread.sleep(2500);

		WebElement shop2 = getDriver().findElement(By.xpath(".//*[@id='open-cart']"));//Får göra det två gånger för att det ska fungera.
		shop2.click();
		
			Thread.sleep(2500);
		
		WebElement x2 = getDriver().findElement(By.xpath(".//*[@id='2']/td[4]/button"));//Får göra det två gånger för att det ska fungera.
		x2.click();
	}
	public void bookR() throws InterruptedException{
		Thread.sleep(2500);
		WebElement zero = getDriver().findElement(By.xpath(".//*[@id='miniCartSummary']"));
		zero.getText();
		assertEquals("SHOPPING CART (0)", zero.getText());
		
		System.out.println(zero.getText());
	}
}

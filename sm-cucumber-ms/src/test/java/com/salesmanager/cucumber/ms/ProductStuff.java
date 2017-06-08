package com.salesmanager.cucumber.ms;

import static org.junit.Assert.*;

/*
 * ProductStuff �r klassen som inneh�ller metoderna som anv�nds av TestProduct
 * 
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ProductStuff extends ParentPage{
	

	public static void goToProductPage(String bookName){
		WebElement book = driver.findElement(By.xpath("//*[contains(@src, '" + bookName + "')]"));
		MainStuff.explicitWaiVisibleXpath("//*[contains(@src, '" + bookName + "')]");
		book.click();
		MainStuff.explicitWaitTitle("The Big Switch");
		assertEquals("The Big Switch",driver.getTitle());
	}
	
	public static void addToCart(){
		WebElement button = driver.findElement(By.xpath("//*[contains(text(), 'Add to cart')]"));
		button.click();
	}
	
	public static void verifyBookInCart() throws InterruptedException{
		WebElement  el = driver.findElement(By.id("open-cart"));
	   MainStuff.scroll(js, el);
	   Thread.sleep(1000);
	   el.click();
	   String bookTitle = driver.findElement(By.xpath(".//*[@id='6']/td[2]")).getText();
	   assertEquals("1 The Big Switch", bookTitle);
	}
	
	public static void checkout() throws InterruptedException{
		Thread.sleep(1000);
		MainStuff.explicitWaitClickableXpath("//*[@href='#']");
		driver.findElement(By.xpath("//*[@href='#']")).click();
	}
	
	
	public static void placeOrder(){
		driver.findElement(By.xpath(".//*[@id='checkoutButton']")).click();
		MainStuff.explicitWaitUrl("checkout");
	    String url = "checkout"; 
		assertFalse(driver.getCurrentUrl().contains(url));
	}
	
	public static void search(){
		String bookTitle = MainStuff.getRandomTitle();
		driver.findElement(By.id("searchField")).sendKeys(bookTitle);
		driver.findElement(By.xpath(".//*[@id='header-top-second']/div/div[2]/button")).click();
		bookTitle = bookTitle.replaceAll(" ", "-");
		assertEquals("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/product/" +bookTitle+ ".htlm", driver.getCurrentUrl());
		
	}
	
	public static void remove(){
		driver.findElement(By.xpath("//*[@class='close removeProductIcon']")).click();
		driver.findElement(By.id("open-cart")).click();
		boolean displayed = driver.findElement(By.xpath("//*[@id='miniCartDetails']//*[contains(text(), 'No items in your shopping cart')]")).isDisplayed();
		assertEquals(displayed, true);
	}
	
	
	
}

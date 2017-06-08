/*
 * MainStuff klassen �r till f�r att hj�lpa andra klasser med de mest generella metoder som anv�ndas ofta.
 * random metoderna �r till f�r att generera en slumpm�ssig boktitle av dem olika b�cker som finns med p� shopizer.
 */

package com.salesmanager.cucumber.ms;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class MainStuff extends ParentPage{
	
	public static void goToTheHomePage(){
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop");
		assertEquals("Shopizer Demo - Default store",driver.getTitle());
	}
	public static void explicitWaitClickableXpath(String text){
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath(text)));	
		}
	public static void explicitWaiVisibleXpath(String xpath){
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));	
	   	
	}
	
	public static void explicitWaitTitle(String title){
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.titleContains(title));	
		}
	
	public static void explicitWaitUrl(String url){
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.urlContains(url));
	}
	
		public static void implicitWait(){
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		public static void scroll(JavascriptExecutor js, WebElement el){
			 js = (JavascriptExecutor) driver ;
			 js.executeScript("arguments[0].scrollIntoView(true);", el);
		 }
		
		public static String getRandomTitle(){
			int random = randomNumber();
			switch(random){
				case 1: 
					return "The Big Switch";
				case 2:
					return "Spring in Action";
				case 3:
					return "Node Web Development";
				case 4:
					return "Programming for PAAS";
				default:
					return "bla";
				}
		}
		
		public static int randomNumber(){
			Random rand = new Random();
			return rand.nextInt(4) + 1;
		}
	
	 
}

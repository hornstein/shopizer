package com.salesmanager.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://bluebottle.westeurope.cloudapp.azure.com:8080")
public class HomePage extends PageObject {

	public void clickOnSpringInAction() {
		
		WebElement button = getDriver().findElement(By.xpath("//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[2]/div/div[1]/a/img"));
		button.click();
	}

	public void clickOnAddToCart() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-6']/div/button")));
		element.click();
	}
	
	public void open_cart() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		JavascriptExecutor jse2 = (JavascriptExecutor)getDriver();
		jse2.executeScript("window.scrollBy(0, -500)", "");
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='open-cart']")));
		element.click();
	}
 
}

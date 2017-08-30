package com.salesmanager.cucumber.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;

public class Header  extends PageObject {

	public String readGreeting() {
		return getDriver().findElement(By.xpath("//*[@id='fat-menu']/a")).getText();
	}

	public void clickOnCart() {
		// TODO Auto-generated method stub
		WebElement book = getDriver().findElement(By.xpath((".//*[@id='open-cart']")));
		book.click();
		//WebElement cart = getDriver().findElement(By.id("miniCartDetails"));

	}
}

 

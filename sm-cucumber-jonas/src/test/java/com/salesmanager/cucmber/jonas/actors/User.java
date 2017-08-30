package com.salesmanager.cucmber.jonas.actors;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.salesmanager.cucmber.jonas.pages.Homepage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class User extends ScenarioSteps {

	Homepage homepage;
	@Step
	public void openHomePage() {
		homepage.open();
	}
	@Step
	public void clickDefaultStore() {
		homepage.clickDefaultStore();
	}
	@Step
	public void checkDefaultStorePage() throws InterruptedException {
		homepage.checkDefaultStorePage();
	}
	@Step
	public void ClickOnBusiness(){
		homepage.ClickOnBusiness();
	}
	@Step
	public void checkBusinessPage(){
		homepage.checkBusinessPage();
	}
	@Step
	public void checkContactUsPage(){
		homepage.checkContactUsPage();
	}
	@Step
	public void failContactUsPage(){
		homepage.failContactUsPage();
	}
	@Step
	public void signIn(){
		homepage.signIn();
	}
	@Step
	public void passAndUserName(){
		homepage.passAndUserName();
	}
	@Step
	public void logIn() throws InterruptedException{
		homepage.logIn();
	}
	@Step
	public void errorM(){
		homepage.errorM();
	}
	@Step
	public void sortby(){
		homepage.sortby();
	}
	@Step
	public void sb(){
		homepage.sb();
	}
	@Step
	public void nm(){
		homepage.nm();
	}
	@Step
	public void atc(){
		homepage.atc();
	}
	@Step
	public void oc(){
		homepage.oc();
	}
	@Step
	public void check(){
		homepage.check();
	}
	@Step
	public void addNwd(){
		homepage.addNwd();
	}
	@Step
	public void checkO(){
		homepage.checkO();
	}
	@Step
	public void review(){
		homepage.review();
	}
	@Step
	public void aAb(){
		homepage.aAb();
	}
	@Step
	public void cart(){
		homepage.cart();
	}
	@Step
	public void rm(){
		homepage.rm();
	}
	@Step
	public void erM(){
		homepage.erM();
	}
	@Step
	public void nWd(){
		homepage.nWd();
	}
	@Step
	public void addNwD(){
		homepage.addNwD();
	}
	@Step
	public void openC() throws InterruptedException{
		homepage.openC();
	}
	@Step
	public void bookR() throws InterruptedException{
		homepage.bookR();
	}
	
}	

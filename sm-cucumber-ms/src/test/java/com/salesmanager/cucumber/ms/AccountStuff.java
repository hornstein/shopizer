/*
 * Den h�r klassen inneh�ller alla metoder som anv�nds i TestAccount-klassen f�r att testa inloggning.
 * 
 */

package com.salesmanager.cucumber.ms;
import static org.junit.Assert.*; 
import org.openqa.selenium.By;

public class AccountStuff extends ParentPage{

	public static void validLogIn(String userName, String password){
		MainStuff.implicitWait();
		login(userName, password);
		String user = driver.findElement(By.xpath("//*[contains(text(), 'mohamed')]")).getText();
		assertEquals(user, "MOHAMED");
	}
	
	public static void checkAccount(){
		MainStuff.implicitWait();
		driver.findElement(By.xpath("//*[contains(text(), 'mohamed')]")).click();
		driver.findElement(By.xpath("//*[@id='customerAccount']//*[contains(text(), 'My Account')]")).click();
		String currentUrl = "http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/customer/dashboard.html";
		driver.findElement(By.xpath(".//*[@id='main-content']/div/div/div[1]/div/ul/li[1]/a")).click();
		assertNotEquals(currentUrl, driver.getCurrentUrl());
		
		
	}
	
	public static void logout() throws InterruptedException{
		driver.findElement(By.xpath("//*[contains(text(), 'mohamed')]")).click();
		driver.findElement(By.xpath("//*[@id='customerAccount']//*[contains(text(), 'Logout')]")).click();
		Thread.sleep(4000);
		String login = driver.findElement(By.xpath("//*[@id='customerAccount']/button")).getText();
		assertEquals(login, "SIGNIN");
	}
	
	public static void invalidLogIn(String falseUserName, String falsePassword){
		login(falseUserName, falsePassword);
		MainStuff.explicitWaiVisibleXpath("//*[@id='loginError']");
		String errormsg = driver.findElement(By.xpath("//*[@id='loginError']")).getText();
		assertEquals("Login Failed. Username or Password is incorrect.", errormsg);
	}
	
	public static void login(String userName, String password){
		//MainStuff.goToTheHomePage();
		MainStuff.explicitWaiVisibleXpath("//*[@id='customerAccount']/button");
		driver.findElement(By.xpath("//*[@id='customerAccount']/button")).click();
		driver.findElement(By.xpath("//*[@id='signin_userName']")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@id='signin_password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='login-button']")).click();
	}
}

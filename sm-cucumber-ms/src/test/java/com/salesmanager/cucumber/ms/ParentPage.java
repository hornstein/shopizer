package com.salesmanager.cucumber.ms;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class ParentPage {
 protected static WebDriver driver;
 protected static JavascriptExecutor js;

 public static void init(){
	 System.setProperty("webdriver.gecko.driver", "C:\\Users\\mohamed\\Documents\\gecko\\geckodriver.exe");
     driver = new FirefoxDriver();
     
 }
 
 public static void close(){
	 driver.quit();
 }
 }
 

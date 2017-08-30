package com.salesmanager.cucumber.ms;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
public class ParentPage {
 //protected static RemoteWebDriver driver;
 protected static WebDriver driver;
 protected static JavascriptExecutor js;

 public static void init() throws Throwable{
	/* System.setProperty("webdriver.gecko.driver", "C:\\Users\\mohamed\\Documents\\gecko\\geckodriver.exe");
     driver = new FirefoxDriver(); */
	DesiredCapabilities capability = DesiredCapabilities.firefox();
	capability.setBrowserName("chrome");
	driver = new RemoteWebDriver( new URL("http://dockerselenium.azurewebsites.net/wd/hub"), capability);
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
 }
 
 public static void close(){
	 driver.quit();
 }
 }
 

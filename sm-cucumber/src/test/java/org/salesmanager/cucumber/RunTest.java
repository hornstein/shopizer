package org.salesmanager.cucumber;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class) 
@CucumberOptions( 
    features = "src/test/java/org/salesmanager/cucumber" 
    ,glue={"classpath:"} 
    ) 
  
public class RunTest { 
  
}  
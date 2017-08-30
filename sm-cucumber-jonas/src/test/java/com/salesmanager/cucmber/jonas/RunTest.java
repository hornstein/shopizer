package com.salesmanager.cucmber.jonas;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;
//CucumberWithSerenity.class
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		//format = {"pretty", "html:target/cucumber.html"},
		features = "src/test/java/com/salesmanager/cucmber/jonas"
		,glue=("classpath:")
		)

public class RunTest {
	
}

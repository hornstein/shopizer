package com.salesmanager.cucumberjp;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/salesmanager/cucumberjp/"
		,glue={"classpath:"}
		)

public class RunShopizerTests {

}

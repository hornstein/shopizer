package com.salesmanager.cucumber.sk;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (features = "src/test/java/com/salesmanager/cucumber/sk"
	,glue={"classpath:"})
	//,tags={"@current"})		
public class TestRunner {

}
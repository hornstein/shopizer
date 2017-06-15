package com.salemanager.cucumberns;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/salemanager/cucumberns/"
		,glue={"classpath:"})
		//,tags={"@"})
 
public class RunTest {
 
}
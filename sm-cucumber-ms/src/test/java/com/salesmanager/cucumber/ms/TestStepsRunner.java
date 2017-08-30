package com.salesmanager.cucumber.ms;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/java/com/salesmanager/cucumber/ms/"
		,glue={"classpath:"}
		)
public class TestStepsRunner {

}

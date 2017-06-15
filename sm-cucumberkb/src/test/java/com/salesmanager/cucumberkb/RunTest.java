package com.salesmanager.cucumberkb;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/java/com/salesmanager/cucumberkb/"
,glue={"classpath:"}
)
public class RunTest {
}
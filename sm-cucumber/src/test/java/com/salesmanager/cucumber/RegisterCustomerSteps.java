package com.salesmanager.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertEquals;
import net.thucydides.core.annotations.Steps;
import com.salesmanager.cucumber.steps.BuyerSteps;

public class RegisterCustomerSteps {

    @Steps
    BuyerSteps user;

	@Given("^the user is logged out$")
	public void the_user_is_logged_out() throws Throwable {
		user.opens_home_page();
		user.logout();
	}

	@When("^the user register with \"(.*)\"$")
	public void the_user_register_with(String name) throws Throwable {
		user.register(name);
		user.submitRegistration();
	}

	@Then("^the user should receive a greeting with \"([^\"]*)\"$")
	public void the_user_should_receive_a_greeting_with(String name) throws Throwable {
		String username = user.read_greeting();
		assertEquals(username, "WELCOME " + name.toUpperCase());
	}	
}

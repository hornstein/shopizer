package com.salesmanager.cucumber.ms;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;

public class ManageAccountTestSteps extends ParentPage{
	
	@Before("@account")
	public void setup(){
		ParentPage.init();
	}
	
	@After("@account")
	public void exit(){
		ParentPage.close();
	}
 
  @When("^I enter \"(.*)\" as a username and \"(.*)\" as a password i should see the name on the top of the page$")
  public void enterValidUsernameAndPassword(String username, String password) {
	  AccountStuff.validLogIn(username, password);
      
  }

  @Then("^I should be able to check the useraccount$")
  public void checkTheUserAccount(){
	  AccountStuff.checkAccount();
  }

  @Then("^i click on the logout button$")
  public void and() throws Throwable {
	  AccountStuff.logout();
  }

}



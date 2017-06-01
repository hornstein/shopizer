package com.salesmanager.cucumber.ms;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;

public class TestSteps {
  @Given("^you are in Given annotation$")
  public void given() throws Throwable {
  }

  @When("^you are in When annotation$")
  public void when() throws Throwable {
  }

  @Then("^you are in Then annotation$")
  public void then() throws Throwable {
  }

  @And("^you are in And annotation$")
  public void and() throws Throwable {
  }

  @But("^you are in But annotation$")
  public void but() throws Throwable {
  }

}

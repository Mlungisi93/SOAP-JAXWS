package com.expleo.soap.StepDefs;

import com.expleo.soap.Steps.ListOfCountriesByISOCodeSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ListOfCountriesByISOCode {


    @Steps
    ListOfCountriesByISOCodeSteps steps;

    @Given("^I got the base url$")
    public void iGotTheBaseUrl()
    {
        steps.getToBaseURL();
    }

    @When("^I send request to get list of Countries$")
    public void iSendRequestToGetListOfCountries()
    {
        steps.getListOfCountries();
    }

    @Then("^i should get a list of Countries$")
    public void iShouldGetAListOfCountries()
    {
        steps.assertListHasCountries();
    }
}

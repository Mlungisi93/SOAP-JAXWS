package com.expleo.soap.StepDefs;

import com.expleo.soap.Steps.CountrySteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CountryStepDefs {


    String isoCode = "IYYY";
    String expectedCity = "New Delhi";

    @Steps
    CountrySteps countrySteps;

    @Given("^I launch the base WSDL$")
    public void iLaunchTheBaseWSDL()
    {
        countrySteps.getToBaseURL();
    }

    @When("^I send country isoCode$")
    public void iSendCountryIsoCode()
    {
        countrySteps.getCapitalCity(isoCode);
    }

    @Then("^I should get correct capital city$")
    public void iShouldGetCorrectCapitalCity()
    {
        countrySteps.report(countrySteps.assertCapitalCity(expectedCity));
    }
}

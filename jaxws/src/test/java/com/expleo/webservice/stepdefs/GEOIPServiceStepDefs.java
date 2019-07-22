package com.expleo.webservice.stepdefs;

import com.expleo.webservice.steps.GeoIPServiceSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GEOIPServiceStepDefs {

    @Steps
    GeoIPServiceSteps steps;
    @Given("^that online GEOIP service is running$")
    public void thatOnlineGEOIPServiceIsRunning() {

        steps.connectToGEOIPService();
    }

    @When("^I pass the ISO code$")
    public void iPassTheISOCode() {
        steps.passISOCode("ZA");
    }

    @Then("^It returns the country$")
    public void itReturnsTheCountry() {
        steps.assertCountry("SOUTH AFRICA");
    }


    @When("^I pass the IP address$")
    public void iPassTheIPAddress() {
        steps.passIPAddress("160.153.207.16");
    }

    @Then("^It returns the country code$")
    public void itReturnsTheCountryCode() {
        steps.assertCountryCode("US");
    }
}

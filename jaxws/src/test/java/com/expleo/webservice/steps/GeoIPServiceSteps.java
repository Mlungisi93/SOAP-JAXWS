package com.expleo.webservice.steps;

import com.expleo.webservice.jaxws.GeoIPService;
import com.expleo.webservice.jaxws.GeoIPServiceSoap;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.MatcherAssert.assertThat;

public class GeoIPServiceSteps {
    GeoIPService ipService;
    GeoIPServiceSoap geoIPServiceSoap;
    private String countryNameString;
    private String countryCodeString;

    @Step("Connect to GEOIPService")
    public void connectToGEOIPService() {

     ipService = new GeoIPService();
     geoIPServiceSoap = ipService.getGeoIPServiceSoap();

    }

    @Step
    public void passISOCode(String isoCode) {

        countryNameString = geoIPServiceSoap.getCountryNameByISO2(isoCode);
    }

    @Step
    public void assertCountry(String countryName) {
        assertThat("Incorrect country returned", countryNameString.contains(countryName));
    }

    @Step
    public void passIPAddress(String ipAddress) {
        countryCodeString = geoIPServiceSoap.getIpLocation20(ipAddress);
    }

    @Step
    public void assertCountryCode(String expectedCode) {

        assertThat("Incorrect country code", countryCodeString.contains(expectedCode));

    }
}

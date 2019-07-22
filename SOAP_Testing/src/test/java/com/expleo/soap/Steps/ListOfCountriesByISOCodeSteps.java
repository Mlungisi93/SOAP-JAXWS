package com.expleo.soap.Steps;

import com.expleo.soap.CountryInfoServiceSoapType;
import com.expleo.soap.CountryInfoService;
import com.expleo.soap.TContinent;
import com.expleo.soap.TCountryCodeAndName;
import net.thucydides.core.annotations.Step;

import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ListOfCountriesByISOCodeSteps
{
    CountryInfoService infoService;
    CountryInfoServiceSoapType countryInfoServiceSoapType;
    List<TCountryCodeAndName> ar;


    @Step
    public void getToBaseURL()
    {
        infoService = new CountryInfoService();
        countryInfoServiceSoapType = infoService.getCountryInfoServiceSoap();
    }

    @Step
    public void getListOfCountries()
    {

        ar = countryInfoServiceSoapType.listOfCountryNamesByCode().getTCountryCodeAndName();

        for(TCountryCodeAndName s: ar)
        {
            System.out.println("Code     " + s.getSISOCode());
            System.out.println("Name     " + s.getSName());
        }

    }


    @Step
    public String assertListHasCountries()
    {
        String message = "empty";
        try
        {
            assertThat(true,is(ar.size() > 0));
            message = "List of Countries has Data";
        }
        catch (AssertionError e)
        {

            message = "List is EMPTY - FAILURE";
        }
        return message;
    }

}

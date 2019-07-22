package com.expleo.soap.Steps;


import com.expleo.soap.CountryInfoService;
import com.expleo.soap.CountryInfoServiceSoapType;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CountrySteps
{

    CountryInfoService infoService;
    CountryInfoServiceSoapType infoServiceSoapType;
    String capitalCity;

    @Step
    public void getToBaseURL()
    {
        infoService = new CountryInfoService();
        infoServiceSoapType = infoService.getCountryInfoServiceSoap();

    }

    @Step
    public void getCapitalCity(String isoCode)
    {
       capitalCity = infoServiceSoapType.capitalCity(isoCode);
       System.out.println(capitalCity);
    }

    @Step
    public String assertCapitalCity(String expectedCity)
    {
        String message = "empty";
        try
        {
            assertThat(expectedCity,is(equalTo(capitalCity)));
            message = "Correct Capital Returned \n" +
                            "Expected -> " + expectedCity + "\n" +
                            "Actual   -> " + capitalCity;
        }
        catch (AssertionError e)
        {
            message = "Incorrect Capital Returned \n" +
                    "Expected \t\t-> " + expectedCity + "\n" +
                    "Actual   \t\t-> " + capitalCity;
        }
        return message;
    }

    @Step
    public String report(String message)
    {
        return message;
    }

}



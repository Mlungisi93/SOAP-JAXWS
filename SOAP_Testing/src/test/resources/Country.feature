@color=red
Feature: Country information SOAP

  Scenario: Get Capital City of Country
    Given I launch the base WSDL
    When I send country isoCode
    Then I should get correct capital city
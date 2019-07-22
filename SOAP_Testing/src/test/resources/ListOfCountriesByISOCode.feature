Feature: Getting country ISO Code

  Scenario: List of countries by ISO code
    Given I got the base url
    When I send request to get list of Countries
    Then i should get a list of Countries
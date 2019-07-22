Feature: GEO IP Service

  As a flight booking agent
  I wish to make use of an onlinr GEO IP Service
  So that I can provide correct country from ISO codes

  Scenario: Get country name from ISO code
    Given  that online GEOIP service is running
    When   I pass the ISO code
    Then   It returns the country

  Scenario: Get country code from IP address
    Given   that online GEOIP service is running
    When     I pass the IP address
    Then     It returns the country code

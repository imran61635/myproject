#Author: Mudassar Iqbal(iqbal.cdac@gmail.com)

@EmiratesMobFlightStatusAvailability
Feature: Verify the flight running status based on flight number

@tag1
Scenario: User should be able to search the flight status for any flight number
    Given Emirates mob app opens successfully
    When user navigates to the flight status 
    And user enter the fligt number 
    And user click on find flights
    Then User should see flight status

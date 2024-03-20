#Author: Mudassar Iqbal(iqbal.cdac@gmail.com)

@EmiratesWebFlightAvailability
Feature: Verify the flight availability from source to destination

@tag1
Scenario: User should be able to search the flight
    Given Emirates site opens successfully
    When user select departure and arrival destination return flight from one weak now
    Then User should see flight listing

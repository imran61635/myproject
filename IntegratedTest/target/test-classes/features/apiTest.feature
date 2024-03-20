#Author: Mudassar Iqbal(iqbal.cdac@gmail.com)

@APIResponseAndSchema
Feature: Verification of the API schema and Response

@tag1
Scenario: User should be able to verify the Response and Schema
    Given The API Endpoint
    When user use the Get method of API 
    Then User should validate the schema and response
    

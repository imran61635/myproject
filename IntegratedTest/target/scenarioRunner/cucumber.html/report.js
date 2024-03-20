$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("apiTest.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Mudassar Iqbal(iqbal.cdac@gmail.com)"
    }
  ],
  "line": 4,
  "name": "Verification of the API schema and Response",
  "description": "",
  "id": "verification-of-the-api-schema-and-response",
  "keyword": "Feature",
  "tags": [
    {
      "line": 3,
      "name": "@APIResponseAndSchema"
    }
  ]
});
formatter.scenario({
  "line": 7,
  "name": "User should be able to verify the Response and Schema",
  "description": "",
  "id": "verification-of-the-api-schema-and-response;user-should-be-able-to-verify-the-response-and-schema",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "The API Endpoint",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "user use the Get method of API",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "User should validate the schema and response",
  "keyword": "Then "
});
formatter.match({
  "location": "apiTestSteps.the_API_Endpoint()"
});
formatter.result({
  "duration": 117101731,
  "status": "passed"
});
formatter.match({
  "location": "apiTestSteps.user_use_the_Get_method_of_API()"
});
formatter.result({
  "duration": 2856522614,
  "status": "passed"
});
formatter.match({
  "location": "apiTestSteps.user_should_validate_the_schema_and_response()"
});
formatter.result({
  "duration": 280211410,
  "status": "passed"
});
formatter.uri("searchFlightStatusMobile.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Mudassar Iqbal(iqbal.cdac@gmail.com)"
    }
  ],
  "line": 4,
  "name": "Verify the flight running status based on flight number",
  "description": "",
  "id": "verify-the-flight-running-status-based-on-flight-number",
  "keyword": "Feature",
  "tags": [
    {
      "line": 3,
      "name": "@EmiratesMobFlightStatusAvailability"
    }
  ]
});
formatter.scenario({
  "line": 7,
  "name": "User should be able to search the flight status for any flight number",
  "description": "",
  "id": "verify-the-flight-running-status-based-on-flight-number;user-should-be-able-to-search-the-flight-status-for-any-flight-number",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "Emirates mob app opens successfully",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "user navigates to the flight status",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "user enter the fligt number",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "user click on find flights",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "User should see flight status",
  "keyword": "Then "
});
formatter.match({
  "location": "searchFlightStatusMobileSteps.emirates_mob_app_opens_successfully()"
});
formatter.result({
  "duration": 18837071476,
  "status": "passed"
});
formatter.match({
  "location": "searchFlightStatusMobileSteps.user_navigates_to_the_flight_status()"
});
formatter.result({
  "duration": 3290839186,
  "status": "passed"
});
formatter.match({
  "location": "searchFlightStatusMobileSteps.user_enter_the_fligt_number()"
});
formatter.result({
  "duration": 7369277048,
  "status": "passed"
});
formatter.match({
  "location": "searchFlightStatusMobileSteps.user_click_on_find_flights()"
});
formatter.result({
  "duration": 596112045,
  "status": "passed"
});
formatter.match({
  "location": "searchFlightStatusMobileSteps.user_should_see_flight_status()"
});
formatter.result({
  "duration": 7931409366,
  "status": "passed"
});
formatter.uri("searchFlightWeb.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Mudassar Iqbal(iqbal.cdac@gmail.com)"
    }
  ],
  "line": 4,
  "name": "Verify the flight availability from source to destination",
  "description": "",
  "id": "verify-the-flight-availability-from-source-to-destination",
  "keyword": "Feature",
  "tags": [
    {
      "line": 3,
      "name": "@EmiratesWebFlightAvailability"
    }
  ]
});
formatter.scenario({
  "line": 7,
  "name": "User should be able to search the flight",
  "description": "",
  "id": "verify-the-flight-availability-from-source-to-destination;user-should-be-able-to-search-the-flight",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "Emirates site opens successfully",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "user select departure and arrival destination return flight from one weak now",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "User should see flight listing",
  "keyword": "Then "
});
formatter.match({
  "location": "searchFlightWebSteps.emirates_site_opens_successfully()"
});
formatter.result({
  "duration": 9550838780,
  "status": "passed"
});
formatter.match({
  "location": "searchFlightWebSteps.user_select_departure_and_arrival_destination_return_flight_from_one_weak_now()"
});
formatter.result({
  "duration": 49638381988,
  "status": "passed"
});
formatter.match({
  "location": "searchFlightWebSteps.user_should_see_flight_listing()"
});
formatter.result({
  "duration": 1464783907,
  "status": "passed"
});
});
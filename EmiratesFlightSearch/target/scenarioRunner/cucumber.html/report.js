$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("checkEmiratesLowPrice.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: iqbal.cdac@gmail.com"
    }
  ],
  "line": 3,
  "name": "To check cheapest return ticket from DXB to LHR",
  "description": "",
  "id": "to-check-cheapest-return-ticket-from-dxb-to-lhr",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@Emirates-flight"
    }
  ]
});
formatter.scenario({
  "line": 6,
  "name": "Bill wants to travel from DXB to LHR",
  "description": "",
  "id": "to-check-cheapest-return-ticket-from-dxb-to-lhr;bill-wants-to-travel-from-dxb-to-lhr",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "that Bill has decided to check available flights",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "he looks at a return trip from DXB to LHR leaving one week from now",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "he should be shown the cheapest return ticket from DXB to LHR",
  "keyword": "Then "
});
formatter.match({
  "location": "checkEmiratesLowPriceSteps.that_Bill_has_decided_to_check_available_flights()"
});
formatter.result({
  "duration": 10811956457,
  "status": "passed"
});
formatter.match({
  "location": "checkEmiratesLowPriceSteps.he_looks_at_a_return_trip_from_DXB_to_LHR_leaving_one_week_from_now()"
});
formatter.result({
  "duration": 4566248144,
  "status": "passed"
});
formatter.match({
  "location": "checkEmiratesLowPriceSteps.he_should_be_shown_the_cheapest_return_ticket_from_DXB_to_LHR()"
});
formatter.result({
  "duration": 25213160215,
  "status": "passed"
});
});
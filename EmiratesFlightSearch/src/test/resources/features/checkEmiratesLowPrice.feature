#Author: iqbal.cdac@gmail.com
@Emirates-flight
Feature: To check cheapest return ticket from DXB to LHR

  @tag1
  Scenario: Bill wants to travel from DXB to LHR
    Given that Bill has decided to check available flights
    When he looks at a return trip from DXB to LHR leaving one week from now
    Then he should be shown the cheapest return ticket from DXB to LHR

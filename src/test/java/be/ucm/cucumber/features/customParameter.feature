Feature: test custom parameter

  Scenario: basic scenario
    Given a Meal name:x|price:4.8
    When I do something
    Then the name is "x" and the price is 4.8
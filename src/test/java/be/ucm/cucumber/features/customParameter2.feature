@todo
Feature: test custom parameter 2 to see if the given works in another step def

  Scenario: basic scenario
    Given a Meal 2 name:burger|price:4.8
    When I do something 2
    Then the name is "burger" and the price is 4.8 2
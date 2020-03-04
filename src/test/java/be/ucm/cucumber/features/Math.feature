Feature: calling a simple math method

  Scenario: a basic example
    Given the first number 50.0
    And the second number 2.5
    When i multiply them
    Then the result is 125.0
Feature: Decide what to eat

  Scenario: High budget
    Given a "good burger" at 15.0 euros
    And a client with a budget of 25.0 euros
    When I buy the burger
    Then the budget is 10.0 euros

  Scenario: Low budget
    Given a list of meals
    |name|price|
    |sushi|48.50|
    |sandwich|3.45|
    |durum   |5.5 |
    |cats    |6   |
    |dagburger|4.5|
    When I ask the cheapest meal
    Then i get the "sandwich" at 3.45 euros
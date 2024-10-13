@Calculator
Feature: This feature will test the calculator functionality

  Scenario: This scenario will test addition of two numbers
    Given I have two numbers 12 and 21
    When I add those two numbers
    Then I should get the result as 33

  Scenario: This scenario will test sub of two numbers
    Given I have two numbers 33 and 21
    When I sub those two numbers
    Then I should get the result as 12

  Scenario: This scenario will test multiplication of two numbers
    Given I have two numbers 10 and 20
    When I multiply those two numbers
    Then I should get the result as 200

@login
Feature: Users should be able to login
  @wip
  Scenario: Login as a Driver
    Given the user is on the login page
    When the user enters the driver information
    Then the user should be able to login
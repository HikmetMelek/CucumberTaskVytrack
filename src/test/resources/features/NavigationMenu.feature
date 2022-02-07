
Feature: Navigation Menu
  @navigate
  Scenario: Navigating Fleet -- Vehicles
    Given the user logged in as "salesManager"
    Then the user should be able to login
    When the user navigates to "Fleet", "Vehicles"
    Then the title should be "Vehicles"
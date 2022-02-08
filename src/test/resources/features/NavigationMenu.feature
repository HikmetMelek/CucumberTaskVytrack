@navigate
Feature: Navigation Menu
 @db
  Scenario: Navigating Fleet -- Vehicles
    Given the user logged in as "salesManager"
    Then the user should be able to login
    When the user navigates to "Fleet", "Vehicles"
    Then the title contains "Car"

  Scenario: Navigating Marketing -- Campaigns
    Given the user logged in as "salesManager"
    Then the user should be able to login
    When the user navigates to "Customers", "Contacts"
    Then the title contains "Contacts"

  Scenario: Navigating Activities -- Calendar Events
    Given the user logged in as "salesManager"
    Then the user should be able to login
    When the user navigates to "Activities", "Calendar Events"
    Then the title should be "All - Calendar Events - Activities"
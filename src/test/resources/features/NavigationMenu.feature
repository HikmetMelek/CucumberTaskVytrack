@smoke
Feature: Navigation Menu

  Scenario: Navigating Fleet -- Vehicles
    Given the user logged in as "sales manager"
    Then the user should be able to login
    When the user navigates to "Fleet", "Vehicles"
    Then the title contains "All - Car"

  Scenario: Navigating Marketing -- Campaigns
    Given the user logged in as "sales manager"
    Then the user should be able to login
    When the user navigates to "Customers", "Contacts"
    Then the title contains "Contacts"

  Scenario: Navigating Activities -- Calendar Events
    Given the user logged in as "sales manager"
    Then the user should be able to login
    When the user navigates to "Activities", "Calendar Events"
    Then the title should be "All - Calendar Events - Activities"
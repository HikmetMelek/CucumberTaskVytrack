Feature: Login as different users

  Scenario: login as a driver
    Given the user is on the login page
    When the user logs in using "User10" and "UserUser123"
    Then the user should be able to login
    And the title contains "Dashboard"

        #homework
  Scenario: login as a user(driver,storeManager,salesManager)
    Given the user logged in as "salesManager"
    Then the user should be able to login
    And the title contains "Dashboard"
    #usertype: driver,storemanager,salesmanager
   #you will have one step definition and it will handle differnet usertypes
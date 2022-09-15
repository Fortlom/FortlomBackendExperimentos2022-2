Feature: Fanatic account creation
  Scenario: Successful fan account creation
    Given the fan to enter the platform
    When you press “Sign up as a fan”
    And complete the form with your fan data
    And hit the button "Sign up as a fan"
    Then  your fan account was successfully created
  Scenario: Incorrect fan account creation
    Given the fan to enter the platform
    When you press “Sign up as a fan”
    And fill out the form incorrectly
    And hit the button "Sign up as a fan"
    Then will display a message that your fan account was not created
  Scenario: Login with the fan account created
    Given the fan to enter the platform
    And already has a fan account created on the platform
    When you complete your corresponding data in the form
    And submit the “Enter” button
    Then enter the platform with the account created
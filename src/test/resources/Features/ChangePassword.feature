Feature: Change Password
  Scenario: Successful password change
    Given that the user enters the platform
    And press "Forgot your password"
    When you write your data
    And click the “Send Mail” button
    And the mail has arrived
    And select it
    And press the button “Change password”
    And complete the information indicated
    And click on the "Change Password" button
    Then your new password was created successfully
  Scenario: Wrong Password Change
    Given that the user enters the platform
    And press "Forgot your password"
    When YOU WRONGLY WRITE YOUR DATA
    And click the “Send Mail” button
    Then the mail has not arrived
  Scenario: Sign in with the newly created password
    Given that the user enters the platform
    And already has the password changed on the platform
    When you complete your corresponding  new data in the form
    And hit the “Enter” button for check
    Then will enter the platform with the changed password
Feature: Fanatic Account Customization
  Scenario: Photo configuration
    Given go to the Configure section
    When fan click the + button
    And choose an image
    Then fan can see your image on your profile

  Scenario:  Name configuration
    Given go to the Configure section
    When fill in the form fan data correctly
    And click on the Change fan Profile button
    Then will be able to see the change in your profile name

  Scenario: New Password
    Given go to the Configure section
    When fill in the password fan data correctly
    When click on the Update Password button
    Then your password is change
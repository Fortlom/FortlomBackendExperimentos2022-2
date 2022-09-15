Feature: Profile information update capability
  Scenario: Photo Settings
    Given enter the Configure section
    When you click the + button
    And choose an image of your choice
    Then you can see your image on your profile
  Scenario: Name Setting
    Given enter the Configure section
    When fill in the form data correctly
    And click on the Change Profile button
    Then will be able to see your change in your profile name
  Scenario: Artist places their Tags
    Given that the user is in the Configure section
    When you click on the Add button
    Then your art will be defined by a specific tag

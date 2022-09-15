Feature: Creation of artist forums
  Scenario: Successful Forum Creation
    Given that the artist is in the Forum section
    And click on the + button
    When correctly fill in the data
    And click on Create
    Then message of your forum created successfully will appear
  Scenario: Bad Forum Creation
    Given that the artist is in the Forum section
    And click on the + button
    When fill in the details
    And the forum name is used
    And click on Create
    Then message will appear your forum already exists
  Scenario: Visualize Forum
    Given that the artist is in the Forum section
    When you have successfully created a forum
    Then your forum will appear in the list

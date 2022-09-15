Feature: Creation of fanatic forums
  Scenario: Successful Forum Creation
    Given that the fanatic is in the Fanatic forum section
    And fan click on the + button
    When fan correctly fill data
    And fan click on Create
    Then message of "your forum created successfully will appear"
  Scenario: Bad Forum Creation
    Given that the fanatic is in the Fanatic forum section
    And fan click on the + button
    When fan fill in the details
    And  forum name is used
    And fan click on Create
    Then message will appear "this forum already exists"
  Scenario: Visualize Forum
    Given that the fanatic is in the Fanatic forum section
    When you have successfully created a fan forum
    Then your new forum will appear in the list

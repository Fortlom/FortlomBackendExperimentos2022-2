Feature: Comment in publications and forums as a fanatic
  Scenario: Create comments in a publication
    Given that the fanatic is at the Publication section
    And press the blue button See Posts
    When choose a publication
    And write what it wants
    And press the button Post Comment
    Then the comment will be created successfully
  Scenario: Create comments in a forum
    Given that the fanatic is at the Fanatic Forum section
    And  choose a forum of its preference
    When write what it wants in the selected forum
    And press the button Accept
    Then a message will show that the comment was created successfully
  Scenario: Visualize comments in a publication
    Given that the fanatic is at the Publication section
    And press the blue button See Posts
    When choose a publication
    And press the button See
    Then the comments of the publication will be visualized
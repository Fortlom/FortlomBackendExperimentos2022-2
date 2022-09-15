Feature: Artist Comments
  Scenario: Creation of comments in Publication
    Given that the artist is in the Posts section
    And hit the see Posts button
    When choose a publication of its preference
    And write what you want
    And hit the Post Comment button
    Then your comment will be created successfully
  Scenario: Creating Forum Comments
    Given the artist is in the Forum section
    And choose a forum of your liking
    When write what you want in the chosen forum
    And hit the OK button
    Then will output a message that the comment was successfully created
  Scenario: Viewing Comments on Post
    Given that the artist is in the Posts section
    And hit the see Posts button
    When choose a publication of its preference
    And hit the See button
    Then you can view the comments of the publication
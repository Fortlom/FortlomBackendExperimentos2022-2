Feature: Artist Publications
  Scenario: Making a correct publication
    Given that the artist is on your homepage
    When press the option Posts
    And fill in everything correctly
    And press the button Post
    Then the publication will be created successfully
  Scenario: Making a incorrect publication
    Given that the artist is on your homepage
    When press the option Posts
    And do not fill out the form
    And press button Post
    Then an alert message will appear
  Scenario: Making a publication with images
    Given that the artist is on Posts section
    And is creating a publication
    When press the clip
    And select images
    And press the button Append
    And press the button Post
    Then will be able to make a publication with images

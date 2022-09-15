Feature: Fraud Report
  Scenario: Report on publication fraud
    Given that the artist is on Posts section fraud
    And press the button See Posts
    When there is a publication that seems incorrect to him
    And press the button Flag Post
    Then the report is created
  Scenario: Report on forum fraud
    Given that the artist is on Forum section
    And enter a forum
    When there is a forum that seems incorrect to him
    And press the button Flag Forum
    Then the report is created
  Scenario: Report on forum commentary fraud
    Given that the artist is on Forum section
    And enter a forum
    When there is a forum commentary that seems incorrect to him
    And press the button Flag Forum Commentary
    Then the report is created
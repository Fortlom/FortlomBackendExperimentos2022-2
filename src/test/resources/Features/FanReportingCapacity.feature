Feature: ability to report to a profane user
  Scenario: Reporting publication fraud
    Given the fanatic is in the publication section
    And click on the see posts button
    When detect a profane publication
    And click on the flag button
    Then the publication is reported

  Scenario: Reporting foro fraud
    Given is in the Fanatic forum section
    And check a forum
    When detect a profane foro
    And click on the flag button
    Then the foro is reported

  Scenario: Reporting comment fraud
    Given is in the Fanatic forum section
    And check a forum
    When detect a profane comment
    And click on the flag button
    Then the comment is reported
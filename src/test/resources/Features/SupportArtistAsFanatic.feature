Feature: Support an artist as a fanatic
  Scenario: Follow an artist
    Given that the fanatic is at the Artist section
    When press the button follow
    Then the artist will be followed
  Scenario: Rate an artist
    Given that the fanatic is at the Artist section
    When select a number at the bar
    Then a message will show that the artist has been rated
  Scenario: Unfollow an artist
    Given that the fanatic is at the Artist section
    When press the button Unfollow
    Then the artist will no longer be followed
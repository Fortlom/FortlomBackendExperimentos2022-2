Feature: Like a publication or event as a fanatic
  Scenario: Like a publication
    Given that the fanatic is at the  fan Publication section
    And press the  button See Posts
    When choose a  publication
    And press the button  Like
    Then it will be noticed that the fanatic likes the publication
  Scenario: Dislike a publication
    Given that the fanatic is at the  fan Publication section
    And press the  button See Posts
    When choose a  publication
    And press the button  Dislike
    Then it will be noticed that the fanatic does not like the publication
  Scenario: Like an event
    Given that the fanatic is at the Event section
    And press white the button Show All Events
    When choose an event of its preference
    And press the button thumb up
    Then it will be noticed that the fanatic likes the event
  Scenario: Dislike an event
    Given that the fanatic is at the Event section
    And press white the button Show All Events
    When choose an event of its preference
    And press the button thumb down
    Then it will be noticed that the fanatic does not like the event
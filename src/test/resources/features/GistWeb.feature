Feature: Visit the Gist UI and perform several functions

  Scenario: Visit Gist, Login and Add a Gist
    Given I don't have and Web session
    When I visit Gist
    And I login to Gist with username caco_la@hotmail.com and password password123!
    And I create a new Gist with description This is my description
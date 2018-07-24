Feature: Make several calls to the Gist API

  Scenario: List Gists
    Given I don't have an API session
    When I call the gists endpoint

  Scenario: Add a new Gist and verify that it created properly
    Given I don't have an API session
    When I post a new gist called this where public is true
    Then My response is a 200

  Scenario: Edit a Gist
    Given I don't have an API session
    When I call the gists endpoint
    And My response is a 200
    Then Then I edit result number 1 with the following description This is my new desctiprion text
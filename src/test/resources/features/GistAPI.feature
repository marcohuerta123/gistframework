Feature: Make several calls to the Gist API

  Scenario: Add a new Gist
    Given I don't have an API session
    When I call the gists endpoint
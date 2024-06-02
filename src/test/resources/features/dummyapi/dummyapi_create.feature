Feature: Handling various scenarios in user creation

  Background:
    Given app-id contains the correct value "66272d3ca25d39f3923bfa35"
    And given base_url variable contains the value "https://dummyapi.io/data/v1" in the environment

  Scenario: Email is already registered in the system
    When the user sends a CREATE request with registered email
    Then the status response should be 400 Bad Request
    And the response body should contain the error message "BODY_NOT_VALID"

  Scenario: FirstName is left empty
    When the user sends an CREATE request with empty firstName
    Then the status response should be 400 Bad Request
    And the response body should contain the error message "BODY_NOT_VALID"

  Scenario: LastName is left empty
    When the user sends an CREATE request with empty lastName
    Then the status response should be 400 Bad Request
    And the response body should contain the error message "BODY_NOT_VALID"

  Scenario: Request body is empty
    When the user sends a CREATE request with empty body
    Then the status response should be 400 Bad Request
    And the response body should contain the error message "BODY_NOT_VALID"

  Scenario: All fields are filled correctly, but the email is already registered in the system
    When the user sends a CREATE request with registered email but other fields are valid
    Then the status response should be 400 Bad Request
    And the response body should contain the error message "BODY_NOT_VALID"

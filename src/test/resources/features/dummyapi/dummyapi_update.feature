Feature: Dummy API UPDATE Method Testing

@TC-M03-01
Scenario: Missing app-id in header request
    Given no app-id is provided in the request header
    When the user sends a PUT request to the URL "https://dummyapi.io/data/v1/user/662e3c761846fb04fdd51dc9"
    Then the status response should be 403 Forbidden
    And the response body should report "APP_ID_MISSING"

@TC-M03-02
Scenario: Added an incorrect app-id to the header
    Given the wrong app-id in the request header is "662e389ebb70a717cf25946d"
    When the user sends a PUT request to the URL "https://dummyapi.io/data/v1/user/662e3c761846fb04fdd51dc9"
    Then the status response should be 403 Forbidden
    And the response body should report "APP_ID_NOT_EXIST"

@TC-M03-10
Scenario: Update some data in user table excluding email with registered id parameter
    Given the app-id in the request header is "662e389ebb70a717cf25946b"
    When the user sends a PUT request to the URL "https://dummyapi.io/data/v1/user/662e3c761846fb04fdd51dc9"
    Then the status response should be 200 OK
    And the response body should contain current user data with ID "662e3c761846fb04fdd51dc9"

@TC-M03-11
Scenario: Update firstName field with length in range 2-50 with registered id parameter
    Given the app-id in the request header is "662e389ebb70a717cf25946b"
    When the user sends a PUT request with updated firstname to the URL "https://dummyapi.io/data/v1/user/662e3c761846fb04fdd51dc9"
    Then the status response should be 200 OK
    And the response body should contain updated firstname user data with ID "662e3c761846fb04fdd51dc9"
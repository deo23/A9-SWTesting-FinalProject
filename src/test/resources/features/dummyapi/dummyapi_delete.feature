Feature: Dummy API DELETE Method Testing

@TC-M04-1
Scenario: Missing app-id in header request
    Given no app-id is provided in the request header
    When the user sends a DELETE request to the URL "https://dummyapi.io/data/v1/user/60d0fe4f5311236168a109cb"
    Then the status response should be 403 Forbidden
    And the response body should report "APP_ID_MISSING"

@TC-M04-2
Scenario: Added an incorrect app-id to the header
    Given the wrong app-id in the request header is "662e3849bb70a7aae125946"
    When the user sends a DELETE request to the URL "https://dummyapi.io/data/v1/user/60d0fe4f5311236168a109cb"
    Then the status response should be 403 Forbidden
    And the response body should report "APP_ID_NOT_EXIST"

@TC-M04-3
Scenario: Delete 1 user data not registered in the database
    Given the app-id in the request header is "662e3849bb70a7aae1259467"
    When the user sends a DELETE request to the URL "https://dummyapi.io/data/v1/user/50d0fe4f5311236168a109cb"
    Then the status response should be 404 Not Found
    And the response body should contain "error" with value "RESOURCE_NOT_FOUND"

@TC-M04-4
Scenario: Delete 1 user data registered in the database
    Given the app-id in the request header is "662e3849bb70a7aae1259467"
    When the user sends a DELETE request to the URL "https://dummyapi.io/data/v1/user/60d0fe4f5311236168a109f2"
    Then the status response should be 200 OK
    And the response body should confirm deletion of user ID "60d0fe4f5311236168a109f2"
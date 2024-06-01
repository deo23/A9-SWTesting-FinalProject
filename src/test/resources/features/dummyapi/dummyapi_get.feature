Feature: Dummy API GET Method Testing

Scenario: Missing app-id in header request
    Given no app-id is provided in the request header
    When the user sends a GET request to the URL "https://dummyapi.io/data/v1/user/60d0fe4f5311236168a109cb"
    Then the status response should be 403 Forbidden
    And the response body should report "APP_ID_MISSING"

Scenario: Added an incorrect app-id to the header
    Given the wrong app-id in the request header is "662e3849bb70a7aae125946"
    When the user sends a GET request to the URL "https://dummyapi.io/data/v1/user/60d0fe4f5311236168a109cb"
    Then the status response should be 403 Forbidden
    And the response body should report "APP_ID_NOT_EXIST"
    
Scenario: Retrieve user data that is not registered in the database
  Given the app-id in the request header is "662e3849bb70a7aae1259467"
  When the user sends a GET request to the URL "https://dummyapi.io/data/v1/user/50d0fe4f5311236168a109cb"
  Then the status response should be 404 Not Found
  And the response body should contain "error" with value "RESOURCE_NOT_FOUND"

Scenario: Retrieve 1 user data registered in the database
    Given the app-id in the request header is "662e3849bb70a7aae1259467"
    When the user sends a GET request to the URL "https://dummyapi.io/data/v1/user/60d0fe4f5311236168a109cc"
    Then the status response should be 200 OK
    And the response body should contain user data with ID "60d0fe4f5311236168a109cc"

Scenario: Retrieve all user data
    Given the app-id in the request header is "662e3849bb70a7aae1259467"
    When the user sends a GET request to the URL "https://dummyapi.io/data/v1/user?page=0&limit=20"
    Then the response should contain a list of users and match the expected data structure
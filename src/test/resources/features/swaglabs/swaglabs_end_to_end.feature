Feature: All Feature

@TC-End-To-End
Scenario: End To End Testing
    Given the application is running and user is login in
    When the user clicks one of the specific product link
    And the user adds the product to the cart
    And the user back to dashboard page
    And the user open the cart page
    And the user checkout the cart
    And the user fill the shipping information
    And the user finish the checkout
    And the user back to home page
    And the user click the sidebar menu
    And the user logout from the application
    Then the system logs out the user

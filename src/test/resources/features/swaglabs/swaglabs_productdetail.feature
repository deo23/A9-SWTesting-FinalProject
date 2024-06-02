Feature: Product detail

@TC-F05-4
Scenario: User can see product detail
    Given the application is running and successfully logged in
    When the user clicks on the specific product link
    Then the system navigates to the product detail page

@TC-F05-2
Scenario: User can add product to cart
    Given the user is on the product detail page
    When the user clicks the Add to Cart button
    Then the system adds the product to the cart

@TC-F05-3
Scenario: User back to dashboard
    Given the user is on the product detail page
    When the user clicks the back button
    Then the system navigates to the dashboard page
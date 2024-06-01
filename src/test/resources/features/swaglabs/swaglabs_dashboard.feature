Feature: Product Display on Dashboard

  Scenario: Testing Product display on the dashboard page
    Given the application is running and successfully logged in
    Then the system displays the dashboard page and shows the list of available products

  Scenario: Navigating to a specific product detail page by clicking the link
    Given the application is running and successfully logged in
    When the user clicks on the specific product link
    Then the system navigates to the product detail page

Scenario: Clicking the cart button on the dashboard page
    Given the application is running and successfully logged in
    When logged in successfully and click the Cart button
    Then the system navigates to the cart page

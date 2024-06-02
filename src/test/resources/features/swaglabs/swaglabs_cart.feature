Feature: Shopping Cart

  @TC-F03-01
  Scenario: Verify the cart display when at least 1 product is added to the cart
    Given the user has successfully logged into the application
    And the user is on the dashboard page
    And at least 1 product is added to the cart
    When the user clicks the cart button on the dashboard page
    Then the system displays the cart page with a list of products added to the cart

  @TC-F03-02
  Scenario: Verify the process of displaying the checkout page when at least 1 product is added to the cart
    Given the user has successfully logged into the application
    And the user is on the dashboard page
    And at least 1 product is added to the cart
    When the user clicks the cart button on the dashboard page
    And the user clicks the checkout button
    Then the system displays the checkout page with a checkout information form

  @TC-F03-03
  Scenario: Verify the process of returning to the dashboard page when at least 1 product is added to the cart
    Given the user has successfully logged into the application
    And the user is on the dashboard page
    And at least 1 product is added to the cart
    When the user clicks the cart button on the dashboard page
    And the user clicks the continue shopping button
    Then the system displays the dashboard page and the previously added products are still in the cart
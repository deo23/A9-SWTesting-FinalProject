Feature: Checkout process

  @TC-F04-01
  Scenario: Clicking the Back Home button on the Checkout Complete page
    Given already accessed the checkout complete page
    When clicking the Back Home button
    Then the system displays the dashboard page

  @TC-F04-02
  Scenario: Clicking the Finish button on the Checkout Overview page
    Given already on the checkout overview page and clicked continue
    When clicking the Finish button
    Then the system displays the checkout complete page

  @TC-F04-03
  Scenario: Clicking the Cancel button on the Checkout Information page
    Given already added products to the cart and clicked checkout
    When clicking the Cancel button
    Then the system displays the cart page
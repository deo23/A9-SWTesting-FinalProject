Feature: Menu Display

@TC-F06-01
Scenario: View All Items in the Menu
    Given application is running and successfully logged in
    When the user clicks on the humburger button
    And the user clicks on the All Items menu
    Then the system displays All Items on the menu page
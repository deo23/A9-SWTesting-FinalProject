Feature: Menu Display

@TC-F06-01
Scenario: View All Items in the Menu
    Given application is running and successfully logged in
    When the user clicks on the humburger button
    And the user clicks on the All Items menu
    Then the system displays All Items on the menu page

@TC-F06-02
Scenario: Logout from the Application
    Given application is running and successfully logged in
    When the user clicks on the humburger button
    And the user clicks on the Logout menu
    Then the system logs out the user and displays the login page

@TC-F06-03
Scenario: View About Information
    Given application is running and successfully logged in
    When the user clicks on the humburger button
    And the user clicks on the About menu
    Then the system displays the About page
Feature: Login
    Scenario: Login with empty password
    Given User is on Homepage
    When User clicks on login link
    And User is redirected to the login page
    And User enters a valid username on username field
    And User doesn't fill the password on password field
    And User clicks on the login button
    Then User should get an error message

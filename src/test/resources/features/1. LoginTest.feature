@regressions
Feature: Log in features | MAFAO Odoo Environment

  Background:
    Given The user access to MAFAO homepage

  Scenario: Login as an admin in MAFAO website
    Given the user logs in as an admin
    When admin dashboard page displays correctly
    Then the user logs out

  Scenario: Login with Keyloack in MAFAO website
    Given the user clicks on Login with Keycloak button
    When the user logs in as a seller with valid credentials
    And seller dashboard page displays correctly
    Then the user logs out

  Scenario: Reset pincode
    Given the user clicks on Reset Pin Code
    When enters a registered mobile number - odoo
    And enters OTP code received - odoo
    And the new pincode twice and clicks on Confirm button
    Then passcode changed successful message must be displayed
    And redirects you to Login page again
    And the user clicks on Login with Keycloak button
    And the user logs in as a seller with valid credentials
    Then seller dashboard page displays correctly

  Scenario: Sign up as a Seller
    Given the user clicks on Login with Keycloak button
    When the user logs in as a seller with valid credentials
    And seller dashboard page displays correctly
    Then the user logs out
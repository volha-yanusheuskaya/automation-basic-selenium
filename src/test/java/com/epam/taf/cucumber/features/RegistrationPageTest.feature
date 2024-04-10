@registration @smoke
  Feature: Create account page in the CIAM Profile application
    As a user, I would like to navigate to the Create account page and see the Registration form to create new account

  Background: Navigate to the Create account page
    Given I have navigated to the Create account page
    Then The URL of the page ends with "/create-account"

  @registration_title_verification
  Scenario: Verify the title of the Create account page
    Then The Title of the page is equals to "Create an account | Thomson Reuters"

  @registration_form_verification
  Scenario: Verify the registration form on the Create account page
    When I close cookie banner
    Then The "first-name-input" element is displayed
    And The "last-name-input" element is displayed
    And The "email-input" element is displayed
    And The "new-password-input" element is displayed
    And The "password-confirmation-input" element is displayed
    And The "language-dropdown" element is displayed
    And The "term-of-use-checkbox" element is displayed
    And The "continue-button" element is displayed

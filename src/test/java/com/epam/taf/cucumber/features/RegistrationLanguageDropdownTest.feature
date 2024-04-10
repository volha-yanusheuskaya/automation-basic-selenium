@registration @regression
Feature: Preferred language dropdown verification on the Create account page
  As a user, I would like to navigate to the Create account page and choose preferred language for my account

  Background: Navigate to the Create account page
    Given I have navigated to the Create account page
    Then The URL of the page ends with "/create-account"
    When I close cookie banner
    Then The Title of the page is equals to "Create an account | Thomson Reuters"

  @dropdown_items_verification
  Scenario: Verify the items of the Preferred language dropdown
    When I click on the "language-dropdown" element
    Then 7 languages are displayed in the dropdown

  @dropdown_item_selection
  Scenario Outline: Verify the selected language in the dropdown
    When I click on the "language-dropdown" element
    And I click on the "<language>" item in dropdown
    Then The header of the dropdown is displayed with the "<language>" text

    When I click on the "language-dropdown" element
    Then The selected "<language>" item has a checkmark

    Examples:
      | language       |
      | English (AU)   |
      | English (CA)   |
      | English (GB)   |
      | English (US)   |
      | Español (AR)   |
      | Français (CA)  |
      | Português (BR) |

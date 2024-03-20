@shopping-cart
Feature: Acceptance testing from registration till shopping cart checkout
         in order to validate that shopping cart feature
         the redmart app is working

  @tag1
  Scenario: The user should be able to successfully register on the app
    Given I am on the homepage of redmart app
    When I click on three line menu option on top left of Explore
    And Click on my account option
    And Enter the emailId in email text box of sign up
    And Enter the password in password text box of sign up
    And click on register button
    Then I should see text "About" after successful registration
    And I click on back arrow button to go on home page

  @tag2
  Scenario: The user should be able to add multiple items to cart
    Given I am on the homepage of redmart app
    When I find products on home page
    Then I should be able to add all products to the cart

  @tag3
  Scenario: The user should be able to remove items to cart
    Given I am on the homepage of redmart app
    When I click on shopping cart icon from prod list main page
    Then I should be able to remove products items to cart

  @tag4
  Scenario: The user should be able to update items quantity in cart
    Given I am on the homepage of redmart app
    When I click on increase quantity option of the added item in cart
    Then The item quantity should be changed

  @tag5
  Scenario: The user should be able to checkout
    Given I am on the homepage of redmart app
    When I Click on checkout button
    Then I should see "Select your address." option

  @tag6
  Scenario: The user should be able to add the address
    Given I am on the homepage of redmart app
    When click on add new address section after checkout
    And click the postal code section for address
    And enter the postal code "619747" in the postal code section
    And select the suggested address
    And enter the "7" in floor section
    And enter "1" in unit section
    And enter "mudassar" in the first name  section text box
    And enter "iqbal" in the last name  section text box
    And click on address save button
    Then i should see "MOBILE NUMBER" section

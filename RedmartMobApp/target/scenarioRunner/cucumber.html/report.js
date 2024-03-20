$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("shoppingCart.feature");
formatter.feature({
  "line": 2,
  "name": "Acceptance testing from registration till shopping cart checkout",
  "description": "       in order to validate that shopping cart feature\n       the redmart app is working",
  "id": "acceptance-testing-from-registration-till-shopping-cart-checkout",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@shopping-cart"
    }
  ]
});
formatter.scenario({
  "line": 7,
  "name": "The user should be able to successfully register on the app",
  "description": "",
  "id": "acceptance-testing-from-registration-till-shopping-cart-checkout;the-user-should-be-able-to-successfully-register-on-the-app",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "I am on the homepage of redmart app",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I click on three line menu option on top left of Explore",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "Click on my account option",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Enter the emailId in email text box of sign up",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Enter the password in password text box of sign up",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "click on register button",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I should see text \"About\" after successful registration",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "I click on back arrow button to go on home page",
  "keyword": "And "
});
formatter.match({
  "location": "shoppingCartSteps.i_am_on_the_homepage_of_redmart_app()"
});
formatter.result({
  "duration": 14552840986,
  "status": "passed"
});
formatter.match({
  "location": "shoppingCartSteps.i_click_on_three_line_menu_option_on_top_left_of_Explore()"
});
formatter.result({
  "duration": 1202510030,
  "status": "passed"
});
formatter.match({
  "location": "shoppingCartSteps.click_on_my_account_option()"
});
formatter.result({
  "duration": 1668748669,
  "status": "passed"
});
formatter.match({
  "location": "shoppingCartSteps.enter_the_in_email_text_box_of_sign_up()"
});
formatter.result({
  "duration": 11196797853,
  "status": "passed"
});
formatter.match({
  "location": "shoppingCartSteps.enter_the_in_password_text_box_of_sign_up()"
});
formatter.result({
  "duration": 8259394703,
  "status": "passed"
});
formatter.match({
  "location": "shoppingCartSteps.click_on_register_button()"
});
formatter.result({
  "duration": 3235202224,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "About",
      "offset": 19
    }
  ],
  "location": "shoppingCartSteps.i_should_see_text_after_successful_registration(String)"
});
formatter.result({
  "duration": 889050397,
  "status": "passed"
});
formatter.match({
  "location": "shoppingCartSteps.i_click_on_back_arrow_button_to_go_on_home_page()"
});
formatter.result({
  "duration": 3494019168,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "The user should be able to add multiple items to cart",
  "description": "",
  "id": "acceptance-testing-from-registration-till-shopping-cart-checkout;the-user-should-be-able-to-add-multiple-items-to-cart",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 17,
      "name": "@tag2"
    }
  ]
});
formatter.step({
  "line": 19,
  "name": "I am on the homepage of redmart app",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "I find products on home page",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "I should be able to add all products to the cart",
  "keyword": "Then "
});
formatter.match({
  "location": "shoppingCartSteps.i_am_on_the_homepage_of_redmart_app()"
});
formatter.result({
  "duration": 167966,
  "status": "passed"
});
formatter.match({
  "location": "shoppingCartSteps.i_find_products_on_home_page()"
});
formatter.result({
  "duration": 48877932,
  "status": "passed"
});
formatter.match({
  "location": "shoppingCartSteps.i_should_be_able_to_add_all_products_to_the_cart()"
});
formatter.result({
  "duration": 9937530293,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "The user should be able to remove items to cart",
  "description": "",
  "id": "acceptance-testing-from-registration-till-shopping-cart-checkout;the-user-should-be-able-to-remove-items-to-cart",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 23,
      "name": "@tag3"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "I am on the homepage of redmart app",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "I click on shopping cart icon from prod list main page",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "I should be able to remove products items to cart",
  "keyword": "Then "
});
formatter.match({
  "location": "shoppingCartSteps.i_am_on_the_homepage_of_redmart_app()"
});
formatter.result({
  "duration": 145517,
  "status": "passed"
});
formatter.match({
  "location": "shoppingCartSteps.I_click_on_shopping_cart_icon_from_prod_list_main_page()"
});
formatter.result({
  "duration": 1040446174,
  "status": "passed"
});
formatter.match({
  "location": "shoppingCartSteps.I_should_be_able_to_remove_products_items_to_cart()"
});
formatter.result({
  "duration": 10836875300,
  "status": "passed"
});
formatter.scenario({
  "line": 30,
  "name": "The user should be able to update items quantity in cart",
  "description": "",
  "id": "acceptance-testing-from-registration-till-shopping-cart-checkout;the-user-should-be-able-to-update-items-quantity-in-cart",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 29,
      "name": "@tag4"
    }
  ]
});
formatter.step({
  "line": 31,
  "name": "I am on the homepage of redmart app",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "I click on increase quantity option of the added item in cart",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "The item quantity should be changed",
  "keyword": "Then "
});
formatter.match({
  "location": "shoppingCartSteps.i_am_on_the_homepage_of_redmart_app()"
});
formatter.result({
  "duration": 231956,
  "status": "passed"
});
formatter.match({
  "location": "shoppingCartSteps.I_click_on_increase_quantity_option_of_the_added_item_in_cart()"
});
formatter.result({
  "duration": 39770,
  "status": "passed"
});
formatter.match({
  "location": "shoppingCartSteps.The_item_quantity_should_be_changed()"
});
formatter.result({
  "duration": 2643413987,
  "status": "passed"
});
formatter.scenario({
  "line": 36,
  "name": "The user should be able to checkout",
  "description": "",
  "id": "acceptance-testing-from-registration-till-shopping-cart-checkout;the-user-should-be-able-to-checkout",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 35,
      "name": "@tag5"
    }
  ]
});
formatter.step({
  "line": 37,
  "name": "I am on the homepage of redmart app",
  "keyword": "Given "
});
formatter.step({
  "line": 38,
  "name": "I Click on checkout button",
  "keyword": "When "
});
formatter.step({
  "line": 39,
  "name": "I should see \"Select your address.\" option",
  "keyword": "Then "
});
formatter.match({
  "location": "shoppingCartSteps.i_am_on_the_homepage_of_redmart_app()"
});
formatter.result({
  "duration": 152171,
  "status": "passed"
});
formatter.match({
  "location": "shoppingCartSteps.I_Click_on_checkout_button()"
});
formatter.result({
  "duration": 547177359,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Select your address.",
      "offset": 14
    }
  ],
  "location": "shoppingCartSteps.I_should_see_Select_your_address_option(String)"
});
formatter.result({
  "duration": 1032320654,
  "status": "passed"
});
formatter.scenario({
  "line": 42,
  "name": "The user should be able to add the address",
  "description": "",
  "id": "acceptance-testing-from-registration-till-shopping-cart-checkout;the-user-should-be-able-to-add-the-address",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 41,
      "name": "@tag6"
    }
  ]
});
formatter.step({
  "line": 43,
  "name": "I am on the homepage of redmart app",
  "keyword": "Given "
});
formatter.step({
  "line": 44,
  "name": "click on add new address section after checkout",
  "keyword": "When "
});
formatter.step({
  "line": 45,
  "name": "click the postal code section for address",
  "keyword": "And "
});
formatter.step({
  "line": 46,
  "name": "enter the postal code \"619747\" in the postal code section",
  "keyword": "And "
});
formatter.step({
  "line": 47,
  "name": "select the suggested address",
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "enter the \"7\" in floor section",
  "keyword": "And "
});
formatter.step({
  "line": 49,
  "name": "enter \"1\" in unit section",
  "keyword": "And "
});
formatter.step({
  "line": 50,
  "name": "enter \"mudassar\" in the first name  section text box",
  "keyword": "And "
});
formatter.step({
  "line": 51,
  "name": "enter \"iqbal\" in the last name  section text box",
  "keyword": "And "
});
formatter.step({
  "line": 52,
  "name": "click on address save button",
  "keyword": "And "
});
formatter.step({
  "line": 53,
  "name": "i should see \"MOBILE NUMBER\" section",
  "keyword": "Then "
});
formatter.match({
  "location": "shoppingCartSteps.i_am_on_the_homepage_of_redmart_app()"
});
formatter.result({
  "duration": 147824,
  "status": "passed"
});
formatter.match({
  "location": "shoppingCartSteps.click_on_add_new_address_section_after_checkout()"
});
formatter.result({
  "duration": 476548720,
  "status": "passed"
});
formatter.match({
  "location": "shoppingCartSteps.click_the_postal_code_section_for_address()"
});
formatter.result({
  "duration": 764548191,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "619747",
      "offset": 23
    }
  ],
  "location": "shoppingCartSteps.enter_the_postal_code_in_the_postal_code_section(String)"
});
formatter.result({
  "duration": 7516246749,
  "status": "passed"
});
formatter.match({
  "location": "shoppingCartSteps.select_the_suggested_address()"
});
formatter.result({
  "duration": 1055971749,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "7",
      "offset": 11
    }
  ],
  "location": "shoppingCartSteps.enter_the_in_floor_section(String)"
});
formatter.result({
  "duration": 6209163193,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 7
    }
  ],
  "location": "shoppingCartSteps.enter_in_unit_section(String)"
});
formatter.result({
  "duration": 6472159498,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "mudassar",
      "offset": 7
    }
  ],
  "location": "shoppingCartSteps.enter_mudassar_in_the_first_name_section_text_box(String)"
});
formatter.result({
  "duration": 6185202019,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "iqbal",
      "offset": 7
    }
  ],
  "location": "shoppingCartSteps.enter_iqbal_in_the_last_name_section_text_box(String)"
});
formatter.result({
  "duration": 5967244622,
  "status": "passed"
});
formatter.match({
  "location": "shoppingCartSteps.click_on_address_save_button()"
});
formatter.result({
  "duration": 809898477,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "MOBILE NUMBER",
      "offset": 14
    }
  ],
  "location": "shoppingCartSteps.i_should_see_section(String)"
});
formatter.result({
  "duration": 2630885591,
  "status": "passed"
});
});
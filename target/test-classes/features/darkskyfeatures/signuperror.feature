@web @regression @signuperror

Feature: Dark Sky Sign Up Error

  Background:
    Given I am on DarkSKy home page

    @signuperror-1
    Scenario: Verify invalid signup error message
      When I am on the darksky Register page
      When I click on Register button
      Then I verify error message please fill out this field













@web @regression @TempTimeline

Feature: Dark Sky Sign Up Error

  Background:
    Given I am on DarkSKy home page

    @homepeageTimeline
    Scenario: Verify timline is displayed in correct format

      Then I verify timeline is displayed with two hours incremented


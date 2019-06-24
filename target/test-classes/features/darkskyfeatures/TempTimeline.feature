@web @regression @TempTimeline

Feature: Dark Sky Sign Up Error

  Background:
    Given I am on DarkSKy home page

  @temperaturetimeline
  Scenario: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
    Given I am on Darksky Home Page
    Then I verify current temp is not greater or less then temps from daily timeline



  @todaytemperature
  Scenario: Verify individual day temp timeline
    Given I am on Darksky Home Page
    When I expand todays timeline
    Then I verify lowest and highest temp is displayed correctly

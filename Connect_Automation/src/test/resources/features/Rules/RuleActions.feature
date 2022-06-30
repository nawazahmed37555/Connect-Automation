@RuleDefs
Feature: Manage Rule Definitions

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed
    When User clicks on Rules menu option
    And User clicks on Rule Actions menu option

  @T1720110391
  Scenario: Add a rule Definition
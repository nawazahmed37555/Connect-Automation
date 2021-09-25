@Responsibilities
Feature: Add,Search,Edit,Enable,Disable,Export responsibilities

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed

  @T1720110327
  Scenario: Add a Responsibility
    When User clicks on Responsibilities menu option
    And User clicks on Add button to add Responsibility
    And User Enters required detais to add Responsibility
    And User clicks on Save button to add Responsibility
    Then Verify Responsibility is created successfully

  @T1720110325
  Scenario: Search a Responsibility
    When User clicks on Responsibilities menu option
    And User enters search criteria to search a Responsibility
    And User clicks on Search button to search Responsibility
    Then Responsibility should be displayed in search results

  @T1720110328
  Scenario: Disable a Responsibility bility
    When User clicks on Responsibilities menu option
    And User enters search criteria to search a Responsibility
    And User clicks on Search button to search Responsibility
    Then Responsibility should be displayed in search results
    When User clicks on Disable option to disable Responsibility
    And User enters search criteria to search a Responsibility
    And User clicks on Search button to search Responsibility
    Then Verify that the Responsibility is disabled

  @T1720110329
  Scenario: Enable a Responsibility
    When User clicks on Responsibilities menu option
    And User enters search criteria to search a Responsibility
    And User clicks on Search button to search Responsibility
    Then Responsibility should be displayed in search results
    When User clicks on Enable option to enable Responsibility
    And User enters search criteria to search a Responsibility
    And User clicks on Search button to search Responsibility
    Then Verify that the Responsibility is Enabled

  @T1720110326
  Scenario: Edit a Responsibility
    When User clicks on Responsibilities menu option
    And User enters search criteria to search a Responsibility
    And User clicks on Search button to search Responsibility
    Then Responsibility should be displayed in search results
    When User clicks on Edit option to edit Responsibility
    And User changes Responsibility details
    And User clicks on Save button to save Responsibility details
    Then Verify Responsibility details updated successfully


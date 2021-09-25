@Companies
Feature: Add,Edit,Enable,Disable,Export Companies records

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed

  @T1720099047
  Scenario: Add a Company
    When User clicks on Companies menu option
    And User clicks on Add button to add Company
    And User Enters required detais to add company
    And User clicks on Save button to add company
    Then Company record is created successfully

  @T1720099045
  Scenario: Search a Company
    When User clicks on Companies menu option
    And User enters search criteria to search a company
    And User clicks on Search button to search Company
    Then Company should be displayed in search results

  @T1720110336
  Scenario: Disable a Company
    When User clicks on Companies menu option
    And User enters search criteria to search a company
    And User clicks on Search button to search Company
    Then Company should be displayed in search results
    When User clicks on Disable option to disable company
    And User enters search criteria to search a company
    And User clicks on Search button to search Company
    Then Verify that the Company is disabled

  @T1720110335
  Scenario: Enable a Company
    When User clicks on Companies menu option
    And User enters search criteria to search a company
    And User clicks on Search button to search Company
    Then Company should be displayed in search results
    When User clicks on Enable option
    And User enters search criteria to search a company
    And User clicks on Search button to search Company
    Then Verify that the Company is Enabled

  @T1720099046
  Scenario: Edit a Company
    When User clicks on Companies menu option
    And User enters search criteria to search a company
    And User clicks on Search button to search Company
    Then Company should be displayed in search results
    When User clicks on Edit option to edit company details
    And User changes company details
    And User clicks on Save button to save company details
    Then Verify company details updated successfully

  @T1720110337 @Export
  Scenario: Export Company records to XML file
    When User clicks on Companies menu option
    And User clicks on Search button to search Company
    Then All companies should be displayed in search results
    When User clicks on checkbox to select all companies under search results
    And User clicks on Choose an Action drop down on Companies page
    And User selects Export as XML on Companies page
    And User clicks on Go button on Companies page
    Then Verify that the company records xml file was successfully downloaded
    And User deletes the "company_export" file

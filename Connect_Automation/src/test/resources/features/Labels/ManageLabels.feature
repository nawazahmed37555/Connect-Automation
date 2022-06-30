@Labels
Feature: Manage Labels

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed
    When User clicks on Label Management menu option
    And User clicks on Labels menu option

  @T1720096739
  Scenario: Add a label format
    When User clicks on Add button to add label format
    And User enters label format name[0] for the label format
    And User selects label format file for the label format
    And User selects Language[1] for the label format
    And User selects DPI[1] for the label format
    And User selects Company[1] for the label format
    And User selects Create Label Type option
    And User clicks on Save button to save label format details
    Then Label format[0] should be created successfully

  @T1720096736
  Scenario: Search a label format
    When User enters label format name[0] to search
    And User clicks on Search button to search label(s)
    Then Label format[0] is displayed in search results

  @T1720096737
  Scenario: Edit a label format
    When User enters label format name[0] to search
    And User clicks on Search button to search label(s)
    Then Label format[0] is displayed in search results
    And Click on Edit button edit label details
    And User enters label format name[1] for the label format
    And User selects label format file for the label format
    And User selects Language[2] for the label format
    And User selects DPI[2] for the label format
    And User selects Company[2] for the label format
    And User clicks on Save button to save label format details
    Then Label format[1] details should be saved successfully

  @T1720110372
  Scenario: Disable a label format
    When User enters label format name[1] to search
    And User clicks on Search button to search label(s)
    Then Label format[1] is displayed in search results
    And User clicks on Disable button to disable label format
    When User enters label format name[1] to search
    And User clicks on Search button to search label(s)
    Then Label format[1] is displayed in search results
    Then Label format should be disabled successfully

  @T1720110373
  Scenario: Enable a label format
    When User enters label format name[1] to search
    And User clicks on Search button to search label(s)
    Then Label format[1] is displayed in search results
    And User clicks on Enable button to Enable label format
    When User enters label format name[1] to search
    And User clicks on Search button to search label(s)
    Then Label format[1] is displayed in search results
    Then Label format should be Enabled successfully

  @T1720096738
  Scenario: Delete a label format
    When User enters label format name[1] to search
    And User clicks on Search button to search label(s)
    Then Label format[1] is displayed in search results
    And User clicks on the delete button to delete label format
    Then label format should be deleted successfully

  @T1720110374 @Export
  Scenario: Export label formats to XML file
    And User clicks on Search button to search label(s)
    Then All Label formats should be displayed in search results
    When User clicks on checkbox to select all Label formats under search results
    And User clicks on Choose an Action drop down on Label formats page
    And User selects Export as XML on Label formats page
    And User clicks on Go button on Label formats page
    Then Verify that the Label formats records xml file was successfully downloaded

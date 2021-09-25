@PLCs
Feature: Add,Search,Edit,Export,Delete PLCs

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed

  @T1720096872
  Scenario: Add a PLC
    When User clicks on Devices menu option
    And User clicks on PLCs menu option
    And User clicks on Add button to add PLC
    And User Enters required detais to add PLC
    And User clicks on Save button to add PLC
    Then Verify PLC is created successfully

  @T1720110341
  Scenario: Search a PLC
    When User clicks on Devices menu option
    And User clicks on PLCs menu option
    And User enters 'PLCsPageObjects.PLC_name[0]' to search a PLC
    And User clicks on Search button to search PLC
    Then PLC 'PLCsPageObjects.PLC_name[0]' should be displayed in search results

  @T1720096873
  Scenario: Edit a PLC
    When User clicks on Devices menu option
    And User clicks on PLCs menu option
   And User enters 'PLCsPageObjects.PLC_name[0]' to search a PLC
    And User clicks on Search button to search PLC
    Then PLC 'PLCsPageObjects.PLC_name[0]' should be displayed in search results
    When User clicks on Edit option to edit PLC
    And User changes PLC details
    And User clicks on Save button to save PLC details
    Then Verify PLC details updated successfully

  @T1720096876 @Export
  Scenario: Export PLC recods
    When User clicks on Devices menu option
    And User clicks on PLCs menu option
    And User clicks on Search button to search PLCs
    Then All PLCs should be displayed in search results
    When User clicks on checkbox to select all PLCs under search results
    And User clicks on Choose an Action drop down on PLCs page
    And User selects Export as XML on PLCs page
    And User clicks on Go button on PLCs page
    Then Verify that the PLC records xml file was successfully downloaded
    And User deletes the "plc_export" file

  @T1720096874
  Scenario: Delete PLC
    When User clicks on Devices menu option
    And User clicks on PLCs menu option
    And User enters 'PLCsPageObjects.PLC_name[1]' to search a PLC
    And User clicks on Search button to search PLC
    Then PLC 'PLCsPageObjects.PLC_name[1]' should be displayed in search results
    When User clicks on Delete option to delete PLC
    And User enters 'PLCsPageObjects.PLC_name[1]' to search a PLC
    And User clicks on Search button to search PLC
    Then Verify PLC deleted successfully

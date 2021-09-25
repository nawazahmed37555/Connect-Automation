## All the test data used in the below steps, can be found int the step definition file.

@Printers
Feature: Add,Search,Edit,Export,Delete Printers

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed

  @T1720096882
  Scenario: Add a Printer
    When User clicks on Devices menu option
    And User clicks on Printers menu option
    And User clicks on Add button to add Printer
    And User Enters Printer_name[0] on add Printer panel
    And User Enters Host_IP[0] on add Printer panel
    And User Enters Port_number[0] on add Printer panel
    And User selects device_driver[1]  on add Printer panel
    And User selects company[1]  on add Printer panel
    And User selects communication_method[1] on add Printer panel
    And User selects DPI[1] on add Printer Panel
    And User clicks on Save button to add Printer
    Then Verify Printer is created successfully

  @T1720110343
  Scenario: Search a Printer
    When User clicks on Devices menu option
    And User clicks on Printers menu option
    And User enters Printer_name[0] to search a Printer
    And User clicks on Search button to search Printer
    Then Printer[0] should be displayed in search results

  @T1720096883
  Scenario: Edit a Printer
    When User clicks on Devices menu option
    And User clicks on Printers menu option
    And User enters Printer_name[0] to search a Printer
    And User clicks on Search button to search Printer
    Then Printer[0] should be displayed in search results
    When User clicks on Edit option to edit Printer
    And User Enters Printer_name[1] on add Printer panel
    And User Enters Host_IP[1] on add Printer panel
    And User Enters Port_number[1] on add Printer panel
    And User selects device_driver[2]  on add Printer panel
    And User selects company[2]  on add Printer panel
    And User selects communication_method[3] on add Printer panel
    And User selects DPI[2] on add Printer Panel
    And User clicks on Save button to save Printer details
    Then Verify Printer details updated successfully

  @T1720096886 @Export
  Scenario: Export Printer recods
    When User clicks on Devices menu option
    And User clicks on Printers menu option
    And User clicks on Search button to search Printers
    Then All Printers should be displayed in search results
    When User clicks on checkbox to select all Printers under search results
    And User clicks on Choose an Action drop down on Printers page
    And User selects Export as XML on Printers page
    And User clicks on Go button on Printers page
    Then Verify that the Printer records xml file was successfully downloaded
    And User deletes the "printer_export" file

  @T1720096884
  Scenario: Delete Printer
    When User clicks on Devices menu option
    And User clicks on Printers menu option
    And User enters Printer_name[1] to search a Printer
    And User clicks on Search button to search Printer
   	Then Printer[1] should be displayed in search results
    When User clicks on Delete option to delete Printer
    And User enters Printer_name[1] to search a Printer
    And User clicks on Search button to search Printer
    Then Verify Printer deleted successfully

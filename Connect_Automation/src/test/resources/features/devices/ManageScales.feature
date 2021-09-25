@Scales
Feature: Add,Search,Edit,Export,Delete Scales

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed

  @T1720096877
  Scenario: Add a Scale
    When User clicks on Devices menu option
    And User clicks on Scales menu option
    And User clicks on Add button to add Scale
    And User Enters scale name 'scalesPageObjects.scale_name[0]' on add Scale panel
    And User Enters Host IP 'scalesPageObjects.hostIP[0]' on add Scale panel
    And User Enters Port number 'scalesPageObjects.port[0]' on add Scale panel
    And User selects device_driver[1]  on add Scale panel
    And User selects company[1]  on add Scale panel
    And User clicks on Save button to add Scale
    Then Verify Scale is created successfully

  @T1720110342
  Scenario: Search a Scale
    When User clicks on Devices menu option
    And User clicks on Scales menu option
    And User enters 'ScalesPageObjects.Scale_name[0]' to search a Scale
    And User clicks on Search button to search Scale
    Then Scale 'ScalesPageObjects.Scale_name[0]' should be displayed in search results

  @T1720096881
  Scenario: Edit a Scale
    When User clicks on Devices menu option
    And User clicks on Scales menu option
    And User enters 'ScalesPageObjects.Scale_name[0]' to search a Scale
    And User clicks on Search button to search Scale
    Then Scale 'ScalesPageObjects.Scale_name[0]' should be displayed in search results
    When User clicks on Edit option to edit Scale
    And User Enters scale name 'scalesPageObjects.scale_name[1]' on add Scale panel
    And User Enters Host IP 'scalesPageObjects.hostIP[1]' on add Scale panel
    And User Enters Port number 'scalesPageObjects.port[1]' on add Scale panel
    And User selects device_driver[2]  on add Scale panel
    And User selects company[2]  on add Scale panel
    And User clicks on Save button to save Scale details
    Then Verify Scale details updated successfully

  @T1720096880 @Export
  Scenario: Export Scale recods
    When User clicks on Devices menu option
    And User clicks on Scales menu option
    And User clicks on Search button to search Scales
    Then All Scales should be displayed in search results
    When User clicks on checkbox to select all Scales under search results
    And User clicks on Choose an Action drop down on Scales page
    And User selects Export as XML on Scales page
    And User clicks on Go button on Scales page
    Then Verify that the Scale records xml file was successfully downloaded
    And User deletes the "scale_export" file

  @T1720096878
  Scenario: Delete Scale
    When User clicks on Devices menu option
    And User clicks on Scales menu option
    And User enters 'ScalesPageObjects.Scale_name[1]' to search a Scale
    And User clicks on Search button to search Scale
    Then Scale 'ScalesPageObjects.Scale_name[1]' should be displayed in search results
    When User clicks on Delete option to delete Scale
    And User enters 'ScalesPageObjects.Scale_name[1]' to search a Scale
    And User clicks on Search button to search Scale
    Then Verify Scale deleted successfully

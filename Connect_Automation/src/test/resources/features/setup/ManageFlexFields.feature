## All the test data used in the below steps, can be found int the step definition file.
@FlexFields
Feature: Add,Search,Edit,Export,Delete Flex Fields

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed
    When User clicks on Setup menu option
    And User clicks on Flex Fields menu option

  @T1720095693
  Scenario: Add a Flex Field
    And User clicks on Add button to add Flex Field
    And User enters Flex_Field_name[0]	on Flex Field Details panel
    And User selects Flex_Field_namespace[1] on Flex Field Details panel
    And User selects Application[1] on Flex Field Details panel
    And User clicks on Save button to save Flex Field details
    Then Verify Flex_Field[0] is created successfully

  @T1720095696
  Scenario: Search a Flex Field
    And User enters Flex_Field_name[0] to search a Flex Field
    And User clicks on Search button to search Flex Field(s)
    Then Field with Flex_Field_name[0] should be displayed in search results

  @T1720095692
  Scenario: Edit a Flex Field
    And User enters Flex_Field_name[0] to search a Flex Field
    And User clicks on Search button to search Flex Field(s)
    Then Field with Flex_Field_name[0] should be displayed in search results
    And User clicks on Edit option to edit Flex Field
    And User enters Flex_Field_name[1]	on Flex Field Details panel
    And User selects Flex_Field_namespace[2] on Flex Field Details panel
    And User selects Application[2] on Flex Field Details panel
    And User clicks on Save button to save Flex Field details
    Then Verify Flex_Field[1] details updated successfully

  @Export @T1720110355
  Scenario: Export Field recods
    And User clicks on Search button to search Flex Field(s)
    Then All Flex Fields should be displayed in search results
    When User clicks on checkbox to select all Flex Fields under search results
    And User clicks on Choose an Action drop down on Flex Fields page
    And User selects Export as XML on Flex Fields page
    And User clicks on Go button on Flex Fields page
    Then Verify that the Flex Field records xml file was successfully downloaded
		And User deletes the "flexField_export" file
		
  @T1720095694
  Scenario: Delete Flex Field
    And User enters Flex_Field_name[1] to search a Flex Field
    And User clicks on Search button to search Flex Field(s)
    Then Field with Flex_Field_name[1] should be displayed in search results
    When User clicks on Delete option to delete Flex Field
    And User enters Flex_Field_name[1] to search a Flex Field
    And User clicks on Search button to search Flex Field(s)
    Then Verify Flex_Field[1] deleted successfully

## All the test data used in the below steps, can be found int the step definition file.
@Fields
Feature: Add,Search,Edit,Export,Delete Fields

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed
    When User clicks on Setup menu option
    And User clicks on Fields menu option

  @T1720093249
  Scenario: Add a Field
    And User clicks on Add button to add Field
    And User selects Field_namespace[1] on Field Details panel
    And User enters Field_name[0]	on Field Details panel
    And User selects Field_type[1] on Field Details panel
    And User enters Description[0] on Field Details panel
    And User enters Display_name[0] on Field Details panel
    And User selects Field_LOV_Class[1] on Field Details panel
    And User selects Field_LOV_Type[1] on Field Details panel
    And User clicks on Save button to save Field details
    Then Verify Field[0] is created successfully

  @T1720110345
  Scenario: Search a Field
    And User enters Field_name[0] to search a Field
    And User clicks on Search button to search Field
    Then Field with Field_name[0] should be displayed in search results

  @T1720093250
  Scenario: Edit a Field
    And User enters Field_name[0] to search a Field
    And User clicks on Search button to search Field
    Then Field with Field_name[0] should be displayed in search results
    And User clicks on Edit option to edit Field
    And User selects Field_namespace[2] on Field Details panel
    And User enters Field_name[1]	on Field Details panel
    And User selects Field_type[2] on Field Details panel
    And User enters Description[1] on Field Details panel
    And User enters Display_name[1] on Field Details panel
    And User selects Field_LOV_Class[1] on Field Details panel
    And User selects Field_LOV_Type[1] on Field Details panel
    And User clicks on Save button to save Field details
    Then Verify Field[1] details updated successfully
  
  Scenario: Assign  a specific responsibility to a Field
    And User enters Field_name[1] to search a Field
    And User clicks on Search button to search Field
    Then Field with Field_name[1] should be displayed in search results
    And User clicks on Edit option to edit Field
    And User clicks on the Responsibilities tab on Field Details panel
    And User selects "CLR_SUPERUSER" responsibility 
    And User clicks on Add button to assign the reponsibility to the field
    And User clicks on Save button to save Field details
    Then Verify all responsibilities are assigned to the Field
	
  Scenario: Assign  all responsibilities to a Field
    And User enters Field_name[1] to search a Field
    And User clicks on Search button to search Field
    Then Field with Field_name[1] should be displayed in search results
    And User clicks on Edit option to edit Field
    And User clicks on the Responsibilities tab on Field Details panel
    And User selects all responsibilities from the unassigned list
    And User clicks on Add button to assign the reponsibility to the field
    And User clicks on Save button to save Field details
    Then Verify all responsibilities are assigned to the Field

  @T1720093251 @Export
  Scenario: Export Field recods
    And User clicks on Search button to search Fields
    Then All Fields should be displayed in search results
    When User clicks on checkbox to select all Fields under search results
    And User clicks on Choose an Action drop down on Fields page
    And User selects Export as XML on Fields page
    And User clicks on Go button on Fields page
    Then Verify that the Field records xml file was successfully downloaded

  @T1720110344
  Scenario: Delete Field
    And User enters Field_name[1] to search a Field
    And User clicks on Search button to search Field
    Then Field with Field_name[1] should be displayed in search results
    When User clicks on Delete option to delete Field
    And User enters Field_name[1] to search a Field
    And User clicks on Search button to search Field
    Then Verify Field deleted successfully

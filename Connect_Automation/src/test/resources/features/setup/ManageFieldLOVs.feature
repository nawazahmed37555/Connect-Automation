## All the test data used in the below steps, can be found in the step definition file.
@FieldLOVs
Feature: Add,Search,Edit,Delete FieldLOVs

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed
    When User clicks on Setup menu option
    And User clicks on Field LOV Values menu option
 
  @T1720110363
  Scenario: Add a Field LOV value  
    And User clicks on Add button to add Field LOV value
    And User selects Class_name[1] on Field LOV value Details panel
    And User enters Display_Name[0] on Field LOV value Details panel
		And User enters Field_LOV_class_name[0] on Field LOV value Details panel
    And User clicks on Save button to save Field LOV value details
    Then Verify Field LOV value with Display_name[0] is created successfully

  @T1720110362
  Scenario: Search a Field LOV value
     And User enters Display_Name[0] to search a Field LOV value
    And User clicks on Search button to search Field LOV value(s)
    Then Field LOV value with Display_Name[0] should be displayed in search results

  @T1720110364
  Scenario: Edit a Field LOV value
      And User enters Display_Name[0] to search a Field LOV value
    And User clicks on Search button to search Field LOV value(s)
	  Then Field LOV value with Display_Name[0] should be displayed in search results
    And User clicks on Edit option to edit Field LOV value
       And User selects Class_name[2] on Field LOV value Details panel
    And User enters Display_Name[1] on Field LOV value Details panel
		And User enters Field_LOV_class_name[1] on Field LOV value Details panel
    And User clicks on Save button to save Field LOV value details
    Then Verify Field LOV value with Display_Name[1] details updated successfully

  @T1720110365
  Scenario: Delete Field LOV value

    And User enters Display_Name[1] to search a Field LOV value
    And User clicks on Search button to search Field LOV value(s)
 		Then Field LOV value with Display_Name[1] should be displayed in search results
    When User clicks on Delete option to delete Field LOV value
    And User enters Display_Name[1] to search a Field LOV value
    And User clicks on Search button to search Field LOV value(s)
    Then Verify Field LOV value with Display_Name[1] deleted successfully

  
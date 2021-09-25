## All the test data used in the below steps, can be found int the step definition file.
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
 
  @T1720095699
  Scenario: Add a Field LOV value
   
    And User clicks on Add button to add Field LOV value
    And User selects Flex_Field_name[0] on Field LOV value Details panel
    And User selects Field_name[1] on Field LOV value Details panel
    And User selects Index[1] on Field LOV value Details panel
    And User enters LOV_Query[0] on Field LOV value Details panel
    And User clicks on Save button to save Field LOV value details
    Then Verify Field LOV value with Flex_Field_name[0] is created successfully

  @T1720095697
  Scenario: Search a Field LOV value
     And User enters Flex_Field_name[0] to search a Field LOV value
    And User clicks on Search button to search Field LOV value(s)
    Then Field LOV value with Flex_Field_name[0] should be displayed in search results

  @T1720095698
  Scenario: Edit a Field LOV value
      And User enters Flex_Field_name[0] to search a Field LOV value
    And User clicks on Search button to search Field LOV value(s)
	  Then Field LOV value with Flex_Field_name[0] should be displayed in search results
    And User clicks on Edit option to edit Field LOV value
    And User selects Flex_Field_name[1] on Field LOV value Details panel
    And User selects Field_name[2] on Field LOV value Details panel
    And User selects Index[2] on Field LOV value Details panel
    And User enters LOV_Query[1] on Field LOV value Details panel
    And User clicks on Save button to save Field LOV value details
    Then Verify Field LOV value with Flex_Field_name[1] details updated successfully

  @T1720095700
  Scenario: Delete Field LOV value

    And User enters Flex_Field_name[1] to search a Field LOV value
    And User clicks on Search button to search Field LOV value(s)
 		Then Field LOV value with Flex_Field_name[1] should be displayed in search results
    When User clicks on Delete option to delete Field LOV value
    And User enters Flex_Field_name[1] to search a Field LOV value
    And User clicks on Search button to search Field LOV value(s)
    Then Verify Field LOV value with Flex_Field_name[0] deleted successfully

  
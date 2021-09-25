## All the test data used in the below steps, can be found int the step definition file.
@Attributes
Feature: Add,Search,Edit,Delete Attributes

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed
    When User clicks on Setup menu option

  Scenario: Add  Flex Fields for testing Attributes section 
    And User clicks on Flex Fields menu option
    And User clicks on Add button to add Flex Field
    And User enters Flex_Field_name[0]	on Flex Field Details panel
    And User selects Flex_Field_namespace[1] on Flex Field Details panel
    And User selects Application[1] on Flex Field Details panel
    And User clicks on Save button to save Flex Field details
    Then Verify Flex_Field[0] is created successfully
   # And User clicks on Flex Fields menu option
    And User clicks on Add button to add Flex Field
    And User enters Flex_Field_name[1]	on Flex Field Details panel
    And User selects Flex_Field_namespace[2] on Flex Field Details panel
    And User selects Application[2] on Flex Field Details panel
    And User clicks on Save button to save Flex Field details
    Then Verify Flex_Field[1] is created successfully

  @T1720095699
  Scenario: Add a Attribute
    And User clicks on Attributes menu option
    And User clicks on Add button to add Attribute
    And User selects Flex_Field_name[0] on Attribute Details panel
    And User selects Field_name[1] on Attribute Details panel
    And User selects Index[1] on Attribute Details panel
    And User enters LOV_Query[0] on Attribute Details panel
    And User clicks on Save button to save Attribute details
    Then Verify Attribute with Flex_Field_name[0] is created successfully

  @T1720095697
  Scenario: Search a Attribute
    And User clicks on Attributes menu option
    And User enters Flex_Field_name[0] to search a Attribute
    And User clicks on Search button to search Attribute(s)
    Then Attribute with Flex_Field_name[0] should be displayed in search results

  @T1720095698
  Scenario: Edit a Attribute
    And User clicks on Attributes menu option
    And User enters Flex_Field_name[0] to search a Attribute
    And User clicks on Search button to search Attribute(s)
	  Then Attribute with Flex_Field_name[0] should be displayed in search results
    And User clicks on Edit option to edit Attribute
    And User selects Flex_Field_name[1] on Attribute Details panel
    And User selects Field_name[2] on Attribute Details panel
    And User selects Index[2] on Attribute Details panel
    And User enters LOV_Query[1] on Attribute Details panel
    And User clicks on Save button to save Attribute details
    Then Verify Attribute with Flex_Field_name[1] details updated successfully

  @T1720095700
  Scenario: Delete Attribute
    And User clicks on Attributes menu option
    And User enters Flex_Field_name[1] to search a Attribute
    And User clicks on Search button to search Attribute(s)
 		Then Attribute with Flex_Field_name[1] should be displayed in search results
    When User clicks on Delete option to delete Attribute
    And User enters Flex_Field_name[1] to search a Attribute
    And User clicks on Search button to search Attribute(s)
    Then Verify Attribute with Flex_Field_name[0] deleted successfully

  Scenario: Delete Flex Fields created for testing Attributes section
    And User clicks on Flex Fields menu option
    And User enters Flex_Field_name[0] to search a Flex Field
    And User clicks on Search button to search Flex Field(s)
    Then Field with Flex_Field_name[0] should be displayed in search results
    When User clicks on Delete option to delete Flex Field
    And User enters Flex_Field_name[0] to search a Flex Field
    And User clicks on Search button to search Flex Field(s)
    Then Verify Flex_Field[0] deleted successfully
     And User enters Flex_Field_name[1] to search a Flex Field
    And User clicks on Search button to search Flex Field(s)
    Then Field with Flex_Field_name[1] should be displayed in search results
    When User clicks on Delete option to delete Flex Field
    And User enters Flex_Field_name[1] to search a Flex Field
    And User clicks on Search button to search Flex Field(s)
    Then Verify Flex_Field[1] deleted successfully

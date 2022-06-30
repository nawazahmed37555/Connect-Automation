@RuleDefinitions
Feature: Manage Rule Definitions

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed
    When User clicks on Rules menu option
    And User clicks on Rule Definitions menu option

  @T1720110377
  Scenario: Add a rule Definition
    When User clicks on Add button to add rule definition
    And User enters rule difinition name[0]
    And User selects rule type for the rule definition[1]
    And User selects Company for the rule definition[1]
    And User clicks on Save button to save rule definition
    Then Verify that the rule definition[0] is created successfully

  @T1720110378
  Scenario: Search a Rule Definition
    When User enters rule difinition name[0] to search
    And User clicks on Search button to search rule definition(s)
    Then rule difinition[0] should be displayed in search results

  @T1720110379
  Scenario: Edit Rule Definition
    When User enters rule difinition name[0] to search
    And User clicks on Search button to search rule definition(s)
    Then rule difinition[0] should be displayed in search results
    When User clicks on Edit option to edit rule definition
    And User enters rule difinition name[1]
    And User selects rule type for the rule definition[2]
    And User selects Company for the rule definition[2]
    And User clicks on Save button to save rule definition
    Then Verify that the rule definition[1] info is updated successfully
    And User enters rule difinition name[0]
    And User selects rule type for the rule definition[1]
    And User selects Company for the rule definition[1]
    And User clicks on Save button to save rule definition

  @T1720110380
  Scenario: Add Rule to the rule definition
    When User enters rule difinition name[0] to search
    And User clicks on Search button to search rule definition(s)
    Then rule difinition[0] should be displayed in search results
    And User click on Add rule option to add rule instance
    And User enters rule instance name[0] on add rule panel
    And User selects Company for the rule instance[1]
    And User enters Order number as "1"
    And User clicks on save button to save the rule instance details
    Then Rule instance[0] should be added successfully

  @T1720110381
  Scenario: View Rule for the rule definition
    When User enters rule difinition name[0] to search
    And User clicks on Search button to search rule definition(s)
    Then rule difinition[0] should be displayed in search results
		And User click on View rule option to add rule instance
		Then Rule instance[0] should be displayed in the search results
  
  @T1720110383
  Scenario: Delete Rule Definitions
    When User enters rule difinition name[0] to search
    And User clicks on Search button to search rule definition(s)
    Then rule difinition[0] should be displayed in search results
		And User clicks on delete option to delete the rule definition
		When User enters rule difinition name[0] to search
    And User clicks on Search button to search rule definition(s)
		Then Rule definition should be deleted successfully

		
		
		
  @T1720110382 @Export
  Scenario: Export Rule Definitions to XML file
  And User clicks on Search button to search rule definition(s)
    Then All rule definitions should be displayed in search results
    When User clicks on checkbox to select all rule definitions under search results
    And User clicks on Choose an Action drop down
    And User selects Export as XML page
    And User clicks on Go button
    Then Verify that the rule definition records xml file was successfully downloaded
  
  
@RuleInstances
Feature: Manage Rule Instances

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed
    When User clicks on Rules menu option
    And User clicks on Rule Instances menu option

  Scenario: Add a rule Definition
    When User clicks on Rule Definitions menu option
    When User clicks on Add button to add rule definition
    And User enters rule difinition name[0]
    And User selects rule type for the rule definition[1]
    And User selects Company for the rule definition[1]
    And User clicks on Save button to save rule definition
    Then Verify that the rule definition[0] is created successfully

  @T1720110384
  Scenario: Add a Rule Instance
    When User clicks on Add button
		And User selects Rule definition "EngineeringQuality : Automated_rule1" to create rule instance
		And User clicks on Save button
    And User enters rule instance name[0] on add rule panel
    And User selects Company for the rule instance[1]
    And User enters Order number as "1"
    And User clicks on Save button
    Then Rule instance[0] should be added successfully

  @T1720110385
  Scenario: Search for Rule Instances
    When User enters rule instance name[0] to search
    And User clicks on Search button
    Then Rule instance[0] should be displayed in search results


  @T1720110386
  Scenario: Edit Rule Instance
  When User enters rule instance name[0] to search
    And User clicks on Search button
    Then Rule instance[0] should be displayed in search results
    And User clicks on Edit button to edit rule instance
		And User enters rule instance name[1] on add rule panel
    And User selects Company for the rule instance[2]
    And User enters Order number as "2"
    And User clicks on Save button
    

  @T1720110388
  Scenario: Disable rule instance
  	When User enters rule instance name[1] to search
    And User clicks on Search button
    Then Rule instance[1] should be displayed in search results
		And User clicks on the checkbox to select the rule instance
		And User selects Disable option to disable rule instance
		And User clicks on Go button
		Then Verify that the rule instance is disabled successfully
	
  @T1720110389
  Scenario: Enable Rule instance
		When User enters rule instance name[1] to search
    And User clicks on Search button
    Then Rule instance[1] should be displayed in search results
		And User clicks on the checkbox to select the rule instance
		And User selects Enable option to enable rule instance
		And User clicks on Go button
		Then Verify that the rule instance is enabled successfully
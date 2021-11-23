## All the test data used in the below steps, can be found in the step definition file.
@SavedSearches
Feature: Add,Search,Edit,Delete SavedSearches

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed
    When User clicks on Setup menu option
    And User clicks on Saved Search menu option

  @T1720110366
  Scenario: Search a Saved Search
	    And User clicks on Search button to search Saved Search(s)
    Then All Saved searches should be displayed in search results
    And User copies the Saved_Search_Name[0] from the search results
    And User enters Saved_Search_Name[0] to search a Saved Search
    And User clicks on Search button to search Saved Search(s)
    Then Saved_Search_Name[0] should be displayed in search results

  @T1720110367
  Scenario: Edit a Saved Search
		When User clicks on Search button to search Saved Search(s)
    Then All Saved searches should be displayed in search results
    And User copies the Saved_Search_Name[0] from the search results
    When User enters Saved_Search_Name[0] to search a Saved Search
    And User clicks on Search button to search Saved Search(s)
    Then Saved_Search_Name[0] should be displayed in search results
    And User clicks on Edit option to edit Saved Search
    And User changes Saved_Search_Name[1]
    And User clicks on Save button to save Saved Search details
    Then Verify Saved Search[1] details updated successfully
    And User enters Saved_Search_Name[1] to search a Saved Search
    And User clicks on Search button to search Saved Search(s)
    Then Saved_Search_Name[1] should be displayed in search results
    And User clicks on Edit option to edit Saved Search
    And User changes Saved_Search_Name[0]
    And User clicks on Save button to save Saved Search details
    Then Verify Saved Search[0] details updated successfully

  

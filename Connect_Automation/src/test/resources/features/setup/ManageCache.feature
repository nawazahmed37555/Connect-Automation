## All the test data used in the below steps, can be found in the step definition file.
@Caches
Feature: Manage Caches

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed
    When User clicks on Setup menu option
    And User clicks on Caches menu option
 
  @T1720110369
  Scenario: View a Cache  
    And User clicks on View button to view Cache
    And Navigate to Cache View window
    And User clicks on Close button to close the Cache details window
    Then Cache details window should be closed
  
  @T1720110371  
    Scenario: Delete a Cache
    And User clicks on Delete button to delete Cache
    Then Verify that the cache got deleted
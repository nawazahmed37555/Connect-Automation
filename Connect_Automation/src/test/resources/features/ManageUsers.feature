@Users
Feature: Add,Search,Edit,Enable,Disable,Export Users records

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed

  @T1720099023
  Scenario: Add a User
    When User clicks on Users menu option
    And User clicks on Add button to add User
    And User Enters required detais to add User[0]
    And User clicks on Save button to add User
    Then User record is created successfully

  @T1720099011
  Scenario: Search a User
    When User clicks on Users menu option
    And User enters search criteria to search a User
    And User clicks on Search button to search User
    Then User should be displayed in search results
    
  
  @T1720099024
  Scenario: Disable a User
    When User clicks on Users menu option
    And User enters search criteria to search a User
     And User clicks on Search button to search User
    Then User should be displayed in search results
    When User clicks on Disable option to disable User
    And User enters search criteria to search a User
     And User clicks on Search button to search User
    Then Verify that the User is disabled

  @T1720099028
  Scenario: Enable a User
    When User clicks on Users menu option
    And User enters search criteria to search a User
    And User clicks on Search button to search User
    Then User should be displayed in search results
    When User clicks on Enable option to enable user
    And User enters search criteria to search a User
    And User clicks on Search button to search User
    Then Verify that the User is Enabled

   @T1720099012
   Scenario: Edit a User
    When User clicks on Users menu option
    And User enters search criteria to search a User
    And User clicks on Search button to search User
    Then User should be displayed in search results
    When User clicks on Edit option to edit user
    And User changes user[1] details
    And User clicks on Save button to save User details
     Then Verify user[1] details updated successfully
    
  @C41526346 @Export
  Scenario: Export User records to XML file
    When User clicks on Users menu option
    And User clicks on Search button to search User
    Then All Users should be displayed in search results
    When User clicks on checkbox to select all users under search results
    And User clicks on Choose an Action drop down on Users page
    And User selects Export as XML option on Users page
    And User clicks on Go button on Users page
    Then Verify that the user records xml file was successfully downloaded 
    And User deletes the "user_export" file

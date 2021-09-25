@Roles
Feature: Add,Search,Edit,Enable,Disable Roles

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed

  @T1720093239
  Scenario: Add a Role
    When User clicks on Roles menu option
    And User clicks on Add button to add Role
    And User Enters required detais to add Role
    And User clicks on Save button to add Role
    Then Verify Role is created successfully

  @C41526351
  Scenario: Search a Role
    When User clicks on Roles menu option
    And User enters search criteria to search a Role
    And User clicks on Search button to search Role
    Then Role should be displayed in search results

  @T1720110339
  Scenario: Disable a Role
    When User clicks on Roles menu option
    And User enters search criteria to search a Role
    And User clicks on Search button to search Role
    Then Role should be displayed in search results
    When User clicks on Disable option to disable Role
    And User enters search criteria to search a Role
    And User clicks on Search button to search Role
    Then Verify that the Role is disabled

  @T1720110338
  Scenario: Enable a Role
    When User clicks on Roles menu option
    And User enters search criteria to search a Role
    And User clicks on Search button to search Role
    Then Role should be displayed in search results
    When User clicks on Enable option to enable Role
    And User enters search criteria to search a Role
    And User clicks on Search button to search Role
    Then Verify that the Role is Enabled

    
    
    @T1720093241
    Scenario: Grouping multiple responsibilities into a Role
   	When User clicks on Roles menu option
    And User enters search criteria to search a Role
    And User clicks on Search button to search Role
    Then Role should be displayed in search results
    When User clicks on Edit option to edit Role
    And User clicks on the Responsibilities tab under edit Role panel
    And User selects responsibilities to assign to the Role
    And User clicks on Add button to assign responsibilities to the Role
   And User clicks on Save button to save Role details
    Then Responsibilities should be assigned to the Role
    
     @T1720093240
  Scenario: Edit a Role
  	When User clicks on Roles menu option
    And User enters search criteria to search a Role
    And User clicks on Search button to search Role
    Then Role should be displayed in search results
    When User clicks on Edit option to edit Role
    And User changes Role details
    And User clicks on Save button to save Role details
    Then Verify Role details updated successfully



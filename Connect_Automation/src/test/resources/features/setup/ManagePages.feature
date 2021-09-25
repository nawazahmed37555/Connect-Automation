## All the test data used in the below steps, can be found int the step definition file.
@Pages
Feature: Add,Search,Edit,Export,Delete Pages

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed
    When User clicks on Setup menu option
    And User clicks on Pages menu option

  @T1720110331
  Scenario: Add a Page
    And User clicks on Add button to add Page
    And User enters Page_name[0] on Page Details panel
    And User enters Description[0] on Page Details panel
    And User selects Application[1] on Page Details panel
    And User clicks on Save button to save Page details
    Then Verify Page with Page_name[0] is created successfully

  @T1720110349
  Scenario: Search a Page
    And User enters Page_name[0] to search a Page
    And User clicks on Search button to search Page
    Then Page with Page_name[0] should be displayed in search results

  @T1720110330
  Scenario: Edit a Page
    And User enters Page_name[0] to search a Page
    And User clicks on Search button to search Page
    Then Page with Page_name[0] should be displayed in search results
    And User clicks on Edit option to edit Page
    And User enters Page_name[1] on Page Details panel
    And User enters Description[1] on Page Details panel
    And User selects Application[2] on Page Details panel
    And User clicks on Save button to save Page details
    Then Verify Page[1] details updated successfully
    
  @C41527170
  Scenario: Assign  a specific responsibility to a Page
    And User enters Page_name[1] to search a Page
    And User clicks on Search button to search Page
    Then Page with Page_name[1] should be displayed in search results
    And User clicks on Edit option to edit Page
    And User clicks on the Responsibilities tab on Page Details panel
    And User selects responsibility[2] to assign to the Page
    And User clicks on Add button to assign the reponsibility to the Page
    And User clicks on Save button to save Page details
    Then Verify responsibilities are assigned to the Page
    
    @C41527171
  Scenario: Assign  a specific Namespace to a Page
    And User enters Page_name[1] to search a Page
    And User clicks on Search button to search Page
    Then Page with Page_name[1] should be displayed in search results
    And User clicks on Edit option to edit Page
    And User clicks on the Namespcae tab on Page Details panel
    And User selects Namespace[0] to assign to the Page
    And User clicks on Add button to assign the Namespace to the Page
    And User clicks on Save button to save Page details
    Then Verify Namespaces are assigned to the Page

		
  @T1720110350 @Export
  Scenario: Export Page recods
    And User clicks on Search button to search Pages
    Then All Pages should be displayed in search results
    When User clicks on checkbox to select all Pages under search results
    And User clicks on Choose an Action drop down on Pages page
    And User selects Export as XML on Pages page
    And User clicks on Go button on Pages page
    Then Verify that the Page records xml file was successfully downloaded

  @T1720110332
  Scenario: Delete Page
    And User enters Page_name[1] to search a Page
    And User clicks on Search button to search Page
    Then Page with Page_name[1] should be displayed in search results
    When User clicks on Delete option to delete Page
    And User enters Page_name[1] to search a Page
    And User clicks on Search button to search Page
    Then Verify Page deleted successfully

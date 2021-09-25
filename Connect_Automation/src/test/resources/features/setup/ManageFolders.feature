## All the test data used in the below steps, can be found int the step definition file.
@Folders
Feature: Add,Search,Edit,Export,Delete Folders

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed
    When User clicks on Setup menu option
    And User clicks on Folders menu option

  @T1720093233
  Scenario: Add a Folder
    And User clicks on Add button to add Folder
    And User enters Folder_name[0] on Folder Details panel
    And User selects Application_Name[1] on Folder Details panel
    And User selects Page_Name[1] on Folder Details panel
    And User selects a Namespace[1] on Folder Details panel
    And User selects Field[1] on Folder Details panel
    And User clicks on Assign button to assign fields to the Folder
    And User clicks on Save button to save Folder details
    Then Verify Folder with Folder_name[0] is created successfully

  @T1720093234
  Scenario: Search a Folder
    And User enters Folder_name[0] to search a Folder
    And User clicks on Search button to search Folder
    Then Folder with Folder_name[0] should be displayed in search results
  
   @T1720093235
  Scenario: Verify folder is seen in Endeavour
    Given User Navigates to Endeavour URL
    And Endeavour Home Page is displayed
    And User clicks on Accounts Payable menu option
    And User clicks on Search Invoices menu option
    And User clicks on Search folder dropdown
    Then Folder with Folder_name[0] should be displayed in the Search folder dropdown 
   
    

  @T1720110346
  Scenario: Edit a Folder
    And User enters Folder_name[0] to search a Folder
    And User clicks on Search button to search Folder
    Then Folder with Folder_name[0] should be displayed in search results
    And User clicks on Edit option to edit Folder
    And User enters Folder_name[1] on Folder Details panel
    And User selects Application_Name[2] on Folder Details panel
    And User selects Page_Name[1] on Folder Details panel
    And User selects a Namespace[2] on Folder Details panel
    And User selects Field[2] on Folder Details panel
    And User clicks on Assign button to assign fields to the Folder
    And User clicks on Save button to save Folder details
    Then Verify Folder[1] details updated successfully

    
  @C41527160
  Scenario: Assign a Buyer company to a Folder
    And User enters Folder_name[1] to search a Folder
    And User clicks on Search button to search Folder
    Then Folder with Folder_name[1] should be displayed in search results
    And User clicks on Edit option to edit Folder
    And User clicks on Buyer tab on Folder Details panel
    And User selects a Buyer_company[0] to assign to the Folder
    And User selects Buyer_User[0] to assign to the folder
    And User clicks on assign button to assign the Buyer User to the folder
    And User clicks on Save button to save Folder details
    Then Buyer_User[0] should be assigned to the folder

  @C41527159
  Scenario: Assign a Supplier company to  a Folder
    And User enters Folder_name[1] to search a Folder
    And User clicks on Search button to search Folder
    Then Folder with Folder_name[1] should be displayed in search results
    And User clicks on Edit option to edit Folder
    And User clicks on Supplier tab on Folder Details panel
    And User selects a supplier_company[0] to assign to the Folder
    And User selects supplier_User[0] to assign to the folder
    And User clicks on assign button to assign the supplier user to the folder
    And User clicks on Save button to save Folder details
    Then Supplier_user[0] should be assigned to the folder

  Scenario: Copy folder
   And User enters Folder_name[1] to search a Folder
    And User clicks on Search button to search Folder
    Then Folder with Folder_name[1] should be displayed in search results
    And User clicks on Copy option to copy Folder
    Then Verify that a copy of the folder[1] is created successfully

  @T1720110351 @Export
  Scenario: Export Folder recods
    And User clicks on Search button to search Folders
    Then All Folders should be displayed in search results
    When User clicks on checkbox to select all Folders under search results
    And User clicks on Choose an Action drop down on Folders page
    And User selects Export as XML on Folders page
    And User clicks on Go button on Folders page
    Then Verify that the Folder records xml file was successfully downloaded

  @T1720110348
  Scenario: Delete Folder
    And User enters Folder_name[1] to search a Folder
    And User clicks on Search button to search Folder
    Then Folder with Folder_name[1] should be displayed in search results
    When User clicks on Delete option to delete Folder
    And User enters Folder_name[1] to search a Folder
    And User clicks on Search button to search Folder
    Then Verify Folder[1] deleted successfully
    
    Scenario: Delete copy of the Folder
    And User enters Folder_name[2] to search a Folder
    And User clicks on Search button to search Folder
    Then Folder with Folder_name[2] should be displayed in search results
    When User clicks on Delete option to delete Folder
    And User enters Folder_name[2] to search a Folder
    And User clicks on Search button to search Folder
    Then Verify Folder[2] deleted successfully

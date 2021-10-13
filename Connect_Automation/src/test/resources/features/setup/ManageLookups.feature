## All the test data used in the below steps, can be found int the step definition file.
@Lookups
Feature: Add,Search,Edit,Export,Delete Lookups

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed
    When User clicks on Setup menu option
    And User clicks on Lookups menu option

  @T1720110353
  Scenario: Add a Lookup
    And User clicks on Add button to add Lookup
    And User selects Category1 on Lookup Details panel
      | Category1 | Connect |
    And User selects Category2 on Lookup Details panel
      | Category2 | MAX_ROWS |
    And User enters Value on Lookup Details panel
      | Value | 1 |
    And User clicks on Save button to save Lookup details
    And User selects Category1 on Lookup Search panel
      | Category1 | Connect |
    And User selects Category2 on Lookup Search panel
      | Category2 | MAX_ROWS |
    And User enters Value on Lookup Search panel
      | Value | 1 |
    And User clicks on Search button to search Lookup
    Then Lookup should be displayed in search results
      | Category1 | Connect  |
      | Category2 | MAX_ROWS |
      | Value     |        1 |

  @T1720110352
  Scenario: Search a Lookup
    Given User navigates to the Lookup Search panel
    And User selects Category1 on Lookup Search panel
      | Category1 | Connect |
    And User selects Category2 on Lookup Search panel
      | Category2 | MAX_ROWS |
    And User enters Value on Lookup Search panel
      | Value | 1 |
    And User clicks on Search button to search Lookup
    Then Lookup should be displayed in search results
      | Category1 | Connect  |
      | Category2 | MAX_ROWS |
      | Value     |        1 |

  @C41527263
  Scenario: Edit a Lookup
    Given User navigates to the Lookup Search panel
    And User selects Category1 on Lookup Search panel
      | Category1 | Endeavour |
    And User selects Category2 on Lookup Search panel
      | Category2 | MAX_ROWS |
    And User enters Value on Lookup Search panel
      | Value | 10000 |
    And User clicks on Search button to search Lookup
    Then Lookup should be displayed in search results
      | Category1 | Endeavour |
      | Category2 | MAX_ROWS  |
      | Value     |     10000 |
    And User clicks on Edit option to edit Lookup
    And User selects Category1 on Lookup Details panel
      | Category1 | Endeavour |
    And User selects Category2 on Lookup Details panel
      | Category2 | MAX_ROWS |
    And User enters Value on Lookup Details panel
      | Value | 1 |
    And User clicks on Save button to save Lookup details
    Then Verify Lookup details updated successfully
      | Category1 | Endeavour |
      | Category2 | MAX_ROWS  |
      | Value     |         1 |

  @T1720095707
  Scenario: Verify Lookup functions properly
    Given User Navigates to Endeavour URL
    Then Endeavour Home Page is displayed
    When User clicks on Purchase Orders menu option
    And User clicks on Search Orders menu option
    And User clicks on Search button to search all purchase orders
    Then Total search results should be as per the lookup
      | Total Search Results | 1 |
      
    Scenario: Reset the Lookup details
    Given User navigates to the Lookup Search panel
    And User selects Category1 on Lookup Search panel
      | Category1 | Endeavour |
    And User selects Category2 on Lookup Search panel
      | Category2 | MAX_ROWS |
    And User enters Value on Lookup Search panel
      | Value | 1 |
    And User clicks on Search button to search Lookup
    Then Lookup should be displayed in search results
      | Category1 | Endeavour |
      | Category2 | MAX_ROWS  |
      | Value     |     1 |
    And User clicks on Edit option to edit Lookup
    And User selects Category1 on Lookup Details panel
      | Category1 | Endeavour |
    And User selects Category2 on Lookup Details panel
      | Category2 | MAX_ROWS |
    And User enters Value on Lookup Details panel
      | Value | 10000 |
    And User clicks on Save button to save Lookup details
    Then Verify Lookup details updated successfully
      | Category1 | Endeavour |
      | Category2 | MAX_ROWS  |
      | Value     |10000 |   

  @T1720095706
  Scenario: Disable a Lookup
    Given User navigates to the Lookup Search panel
    And User selects Category1 on Lookup Search panel
      | Category1 | Connect |
    And User selects Category2 on Lookup Search panel
      | Category2 | MAX_ROWS |
    And User enters Value on Lookup Search panel
      | Value | 1 |
    And User clicks on Search button to search Lookup
    Then Lookup should be displayed in search results
      | Category1 | Connect  |
      | Category2 | MAX_ROWS |
      | Value     |        1 |
    And User clicks on Disable option to disable Lookup
    And User selects Category1 on Lookup Search panel
      | Category1 | Connect |
    And User selects Category2 on Lookup Search panel
      | Category2 | MAX_ROWS |
    And User enters Value on Lookup Search panel
      | Value | 1 |
    And User clicks on Search button to search Lookup
    Then Lookup should be displayed in search results
      | Category1 | Connect  |
      | Category2 | MAX_ROWS |
      | Value     |        1 |
    Then Lookup should be disabled
      
  @T1720095705
  Scenario: Enable a Lookup
    Given User navigates to the Lookup Search panel
    And User selects Category1 on Lookup Search panel
      | Category1 | Connect |
    And User selects Category2 on Lookup Search panel
      | Category2 | MAX_ROWS |
    And User enters Value on Lookup Search panel
      | Value | 1 |
    And User clicks on Search button to search Lookup
    Then Lookup should be displayed in search results
      | Category1 | Connect  |
      | Category2 | MAX_ROWS |
      | Value     |        1 |
    And User clicks on Enable option to enable Lookup
     And User selects Category1 on Lookup Search panel
      | Category1 | Connect |
    And User selects Category2 on Lookup Search panel
      | Category2 | MAX_ROWS |
    And User enters Value on Lookup Search panel
      | Value | 1 |
    And User clicks on Search button to search Lookup
    Then Lookup should be displayed in search results
      | Category1 | Connect  |
      | Category2 | MAX_ROWS |
      | Value     |        1 |
    Then Lookup should be Enabled


  @T1720110354
  Scenario: Delete Lookup
   Given User navigates to the Lookup Search panel
    And User selects Category1 on Lookup Search panel
      | Category1 | Connect |
    And User selects Category2 on Lookup Search panel
      | Category2 | MAX_ROWS |
    And User enters Value on Lookup Search panel
      | Value | 1 |
    And User clicks on Search button to search Lookup
    Then Lookup should be displayed in search results
      | Category1 | Connect  |
      | Category2 | MAX_ROWS |
      | Value     |        1 |
    And User clicks on Delete option to delete Lookup
    And User selects Category1 on Lookup Search panel
      | Category1 | Connect |
    And User selects Category2 on Lookup Search panel
      | Category2 | MAX_ROWS |
    And User enters Value on Lookup Search panel
      | Value | 1 |
    Then Lookup should be Deleted

			@Export
  Scenario: Export Lookup records to XML File
    And User clicks on Search button to search Lookups
    Then All Lookups should be displayed in search results
    When User clicks on checkbox to select all Lookups under search results
    And User clicks on Choose an Action drop down on Lookups page
    And User selects Export as XML on Lookups page
    And User clicks on Go button on Lookups page
    Then Verify that the Lookups records xml file was successfully downloaded
    And User deletes the "lookup_export" file


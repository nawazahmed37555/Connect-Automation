## All the test data used in the below steps, can be found int the step definition file.
@ImportXMLData
Feature: Add,Search,Edit,Export,Delete Pages

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed

  Scenario: Import Carousels Data to create new Records
    When User clicks on Devices menu option
    And User clicks on Carousels menu option
    And User clicks on Add button to add Carousel
    And User Enters required detais to add Carousel[0]
    And User clicks on Save button to add Carousel
    Then Verify Carousel is created successfully
    And User clicks on Search button to search Carousels
    Then All Carousels should be displayed in search results
    When User clicks on checkbox to select all Carousels under search results
    And User clicks on Choose an Action drop down on Carousels page
    And User selects Export as XML on Carousels page
    And User clicks on Go button on Carousels page
    Then Verify that the Carousel records xml file was successfully downloaded
    And User enters carousel_name[0] to search a Carousel
    And User clicks on Search button to search Carousel
    Then Carousel carousel_name[0] should be displayed in search results
    When User clicks on Delete option to delete Carousel
    And User enters carousel_name[0] to search a Carousel
    And User clicks on Search button to search Carousel
    Then Verify Carousel deleted successfully
    When User clicks on Setup menu option
    When User clicks on Import XML Data menu option
    And User selects file to import on Import XML Data page
      | FileName | carousel_export |
    And User clicks on Load button on Import XML Data page
    And User unchecks Update_matched_records checkbox
    And User clicks on Import button on Import XML Data page
    Then Verify that the new record was created successfully
    When User clicks on Devices menu option
    And User clicks on Carousels menu option
    And User enters carousel_name[0] to search a Carousel
    And User clicks on Search button to search Carousel
    Then Carousel carousel_name[0] should be displayed in search results
    When User clicks on Delete option to delete Carousel
    And User enters carousel_name[0] to search a Carousel
    And User clicks on Search button to search Carousel
    Then Verify Carousel deleted successfully
    And User deletes the "carousel_export" file

  Scenario: Import Carousels Data to Update Matched Records
    When User clicks on Devices menu option
    And User clicks on Carousels menu option
    And User clicks on Add button to add Carousel
    And User Enters required detais to add Carousel[0]
    And User clicks on Save button to add Carousel
    Then Verify Carousel is created successfully
    And User clicks on Search button to search Carousels
    Then All Carousels should be displayed in search results
    When User clicks on checkbox to select all Carousels under search results
    And User clicks on Choose an Action drop down on Carousels page
    And User selects Export as XML on Carousels page
    And User clicks on Go button on Carousels page
    Then Verify that the Carousel records xml file was successfully downloaded
    When User clicks on Setup menu option
    When User clicks on Import XML Data menu option
    And User selects file to import on Import XML Data page
      | FileName | carousel_export |
    And User clicks on Load button on Import XML Data page
    And User checks Update_matched_records checkbox
    And User clicks on Import button on Import XML Data page
    Then Verify that the records were updated successfully
    When User clicks on Devices menu option
    And User clicks on Carousels menu option
    And User enters carousel_name[0] to search a Carousel
    And User clicks on Search button to search Carousel
    Then Carousel carousel_name[0] should be displayed in search results
    When User clicks on Delete option to delete Carousel
    And User enters carousel_name[0] to search a Carousel
    And User clicks on Search button to search Carousel
    Then Verify Carousel deleted successfully
    And User deletes the "carousel_export" file

  Scenario: Import Lookups Data to create new lookup Record
    When User clicks on Setup menu option
    And User clicks on Lookups menu option
    And User clicks on Add button to add Lookup
    And User selects Category1 on Lookup Details panel
      | Category1 | Connect |
    And User selects Category2 on Lookup Details panel
      | Category2 | MAX_ROWS |
    And User enters Value on Lookup Details panel
      | Value | 1 |
    And User clicks on Save button to save Lookup details
    Given User navigates to the Lookup Search panel
    And User clicks on Search button to search Lookups
    Then All Lookups should be displayed in search results
    When User clicks on checkbox to select all Lookups under search results
    And User clicks on Choose an Action drop down on Lookups page
    And User selects Export as XML on Lookups page
    And User clicks on Go button on Lookups page
    Then Verify that the Lookups records xml file was successfully downloaded
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
    When User clicks on Import XML Data menu option
    And User selects file to import on Import XML Data page
      | FileName | lookup_export |
    And User clicks on Load button on Import XML Data page
    And User unchecks Update_matched_records checkbox
    And User clicks on Import button on Import XML Data page
    Then Verify that the new record was created successfully
    And User clicks on Lookups menu option
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
    And User deletes the "lookup_export" file

  
  Scenario: Import Lookups Data to update existing lookup Record
    #Add a new lookup record
    When User clicks on Setup menu option
    And User clicks on Lookups menu option
    And User clicks on Add button to add Lookup
    And User selects Category1 on Lookup Details panel
      | Category1 | Connect |
    And User selects Category2 on Lookup Details panel
      | Category2 | MAX_ROWS |
    And User enters Value on Lookup Details panel
      | Value | 1 |
    And User clicks on Save button to save Lookup details
    #Export the records
    Given User navigates to the Lookup Search panel
    And User clicks on Search button to search Lookups
    Then All Lookups should be displayed in search results
    When User clicks on checkbox to select all Lookups under search results
    And User clicks on Choose an Action drop down on Lookups page
    And User selects Export as XML on Lookups page
    And User clicks on Go button on Lookups page
    Then Verify that the Lookups records xml file was successfully downloaded
    #Import the file
    When User clicks on Import XML Data menu option
    And User selects file to import on Import XML Data page
      | FileName | lookup_export |
    And User clicks on Load button on Import XML Data page
    And User checks Update_matched_records checkbox
    And User clicks on Import button on Import XML Data page
    Then Verify that the records were updated successfully
    #Delete the record
    And User clicks on Lookups menu option
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
  #Delete the exported file  
And User deletes the "lookup_export" file
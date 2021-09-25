@Carousels
Feature: Add,Search,Edit,Export,Delete Carousels

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed

  @C25349897
  Scenario: Add a Carousel
    When User clicks on Devices menu option
    And User clicks on Carousels menu option
    And User clicks on Add button to add Carousel
    And User Enters required detais to add Carousel[0]
    And User clicks on Save button to add Carousel
    Then Verify Carousel is created successfully

  @C41461722
  Scenario: Search a Carousel
    When User clicks on Devices menu option
    And User clicks on Carousels menu option
    And User enters 'carouselsPageObjects.carousel_name[0]' to search a Carousel
    And User clicks on Search button to search Carousel
    Then Carousel 'carouselsPageObjects.carousel_name[0]' should be displayed in search results

  @C25349898
  Scenario: Edit a Carousel
    When User clicks on Devices menu option
    And User clicks on Carousels menu option
    And User enters search criteria to search a Carousel
    And User clicks on Search button to search Carousel
    Then Carousel should be displayed in search results
    When User clicks on Edit option to edit Carousel
    And User changes Carousel details
    And User clicks on Save button to save Carousel details
    Then Verify Carousel details updated successfully

  @C25349901 @Export
  Scenario: Export Carousel recods
    When User clicks on Devices menu option
    And User clicks on Carousels menu option
    And User clicks on Search button to search Carousels
    Then All Carousels should be displayed in search results
    When User clicks on checkbox to select all Carousels under search results
    And User clicks on Choose an Action drop down on Carousels page
    And User selects Export as XML on Carousels page
    And User clicks on Go button on Carousels page
    Then Verify that the Carousel records xml file was successfully downloaded
    And User deletes the "carousel_export" file

  @C25349899
  Scenario: Delete Carousel
    When User clicks on Devices menu option
    And User clicks on Carousels menu option
    And User enters carousel_name[1] to search a Carousel
    And User clicks on Search button to search Carousel
    Then Carousel carousel_name[1] should be displayed in search results
    When User clicks on Delete option to delete Carousel
    And User enters carousel_name[1] to search a Carousel
    And User clicks on Search button to search Carousel
    Then Verify Carousel deleted successfully

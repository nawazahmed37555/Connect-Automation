@LabelGrpahics
Feature: Manage Label Grpahics

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed
    When User clicks on Label Management menu option
    And User clicks on Label Grpahics menu option

  @T1720096749
  Scenario: Add a Label Graphic

  # When User clicks on Add button to add Label Graphic
  # And User enters Label Graphic name[0] for the Label Graphic
  #And User selects Label Graphic file for the Label Graphic
  # And User selects Language[1] for the Label Graphic
  # And User selects DPI[1] for the Label Graphic
  #And User selects Company[1] for the Label Graphic
  # And User clicks on Save button to save Label Graphic details
  # Then Label Graphic[0] should be created successfully
  @T1720096750
  Scenario: Search a Label Graphic
    When User clicks on Search button to search label graphic(s)
    And User notes down the first graphic name from the search results
    When User enters Label Graphic name[0] to search
    And User clicks on Search button to search label graphic(s)
    Then Label Graphic[0] is displayed in search results

  @T1720096747
  Scenario: Edit a Label Graphic
    When User enters Label Graphic name[0] to search
    And User clicks on Search button to search label(s)
    Then Label Graphic[0] is displayed in search results
    And Click on Edit button edit label graphic details
    And User enters Label Graphic name[1] for the Label Graphic
    And User clicks on Save button to save Label Graphic details
    Then Label Graphic[1] details should be updated successfully
    Then Label Graphic[1] is displayed in search results
    And Click on Edit button edit label graphic details
    And User enters Label Graphic name[0] for the Label Graphic
    And User clicks on Save button to save Label Graphic details

  @T1720096748
  Scenario: Delete a Label Graphic

  # When User enters Label Graphic name[1] to search
  # And User clicks on Search button to search label(s)
  # Then Label Graphic[1] is displayed in search results
  # And User clicks on the delete button to delete Label Graphic
  # Then Label Graphic should be deleted successfully
  @T1720110375 @Export
  Scenario: Export Label Graphics to XML file
    And User clicks on Search button to search label(s)
    Then All Label Graphics should be displayed in search results
    When User clicks on checkbox to select all Label Graphics under search results
    And User clicks on Choose an Action drop down on Label Graphics page
    And User selects Export as XML on Label Graphics page
    And User clicks on Go button on Label Graphics page
    Then Verify that the Label Graphics records xml file was successfully downloaded

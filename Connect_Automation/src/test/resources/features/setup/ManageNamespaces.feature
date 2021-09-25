## All the test data used in the below steps, can be found int the step definition file.
@Namespaces
Feature: Add,Search,Edit,Export,Delete Namespaces

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed
    When User clicks on Setup menu option
    And User clicks on Namespaces menu option

  @T1720095761
  Scenario: Add a Namespace
    And User clicks on Add button to add Namespace
    And User enters Namespace_name[0] on Namespace Details panel
    And User enters Class_name[0] on Namespace Details panel
    And User enters Description[0] on Namespace Details panel
    And User clicks on Save button to save Namespace details
    And User enters Namespace_name[0] to search a Namespace
    And User clicks on Search button to search Namespace
    Then Namespace with Namespace_name[0] should be displayed in search results

  @T1720095759
  Scenario: Search for namespace belonging to a specific class
    And User enters Class_name[0] to search a Namespace
    And User clicks on Search button to search Namespace
    Then Namespace with Class_name[0] should be displayed in search results

  @T1720095760
  Scenario: Edit a Namespace
    And User enters Namespace_name[0] to search a Namespace
    And User clicks on Search button to search Namespace
    Then Namespace with Namespace_name[0] should be displayed in search results
    And User clicks on Edit option to edit Namespace
    And User enters Namespace_name[1] on Namespace Details panel
    And User enters Class_name[1] on Namespace Details panel
    And User enters Description[1] on Namespace Details panel
    And User clicks on Save button to save Namespace details
    Then Verify Namespace[1] details updated successfully

  @T1720095762
  Scenario: Delete Namespace
    And User enters Namespace_name[1] to search a Namespace
    And User clicks on Search button to search Namespace
    Then Namespace with Namespace_name[1] should be displayed in search results
    When User clicks on Delete option to delete Namespace
    And User enters Namespace_name[1] to search a Namespace
    And User clicks on Search button to search Namespace
    Then Verify Namespace deleted successfully

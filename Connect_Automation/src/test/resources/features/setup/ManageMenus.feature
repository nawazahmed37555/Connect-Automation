## All the test data used in the below steps, can be found int the step definition file.

@Menus
Feature: Add,Search,Edit,Export,Delete Menus

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed
    When User clicks on Setup menu option
    And User clicks on Menus menu option

  @T1720095710
  Scenario: Add a Menu
    And User clicks on Add button to add Menu
    And User selects Menu_group[1] on Menu Details panel
    And User enters Display_name[0] on Menu Details panel
    And User selects Application[3] on Menu Details panel
    And User enters HREF[0] on Menu Details panel
    And User enters Sequence[0] on Menu Details panel
    And User selects Menu_item_type[2] on Menu Details panel
    And User clicks on Save button to save Menu details
    And User clicks on responsibilities tab on Menu Details panel
    And User selects responsibility "CLR_ADMINISTRATOR" to assign to the menu
    And User clicks on Add button to assign the reponsibility to the menu
    And User clicks on Save button to save Menu details
    Then Verify Menu with Menu_name[0] is created successfully

  @T1720095708
  Scenario: Search a Menu
    And User enters Menu_display_name[0] to search a Menu
    And User clicks on Search button to search Menu
    Then Menu with Menu_display_name[0] should be displayed in search results

  @T1720095709
  Scenario: Edit  Menu details
    And User enters Menu_display_name[0] to search a Menu
    And User clicks on Search button to search Menu
    Then Menu with Menu_display_name[0] should be displayed in search results
    And User clicks on Edit option to edit Menu
    And User selects Menu_group[2] on Menu Details panel
    And User enters Display_name[1] on Menu Details panel
    And User selects Application[3] on Menu Details panel
    And User enters HREF[1] on Menu Details panel
    And User enters Sequence[1] on Menu Details panel
    And User selects Menu_item_type[2] on Menu Details panel
    And User clicks on Save button to save Menu details
    Then Verify Menu[1] details updated successfully

  @T1720095711
  Scenario: Disable Menu option
    And User enters Menu_display_name[1] to search a Menu
    And User clicks on Search button to search Menu
    Then Menu with Menu_display_name[1] should be displayed in search results
    And User clicks on Disable option to disable menu
    Then Menu should be disabled successfully

  @T1720095713
  Scenario: Enable Menu option
    And User enters Menu_display_name[1] to search a Menu
    And User clicks on Search button to search Menu
    Then Menu with Menu_display_name[1] should be displayed in search results
    And User clicks on Enable option to enable menu
    Then Menu should be Enabled successfully

	
  @C41528272
  Scenario: Add a child to the menu
    And User enters Menu_display_name[1] to search a Menu
    And User clicks on Search button to search Menu
    Then Menu with Menu_display_name[1] should be displayed in search results
    And User clicks on Add Child option to add child menu
    And User selects Menu_group[1] on Menu Details panel
    And User enters Display_name[2] on Menu Details panel
    And User selects Application[3] on Menu Details panel
    And User enters HREF[2] on Menu Details panel
    And User enters Sequence[2] on Menu Details panel
    And User selects Menu_item_type[2] on Menu Details panel
    And User clicks on Save button to save Menu details
    And User clicks on responsibilities tab on Menu Details panel
    And User selects responsibility "CLR_ADMINISTRATOR" to assign to the menu
    And User clicks on Add button to assign the reponsibility to the menu
    And User clicks on Save button to save Menu details
    Then Verify Child_menu[2] under Menu_name[1] is created successfully

  @T1720095714
  Scenario: Delete Menu
    And User enters Menu_display_name[1] to search a Menu
    And User clicks on Search button to search Menu
   Then Menu with Menu_display_name[1] should be displayed in search results
    When User clicks on Delete option to delete Menu
   And User enters Menu_display_name[1] to search a Menu
    And User clicks on Search button to search Menu
    Then Verify Menu deleted successfully
    
  Scenario: Delete Child Menu
    And User enters Menu_display_name[2] to search a Menu
    And User clicks on Search button to search Menu
   Then Menu with Menu_display_name[2] should be displayed in search results
    When User clicks on Delete option to delete Menu
   And User enters Menu_display_name[2] to search a Menu
    And User clicks on Search button to search Menu
    Then Verify Menu deleted successfully
    
@LabelHistory
Feature: Manage Labels

  Background: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed
    And User clicks on Label History and Reprint menu option

  @T1720096740
    Scenario: Search Label History records
    When Run the SQL query to get the request_id[0] of the latest printed label record from DB
    And User enters label Request_id[0] to search
    And User clicks on Search button to search label printing history
    Then Printed label history with Request_id[0] should be displayed
   
  
    
    
    @T1720096743 @T1720096742
    Scenario: Reprint label
    When Run the SQL query to get the request_id[0] of the latest printed label record from DB
    And User enters label Request_id[0] to search
    And User clicks on Search button to search label printing history
    Then Printed label history with Request_id[0] should be displayed
    And User notes down all the label[0] information
    And User notes down the label[0] data
    When User clicks on the checkbox to select the label history record
    And User selects "Reprint Labels(s)" from the choose an action dropdown
    And User disables Print to PDF option
    And User selects printer[0] to reprint label
    And User clicks on Go button to reprint label
    When Run the SQL query to get the request_id[1] of the latest printed label record from DB
    And User enters label Request_id[1] to search
    And User clicks on Search button to search label printing history
    Then Printed label history with Request_id[1] should be displayed
    And User notes down the label[1] data
    Then Verify that the label data is same in the actual and the reprinted labels
    
      
       
    @T1720110376 @T1720096742
    Scenario: Reprint label using 'Print to PDF' 
    When Run the SQL query to get the request_id[0] of the latest printed label record from DB
    And User enters label Request_id[0] to search
    And User clicks on Search button to search label printing history
    Then Printed label history with Request_id[0] should be displayed
    And User notes down all the label[0] information
    And User notes down the label[0] data
    When User clicks on the checkbox to select the label history record
    And User selects "Reprint Labels(s)" from the choose an action dropdown  
    And User enables Print to PDF option
    And User clicks on Go button to reprint label
    And PDF is opened in a new browser tab so user navigates back to the main window
    When Run the SQL query to get the printToPdfID[0] of the latest printed label record from DB
    And User enters printToPdfID[0] to search label printing history
    And User notes down the label[1] data
    Then Verify that the label data is same in the actual and the reprinted labels
    
    
    @T1720110406
    Scenario: Reprint label when label format is disabled
    When Run the SQL query to get the request_id[0] of the latest printed label record from DB
    And User enters label Request_id[0] to search
    And User clicks on Search button to search label printing history
    Then Printed label history with Request_id[0] should be displayed
    And User notes down all the label[0] information
    When User clicks on Label Management menu option
    And User clicks on Labels menu option
    When User enters label format name[0]  to search
    And User clicks on Search button to search label(s)
    And User clicks on Disable button to disable label format
 		And User clicks on Label History and Reprint menu option
 		And User enters label Request_id[0] to search
    And User clicks on Search button to search label printing history
  	When User clicks on the checkbox to select the label history record
    And User selects "Reprint Labels(s)" from the choose an action dropdown
    And User disables Print to PDF option
    And User selects printer[0] to reprint label
    And User clicks on Go button to reprint label
    Then Should display an error message that the label format is disabled
    When User clicks on Label Management menu option
    And User clicks on Labels menu option
    When User enters label format name[0]  to search
    And User clicks on Search button to search label(s)
    And User clicks on Enable button to Enable label format
    
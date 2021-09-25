@Login/Logout
Feature: Connect Login Feature
 Verifying all the login/logout tests.
	 
	 @T1720107274
	  Scenario: Login to Connect with invalid Username and invalid Password
    Given User Navigates to Connect URL
    And User Enters invalid Username
    And User Enters invalid Password
    When User clicks on Login button
    Then Access denied error message is displayed.
    
	@T1720110334 
  Scenario: Login to Connect with valid Username and Password
    Given User Navigates to Connect URL
    And User Enters valid Username
    And User Enters valid Password
    When User clicks on Login button
    Then Connect Home Page is displayed

	@T1720107279 
	Scenario: Verify Logout option
  Given User Navigates to Connect URL
	And User Enters valid Username
   And User Enters valid Password
   When User clicks on Login button
   Then Connect Home Page is displayed
   When User cliks on Logout button
   
   @T1720110357 
   Scenario: Verify Single SSO with Endeavour
  Given User Navigates to Connect URL
	 And User Enters valid Username
   And User Enters valid Password
   When User clicks on Login button
   Then Connect Home Page is displayed
   And User Navigates to Endeavour URL in new tab
   Then User is automatically logged into Endeavour

   Scenario: Login to Endeavour with valid credentials 
    Given User Navigates to Endeavour URL
    And User Enters valid Username for Endeavour	
    And User Enters valid Password for Endeavour
    When User clicks on Login button
    Then Endeavour Home Page is displayed
   
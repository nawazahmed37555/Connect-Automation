package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.BasePage;
import pageObjects.CommonPageLocators;
import pageObjects.connect.UsersPageObjects;
import utils.DriverFactory;

public class ManageUsers extends DriverFactory{

	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public UsersPageObjects usersPageObjects = PageFactory.initElements(driver, UsersPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);
	
	
	@When("^User clicks on Users menu option$")
	public void user_clicks_on_Users_menu_option() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Users.click();
		
	}

	@And("^User clicks on Add button to add User$")
	public void userClicksOnAddButtonToAddUser() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		usersPageObjects.addBtn.click();;
		
	}
	

	@And("^User Enters required detais to add User\\[(\\d+)\\]$")
	public void userEntersRequiredDetaisToAddUser(int index) {
		//Enter Username
				usersPageObjects.edit_userName.sendKeys(usersPageObjects.userName[index]);
				//Enter Password
				usersPageObjects.edit_password.sendKeys(usersPageObjects.passWord[index]);
				/*//Select User type
				Select userTypeDropDown = new Select (usersPageObjects.choose_userType);
				userTypeDropDown.selectByIndex(index+1);
				*/
				//Select Company
				Select companyDropDown = new Select (usersPageObjects.choose_company);
				companyDropDown.selectByIndex(index+1);
				}

	@And("^User clicks on Save button to add User$")
	public void userClicksOnSaveButtonToAddUser() throws InterruptedException {
		usersPageObjects.saveBtn.click();
		//System.out.println("Uncomment the code to create user successfully.");
	}

	@Then("^User record is created successfully$")
	public void userRecordIsCreatedSuccessfully()  {
		
		Assert.assertEquals(usersPageObjects.userName[0], usersPageObjects.edit_userName.getAttribute("value"));
		//System.out.println("Uncomment the code to create user successfully.");
		
	}

	@And("^User enters search criteria to search a User$")
	public void userEntersSearchCriteriaToSearchAUser() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		usersPageObjects.search_userName.sendKeys(usersPageObjects.userName[0]);
		
	}

	@And("^User clicks on Search button to search User$")
	public void userClicksOnSearchButtonToSearchUser() {
	driver.switchTo().defaultContent();
	driver.switchTo().frame(commonPageLocators.body_frame);
	usersPageObjects.searchBtn.click();
	}

	@Then("^User should be displayed in search results$")
	public void userShouldBeDisplayedInSearchResults() {
		
		Assert.assertEquals(usersPageObjects.userName[0], usersPageObjects.searchResults_userName.getText().trim());
		
	}

	@When("^User clicks on Disable option to disable User$")
	public void userClicksOnDisableOptionToDisableUser() 
	{
		usersPageObjects.contextMenuBtn.click();
		usersPageObjects.contextMenu_Disable_Btn.click();
	}

	@Then("^Verify that the User is disabled$")
	public void verifyThatTheUserIsDisabled(){
		Assert.assertEquals("true",usersPageObjects.userStatus.getText().trim());
	}

	@When("^User clicks on Enable option to enable user$")
	public void userClicksOnEnableOptionToEnableUser() {
		
		usersPageObjects.contextMenuBtn.click();
		usersPageObjects.contextMenu_Enable_Btn.click();
	}

	@Then("^Verify that the User is Enabled$")
	public void verifyThatTheUserIsEnabled() {
		Assert.assertEquals("false", usersPageObjects.userStatus.getText().trim());
	}

	@When("^User clicks on Edit option to edit user$")
	public void userClicksOnEditOptionToEditUser() throws Throwable {
		usersPageObjects.contextMenuBtn.click();
		usersPageObjects.contextMenu_Edit_Btn.click();
	}
	@And("^User changes user\\[(\\d+)\\] details$")
	public void userChangesUserDetails(int index)  {
	
		//Change Username
				usersPageObjects.edit_userName.clear();
				usersPageObjects.edit_userName.sendKeys(usersPageObjects.userName[index]);
				
				//Change Password
				usersPageObjects.edit_password.clear();
				usersPageObjects.edit_password.sendKeys(usersPageObjects.passWord[index]);
				//Change User type
				Select userTypeDropDown = new Select (usersPageObjects.choose_userType);
				userTypeDropDown.selectByIndex(index+1);
				//Change Company
				Select companyDropDown = new Select (usersPageObjects.choose_company);
				companyDropDown.selectByIndex(index+1);
	}


	@And("^User clicks on Save button to save User details$")
	public void userClicksOnSaveButtonToSaveUserDetails(){
		usersPageObjects.saveBtn.click();
	}

	@Then("^Verify user\\[(\\d+)\\] details updated successfully$")
	public void verifyUserDetailsUpdatedSuccessfully(int index)  {
		//Verify Username updated successfully
 		Assert.assertEquals(usersPageObjects.edit_userName.getAttribute("value"),usersPageObjects.userName[index]);
 
		//Verify Company updated successfully
		Select companyDropDown = new Select (usersPageObjects.choose_company);
		Assert.assertEquals(companyDropDown.getFirstSelectedOption().getText(),usersPageObjects.company[index]);
	}

	@Then("^All Users should be displayed in search results$")
	public void allUsersShouldBeDisplayedInSearchResults() throws Throwable {
		//Confirm if there any  User records available or not.
		Assert.assertTrue(driver.findElements(By.xpath("//*[@id='unique_id']/tbody/tr")).size()>1);
	}

	@When("^User clicks on checkbox to select all users under search results$")
	public void userClicksOnCheckboxToSelectAllUsersUnderSearchResults()  {
		
		usersPageObjects.selectAll_checkbox.click();
	}

	@And("^User clicks on Choose an Action drop down on Users page$")
	public void userClicksOnChooseAnActionDropDownOnUsersPage()  {
		usersPageObjects.choose_an_action.click();
		
	}

	@And("^User selects Export as XML option on Users page$")
	public void userSelectsExportAsXMLOptionOnUsersPage()  {
		Select chooseAnAction_drpDown = new Select (usersPageObjects.choose_an_action) ;
		chooseAnAction_drpDown.selectByVisibleText("Export as XML");
	}

	@And("^User clicks on Go button on Users page$")
	public void userClicksOnGoButtonOnUsersPage() throws InterruptedException {
		usersPageObjects.Go_Btn.click();
		
	}

	@Then("^Verify that the user records xml file was successfully downloaded$")
	public void verifyThatTheUserRecordsXmlFileWasSuccessfullyDownloaded() throws Throwable {
		
		//Dates starting with 0 needs to be stripped to match the fileName
		String currentDate = basePage.getCURRENTDate_initialZeroStripped("M-d-yyyy");
		String FileName = "user_export_"+currentDate+".xml";
		Assert.assertEquals(true, basePage.isFileDownloaded(utils.Constant.downloadDirectory, FileName, 300));	
	}





}

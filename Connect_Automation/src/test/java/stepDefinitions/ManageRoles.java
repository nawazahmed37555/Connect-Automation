package stepDefinitions;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.CommonPageLocators;
import pageObjects.connect.RolesPageObjects;
import utils.DriverFactory;

public class ManageRoles extends DriverFactory {
	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public RolesPageObjects rolesPageObjects = PageFactory.initElements(driver, RolesPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);
	public List<String> selectedOptions = new ArrayList<String>();
	
	@When("^User clicks on Roles menu option$")
	public void user_clicks_on_Roles_menu_option() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Roles.click();

	    
	}
	@When("^User clicks on Add button to add Role$")
	public void user_clicks_on_Add_button_to_add_Role() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		commonPageLocators.addBtn.click();
	   
	}
	@When("^User Enters required detais to add Role$")
	public void user_Enters_required_detais_to_add_Role() {
		rolesPageObjects.edit_RoleName.clear();
		rolesPageObjects.edit_RoleName.sendKeys(rolesPageObjects.roleName[0]);
		rolesPageObjects.edit_description.clear();
		rolesPageObjects.edit_description.sendKeys(rolesPageObjects.roleDescription[0]);
		
	    
	}
	@When("^User clicks on Save button to add Role$")
	public void user_clicks_on_Save_button_to_add_Role() {
		
		commonPageLocators.saveBtn.click();
	}
	@Then("^Verify Role is created successfully$")
	public void verify_Role_is_created_successfully() {
	    Assert.assertEquals(rolesPageObjects.edit_RoleName.getAttribute("value"), rolesPageObjects.roleName[0]);
	    Assert.assertEquals(rolesPageObjects.edit_description.getAttribute("value"), rolesPageObjects.roleDescription[0]);
	  
	}
	@And("^User enters search criteria to search a Role$")
	public void userEntersSearchCriteriaToSearchARole() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		rolesPageObjects.search_Role_name.clear();
		rolesPageObjects.search_Role_name.sendKeys(rolesPageObjects.roleName[0]);
	}
	@And("^User clicks on Search button to search Role$")
	public void userClicksOnSearchButtonToSearchRole() {
		rolesPageObjects.searchBtn.click();
	}
	@Then("^Role should be displayed in search results$")
	public void roleShouldBeDisplayedInSearchResults()  {
		Assert.assertEquals(rolesPageObjects.searchResults_roleName.getText().trim(), rolesPageObjects.roleName[0]);
		
	}
	@When("^User clicks on Disable option to disable Role$")
	public void userClicksOnDisableOptionToDisableRole() {
		rolesPageObjects.contextMenuBtn.click();
		rolesPageObjects.contextMenu_Disable_Btn.click();
		
	}
	@Then("^Verify that the Role is disabled$")
	public void verifyThatTheRoleIsDisabled() {
		Assert.assertEquals(rolesPageObjects.searchResults_roleStatus.getText().trim(), "true");			
		
	}
	@When("^User clicks on Enable option to enable Role$")
	public void userClicksOnEnableOptionToEnableRole(){
		rolesPageObjects.contextMenuBtn.click();
		rolesPageObjects.contextMenu_Enable_Btn.click();
	}
	@Then("^Verify that the Role is Enabled$")
	public void verifyThatTheRoleIsEnabled()  {
		Assert.assertEquals(rolesPageObjects.searchResults_roleStatus.getText().trim(), "false");
	}
	@When("^User clicks on Edit option to edit Role$")
	public void userClicksOnEditOptionToEditRole()  {
		rolesPageObjects.contextMenuBtn.click();
		rolesPageObjects.contextMenu_Edit_Btn.click();
	}
	@And("^User changes Role details$")
	public void userChangesRoleDetails()  {
		rolesPageObjects.edit_RoleName.clear();
		rolesPageObjects.edit_RoleName.sendKeys(rolesPageObjects.roleName[1]);
		rolesPageObjects.edit_description.clear();
		rolesPageObjects.edit_description.sendKeys(rolesPageObjects.roleDescription[1]);
	}
	@And("^User clicks on Save button to save Role details$")
	public void userClicksOnSaveButtonToSaveRoleDetails(){
		rolesPageObjects.saveBtn.click();
	}
	@Then("^Verify Role details updated successfully$")
	public void verifyRoleDetailsUpdatedSuccessfully() {
		Assert.assertEquals(rolesPageObjects.roleName[1],rolesPageObjects.edit_RoleName.getAttribute("value"));
		Assert.assertEquals(rolesPageObjects.roleDescription[1],rolesPageObjects.edit_description.getAttribute("value"));
	}
	@And("^User clicks on the Responsibilities tab under edit Role panel$")
	public void userClicksOnTheResponsibilitiesTabUnderEditRolePanel()  {
		rolesPageObjects.responsibilities_tab.click();
	}
	@And("^User selects responsibilities to assign to the Role$")
	public void userSelectsResponsibilitiesToAssignToTheRole() {
	 	//Select specific dropdown options
		selectedOptions=basePage.selectDropDownOption(rolesPageObjects.unassigned_ResponsibilitiesList, "CLR_SUPERUSER", selectedOptions);
	}
	@And("^User selects all responsibilities to assign to the Role$")
	public void userSelectsAllResponsibilitiesToAssignToTheRole() {
	//Select all options in the dropdown
	 selectedOptions = basePage.selectAllDropDownOptions(rolesPageObjects.unassigned_ResponsibilitiesList, selectedOptions);
	}
	@And("^User clicks on Add button to assign responsibilities to the Role$")
	public void userClicksOnAddButtonToAssignResponsibilitiesToTheRole() {
		rolesPageObjects.Add_Btn_assignResponsibilities.click();
	}
	@Then("^Responsibilities should be assigned to the Role$")
	public void responsibilitiesShouldBeAssignedToTheRole() {
		Assert.assertEquals(basePage.compareDropdownoptions(rolesPageObjects.assigned_ResponsibilitiesList, selectedOptions),true);
	}
}

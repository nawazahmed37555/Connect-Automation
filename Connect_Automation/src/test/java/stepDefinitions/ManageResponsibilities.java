package stepDefinitions;


import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.CommonPageLocators;
import pageObjects.connect.ResponsibilitiesPageObjects;
import utils.DriverFactory;

public class ManageResponsibilities extends DriverFactory{

	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public ResponsibilitiesPageObjects responsibilitiesPageObjects = PageFactory.initElements(driver, ResponsibilitiesPageObjects.class);


	@When("^User clicks on Responsibilities menu option$")
	public void userClicksOnResponsibilitiesMenuOption(){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Responsibilities.click();
	}

	@And("^User clicks on Add button to add Responsibility$")
	public void userClicksOnAddButtonToAddResponsibility() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		responsibilitiesPageObjects.addBtn.click();;
	}

	@And("^User Enters required detais to add Responsibility$")
	public void userEntersRequiredDetaisToAddResponsibility() {
		responsibilitiesPageObjects.edit_ResponsibiltyName.sendKeys(responsibilitiesPageObjects.responsibilityName[0]);
		responsibilitiesPageObjects.edit_description.sendKeys(responsibilitiesPageObjects.responsibilityDescription[0]);
		
		}

	@And("^User clicks on Save button to add Responsibility$")
	public void userClicksOnSaveButtonToAddResponsibility()  {
		responsibilitiesPageObjects.saveBtn.click();
	}


	@Then("^Verify Responsibility is created successfully$")
	public void verifyResponsibilityIsCreatedSuccessfully()  {
		Assert.assertEquals(responsibilitiesPageObjects.responsibilityName[0], responsibilitiesPageObjects.edit_ResponsibiltyName.getAttribute("value"));
		Assert.assertEquals(responsibilitiesPageObjects.responsibilityDescription[0], responsibilitiesPageObjects.edit_description.getAttribute("value"));
	}

	@And("^User enters search criteria to search a Responsibility$")
	public void userEntersSearchCriteriaToSearchAResponsibility() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		responsibilitiesPageObjects.search_ResponsibilityName.sendKeys(responsibilitiesPageObjects.responsibilityName[0]);
		
	}

	@And("^User clicks on Search button to search Responsibility$")
	public void userClicksOnSearchButtonToSearchResponsibility(){
		responsibilitiesPageObjects.searchBtn.click();
	}

	@Then("^Responsibility should be displayed in search results$")
	public void responsibilityShouldBeDisplayedInSearchResults()  {
		Assert.assertEquals(responsibilitiesPageObjects.responsibilityName[0], responsibilitiesPageObjects.searchResults_responsibilityName.getText().trim());
		}

	@When("^User clicks on Disable option to disable Responsibility$")
	public void userClicksOnDisableOptionToDisableResponsibility() {
		responsibilitiesPageObjects.contextMenuBtn.click();
		responsibilitiesPageObjects.contextMenu_Disable_Btn.click();
	}

	@Then("^Verify that the Responsibility is disabled$")
	public void verifyThatTheResponsibilityIsDisabled() {
		
		Assert.assertEquals("true",responsibilitiesPageObjects.responsibilityStatus.getText().trim());
	}

	@When("^User clicks on Enable option to enable Responsibility$")
	public void userClicksOnEnableOptionToEnableResponsibility() {
		responsibilitiesPageObjects.contextMenuBtn.click();
		responsibilitiesPageObjects.contextMenu_Enable_Btn.click();
	}

	@Then("^Verify that the Responsibility is Enabled$")
	public void verifyThatTheResponsibilityIsEnabled() {
		Assert.assertEquals("false",responsibilitiesPageObjects.responsibilityStatus.getText().trim());
	}

	@When("^User clicks on Edit option to edit Responsibility$")
	public void userClicksOnEditOptionToEditResponsibility() {
		responsibilitiesPageObjects.contextMenuBtn.click();
		responsibilitiesPageObjects.contextMenu_Edit_Btn.click();
		
	}

	@And("^User changes Responsibility details$")
	public void userChangesResponsibilityDetails()  {
		//Change Responsibility name
		responsibilitiesPageObjects.edit_ResponsibiltyName.clear();
		responsibilitiesPageObjects.edit_ResponsibiltyName.sendKeys(responsibilitiesPageObjects.responsibilityName[1]);
		//Change responsibility description 
		responsibilitiesPageObjects.edit_description.clear();
		responsibilitiesPageObjects.edit_description.sendKeys(responsibilitiesPageObjects.responsibilityDescription[1]);
		
	}

	@And("^User clicks on Save button to save Responsibility details$")
	public void userClicksOnSaveButtonToSaveResponsibilityDetails() {
		responsibilitiesPageObjects.saveBtn.click();
	}

	@Then("^Verify Responsibility details updated successfully$")
	public void verifyResponsibilityDetailsUpdatedSuccessfully(){
		Assert.assertEquals(responsibilitiesPageObjects.responsibilityName[1],responsibilitiesPageObjects.edit_ResponsibiltyName.getAttribute("value"));
		Assert.assertEquals(responsibilitiesPageObjects.responsibilityDescription[1],responsibilitiesPageObjects.edit_description.getAttribute("value"));

	}

	@Then("^All Responsibilities should be displayed in search results$")
	public void allResponsibilitiesShouldBeDisplayedInSearchResults() {
		
		Assert.assertTrue(driver.findElements(By.xpath("//*[@id='unique_id']/tbody/tr")).size()>1);
		}

	@When("^User clicks on checkbox to select all Responsibilities under search results$")
	public void userClicksOnCheckboxToSelectAllResponsibilitiesUnderSearchResults() {
		responsibilitiesPageObjects.selectAll_checkbox.click();
	}
	
}



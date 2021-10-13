package stepDefinitions.setup;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.CommonPageLocators;
import pageObjects.connect.setup.FieldsPageObjects;
import utils.DriverFactory;


public class ManageFields extends DriverFactory {

	//Test data
	
			public String[] field_name = {"Automated_field1","Automated_field2"};
			public String[] description = {"Automated Desciption 1","Automated Description 2"};
			public String[] display_name = {"Automated_field1","Automated_field2"};
			public List<String> selectedResponsibilities = new ArrayList<String>();
			
			public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
			public FieldsPageObjects fieldsPageObjects = PageFactory.initElements(driver, FieldsPageObjects.class);
			public BasePage basePage = PageFactory.initElements(driver, BasePage.class);

	@When("^User clicks on Setup menu option$")
	public void userClicksOnSetupMenuOption()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Setup.click();
	}

	@And("^User clicks on Fields menu option$")
	public void userClicksOnFieldsMenuOption()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Setup_Fields.click();
		
	}

	@And("^User clicks on Add button to add Field$")
	public void userClicksOnAddButtonToAddField(){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		commonPageLocators.addBtn.click();
	}

	@And("^User selects Field_namespace\\[(\\d+)\\] on Field Details panel$")
	public void userSelectsField_namespaceOnFieldDetailsPanel(int index) {
		Select nameSpace_dropDown = new Select(fieldsPageObjects.edit_fieldNameSpace_drpDown);
		nameSpace_dropDown.selectByIndex(index);
		
	}
	
	@And("^User enters Field_name\\[(\\d+)\\]	on Field Details panel$")
	public void userEntersField_nameOnFieldDetailsPanel(int index) {
		fieldsPageObjects.edit_fieldName.clear();
		fieldsPageObjects.edit_fieldName.sendKeys(field_name[index]);
	}

	@And("^User selects Field_type\\[(\\d+)\\] on Field Details panel$")
	public void userSelectsField_typeOnFieldDetailsPanel(int index) {
		Select fieldType_dropDown = new Select(fieldsPageObjects.edit_fieldType_drpDown);
		fieldType_dropDown.selectByIndex(index);
	}

	@And("^User enters Description\\[(\\d+)\\] on Field Details panel$")
	public void userEntersDescriptionOnFieldDetailsPanel(int index)  {
		fieldsPageObjects.edit_description.clear();
		fieldsPageObjects.edit_description.sendKeys(description[index]);
	}

	@And("^User enters Display_name\\[(\\d+)\\] on Field Details panel$")
	public void userEntersDisplay_nameOnFieldDetailsPanel(int index)  {
		fieldsPageObjects.edit_displayName.clear();
		fieldsPageObjects.edit_displayName.sendKeys(display_name[index]);
	}

	@And("^User selects Field_LOV_Class\\[(\\d+)\\] on Field Details panel$")
	public void userSelectsField_LOV_ClassOnFieldDetailsPanel(int index)  {
		Select fieldType_dropDown = new Select(fieldsPageObjects.edit_fieldLOVClass_drpDown);
		fieldType_dropDown.selectByIndex(index);
	}

	@And("^User selects Field_LOV_Type\\[(\\d+)\\] on Field Details panel$")
	public void userSelectsField_LOV_TypeOnFieldDetailsPanel(int index) {
		Select fieldLOVType_dropDown = new Select(fieldsPageObjects.edit_fieldLOVType_drpDown);
		if(fieldLOVType_dropDown.getOptions().size()>index) {
		fieldLOVType_dropDown.selectByIndex(index);
		}
	}

	@And("^User clicks on Save button to save Field details$")
	public void userClicksOnSaveButtonToAddField()  {
		commonPageLocators.saveBtn.click();
	}


	@Then("^Verify Field\\[(\\d+)\\] is created successfully$")
	public void verifyFieldIsCreatedSuccessfully(int index) {
		Assert.assertEquals(fieldsPageObjects.searchResult.getText().trim(), field_name[index]);
	}
	/*
	@And("^User selects Field_namespace \"([^\"]*)\" on Field Details panel$")
	public void userSelectsField_namespaceOnFieldDetailsPanel(String Field_namespace)  {
		Select nameSpace_dropDown = new Select(fieldsPageObjects.edit_fieldNameSpace_drpDown);
		nameSpace_dropDown.selectByVisibleText(Field_namespace);
	}

	@And("^User enters  Field_name \"([^\"]*)\" on Field Details panel$")
	public void userEntersField_nameOnFieldDetailsPanel(String Field_name)  {
		fieldsPageObjects.edit_fieldName.clear();
		fieldsPageObjects.edit_fieldName.sendKeys(Field_name);
	}

	@And("^User selects Field_type \"([^\"]*)\" on Field Details panel$")
	public void userSelectsField_typeOnFieldDetailsPanel(String Field_type) {
		Select fieldType_dropDown = new Select(fieldsPageObjects.edit_fieldType_drpDown);
		fieldType_dropDown.selectByVisibleText(Field_type);
	}

	@And("^User enters Description \"([^\"]*)\" on Field Details panel$")
	public void userEntersDescriptionOnFieldDetailsPanel(String Description)  {
		fieldsPageObjects.edit_description.clear();
		fieldsPageObjects.edit_description.sendKeys(Description);
	}

	@And("^User enters Display_name \"([^\"]*)\" on Field Details panel$")
	public void userEntersDisplay_nameOnFieldDetailsPanel(String Display_name) {
		fieldsPageObjects.edit_displayName.clear();
		fieldsPageObjects.edit_displayName.sendKeys(Display_name);
	}

	@And("^User selects Field_LOV_class \"([^\"]*)\" on Field Details panel$")
	public void userSelectsField_LOV_classOnFieldDetailsPanel(String Field_LOV_class) {
		Select fieldType_dropDown = new Select(fieldsPageObjects.edit_fieldLOVClass_drpDown);
		fieldType_dropDown.selectByVisibleText(Field_LOV_class);
	}

	@And("^User selects Field_LOV_type \"([^\"]*)\" on Field Details panel$")
	public void userSelectsField_LOV_typeOnFieldDetailsPanel(String Field_LOV_type)  {
		Select fieldLOVType_dropDown = new Select(fieldsPageObjects.edit_fieldLOVType_drpDown);
		fieldLOVType_dropDown.selectByVisibleText(Field_LOV_type);
	}
	@And("^User clicks on Save button to add Field$")
	public void userClicksOnSaveButtonToAddField()  {
		commonPageLocators.saveBtn.click();
	}
	@Then("^Verify Field with Field_Name \"([^\"]*)\" is created successfully$")
	public void verifyFieldWithFieldNameIsCreatedSuccessfully(String Field_Name)  {
		Assert.assertEquals(commonPageLocators.searchResult.getText().trim(), Field_Name);

	}
*/

	@And("^User enters Field_name\\[(\\d+)\\] to search a Field$")
	public void userEntersField_nameToSearchAField(int index) throws Throwable {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		fieldsPageObjects.search_field_name.clear();
		fieldsPageObjects.search_field_name.sendKeys(field_name[index]);
	}

	@And("^User clicks on Search button to search Field$")
	public void userClicksOnSearchButtonToSearchField()  {
		commonPageLocators.searchBtn.click();
	}
	
	@Then("^Field with Field_name\\[(\\d+)\\] should be displayed in search results$")
	public void fieldWithField_nameShouldBeDisplayedInSearchResults(int index)  {
		Assert.assertEquals(fieldsPageObjects.searchResult.getText().trim(), field_name[index]);
		}

	@When("^User clicks on Edit option to edit Field$")
	public void userClicksOnEditOptionToEditField()  {
		commonPageLocators.contextMenuBtn.click();
		commonPageLocators.contextMenu_Edit_Btn.click();
	}

	@Then("^Verify Field\\[(\\d+)\\] details updated successfully$")
	public void verifyFieldDetailsUpdatedSuccessfully(int index) throws Throwable {
		Assert.assertEquals(fieldsPageObjects.edit_fieldName.getAttribute("value"),field_name[index] );
		Assert.assertEquals(fieldsPageObjects.edit_description.getAttribute("value"),description[index] );
		Assert.assertEquals(fieldsPageObjects.edit_displayName.getAttribute("value"),display_name[index] );
	}

	@And("^User clicks on Search button to search Fields$")
	public void userClicksOnSearchButtonToSearchFields()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		fieldsPageObjects.searchBtn.click();
	}

	@Then("^All Fields should be displayed in search results$")
	public void allFieldsShouldBeDisplayedInSearchResults() throws Throwable {
		Assert.assertTrue(driver.findElements(By.xpath("//*[@id='unique_id']/tbody/tr")).size()>1);
	}

	@When("^User clicks on checkbox to select all Fields under search results$")
	public void userClicksOnCheckboxToSelectAllFieldsUnderSearchResults() throws InterruptedException  {
		Thread.sleep(60000);	
		fieldsPageObjects.selectAll_checkbox.click();
	}

	@And("^User clicks on Choose an Action drop down on Fields page$")
	public void userClicksOnChooseAnActionDropDownOnFieldsPage() {
		fieldsPageObjects.choose_an_action.click();
		
	}

	@And("^User selects Export as XML on Fields page$")
	public void userSelectsExportAsXMLOnFieldsPage() {
		Select chooseAnAction_drpDown = new Select(fieldsPageObjects.choose_an_action);
		chooseAnAction_drpDown.selectByVisibleText("Export as XML");
		
	}

	@And("^User clicks on Go button on Fields page$")
	public void userClicksOnGoButtonOnFieldsPage() {
		fieldsPageObjects.Go_Btn.click();
	}

	@Then("^Verify that the Field records xml file was successfully downloaded$")
	public void verifyThatTheFieldRecordsXmlFileWasSuccessfullyDownloaded() throws InterruptedException  {
		//Dates starting with 0(for ex :01-01-2021) needs to be stripped to match the fileName
		String currentDate = basePage.getCURRENTDate_initialZeroStripped("M-d-yyyy");
		String FileName = "field_export_"+currentDate+".xml";
		Assert.assertEquals(true, basePage.isFileDownloaded(utils.Constant.downloadDirectory, FileName, 600));
	}

	@When("^User clicks on Delete option to delete Field$")
	public void userClicksOnDeleteOptionToDeleteField() throws Throwable {
		fieldsPageObjects.contextMenuBtn.click();
		fieldsPageObjects.contextMenu_Delete_Btn.click();
	}

	@Then("^Verify Field deleted successfully$")
	public void verifyFieldDeletedSuccessfully() throws Throwable {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td")).getText(), "No Results Found");
	}

	@And("^User clicks on the Responsibilities tab on Field Details panel$")
	public void userClicksOnTheResponsibilitiesTabOnFieldDetailsPanel()  {
		fieldsPageObjects.Responsibilities_tab.click();
	}

	@And("^User selects \"([^\"]*)\" responsibility$")
	public void userSelectsResponsibility(String optionToselect)  {
		selectedResponsibilities=basePage.selectDropDownOption(fieldsPageObjects.unassigned_ResponsibilitiesList, optionToselect, selectedResponsibilities);
		
	}
	
	@And("^User selects all responsibilities from the unassigned list$")
	public void userSelectsAResponsibilityFromTheUnassignedList() {
	
		selectedResponsibilities = basePage.selectAllDropDownOptions(fieldsPageObjects.unassigned_ResponsibilitiesList,selectedResponsibilities);
		 
	}

	@And("^User clicks on Add button to assign the reponsibility to the field$")
	public void userClicksOnAddButtonToAssignTheReponsibilityToTheField()  {
		fieldsPageObjects.addBtn_responsibilitiesTab.click();
	}

	@Then("^Verify all responsibilities are assigned to the Field$")
	public void verifyResponsibilityIsAssignedToTheField() {
		
		basePage.compareDropdownoptions(fieldsPageObjects.assigned_ResponsibilitiesList, selectedResponsibilities);
	}


	
	
	
}

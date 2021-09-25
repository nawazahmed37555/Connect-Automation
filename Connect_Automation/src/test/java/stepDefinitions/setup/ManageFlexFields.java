package stepDefinitions.setup;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.CommonPageLocators;
import pageObjects.connect.setup.FlexFieldsPageObjects;
import utils.DriverFactory;

public class ManageFlexFields extends DriverFactory {

	public String[] flex_field_name = {"Automated_flex_field1","Automated_flex_field2"};
	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public FlexFieldsPageObjects flexFieldsPageObjects = PageFactory.initElements(driver, FlexFieldsPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);

	@And("^User clicks on Flex Fields menu option$")
	public void userClicksOnFlexFieldsMenuOption(){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Setup_Flex_Fields.click();
	}


	@And("^User clicks on Add button to add Flex Field$")
	public void userClicksOnAddButtonToAddFlexField() throws Throwable {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		flexFieldsPageObjects.addBtn.click();
	}
	@And("^User enters Flex_Field_name\\[(\\d+)\\]	on Flex Field Details panel$")
	public void userEntersFlex_Field_nameOnFlexFieldDetailsPanel(int index){
		flexFieldsPageObjects.edit_Flexfield_name.clear();
		flexFieldsPageObjects.edit_Flexfield_name.sendKeys(flex_field_name[index]);
	}

	@And("^User selects Flex_Field_namespace\\[(\\d+)\\] on Flex Field Details panel$")
	public void userSelectsFlex_Field_namespaceOnFlexFieldDetailsPanel(int index) {
		Select field_namespace_drpdown = new Select(flexFieldsPageObjects.edit_fieldNameSpace_drpDown);
		field_namespace_drpdown.selectByIndex(index);
	}

	@And("^User selects Application\\[(\\d+)\\] on Flex Field Details panel$")
	public void userSelectsApplicationOnFlexFieldDetailsPanel(int index)  {
		Select application_drpdown = new Select(flexFieldsPageObjects.edit_application_drpDown);
		application_drpdown.selectByIndex(index);
	}

	@And("^User clicks on Save button to save Flex Field details$")
	public void userClicksOnSaveButtonToSaveFlexFieldDetails()  {
		flexFieldsPageObjects.saveBtn.click();
	}

	@Then("^Verify Flex_Field\\[(\\d+)\\] is created successfully$")
	public void verifyFlex_FieldIsCreatedSuccessfully(int index) {
	Assert.assertEquals( driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[3]")).getText().trim(), flex_field_name[index]);
	}


	@And("^User enters Flex_Field_name\\[(\\d+)\\] to search a Flex Field$")
	public void userEntersFlex_Field_nameToSearchAFlexField(int index)  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		flexFieldsPageObjects.search_Flexfield_name.clear();
		flexFieldsPageObjects.search_Flexfield_name.sendKeys(flex_field_name[index]);
	}

/*
	@And("^User clicks on Search button to search Flex Field$")
	public void userClicksOnSearchButtonToSearchFlexField()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		flexFieldsPageObjects.searchBtn.click();
	}
*/

	@Then("^Field with Flex_Field_name\\[(\\d+)\\] should be displayed in search results$")
	public void fieldWithFlex_Field_nameShouldBeDisplayedInSearchResults(int index) {
		Assert.assertEquals( driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[3]")).getText().trim(), flex_field_name[index]);
	}


	@And("^User clicks on Edit option to edit Flex Field$")
	public void userClicksOnEditOptionToEditFlexField() {
		flexFieldsPageObjects.contextMenuBtn.click();
		flexFieldsPageObjects.contextMenu_Edit_Btn.click();
	}


	@Then("^Verify Flex_Field\\[(\\d+)\\] details updated successfully$")
	public void verifyFlex_FieldDetailsUpdatedSuccessfully(int index)  {
		Assert.assertEquals( flexFieldsPageObjects.edit_Flexfield_name.getAttribute("value"), flex_field_name[index]);

	}


	@And("^User clicks on Search button to search Flex Field\\(s\\)$")
	public void userClicksOnSearchButtonToSearchFlexFieldS() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		flexFieldsPageObjects.searchBtn.click();
	}


	@Then("^All Flex Fields should be displayed in search results$")
	public void allFlexFieldsShouldBeDisplayedInSearchResults() throws Throwable {
		Assert.assertTrue(driver.findElements(By.xpath("//*[@id='unique_id']/tbody/tr")).size()>1);
	}


	@When("^User clicks on checkbox to select all Flex Fields under search results$")
	public void userClicksOnCheckboxToSelectAllFlexFieldsUnderSearchResults() throws Throwable {
		flexFieldsPageObjects.selectAll_checkbox.click();
	}


	@And("^User clicks on Choose an Action drop down on Flex Fields page$")
	public void userClicksOnChooseAnActionDropDownOnFlexFieldsPage() throws Throwable {
		flexFieldsPageObjects.choose_an_action.click();
	}


	@And("^User selects Export as XML on Flex Fields page$")
	public void userSelectsExportAsXMLOnFlexFieldsPage() throws Throwable {
		Select chooseAnAction_drpDown = new Select(flexFieldsPageObjects.choose_an_action);
		chooseAnAction_drpDown.selectByVisibleText("Export as XML");
	}


	@And("^User clicks on Go button on Flex Fields page$")
	public void userClicksOnGoButtonOnFlexFieldsPage() throws Throwable {
		flexFieldsPageObjects.Go_Btn.click();
	}


	@Then("^Verify that the Flex Field records xml file was successfully downloaded$")
	public void verifyThatTheFlexFieldRecordsXmlFileWasSuccessfullyDownloaded() throws Throwable {
		//Dates starting with 0(for ex :01-01-2021) needs to be stripped to match the fileName
				String currentDate = basePage.getCURRENTDate_initialZeroStripped("M-d-yyyy");
				String FileName = "flexField_export_"+currentDate+".xml";
				Assert.assertEquals(true, basePage.isFileDownloaded(utils.Constant.downloadDirectory, FileName, 60));
				
			}


	@When("^User clicks on Delete option to delete Flex Field$")
	public void userClicksOnDeleteOptionToDeleteFlexField() {
		flexFieldsPageObjects.contextMenuBtn.click();
		flexFieldsPageObjects.contextMenu_Delete_Btn.click();
	}


	@Then("^Verify Flex_Field\\[(\\d+)\\] deleted successfully$")
	public void verifyFlex_FieldDeletedSuccessfully(int index)  {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td")).getText().trim(),"No Results Found");
		
	}
	}





package stepDefinitions.setup;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.CommonPageLocators;
import pageObjects.connect.setup.LookupsPageObjects;
import utils.DriverFactory;

public class ManageLookups extends DriverFactory{

	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public LookupsPageObjects lookupsPageObjects = PageFactory.initElements(driver, LookupsPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);
	
	
	@And("^User clicks on Lookups menu option$")
	public void userClicksOnLookupsMenuOption() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Setup_Lookups.click();
	}

	@And("^User clicks on Add button to add Lookup$")
	public void userClicksOnAddButtonToAddLookup()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		lookupsPageObjects.addBtn.click();
	}

	@And("^User selects Category1 on Lookup Details panel$")
	public void userSelectsCategory1OnLookupDetailsPanel(DataTable table) {
		List<List<String>> data = table.asLists();
		String Category1 = data.get(0).get(1);
		Select Category1_drpDown = new Select(lookupsPageObjects.edit_category1_drpDown);
		Category1_drpDown.selectByVisibleText(Category1);
	}

	@And("^User selects Category2 on Lookup Details panel$")
	public void userSelectsCategory2OnLookupDetailsPanel(DataTable table)  {
		List<List<String>> data = table.asLists();
		String Category2 = data.get(0).get(1);
		Select Category2_drpDown = new Select(lookupsPageObjects.edit_category2_drpDown);
		Category2_drpDown.selectByVisibleText(Category2);
	}

	@And("^User enters Value on Lookup Details panel$")
	public void userEntersValueOnLookupDetailsPanel(DataTable table)  {
		List<List<String>> data = table.asLists();
		String value = data.get(0).get(1);
		lookupsPageObjects.edit_value.clear();
		lookupsPageObjects.edit_value.sendKeys(value);
	}

	@And("^User clicks on Save button to save Lookup details$")
	public void userClicksOnSaveButtonToSaveLookupDetails()  {
		lookupsPageObjects.saveBtn.click();
	}

	@And("^User selects Category1 on Lookup Search panel$")
	public void userSelectsCategory1OnLookupSearchPanel(DataTable table){
		List<List<String>> data = table.asLists();
		String Category1 = data.get(0).get(1);
		Select Category1_drpDown = new Select(lookupsPageObjects.search_category1_drpDown);
		Category1_drpDown.selectByVisibleText(Category1);
	}

	@And("^User selects Category2 on Lookup Search panel$")
	public void userSelectsCategory2nLookupSearchPanel(DataTable table) {
		List<List<String>> data = table.asLists();
		String Category2 = data.get(0).get(1);
		Select Category2_drpDown = new Select(lookupsPageObjects.search_category2_drpDown);
		Category2_drpDown.selectByVisibleText(Category2);
	}

	@And("^User enters Value on Lookup Search panel$")
	public void userEntersValueOnLookupSearchPanel(DataTable table) {
		List<List<String>> data = table.asLists();
		String value = data.get(0).get(1);
		lookupsPageObjects.search_value.clear();
		lookupsPageObjects.search_value.sendKeys(value);
	}

	@And("^User clicks on Search button to search Lookup$")
	public void userClicksOnSearchButtonToSearchLookup() {
		
		lookupsPageObjects.searchBtn.click();
	}

	@Then("^Lookup should be displayed in search results$")
	public void lookupShouldBeDisplayedInSearchResults(DataTable table) {
		List<List<String>> data = table.asLists();
		String Category1 = data.get(0).get(1);
		String Category2 = data.get(1).get(1);
		String value = data.get(2).get(1);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[3]")).getText().trim(), Category1);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[4]")).getText().trim(), Category2);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[8]")).getText().trim(), value);
		
	}

	@Given("^User navigates to the Lookup Search panel$")
	public void userNavigatesToTheLookupSearchPanel() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
	}

	@And("^User clicks on Edit option to edit Lookup$")
	public void userClicksOnEditOptionToEditLookup() {
		lookupsPageObjects.contextMenuBtn.click();
		lookupsPageObjects.contextMenu_Edit_Btn.click();
	}

	@Then("^Verify Lookup details updated successfully$")
	public void verifyLookupDetailsUpdatedSuccessfully(DataTable table) {
		List<List<String>> data = table.asLists();
		String Category1 = data.get(0).get(1);
		String Category2 = data.get(1).get(1);
		String value = data.get(2).get(1);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[3]")).getText().trim(), Category1);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[4]")).getText().trim(), Category2);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[8]")).getText().trim(), value);
	}

	@And("^User clicks on Disable option to disable Lookup$")
	public void userClicksOnDisableOptionToDisableLookup() {
		lookupsPageObjects.contextMenuBtn.click();
		lookupsPageObjects.contextMenu_Disable_Btn.click();
		}

	@Then("^Lookup should be disabled$")
	public void lookupShouldBeDisabled() {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[10]")).getText().trim(), "true");
		
	}

	@And("^User clicks on Enable option to enable Lookup$")
	public void userClicksOnEnableOptionToEnableLookup() {
		lookupsPageObjects.contextMenuBtn.click();
		lookupsPageObjects.contextMenu_Enable_Btn.click();
	}

	@Then("^Lookup should be Enabled$")
	public void lookupShouldBeEnabled()  {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[10]")).getText().trim(), "false");
	}

	@And("^User clicks on Delete option to delete Lookup$")
	public void userClicksOnDeleteOptionToDeleteLookup() {
		lookupsPageObjects.contextMenuBtn.click();
		lookupsPageObjects.contextMenu_Delete_Btn.click();
		driver.switchTo().alert().accept();
	}

	@Then("^Lookup should be Deleted$")
	public void lookupShouldBeDeleted(){
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td")).getText(), "No Results Found");
	}

	@And("^User clicks on Search button to search Lookups$")
	public void userClicksOnSearchButtonToSearchLookups() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		lookupsPageObjects.searchBtn.click();
	}

	@Then("^All Lookups should be displayed in search results$")
	public void allLookupsShouldBeDisplayedInSearchResults() {
		Assert.assertTrue(driver.findElements(By.xpath("//*[@id='unique_id']/tbody/tr")).size()>1);
	}

	@When("^User clicks on checkbox to select all Lookups under search results$")
	public void userClicksOnCheckboxToSelectAllLookupsUnderSearchResults()  {
		lookupsPageObjects.selectAll_checkbox.click();
	}

	@And("^User clicks on Choose an Action drop down on Lookups page$")
	public void userClicksOnChooseAnActionDropDownOnLookupsPage()  {
		lookupsPageObjects.choose_an_action.click();
	}

	@And("^User selects Export as XML on Lookups page$")
	public void userSelectsExportAsXMLOnLookupsPage() {
		Select chooseAnAction_drpDown = new Select(lookupsPageObjects.choose_an_action);
		chooseAnAction_drpDown.selectByVisibleText("Export as XML");
	}

	@And("^User clicks on Go button on Lookups page$")
	public void userClicksOnGoButtonOnLookupsPage() {
		lookupsPageObjects.Go_Btn.click();
	}

	@Then("^Verify that the Lookups records xml file was successfully downloaded$")
	public void verifyThatTheLookupsRecordsXmlFileWasSuccessfullyDownloaded() throws InterruptedException {
		//Dates starting with 0(for ex :01-01-2021) needs to be stripped to match the fileName
		String currentDate = basePage.getCURRENTDate_initialZeroStripped("M-d-yyyy");
		String FileName = "lookup_export_"+currentDate+".xml";
		Assert.assertEquals(basePage.isFileDownloaded(utils.Constant.downloadDirectory, FileName, 300), true);
	}



	
}

package stepDefinitions.setup;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.CommonPageLocators;
import pageObjects.connect.setup.ImportXMLDataPageObjects;
import utils.DriverFactory;

public class ImportXMLData extends DriverFactory{

	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public ImportXMLDataPageObjects importXMLDataPageObjects = PageFactory.initElements(driver, ImportXMLDataPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);
	
	String[] FileNames = {"company_export_"};

	@When("^User clicks on Import XML Data menu option$")
	public void userNavigatesToTheImportXMLDataPage() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Setup_Import_XML_Data.click();
	}
	
	@When("^User Clicks on the Choose File button on Import XML Data page$")
	public void userClicksOnTheChooseFileButtonOnImportXMLDataPage() {
		
	}

	@And("^User selects file to import on Import XML Data page$")
	public void userSelectsFileToImportOnImportXMLDataPage(DataTable table) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		List<List<String>> data = table.asLists();
		String FileName = data.get(0).get(1);
		String currentDate = basePage.getCURRENTDate_initialZeroStripped("M-d-yyyy");
		String FileToImport = FileName+"_"+currentDate+".xml";
		importXMLDataPageObjects.chooseFile_Btn.sendKeys(utils.Constant.downloadDirectory+FileToImport);
	}

	@And("^User clicks on Load button on Import XML Data page$")
	public void userClicksOnLoadButtonOnImportXMLDataPage()  {
		importXMLDataPageObjects.load_Btn.click();
	}

	@And("^User clicks on Import button on Import XML Data page$")
	public void userClicksOnImportButtonOnImportXMLDataPage() throws InterruptedException {
		importXMLDataPageObjects.import_Btn.click();
		Thread.sleep(10000);
	}

	@And("^User checks Update_matched_records checkbox$")
	public void userChecksUpdate_matched_recordsCheckbox()  {
		if(importXMLDataPageObjects.updateExisting_checkbox.isSelected()==false) {
			importXMLDataPageObjects.updateExisting_checkbox.click();
		}
	}

	@And("^User unchecks Update_matched_records checkbox$")
	public void userUnchecksUpdate_matched_recordsCheckbox()  {
		if(importXMLDataPageObjects.updateExisting_checkbox.isSelected()) {
			importXMLDataPageObjects.updateExisting_checkbox.click();
		}
	}

	@Then("^Verify that the records were updated successfully$")
	public void verifyThatTheRecordsWereImportedSuccessfully()  {
		Assert.assertNotEquals(importXMLDataPageObjects.updated_count.getText(), "0");
	}

	@Then("^Verify that the conflicing records were skipped successfully$")
	public void verifyThatTheConflicingRecordsWereSkippedSuccessfully() throws Throwable {
		Assert.assertNotEquals(importXMLDataPageObjects.failed_count.getText(), "0");
	}
	
	@Then("^Verify that the new record was created successfully$")
	public void verifyThatTheNewRecordWasCreatedSuccessfully(){
		Assert.assertEquals(importXMLDataPageObjects.created_count.getText(), "1");
	}

	@And("^User deletes the \"([^\"]*)\" file$")
	public void userDeletesTheFile(String fileName)  {
		
		String currentDate = basePage.getCURRENTDate_initialZeroStripped("M-d-yyyy");
		fileName = fileName+"_"+currentDate;
		basePage.deleteFileFromDirectory(utils.Constant.downloadDirectory, fileName);
	}
	
	
}

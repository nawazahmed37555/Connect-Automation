package stepDefinitions.devices;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.CommonPageLocators;
import pageObjects.connect.devices.PLCsPageObjects;
import utils.DriverFactory;

public class ManagePLCs extends DriverFactory{
	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public PLCsPageObjects plcPageObjects = PageFactory.initElements(driver, PLCsPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);

	@And("^User clicks on PLCs menu option$")
	public void userClicksOnPLCsMenuOption()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Devices_PLCs.click();
	
	}

	@And("^User clicks on Add button to add PLC$")
	public void userClicksOnAddButtonToAddPLC()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		plcPageObjects.addBtn.click();
	}

	@And("^User Enters required detais to add PLC$")
	public void userEntersRequiredDetaisToAddPLC(){
		plcPageObjects.edit_PlcName.sendKeys(plcPageObjects.plc_name[0]);
		plcPageObjects.edit_host.sendKeys(plcPageObjects.hostIP[0]);
		plcPageObjects.edit_port.sendKeys(plcPageObjects.port[0]);
		Select deviceDriver_dropDown = new Select(plcPageObjects.edit_drpDown_deviceDriver);
		deviceDriver_dropDown.selectByIndex(1);
		
		Select company_drpDown = new Select (plcPageObjects.edit_drpDown_company);
		company_drpDown.selectByIndex(1);
	}

	@And("^User clicks on Save button to add PLC$")
	public void userClicksOnSaveButtonToAddPLC()  {
		plcPageObjects.saveBtn.click();
		
	}

	@Then("^Verify PLC is created successfully$")
	public void verifyPLCIsCreatedSuccessfully() {
		Assert.assertEquals(plcPageObjects.searchResults_plcName.getText().trim(), plcPageObjects.plc_name[0]);
	}

	@And("^User enters 'PLCsPageObjects\\.PLC_name\\[(\\d+)\\]' to search a PLC$")
	public void userEntersPLCsPageObjectsPLC_nameToSearchAPLC(int arg1) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		plcPageObjects.search_PLC_name.sendKeys(plcPageObjects.plc_name[arg1]);
	}

	@And("^User clicks on Search button to search PLC$")
	public void userClicksOnSearchButtonToSearchPLC(){
		
		plcPageObjects.searchBtn.click();
	}

	@Then("^PLC 'PLCsPageObjects\\.PLC_name\\[(\\d+)\\]' should be displayed in search results$")
	public void plcPLCsPageObjectsPLC_nameShouldBeDisplayedInSearchResults(int arg1) {
		Assert.assertEquals(plcPageObjects.searchResults_plcName.getText().trim(), plcPageObjects.plc_name[arg1]);
	}

	@When("^User clicks on Edit option to edit PLC$")
	public void userClicksOnEditOptionToEditPLC() {
		
		plcPageObjects.contextMenuBtn.click();
		plcPageObjects.contextMenu_Edit_Btn.click();
	}

	@And("^User changes PLC details$")
	public void userChangesPLCDetails() {
		plcPageObjects.edit_PlcName.clear();
		plcPageObjects.edit_PlcName.sendKeys(plcPageObjects.plc_name[1]);
		plcPageObjects.edit_host.clear();
		plcPageObjects.edit_host.sendKeys(plcPageObjects.hostIP[1]);
		plcPageObjects.edit_port.clear();
		plcPageObjects.edit_port.sendKeys(plcPageObjects.port[1]);
		Select deviceDriver_dropDown = new Select(plcPageObjects.edit_drpDown_deviceDriver);
		deviceDriver_dropDown.selectByIndex(2);
		Select company_drpDown = new Select (plcPageObjects.edit_drpDown_company);
		company_drpDown.selectByIndex(2);
		
	}

	@And("^User clicks on Save button to save PLC details$")
	public void userClicksOnSaveButtonToSavePLCDetails() {
		plcPageObjects.saveBtn.click();
	}

	@Then("^Verify PLC details updated successfully$")
	public void verifyPLCDetailsUpdatedSuccessfully() {
		Assert.assertEquals(plcPageObjects.edit_PlcName.getAttribute("value"),plcPageObjects.plc_name[1]);
		Assert.assertEquals(plcPageObjects.edit_host.getAttribute("value"),plcPageObjects.hostIP[1]);
		Assert.assertEquals(plcPageObjects.edit_port.getAttribute("value"),plcPageObjects.port[1]);
	}

	@And("^User clicks on Search button to search PLCs$")
	public void userClicksOnSearchButtonToSearchPLCs() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		plcPageObjects.searchBtn.click();
	}

	@Then("^All PLCs should be displayed in search results$")
	public void allPLCsShouldBeDisplayedInSearchResults() {
		Assert.assertTrue(driver.findElements(By.xpath("//*[@id='unique_id']/tbody/tr")).size()>1);
	}

	@When("^User clicks on checkbox to select all PLCs under search results$")
	public void userClicksOnCheckboxToSelectAllPLCsUnderSearchResults() {
		plcPageObjects.selectAll_checkbox.click();
	}

	@And("^User clicks on Choose an Action drop down on PLCs page$")
	public void userClicksOnChooseAnActionDropDownOnPLCsPage() {
		plcPageObjects.choose_an_action.click();
	}

	@And("^User selects Export as XML on PLCs page$")
	public void userSelectsExportAsXMLOnPLCsPage()  {
		Select chooseAnAction_drpDown = new Select(plcPageObjects.choose_an_action);
		chooseAnAction_drpDown.selectByVisibleText("Export as XML");
	}

	@And("^User clicks on Go button on PLCs page$")
	public void userClicksOnGoButtonOnPLCsPage() {
		plcPageObjects.Go_Btn.click();
	}

	@Then("^Verify that the PLC records xml file was successfully downloaded$")
	public void verifyThatThePLCRecordsXmlFileWasSuccessfullyDownloaded() throws InterruptedException {
		//Dates starting with 0(for ex :01-01-2021) needs to be stripped to match the fileName
				String currentDate = basePage.getCURRENTDate_initialZeroStripped("M-d-yyyy");
				String FileName = "plc_export_"+currentDate+".xml";
				Assert.assertEquals(basePage.isFileDownloaded(utils.Constant.downloadDirectory, FileName, 300),true);
	}

	@When("^User clicks on Delete option to delete PLC$")
	public void userClicksOnDeleteOptionToDeletePLC(){
		plcPageObjects.contextMenuBtn.click();
		plcPageObjects.contextMenu_Delete_Btn.click();
	}

	@Then("^Verify PLC deleted successfully$")
	public void verifyPLCDeletedSuccessfully()  {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td")).getText(), "No Results Found");

	}


}

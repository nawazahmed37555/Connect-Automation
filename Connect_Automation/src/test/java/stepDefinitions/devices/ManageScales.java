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
import pageObjects.connect.devices.ScalesPageObjects;
import utils.DriverFactory;

public class ManageScales extends DriverFactory {
	
	
	
	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public ScalesPageObjects scalesPageObjects = PageFactory.initElements(driver, ScalesPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);
	
	
	@And("^User clicks on Scales menu option$")
	public void userClicksOnScalesMenuOption() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Devices_Scales.click();
		
	}

	@And("^User clicks on Add button to add Scale$")
	public void userClicksOnAddButtonToAddScale()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		scalesPageObjects.addBtn.click();
	}
	@And("^User Enters scale name 'scalesPageObjects\\.scale_name\\[(\\d+)\\]' on add Scale panel$")
	public void userEntersScaleNameScalesPageObjectsScale_nameOnAddScalePanel(int index)  {
		scalesPageObjects.edit_scaleName.clear();
		scalesPageObjects.edit_scaleName.sendKeys(scalesPageObjects.scale_name[index]);
	}

	@And("^User Enters Host IP 'scalesPageObjects\\.hostIP\\[(\\d+)\\]' on add Scale panel$")
	public void userEntersHostIPScalesPageObjectsHostIPOnAddScalePanel(int index)  {
		scalesPageObjects.edit_host.clear();
		scalesPageObjects.edit_host.sendKeys(scalesPageObjects.hostIP[index]);
			}

	@And("^User Enters Port number 'scalesPageObjects\\.port\\[(\\d+)\\]' on add Scale panel$")
	public void userEntersPortNumberScalesPageObjectsPortOnAddScalePanel(int index)  {
		scalesPageObjects.edit_port.clear();
		scalesPageObjects.edit_port.sendKeys(scalesPageObjects.port[index]);
	}

	@And("^User selects device_driver\\[(\\d+)\\]  on add Scale panel$")
	public void userSelectsDevice_driverOnAddScalePanel(int index) {
		Select deviceDriver_dropDown = new Select(scalesPageObjects.edit_drpDown_deviceDriver);
		deviceDriver_dropDown.selectByIndex(index);
	}


	@And("^User selects company\\[(\\d+)\\]  on add Scale panel$")
	public void userSelectsCompanyOnAddScalePanel(int index) {
		Select company_drpDown = new Select (scalesPageObjects.edit_drpDown_company);
		company_drpDown.selectByIndex(index);
	}

	@And("^User clicks on Save button to add Scale$")
	public void userClicksOnSaveButtonToAddScale()  {
		scalesPageObjects.saveBtn.click();
	}

	@Then("^Verify Scale is created successfully$")
	public void verifyScaleIsCreatedSuccessfully() {
		
		 Assert.assertEquals(scalesPageObjects.searchResults_scaleName.getText().trim(), scalesPageObjects.scale_name[0]);
			
	}

	@And("^User enters 'ScalesPageObjects\\.Scale_name\\[(\\d+)\\]' to search a Scale$")
	public void userEntersScalesPageObjectsScale_nameToSearchAScale(int index)  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		scalesPageObjects.search_scale_name.clear();
		scalesPageObjects.search_scale_name.sendKeys(scalesPageObjects.scale_name[index]);
	}

	@And("^User clicks on Search button to search Scale$")
	public void userClicksOnSearchButtonToSearchScale() {
		scalesPageObjects.searchBtn.click();
	}

	@Then("^Scale 'ScalesPageObjects\\.Scale_name\\[(\\d+)\\]' should be displayed in search results$")
	public void scaleScalesPageObjectsScale_nameShouldBeDisplayedInSearchResults(int index)  {
		Assert.assertEquals(scalesPageObjects.searchResults_scaleName.getText().trim(), scalesPageObjects.scale_name[index]);
	}

	@When("^User clicks on Edit option to edit Scale$")
	public void userClicksOnEditOptionToEditScale() throws Throwable {
		scalesPageObjects.contextMenuBtn.click();
		scalesPageObjects.contextMenu_Edit_Btn.click();
	}

	@And("^User clicks on Save button to save Scale details$")
	public void userClicksOnSaveButtonToSaveScaleDetails() {
		scalesPageObjects.saveBtn.click();
	}

	@Then("^Verify Scale details updated successfully$")
	public void verifyScaleDetailsUpdatedSuccessfully() {
		Assert.assertEquals(scalesPageObjects.edit_scaleName.getAttribute("value"), scalesPageObjects.scale_name[1]);
		Assert.assertEquals(scalesPageObjects.edit_host.getAttribute("value"), scalesPageObjects.hostIP[1]);
		Assert.assertEquals(scalesPageObjects.edit_port.getAttribute("value"), scalesPageObjects.port[1]);
	}

	@And("^User clicks on Search button to search Scales$")
	public void userClicksOnSearchButtonToSearchScales() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		scalesPageObjects.searchBtn.click();
	}

	@Then("^All Scales should be displayed in search results$")
	public void allScalesShouldBeDisplayedInSearchResults()  {
		Assert.assertTrue(driver.findElements(By.xpath("//*[@id='unique_id']/tbody/tr")).size()>1);
		
	}

	@When("^User clicks on checkbox to select all Scales under search results$")
	public void userClicksOnCheckboxToSelectAllScalesUnderSearchResults()  {
		scalesPageObjects.selectAll_checkbox.click();
	}

	@And("^User clicks on Choose an Action drop down on Scales page$")
	public void userClicksOnChooseAnActionDropDownOnScalesPage() {
		scalesPageObjects.choose_an_action.click();
		 
	}

	@And("^User selects Export as XML on Scales page$")
	public void userSelectsExportAsXMLOnScalesPage() {
		Select chooseAnAction_drpDown = new Select(scalesPageObjects.choose_an_action);
		chooseAnAction_drpDown.selectByVisibleText("Export as XML");
		
	}

	@And("^User clicks on Go button on Scales page$")
	public void userClicksOnGoButtonOnScalesPage()  {
		scalesPageObjects.Go_Btn.click();
	}

	@Then("^Verify that the Scale records xml file was successfully downloaded$")
	public void verifyThatTheScaleRecordsXmlFileWasSuccessfullyDownloaded() throws InterruptedException {
		//Dates starting with 0(for ex :01-01-2021) needs to be stripped to match the fileName
				String currentDate = basePage.getCURRENTDate_initialZeroStripped("M-d-yyyy");
				String FileName = "scale_export_"+currentDate+".xml";
				Assert.assertEquals(basePage.isFileDownloaded(utils.Constant.downloadDirectory, FileName, 120),true);
			}

	@When("^User clicks on Delete option to delete Scale$")
	public void userClicksOnDeleteOptionToDeleteScale() {
		scalesPageObjects.contextMenuBtn.click();
		scalesPageObjects.contextMenu_Delete_Btn.click();
	}

	@Then("^Verify Scale deleted successfully$")
	public void verifyScaleDeletedSuccessfully()  {
				Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td")).getText(), "No Results Found");
	}
	
}

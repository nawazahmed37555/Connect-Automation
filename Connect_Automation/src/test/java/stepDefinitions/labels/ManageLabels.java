package stepDefinitions.labels;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.CommonPageLocators;
import pageObjects.connect.labels.LabelsPageObjects;
import utils.DriverFactory;

public class ManageLabels extends DriverFactory {

	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public LabelsPageObjects labelsPageObjects = PageFactory.initElements(driver, LabelsPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);
	
	String labelNames[] = {"Automated_label1","Automated_label2"};

	@When("^User clicks on Label Management menu option$")
	public void userClicksOnLabelManagementMenuOption() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Label_Management.click();
	}

	@And("^User clicks on Labels menu option$")
	public void userClicksOnLabelsMenuOption() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Labels.click();
	}
	@And("^User clicks on Search button to search label\\(s\\)$")
	public void userClicksOnSearchButtonToSearchLabelS()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		labelsPageObjects.searchBtn.click();
	}

	@Then("^All label formats are displayed in the search results$")
	public void allLabelFormatsAreDisplayedInTheSearchResults() {
		Assert.assertTrue(driver.findElements(By.xpath("//*[@id='unique_id']/tbody/tr")).size()>1);
	}

	@And("^User notes down the first label format name from the search results$")
	public void userNotesDownTheFirstLabelFormatNameFromTheSearchResults()  {
		
		//labelFormatName.add(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[3]")).getText());
		
		labelNames[0]=driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[3]")).getText().trim();
		
	}


	@When("^User enters label format name\\[(\\d+)\\] to search$")
	public void userEntersLabelFormatNameToSearch(int index) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		labelsPageObjects.search_formatName.clear();
		labelsPageObjects.search_formatName.sendKeys(labelNames[index]);
	}


	@Then("^Label format\\[(\\d+)\\] is displayed in search results$")
	public void labelFormatIsDisplayedInSearchResults(int index) {
		
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[3]")).getText().trim(), labelNames[index]);
		
	}

	@And("^Click on Edit button edit label details$")
	public void clickOnEditButtonEditLabelDetails()  {
		labelsPageObjects.contextMenuBtn.click();
		labelsPageObjects.contextMenu_Edit_Btn.click();
	}

	@And("^User clicks on Download button to download label format$")
	public void userClicksOnDownloadButtonToDownloadLabelFormat() throws Throwable {
		labelsPageObjects.downloadFormat_Btn.click();
	}

	@Then("^Label format should be downloaded successfully$")
	public void labelFormatShouldBeDownloadedSuccessfully() throws Throwable {
		
	}

	@When("^User clicks on Add button to add label format$")
	public void userClicksOnAddButtonToAddLabelFormat()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		labelsPageObjects.addBtn.click();
	}

	@And("^User enters label format name\\[(\\d+)\\] for the label format$")
	public void userEntersLabelFormatNameForTheLabelFormat(int index)  {
		labelsPageObjects.edit_formatName.clear();
		labelsPageObjects.edit_formatName.sendKeys(labelNames[index]);
	}

	@And("^User selects label format file for the label format$")
	public void userSelectsLabelFormatFileForTheLabelFormat() {
		String labelFilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\label.do";
		labelsPageObjects.edit_fileSelection.sendKeys(labelFilePath);
	}
	
	

	@And("^User selects Language\\[(\\d+)\\] for the label format$")
	public void userSelectsLanguageForTheLabelFormat(int index) throws Throwable {
		Select languageDrpDown= new Select(labelsPageObjects.edit_language_drpDown);
		languageDrpDown.selectByIndex(index);
	}

	@And("^User selects DPI\\[(\\d+)\\] for the label format$")
	public void userSelectsDPIForTheLabelFormat(int index) {
		Select dpiDrpDown= new Select(labelsPageObjects.edit_dpi_drpDown);
		dpiDrpDown.selectByIndex(index);
	}

	@And("^User selects Company\\[(\\d+)\\] for the label format$")

	public void userSelectsCompanyForTheLabelFormat(int index) {
		Select companyDrpDown= new Select(labelsPageObjects.edit_companyId);
		companyDrpDown.selectByIndex(index);
	}
	@And("^User selects Create Label Type option$")
	public void userSelectsCreateLabelTypeOption() throws Throwable {
		if(labelsPageObjects.edit_createLabelType.isSelected()==false) {
			labelsPageObjects.edit_createLabelType.click();
		}
				
	}

	@And("^User clicks on Save button to save label format details$")
	public void userClicksOnSaveButtonToSaveLabelFormatDetails() throws Throwable {
		labelsPageObjects.saveBtn.click();
	}

	@Then("^Label format\\[(\\d+)\\] should be created successfully$")
	public void labelFormatShouldBeCreatedSuccessfully(int index) throws Throwable {
		Assert.assertEquals(labelsPageObjects.edit_formatName.getAttribute("value"), labelNames[index]);
		
	}

	@Then("^Label format\\[(\\d+)\\] details should be saved successfully$")
	public void labelFormatDetailsShouldBeSavedSuccessfully(int index) {
		Assert.assertEquals(labelsPageObjects.edit_formatName.getAttribute("value"), labelNames[index]);
	}

	@And("^User clicks on Disable button to disable label format$")
	public void userClicksOnDisableButtonToDisableLabelFormat() {
		labelsPageObjects.contextMenuBtn.click();
		labelsPageObjects.contextMenu_Disable_Btn.click();
	}

	@Then("^Label format should be disabled successfully$")
	public void labelFormatShouldBeDisabledSuccessfully()  {
	
	}

	@Then("^Label format should be Enabled successfully$")
	public void labelFormatShouldBeEnabledSuccessfully() {
	
	}

	@And("^User clicks on Enable button to Enable label format$")
	public void userClicksOnEnableButtonToEnableLabelFormat() throws Throwable {
		labelsPageObjects.contextMenuBtn.click();
		labelsPageObjects.contextMenu_Enable_Btn.click();
	}

	@And("^User clicks on the delete button to delete label format$")
	public void userClicksOnTheDeleteButtonToDeleteLabelFormat() {
		labelsPageObjects.contextMenuBtn.click();
		labelsPageObjects.contextMenu_Delete_Btn.click();
		
		try {
			driver.switchTo().alert().accept();
		}
		catch (Exception e){
			//do nothing
		}
	}

	@Then("^label format should be deleted successfully$")
	public void labelFormatShouldBeDeletedSuccessfully() {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td")).getText().trim(), "No Results Found");
		
	}

	@Then("^All Label formats should be displayed in search results$")
	public void allLabelFormatsShouldBeDisplayedInSearchResults()  {
		Assert.assertTrue(driver.findElements(By.xpath("//*[@id='unique_id']/tbody/tr")).size()>1);
	}

	@When("^User clicks on checkbox to select all Label formats under search results$")
	public void userClicksOnCheckboxToSelectAllLabelFormatsUnderSearchResults()  {
		labelsPageObjects.selectAll_checkbox.click();
	}

	@And("^User clicks on Choose an Action drop down on Label formats page$")
	public void userClicksOnChooseAnActionDropDownOnLabelFormatsPage() {
		labelsPageObjects.choose_an_action.click();
	}

	@And("^User selects Export as XML on Label formats page$")
	public void userSelectsExportAsXMLOnLabelFormatsPage() {
		Select chooseAnAction_drpDown = new Select(labelsPageObjects.choose_an_action);
		chooseAnAction_drpDown.selectByVisibleText("Export as XML");
		
	}

	@And("^User clicks on Go button on Label formats page$")
	public void userClicksOnGoButtonOnLabelFormatsPage() throws Throwable {
		labelsPageObjects.Go_Btn.click();
	}

	@Then("^Verify that the Label formats records xml file was successfully downloaded$")
	public void verifyThatTheLabelFormatsRecordsXmlFileWasSuccessfullyDownloaded() throws Throwable {
		//Dates starting with 0(for ex :01-01-2021) needs to be stripped to match the fileName
				String currentDate = basePage.getCURRENTDate_initialZeroStripped("M-d-yyyy");
				String FileName = "label_export_"+currentDate+".xml";
				Assert.assertEquals(true, basePage.isFileDownloaded(utils.Constant.downloadDirectory, FileName, 600));
	}

	}
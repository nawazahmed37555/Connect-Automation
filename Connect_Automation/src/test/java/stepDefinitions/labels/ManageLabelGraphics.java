package stepDefinitions.labels;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.CommonPageLocators;
import pageObjects.connect.labels.LabelGraphicsPageObjects;
import utils.DriverFactory;

public class ManageLabelGraphics extends DriverFactory{

	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public LabelGraphicsPageObjects labelGraphicsPageObjects = PageFactory.initElements(driver, LabelGraphicsPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);
	
	public static String labelGraphicNames[] = {"Automated_labelgraphic1","Automated_labelgraphic2"};
	
	@And("^User clicks on Label Grpahics menu option$")
	public void userClicksOnLabelGrpahicsMenuOption() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Labels.click();
		commonPageLocators.menu_Label_Graphics.click();
	}

	@When("^User clicks on Search button to search label graphic\\(s\\)$")
	public void userClicksOnSearchButtonToSearchLabelGraphicS(){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		labelGraphicsPageObjects.searchBtn.click();
	}

	@And("^User notes down the first graphic name from the search results$")

	public void userNotesDownTheFirstGraphicNameFromTheSearchResults() throws Throwable {
		labelGraphicNames[0] = driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[3]")).getText().trim();
	}

	@When("^User enters Label Graphic name\\[(\\d+)\\] to search$")
	public void userEntersLabelGraphicNameToSearch(int index) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		labelGraphicsPageObjects.search_graphicName.clear();
		labelGraphicsPageObjects.search_graphicName.sendKeys(labelGraphicNames[index]);
	}

	@Then("^Label Graphic\\[(\\d+)\\] is displayed in search results$")
	public void labelGraphicIsDisplayedInSearchResults(int index){
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[3]")).getText().trim(),labelGraphicNames[index] );
	}

	@And("^Click on Edit button edit label graphic details$")
	public void clickOnEditButtonEditLabelGraphicDetails() {
		labelGraphicsPageObjects.contextMenuBtn.click();
		labelGraphicsPageObjects.contextMenu_Edit_Btn.click();
	}

	@And("^User enters Label Graphic name\\[(\\d+)\\] for the Label Graphic$")
	public void userEntersLabelGraphicNameForTheLabelGraphic(int index) throws Throwable {
		labelGraphicsPageObjects.edit_graphicName.clear();
		labelGraphicsPageObjects.edit_graphicName.sendKeys(labelGraphicNames[index]);
	}

	@And("^User clicks on Save button to save Label Graphic details$")
	public void userClicksOnSaveButtonToSaveLabelGraphicDetails() throws Throwable {
		labelGraphicsPageObjects.saveBtn.click();
	}

	@Then("^Label Graphic\\[(\\d+)\\] details should be updated successfully$")
	public void labelGraphicDetailsShouldBeUpdatedSuccessfully(int index) throws Throwable {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[3]")).getText().trim(),labelGraphicNames[index] );

	}

	@And("^User clicks on the delete button to delete Label Graphic$")
	public void userClicksOnTheDeleteButtonToDeleteLabelGraphic()  {
		labelGraphicsPageObjects.contextMenuBtn.click();
		labelGraphicsPageObjects.contextMenu_Delete_Btn.click();
	}

	@Then("^Label Graphic should be deleted successfully$")
	public void labelGraphicShouldBeDeletedSuccessfully() {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td")).getText().trim(),"No Results Found" );

	}

	@Then("^All Label Graphics should be displayed in search results$")

	public void allLabelGraphicsShouldBeDisplayedInSearchResults() throws Throwable {
		Assert.assertTrue(driver.findElements(By.xpath("//*[@id='unique_id']/tbody/tr")).size()>1);
	}

	@When("^User clicks on checkbox to select all Label Graphics under search results$")
	public void userClicksOnCheckboxToSelectAllLabelGraphicsUnderSearchResults() throws Throwable {
		labelGraphicsPageObjects.selectAll_checkbox.click();
	}

	@And("^User clicks on Choose an Action drop down on Label Graphics page$")
	public void userClicksOnChooseAnActionDropDownOnLabelGraphicsPage()  {
		labelGraphicsPageObjects.choose_an_action.click();
	}

	@And("^User selects Export as XML on Label Graphics page$")
	public void userSelectsExportAsXMLOnLabelGraphicsPage() {
		Select chooseAnAction_drpDown = new Select(labelGraphicsPageObjects.choose_an_action);
		chooseAnAction_drpDown.selectByVisibleText("Export as XML");
	}

	@And("^User clicks on Go button on Label Graphics page$")
	public void userClicksOnGoButtonOnLabelGraphicsPage() {
		labelGraphicsPageObjects.Go_Btn.click();	
	}

	@Then("^Verify that the Label Graphics records xml file was successfully downloaded$")
	public void verifyThatTheLabelGraphicsRecordsXmlFileWasSuccessfullyDownloaded() throws InterruptedException {
		//Dates starting with 0(for ex :01-01-2021) needs to be stripped to match the fileName
		String currentDate = basePage.getCURRENTDate_initialZeroStripped("M-d-yyyy");
		String FileName = "label_graphic_export_"+currentDate+".xml";
		Assert.assertEquals(true, basePage.isFileDownloaded(utils.Constant.downloadDirectory, FileName, 600));

	}
}

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
import pageObjects.connect.setup.PagesPageObjects;
import utils.DriverFactory;

public class ManagePages extends DriverFactory {
	public String[] page_name = {"Automated_page1","Automated_page2"};
	public String[] description = {"Automated Desciption 1","Automated Description 2"};
	public String[] display_name = {"Automated_field1","Automated_field2"};
	public List<String> selectedResponsibilities = new ArrayList<String>();
	public List<String> selectedNamespaces = new ArrayList<String>();
	
	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public PagesPageObjects pagesPageObjects = PageFactory.initElements(driver, PagesPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);

	@And("^User clicks on Pages menu option$")
	public void userClicksOnPagesMenuOption()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Setup_Pages.click();
	}

	@And("^User clicks on Add button to add Page$")
	public void userClicksOnAddButtonToAddPage()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		pagesPageObjects.addBtn.click();
	}

	@And("^User enters Page_name\\[(\\d+)\\] on Page Details panel$")
	public void userEntersPage_nameOnPageDetailsPanel(int index)  {
		pagesPageObjects.edit_pageName.clear();
		pagesPageObjects.edit_pageName.sendKeys(page_name[index]);
	}

	@And("^User enters Description\\[(\\d+)\\] on Page Details panel$")
	public void userEntersDescriptionOnPageDetailsPanel(int index)  {
		pagesPageObjects.edit_description.clear();
		pagesPageObjects.edit_description.sendKeys(description[index]);
	}

	@And("^User selects Application\\[(\\d+)\\] on Page Details panel$")
	public void userSelectsApplicationOnPageDetailsPanel(int index)  {
		Select application_drpDown = new Select(pagesPageObjects.edit_application_drpDown);
		if(application_drpDown.getOptions().size()>index) {
			application_drpDown.selectByIndex(index);
		}
		else
		{	
			Assert.fail("There is no option  with index " +index+ " in dropdown "+ pagesPageObjects.edit_application_drpDown.getAttribute("name"));
		}
	}

	@And("^User clicks on Save button to save Page details$")
	public void userClicksOnSaveButtonToSavePageDetails() {
		pagesPageObjects.saveBtn.click();
	}


	@Then("^Verify Page with Page_name\\[(\\d+)\\] is created successfully$")
	public void verifyPageWithPage_nameIsCreatedSuccessfully(int index) {
		Assert.assertEquals(pagesPageObjects.searchResult.getText().trim(), page_name[index]);
	}

	@And("^User enters Page_name\\[(\\d+)\\] to search a Page$")
	public void userEntersPage_nameToSearchAPage(int index) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		pagesPageObjects.search_page_name.clear();
		pagesPageObjects.search_page_name.sendKeys(page_name[index]);
		}

	@And("^User clicks on Search button to search Page$")
	public void userClicksOnSearchButtonToSearchPage()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		pagesPageObjects.searchBtn.click();
	}

	@Then("^Page with Page_name\\[(\\d+)\\] should be displayed in search results$")
	public void pageWithPage_nameShouldBeDisplayedInSearchResults(int index) {
		Assert.assertEquals(pagesPageObjects.searchResult.getText().trim(), page_name[index]);
	}

	@And("^User clicks on Edit option to edit Page$")
	public void userClicksOnEditOptionToEditPage()  {
		pagesPageObjects.contextMenuBtn.click();
		pagesPageObjects.contextMenu_Edit_Btn.click();
	}

	@Then("^Verify Page\\[(\\d+)\\] details updated successfully$")
	public void verifyPageDetailsUpdatedSuccessfully(int index) {
		Assert.assertEquals(pagesPageObjects.edit_pageName.getAttribute("value"),page_name[index] );
		Assert.assertEquals(pagesPageObjects.edit_description.getAttribute("value"),description[index] );
	}

	@And("^User clicks on the Responsibilities tab on Page Details panel$")
	public void userClicksOnTheResponsibilitiesTabOnPageDetailsPanel()  {
		pagesPageObjects.edit_responsibilitiesTab.click();
	}


	@And("^User selects responsibility\\[(\\d+)\\] to assign to the Page$")
	public void userSelectsResponsibilityToAssignToThePage(int index) {
		
		selectedResponsibilities=basePage.selectDropDownOptionByIndex(pagesPageObjects.unassigned_ResponsibilitiesList,index , selectedResponsibilities);
		}

	@And("^User clicks on Add button to assign the reponsibility to the Page$")
	public void userClicksOnAddButtonToAssignTheReponsibilityToThePage() {
		pagesPageObjects.edit_addBtn.click();
	}

	@Then("^Verify responsibilities are assigned to the Page$")
	public void verifyAllResponsibilitiesAreAssignedToThePage() {
		basePage.compareDropdownoptions(pagesPageObjects.assigned_ResponsibilitiesList, selectedResponsibilities);
	}

	@And("^User clicks on the Namespcae tab on Page Details panel$")
	public void userClicksOnTheNamespcaeTabOnPageDetailsPanel() throws Throwable {
		pagesPageObjects.edit_namespacesTab.click();
	}

	@And("^User selects Namespace\\[(\\d+)\\] to assign to the Page$")
	public void userSelectsNamespaceToAssignToThePage(int index) throws Throwable {
		selectedNamespaces =basePage.selectDropDownOptionByIndex(pagesPageObjects.unassigned_NamespacesList,index , selectedNamespaces);
		
	}

	@And("^User clicks on Add button to assign the Namespace to the Page$")
	public void userClicksOnAddButtonToAssignTheNamespaceToThePage()  {
		pagesPageObjects.edit_addBtn.click();
	}

	@Then("^Verify Namespaces are assigned to the Page$")
	public void verifyNamespacesAreAssignedToThePage() {
		basePage.compareDropdownoptions(pagesPageObjects.assigned_NamespacesList,selectedNamespaces );
	}

	@And("^User clicks on Search button to search Pages$")
	public void userClicksOnSearchButtonToSearchPages()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		pagesPageObjects.searchBtn.click();
	}

	@Then("^All Pages should be displayed in search results$")
	public void allPagesShouldBeDisplayedInSearchResults()  {
		//Assert.assertTrue(driver.findElements(pagesPageObjects.searchResults).size()>1);
		Assert.assertTrue(driver.findElements(By.xpath("//*[@id='unique_id']/tbody/tr")).size()>1);
	}

	@When("^User clicks on checkbox to select all Pages under search results$")
	public void userClicksOnCheckboxToSelectAllPagesUnderSearchResults()  {
		pagesPageObjects.selectAll_checkbox.click();
	}

	@And("^User clicks on Choose an Action drop down on Pages page$")
	public void userClicksOnChooseAnActionDropDownOnPagesPage() {
		pagesPageObjects.choose_an_action.click();
	}

	@And("^User selects Export as XML on Pages page$")
	public void userSelectsExportAsXMLOnPagesPage()  {
		Select chooseAnAction_drpDown = new Select(pagesPageObjects.choose_an_action);
		chooseAnAction_drpDown.selectByVisibleText("Export as XML");
	}

	@And("^User clicks on Go button on Pages page$")
	public void userClicksOnGoButtonOnPagesPage()  {
		pagesPageObjects.Go_Btn.click();
	}

	@Then("^Verify that the Page records xml file was successfully downloaded$")
	public void verifyThatThePageRecordsXmlFileWasSuccessfullyDownloaded() throws InterruptedException  {
		//Dates starting with 0(for ex :01-01-2021) needs to be stripped to match the fileName 1-1-2021
				String currentDate = basePage.getCURRENTDate_initialZeroStripped("M-d-yyyy");
				String FileName = "page_export_"+currentDate+".xml";
				Assert.assertEquals(true, basePage.isFileDownloaded(utils.Constant.downloadDirectory, FileName, 60));
	}

	@When("^User clicks on Delete option to delete Page$")
	public void userClicksOnDeleteOptionToDeletePage()  {
		pagesPageObjects.contextMenuBtn.click();
		pagesPageObjects.contextMenu_Delete_Btn.click();
	}

	@Then("^Verify Page deleted successfully$")
	public void verifyPageDeletedSuccessfully()  {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td")).getText(), "No Results Found");

	}

}

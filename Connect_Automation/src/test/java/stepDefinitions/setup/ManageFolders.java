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
import pageObjects.connect.setup.FoldersPageObjects;
import pageObjects.endeavour.EndeavourCommonPageObjects;
import utils.DriverFactory;

public class ManageFolders extends DriverFactory{
	public String[] folder_name = {"Automated_folder1","Automated_folder2", "Copy of Automated_folder2"};
	public List<String> selectedSupplierUsers = new ArrayList<String>();
	public List<String> selectedBuyerUsers = new ArrayList<String>();
	
	
	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public FoldersPageObjects foldersPageObjects = PageFactory.initElements(driver, FoldersPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);
	public EndeavourCommonPageObjects endeavourPageObjects = PageFactory.initElements(driver, EndeavourCommonPageObjects.class);


	@And("^User clicks on Folders menu option$")
	public void userClicksOnFoldersMenuOption()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Setup_Folders.click();
	}

	@And("^User clicks on Add button to add Folder$")
	public void userClicksOnAddButtonToAddFolder()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		foldersPageObjects.addBtn.click();
	}

	@And("^User enters Folder_name\\[(\\d+)\\] on Folder Details panel$")
	public void userEntersFolder_nameOnFolderDetailsPanel(int index)  {
		foldersPageObjects.edit_folderName.clear();
		foldersPageObjects.edit_folderName.sendKeys(folder_name[index]);
	}

	@And("^User selects Application_Name\\[(\\d+)\\] on Folder Details panel$")
	public void userSelectsApplication_NameOnFolderDetailsPanel(int index)  {
		Select applicationName_drpDown = new Select(foldersPageObjects.edit_applicationName_drpDown);
		applicationName_drpDown.selectByIndex(index);
	}

	@And("^User selects Page_Name\\[(\\d+)\\] on Folder Details panel$")
	public void userSelectsPage_NameOnFolderDetailsPanel(int index) {
		
		Select applicationName_drpDown = new Select(foldersPageObjects.edit_PageName_drpDown);
		if(applicationName_drpDown.getOptions().size()>1) {
		applicationName_drpDown.selectByIndex(index);
		}
		else {
			Assert.fail("There are no options available to select in the dropdown " + foldersPageObjects.edit_namespace_drpDown.getAttribute("name"));
		}
	}
	@And("^User selects a Namespace\\[(\\d+)\\] on Folder Details panel$")
	public void userSelectsANamespaceOnFolderDetailsPanel(int index)  {
		Select nameSpace_drpDown = new Select(foldersPageObjects.edit_namespace_drpDown);
		if(nameSpace_drpDown.getOptions().size()>0) {
			nameSpace_drpDown.selectByIndex(index);
		}
		else {
			Assert.fail("There are no options available to select in the dropdown " + foldersPageObjects.edit_namespace_drpDown.getAttribute("name"));
		}
	}
	@And("^User selects Field\\[(\\d+)\\] on Folder Details panel$")
	public void userSelectsFieldOnFolderDetailsPanel(int index) {
		Select fields_drpDown = new Select(foldersPageObjects.edit_fields_drpDown);
		if(fields_drpDown.getOptions().size()>0) {
			fields_drpDown.selectByIndex(index);
		}
		else {
			Assert.fail("There are no options available to select in the dropdown " + foldersPageObjects.edit_fields_drpDown.getAttribute("name"));
		}
	}
	@And("^User clicks on Assign button to assign fields to the Folder$")
	public void userClicksOnAssignButtonToAssignFieldsToTheFolder()  {
		foldersPageObjects.edit_addBtn.click();
	}

	@And("^User clicks on Save button to save Folder details$")
	public void userClicksOnSaveButtonToSaveFolderDetails()  {
		
		foldersPageObjects.saveBtn.click();
	}

	@Then("^Verify Folder with Folder_name\\[(\\d+)\\] is created successfully$")
	public void verifyFolderWithFolder_nameIsCreatedSuccessfully(int index)  {
		Assert.assertEquals(foldersPageObjects.searchResult.getText().trim(), folder_name[index]);
	}

	@And("^User enters Folder_name\\[(\\d+)\\] to search a Folder$")
	public void userEntersFolder_nameToSearchAFolder(int index){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		foldersPageObjects.search_folderName.clear();
		foldersPageObjects.search_folderName.sendKeys(folder_name[index]);
	}

	@And("^User clicks on Search button to search Folder$")
	public void userClicksOnSearchButtonToSearchFolder()  {
		foldersPageObjects.searchBtn.click();
	}

	@Then("^Folder with Folder_name\\[(\\d+)\\] should be displayed in search results$")
	public void folderWithFolder_nameShouldBeDisplayedInSearchResults(int index) {
		Assert.assertEquals(foldersPageObjects.searchResult.getText().trim(), folder_name[index]);
	}

	@And("^User clicks on Edit option to edit Folder$")
	public void userClicksOnEditOptionToEditFolder()  {
		foldersPageObjects.contextMenuBtn.click();
		foldersPageObjects.contextMenu_Edit_Btn.click();
	}

	@Then("^Verify Folder\\[(\\d+)\\] details updated successfully$")
	public void verifyFolderDetailsUpdatedSuccessfully(int index) {
		Assert.assertEquals(foldersPageObjects.edit_folderName.getAttribute("value"),folder_name[index] );
	}

	@And("^User clicks on Supplier tab on Folder Details panel$")
	public void userClicksOnSupplierTabOnFolderDetailsPanel()  {
		foldersPageObjects.SupplierCompanies_Tab.click();;
		
	}


	@And("^User selects a supplier_company\\[(\\d+)\\] to assign to the Folder$")
	public void userSelectsASupplier_companyToAssignToTheFolder(int index) {
		Select supplierCompany_drpDown = new Select (foldersPageObjects.companies_DrpDown);
		if(supplierCompany_drpDown.getOptions().size()>0) {
			supplierCompany_drpDown.selectByIndex(index);
			}
			else {
				Assert.fail("There are no options available to select in the dropdown " + foldersPageObjects.companies_DrpDown.getAttribute("name"));
			}
	}

	@And("^User selects supplier_User\\[(\\d+)\\] to assign to the folder$")
	public void userSelectsSupplier_UserToAssignToTheFolder(int index)  {
		Select supplierUsers_drpDown = new Select (foldersPageObjects.users_drpDown);
			if(supplierUsers_drpDown.getOptions().size()>0) {
				supplierUsers_drpDown.selectByIndex(index);
				selectedSupplierUsers.add(supplierUsers_drpDown.getFirstSelectedOption().getText());
			}
			else {
				Assert.fail("There are no options available to select in the dropdown " + foldersPageObjects.users_drpDown.getAttribute("name"));
			}
	}

	@And("^User clicks on assign button to assign the supplier user to the folder$")
	public void userClicksOnAssignButtonToAssignTheSupplierCompanyToTheFolder() {
		foldersPageObjects.edit_addBtn.click();
	}

	@Then("^Supplier_user\\[(\\d+)\\] should be assigned to the folder$")
	public void supplier_companyShouldBeAssignedToTheFolder(int index)  {
		Assert.assertEquals(basePage.compareDropdownoptions(foldersPageObjects.selectedUsers_drpDown, selectedSupplierUsers), true);
		
	}


	@And("^User clicks on Buyer tab on Folder Details panel$")
	public void userClicksOnBuyerTabOnFolderDetailsPanel()  {
		foldersPageObjects.BuyerCompanies_Tab.click();
	}


	@And("^User selects a Buyer_company\\[(\\d+)\\] to assign to the Folder$")
	public void userSelectsABuyer_companyToAssignToTheFolder(int index) {
		Select buyerCompany_drpDown = new Select (foldersPageObjects.companies_DrpDown);
		if(buyerCompany_drpDown.getOptions().size()>0) {
			buyerCompany_drpDown.selectByIndex(index);
			}
			else {
				Assert.fail("There are no options available to select in the dropdown " + foldersPageObjects.companies_DrpDown.getAttribute("name"));
			}
	}


	@And("^User selects Buyer_User\\[(\\d+)\\] to assign to the folder$")
	public void userSelectsBuyer_UserToAssignToTheFolder(int index) {
		Select buyerUsers_drpDown = new Select (foldersPageObjects.users_drpDown);
		if(buyerUsers_drpDown.getOptions().size()>0) {
			buyerUsers_drpDown.selectByIndex(index);
			selectedBuyerUsers.add(buyerUsers_drpDown.getFirstSelectedOption().getText());
		}
		else {
			Assert.fail("There are no options available to select in the dropdown " + foldersPageObjects.users_drpDown.getAttribute("name"));
		}
	}

	@And("^User clicks on assign button to assign the Buyer User to the folder$")
	public void userClicksOnAssignButtonToAssignTheBuyerCompanyToTheFolder() {
		foldersPageObjects.edit_addBtn.click();
	}
	@Then("^Buyer_User\\[(\\d+)\\] should be assigned to the folder$")
	public void buyer_companyShouldBeAssignedToTheFolder(int index)  {
		Assert.assertEquals(basePage.compareDropdownoptions(foldersPageObjects.selectedUsers_drpDown,selectedBuyerUsers ), true);
	}


	@And("^User clicks on Search button to search Folders$")
	public void userClicksOnSearchButtonToSearchFolders() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		foldersPageObjects.searchBtn.click();
	}

	@Then("^All Folders should be displayed in search results$")
	public void allFoldersShouldBeDisplayedInSearchResults()  {
		Assert.assertTrue(driver.findElements(By.xpath("//*[@id='unique_id']/tbody/tr")).size()>1);
	}

	@When("^User clicks on checkbox to select all Folders under search results$")
	public void userClicksOnCheckboxToSelectAllFoldersUnderSearchResults()  {
		foldersPageObjects.selectAll_checkbox.click();
	}

	@And("^User clicks on Choose an Action drop down on Folders page$")
	public void userClicksOnChooseAnActionDropDownOnFoldersPage() {
		foldersPageObjects.choose_an_action.click();
	}

	@And("^User selects Export as XML on Folders page$")
	public void userSelectsExportAsXMLOnFoldersPage() {
		Select chooseAnAction_drpDown = new Select(foldersPageObjects.choose_an_action);
		chooseAnAction_drpDown.selectByVisibleText("Export as XML");
	}

	@And("^User clicks on Go button on Folders page$")
	public void userClicksOnGoButtonOnFoldersPage()  {
		foldersPageObjects.Go_Btn.click();
	}

	@Then("^Verify that the Folder records xml file was successfully downloaded$")
	public void verifyThatTheFolderRecordsXmlFileWasSuccessfullyDownloaded() throws InterruptedException  {
		//Dates starting with 0(for ex :01-01-2021) needs to be stripped to match the fileName
				String currentDate = basePage.getCURRENTDate_initialZeroStripped("M-d-yyyy");
				String FileName = "folder_export_"+currentDate+".xml";
				Assert.assertEquals(basePage.isFileDownloaded(utils.Constant.downloadDirectory, FileName, 60), true);
			
	}

	@When("^User clicks on Delete option to delete Folder$")
	public void userClicksOnDeleteOptionToDeleteFolder() throws Throwable {
		foldersPageObjects.contextMenuBtn.click();
		foldersPageObjects.contextMenu_Delete_Btn.click();
		driver.switchTo().alert().accept();
	}

	@Then("^Verify Folder\\[(\\d+)\\] deleted successfully$")
	public void verifyFolderDeletedSuccessfully(int index) throws Throwable {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td")).getText(), "No Results Found");
	}

	@And("^User clicks on Copy option to copy Folder$")
	public void userClicksOnCopyOptionToCopyFolder() {
		foldersPageObjects.contextMenuBtn.click();
		foldersPageObjects.contextMenu_Copy_Btn.click();
	}

	@Then("^Verify that a copy of the folder\\[(\\d+)\\] is created successfully$")
	public void verifyThatACopyOfTheFolderIsCreatedSuccessfully(int index) {
		Assert.assertEquals(foldersPageObjects.searchResult.getText().trim(), "Copy of "+folder_name[index]);	}

	@And("^User clicks on Accounts Payable menu option$")
	public void userClicksOnAccountsPayableMenuOption() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		endeavourPageObjects.Accounts_Payable.click();
	}

	@And("^User clicks on Search Invoices menu option$")
	public void userClicksOnSearchInvoicesMenuOption(){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		endeavourPageObjects.Search_Invoices.click();
	}

	@And("^User clicks on Search folder dropdown$")
	public void userClicksOnSearchFolderDropdown() throws InterruptedException  {
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame(commonPageLocators.body_frame);
		endeavourPageObjects.searchFolder_drpDown.click();
	}

	@Then("^Folder with Folder_name\\[(\\d+)\\] should be displayed in the Search folder dropdown$")
	public void folderWithFolder_nameShouldBeDisplayedInTheSearchFolderDropdown(int index) {
	Select searchFolder_drpDown = new Select(endeavourPageObjects.searchFolder_drpDown);
	searchFolder_drpDown.selectByVisibleText(folder_name[index]);
	Assert.assertEquals(searchFolder_drpDown.getFirstSelectedOption().getText(),folder_name[index]);
	}
}

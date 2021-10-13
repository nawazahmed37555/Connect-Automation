package stepDefinitions;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.BasePage;
import pageObjects.CommonPageLocators;
import pageObjects.connect.CompaniesPageObjects;

import utils.DriverFactory;
import utils.JsonConfigReader;

public class ManageCompanies extends DriverFactory {

	JsonConfigReader reader = new JsonConfigReader();
	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public CompaniesPageObjects companiesPageObjects = PageFactory.initElements(driver, CompaniesPageObjects.class);
	
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);
	
	@When("^User clicks on Companies menu option$")
	public void user_clicks_on_Companies_menu_option() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Companies.click();
		}

	@And("^User clicks on Add button to add Company$")
	public void user_clicks_on_Add_button_to_add_Company() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		companiesPageObjects.addBtn.click();
	}


	@And("^User Enters required detais to add company$")
	public void user_Enters_required_detais_to_add_company() throws InterruptedException {
		
		companiesPageObjects.edit_companyName.sendKeys(companiesPageObjects.company_name[0]);
		companiesPageObjects.edit_companyCode.sendKeys(companiesPageObjects.company_code[0]);
		//companiesPageObjects.edit_companyPrintToPDF.click();
		
	}

	
	@And("^User clicks on Save button to add company$")
	public void user_clicks_on_Save_button() {
	    companiesPageObjects.saveBtn.click();
		//System.out.println("There is no way to delete a company record,That is why adding new records is not feasible.");
		
	}

	
	@Then("^Company record is created successfully$")
	public void company_record_is_created_successfully() {
		Assert.assertEquals(companiesPageObjects.company_name[0], companiesPageObjects.edit_companyName.getAttribute("value"));
			}

	@And("^User enters search criteria to search a company$")
	public void userEntersSearchCriteriaToSearchACompany() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		companiesPageObjects.search_companyName.sendKeys(companiesPageObjects.company_name[0]);
	}

	@And("^User clicks on Search button to search Company$")
	public void userClicksOnSearchButtonToSearchCompany() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		companiesPageObjects.searchBtn.click();
	}

	@Then("^Company should be displayed in search results$")
	public void companyShouldBeDisplayedInSearchResults() {
		Assert.assertEquals(companiesPageObjects.company_name[0],companiesPageObjects.searchResults_companyName.getText().trim());
	}

	@When("^User clicks on Disable option to disable company$")
	public void userClicksOnDisableOptionToDisableCompany() {
		companiesPageObjects.contextMenuBtn.click();
		companiesPageObjects.contextMenu_Disable_Btn.click();
	}

	
	@Then("^Verify that the Company is disabled$")
	public void verifyThatTheCompanyIsDisabled()  {
		
		List<WebElement>  headerCoulmns = driver.findElements(By.xpath("//*[@id='unique_id']/tbody/tr[1]/td"));
		for (int i=0; i<headerCoulmns.size();i++) {
			if (headerCoulmns.get(i).getText().equalsIgnoreCase("Disabled")){
				int index = i+1;
				String CompanyStatus = "//*[@id='unique_id']/tbody/tr[2]/td["+index+"]";
				Assert.assertEquals(driver.findElement(By.xpath(CompanyStatus)).getText().trim(),"Yes");
			}
		}
	}

	@When("^User clicks on Enable option$")
	public void userClicksOnEnableOption() {
		companiesPageObjects.contextMenuBtn.click();
		companiesPageObjects.contextMenu_Enable_Btn.click();
	}

	@Then("^Verify that the Company is Enabled$")
	public void verifyThatTheCompanyIsEnabled()  {
		List<WebElement>  headerCoulmns = driver.findElements(By.xpath("//*[@id='unique_id']/tbody/tr[1]/td"));
		for (int i=0; i<headerCoulmns.size();i++) {
			if (headerCoulmns.get(i).getText().equalsIgnoreCase("Disabled")){
				int index = i+1;
				String CompanyStatus = "//*[@id='unique_id']/tbody/tr[2]/td["+index+"]";
				Assert.assertEquals(driver.findElement(By.xpath(CompanyStatus)).getText().trim(),"No");
			}
		}
	}

	@Then("^All companies should be displayed in search results$")
	public void allCompaniesShouldBeDisplayedInSearchResults()  {
		//Confirm if there any  company records available or not.
		Assert.assertTrue(driver.findElements(By.xpath("//*[@id='unique_id']/tbody/tr")).size()>1);
		
	}

	@When("^User clicks on checkbox to select all companies under search results$")
	public void userClicksOnCheckboxToSelectAllCompaniesUnderSearchResults()  {
		
		companiesPageObjects.selectAll_Checkbox.click();
	}

	@And("^User clicks on Choose an Action drop down on Companies page$")
	public void userClicksOnChooseAnActionDropDown() {
		companiesPageObjects.actionList.click();
	}

	@And("^User selects Export as XML on Companies page$")
	public void userSelectsExportAsXML()  {
		Select chooseAnAction = new Select (companiesPageObjects.actionList) ;
		chooseAnAction.selectByVisibleText("Export as XML");
		
	}

	@And("^User clicks on Go button on Companies page$")
	public void userClicksOnGoButton() throws InterruptedException {
		
		companiesPageObjects.Go_Btn.click();
			
	}

	@Then("^Verify that the company records xml file was successfully downloaded$")
	public void verifyThatTheCompanyRecordsXmlFileWasSuccessfullyDownloaded() throws Throwable {
			//Dates starting with 0(for ex :01-01-2021) needs to be stripped to match the fileName
				String currentDate = basePage.getCURRENTDate_initialZeroStripped("M-d-yyyy");
				String FileName = "company_export_"+currentDate+".xml";
				Assert.assertEquals(basePage.isFileDownloaded(utils.Constant.downloadDirectory, FileName, 120), true);
				
	}

	@When("^User clicks on Edit option to edit company details$")
	public void userClicksOnEditOptionToEditCompanyDetails() {
		companiesPageObjects.contextMenuBtn.click();
		companiesPageObjects.contextMenu_Edit_Btn.click();
	}

	@And("^User changes company details$")
	public void userChangesCompanyDetails() {
		companiesPageObjects.edit_companyName.clear();
		companiesPageObjects.edit_companyName.sendKeys(companiesPageObjects.company_name[1]);
		companiesPageObjects.edit_companyCode.clear();
		companiesPageObjects.edit_companyCode.sendKeys(companiesPageObjects.company_code[1]);
		
	}

	@And("^User clicks on Save button to save company details$")
	public void userClicksOnSaveButtonToSaveCompanyDetails()  {
		companiesPageObjects.saveBtn.click();
	}

	@Then("^Verify company details updated successfully$")
	public void verifyCompanyDetailsUpdatedSuccessfully() throws Throwable {
		Assert.assertEquals(companiesPageObjects.company_name[1], companiesPageObjects.edit_companyName.getAttribute("value"));
		Assert.assertEquals(companiesPageObjects.company_code[1], companiesPageObjects.edit_companyCode.getAttribute("value"));
	}

	
}

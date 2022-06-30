package stepDefinitions.rules;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.CommonPageLocators;
import pageObjects.connect.rules.RuleDefinitionsPageObjects;

import utils.DriverFactory;


public class RuleDefinitions extends DriverFactory{
	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public RuleDefinitionsPageObjects ruleDefinitionsPageObjects = PageFactory.initElements(driver, RuleDefinitionsPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);
	
	String[] ruleDeninitionName = {"Automated_rule1","Automated_rule2"};
	String[] ruleInstanceName = {"Automated_ruleInstance1","Automated_ruleInstance2"};
	
	@When("^User clicks on Rules menu option$")
	public void userClicksOnRulesMenuOption()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Rules.click();
	}

	@And("^User clicks on Rule Definitions menu option$")
	public void userClicksOnRuleDefinitionsMenuOption() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Rule_Definitions.click();
	}

	@When("^User clicks on Add button to add rule definition$")
	public void userClicksOnAddButtonToAddRuleDefinition() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		ruleDefinitionsPageObjects.addBtn.click();
	}

	@And("^User enters rule difinition name\\[(\\d+)\\]$")
	public void userEntersRuleDifinitionName(int index)  {
		ruleDefinitionsPageObjects.edit_RuleDefinition_name.clear();
		ruleDefinitionsPageObjects.edit_RuleDefinition_name.sendKeys(ruleDeninitionName[index]);
	}

	@And("^User selects rule type for the rule definition\\[(\\d+)\\]$")
	public void userSelectsRuleTypeForTheRuleDefinition(int index) throws Throwable {
		Select ruleTypedrpDown =  new Select(ruleDefinitionsPageObjects.edit_ruleType_drpDown);
		ruleTypedrpDown.selectByIndex(index);
	}

	@And("^User selects Company for the rule definition\\[(\\d+)\\]$")
	public void userSelectsCompanyForTheRuleDefinition(int index) throws Throwable {
		Select companydrpDown =  new Select(ruleDefinitionsPageObjects.edit_companyId_drpDown);
		companydrpDown.selectByIndex(index);
	}

	@And("^User clicks on Save button to save rule definition$")
	public void userClicksOnSaveButtonToSaveRuleDefinition() throws Throwable {
		ruleDefinitionsPageObjects.saveBtn.click();
	}

	@Then("^Verify that the rule definition\\[(\\d+)\\] is created successfully$")
	public void verifyThatTheRuleDefinitionIsCreatedSuccessfully(int index) {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[3]")).getText().trim(),ruleDeninitionName[index] );
		
	}

	@When("^User enters rule difinition name\\[(\\d+)\\] to search$")
	public void userEntersRuleDifinitionNameToSearch(int index) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		ruleDefinitionsPageObjects.search_RuleDefinition_name.clear();
		ruleDefinitionsPageObjects.search_RuleDefinition_name.sendKeys(ruleDeninitionName[index]);
	}

	@And("^User clicks on Search button to search rule definition\\(s\\)$")
	public void userClicksOnSearchButtonToSearchRuleDefinitionS() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		ruleDefinitionsPageObjects.searchBtn.click();
	}

	@Then("^rule difinition\\[(\\d+)\\] should be displayed in search results$")
	public void ruleDifinitionShouldBeDisplayedInSearchResults(int index) {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[3]")).getText().trim(),ruleDeninitionName[index] );
		
	}

	@When("^User clicks on Edit option to edit rule definition$")
	public void userClicksOnEditOptionToEditRuleDefinition()  {
		ruleDefinitionsPageObjects.contextMenuBtn.click();
		ruleDefinitionsPageObjects.contextMenu_Edit_Btn.click();
	}

	@Then("^Verify that the rule definition\\[(\\d+)\\] info is updated successfully$")
	public void verifyThatTheRuleDefinitionInfoIsUpdatedSuccessfully(int index)  {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[3]")).getText().trim(),ruleDeninitionName[index] );

	}
	@And("^User click on Add rule option to add rule instance$")
	public void userClickOnAddRuleOptionToAddRuleInstance(){
		ruleDefinitionsPageObjects.contextMenuBtn.click();
		ruleDefinitionsPageObjects.contextMenu_AddRule_Btn.click();
	
	}
	@And("^User enters rule instance name\\[(\\d+)\\] on add rule panel$")
	public void userEntersRuleInstanceNameOnAddRulePanel(int index) throws Throwable {
		ruleDefinitionsPageObjects.ruleInstance_name.clear();
		ruleDefinitionsPageObjects.ruleInstance_name.sendKeys(ruleInstanceName[index]);
	}

	@And("^User selects Company for the rule instance\\[(\\d+)\\]$")
	public void userSelectsCompanyForTheRuleInstance(int index) throws Throwable {
		Select companydrpDown =  new Select(ruleDefinitionsPageObjects.edit_companyId_drpDown);
		companydrpDown.selectByIndex(index);
	}

	@And("^User enters Order number as \"([^\"]*)\"$")
	public void userEntersOrderNumberAs(String orderNumber) throws Throwable {
		ruleDefinitionsPageObjects.orderNumber.clear();
		ruleDefinitionsPageObjects.orderNumber.sendKeys(orderNumber);
	}

	@And("^User clicks on save button to save the rule instance details$")
	public void userClicksOnSaveButtonToSaveTheRuleInstanceDetails(){
		ruleDefinitionsPageObjects.saveBtn.click();
	}

	@Then("^Rule instance\\[(\\d+)\\] should be added successfully$")
	public void ruleInstanceShouldBeAddedSuccessfully(int index) {
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/form[2]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[1]")).getText().trim(),ruleInstanceName[index] );

	}

	@And("^User click on View rule option to add rule instance$")
	public void userClickOnViewRuleOptionToAddRuleInstance(){
		ruleDefinitionsPageObjects.contextMenuBtn.click();
		ruleDefinitionsPageObjects.contextMenu_ViewRules_Btn.click();
	}

	@Then("^Rule instance\\[(\\d+)\\] should be displayed in the search results$")
	public void ruleInstanceShouldBeDisplayedInTheSearchResults(int index) throws Throwable {
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/form[2]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[1]")).getText().trim(),ruleInstanceName[index] );	
	}

	@Then("^All rule definitions should be displayed in search results$")
	public void allRuleDefinitionsShouldBeDisplayedInSearchResults()  {
		Assert.assertTrue(driver.findElements(By.xpath("//*[@id='unique_id']/tbody/tr")).size()>1);
	}

	@When("^User clicks on checkbox to select all rule definitions under search results$")
	public void userClicksOnCheckboxToSelectAllRuleDefinitionsUnderSearchResults() {
		ruleDefinitionsPageObjects.selectAll_checkbox.click();	
	}

	@And("^User clicks on Choose an Action drop down$")
	public void userClicksOnChooseAnActionDropDown() {
		ruleDefinitionsPageObjects.choose_an_action.click();
	}

	@And("^User selects Export as XML page$")
	public void userSelectsExportAsXMLPage() {
		Select chooseAnAction_drpDown = new Select(ruleDefinitionsPageObjects.choose_an_action);
		chooseAnAction_drpDown.selectByVisibleText("Export as XML");
	}

	@And("^User clicks on Go button$")
	public void userClicksOnGoButton()  {
		ruleDefinitionsPageObjects.Go_Btn.click();			
	}

	@Then("^Verify that the rule definition records xml file was successfully downloaded$")
	public void verifyThatTheRuleDefinitionRecordsXmlFileWasSuccessfullyDownloaded() throws Throwable {
		//Dates starting with 0(for ex :01-01-2021) needs to be stripped to match the fileName
		String currentDate = basePage.getCURRENTDate_initialZeroStripped("M-d-yyyy");
		String FileName = "rule_export_"+currentDate+".xml";
		Assert.assertEquals(true, basePage.isFileDownloaded(utils.Constant.downloadDirectory, FileName, 600));

	}

	@And("^User clicks on delete option to delete the rule definition$")
	public void userClicksOnDeleteOptionToDeleteTheRuleDefinition()  {
		ruleDefinitionsPageObjects.contextMenuBtn.click();
		ruleDefinitionsPageObjects.contextMenu_Delete_Btn.click();
		driver.switchTo().alert().accept();
	}

	@Then("^Rule definition should be deleted successfully$")
	public void ruleDefinitionShouldBeDeletedSuccessfully() {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td")).getText().trim(), "No Results Found");
	}

	

	
	
}

package stepDefinitions.rules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.CommonPageLocators;
import pageObjects.connect.rules.RuleInstancesPageObjects;
import utils.DriverFactory;

public class RuleInstances extends DriverFactory{
	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public RuleInstancesPageObjects ruleInstancesPageObjects = PageFactory.initElements(driver, RuleInstancesPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);
		
	String[] ruleDeninitionName = {"Automated_rule1","Automated_rule2"};
	String[] ruleInstanceName = {"Automated_ruleInstance1","Automated_ruleInstance2"};


	@And("^User clicks on Rule Instances menu option$")
	
	public void userClicksOnRuleInstancesMenuOption() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Rule_Instances.click();		
	}


	@And("^User selects Rule definition\\[(\\d+)\\] to create rule instance$")
	public void userSelectsRuleDefinitionToCreateRuleInstance(int index) {
		String option=null;
		Select definition_drpDown = new Select(ruleInstancesPageObjects.definitionId_drpDown);
		List<WebElement> drpDownoptions = definition_drpDown.getOptions();
		Iterator<WebElement> iterator = drpDownoptions.iterator();
		while(iterator.hasNext()){
		
			if(iterator.toString().contains(ruleDeninitionName[index])) {
				option =iterator.toString();
				
			}
			iterator.next();
			}
		definition_drpDown.selectByVisibleText(option);
	}


	@And("^User selects Rule definition \"([^\"]*)\" to create rule instance$")
	public void userSelectsRuleDefinitionToCreateRuleInstance(String option){
		Select definition_drpDown = new Select(ruleInstancesPageObjects.definitionId_drpDown);
		definition_drpDown.selectByVisibleText(option);
	}


	@When("^User enters rule instance name\\[(\\d+)\\] to search$")
	public void userEntersRuleInstanceNameToSearch(int index){
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(commonPageLocators.body_frame);
		ruleInstancesPageObjects.search_RuleInstance_name.clear();
		ruleInstancesPageObjects.search_RuleInstance_name.sendKeys(ruleInstanceName[index]);
	}


	@Then("^Rule instance\\[(\\d+)\\] should be displayed in search results$")
	public void ruleInstanceShouldBeDisplayedInSearchResults(int index) {
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/form[2]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[1]")).getText().trim(),ruleInstanceName[index] );
	}


	@And("^User clicks on Edit button to edit rule instance$")
	public void userClicksOnEditButtonToEditRuleInstance() {
		ruleInstancesPageObjects.contextMenuBtn_ruleInst.click();
		ruleInstancesPageObjects.contextMenu_Edit_Btn.click();
	}


	@And("^User clicks on the checkbox to select the rule instance$")
	public void userClicksOnTheCheckboxToSelectTheRuleInstance() throws Throwable {
		ruleInstancesPageObjects.selectRow_checkbox.click();
	}

	@And("^User selects Disable option to disable rule instance$")
	public void userSelectsDisableOptionToDisableRuleInstance() throws Throwable {
		Select choose_an_action = new Select(ruleInstancesPageObjects.choose_an_action);
		choose_an_action.selectByVisibleText("Disable");
	}


	@Then("^Verify that the rule instance is disabled successfully$")
	public void verifyThatTheRuleInstanceIsDisabledSuccessfully()  {
		
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/form[2]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[5]/img")).getAttribute("title"),"Disabled" );
		
	}


	@And("^User selects Enable option to enable rule instance$")
	public void userSelectsEnableOptionToEnableRuleInstance(){
		Select choose_an_action = new Select(ruleInstancesPageObjects.choose_an_action);
		choose_an_action.selectByVisibleText("Enable");	
	}


	@Then("^Verify that the rule instance is enabled successfully$")
	public void verifyThatTheRuleInstanceIsEnabledSuccessfully()  {
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/form[2]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[5]/img")).getAttribute("title"),"Enabled" );

	}


	
}

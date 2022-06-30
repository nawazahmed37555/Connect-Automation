package pageObjects.connect.rules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RuleInstancesPageObjects {
	public @FindBy (name= "search_RuleInstance_name") WebElement search_RuleInstance_name;
	public @FindBy (name= "definitionId") WebElement definitionId_drpDown;
	public @FindBy (name= "name") WebElement edit_RuleDefinition_name;
	public @FindBy (name= "ruleType") WebElement edit_ruleType_drpDown;
	public @FindBy (name= "description") WebElement edit_description;
	public @FindBy (name= "edit_companyId") WebElement edit_companyId_drpDown;
	public @FindBy (name = "RuleInstance_name") WebElement ruleInstance_name;
	public @FindBy (name = "sequence") WebElement orderNumber;
	
	
	public @FindBy (name= "ruleInstanceActionList") WebElement choose_an_action;
	public @FindBy (name= "selectRow") WebElement selectRow_checkbox;
	
	public @FindBy (css = "input[value=Go]" ) WebElement Go_Btn;
	public @FindBy (xpath= "/html/body/form[2]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[1]/a") WebElement contextMenuBtn_ruleInst;
	public @FindBy (xpath= "/html/body/form[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]/a") WebElement contextMenuBtn_ruleDef;
	
	
	public @FindBy (linkText= "Edit") WebElement contextMenu_Edit_Btn;
	public @FindBy (linkText= "Delete") WebElement contextMenu_Delete_Btn;
	public @FindBy (linkText= "Add Rule") WebElement contextMenu_AddRule_Btn;
	
	
	
	public @FindBy (name= "toggleAll") WebElement selectAll_checkbox;
	

	
}

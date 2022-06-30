package pageObjects.connect.rules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RuleDefinitionsPageObjects {

	public @FindBy (css = "input[value=Clear]") WebElement clearBtn;
	public @FindBy (css = "input[value=Add]") WebElement addBtn;
	public @FindBy (css = "input[value=Search]") WebElement searchBtn;
	public @FindBy (name= "search_RuleDefinition_name") WebElement search_RuleDefinition_name;
	public @FindBy (name= "name") WebElement edit_RuleDefinition_name;
	public @FindBy (name= "ruleType") WebElement edit_ruleType_drpDown;
	public @FindBy (name= "description") WebElement edit_description;
	public @FindBy (name= "edit_companyId") WebElement edit_companyId_drpDown;
	public @FindBy (css = "input[value=Save]") WebElement saveBtn;

	public @FindBy (name = "RuleInstance_name") WebElement ruleInstance_name;
	public @FindBy (name = "sequence") WebElement orderNumber;
	
	
	public @FindBy (name= "ruleDefinitionActionList") WebElement choose_an_action;
	public @FindBy (css = "input[value=Go]" ) WebElement Go_Btn;
	public @FindBy (className= "menuButton") WebElement contextMenuBtn;
	public @FindBy (linkText= "Edit") WebElement contextMenu_Edit_Btn;
	public @FindBy (linkText= "Delete") WebElement contextMenu_Delete_Btn;
	public @FindBy (linkText= "View Rules") WebElement contextMenu_ViewRules_Btn;
	public @FindBy (linkText= "Add Rule") WebElement contextMenu_AddRule_Btn;
	public @FindBy (name= "toggleAll") WebElement selectAll_checkbox;
	
	
	
}

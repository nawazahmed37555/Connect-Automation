package pageObjects.connect.setup;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FieldsPageObjects {
	public @FindBy (name= "search_name") WebElement search_field_name;
		
	//Search Results panel
	public @FindBy (name= "fieldActionList") WebElement choose_an_action;
	public @FindBy (css = "input[value=Clear]") WebElement clearBtn;
	public @FindBy (css = "input[value=Add]") WebElement addBtn;
	public @FindBy (css = "input[value=Search]") WebElement searchBtn;
	
	//Add/edit panel
	public @FindBy (name= "qualifier") WebElement edit_fieldNameSpace_drpDown;
	public @FindBy (name= "name") WebElement edit_fieldName;
	public @FindBy (name= "typeId") WebElement edit_fieldType_drpDown;
	public @FindBy (name= "description") WebElement edit_description;
	public @FindBy (name= "displayName") WebElement edit_displayName;
	public @FindBy (name= "fieldLOVTypeClasses") WebElement edit_fieldLOVClass_drpDown;
	public @FindBy (name= "fieldLOVTypesForClassList") WebElement edit_fieldLOVType_drpDown;
	public @FindBy (linkText= "Responsibilities") WebElement Responsibilities_tab;
	public @FindBy (name= "unassignedResponsibilitiesList") WebElement unassigned_ResponsibilitiesList;
	public @FindBy (name= "assignedResponsibilitiesList") WebElement assigned_ResponsibilitiesList;
	public @FindBy (name= "btnAdd") WebElement addBtn_responsibilitiesTab;
	
	//Search Results or details panel
	public @FindBy (css = "input[value=Save]") WebElement saveBtn;
	
	
	public @FindBy (css = "input[value=Go]" ) WebElement Go_Btn;
	public @FindBy (xpath= "//*[@id='unique_id']/tbody/tr[2]/td[3]") WebElement searchResult;
	public @FindBy (xpath= "//*[@id='unique_id']/tbody/tr") By searchResults; 
	public @FindBy (className= "menuButton") WebElement contextMenuBtn;
	public @FindBy (linkText= "Edit") WebElement contextMenu_Edit_Btn;
	public @FindBy (linkText= "Delete") WebElement contextMenu_Delete_Btn;
	public @FindBy (name= "toggleAll") WebElement selectAll_checkbox;
}

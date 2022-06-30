package pageObjects.connect.setup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FieldLOVsPageObjects {
	
	public @FindBy (name= "search_displayName") WebElement search_displayName;
	
	//Search Results panel
	public @FindBy (name= "attributesctionList") WebElement choose_an_action;
	public @FindBy (css = "input[value=Clear]") WebElement clearBtn;
	public @FindBy (css = "input[value=Add]") WebElement addBtn;
	public @FindBy (css = "input[value=Search]") WebElement searchBtn;
	
	//Add/edit panel
	public @FindBy (name= "edit_classNameKey") WebElement edit_className_drpdown;
	public @FindBy (name= "edit_displayName") WebElement edit_displayName;
	public @FindBy (name= "edit_fieldLovClassName") WebElement edit_fieldLovClassName;
	
		
	//Search Results or details panel
	public @FindBy (css = "input[value=Save]") WebElement saveBtn;
	public @FindBy (css = "input[value=Go]" ) WebElement Go_Btn;
	public @FindBy (className= "menuButton") WebElement contextMenuBtn;
	public @FindBy (linkText= "Edit") WebElement contextMenu_Edit_Btn;
	public @FindBy (linkText= "Delete") WebElement contextMenu_Delete_Btn;
	public @FindBy (name= "toggleAll") WebElement selectAll_checkbox;
}

package pageObjects.connect.setup;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlexFieldsPageObjects {
	
	public @FindBy (name= "search_Flexfield_name") WebElement search_Flexfield_name;
	
	//Search Results panel
	public @FindBy (name= "flexFieldActionList") WebElement choose_an_action;
	public @FindBy (css = "input[value=Clear]") WebElement clearBtn;
	public @FindBy (css = "input[value=Add]") WebElement addBtn;
	public @FindBy (css = "input[value=Search]") WebElement searchBtn;
	
	//Add/edit panel
	public @FindBy (name= "edit_FieldNamespace_name") WebElement edit_fieldNameSpace_drpDown;
	public @FindBy (name= "edit_Flexfield_name") WebElement edit_Flexfield_name;
	public @FindBy (name= "edit_Flexfield_applicationCode") WebElement edit_application_drpDown;
		
	//Search Results or details panel
	public @FindBy (css = "input[value=Save]") WebElement saveBtn;
	
	
	public @FindBy (css = "input[value=Go]" ) WebElement Go_Btn;
	public @FindBy (className= "menuButton") WebElement contextMenuBtn;
	public @FindBy (linkText= "Edit") WebElement contextMenu_Edit_Btn;
	public @FindBy (linkText= "Delete") WebElement contextMenu_Delete_Btn;
	public @FindBy (name= "toggleAll") WebElement selectAll_checkbox;
	
}

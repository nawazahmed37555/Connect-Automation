package pageObjects.connect.labels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LabelsPageObjects {

	//Search Results panel
	
	public @FindBy (css = "input[value=Clear]") WebElement clearBtn;
	public @FindBy (css = "input[value=Add]") WebElement addBtn;
	public @FindBy (css = "input[value=Search]") WebElement searchBtn;
	public @FindBy (name= "search_formatName") WebElement search_formatName;

	public @FindBy (name= "action_list") WebElement choose_an_action;
	public @FindBy (css = "input[value=Go]" ) WebElement Go_Btn;
	public @FindBy (className= "menuButton") WebElement contextMenuBtn;
	public @FindBy (linkText= "Edit") WebElement contextMenu_Edit_Btn;
	public @FindBy (linkText= "Delete") WebElement contextMenu_Delete_Btn;
	public @FindBy (linkText= "Disable") WebElement contextMenu_Disable_Btn;
	public @FindBy (linkText= "Enable") WebElement contextMenu_Enable_Btn;
	public @FindBy (name= "toggleAll") WebElement selectAll_checkbox;
	
	//Add/Edit panel
	public @FindBy (name= "formatName") WebElement edit_formatName;
	public @FindBy (name= "language") WebElement edit_language_drpDown;
	public @FindBy (name= "fileSelection") WebElement edit_fileSelection;
	public @FindBy (name= "dpi") WebElement edit_dpi_drpDown;
	public @FindBy (name= "edit_companyId") WebElement edit_companyId;
	public @FindBy (name= "createLabelType") WebElement edit_createLabelType;
	
	
	public @FindBy (css = "input[value=Save]") WebElement saveBtn;
	
	
	public @FindBy (name= "download") WebElement downloadFormat_Btn;
	public @FindBy (name= "printButton") WebElement printButton;
	
	
}

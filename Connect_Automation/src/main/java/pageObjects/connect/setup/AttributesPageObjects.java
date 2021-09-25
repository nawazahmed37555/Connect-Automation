package pageObjects.connect.setup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AttributesPageObjects {

	
public @FindBy (name= "search_Flexfield_name") WebElement search_Flexfield_name;
	
	//Search Results panel
	public @FindBy (name= "attributesctionList") WebElement choose_an_action;
	public @FindBy (css = "input[value=Clear]") WebElement clearBtn;
	public @FindBy (css = "input[value=Add]") WebElement addBtn;
	public @FindBy (css = "input[value=Search]") WebElement searchBtn;
	
	//Add/edit panel
	public @FindBy (name= "edit_Flexfield_name") WebElement edit_Flexfield_name_drpDown;
	public @FindBy (name= "edit_Field_name") WebElement edit_Field_name_drpDown;
	public @FindBy (name= "edit_FlexfieldAttribute_flexfieldAttribute") WebElement edit_index_drpDown;
	public @FindBy (name= "edit_FlexfieldAttribute_lovQuery") WebElement edit_LOV_query;
		
	//Search Results or details panel
	public @FindBy (css = "input[value=Save]") WebElement saveBtn;
	
	
	public @FindBy (css = "input[value=Go]" ) WebElement Go_Btn;
	public @FindBy (className= "menuButton") WebElement contextMenuBtn;
	public @FindBy (linkText= "Edit") WebElement contextMenu_Edit_Btn;
	public @FindBy (linkText= "Delete") WebElement contextMenu_Delete_Btn;
	public @FindBy (name= "toggleAll") WebElement selectAll_checkbox;
}

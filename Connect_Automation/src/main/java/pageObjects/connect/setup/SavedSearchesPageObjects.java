package pageObjects.connect.setup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SavedSearchesPageObjects {
public @FindBy (name= "search_SavedSearch_searchName") WebElement search_SavedSearchName;
	
	//Search Results panel
	public @FindBy (name= "actionList") WebElement choose_an_action;
	public @FindBy (css = "input[value=Clear]") WebElement clearBtn;
	public @FindBy (css = "input[value=Search]") WebElement searchBtn;
	
	
		
	//Search Results or details panel
	public @FindBy (css = "input[value=Save]") WebElement saveBtn;
	public @FindBy (css = "input[value=Go]" ) WebElement Go_Btn;
	public @FindBy (className= "menuButton") WebElement contextMenuBtn;
	public @FindBy (linkText= "Edit") WebElement contextMenu_Edit_Btn;
	public @FindBy (name= "selectRow") WebElement selectRow_checkbox;
	public @FindBy (name= "toggleAll") WebElement selectAll_checkbox;
	public @FindBy (name= "edit_SavedSearch_searchName") WebElement edit_SavedSearchName;
	
}

package pageObjects.connect.setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenusPageObjects {
	//Search  panel
		
		public @FindBy (name= "search_displayName") WebElement search_displayName;
		public @FindBy (css = "input[value=Clear]") WebElement clearBtn;
		public @FindBy (css = "input[value=Add]") WebElement addBtn;
		public @FindBy (css = "input[value=Search]") WebElement searchBtn;

		//Add/edit panel
		public @FindBy (name= "edit_name") WebElement edit_menuGroup_drpDown;
		public @FindBy (name= "edit_displayName") WebElement edit_displayName;
		public @FindBy (name= "edit_href") WebElement edit_href;
		public @FindBy (name= "edit_applicationCode") WebElement edit_application_drpDown;
		public @FindBy (name= "edit_sequenceId") WebElement edit_sequence;
		public @FindBy (name= "edit_menuItemTypeId") WebElement edit_menuItemType_drpDown;
		public @FindBy (css = "input[value=Save]") WebElement saveBtn;
		public @FindBy (linkText = "Responsibilities") WebElement responsibility_tab;
		public @FindBy (name= "unassignedResponsibilitiesList") WebElement unassignedResponsibilitiesList;
		public @FindBy (xpath= "//*[@id='btnAdd']") WebElement edit_addBtn;
		
		
		//Search Results or details panel
		public @FindBy (name= "menuActionList") WebElement choose_an_action;
		public @FindBy (css = "input[value=Go]" ) WebElement Go_Btn;
		public @FindBy (xpath= "//*[@id='unique_id']/tbody/tr[2]/td[3]") WebElement searchResult;
		public @FindBy (xpath= "//*[@id='unique_id']/tbody/tr") By searchResults; 
		public @FindBy (className= "menuButton") WebElement contextMenuBtn;
		public @FindBy (linkText= "Edit") WebElement contextMenu_Edit_Btn;
		public @FindBy (linkText= "Enable") WebElement contextMenu_Enable_Btn;
		public @FindBy (linkText= "Disable") WebElement contextMenu_Disable_Btn;
		public @FindBy (linkText= "Delete") WebElement contextMenu_Delete_Btn;
		public @FindBy (linkText= "Add Child") WebElement contextMenu_Add_Child_Btn;
		public @FindBy (name= "toggleAll") WebElement selectAll_checkbox;
}

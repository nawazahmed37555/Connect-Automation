package pageObjects.connect.labels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LabelGraphicsPageObjects {
	//Search Results panel
	
		public @FindBy (css = "input[value=Clear]") WebElement clearBtn;
		public @FindBy (css = "input[value=Add]") WebElement addBtn;
		public @FindBy (css = "input[value=Search]") WebElement searchBtn;
		public @FindBy (name= "search_name") WebElement search_graphicName;

		public @FindBy (name= "action_list") WebElement choose_an_action;
		public @FindBy (css = "input[value=Go]" ) WebElement Go_Btn;
		public @FindBy (className= "menuButton") WebElement contextMenuBtn;
		public @FindBy (linkText= "Edit") WebElement contextMenu_Edit_Btn;
		public @FindBy (linkText= "Delete") WebElement contextMenu_Delete_Btn;
		public @FindBy (name= "toggleAll") WebElement selectAll_checkbox;
		
		//Add/Edit panel
		public @FindBy (name= "name") WebElement edit_graphicName;
		public @FindBy (name= "language") WebElement edit_language_drpDown;
		public @FindBy (name= "fileSelection") WebElement edit_fileSelection;
		public @FindBy (name= "dpi") WebElement edit_dpi_drpDown;
		public @FindBy (name= "edit_companyId") WebElement edit_companyId;
	
		
		
		public @FindBy (name= "saveButton") WebElement saveBtn;
		
}

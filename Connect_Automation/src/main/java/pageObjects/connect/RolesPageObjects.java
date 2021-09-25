package pageObjects.connect;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RolesPageObjects {

	//Search Role panel
		public @FindBy (name= "search_Role_name") WebElement search_Role_name;
		public @FindBy (name= "search_Role_disabled") WebElement search_role_status;
		
		public @FindBy (css = "input[value=Clear]") WebElement clearBtn;
		public @FindBy (css = "input[value=Add]") WebElement addBtn;
		public @FindBy (css = "input[value=Search]") WebElement searchBtn;
		
		//Search Results panel
		public @FindBy (name= "actions") WebElement choose_an_action;
		public @FindBy (css = "input[value=Go]" ) WebElement Go_Btn;
		
		public @FindBy (xpath= "//*[@id='unique_id']/tbody/tr[2]/td[3]") WebElement searchResults_roleName;
		public @FindBy (className= "menuButton") WebElement contextMenuBtn;
		public @FindBy (linkText= "Disable") WebElement contextMenu_Disable_Btn;
		public @FindBy (linkText= "Enable") WebElement contextMenu_Enable_Btn;
		public @FindBy (linkText= "Edit") WebElement contextMenu_Edit_Btn;
		public @FindBy (xpath= "//*[@id='unique_id']/tbody/tr[2]/td[5]") WebElement searchResults_roleStatus;	
		public @FindBy (name= "toggleAll") WebElement selectAll_checkbox;
		
		
		//Add/Edit Role panel
		public @FindBy (name= "edit_name") WebElement edit_RoleName;
		public @FindBy (name= "edit_description") WebElement edit_description;
		public @FindBy (css = "input[value=Save]") WebElement saveBtn;
		public @FindBy (linkText= "Responsibilities") WebElement responsibilities_tab;
		public @FindBy (name= "unassignedResponsibilitiesList") WebElement unassigned_ResponsibilitiesList;
		public @FindBy (name= "assignedResponsibilitiesList") WebElement assigned_ResponsibilitiesList;
		
		public @FindBy (name= "btnAdd") WebElement Add_Btn_assignResponsibilities;//Add button to assign responsibilitis
		
		
		
		
		//Strings used as test data
		public String[] roleName = {"Automated_role1","Automated_role2"};
		public String[] roleDescription = {"Automated_description1","Automated_description2"};
		
			
}

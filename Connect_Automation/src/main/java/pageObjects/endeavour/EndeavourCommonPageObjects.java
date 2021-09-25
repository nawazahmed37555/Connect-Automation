package pageObjects.endeavour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EndeavourCommonPageObjects {
	
		// Login Page elements
		public @FindBy (xpath = "//input[@id=\"id_username\"]") WebElement txtF_UserName;
		public @FindBy (xpath = "//input[@id=\"id_password\"]") WebElement txtF_PassWord;
		public @FindBy (xpath = "//button[@id=\"_submit\"]") WebElement btn_signIn;	
		
		//Frames
		public @FindBy (name = "header") WebElement Header_frame;
		public @FindBy (name = "menu") WebElement menu_frame;
		public @FindBy (name = "body") WebElement body_frame;
		
		
		//Menu Elements
		public @FindBy (linkText="Home") WebElement menu_Home;
		public @FindBy (linkText="Administration") WebElement menu_Administration;
		public @FindBy (linkText="Companies") WebElement menu_Companies;
		public @FindBy (linkText="Users") WebElement menu_Users;
		public @FindBy (linkText="Purchase Orders") WebElement Purchase_Orders;
		public @FindBy (linkText="Search Orders") WebElement Search_Orders;
		public @FindBy (linkText="Accounts Payable") WebElement Accounts_Payable;
		public @FindBy (linkText="Search Invoices") WebElement Search_Invoices;
		public @FindBy (name="searchFolderList") WebElement searchFolder_drpDown;
		public @FindBy (linkText="Logout") WebElement menu_Logout;
		
		//Search panel
		public @FindBy (css = "input[value=Clear]") WebElement clearBtn;
		public @FindBy (css = "input[value=Add]") WebElement addBtn;
		public @FindBy (css = "input[value=Search]") WebElement searchBtn;
		
		
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

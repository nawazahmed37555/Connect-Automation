package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonPageLocators extends BasePage {

	public CommonPageLocators() throws IOException {
		super();
	}

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
	public @FindBy (linkText="Companies") WebElement menu_Companies;
	public @FindBy (linkText="Users") WebElement menu_Users;
	public @FindBy (linkText="Responsibilities") WebElement menu_Responsibilities;
	public @FindBy (linkText="Roles") WebElement menu_Roles;
	
	//Devices menu options
	public @FindBy (linkText="Devices") WebElement menu_Devices;
	public @FindBy (linkText="Carousels") WebElement menu_Devices_Carousels;
	public @FindBy (linkText="PLCs") WebElement menu_Devices_PLCs;
	public @FindBy (linkText="Scales") WebElement menu_Devices_Scales;
	public @FindBy (linkText="Printers") WebElement menu_Devices_Printers;
	//Setup Menu options
	public @FindBy (linkText="Setup") WebElement menu_Setup;
	public @FindBy (linkText="Fields") WebElement menu_Setup_Fields;
	public @FindBy (linkText="Folders") WebElement menu_Setup_Folders;
	public @FindBy (linkText="Pages") WebElement menu_Setup_Pages;
	public @FindBy (linkText="Namespaces") WebElement menu_Setup_NameSpaces;
	public @FindBy (linkText="Lookups") WebElement menu_Setup_Lookups;
	public @FindBy (linkText="Menus") WebElement menu_Setup_Menus;
	public @FindBy (linkText="Import XML Data") WebElement menu_Setup_Import_XML_Data;
	public @FindBy (linkText="Flex Fields") WebElement menu_Setup_Flex_Fields;
	public @FindBy (linkText="Attributes") WebElement menu_Setup_Attributes;
	public @FindBy (linkText="Mass Export") WebElement menu_Setup_Mass_Export;
	public @FindBy (linkText="Migrations") WebElement menu_Setup_Migrations;
	public @FindBy (linkText="Field LOV Values") WebElement menu_Setup_Field_LOV_Values;
	public @FindBy (linkText="SAP Instance Manager") WebElement menu_Setup_SAP_Instance_Manager;
	public @FindBy (linkText="Saved Searches") WebElement menu_Setup_Saved_Searches;
	public @FindBy (linkText="Caches") WebElement menu_Setup_Caches;
	
	//Label management
	public @FindBy (linkText="Label Management") WebElement menu_Label_Management;
	public @FindBy (linkText="Labels") WebElement menu_Labels;
	public @FindBy (linkText="Label Graphics") WebElement menu_Label_Graphics;
	public @FindBy (linkText="Label History and Reprint") WebElement menu_Label_History_Reprint;
	
	//Rules
	public @FindBy (linkText="Rules") WebElement menu_Rules;
	public @FindBy (linkText="Rule Definitions") WebElement menu_Rule_Definitions;
	public @FindBy (linkText="Rule Instances") WebElement menu_Rule_Instances;
	public @FindBy (linkText="Rule Actions") WebElement menu_Rule_Actions;
	public @FindBy (linkText="Rule Testing") WebElement menu_Rule_Testing;
	public @FindBy (linkText="Rule Execute") WebElement menu_Rule_Execute;
	public @FindBy (linkText="Rule Summary") WebElement menu_Rule_Summary;
	public @FindBy (linkText="User Rules") WebElement menu_User_Rules;
	
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

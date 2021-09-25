package pageObjects.connect;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class UsersPageObjects  extends BasePage{

	
	public UsersPageObjects() throws IOException{
		
		super();
	}
	
	
	
	//Search panel
	public @FindBy (name= "search_userName") WebElement search_userName;
	public @FindBy (css = "input[value=Clear]") WebElement clearBtn;
	public @FindBy (css = "input[value=Add]") WebElement addBtn;
	public @FindBy (css = "input[value=Search]") WebElement searchBtn;
	
	
	//Add/Edit User Details panel
	
	public @FindBy (name= "edit_userName") WebElement edit_userName;
	public @FindBy (name= "edit_password") WebElement edit_password;
	public @FindBy (name= "edit_typeCode") WebElement choose_userType;
	public @FindBy (name= "edit_contactName") WebElement edit_contactName;
	public @FindBy (name= "edit_contactPhone") WebElement edit_contactPhone;
	public @FindBy (name= "edit_contactEmail") WebElement edit_contactEmail;
	public @FindBy (name= "edit_contactFax") WebElement edit_contactFax;
	public @FindBy (name= "edit_companyId") WebElement choose_company;
	
	//Search Results panel
	public @FindBy (xpath= "//*[@id='unique_id']/tbody/tr[2]/td[3]") WebElement searchResults_userName;
	public @FindBy (className= "menuButton") WebElement contextMenuBtn;
	public @FindBy (linkText= "Disable") WebElement contextMenu_Disable_Btn;
	public @FindBy (linkText= "Enable") WebElement contextMenu_Enable_Btn;
	public @FindBy (linkText= "Edit") WebElement contextMenu_Edit_Btn;
	public @FindBy (xpath= "//*[@id='unique_id']/tbody/tr[2]/td[6]") WebElement userStatus;
	public @FindBy (name= "toggleAll") WebElement selectAll_checkbox;
	public @FindBy (name= "actionList") WebElement choose_an_action;
	
	
	public @FindBy (css = "input[value=Save]") WebElement saveBtn;
	public @FindBy (css = "input[value=Go]" ) WebElement Go_Btn;
	
	
	
	
	//Strings used as test data
	public final  String[] userName = {"Automated_User","Automated_User_Updated"};
	public final  String[] passWord = {"test1234","updated1234"};
	public final  String[] userType = {"User","Supplier","Buyer"}; 
	public final  String[] contactName = {"test_contactName","updated_contactName"};
	public final  String[] contactPhone = {"123456789","9876543210"};
	public final  String[] contactEmail = {"test@gmail.com","updated@gmail.com"};
	public final  String[] contactFax = {"+13235551234","+13235551233"};
	public final  String[] company = {"Allied Manufacturing Company","AllVendors","Acme, Inc.","ClearOrbit","ClearOrbitTPX","Los Alamos National Laboratory","MarkBuyerCo","NeuCorp","test"};
	
	
} 

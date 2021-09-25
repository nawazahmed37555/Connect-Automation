package pageObjects.connect.setup;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FoldersPageObjects {
	//Search Results panel
	
		public @FindBy (css = "input[value=Clear]") WebElement clearBtn;
		public @FindBy (css = "input[value=Add]") WebElement addBtn;
		public @FindBy (css = "input[value=Search]") WebElement searchBtn;
		public @FindBy (name= "folderActionList") WebElement choose_an_action;
		public @FindBy (name= "search_Folder_name") WebElement search_folderName;
		
		//Add/edit panel
	
		public @FindBy (name= "edit_name") WebElement edit_folderName;
		public @FindBy (name= "edit_applicationCode") WebElement edit_applicationName_drpDown;
		public @FindBy (name= "edit_page_name") WebElement edit_PageName_drpDown;
		public @FindBy (name= "namespacesForPageList") WebElement edit_namespace_drpDown;
		public @FindBy (name= "fieldsForNamespacesList") WebElement edit_fields_drpDown;
		public @FindBy (css = "input[value=Save]") WebElement saveBtn;
		public @FindBy (name= "btnAdd") WebElement edit_addBtn;
		public @FindBy (linkText= "Buyer Companies") WebElement BuyerCompanies_Tab;
		public @FindBy (linkText= "Supplier Companies") WebElement SupplierCompanies_Tab;
		
		public @FindBy (name= "companiesList") WebElement companies_DrpDown;
		public @FindBy (name= "usersForCompaniesList") WebElement users_drpDown;
		public @FindBy (name= "usersForFolderList") WebElement selectedUsers_drpDown;
		
		//Search Results or details panel
		public @FindBy (css = "input[value=Go]" ) WebElement Go_Btn;
		public @FindBy (xpath= "//*[@id='unique_id']/tbody/tr[2]/td[3]") WebElement searchResult;
		public @FindBy (xpath= "//*[@id='unique_id']/tbody/tr") List<WebElement> searchResults; 
		public @FindBy (className= "menuButton") WebElement contextMenuBtn;
		public @FindBy (linkText= "Edit") WebElement contextMenu_Edit_Btn;
		public @FindBy (linkText= "Delete") WebElement contextMenu_Delete_Btn;
		public @FindBy (linkText= "Copy") WebElement contextMenu_Copy_Btn;
		public @FindBy (name= "toggleAll") WebElement selectAll_checkbox;

}

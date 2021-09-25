package pageObjects.connect.setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NamespacesPageObjects {
	
//Search  panel
public @FindBy (name= "search_name") WebElement search_NameSpace_name;
public @FindBy (name= "search_persistentClassName") WebElement search_ClassName;
public @FindBy (css = "input[value=Clear]") WebElement clearBtn;
public @FindBy (css = "input[value=Add]") WebElement addBtn;
public @FindBy (css = "input[value=Search]") WebElement searchBtn;

//Add/edit panel

public @FindBy (name= "name") WebElement edit_NameSpace_name;
public @FindBy (name= "persistentClassName") WebElement edit_Class_name;
public @FindBy (name= "description") WebElement edit_description;
public @FindBy (name= "edit_applicationCode") WebElement edit_application_drpDown;
public @FindBy (css = "input[value=Save]") WebElement saveBtn;

//Search Results or details panel
public @FindBy (name= "pageActionList") WebElement choose_an_action;
public @FindBy (css = "input[value=Go]" ) WebElement Go_Btn;
public @FindBy (xpath= "//*[@id='unique_id']/tbody/tr[2]/td[3]") WebElement searchResult;
//*[@id="unique_id"]/tbody/tr[2]/td[3]
public @FindBy (xpath= "//*[@id='unique_id']/tbody/tr") By searchResults; 
public @FindBy (className= "menuButton") WebElement contextMenuBtn;
public @FindBy (linkText= "Edit") WebElement contextMenu_Edit_Btn;
public @FindBy (linkText= "Delete") WebElement contextMenu_Delete_Btn;
public @FindBy (name= "toggleAll") WebElement selectAll_checkbox;
}

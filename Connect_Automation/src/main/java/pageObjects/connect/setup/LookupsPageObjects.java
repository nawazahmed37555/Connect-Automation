package pageObjects.connect.setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LookupsPageObjects {
	//Search  panel
	public @FindBy (name= "search_LookupEntry_category1") WebElement search_category1_drpDown;
	public @FindBy (name= "search_LookupEntry_category2") WebElement search_category2_drpDown;
	public @FindBy (name= "search_LookupEntry_value") WebElement search_value;
	
	public @FindBy (css = "input[value=Clear]") WebElement clearBtn;
	public @FindBy (css = "input[value=Add]") WebElement addBtn;
	public @FindBy (css = "input[value=Search]") WebElement searchBtn;

	//Add/edit panel

	public @FindBy (name= "edit_LookupEntry_category1") WebElement edit_category1_drpDown;
	public @FindBy (name= "edit_LookupEntry_category2") WebElement edit_category2_drpDown;
	public @FindBy (name= "edit_LookupEntry_category3") WebElement edit_category3_drpDown;
	public @FindBy (name= "edit_LookupEntry_value") WebElement edit_value;
	public @FindBy (name= "edit_LookupEntry_description") WebElement edit_description;
	public @FindBy (css = "input[value=Save]") WebElement saveBtn;

	//Search Results or details panel
	public @FindBy (name= "actions") WebElement choose_an_action;
	public @FindBy (css = "input[value=Go]" ) WebElement Go_Btn;
	public @FindBy (xpath= "//*[@id='unique_id']/tbody/tr[2]/td[3]") WebElement searchResult;
	//*[@id="unique_id"]/tbody/tr[2]/td[3]
	public @FindBy (xpath= "//*[@id='unique_id']/tbody/tr") By searchResults; 
	public @FindBy (className= "menuButton") WebElement contextMenuBtn;
	public @FindBy (linkText= "Edit") WebElement contextMenu_Edit_Btn;
	public @FindBy (linkText= "Enable") WebElement contextMenu_Enable_Btn;
	public @FindBy (linkText= "Disable") WebElement contextMenu_Disable_Btn;
	public @FindBy (linkText= "Delete") WebElement contextMenu_Delete_Btn;
	public @FindBy (name= "toggleAll") WebElement selectAll_checkbox;
}

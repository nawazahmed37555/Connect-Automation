package pageObjects.connect;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ResponsibilitiesPageObjects extends BasePage {

	public ResponsibilitiesPageObjects() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Search Responsibility panel
	public @FindBy (name= "search_Responsibility_name") WebElement search_ResponsibilityName;
	public @FindBy (name= "search_Responsibility_disabled") WebElement responsibility_status;
	public @FindBy (css = "input[value=Clear]") WebElement clearBtn;
	public @FindBy (css = "input[value=Add]") WebElement addBtn;
	public @FindBy (css = "input[value=Search]") WebElement searchBtn;
	
	//Search Results panel
	public @FindBy (name= "actions") WebElement choose_an_action;
	public @FindBy (css = "input[value=Go]" ) WebElement Go_Btn;
	public @FindBy (css = "input[value=Save]") WebElement saveBtn;
	public @FindBy (xpath= "//*[@id='unique_id']/tbody/tr[2]/td[3]") WebElement searchResults_responsibilityName;
	public @FindBy (className= "menuButton") WebElement contextMenuBtn;
	public @FindBy (linkText= "Disable") WebElement contextMenu_Disable_Btn;
	public @FindBy (linkText= "Enable") WebElement contextMenu_Enable_Btn;
	public @FindBy (linkText= "Edit") WebElement contextMenu_Edit_Btn;
	public @FindBy (xpath= "//*[@id='unique_id']/tbody/tr[2]/td[5]") WebElement responsibilityStatus;	
	public @FindBy (name= "toggleAll") WebElement selectAll_checkbox;
	
	
	//Add/Edit Responsibilty panel
	public @FindBy (name= "edit_name") WebElement edit_ResponsibiltyName;
	public @FindBy (name= "edit_description") WebElement edit_description;
	
	//Strings used as test data
	public String[] responsibilityName = {"Automated_resp1","Automated_resp2"};
	public String[] responsibilityDescription = {"Automated_description1","Automated_description2"};
	
		
		
}

package pageObjects.connect;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class CompaniesPageObjects extends BasePage {

	public CompaniesPageObjects() throws IOException {

	super();
	}
	//Company Search Panel
	public @FindBy (name= "clearBtn") WebElement clearBtn;
	public @FindBy (name= "addBtn") WebElement addBtn;
	public @FindBy (name= "searchBtn") WebElement searchBtn;
	public @FindBy (name= "search_companyName") WebElement search_companyName;
	
	
	
	//Search Results panel or Details panel
	public @FindBy (xpath= "//*[@id='unique_id']/tbody/tr[2]/td[3]") WebElement searchResults_companyName;
	public @FindBy (className= "menuButton") WebElement contextMenuBtn;
	public @FindBy (linkText= "Disable") WebElement contextMenu_Disable_Btn;
	public @FindBy (linkText= "Enable") WebElement contextMenu_Enable_Btn;
	public @FindBy (linkText= "Edit") WebElement contextMenu_Edit_Btn;
	public @FindBy (xpath= "//*[@id='unique_id']/tbody/tr[2]/td[6]") WebElement companyStatus;
	public @FindBy (name= "toggleAll") WebElement selectAll_Checkbox;
	public @FindBy (name= "actionList") WebElement actionList;

	public @FindBy (css = "input[value=Go]" ) WebElement Go_Btn;
	
	
	//Add/Edit Company Details panel
	public @FindBy (name= "edit_companyName") WebElement edit_companyName;
	public @FindBy (name= "edit_companyCode") WebElement edit_companyCode;
	public @FindBy (name= "saveBtn") WebElement saveBtn;
	public @FindBy (name= "edit_disabled") WebElement edit_disabled;
	public @FindBy (name= "edit_CompanyType_name") WebElement edit_CompanyType_name;
	public @FindBy (name= "edit_minOrderDate") WebElement edit_minOrderDate;
	public @FindBy (name= "edit_allVendors") WebElement edit_allVendors;
	public @FindBy (name= "edit_contactName") WebElement edit_contactName;
	public @FindBy (name= "edit_contactPhone") WebElement edit_contactPhone;
	public @FindBy (name= "edit_contactEmail") WebElement edit_contactEmail;
	public @FindBy (name= "edit_companyPrintToPDF") WebElement edit_companyPrintToPDF;
	
	
	public final String[] company_name = {"test","test2"};
	public final  String[] company_code = {"test1","test2"};
	
}

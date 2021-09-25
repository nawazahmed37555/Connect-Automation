package pageObjects.connect.devices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScalesPageObjects {
	
	//Search  panel
	
		public @FindBy (name= "search_name") WebElement search_scale_name;
		public @FindBy (css = "input[value=Clear]") WebElement clearBtn;
		public @FindBy (css = "input[value=Add]") WebElement addBtn;
		public @FindBy (css = "input[value=Search]") WebElement searchBtn;
		
		//Search Results panel
		public @FindBy (name= "scaleActionList") WebElement choose_an_action;
		public @FindBy (css = "input[value=Go]" ) WebElement Go_Btn;
		public @FindBy (xpath= "//*[@id='unique_id']/tbody/tr") By searchResults;
			public @FindBy (xpath= "//*[@id='unique_id']/tbody/tr[2]/td[3]") WebElement searchResults_scaleName;
		public @FindBy (className= "menuButton") WebElement contextMenuBtn;
		public @FindBy (linkText= "Edit") WebElement contextMenu_Edit_Btn;
		public @FindBy (linkText= "Delete") WebElement contextMenu_Delete_Btn;
		public @FindBy (name= "toggleAll") WebElement selectAll_checkbox;
		
		
		
		//Add/edit panel
		public @FindBy (name= "edit_name") WebElement edit_scaleName;
		public @FindBy (name= "edit_host") WebElement edit_host;
		public @FindBy (name= "edit_port") WebElement edit_port;
		public @FindBy (name= "edit_deviceDriverId") WebElement edit_drpDown_deviceDriver;
		public @FindBy (name= "edit_companyId") WebElement edit_drpDown_company;
		public @FindBy (xpath = "//input[contains(@value,'Save')]") WebElement saveBtn;
		
		//input[contains(@value,'Save')]
		//Test data
		public String[] scale_name = {"Automated_scale1","Automated_scale2"};
		public String[] hostIP = {"192.168.0.85","192.168.0.86"};
		public String[] port = {"4400","4401"};
		
}

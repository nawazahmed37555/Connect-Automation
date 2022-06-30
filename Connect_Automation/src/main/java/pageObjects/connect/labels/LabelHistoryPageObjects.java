package pageObjects.connect.labels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LabelHistoryPageObjects {

	//Search Results panel
	
		public @FindBy (css = "input[value=Clear]") WebElement clearBtn;
		public @FindBy (css = "input[value=Add]") WebElement addBtn;
		public @FindBy (css = "input[value=Search]") WebElement searchBtn;
		public @FindBy (name= "search_LabelHistoryReprint_requestId") WebElement search_requestId;
		public @FindBy (name= "search_LabelHistoryReprint_status") WebElement search_status;
		public @FindBy (xpath= "//*[@id=\"unique_id\"]/tbody/tr[2]/td[14]/a") WebElement labelDataIcon;
		public @FindBy (xpath= "	//*[@id=\"overDiv\"]/table/tbody/tr/td/table[2]") WebElement labelDataPopup;
		public @FindBy (name= "search_LabelHistoryReprint_pdfId") WebElement search_pdfId;
			
		public @FindBy (name= "webPrintLabels") WebElement PrintToPdf_checkbox;
		public @FindBy (name= "actionList") WebElement choose_an_action;
		public @FindBy (name= "Printer_name") WebElement Printer_drpdown;
		public @FindBy (css = "input[value=Go]" ) WebElement Go_Btn;
		public @FindBy (name= "selectRow") WebElement selectRow_checkbox;
		public @FindBy (name= "toggleAll") WebElement selectAll_checkbox;
		

		
}

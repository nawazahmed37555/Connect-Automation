package pageObjects.connect.setup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ImportXMLDataPageObjects {

	public @FindBy (name="file") WebElement chooseFile_Btn;
	public @FindBy (name="load") WebElement load_Btn;
	public @FindBy (name="clear") WebElement clear_Btn;
	public @FindBy (name="updateExisting") WebElement updateExisting_checkbox;
	public @FindBy (name="import") WebElement import_Btn;
	public @FindBy (name="data") WebElement data_box;
	public @FindBy (xpath="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]") WebElement created_count;
	public @FindBy (xpath="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]") WebElement updated_count;
	public @FindBy (xpath="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]") WebElement failed_count;

	
}

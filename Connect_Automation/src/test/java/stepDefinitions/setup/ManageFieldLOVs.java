package stepDefinitions.setup;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.CommonPageLocators;
import pageObjects.connect.setup.FieldLOVsPageObjects;
import utils.DriverFactory;

public class ManageFieldLOVs extends DriverFactory{

	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public FieldLOVsPageObjects fieldLOVsPageObjects = PageFactory.initElements(driver, FieldLOVsPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);
	String display_Name[] = {"Automated_fieldLOV1", "Automated_fieldLOV2"};
	String fieldLovClassName[] = {"Autoamted_FieldLOVClass1", "Autoamted_FieldLOVClass2"};
	
	@And("^User clicks on Field LOV Values menu option$")
	public void userClicksOnFieldLOVValuesMenuOption() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Setup_Field_LOV_Values.click();
	}

	@And("^User clicks on Add button to add Field LOV value$")
	public void userClicksOnAddButtonToAddFieldLOVValue(){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		fieldLOVsPageObjects.addBtn.click();
		
	}

	@And("^User selects Class_name\\[(\\d+)\\] on Field LOV value Details panel$")
	public void userSelectsClass_nameOnFieldLOVValueDetailsPanel(int index) {
		Select className_drpDown = new Select(fieldLOVsPageObjects.edit_className_drpdown);
		className_drpDown.selectByIndex(index);
	}

	@And("^User enters Display_Name\\[(\\d+)\\] on Field LOV value Details panel$")
	public void userEntersDisplay_NameOnFieldLOVValueDetailsPanel(int index){
		fieldLOVsPageObjects.edit_displayName.clear();
		fieldLOVsPageObjects.edit_displayName.sendKeys(display_Name[index]);
	}

	@And("^User enters Field_LOV_class_name\\[(\\d+)\\] on Field LOV value Details panel$")
	public void userEntersField_LOV_class_nameOnFieldLOVValueDetailsPanel(int index) {
		fieldLOVsPageObjects.edit_fieldLovClassName.clear();
		fieldLOVsPageObjects.edit_fieldLovClassName.sendKeys(fieldLovClassName[index]);
	}

	@And("^User clicks on Save button to save Field LOV value details$")
	public void userClicksOnSaveButtonToSaveFieldLOVValueDetails() {
		fieldLOVsPageObjects.saveBtn.click();
	}

	@Then("^Verify Field LOV value with Display_name\\[(\\d+)\\] is created successfully$")
	public void verifyFieldLOVValueWithDisplay_nameIsCreatedSuccessfully(int index) {
	
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[3]")).getText().trim(), display_Name[index]);
	}

	@And("^User enters Display_Name\\[(\\d+)\\] to search a Field LOV value$")
	public void userEntersDisplay_NameToSearchAFieldLOVValue(int index)  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		fieldLOVsPageObjects.search_displayName.clear();
		fieldLOVsPageObjects.search_displayName.sendKeys(display_Name[index]);;
	}

	@And("^User clicks on Search button to search Field LOV value\\(s\\)$")
	public void userClicksOnSearchButtonToSearchFieldLOVValueS() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		fieldLOVsPageObjects.searchBtn.click();
	}

	@Then("^Field LOV value with Display_Name\\[(\\d+)\\] should be displayed in search results$")
	public void fieldLOVValueWithDisplay_NameShouldBeDisplayedInSearchResults(int index)  {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[3]")).getText().trim(), display_Name[index]);
		
	}

	@And("^User clicks on Edit option to edit Field LOV value$")
	public void userClicksOnEditOptionToEditFieldLOVValue() {
		fieldLOVsPageObjects.contextMenuBtn.click();
		fieldLOVsPageObjects.contextMenu_Edit_Btn.click();
	}

	@Then("^Verify Field LOV value with Display_Name\\[(\\d+)\\] details updated successfully$")
	public void verifyFieldLOVValueWithDisplay_NameDetailsUpdatedSuccessfully(int index)  {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[3]")).getText().trim(), display_Name[index]);

	}

	@When("^User clicks on Delete option to delete Field LOV value$")
	public void userClicksOnDeleteOptionToDeleteFieldLOVValue() {
		fieldLOVsPageObjects.contextMenuBtn.click();
		fieldLOVsPageObjects.contextMenu_Delete_Btn.click();
	}

	@Then("^Verify Field LOV value with Display_Name\\[(\\d+)\\] deleted successfully$")
	public void verifyFieldLOVValueWithDisplay_NameDeletedSuccessfully(int index) {
		
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td")).getText(), "No Results Found");

	}


	
}

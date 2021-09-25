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
import pageObjects.connect.setup.AttributesPageObjects;
import utils.DriverFactory;

public class ManageAttributes extends DriverFactory{

	
	public String[] LOV_Query = {"Automated_lov_Query1","Automated_lov_Query2"};
	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public AttributesPageObjects attributesPageObjects = PageFactory.initElements(driver, AttributesPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);
	public ManageFlexFields manageFlexFields = PageFactory.initElements(driver, ManageFlexFields.class);
	

	@And("^User clicks on Attributes menu option$")
	public void userClicksOnAttributesMenuOption() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Setup_Attributes.click();
		
	}

	@And("^User clicks on Add button to add Attribute$")
	public void userClicksOnAddButtonToAddAttribute() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		attributesPageObjects.addBtn.click();
	}

	@And("^User selects Flex_Field_name\\[(\\d+)\\] on Attribute Details panel$")
	public void userSelectsFlex_Field_nameOnAttributeDetailsPanel(int index) {
		Select flex_field_drpdown = new Select(attributesPageObjects.edit_Flexfield_name_drpDown);
		flex_field_drpdown.selectByVisibleText(manageFlexFields.flex_field_name[index]);;
		}

	@And("^User selects Field_name\\[(\\d+)\\] on Attribute Details panel$")
	public void userSelectsField_nameOnAttributeDetailsPanel(int index)  {
		Select fieldName_drpdown = new Select(attributesPageObjects.edit_Field_name_drpDown);
		fieldName_drpdown.selectByIndex(index);
		  
	}

	@And("^User selects Index\\[(\\d+)\\] on Attribute Details panel$")
	public void userSelectsIndexOnAttributeDetailsPanel(int index)  {
		Select index_drpdown = new Select(attributesPageObjects.edit_index_drpDown);
		index_drpdown.selectByIndex(index);
	}

	@And("^User enters LOV_Query\\[(\\d+)\\] on Attribute Details panel$")
	public void userEntersLOV_QueryOnAttributeDetailsPanel(int index) {
		attributesPageObjects.edit_LOV_query.clear();
		attributesPageObjects.edit_LOV_query.sendKeys(LOV_Query[index]);
	}

	@And("^User clicks on Save button to save Attribute details$")
	public void userClicksOnSaveButtonToSaveAttributeDetailsPanel()  {
		attributesPageObjects.saveBtn.click();
	}

	@Then("^Verify Attribute with Flex_Field_name\\[(\\d+)\\] is created successfully$")
	public void verifyAttributeWithFlex_Field_nameIsCreatedSuccessfully(int index){
		Assert.assertEquals( driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[3]")).getText().trim(), manageFlexFields.flex_field_name[index]);
	}

	@And("^User enters Flex_Field_name\\[(\\d+)\\] to search a Attribute$")
	public void userEntersFlex_Field_nameToSearchAAttribute(int index)  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		attributesPageObjects.search_Flexfield_name.clear();
		attributesPageObjects.search_Flexfield_name.sendKeys(manageFlexFields.flex_field_name[index]);
	}

	@And("^User clicks on Search button to search Attribute\\(s\\)$")
	public void userClicksOnSearchButtonToSearchAttributeS()  {
		attributesPageObjects.searchBtn.click();
	}

	@Then("^Attribute with Flex_Field_name\\[(\\d+)\\] should be displayed in search results$")
	public void attributeWithFlex_Field_nameShouldBeDisplayedInSearchResults(int index) {
		Assert.assertEquals( driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[3]")).getText().trim(), manageFlexFields.flex_field_name[index]);
		
	}

	@And("^User clicks on Edit option to edit Attribute$")
	public void userClicksOnEditOptionToEditAttribute() throws Throwable {
		attributesPageObjects.contextMenuBtn.click();
		attributesPageObjects.contextMenu_Edit_Btn.click();
	}

	@Then("^Verify Attribute with Flex_Field_name\\[(\\d+)\\] details updated successfully$")
	public void verifyAttributeWithFlex_Field_nameDetailsUpdatedSuccessfully(int index)  {
		Select flex_field_drpdown = new Select(attributesPageObjects.edit_Flexfield_name_drpDown);
		Assert.assertEquals(flex_field_drpdown.getFirstSelectedOption().getText().trim(), manageFlexFields.flex_field_name[index]);
		Assert.assertEquals(attributesPageObjects.edit_LOV_query.getAttribute("value"), LOV_Query[index]);

	}

	@When("^User clicks on Delete option to delete Attribute$")
	public void userClicksOnDeleteOptionToDeleteAttribute() {
		attributesPageObjects.contextMenuBtn.click();
		attributesPageObjects.contextMenu_Delete_Btn.click();
	}

	@Then("^Verify Attribute with Flex_Field_name\\[(\\d+)\\] deleted successfully$")
	public void verifyAttributeWithFlex_Field_nameDeletedSuccessfully(int index)  {
		Assert.assertEquals( driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td")).getText().trim(), "No Results Found");
	}
}

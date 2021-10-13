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
import pageObjects.connect.setup.MenusPageObjects;
import utils.DriverFactory;
import utils.JsonConfigReader;

public class ManageMenus extends DriverFactory {


	public String[] display_name = {"Automated_menu1","Automated_menu2","Automated_child_menu1"};
	public String[] childMenu_display_name = {"Automated_child_menu1","Automated_child_menu2"};
	public String[] sequence = {"10","20","1"};
	public String[] href = {"/folder.do?operation=showSearch","/namespace.do?operation=showSearch","/namespace.do?operation=showSearch"};
	
	JsonConfigReader reader = new JsonConfigReader();
	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public MenusPageObjects menusPageObjects = PageFactory.initElements(driver, MenusPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);
	
	@And("^User clicks on Menus menu option$")
	public void userClicksOnMenusMenuOption()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Setup_Menus.click();
		}

	@And("^User clicks on Add button to add Menu$")
	public void userClicksOnAddButtonToAddMenu()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		menusPageObjects.addBtn.click();
	}

	@And("^User selects Menu_group\\[(\\d+)\\] on Menu Details panel$")
	public void userSelectsMenu_groupOnMenuDetailsPanel(int index)  {
	Select menu_grpoup_drpdown = new Select(menusPageObjects.edit_menuGroup_drpDown); 
	menu_grpoup_drpdown.selectByIndex(index);
	}

	@And("^User enters HREF\\[(\\d+)\\] on Menu Details panel$")
	public void userEntersHREFOnMenuDetailsPanel(int index) {
		menusPageObjects.edit_href.clear();
		menusPageObjects.edit_href.sendKeys(href[index]);
	}

	@And("^User enters Display_name\\[(\\d+)\\] on Menu Details panel$")
	public void userEntersDisplay_nameOnMenuDetailsPanel(int index) {
		menusPageObjects.edit_displayName.clear();
		menusPageObjects.edit_displayName.sendKeys(display_name[index]);
	}

	@And("^User selects Application\\[(\\d+)\\] on Menu Details panel$")
	public void userSelectsApplicationOnMenuDetailsPanel(int index) {
		Select applciation_drpdown = new Select(menusPageObjects.edit_application_drpDown); 
		applciation_drpdown.selectByIndex(index);
	}


	@And("^User enters Sequence\\[(\\d+)\\] on Menu Details panel$")
	public void userEntersSequenceOnMenuDetailsPanel(int index) {
		menusPageObjects.edit_sequence.clear();
		menusPageObjects.edit_sequence.sendKeys(sequence[index]);
		
		
	}
	@And("^User selects Menu_item_type\\[(\\d+)\\] on Menu Details panel$")
	public void userSelectsMenu_item_typeOnMenuDetailsPanel(int index)  {
		Select menu_item_type_drpdown = new Select(menusPageObjects.edit_menuItemType_drpDown); 
		menu_item_type_drpdown.selectByIndex(index);
	}
	
	@And("^User clicks on responsibilities tab on Menu Details panel$")
	public void userClicksOnResponsibilitiesTabOnMenuDetailsPanel() {
		
		menusPageObjects.responsibility_tab.click();
	}

	@And("^User selects responsibility \"([^\"]*)\" to assign to the menu$")
	public void userSelectsResponsibilityToAssignToTheMenu(String respName) throws Throwable {
		Select responsibilities_drpdown = new Select(menusPageObjects.unassignedResponsibilitiesList); 
		responsibilities_drpdown.selectByVisibleText(respName);;
	}

	@And("^User clicks on Add button to assign the reponsibility to the menu$")
	public void userClicksOnAddButtonToAssignTheReponsibilityToTheMenu()  {
		menusPageObjects.edit_addBtn.click();
	}


	@And("^User clicks on Save button to save Menu details$")
	public void userClicksOnSaveButtonToSaveMenuDetails() {
		menusPageObjects.saveBtn.click();
		try {
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
		}
		catch(Exception e) {
		 //do nothing
		}
		
	}

	@Then("^Verify Menu with Menu_name\\[(\\d+)\\] is created successfully$")
	public void verifyMenuWithMenu_nameIsCreatedSuccessfully(int index)  {
		Assert.assertEquals(menusPageObjects.searchResult.getText().trim(), display_name[index]);
		driver.get(reader.getConfigValue("GeneralSettings", "connectURL" ));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		Assert.assertEquals(driver.findElement(By.linkText(display_name[index])).isDisplayed(), true);
	}

	@And("^User enters Menu_display_name\\[(\\d+)\\] to search a Menu$")
	public void userEntersMenu_display_nameToSearchAMenu(int index) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		menusPageObjects.search_displayName.clear();
		menusPageObjects.search_displayName.sendKeys(display_name[index]);
	}

	@And("^User clicks on Search button to search Menu$")
	public void userClicksOnSearchButtonToSearchMenu(){
		menusPageObjects.searchBtn.click();
	}

	@Then("^Menu with Menu_display_name\\[(\\d+)\\] should be displayed in search results$")
	public void menuWithMenu_display_nameShouldBeDisplayedInSearchResults(int index) {
		Assert.assertEquals(menusPageObjects.searchResult.getText().trim(), display_name[index]);
	}

	@And("^User clicks on Edit option to edit Menu$")
	public void userClicksOnEditOptionToEditMenu() throws Throwable {
		menusPageObjects.contextMenuBtn.click();
		menusPageObjects.contextMenu_Edit_Btn.click();
	}

	@Then("^Verify Menu\\[(\\d+)\\] details updated successfully$")
	public void verifyMenuDetailsUpdatedSuccessfully(int index)  {
		Assert.assertEquals(menusPageObjects.searchResult.getText().trim(), display_name[index]);
	}

	@And("^User clicks on Disable option to disable menu$")
	public void userClicksOnDisableOptionToDisableMenu() {
		menusPageObjects.contextMenuBtn.click();
		menusPageObjects.contextMenu_Disable_Btn.click();
	}

	@Then("^Menu should be disabled successfully$")
	public void menuShouldBeDisabledSuccessfully() {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[9]")).getText(), "true");
		
	}

	@And("^User clicks on Enable option to enable menu$")
	public void userClicksOnEnableOptionToEnableMenu() {
		menusPageObjects.contextMenuBtn.click();
		menusPageObjects.contextMenu_Enable_Btn.click();
	}

	@Then("^Menu should be Enabled successfully$")
	public void menuShouldBeEnabledSuccessfully()  {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[9]")).getText(), "false");
	}

	@And("^User clicks on Add Child option to add child menu$")
	public void userClicksOnAddChildOptionToAddChildMenu() throws Throwable {
		menusPageObjects.contextMenuBtn.click();
		menusPageObjects.contextMenu_Add_Child_Btn.click();
	}

	@Then("^Verify Child_menu\\[(\\d+)\\] under Menu_name\\[(\\d+)\\] is created successfully$")
	public void verifyChild_menuUnderMenu_nameIsCreatedSuccessfully(int childIndex, int parentIndex) {
		driver.get(reader.getConfigValue("GeneralSettings", "connectURL" ));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		driver.findElement(By.linkText(display_name[parentIndex])).click();
		Assert.assertEquals(driver.findElement(By.linkText(display_name[childIndex])).isDisplayed(), true);
	}

	@When("^User clicks on Delete option to delete Menu$")
	public void userClicksOnDeleteOptionToDeleteMenu() {
		menusPageObjects.contextMenuBtn.click();
		menusPageObjects.contextMenu_Delete_Btn.click();
	}

	@Then("^Verify Menu deleted successfully$")
	public void verifyMenuDeletedSuccessfully() {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td")).getText(), "No Results Found");
	}
	

}

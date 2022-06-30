package stepDefinitions.setup;


import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.BasePage;
import pageObjects.CommonPageLocators;
import pageObjects.connect.setup.SavedSearchesPageObjects;
import utils.DriverFactory;

public class ManagaSavedSearches extends DriverFactory{

	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public SavedSearchesPageObjects savedSearchesPageObjects = PageFactory.initElements(driver, SavedSearchesPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);
	public String savedSearches[]= {"Automated_savedSearch1","Automated_savedSearch2"};

	@And("^User clicks on Saved Search menu option$")
	public void userClicksOnSavedSearchMenuOption() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Setup_Saved_Searches.click();
		
	}

	@And("^User clicks on Search button to search Saved Search\\(s\\)$")
	public void userClicksOnSearchButtonToSearchSavedSearchS()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		savedSearchesPageObjects.searchBtn.click();
	}

	@Then("^All Saved searches should be displayed in search results$")
	public void allSavedSearchesShouldBeDisplayedInSearchResults() {
		Assert.assertTrue(driver.findElements(By.xpath("//*[@id='unique_id']/tbody/tr")).size()>1);
		
	}
	@And("^User copies the Saved_Search_Name\\[(\\d+)\\] from the search results$")
	public void userCopiesTheSaved_Search_NameFromTheSearchResults(int index) {
		savedSearches[index] = driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[3]")).getText().trim();
		
	}

	@And("^User enters Saved_Search_Name\\[(\\d+)\\] to search a Saved Search$")
	public void userEntersSaved_Search_NameToSearchASavedSearch(int index) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		savedSearchesPageObjects.search_SavedSearchName.clear();
		savedSearchesPageObjects.search_SavedSearchName.sendKeys(savedSearches[index]);
	}

	@Then("^Saved_Search_Name\\[(\\d+)\\] should be displayed in search results$")
	public void saved_search_nameShouldBeDisplayedInSearchResults(int index)  {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[3]")).getText().trim(), savedSearches[index]);
	}

	@And("^User clicks on Edit option to edit Saved Search$")
	public void userClicksOnEditOptionToEditSavedSearch() {
		savedSearchesPageObjects.contextMenuBtn.click();
		savedSearchesPageObjects.contextMenu_Edit_Btn.click();
	}

	@And("^User changes Saved_Search_Name\\[(\\d+)\\]$")
	public void userChangesSaved_Search_Name(int index)  {
		
		savedSearchesPageObjects.edit_SavedSearchName.clear();
		savedSearchesPageObjects.edit_SavedSearchName.sendKeys(savedSearches[index]);
	}

	@And("^User clicks on Save button to save Saved Search details$")
	public void userClicksOnSaveButtonToSaveSavedSearchDetails() {
		savedSearchesPageObjects.saveBtn.click();
	}

	@Then("^Verify Saved Search\\[(\\d+)\\] details updated successfully$")
	public void verifySavedSearchDetailsUpdatedSuccessfully(int index) {
		Assert.assertEquals(savedSearchesPageObjects.edit_SavedSearchName.getAttribute("value"), savedSearches[index]);
		
	}


}

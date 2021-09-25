package stepDefinitions.setup;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.CommonPageLocators;
import pageObjects.connect.setup.NamespacesPageObjects;
import utils.DriverFactory;

public class ManageNamespaces extends DriverFactory{
	public String[] nameSpace_name = {"Auto_NameSpace1","Auto_NameSpace2"};
	public String[] className = {"Automated_className_1","Automated_className_2"};
	public String[] description = {"Automated Desciption 1","Automated Description 2"};
	
	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public NamespacesPageObjects nameSpacesPageObjects = PageFactory.initElements(driver, NamespacesPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);


	@And("^User clicks on Namespaces menu option$")
	public void userClicksOnNamespacesMenuOption()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Setup_NameSpaces.click();
	}

	@And("^User clicks on Add button to add Namespace$")
	public void userClicksOnAddButtonToAddNamespace() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		nameSpacesPageObjects.addBtn.click();
	}
	@And("^User enters Namespace_name\\[(\\d+)\\] on Namespace Details panel$")
	public void userEntersNamespace_nameOnNamespaceDetailsPanel(int index)  {
		nameSpacesPageObjects.edit_NameSpace_name.clear();
		nameSpacesPageObjects.edit_NameSpace_name.sendKeys(nameSpace_name[index]);
	}

	@And("^User enters Class_name\\[(\\d+)\\] on Namespace Details panel$")
	public void userEntersClass_nameOnNamespaceDetailsPanel(int index)  {
		nameSpacesPageObjects.edit_Class_name.clear();
		nameSpacesPageObjects.edit_Class_name.sendKeys(className[index]);
	}

	@And("^User enters Description\\[(\\d+)\\] on Namespace Details panel$")
	public void userEntersDescriptionOnNamespaceDetailsPanel(int index)  {
		nameSpacesPageObjects.edit_description.clear();
		nameSpacesPageObjects.edit_description.sendKeys(description[index]);
	}

	@And("^User clicks on Save button to save Namespace details$")
	public void userClicksOnSaveButtonToSaveNamespaceDetails()  {
		nameSpacesPageObjects.saveBtn.click();
	}


	@And("^User enters Namespace_name\\[(\\d+)\\] to search a Namespace$")
	public void userEntersNamespace_nameToSearchANamespace(int index) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		nameSpacesPageObjects.search_NameSpace_name.clear();
		nameSpacesPageObjects.search_NameSpace_name.sendKeys(nameSpace_name[index]);
	}

	@And("^User clicks on Search button to search Namespace$")
	public void userClicksOnSearchButtonToSearchNamespace()  {
		nameSpacesPageObjects.searchBtn.click();
	}

	@Then("^Namespace with Namespace_name\\[(\\d+)\\] should be displayed in search results$")
	public void namespaceWithNamespace_nameShouldBeDisplayedInSearchResults(int index)  {
		Assert.assertEquals(nameSpacesPageObjects.searchResult.getText().trim(), nameSpace_name[index]);
	}

	@And("^User enters Class_name\\[(\\d+)\\] to search a Namespace$")
	public void userEntersClass_nameToSearchANamespace(int index)  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		nameSpacesPageObjects.search_ClassName.clear();
		nameSpacesPageObjects.search_ClassName.sendKeys(className[index]);
	}

	@Then("^Namespace with Class_name\\[(\\d+)\\] should be displayed in search results$")
	public void namespaceWithClass_nameShouldBeDisplayedInSearchResults(int index)  {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td[4]")).getText().trim(), className[index]);
		
	}

	@And("^User clicks on Edit option to edit Namespace$")
	public void userClicksOnEditOptionToEditNamespace() {
		nameSpacesPageObjects.contextMenuBtn.click();
		nameSpacesPageObjects.contextMenu_Edit_Btn.click();
	}

	@Then("^Verify Namespace\\[(\\d+)\\] details updated successfully$")
	public void verifyNamespaceDetailsUpdatedSuccessfully(int index)  {
		Assert.assertEquals(nameSpacesPageObjects.edit_NameSpace_name.getAttribute("value"),nameSpace_name[index] );
		Assert.assertEquals(nameSpacesPageObjects.edit_description.getAttribute("value"),description[index] );
		Assert.assertEquals(nameSpacesPageObjects.edit_Class_name.getAttribute("value"),className[index] );
	}

	@When("^User clicks on Delete option to delete Namespace$")
	public void userClicksOnDeleteOptionToDeleteNamespace()  {
		nameSpacesPageObjects.contextMenuBtn.click();
		nameSpacesPageObjects.contextMenu_Delete_Btn.click();
	}

	@Then("^Verify Namespace deleted successfully$")
	public void verifyNamespaceDeletedSuccessfully()  {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td")).getText(), "No Results Found");
	}
}

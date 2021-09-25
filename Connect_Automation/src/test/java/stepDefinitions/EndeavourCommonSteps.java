package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.CommonPageLocators;
import pageObjects.connect.setup.LookupsPageObjects;
import pageObjects.endeavour.EndeavourCommonPageObjects;
import utils.DriverFactory;

public class EndeavourCommonSteps extends DriverFactory{

	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public EndeavourCommonPageObjects endeavourPageObjects = PageFactory.initElements(driver, EndeavourCommonPageObjects.class);
	public LookupsPageObjects lookupsPageObjects = PageFactory.initElements(driver, LookupsPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);
	
	@When("^User clicks on Purchase Orders menu option$")
	public void userClicksOnPurchaseOrdersMenuOption() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(endeavourPageObjects.menu_frame);
		endeavourPageObjects.Purchase_Orders.click();
	}

	@And("^User clicks on Search Orders menu option$")
	public void userClicksOnSearchOrdersMenuOption() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(endeavourPageObjects.menu_frame);
		endeavourPageObjects.Search_Orders.click();
	}

	@And("^User clicks on Search button to search all purchase orders$")
	public void userClicksOnSearchButtonToSearchAllOrders() throws InterruptedException {
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame(endeavourPageObjects.body_frame);
		endeavourPageObjects.searchBtn.click();
	}

	@Then("^Total search results should be as per the lookup$")
	public void totalSearchResultsShouldBeAsPerTheLookup(DataTable table)  {
		String SearchResultCount = driver.findElement(By.xpath("//*[@id='searchResultsFormId']/table[1]/tbody/tr[1]/td/table/tbody/tr/td[3]")).getText();
		SearchResultCount=SearchResultCount.substring(SearchResultCount.lastIndexOf("of")+2);
		List<List<String>> data = table.asLists();
		String ExpectedResultsCount = data.get(0).get(1);
		Assert.assertEquals(SearchResultCount, ExpectedResultsCount);
		
	}
}

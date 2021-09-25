package stepDefinitions.devices;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.CommonPageLocators;
import pageObjects.connect.devices.CarouselsPageObjects;
import utils.DriverFactory;

public class ManageCarousels extends DriverFactory {
	
	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public CarouselsPageObjects carouselsPageObjects = PageFactory.initElements(driver, CarouselsPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);
		
	@When("^User clicks on Devices menu option$")
	public void user_clicks_on_Devices_menu_option() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Devices.click();
	}

	@When("User clicks on Carousels menu option")
	public void user_clicks_on_Carousels_menu_option() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Devices_Carousels.click();
	}

	
	@When("User clicks on Add button to add Carousel")
	public void user_clicks_on_Add_button_to_add_Carousel() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		carouselsPageObjects.addBtn.click();
	}

	

	@And("^User Enters required detais to add Carousel\\[(\\d+)\\]$")
	public void userEntersRequiredDetaisToAddCarousel(int index) throws Throwable {
		carouselsPageObjects.edit_CarouselName.sendKeys(carouselsPageObjects.carousel_name[index]);
		carouselsPageObjects.edit_host.sendKeys(carouselsPageObjects.hostIP[index]);
		carouselsPageObjects.edit_port.sendKeys(carouselsPageObjects.port[index]);
		Select deviceDriver_dropDown = new Select(carouselsPageObjects.edit_drpDown_deviceDriver);
		deviceDriver_dropDown.selectByIndex(index+1);
		Select company_drpDown = new Select (carouselsPageObjects.edit_drpDown_company);
		company_drpDown.selectByIndex(index+1);
	}

	
	@When("User clicks on Save button to add Carousel")
	public void user_clicks_on_Save_button_to_add_Carousel() {
		carouselsPageObjects.saveBtn.click();
		
	}

	

	@Then("Verify Carousel is created successfully")
	public void verify_Carousel_is_created_successfully() {
	  Assert.assertEquals(carouselsPageObjects.edit_CarouselName.getAttribute("value"), carouselsPageObjects.carousel_name[0]);
		
	}

	@And("User enters search criteria to search a Carousel")
	public void userEntersSearchCriteriaToSearchACarousel() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		carouselsPageObjects.search_carousel_name.sendKeys(carouselsPageObjects.carousel_name[0]);
	}

	@And("^User clicks on Search button to search Carousel$")
	public void userClicksOnSearchButtonToSearchCarousel()  {
		carouselsPageObjects.searchBtn.click();
	}

	@Then("^Carousel should be displayed in search results$")
	public void carouselShouldBeDisplayedInSearchResults()  {
		
		Assert.assertEquals(carouselsPageObjects.searchResults_carouselName.getText().trim(),carouselsPageObjects.carousel_name[0]);
	}

	@When("^User clicks on Edit option to edit Carousel$")
	public void userClicksOnEditOptionToEditCarousel()  {
		carouselsPageObjects.contextMenuBtn.click();
		carouselsPageObjects.contextMenu_Edit_Btn.click();
		
	}

	@And("^User changes Carousel details$")
	public void userChangesCarouselDetails()  {
		carouselsPageObjects.edit_CarouselName.clear();
		carouselsPageObjects.edit_CarouselName.sendKeys(carouselsPageObjects.carousel_name[1]);
		carouselsPageObjects.edit_host.clear();
		carouselsPageObjects.edit_host.sendKeys(carouselsPageObjects.hostIP[1]);
		carouselsPageObjects.edit_port.clear();
		carouselsPageObjects.edit_port.sendKeys(carouselsPageObjects.port[1]);
		Select deviceDriver_dropDown = new Select(carouselsPageObjects.edit_drpDown_deviceDriver);
		deviceDriver_dropDown.selectByIndex(2);
		Select company_drpDown = new Select (carouselsPageObjects.edit_drpDown_company);
		company_drpDown.selectByIndex(2);
		
		
	}

	@And("^User clicks on Save button to save Carousel details$")
	public void userClicksOnSaveButtonToSaveCarouselDetails()  {
		carouselsPageObjects.saveBtn.click();
	}

	@Then("^Verify Carousel details updated successfully$")
	public void verifyCarouselDetailsUpdatedSuccessfully()  {
		Assert.assertEquals(carouselsPageObjects.edit_CarouselName.getAttribute("value"),carouselsPageObjects.carousel_name[1]);
		Assert.assertEquals(carouselsPageObjects.edit_host.getAttribute("value"),carouselsPageObjects.hostIP[1]);
		Assert.assertEquals(carouselsPageObjects.edit_port.getAttribute("value"),carouselsPageObjects.port[1]);
		
	}

	@And("^User clicks on Search button to search Carousels$")
	public void userClicksOnSearchButtonToSearchCarousels() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		carouselsPageObjects.searchBtn.click();
	}

	@Then("^All Carousels should be displayed in search results$")
	public void allCarouselsShouldBeDisplayedInSearchResults() {
		Assert.assertTrue(driver.findElements(By.xpath("//*[@id='unique_id']/tbody/tr")).size()>1);
	}

	@When("^User clicks on checkbox to select all Carousels under search results$")
	public void userClicksOnCheckboxToSelectAllCarouselsUnderSearchResults()  {
		carouselsPageObjects.selectAll_checkbox.click();
	}

	@And("^User clicks on Choose an Action drop down on Carousels page$")
	public void userClicksOnChooseAnActionDropDownOnCarouselsPage() {
		carouselsPageObjects.choose_an_action.click();
	}

	@And("^User selects Export as XML on Carousels page$")
	public void userSelectsExportAsXMLOnCarouselsPage() {
		Select chooseAnAction_drpDown = new Select(carouselsPageObjects.choose_an_action);
		chooseAnAction_drpDown.selectByVisibleText("Export as XML");
	}

	@And("^User clicks on Go button on Carousels page$")
	public void userClicksOnGoButtonOnCarouselsPage()  {
		carouselsPageObjects.Go_Btn.click();
	}

	@Then("^Verify that the Carousel records xml file was successfully downloaded$")
	public void verifyThatTheCarouselRecordsXmlFileWasSuccessfullyDownloaded() throws InterruptedException  {
		//Dates starting with 0(for ex :01-01-2021) needs to be stripped to match the fileName
		String currentDate = basePage.getCURRENTDate_initialZeroStripped("M-d-yyyy");
		String FileName = "carousel_export_"+currentDate+".xml";
		Assert.assertEquals(basePage.isFileDownloaded(utils.Constant.downloadDirectory, FileName, 60),true);
	}

	@When("^User clicks on Delete option to delete Carousel$")
	public void userClicksOnDeleteOptionToDeleteCarousel()  {
		carouselsPageObjects.contextMenuBtn.click();
		carouselsPageObjects.contextMenu_Delete_Btn.click();
	}

	@Then("^Verify Carousel deleted successfully$")
	public void verifyCarouselDeletedSuccessfully(){
	
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td")).getText(), "No Results Found");
	}

	@And("^User enters \"([^\"]*)\" to search a Carousel$")
	public void userEntersToSearchACarousel(String[] carouselName)  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		carouselsPageObjects.search_carousel_name.sendKeys(carouselName);
	}

	@And("^User enters 'carouselsPageObjects\\.carousel_name\\[(\\d+)\\]' to search a Carousel$")
	public void userEntersCarouselsPageObjectsCarousel_nameToSearchACarousel(int index) throws Throwable {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		carouselsPageObjects.search_carousel_name.sendKeys(carouselsPageObjects.carousel_name[index]);
	}

	@Then("^Carousel 'carouselsPageObjects\\.carousel_name\\[(\\d+)\\]' should be displayed in search results$")
	public void carouselspageobjectsCarousel_nameShouldBeDisplayedInSearchResults(int index)  {
		Assert.assertEquals(carouselsPageObjects.searchResults_carouselName.getText().trim(),carouselsPageObjects.carousel_name[index]);

	}

	@And("^User enters carousel_name\\[(\\d+)\\] to search a Carousel$")
	public void userEntersCarousel_nameToSearchACarousel(int index)  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		carouselsPageObjects.search_carousel_name.sendKeys(carouselsPageObjects.carousel_name[index]);
	}

	@Then("^Carousel carousel_name\\[(\\d+)\\] should be displayed in search results$")
	public void carouselCarousel_nameShouldBeDisplayedInSearchResults(int index) throws Throwable {
		Assert.assertEquals(carouselsPageObjects.searchResults_carouselName.getText().trim(),carouselsPageObjects.carousel_name[index]);

	}



	

	
	
}

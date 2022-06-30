package stepDefinitions;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.CommonPageLocators;
import utils.DriverFactory;

public class CommonSteps extends DriverFactory {
	
	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);
	

	@When("^User clicks on Add button$")
	public void userClicksOnAddButton() {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(commonPageLocators.body_frame);
			commonPageLocators.addBtn.click();			
	}


	@And("^User clicks on Save button$")
	public void userClicksOnSaveButton() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		commonPageLocators.saveBtn.click();	
	}


	@And("^User clicks on Search button$")
	public void userClicksOnSearchButton()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		commonPageLocators.searchBtn.click();	
	}	
}

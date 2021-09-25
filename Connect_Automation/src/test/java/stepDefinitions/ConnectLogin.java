package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.CommonPageLocators;
import pageObjects.connect.LoginPageObjects;
import utils.Constant;
import utils.DriverFactory;
import utils.JsonConfigReader;

public class ConnectLogin extends DriverFactory {
	
	
	JsonConfigReader reader = new JsonConfigReader();
	public LoginPageObjects loginPageObjects = PageFactory.initElements(driver, LoginPageObjects.class);
	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public Constant constant = PageFactory.initElements(driver, Constant.class);
	
	@Given("^User Navigates to Connect URL$")
	public void user_Navigates_to_Connect_URL() {
			
		driver.get(reader.getConfigValue("GeneralSettings", "connectURL" ));		
	}

	@And("^User Enters valid Username$")
	public void user_Enters_valid_Username() {
	   
		loginPageObjects.Username_txtF.sendKeys(reader.getConfigValue("Connect", "username"));      
	}

	@And("^User Enters valid Password$")
	public void user_Enters_valid_Password() {
	    
		loginPageObjects.Password_txtF.sendKeys(reader.getConfigValue("Connect", "password"));
		}

	@When("^User clicks on Login button$")
	public void user_clicks_on_Login_button() {
	    
		loginPageObjects.LogIn_btn.click();
	
	}

	@Then("^Connect Home Page is displayed$")
	public void connect_Home_Page_is_displayed() throws InterruptedException {
			driver.switchTo().frame(commonPageLocators.Header_frame);
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id='userDetail']/table/tbody/tr[1]/td/font/b")).getText(),reader.getConfigValue("Connect", "username"));			
	}
	
	@Given("^User Enters invalid Username$")
	public void user_Enters_invalid_Username() {
		loginPageObjects.Username_txtF.sendKeys(reader.getConfigValue("IncorrectCredentials", "username"));
	    
	}
	@Given("^User Enters invalid Password$")
	public void user_Enters_invalid_Password() {
		loginPageObjects.Password_txtF.sendKeys(reader.getConfigValue("IncorrectCredentials", "password"));
	}
	
	@Then("^Access denied error message is displayed.$")
	public void access_denied_error_message_is_displayed() {

		Assert.assertEquals(constant.IncorrectCredentials_Error, driver.findElement(By.xpath("//*[@id='errors']")).getText()); 
	}

	@When("^User cliks on Logout button$")
	public void userCliksOnLogoutButton()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Logout.click();
		driver.navigate().refresh();
		Assert.assertEquals("Welcome",driver.getTitle());
	}

	@And("^User Navigates to Endeavour URL in new tab$")
	public void userNavigatesToEndeavourURLInNewTab() {
		driver.get(reader.getConfigValue("GeneralSettings", "endeavourURL"));
		
	}

	@Then("^User is automatically logged into Endeavour$")
	public void userIsAutomaticallyLoggedIntoEndeavour() {
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='bottom_frame']/frame[1]")));
		Assert.assertEquals(true ,driver.findElement(By.xpath("//*[@id='oMenu']/table/tbody/tr[1]/td/table/tbody/tr/td[3]/a")).isDisplayed());
		
	}

	@Given("^User Navigates to Endeavour URL$")
	public void userNavigatesToEndeavourURL()  {
		driver.get(reader.getConfigValue("GeneralSettings", "endeavourURL" ));
	}
	@And("^User Enters valid Username for Endeavour$")
	public void userEntersValidUsernameForEndeavour() {
		loginPageObjects.Username_txtF.sendKeys(reader.getConfigValue("Endeavour", "username"));  
	}

	@And("^User Enters valid Password for Endeavour$")
	public void userEntersValidPasswordForEndeavour()  {
		loginPageObjects.Password_txtF.sendKeys(reader.getConfigValue("Endeavour", "password"));
	}
	@Then("^Endeavour Home Page is displayed$")
	public void endeavourHomePageIsDisplayed()  {
		driver.switchTo().frame(commonPageLocators.Header_frame);
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[2]/form/table/tbody/tr/td[2]")).getText(),reader.getConfigValue("Endeavour", "username"));			
		
	}

	
	

}

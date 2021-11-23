package stepDefinitions.setup;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.BasePage;
import pageObjects.CommonPageLocators;
import pageObjects.connect.setup.CachePageObjects;
import utils.DriverFactory;

public class ManageCaches extends DriverFactory{

	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public CachePageObjects cachePageObjects = PageFactory.initElements(driver, CachePageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);

	public String parentWindowHandle;
	public float cacheSizeBeforeDelete;
	public float cacheSizeAfterDelete;

	@And("^User clicks on Caches menu option$")
	public void userClicksOnCachesMenuOption() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Setup_Caches.click();
		
	}

	@And("^User clicks on View button to view Cache$")
	public void userClicksOnViewButtonToViewCache() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);	
		parentWindowHandle=driver.getWindowHandle();
		cachePageObjects.viewCacheButton.click();
		
	}
	@And("^Navigate to Cache View window$")
	public void navigateToCacheViewWindow()  {
		basePage.switchToWindow("View Cache");
	}


	@And("^User clicks on Close button to close the Cache details window$")
	public void userClicksOnCloseButtonToCloseTheCacheDetailsWindow() {
		cachePageObjects.closeButton.click();
	}

	@Then("^Cache details window should be closed$")
	public void cacheDetailsWindowShouldBeClosed() {
		driver.switchTo().window(parentWindowHandle);
		if(basePage.switchToWindow("View Cache")== true) {
			Assert.fail("View Cache window is not closed");
		}
		
	}

	@And("^User clicks on Delete button to delete Cache$")
	public void userClicksOnDeleteButtonToDeleteCache()  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);	
		String size = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[5]")).getText();
		cacheSizeBeforeDelete= Float.parseFloat(size);
		cachePageObjects.deleteCacheButton.click();
	}

	@Then("^Verify that the cache got deleted$")
	public void verifyThatTheCacheGotDeleted(){
		String size = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[5]")).getText();
		cacheSizeAfterDelete= Float.parseFloat(size);
		Assert.assertTrue(cacheSizeBeforeDelete>cacheSizeAfterDelete);
		System.out.println(cacheSizeBeforeDelete);
		System.out.println(cacheSizeAfterDelete);
	}
}

package stepDefinitions.hook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import utils.DriverFactory;
import utils.JsonConfigReader;

public class MasterHook extends DriverFactory {

	

	@Before
	
	public void setup() {
		JsonConfigReader jsonConfigReader = new JsonConfigReader();
		driver = getDriver(jsonConfigReader.getConfigValue("DriverConfig", "browser"),
		jsonConfigReader.getConfigValue("DriverConfig", "environment"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@SuppressWarnings("deprecation")
	@After
	@Attachment("Screenshot on failure")
	public void tearDownAndScreenshotOnFailure(Scenario scenario) {
		try {
			if (driver != null && scenario.isFailed()) {
				//scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
				//scenario.attach(pngBytes, "image/png", "Bartholomew and the Bytes of the Oobleck");
				driver.manage().deleteAllCookies();
				driver.quit();
				driver = null;

			}

			if (driver != null) {
				Thread.sleep(2000);
				driver.manage().deleteAllCookies();
				driver.quit();
				driver = null;

			}

		} catch (Exception e) {
			System.out.println("Methods failed: tearDownAndScreenshotOnFailure, Exception: " + e.getMessage());
		}
	}
}

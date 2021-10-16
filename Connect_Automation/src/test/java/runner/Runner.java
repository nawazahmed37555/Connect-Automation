package runner;


import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.SQLConnector;


@CucumberOptions(
 	 features = "src/test/resources/features/",
 		 glue = "stepDefinitions",  
 		 monochrome = true,
 		 tags = "",
 		 plugin = {"pretty", "html:target/cucumber/report.html", "json:target/cucumber.json", "html:target/selenium-reports/selenium-reports.html"}
)
public class Runner extends AbstractTestNGCucumberTests {	 
	
	@BeforeSuite(alwaysRun = true)
	@AfterSuite(alwaysRun = true)
	public void clearDBBeforeTest() throws ClassNotFoundException, SQLException  {
		SQLConnector sqlConnector = new SQLConnector();
		sqlConnector.deleteDBrecords();	
	}
	
	
}
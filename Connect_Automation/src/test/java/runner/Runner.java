package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
 	 features = "src/test/resources/features/",
 		 glue = "stepDefinitions",  
 		 monochrome = true,
 		 tags = "",
 		 plugin = {"pretty", "html:target/cucumber/report.html", "json:target/cucumber.json", "html:target/selenium-reports/selenium-reports.html"}
)
public class Runner extends AbstractTestNGCucumberTests {	 
	
	
}
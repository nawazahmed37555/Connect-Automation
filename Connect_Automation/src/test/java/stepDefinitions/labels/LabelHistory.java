package stepDefinitions.labels;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.CommonPageLocators;
import pageObjects.connect.labels.LabelHistoryPageObjects;
import pageObjects.connect.labels.LabelsPageObjects;
import utils.DriverFactory;
import utils.SQLConnector;

public class LabelHistory extends DriverFactory {

	
	SQLConnector sqlConnector = new SQLConnector();
	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public LabelHistoryPageObjects labelHistoryPageObjects = PageFactory.initElements(driver, LabelHistoryPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);
	public LabelsPageObjects labelsPageObjects = PageFactory.initElements(driver, LabelsPageObjects.class);
	
	public String[] request_ID= new String[2];
	public String[] label_ID= new String[2];
	public String[] printerName=new String[2];
	public String[] labelFormatName= new String[2];
	public String[] company=new String[2];
	public String[] labelData=new String[2];
	public String[] printToPdfID=new String[2];
	
	public String parentWinHandle;

	@And("^User clicks on Label History and Reprint menu option$")
	public void userClicksOnLabelHistoryAndReprintMenuOption() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.menu_frame);
		commonPageLocators.menu_Label_History_Reprint.click();
		parentWinHandle = driver.getWindowHandle();
	}

	@When("^User selects status as \"([^\"]*)\"$")
	public void userSelectsStatusAs(String status)  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		Select status_drpdown = new Select(labelHistoryPageObjects.search_status);
		status_drpdown.selectByValue(status);
	}
	
	@And("^User clicks on Search button to search label printing history$")
	public void userClicksOnSearchButtonToSearchLabelPrintingHistory() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		labelHistoryPageObjects.searchBtn.click();
	}

	@Then("^Label printing history should be displayed$")
	public void labelPrintingHistoryShouldBeDisplayed() {
		Assert.assertTrue(driver.findElements(By.xpath("//*[@id='unique_id']/tbody/tr")).size()>1);
	}


	@When("^Run the SQL query to get the request_id\\[(\\d+)\\] of the latest printed label record from DB$")
	public void runTheSQLQueryToGetTheRequest_idOfTheLatestPrintedLabelRecordFromDB(int index) throws Throwable {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(sqlConnector.db_url,sqlConnector.db_username,sqlConnector.db_password);
		Statement stmt = con.createStatement();
		String getLatestRequestID = "select request_id  from con_service_requests_hs where status_code LIKE 'COMPLETED'order by request_id desc";
		ResultSet rs=stmt.executeQuery(getLatestRequestID);
		rs.next();
		request_ID[index]= rs.getString(1);
	}
	@And("^User enters label Request_id\\[(\\d+)\\] to search$")
	public void userEntersLabelRequest_idToSearch(int index)  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		labelHistoryPageObjects.search_requestId.clear();
		labelHistoryPageObjects.search_requestId.sendKeys(request_ID[index]);
	}

	@Then("^Printed label history with Request_id\\[(\\d+)\\] should be displayed$")
	public void printedLabelHistoryWithRequest_idShouldBeDisplayed(int index)  {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"unique_id\"]/tbody/tr[2]/td[3]")).getText().trim(),request_ID[index] );
	}

	@When("^User clicks on the checkbox to select the label history record$")
	public void userClicksOnTheCheckboxToSelectTheLabelHistoryRecord() {
		if(labelHistoryPageObjects.selectRow_checkbox.isSelected()!= true) {
			labelHistoryPageObjects.selectRow_checkbox.click();
		}
	}

	@And("^User selects \"([^\"]*)\" from the choose an action dropdown$")
	public void userSelectsFromTheChooseAnActionDropdown(String option)  {
		Select chooseAnAction_drpDown = new Select(labelHistoryPageObjects.choose_an_action);
		chooseAnAction_drpDown.selectByVisibleText(option);
	}

	@And("^User clicks on Go button to reprint label$")
	public void userClicksOnGoButtonToReprintLabel() {
		labelHistoryPageObjects.Go_Btn.click();
	}

	@And("^User disables Print to PDF option$")
	public void userDisablesPrintToPDFOption() {
		if(labelHistoryPageObjects.PrintToPdf_checkbox.isSelected()) {
			labelHistoryPageObjects.PrintToPdf_checkbox.click();
		}
	}


	@And("^User notes down all the label\\[(\\d+)\\] information$")
	public void userNotesDownAllTheLabelInformation(int index) throws Throwable {
		label_ID[index]=driver.findElement(By.xpath("//*[@id=\"unique_id\"]/tbody/tr[2]/td[8]")).getText().trim();
		printerName[index]=	driver.findElement(By.xpath("//*[@id=\"unique_id\"]/tbody/tr[2]/td[11]")).getText().trim();
		company[index]=	driver.findElement(By.xpath("//*[@id=\"unique_id\"]/tbody/tr[2]/td[10]")).getText().trim();
		labelFormatName[index]=basePage.getValueForColumn("Format Name");
	}


	@And("^User notes down the label\\[(\\d+)\\] data$")
	public void userNotesDownTheLabelData(int index)  {
		labelHistoryPageObjects.labelDataIcon.click();
		labelData[index] =labelHistoryPageObjects.labelDataPopup.getText();
	
	}

	@And("^User selects printer\\[(\\d+)\\] to reprint label$")
	public void userSelectsPrinterToReprintLabel(int index)  {
		Select printerDrpDown = new Select(labelHistoryPageObjects.Printer_drpdown);
		printerDrpDown.selectByVisibleText(printerName[index]);
	}

	@Then("^Verify that the label data is same in the actual and the reprinted labels$")
	public void verifyThatTheLabelDataIsSameInTheActualAndTheReprintedLabels(){
		Assert.assertEquals(labelData[1],labelData[0] );
	}

	@And("^User enables Print to PDF option$")
	public void userEnablesPrintToPDFOption(){
		if(labelHistoryPageObjects.PrintToPdf_checkbox.isSelected()!= true) {
			labelHistoryPageObjects.PrintToPdf_checkbox.click();
		}
	}

	@And("^PDF is opened in a new browser tab so user navigates back to the main window$")
	public void pdfIsOpenedInANewBrowserTabSoUserNavigatesBackToTheMainWindow()  {
		
		driver.switchTo().window(parentWinHandle);
	}

	@When("^Run the SQL query to get the printToPdfID\\[(\\d+)\\] of the latest printed label record from DB$")
	public void runTheSQLQueryToGetThePrintToPdfIDOfTheLatestPrintedLabelRecordFromDB(int index) throws ClassNotFoundException, SQLException  {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(sqlConnector.db_url,sqlConnector.db_username,sqlConnector.db_password);
		Statement stmt = con.createStatement();
		String getLatestPrintToPdfID = "select web_label_pdf_id  from con_web_labels order by creation_date desc FETCH FIRST 1 ROWS ONLY";
		ResultSet rs=stmt.executeQuery(getLatestPrintToPdfID);
		rs.next();
		printToPdfID[index]= rs.getString(1);
	}

	@And("^User enters printToPdfID\\[(\\d+)\\] to search label printing history$")
	public void userEntersPrintToPdfIDToSearchLabelPrintingHistory(int index) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		labelHistoryPageObjects.clearBtn.click();
		labelHistoryPageObjects.search_pdfId.sendKeys(printToPdfID[index]);
		Thread.sleep(10000);
	}

	@When("^User enters label format name\\[(\\d+)\\]  to search$")
	public void userEntersLabelFormatNameToSearch(int index)  {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(commonPageLocators.body_frame);
		labelsPageObjects.search_formatName.clear();
		labelsPageObjects.search_formatName.sendKeys(labelFormatName[index]);
	}

	@Then("^Should display an error message that the label format is disabled$")
	public void shouldDisplayAnErrorMessageThatTheLabelFormatIsDisabled(){
		String alertText = driver.switchTo().alert().getText();
		Assert.assertTrue(alertText.contains("Service message: Label format is disabled:"));
		driver.switchTo().alert().accept();
	}




}

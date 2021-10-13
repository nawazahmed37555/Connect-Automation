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
	import pageObjects.connect.devices.PrintersPageObjects;
	import utils.DriverFactory;

	public class ManagePrinters extends DriverFactory {
		
		//Test data
		public String[] printer_name = {"Automated_printer1","Automated_printer2"};
		public String[] hostIP = {"192.168.0.85","192.168.0.86"};
		public String[] port = {"4400","4401"};
		
		public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
		public PrintersPageObjects printersPageObjects = PageFactory.initElements(driver, PrintersPageObjects.class);
		public BasePage basePage = PageFactory.initElements(driver, BasePage.class);
		
		
		@And("^User clicks on Printers menu option$")
		public void userClicksOnPrintersMenuOption() {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(commonPageLocators.menu_frame);
			commonPageLocators.menu_Devices_Printers.click();
			
		}

		@And("^User clicks on Add button to add Printer$")
		public void userClicksOnAddButtonToAddPrinter()  {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(commonPageLocators.body_frame);
			printersPageObjects.addBtn.click();
		}
		
		@And("^User Enters Printer_name\\[(\\d+)\\] on add Printer panel$")
		public void userEntersPrinter_nameOnAddPrinterPanel(int index)  {
			printersPageObjects.edit_printerName.clear();
			printersPageObjects.edit_printerName.sendKeys(printer_name[index]);
		}

		@And("^User Enters Host_IP\\[(\\d+)\\] on add Printer panel$")
		public void userEntersHost_IPOnAddPrinterPanel(int index) {
			printersPageObjects.edit_host.clear();
			printersPageObjects.edit_host.sendKeys(hostIP[index]);
		}

		@And("^User Enters Port_number\\[(\\d+)\\] on add Printer panel$")
		public void userEntersPort_numberOnAddPrinterPanel(int index) {
			printersPageObjects.edit_port.clear();
			printersPageObjects.edit_port.sendKeys(port[index]);
		}
		

		@And("^User selects device_driver\\[(\\d+)\\]  on add Printer panel$")
		public void userSelectsDevice_driverOnAddPrinterPanel(int index) {
			Select deviceDriver_dropDown = new Select(printersPageObjects.edit_drpDown_deviceDriver);
			deviceDriver_dropDown.selectByIndex(index);
		}


		@And("^User selects company\\[(\\d+)\\]  on add Printer panel$")
		public void userSelectsCompanyOnAddPrinterPanel(int index) {
			Select company_drpDown = new Select (printersPageObjects.edit_drpDown_company);
			company_drpDown.selectByIndex(index);
		}
		@And("^User selects communication_method\\[(\\d+)\\] on add Printer panel$")
		public void userSelectsCommunication_methodOnAddPrinterPanel(int index)  {
			Select communicationMethod_drpDown = new Select (printersPageObjects.edit_drpDown_communicationMethod);
			communicationMethod_drpDown.selectByIndex(index);
		}

		@And("^User selects DPI\\[(\\d+)\\] on add Printer Panel$")
		public void userSelectsDPIOnAddPrinterPanel(int index)  {
			Select DPI_drpDown = new Select (printersPageObjects.edit_drpDown_dpi);
			DPI_drpDown.selectByIndex(index);
		
		}
		@And("^User clicks on Save button to add Printer$")
		public void userClicksOnSaveButtonToAddPrinter()  {
			printersPageObjects.saveBtn.click();
		}

		@Then("^Verify Printer is created successfully$")
		public void verifyPrinterIsCreatedSuccessfully() {
			
			 Assert.assertEquals(printersPageObjects.searchResults_printerName.getText().trim(), printer_name[0]);
				
		}
		@And("^User enters Printer_name\\[(\\d+)\\] to search a Printer$")
		public void userEntersPrinter_nameToSearchAPrinter(int index) throws Throwable {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(commonPageLocators.body_frame);
			printersPageObjects.search_printer_name.clear();
			printersPageObjects.search_printer_name.sendKeys(printer_name[index]);
		}

	

		@And("^User clicks on Search button to search Printer$")
		public void userClicksOnSearchButtonToSearchPrinter() {
			printersPageObjects.searchBtn.click();
		}


		@Then("^Printer\\[(\\d+)\\] should be displayed in search results$")
		public void printerShouldBeDisplayedInSearchResults(int index ) {
			Assert.assertEquals(printersPageObjects.searchResults_printerName.getText().trim(), printer_name[index]);
		}

		
		@When("^User clicks on Edit option to edit Printer$")
		public void userClicksOnEditOptionToEditPrinter() throws Throwable {
			printersPageObjects.contextMenuBtn.click();
			printersPageObjects.contextMenu_Edit_Btn.click();
		}

		@And("^User clicks on Save button to save Printer details$")
		public void userClicksOnSaveButtonToSavePrinterDetails() {
			printersPageObjects.saveBtn.click();
		}

		@Then("^Verify Printer details updated successfully$")
		public void verifyPrinterDetailsUpdatedSuccessfully() {
			Assert.assertEquals(printersPageObjects.edit_printerName.getAttribute("value"), printer_name[1]);
			Assert.assertEquals(printersPageObjects.edit_host.getAttribute("value"), hostIP[1]);
			Assert.assertEquals(printersPageObjects.edit_port.getAttribute("value"), port[1]);
		}

		@And("^User clicks on Search button to search Printers$")
		public void userClicksOnSearchButtonToSearchPrinters() {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(commonPageLocators.body_frame);
			printersPageObjects.searchBtn.click();
		}

		@Then("^All Printers should be displayed in search results$")
		public void allPrintersShouldBeDisplayedInSearchResults()  {
			Assert.assertTrue(driver.findElements(By.xpath("//*[@id='unique_id']/tbody/tr")).size()>1);
			
		}

		@When("^User clicks on checkbox to select all Printers under search results$")
		public void userClicksOnCheckboxToSelectAllPrintersUnderSearchResults()  {
			printersPageObjects.selectAll_checkbox.click();
		}

		@And("^User clicks on Choose an Action drop down on Printers page$")
		public void userClicksOnChooseAnActionDropDownOnPrintersPage() {
			printersPageObjects.choose_an_action.click();
			 
		}

		@And("^User selects Export as XML on Printers page$")
		public void userSelectsExportAsXMLOnPrintersPage() {
			Select chooseAnAction_drpDown = new Select(printersPageObjects.choose_an_action);
			chooseAnAction_drpDown.selectByVisibleText("Export as XML");
			
		}

		@And("^User clicks on Go button on Printers page$")
		public void userClicksOnGoButtonOnPrintersPage()  {
			printersPageObjects.Go_Btn.click();
		}

		@Then("^Verify that the Printer records xml file was successfully downloaded$")
		public void verifyThatThePrinterRecordsXmlFileWasSuccessfullyDownloaded() throws InterruptedException {
			//Dates starting with 0(for ex :01-01-2021) needs to be stripped to match the fileName
					String currentDate = basePage.getCURRENTDate_initialZeroStripped("M-d-yyyy");
					String FileName = "printer_export_"+currentDate+".xml";
					Assert.assertEquals(basePage.isFileDownloaded("C:\\Users\\admin\\Downloads", FileName, 20),true);
				}

		@When("^User clicks on Delete option to delete Printer$")
		public void userClicksOnDeleteOptionToDeletePrinter() {
			printersPageObjects.contextMenuBtn.click();
			printersPageObjects.contextMenu_Delete_Btn.click();
		}

		@Then("^Verify Printer deleted successfully$")
		public void verifyPrinterDeletedSuccessfully()  {
					//Assert.assertEquals(driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td")).getText(), "No results Found");
					String actualText = driver.findElement(By.xpath("//*[@id='unique_id']/tbody/tr[2]/td")).getText();
					Assert.assertTrue(actualText.equalsIgnoreCase("No Results Found"));
		}

	
		

	

	
	}


package pageObjects;

import java.awt.AWTException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import utils.DriverFactory;

public class BasePage extends DriverFactory {
	protected WebDriverWait wait;
	protected JavascriptExecutor jsExecutor;

	// Get the current window handle
	String parentWinHandle = driver.getWindowHandle();

	@SuppressWarnings("deprecation")
	public BasePage() throws IOException {
		this.wait = new WebDriverWait(driver, 15);
		jsExecutor = ((JavascriptExecutor) driver);
	}

	/**********************************************************************************
	 ** CLICK METHODS
	 **********************************************************************************/
	public void waitAndClickElement(WebElement element) throws InterruptedException {
		boolean clicked = false;
		int attempts = 0;
		while (!clicked && attempts < 10) {
			try {
				this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
				System.out.println("Successfully clicked on the WebElement: " + "<" + element.toString() + ">");
				clicked = true;
			} catch (Exception e) {
				System.out.println("Unable to wait and click on WebElement, Exception: " + e.getMessage());
				Assert.fail(
						"Unable to wait and click on the WebElement, using locator: " + "<" + element.toString() + ">");
			}
			attempts++;
		}
	}

	public void waitAndClickElementsUsingByLocator(By by) throws InterruptedException {
		boolean clicked = false;
		int attempts = 0;
		while (!clicked && attempts < 10) {
			try {
				this.wait.until(ExpectedConditions.elementToBeClickable(by)).click();
				System.out
						.println("Successfully clicked on the element using by locator: " + "<" + by.toString() + ">");
				clicked = true;
			} catch (Exception e) {
				System.out.println(
						"Unable to wait and click on the element using the By locator, Exception: " + e.getMessage());
				Assert.fail("Unable to wait and click on the element using the By locator, element: " + "<"
						+ by.toString() + ">");
			}
			attempts++;
		}
	}

	public void clickOnTextFromDropdownList(WebElement list, String textToSearchFor) throws Exception {
		@SuppressWarnings("deprecation")
		Wait<WebDriver> tempWait = new WebDriverWait(driver, 30);
		try {
			tempWait.until(ExpectedConditions.elementToBeClickable(list)).click();
			list.sendKeys(textToSearchFor);
			list.sendKeys(Keys.ENTER);
			System.out.println("Successfully sent the following keys: " + textToSearchFor
					+ ", to the following WebElement: " + "<" + list.toString() + ">");
		} catch (Exception e) {
			System.out.println("Unable to send the following keys: " + textToSearchFor
					+ ", to the following WebElement: " + "<" + list.toString() + ">");
			Assert.fail("Unable to select the required text from the dropdown menu, Exception: " + e.getMessage());
		}
	}
	public String getSelectedOptionText(WebElement Dropdown ) {
		Select drpdown = new Select(Dropdown);
		return drpdown.getFirstSelectedOption().getText();
	}

	public void clickOnElementUsingCustomTimeout(WebElement locator, WebDriver driver, int timeout) {
		try {
			@SuppressWarnings("deprecation")
			final WebDriverWait customWait = new WebDriverWait(driver, timeout);
			customWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
			locator.click();
			System.out.println("Successfully clicked on the WebElement, using locator: " + "<" + locator + ">"
					+ ", using a custom Timeout of: " + timeout);
		} catch (Exception e) {
			System.out.println("Unable to click on the WebElement, using locator: " + "<" + locator + ">"
					+ ", using a custom Timeout of: " + timeout);
			Assert.fail("Unable to click on the WebElement, Exception: " + e.getMessage());
		}
	}

	/**********************************************************************************
	 ** ACTION METHODS
	 **********************************************************************************/

	public void actionMoveAndClick(WebElement element) throws Exception {
		Actions ob = new Actions(driver);
		try {
			this.wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
			ob.moveToElement(element).click().build().perform();
			System.out.println("Successfully Action Moved and Clicked on the WebElement, using locator: " + "<"
					+ element.toString() + ">");
		} catch (StaleElementReferenceException elementUpdated) {
			WebElement elementToClick = element;
			Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(elementToClick)).isEnabled();
			if (elementPresent == true) {
				ob.moveToElement(elementToClick).click().build().perform();
				System.out.println(
						"(Stale Exception) - Successfully Action Moved and Clicked on the WebElement, using locator: "
								+ "<" + element.toString() + ">");
			}
		} catch (Exception e) {
			System.out.println("Unable to Action Move and Click on the WebElement, using locator: " + "<"
					+ element.toString() + ">");
			Assert.fail("Unable to Action Move and Click on the WebElement, Exception: " + e.getMessage());
		}
	}

	public void actionMoveAndClickByLocator(By element) throws Exception {
		Actions ob = new Actions(driver);
		try {
			Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
			if (elementPresent == true) {
				WebElement elementToClick = driver.findElement(element);
				ob.moveToElement(elementToClick).click().build().perform();
				System.out.println("Action moved and clicked on the following element, using By locator: " + "<"
						+ element.toString() + ">");
			}
		} catch (StaleElementReferenceException elementUpdated) {
			WebElement elementToClick = driver.findElement(element);
			ob.moveToElement(elementToClick).click().build().perform();
			System.out
					.println("(Stale Exception) - Action moved and clicked on the following element, using By locator: "
							+ "<" + element.toString() + ">");
		} catch (Exception e) {
			System.out.println("Unable to Action Move and Click on the WebElement using by locator: " + "<"
					+ element.toString() + ">");
			Assert.fail(
					"Unable to Action Move and Click on the WebElement using by locator, Exception: " + e.getMessage());
		}
	}

	/**********************************************************************************
	 ** SEND KEYS METHODS /
	 **********************************************************************************/
	public void sendKeysToWebElement(WebElement element, String textToSend) throws Exception {
		try {
			this.WaitUntilWebElementIsVisible(element);
			element.clear();
			element.sendKeys(textToSend);
			System.out.println("Successfully Sent the following keys: '" + textToSend + "' to element: " + "<"
					+ element.toString() + ">");
		} catch (Exception e) {
			System.out.println("Unable to locate WebElement: " + "<" + element.toString()
					+ "> and send the following keys: " + textToSend);
			Assert.fail("Unable to send keys to WebElement, Exception: " + e.getMessage());
		}
	}

	/**********************************************************************************
	 ** JS METHODS & JS SCROLL
	 **********************************************************************************/
	public void scrollToElementByWebElementLocator(WebElement element) {
		try {
			this.wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -400)");
			System.out.println(
					"Succesfully scrolled to the WebElement, using locator: " + "<" + element.toString() + ">");
		} catch (Exception e) {
			System.out.println("Unable to scroll to the WebElement, using locator: " + "<" + element.toString() + ">");
			Assert.fail("Unable to scroll to the WebElement, Exception: " + e.getMessage());
		}
	}

	public void jsPageScroll(int numb1, int numb2) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("scroll(" + numb1 + "," + numb2 + ")");
			System.out.println("Succesfully scrolled to the correct position! using locators: " + numb1 + ", " + numb2);
		} catch (Exception e) {
			System.out
					.println("Unable to scroll to element using locators: " + "<" + numb1 + "> " + " <" + numb2 + ">");
			Assert.fail("Unable to manually scroll to WebElement, Exception: " + e.getMessage());
		}
	}

	public void waitAndclickElementUsingJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			js.executeScript("arguments[0].click();", element);
			System.out
					.println("Successfully JS clicked on the following WebElement: " + "<" + element.toString() + ">");
		} catch (StaleElementReferenceException elementUpdated) {
			WebElement staleElement = element;
			Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(staleElement)).isEnabled();
			if (elementPresent == true) {
				js.executeScript("arguments[0].click();", elementPresent);
				System.out.println("(Stale Exception) Successfully JS clicked on the following WebElement: " + "<"
						+ element.toString() + ">");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Unable to JS click on the following WebElement: " + "<" + element.toString() + ">");
			Assert.fail("Unable to JS click on the WebElement, Exception: " + e.getMessage());
		}
	}

	public void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	/**********************************************************************************
	 ** WAIT METHODS
	 **********************************************************************************/
	public boolean WaitUntilWebElementIsVisible(WebElement element) {
		try {
			this.wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("WebElement is visible using locator: " + "<" + element.toString() + ">");
			Thread.sleep(200);
			return true;
		} catch (Exception e) {
			System.out.println("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
			Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
			return false;
		}
	}

	public boolean WaitUntilWebElementIsVisibleUsingByLocator(By element) {
		try {
			this.wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			System.out.println("Element is visible using By locator: " + "<" + element.toString() + ">");
			return true;
		} catch (Exception e) {
			System.out.println("WebElement is NOT visible, using By locator: " + "<" + element.toString() + ">");
			Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
			return false;
		}
	}

	public boolean isElementClickable(WebElement element) {
		try {
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			System.out.println("WebElement is clickable using locator: " + "<" + element.toString() + ">");
			return true;
		} catch (Exception e) {
			System.out.println("WebElement is NOT clickable using locator: " + "<" + element.toString() + ">");
			return false;
		}
	}

	public boolean waitUntilPreLoadElementDissapears(By element) {
		try {
			this.wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
			System.out.println("WebElement is visible using locator: " + "<" + element.toString() + ">");
			return true;
		} catch (Exception e) {
			System.out.println("WebElement is NOT visible using locator: " + "<" + element.toString() + ">");
			return false;
		}
	}

	public boolean waitUntilElementDissapears(WebElement element) {
		try {
			this.wait.until(ExpectedConditions.invisibilityOf(element));
			System.out.println("WebElement is invisible using locator: " + "<" + element.toString() + ">");
			return true;
		} catch (Exception e) {
			System.out.println("WebElement is NOT invisible using locator: " + "<" + element.toString() + ">");
			return false;
		}

	}

	public boolean waitForTextToBePresentInElement(WebElement element, String text) {
		try {
			this.wait.until(ExpectedConditions.textToBePresentInElement(element, text));
			System.out.println("Text is present in element using locator: " + "<" + element.toString() + ">");
			return true;
		} catch (Exception e) {
			System.out.println("Text is not present in element using locator: " + "<" + element.toString() + ">");
			return false;
		}

	}

	/**********************************************************************************
	 ** PAGE METHODS
	 **********************************************************************************/
	public BasePage loadUrl(String url) throws Exception {
		driver.get(url);
		return new BasePage();
	}

	public String getCurrentURL() {
		try {
			String url = driver.getCurrentUrl();
			System.out.println("Found(Got) the following URL: " + url);
			return url;
		} catch (Exception e) {
			System.out.println("Unable to locate (Get) the current URL, Exception: " + e.getMessage());
			return e.getMessage();
		}
	}

	public String waitForSpecificPage(String urlToWaitFor) {
		try {
			String url = driver.getCurrentUrl();
			this.wait.until(ExpectedConditions.urlMatches(urlToWaitFor));
			System.out.println("The current URL was: " + url + ", " + "navigated and waited for the following URL: "
					+ urlToWaitFor);
			return urlToWaitFor;
		} catch (Exception e) {
			System.out.println("Exception! waiting for the URL: " + urlToWaitFor + ",  Exception: " + e.getMessage());
			return e.getMessage();
		}
	}

	/**********************************************************************************
	 ** ALERT & POPUPS METHODS
	 **********************************************************************************/
	public void closePopups(By locator) throws InterruptedException {
		try {
			List<WebElement> elements = this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			for (WebElement element : elements) {
				if (element.isDisplayed()) {
					element.click();
					this.wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
					System.out.println("The popup has been closed Successfully!");
				}
			}
		} catch (Exception e) {
			System.out.println("Exception! - could not close the popup!, Exception: " + e.toString());
			throw (e);
		}
	}

	public boolean checkPopupIsVisible() {
		try {
			@SuppressWarnings("unused")
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			System.out.println("A popup has been found!");
			return true;
		} catch (Exception e) {
			System.err.println("Error came while waiting for the alert popup to appear. " + e.getMessage());
		}
		return false;
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void closeAlertPopupBox() throws AWTException, InterruptedException {
		try {
			Alert alert = this.wait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
		} catch (UnhandledAlertException f) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			System.out.println("Unable to close the popup");
			Assert.fail("Unable to close the popup, Exception: " + e.getMessage());
		}
	}

	/**********************************************************************************
	 ** GET ATTRIBUTE OF AN ELEMENT
	 *********************************************************************************/
	public String getElementText(WebElement element) throws InterruptedException {
		this.WaitUntilWebElementIsVisible(element);
		return element.getText();

	}



	
	public List<String> selectAllDropDownOptions(WebElement element, List<String> selectedOptions) {
		Select drpDown = new Select(element);
		List<WebElement> options = drpDown.getOptions();
		
		if(options.size()>0) {
				
			for ( WebElement option : options){
				drpDown.selectByVisibleText(option.getText());
				selectedOptions.add(option.getText());//Store selected option name
			}
		}
		else {
			 Assert.fail("There are no options to select in the Dropdown " + element.getAttribute("name"));
		}
		return selectedOptions;
	}
	public List<String> selectDropDownOption(WebElement element, String optionToselect, List<String> selectedOptions) {
		Select drpDown = new Select(element);
		List<WebElement> options = drpDown.getOptions();
		
		if(options.size()>0) {
				
			drpDown.selectByVisibleText(optionToselect);	
			selectedOptions.add(optionToselect);
			
				
		}
		else {
			Assert.fail("The option "+ optionToselect+" is unavailable in the Dropdown " + element.getAttribute("name"));
		}
		return selectedOptions;
	
	}
	public List<String> selectDropDownOptionByIndex(WebElement element, int index, List<String> selectedOptions) {
		Select drpDown = new Select(element);
		List<WebElement> options = drpDown.getOptions();
		
		if(options.size()>index) {
				
			drpDown.selectByIndex(index);
			WebElement selectedOption = options.get(index);
			selectedOptions.add(selectedOption.getText());
			}
		else {
			Assert.fail("The option "+ options.get(index).toString() +" is unavailable in the Dropdown " + element.getAttribute("name"));
		}
		return selectedOptions;
	
	}
	
public void deSelectAllDropDownOptions(WebElement element) {
		
		Select drpDown = new Select(element);
		List<WebElement> options = drpDown.getOptions();
					
		if(options.size()>0) {
				for(WebElement option : options) {
					drpDown.deselectByValue(option.getText());
					}
			}
			
		else {
			System.out.println("There are no options available to Deselect in the dropdown " + element.getAttribute("name") );
		}
	}
	public void deSelectDropDownOption(WebElement element, String option) {
		
		Select drpDown = new Select(element);
		List<WebElement> options = drpDown.getOptions();
					
		if(options.size()>0) {
				
					drpDown.deselectByValue(option);
			}
			
		else {
			System.out.println("There are no options available to Deselect in the dropdown " + element.getAttribute("name") );
		}
	}
	public boolean compareDropdownoptions (WebElement element, List<String> selectedOptions ) {
		Select drpDown = new Select(element);
		List<WebElement> options = drpDown.getOptions();
		 int flag=0;
		
		for (String selectedOption : selectedOptions) {
			
			for (WebElement dropDown_option : options) {
				if(selectedOption.equals(dropDown_option.getText()) ) {
					flag =1;
					break;
					
				}
				else {
					flag=0;
					continue;
				}
				
			}
			if(flag==0) {
				System.out.println(selectedOption + " option is not available in the dropdown" + element);
				return false;
			}
		}
		return true;
		
	}
	/**********************************************************************************
	 ** GET NUMBER OF RECORDS FROM CSV, XLS OR XLSX FILE
	 * 
	 * @throws CsvException
	 * @throws IOException
	 *********************************************************************************/
	public int getNumberOfRowsInASpreadsheet(String path) throws IOException, CsvException {
		// This will load csv file
		CSVReader reader = new CSVReader(new FileReader(path));

		// this will load content into list
		List<String[]> li = reader.readAll();
		return li.size();
	}

	/**********************************************************************************
	 ** SWITCH WINDOW
	 *********************************************************************************/
	public void switchWindow() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	/**********************************************************************************
	 ** GET DATE (MM/DD/YYYY)
	 *********************************************************************************/
	public String currentDate() {

		DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		df.withZone(ZoneId.of("America/Anchorage"));
		LocalDate now = LocalDate.now();
		return df.format(now);

	}

	/**********************************************************************************
	 ** Assert that an element is not Visible
	 *********************************************************************************/
	public boolean isElementVisible(String locator) {

		try {
			driver.findElement(By.xpath(locator)).isDisplayed();
			return true;
		} catch (NoSuchElementException NSE) {
			return false;

		}
	}

	/**********************************************************************************
	 ** Assert that file download is successful - This is for file download
	 * 
	 * @throws InterruptedException
	 *********************************************************************************/
	public boolean isFileDownloaded(String downloadPath, String fileName, int waitTime) throws InterruptedException {

		
		// Specifies the download directory
		File dir = new File(downloadPath);

		// Waits for a certain time to download the file.
		
		for (int j = 0; j < waitTime ; j++) {
			File[] dirContents = dir.listFiles();
					for (int i = 0; i < dirContents.length; i++) {
					
						if (dirContents[i].getName().equals(fileName)) {
							if(dirContents[i].length()>0) {
							return true;
							}
							else {
								Assert.assertFalse(dirContents[i].getName()+ " File size is 0 Bytes.", dirContents[i].length()==0);
								
							}
						}
						
					}
					
					Thread.sleep(1000); // Wait to allow file to be fully downloaded and retry
					
			}
		System.out.println("File download failed");
		return false;

	}
public void  deleteFileFromDirectory(String filePath, String fileName)  {

		
		// Specifies the directory
		File dir = new File(filePath);
int count=0;
				File[] dirContents = dir.listFiles();
					for (int i = 0; i < dirContents.length; i++) {
					
						if (dirContents[i].getName().contains(fileName)) {
							dirContents[i].delete();
							count++;
						}
							
					}
					System.out.println("Total # number of copies deleted for the filename("+fileName+") is "+count);
	}

	/**********************************************************************************
	 ** Assert that file download is successful - This is for Dynamic file download
	 * 
	 * @throws InterruptedException
	 *********************************************************************************/
	public boolean isFileDownloadedWithDynamicFilename(String downloadPath, String fileName)
			throws InterruptedException {

		// Little wait to allow file to be fully downloaded
		Thread.sleep(500);

		// Specifies the download directory
		File dir = new File(downloadPath);

		// Specifies the directory contents as array
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().contains(fileName)) {
				System.out.println("File download successful");
				dirContents[i].delete();
				return true;
			}
		}
		System.out.println("File download failed");
		return false;

	}

	/**********************************************************************************
	 ** Get Last Month
	 *********************************************************************************/
	public String getLastMonthInRange() {
		
		LocalDate currentDate = LocalDate.now();
		
		String lastMonth = "";
		Month currentMonth = currentDate.getMonth();
		
		switch (currentMonth.toString().toLowerCase()) {
		
				case "january" :
				    lastMonth = "12/01/2019 to 12/31/2019";
				    break;
				case "february" :
					lastMonth =  "01/01/2020 to 01/31/2020";
					break;
				case "march" :
					lastMonth =  "02/01/2020 to 02/28/2020";
					break;
				case "april" :
					lastMonth =  "03/01/2020 to 03/31/2020";
					break;
				case "may" :
					lastMonth =  "04/01/2020 to 04/30/2020";
					break;
				case "june" :
					lastMonth =  "05/01/2020 to 05/31/2020";
					break;
				case "july" :
					lastMonth = "06/01/2020 to 06/30/2020";
					break;
				case "august" :
					lastMonth =  "07/01/2020 to 07/31/2020";
					break;
				case "september" :
					lastMonth =  "08/01/2020 to 08/31/2020";
					break;
				case "october" :
					lastMonth =  "09/01/2020 to 09/30/2020";
					break;
				case "November" :
					lastMonth = "10/01/2020 to 10/31/2020";
					break;
				case "December" :
					lastMonth =  "11/01/2020 to 11/30/2020";
					break;
		}
		
		return lastMonth;

	}
	
	/**********************************************************************************
	 ** GET NUMBER OF ELEMENTs
	 *********************************************************************************/
	public int getNumberOfElements(String element) throws InterruptedException {
		return driver.findElements(By.xpath(element)).size();

	}

	public int getNumberOfElements(WebElement element) {
		return driver.findElements(By.xpath(element.toString())).size();
	}
	
	/**********************************************************************************
	 ** GET GMT DATE
	 *********************************************************************************/	
	
	public String getGMTDate() {
		//capturing today's date
        Date today = new Date();
    
        //dispalying date on CDT timezone
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        df.setTimeZone(TimeZone.getTimeZone("Europe/Copenhagen"));
        String GMT = df.format(today);
        return GMT;	
	}
	
	/**********************************************************************************
	 ** GET CURRENT DATE
	 *********************************************************************************/	
	
	public String getCURRENTDate() {
		//capturing today's date
        Date today = new Date();
    
        //dispalying date on CDT timezone
        DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
//        df.setTimeZone(TimeZone.getTimeZone("Europe/Copenhagen"));
        String currentDate = df.format(today);
        return currentDate;	
	}
	
	public String getCURRENTDate(String Date_format) {
		//capturing today's date
        Date today = new Date();
        DateFormat df = new SimpleDateFormat(Date_format);
     
      //df.setTimeZone(TimeZone.getTimeZone("Europe/Copenhagen"));
           
        String currentDate = df.format(today);
        return currentDate;	
	}
	public String getCURRENTDate_initialZeroStripped(String Date_format) {
		//capturing today's date
        Date today = new Date();
        DateFormat df = new SimpleDateFormat(Date_format);
     
        df.setTimeZone(TimeZone.getTimeZone("CST"));
        String currentDate = df.format(today);
        return currentDate;	
	}
	
	/**********************************************************************************
	 ** GET ElEMENT LOCATOR FROM WEBELEMENT
	 *********************************************************************************/	
	
	public String getElementLocator(WebElement element) {
		
		// First character of an xpath
		int firstLocatorCharInIdex = element.toString().indexOf("/");
		
		// last character of an xpath
		int lastLocatorCharIndex = element.toString().lastIndexOf("]");
		
		return element.toString().substring(firstLocatorCharInIdex, lastLocatorCharIndex);
		
	}

	/**********************************************************************************
	 ** GENERATE RANDOM NUMBER
	 *********************************************************************************/	
	
	public int getRandomNumber() {
		// Create an instance of Random Class 
		Random rand = new Random();
		
		// Generate Random integers in range 8 to 999
		int randNumber = rand.nextInt(1000);
		
	  return randNumber;
		
	}

	/**********************************************************************************
	 ** CLICK ELEMENT AT A PARTICULAR OFFSET
	 * @return 
	 *********************************************************************************/	
	//The value of the divisor is used to divide the width of the element to get the point to click
	public void clickElementAtOffSet(WebElement element) {
		
		int width = element.getSize().width;
		
		Actions action = new Actions(driver);
		
		action.moveToElement(element).moveByOffset((width/2)-2, 0).click().perform();
		
	}

	/**********************************************************************************
	 ** GET COLOR
	 *********************************************************************************/	
	public String getColor(String colorRGBA) {
		String[] hexValue = colorRGBA.replace("rgba(", "").replace(")", "").split(",");
		int hexValue1 = Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		int hexValue2 = Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		int hexValue3 = Integer.parseInt(hexValue[2]);
		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		return actualColor;
	}
	
}

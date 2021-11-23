package pageObjects.connect.setup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CachePageObjects {

public @FindBy (name= "deleteCacheButton") WebElement deleteCacheButton;
public @FindBy (name= "printCacheButton") WebElement printCacheButton;
public @FindBy (name= "viewCacheButton") WebElement viewCacheButton;

public @FindBy (xpath= "/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]") WebElement cacheName;
public @FindBy (xpath= "/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[5]") WebElement cacheSize;

public @FindBy (name= "closeButton") WebElement closeButton;

}

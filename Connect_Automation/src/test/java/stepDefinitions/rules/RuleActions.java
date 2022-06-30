package stepDefinitions.rules;

import org.openqa.selenium.support.PageFactory;

import pageObjects.BasePage;
import pageObjects.CommonPageLocators;
import pageObjects.connect.rules.RuleActionsPageObjects;
import utils.DriverFactory;

public class RuleActions extends DriverFactory{
	public CommonPageLocators commonPageLocators = PageFactory.initElements(driver, CommonPageLocators.class);
	public RuleActionsPageObjects ruleActionsPageObjects = PageFactory.initElements(driver, RuleActionsPageObjects.class);
	public BasePage basePage = PageFactory.initElements(driver, BasePage.class);
	
	
}

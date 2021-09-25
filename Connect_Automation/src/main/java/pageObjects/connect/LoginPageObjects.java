package pageObjects.connect;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class LoginPageObjects extends BasePage {


public LoginPageObjects() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
public @FindBy (name= "j_username") WebElement Username_txtF;
public @FindBy (name= "j_password") WebElement Password_txtF;
//public @FindBy (xpath = "//*[@id='loginDiv']/input") WebElement LogIn_btn;
public @FindBy (name = "btnLogin") WebElement LogIn_btn;

}

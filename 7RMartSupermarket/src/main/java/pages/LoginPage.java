package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name = "username") WebElement uname; //@FindBy - Annotation provided by PageFactort for locating web elements
	@FindBy(name = "password") WebElement pwd;
	@FindBy(xpath = "//button[text() = 'Sign In']") WebElement signin;
	@FindBy(xpath = "//p[text() = 'Dashboard']") WebElement dashBoard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") WebElement alertBox;
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); //PageFactory - To initialise web elements
	}
	
	public void enterUserName(String username) {
		uname.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		pwd.sendKeys(password);
	}
	
	public void clickSignIn() {
		signin.click();
	}
	
	//For validating the login success 
	public boolean validateHome() {
		return dashBoard.isDisplayed();
		
	}
	
	//For validating the alert popup showing for invalid cases
	public Boolean alertValidation() {
		return alertBox.isDisplayed();
	}
	
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	@FindBy(xpath = "//a[@class = 'nav-link' and @data-toggle='dropdown']") WebElement adminClick;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']") WebElement logout;
	@FindBy(xpath = "//button[text() = 'Sign In']") WebElement signin;
	
	public WebDriver driver;
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); //PageFactory - To initialise web elements
	}
	
	public void clickAdminButtonInHomePage() {
		adminClick.click();
	}
	
	public void clickLogoutButton() {
		logout.click();
	}
	
	public boolean validateLoginPage() {
		return signin.isDisplayed();
	}
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage {
	
	//@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement moreInfoForAdminUsers;
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement newActionBtnAdminUsers;
	@FindBy(id = "username") WebElement usernameFieldAdminUsers;
	@FindBy(id = "password") WebElement passwordFieldAdminUsers;
	@FindBy(id = "user_type") WebElement userTypeFieldAdminUsers;
	@FindBy(xpath = "//button[@name='Create']") WebElement saveBtnAdminUsers;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alertUserCreatedSuccess;
	
	public WebDriver driver;
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	/*public void clickMoreInfoForAdminUsers() {
		moreInfoForAdminUsers.click();
	}*/
	public AdminUsersPage clickNewActionBtnForAdminUsers() {
		newActionBtnAdminUsers.click();
		return this;
	}
	public AdminUsersPage enterUsernameInAdminUsersInformations(String username) {
		usernameFieldAdminUsers.sendKeys(username);
		return this;
	}
	public AdminUsersPage enterPasswordInAdminUsersInformations(String password) {
		passwordFieldAdminUsers.sendKeys(password);
		return this;
	}
	public AdminUsersPage selectUserTypeInAdminUsersInformations(String value) {
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectByValue(userTypeFieldAdminUsers, value);
		return this;
	}
	public AdminUsersPage clickSaveBtnInAdminUsers() {
		saveBtnAdminUsers.click();
		return this;
	}
	public boolean alertValidation() {
		return alertUserCreatedSuccess.isDisplayed();
	}
}

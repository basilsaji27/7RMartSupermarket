package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage {
	
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement moreInfoForAdminUsers;
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
	public void clickMoreInfoForAdminUsers() {
		moreInfoForAdminUsers.click();
	}
	public void clickNewActionBtnForAdminUsers() {
		newActionBtnAdminUsers.click();
	}
	public void enterUsernameInAdminUsersInformations(String username) {
		usernameFieldAdminUsers.sendKeys(username);
	}
	public void enterPasswordInAdminUsersInformations(String password) {
		passwordFieldAdminUsers.sendKeys(password);
	}
	public void selectUserTypeInAdminUsersInformations(String value) {
		PageUtility.selectByValue(userTypeFieldAdminUsers,value);
	}
	public void clickSaveBtnInAdminUsers() {
		saveBtnAdminUsers.click();
	}
	public Boolean alertValidation() {
		return alertUserCreatedSuccess.isDisplayed();
	}
}

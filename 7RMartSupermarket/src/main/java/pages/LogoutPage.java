package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class LogoutPage {
	
	@FindBy(xpath = "//a[@class = 'nav-link' and @data-toggle='dropdown']") WebElement adminClick;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']") WebElement logout;
	@FindBy(xpath = "//button[text() = 'Sign In']") WebElement signin;
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement moreInfoForAdminUsers;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']") WebElement moreInfoForManageCategory;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class = 'small-box-footer']") WebElement moreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']") WebElement moreInfoBtnManageContact;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer'] ") WebElement moreInfoManageFooterText;
	
	
	public WebDriver driver;
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); //PageFactory - To initialise web elements
	}
	
	public AdminUsersPage clickMoreInfoForAdminUsers() {
		moreInfoForAdminUsers.click();
		return new AdminUsersPage(driver);
	}
	
	public ManageCategoryPage clickingMoreInfoForManageCategory() {
		PageUtility pageUtility = new PageUtility();
		pageUtility.jsClick(driver, moreInfoForManageCategory);
		return new ManageCategoryPage(driver);
	}
	
	public ManageNewsPage clickingMoreInfoOfManageNews() {
		moreInfo.click();
		return new ManageNewsPage(driver);
	}
	
	public ManageContactPage clickMoreInfoOfManageContact() {
		moreInfoBtnManageContact.click();
		return new ManageContactPage(driver);
	}
	
	public ManageFooterTextPage clickingMoreInfoForManageFooterText() {
		moreInfoManageFooterText.click();
		return new ManageFooterTextPage(driver);
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

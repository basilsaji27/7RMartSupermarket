package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageFooterTextPage {
	//@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer'] ") WebElement moreInfoManageFooterText;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=2']") WebElement manageFooterTextActionBtn2;
	@FindBy(id = "content") WebElement manageFooterTextAddressField;
	@FindBy(id = "email") WebElement manageFooterTextEmailField;
	@FindBy(id = "phone") WebElement manageFooterTextPhoneField;
	@FindBy(xpath = "//button[@name='Update']") WebElement manageFooterTextUpdateBtn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement manageFooterTextSuccessAlertPopup;
	
	public WebDriver driver;
	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*public void clickingMoreInfoForManageFooterText() {
		moreInfoManageFooterText.click();
	}*/
	
	public ManageFooterTextPage clickingFooterTextActionBtn() {
		manageFooterTextActionBtn2.click();
		PageUtility pageUtility = new PageUtility();
		pageUtility.scrollBy(driver);
		return this;
	}
	
	public ManageFooterTextPage clickingAddressFieldinFooterTextInformationsPage(String newAddress) {
		manageFooterTextAddressField.clear();
		manageFooterTextAddressField.sendKeys(newAddress);
		return this;
	}
	
	public ManageFooterTextPage clickingEmailFieldinFooterTextInformationsPage(String newEmail) {
		manageFooterTextEmailField.clear();
		manageFooterTextEmailField.sendKeys(newEmail);
		return this;
	}
	
	public ManageFooterTextPage clickingPhoneFieldinFooterTextInformationsPage(String newPhone) {
		manageFooterTextPhoneField.clear();
		manageFooterTextPhoneField.sendKeys(newPhone);
		return this;
	}
	
	public ManageFooterTextPage clickingUpdateBtninFooterTextInformationsPage() {
		manageFooterTextUpdateBtn.click();
		return this;
	}
	
	public boolean alertVaidationforFooterTextSuccess() {
		return manageFooterTextSuccessAlertPopup.isDisplayed();
	}
	
	public boolean validatingUpdateBtn() {
		return manageFooterTextUpdateBtn.isEnabled();
	}
}

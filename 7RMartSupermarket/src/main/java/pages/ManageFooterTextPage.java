package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer'] ") WebElement moreInfoManageFooterText;
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
	
	public void clickingMoreInfoForManageFooterText() {
		moreInfoManageFooterText.click();
	}
	
	public void clickingFooterTextActionBtb() {
		manageFooterTextActionBtn2.click();
	}
	
	public void clickingAddressFieldinFooterTextInformationsPage(String newAddress) {
		manageFooterTextAddressField.clear();
		manageFooterTextAddressField.sendKeys(newAddress);
	}
	
	public void clickingEmailFieldinFooterTextInformationsPage(String newEmail) {
		manageFooterTextEmailField.clear();
		manageFooterTextEmailField.sendKeys(newEmail);
	}
	
	public void clickingPhoneFieldinFooterTextInformationsPage(String newPhone) {
		manageFooterTextPhoneField.clear();
		manageFooterTextPhoneField.sendKeys(newPhone);
	}
	
	public void clickingUpdateBtninFooterTextInformationsPage() {
		manageFooterTextUpdateBtn.click();
	}
	
	public boolean alertVaidationforFooterTextSuccess() {
		return manageFooterTextSuccessAlertPopup.isDisplayed();
	}
}

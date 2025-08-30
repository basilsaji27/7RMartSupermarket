package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']") WebElement moreInfoBtnManageContact;
	@FindBy(xpath = "//a[@role='button']") WebElement contactUsActionBtn;
	@FindBy(xpath = "//button[text() =' Update']") WebElement contactUsUpdateBtn;
	@FindBy(id = "phone") WebElement contactUsPhoneTextField;
	@FindBy(id = "email") WebElement contactUsEmailIdTextField;
	@FindBy(xpath = "//textarea[@name='address']") WebElement contactUsAddress;
	@FindBy(xpath = "//textarea[@name='del_time']") WebElement contactUsDeliveryTime;
	@FindBy(id = "del_limit") WebElement contactUsDeliveryChargeLimit;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alertBox;
	
	
	WebDriver driver;
	
	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickMoreInfoOfManageContact() {
		moreInfoBtnManageContact.click();
	}
	public void clickContactUsActionBtn() {
		contactUsActionBtn.click();
	}
	public void addingPhone(String phone) {
		contactUsPhoneTextField.clear();
		contactUsPhoneTextField.sendKeys(phone);
	}
	public void addingEmail(String email) {
		contactUsEmailIdTextField.clear();
		contactUsEmailIdTextField.sendKeys(email);
	}
	public void addingAddress(String address) {
		contactUsAddress.clear();
		contactUsAddress.sendKeys(address);
	}
	
	public void addingDeliveryTime(String delivery_time) {
		contactUsDeliveryTime.clear();
		contactUsDeliveryTime.sendKeys(delivery_time);
	}
	
	public void addingDeliveryChargeLimit(String delivery_charge_limit) {
		contactUsDeliveryChargeLimit.clear();
		contactUsDeliveryChargeLimit.sendKeys(delivery_charge_limit);
	}
	
	public void clickingUpdateBtn() {
		PageUtility.jsClick(driver, contactUsUpdateBtn);
	}
	
	public Boolean alertValidation() {
		return alertBox.isDisplayed();
	}
	
}

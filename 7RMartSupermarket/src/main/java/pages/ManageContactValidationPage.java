package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactValidationPage {
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']") WebElement moreInfoBtnManageContact;
	@FindBy(xpath = "//a[@role='button']") WebElement contactUsActionBtn;
	@FindBy(xpath = "//button[@name='Update']") WebElement contactUsUpdateBtn;
	/*@FindBy(id = "id('phone')") WebElement contactUsPhoneTextField;
	@FindBy(id = "id('email')") WebElement contactUsEmailIdTextField;
	@FindBy(xpath = "//textarea[@name='address']") WebElement contactUsAddress;
	@FindBy(xpath = "//textarea[@name='del_time']") WebElement contactUsDeliveryTime;
	@FindBy(id = "id('del_limit')") WebElement contactUsDeliveryChargeLimit;*/
	
	WebDriver driver;
	
	public ManageContactValidationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickMoreInfoOfManageContact() {
		moreInfoBtnManageContact.click();
	}
	public void clickContactUsActionBtn() {
		contactUsActionBtn.click();
	}
	public boolean validateUpdateBtn() {
		return contactUsUpdateBtn.isEnabled();
	}
}

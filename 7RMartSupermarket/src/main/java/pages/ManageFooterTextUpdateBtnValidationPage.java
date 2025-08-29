package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextUpdateBtnValidationPage {
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer'] ") WebElement moreInfoManageFooterText;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=2']") WebElement manageFooterTextActionBtn2;
	@FindBy(xpath = "//button[@name='Update']") WebElement manageFooterTextUpdateBtn;
	
	WebDriver driver;
	public ManageFooterTextUpdateBtnValidationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickingMoreInfoForManageFooterText() {
		moreInfoManageFooterText.click();
	}
	
	public void clickingFooterTextActionBtb() {
		manageFooterTextActionBtn2.click();
	}
	
	public boolean validatingUpdateBtn() {
		return manageFooterTextUpdateBtn.isEnabled();
	}
}

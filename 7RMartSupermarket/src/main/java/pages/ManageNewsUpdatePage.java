package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsUpdatePage {
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class = 'small-box-footer']") WebElement moreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/edit?edit=7618&page_ad=1']") WebElement manageNewsEditActionBtn;
	@FindBy(id = "news") WebElement manageNewsTextField;
	@FindBy(xpath = "//button[@name='update']") WebElement manageNewsUpdateBtn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alertBox;
	
	public WebDriver driver;
	
	public ManageNewsUpdatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); //PageFactory - To initialise web elements
	}
	
	public void clickingMoreInfoOfManageNews() {
		moreInfo.click();
	}
	
	public void clickingEditActionBtn() {
		manageNewsEditActionBtn.click();
	}
	
	public void clickingManageNewsTextField(String updatedNews) {
		manageNewsTextField.clear();
		manageNewsTextField.sendKeys(updatedNews);
	}
	
	public void clickingManageNewsUpdateBtn() {
		manageNewsUpdateBtn.click();
	}
	
	public Boolean alertValidation() {
		return alertBox.isDisplayed();
	}
	
}

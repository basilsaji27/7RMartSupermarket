package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class = 'small-box-footer']") WebElement moreInfo;
	@FindBy(xpath = "//a[text() =' New']") WebElement newbtn;
	@FindBy(xpath = "//textarea[@id = 'news']") WebElement newsdata;
	@FindBy(xpath = "//button[text() = 'Save']") WebElement clickSave;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alertBox;
	
public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); //PageFactory - To initialise web elements
	}
	
	public void clickingMoreInfoOfManageNews() {
		moreInfo.click();
	}
	
	public void clickingNewInManageNews() {
		newbtn.click();
	}
	
	public void enteringNews(String textdata) {
		newsdata.sendKeys(textdata);
	}
	
	public void clickingSaveOfNews() {
		clickSave.click();
	}
	
	public Boolean alertValidation() {
		return alertBox.isDisplayed();
	}
}

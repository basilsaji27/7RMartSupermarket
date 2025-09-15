package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageNewsPage {
	// @FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class
	// = 'small-box-footer']") WebElement moreInfo;
	@FindBy(xpath = "//a[text() =' New']")
	WebElement newbtn;
	@FindBy(xpath = "//textarea[@id = 'news']")
	WebElement newsdata;
	@FindBy(xpath = "//button[text() = 'Save']")
	WebElement clickSave;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement createNewsAlertBox;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/edit?edit=7666&page_ad=1']")
	WebElement manageNewsEditActionBtn;
	@FindBy(id = "news")
	WebElement manageNewsTextField;
	@FindBy(xpath = "//button[@name='update']")
	WebElement manageNewsUpdateBtn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement updateNewsAlertBox;
	@FindBy(xpath = "//a[text() =' Search']")
	WebElement manageNewsSearch;
	// @FindBy(class = "form-control") WebElement manageNewsSearchTextField;
	@FindBy(xpath = "//input[@placeholder='Title']")
	WebElement manageNewsSearchField;
	@FindBy(xpath = "//button[text()='Search']")
	WebElement manageNewsSearchBtn;
	@FindBy(xpath = "//td[text()='News']")
	WebElement newslist;
	@FindBy(xpath = "//a[text()='Next']")
	WebElement paginateNext;
	@FindBy(xpath = "./td[2]//a[contains(@href,'edit')]")
	WebElement editBtn;
	@FindBy(xpath = "./td[1]")
	WebElement searchData;

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // PageFactory - To initialise web elements
	}

	/*
	 * public void clickingMoreInfoOfManageNews() { moreInfo.click(); }
	 */

	public ManageNewsPage clickingNewInManageNews() {
		newbtn.click();
		return this;
	}

	public ManageNewsPage enteringNews(String textdata) {
		newsdata.sendKeys(textdata);
		return this;
	}

	public ManageNewsPage clickingSaveOfNews() {
		clickSave.click();
		return this;
	}

	public Boolean alertValidation() {
		return createNewsAlertBox.isDisplayed();
	}

	public ManageNewsPage clickingEditActionBtn() {
		manageNewsEditActionBtn.click();
		return this;
	}

	public ManageNewsPage clickingManageNewsTextField(String updatedNews) {
		manageNewsTextField.clear();
		manageNewsTextField.sendKeys(updatedNews);
		return this;
	}

	public ManageNewsPage clickingManageNewsUpdateBtn() {
		manageNewsUpdateBtn.click();
		return this;
	}

	public Boolean alertValidationforNewsUpdates() {
		return updateNewsAlertBox.isDisplayed();
	}

	public ManageNewsPage clickingSearchBtnInManageNews() {
		manageNewsSearch.click();
		return this;
	}

	public ManageNewsPage clickingSearchTextField(String textdata) {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, manageNewsSearchField);
		manageNewsSearchField.sendKeys(textdata);
		return this;
	}

	public ManageNewsPage clickingSearchBtnInSearchManageNews() throws Exception {
		manageNewsSearchBtn.click();
		PageUtility pageutility = new PageUtility();
		pageutility.scrollBy(driver);
		return this;
	}

	public ManageNewsPage updateNews(WebDriver driver, String textdata, String updatedNews) throws Exception {
		boolean found = false;
		while (!found) {
			List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
			for (WebElement row : rows) {
				WebElement newsCol = row.findElement(By.xpath("./td[1]"));
				if (newsCol.getText().equalsIgnoreCase(textdata)) {
					WebElement editBtn = row.findElement(By.xpath("./td[2]//a[contains(@href,'edit')]"));
					PageUtility pageutility = new PageUtility();
					pageutility.scrollIntoView(driver, editBtn);
					Thread.sleep(2000);
					editBtn.click();
					newsdata.clear();
					newsdata.sendKeys(updatedNews);
					manageNewsUpdateBtn.click();
					found = true;
					break;
				}
			}
			if (!found) {
				try {
					if (paginateNext.isDisplayed() && paginateNext.isEnabled()) {
						paginateNext.click();
					} else {
						throw new RuntimeException("News not found in any page!");
					}
				} catch (NoSuchElementException e) {
					throw new RuntimeException("Pagination ended. News not found: " + textdata);
				}
			}
		}
		return this;
	}

}

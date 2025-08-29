package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;

public class ManageCategoryPage {
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']") WebElement moreInfoForManageCategory;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']") WebElement newActionBtnInCategory;
	@FindBy(id = "category") WebElement addCategoryField;
	@FindBy(id = "134-selectable") WebElement selectgrpField;
	@FindBy(id = "main_img") WebElement imgUpload;
	@FindBy(xpath = "//button[@name='create']") WebElement addCategorySaveBtn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alertCategoryCreatedSuccess;
	
	public WebDriver driver;
	
	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	public void clickingMoreInfoForManageCategory() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", moreInfoForManageCategory);
	}
	
	public void clickingNewInManageCategory() {
		newActionBtnInCategory.click();
	}
	
	public void addCategoryName(String categoryName) {
		addCategoryField.sendKeys(categoryName);
	}
	
	public void selectCategoryGroup() {
		selectgrpField.click();
	}
	
	/*public void selectCategoryGroup(String value) {
		PageUtility.selectByValue(selectgrpField,value);
	}*/
	
	public void categoryImageUpload() {
		FileUploadUtility.fileUploadUsingSendKeys(imgUpload, Constant.TESTIMAGEFILE);
	}
	
	public void clickingSavebtn() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", addCategorySaveBtn);
		//addCategorySaveBtn.click();
	}
	
	public Boolean alertValidation() {
		return alertCategoryCreatedSuccess.isDisplayed();
	}
}

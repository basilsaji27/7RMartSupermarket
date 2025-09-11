package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;

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
	
	/*public void clickingMoreInfoForManageCategory() {
		PageUtility pageUtility = new PageUtility();
		pageUtility.jsClick(driver, moreInfoForManageCategory);
	}*/
	
	public ManageCategoryPage clickingNewInManageCategory() {
		newActionBtnInCategory.click();
		return this;
	}
	
	public ManageCategoryPage addCategoryName(String categoryName) {
		addCategoryField.sendKeys(categoryName);
		return this;
	}
	
	public ManageCategoryPage selectCategoryGroup() {
		selectgrpField.click();
		PageUtility pageUtility = new PageUtility();
		pageUtility.scrollBy(driver);
		return this;
	}
	
	/*public void selectCategoryGroup(String value) {
		PageUtility.selectByValue(selectgrpField,value);
	}*/
	
	public ManageCategoryPage categoryImageUpload() {
		FileUploadUtility fileUploadUtility = new FileUploadUtility();
		fileUploadUtility.fileUploadUsingSendKeys(imgUpload, Constant.TESTIMAGEFILE);
		return this;
	}
	
	public ManageCategoryPage clickingSavebtn() {
		PageUtility pageUtility = new PageUtility();
		pageUtility.scrollIntoView(driver, addCategorySaveBtn);
		pageUtility.jsClick(driver, addCategorySaveBtn);
		return this;
	}
	
	public boolean alertValidation() {
		return alertCategoryCreatedSuccess.isDisplayed();
	}
}

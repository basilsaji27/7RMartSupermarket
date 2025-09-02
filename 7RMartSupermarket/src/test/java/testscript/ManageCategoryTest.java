package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base{
	@Test( retryAnalyzer=retry.Retry.class, description = "TC for adding new category item")
	public void addNewCategory() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		String categoryName = ExcelUtility.getStringData(1, 0, "ManageCategory");
		ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		managecategorypage.clickingMoreInfoForManageCategory();
		managecategorypage.clickingNewInManageCategory();
		managecategorypage.addCategoryName(categoryName);
		managecategorypage.selectCategoryGroup();
		managecategorypage.categoryImageUpload();
		managecategorypage.clickingSavebtn();
		boolean createdSuccess = managecategorypage.alertValidation();
		Assert.assertTrue(createdSuccess,Constant.MANAGECATEGORY);
	}
}

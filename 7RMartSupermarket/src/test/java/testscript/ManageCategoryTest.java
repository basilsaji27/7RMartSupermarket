package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageCategoryTest extends Base{
	ManageCategoryPage managecategorypage;
	LogoutPage logoutpage;
	@Test( retryAnalyzer=retry.Retry.class, description = "TC for adding new category item")
	public void addNewCategory() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();
		//String categoryName = ExcelUtility.getStringData(1, 0, "ManageCategory");
		//ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		FakerUtility fakerutility = new FakerUtility();
		String categoryName = fakerutility.createARandomFirstName();
		managecategorypage = logoutpage.clickingMoreInfoForManageCategory().clickingNewInManageCategory().addCategoryName(categoryName).selectCategoryGroup().categoryImageUpload().clickingSavebtn();
		/*managecategorypage.clickingNewInManageCategory();
		managecategorypage.addCategoryName(categoryName);
		managecategorypage.selectCategoryGroup();
		managecategorypage.categoryImageUpload();
		managecategorypage.clickingSavebtn();*/
		boolean createdSuccess = managecategorypage.alertValidation();
		Assert.assertTrue(createdSuccess,Constant.MANAGECATEGORY);
	}
}

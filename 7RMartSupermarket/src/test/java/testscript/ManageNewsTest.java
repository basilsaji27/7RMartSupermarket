package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import constant.Constant;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	
	@Test( retryAnalyzer=retry.Retry.class, description = "Testcase for creating new news")
	public void creatingnewNews() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		String textdata = ExcelUtility.getStringData(1, 0, "ManageNewsPage");
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickingMoreInfoOfManageNews();
		managenewspage.clickingNewInManageNews();
		managenewspage.enteringNews(textdata);
		managenewspage.clickingSaveOfNews();
		boolean newsAdded = managenewspage.alertValidation();
		Assert.assertTrue(newsAdded,Constant.MANAGENEWSCREATION);
	}
	
	@Test( retryAnalyzer=retry.Retry.class, description = "Testcase for updating news")
	public void updateExistingNews() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		String updatedNews = ExcelUtility.getStringData(1, 1, "ManageNewsPage");
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickingMoreInfoOfManageNews();
		managenewspage.clickingEditActionBtn();
		managenewspage.clickingManageNewsTextField(updatedNews);
		managenewspage.clickingManageNewsUpdateBtn();
		boolean newsUpdated = managenewspage.alertValidationforNewsUpdates();
		Assert.assertTrue(newsUpdated,Constant.MANAGENEWSUPDATION);
	}
}

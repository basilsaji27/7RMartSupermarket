package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	ManageNewsPage managenewspage;
	LogoutPage logoutpage;

	@Test(retryAnalyzer = retry.Retry.class, description = "Testcase for creating new news")
	public void verifytheCreationOfNewNews() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		// loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();
		String textdata = ExcelUtility.getStringData(1, 0, "ManageNewsPage");
		// ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage = logoutpage.clickingMoreInfoOfManageNews();
		managenewspage.clickingNewInManageNews().enteringNews(textdata).clickingSaveOfNews();
		// managenewspage.enteringNews(textdata);
		// managenewspage.clickingSaveOfNews();
		boolean newsAdded = managenewspage.alertValidation();
		Assert.assertTrue(newsAdded, Constant.MANAGENEWSCREATION);
	}

	@Test(retryAnalyzer = retry.Retry.class, description = "Testcase for updating news")
	public void verifytheUpdationOfExistingNews() throws Exception {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		// loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();
		String textdata = ExcelUtility.getStringData(1, 0, "ManageNewsPage");
		String updatedNews = ExcelUtility.getStringData(1, 1, "ManageNewsPage");
		// ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage = logoutpage.clickingMoreInfoOfManageNews();
		managenewspage.clickingSearchBtnInManageNews().clickingSearchTextField(textdata).clickingSearchBtnInManageNews()
				.updateNews(driver, textdata, updatedNews);
		/*
		 * managenewspage.clickingSearchTextField(textdata);
		 * managenewspage.clickingSearchBtnInSearchManageNews();
		 * managenewspage.updateNews(driver, textdata, updatedNews);
		 */
		boolean newsUpdated = managenewspage.alertValidationforNewsUpdates();
		Assert.assertTrue(newsUpdated, Constant.MANAGENEWSUPDATION);
	}
}

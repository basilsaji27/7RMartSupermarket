package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsUpdatePage;
import utilities.ExcelUtility;

public class ManageNewsUpdateTest extends Base{
	@Test( retryAnalyzer=retry.Retry.class, description = "TC for updating news")
	public void updatingManageNews() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		String updatedNews = ExcelUtility.getStringData(1, 1, "ManageNewsPage");
		ManageNewsUpdatePage managenewsupdatepage = new ManageNewsUpdatePage(driver);
		managenewsupdatepage.clickingMoreInfoOfManageNews();
		managenewsupdatepage.clickingEditActionBtn();
		managenewsupdatepage.clickingManageNewsTextField(updatedNews);
		managenewsupdatepage.clickingManageNewsUpdateBtn();
		Boolean newsUpdated = managenewsupdatepage.alertValidation();
		Assert.assertTrue(newsUpdated);
	}
	
}

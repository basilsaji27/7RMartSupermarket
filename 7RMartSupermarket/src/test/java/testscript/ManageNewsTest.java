package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	
	@Test
	public void creatingNewNews() throws IOException {
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
		Boolean newsAdded = managenewspage.alertValidation();
		Assert.assertTrue(newsAdded);
	}
}

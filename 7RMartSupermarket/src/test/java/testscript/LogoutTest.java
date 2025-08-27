package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base{
	
	@Test
	public void verifyUserLogout() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.clickAdminButtonInHomePage();
		logoutpage.clickLogoutButton();
		Boolean loginpagescreen = logoutpage.validateLoginPage();
		Assert.assertTrue(loginpagescreen);
	}
}

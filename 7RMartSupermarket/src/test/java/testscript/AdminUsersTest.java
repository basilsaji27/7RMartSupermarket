package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base{
	@Test
	public void createAdminUser() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		String adminusername = ExcelUtility.getStringData(4, 0, "AdminUsers");
		String adminpassword = ExcelUtility.getStringData(4, 1, "AdminUsers");
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		adminuserspage.clickMoreInfoForAdminUsers();
		adminuserspage.clickNewActionBtnForAdminUsers();
		adminuserspage.enterUsernameInAdminUsersInformations(adminusername);
		adminuserspage.enterPasswordInAdminUsersInformations(adminpassword);
		adminuserspage.selectUserTypeInAdminUsersInformations("admin");
		adminuserspage.clickSaveBtnInAdminUsers();
		Boolean createdSuccess = adminuserspage.alertValidation();
		Assert.assertTrue(createdSuccess);
	}
}

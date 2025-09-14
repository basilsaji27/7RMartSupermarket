package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base{
	AdminUsersPage adminuserspage;
	LogoutPage logoutpage;
	@Test( retryAnalyzer=retry.Retry.class, description = "Testcase to create a new admin user")
	public void createAdminUser() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();
		//String adminusername = ExcelUtility.getStringData(4, 0, "AdminUsers");
		//String adminpassword = ExcelUtility.getStringData(4, 1, "AdminUsers");
		//AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		FakerUtility fakerutility = new FakerUtility();
		String adminusername = fakerutility.createARandomLastName();
		String adminpassword = fakerutility.createARandomLastName();
		//adminuserspage.clickMoreInfoForAdminUsers();
		adminuserspage = logoutpage.clickMoreInfoForAdminUsers();
		adminuserspage.clickNewActionBtnForAdminUsers().enterUsernameInAdminUsersInformations(adminusername).enterPasswordInAdminUsersInformations(adminpassword).selectUserTypeInAdminUsersInformations("partner").clickSaveBtnInAdminUsers();
		/*adminuserspage.enterUsernameInAdminUsersInformations(adminusername);
		adminuserspage.enterPasswordInAdminUsersInformations(adminpassword);
		adminuserspage.selectUserTypeInAdminUsersInformations("admin");
		adminuserspage.clickSaveBtnInAdminUsers();*/
		boolean createdSuccess = adminuserspage.alertValidation();
		Assert.assertTrue(createdSuccess,Constant.ADMINUSERCREATION);
	}
}

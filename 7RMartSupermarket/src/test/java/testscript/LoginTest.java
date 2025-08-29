package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	
	@Test( retryAnalyzer=retry.Retry.class, description = "User Login with Valid Credentials")
	public void verifyUserIsAbleToLoginUsingValidCredentials() throws IOException {
		//String username = "admin";
		//String password = "admin";
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		Boolean homePage = loginpage.validateHome();
		Assert.assertTrue(homePage);
	}
	
	@Test(groups = {"regression"}, retryAnalyzer=retry.Retry.class, description = "User Login with valid username and invalid password")
	public void verifyUserloginWithValidUsernameInvalidPassword() throws IOException {
		/*String username = "admin";
		String password = "Admin";*/
		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		Boolean alertScreen = loginpage.alertValidation();
		Assert.assertTrue(alertScreen);
	}
	
	@Test(groups = {"regression"}, retryAnalyzer=retry.Retry.class, description = "User Login with invalid username and valid password")
	public void verifyUserLoginWithInvalidUsernameValidPassword() throws IOException {
		/*String username = "Test";
		String password = "admin";*/
		String username = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		Boolean alertScreen = loginpage.alertValidation();
		Assert.assertTrue(alertScreen);
	}
	
	@Test(groups = {"regression"}, retryAnalyzer=retry.Retry.class, description = "User Login with invalid Credentials")
	public void verifyUserLoginWithInvalidUsernameInvalidPassword() throws IOException {
		/*String username = "Test";
		String password = "Test";*/
		String username = ExcelUtility.getStringData(4, 0, "LoginPage");
		String password = ExcelUtility.getStringData(4, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		Boolean alertScreen = loginpage.alertValidation();
		Assert.assertTrue(alertScreen);
	}
}

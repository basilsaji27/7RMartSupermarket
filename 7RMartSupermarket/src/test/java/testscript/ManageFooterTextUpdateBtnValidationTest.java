package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterTextUpdateBtnValidationPage;
import utilities.ExcelUtility;
import utilities.PageUtility;

public class ManageFooterTextUpdateBtnValidationTest extends Base{
	@Test
	public void validateUpdateBtn() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		ManageFooterTextUpdateBtnValidationPage managefootertextupdatebtnvalidationpage = new ManageFooterTextUpdateBtnValidationPage(driver);
		managefootertextupdatebtnvalidationpage.clickingMoreInfoForManageFooterText();
		managefootertextupdatebtnvalidationpage.clickingFooterTextActionBtb();
		PageUtility.scrollBy(driver);
		Boolean updateBtn = managefootertextupdatebtnvalidationpage.validatingUpdateBtn();
		Assert.assertTrue(updateBtn);
	}
}

package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageContactValidationPage;
import utilities.ExcelUtility;
import utilities.PageUtility;

public class ManageContactValidationTest extends Base{
	@Test
	public void validateUpdateBtnAvailable() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		ManageContactValidationPage managecontactvalidationpage = new ManageContactValidationPage(driver);
		managecontactvalidationpage.clickMoreInfoOfManageContact();
		managecontactvalidationpage.clickContactUsActionBtn();
		PageUtility.scrollBy(driver);
		Boolean contactUs = managecontactvalidationpage.validateUpdateBtn();
		Assert.assertTrue(contactUs);
	}
}

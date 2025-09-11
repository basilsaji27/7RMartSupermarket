package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base{
	ManageFooterTextPage managefootertextpage;
	LogoutPage logoutpage;
	@Test(groups = {"regression"}, retryAnalyzer=retry.Retry.class, description = "Testcase for managing footer details")
	public void manageFooterTextUpdate() throws Exception {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();
		String newAddress = ExcelUtility.getStringData(1, 0, "ManageFooterTextPage");
		String newEmail = ExcelUtility.getStringData(2, 0, "ManageFooterTextPage");
		String newPhone = ExcelUtility.getIntegerData(3, 0, "ManageFooterTextPage");
		//ManageFooterTextPage managefootertextpage = new ManageFooterTextPage(driver);
		managefootertextpage = logoutpage.clickingMoreInfoForManageFooterText();
		managefootertextpage.clickingFooterTextActionBtn().clickingAddressFieldinFooterTextInformationsPage(newAddress).clickingEmailFieldinFooterTextInformationsPage(newEmail).clickingPhoneFieldinFooterTextInformationsPage(newPhone).clickingUpdateBtninFooterTextInformationsPage();
		/*managefootertextpage.clickingAddressFieldinFooterTextInformationsPage(newAddress);
		managefootertextpage.clickingEmailFieldinFooterTextInformationsPage(newEmail);
		managefootertextpage.clickingPhoneFieldinFooterTextInformationsPage(newPhone);
		managefootertextpage.clickingUpdateBtninFooterTextInformationsPage();*/
		boolean footerTextSuccess = managefootertextpage.alertVaidationforFooterTextSuccess();
		Assert.assertTrue(footerTextSuccess,Constant.MANAGEFOOTERTEXT);
	}
	
	@Test( retryAnalyzer=retry.Retry.class, description = "Testcase for validating button in Manage Footer")
	public void validateUpdateBtnPresent() throws IOException, Exception {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();
		//ManageFooterTextPage managefootertextpage = new ManageFooterTextPage(driver);
		managefootertextpage = logoutpage.clickingMoreInfoForManageFooterText();
		managefootertextpage.clickingFooterTextActionBtn();
		boolean updateBtn = managefootertextpage.validatingUpdateBtn();
		Assert.assertTrue(updateBtn,Constant.MANAGEFOOTERPAGEBUTTON);
	}
}

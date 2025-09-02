package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base{
	@Test( retryAnalyzer=retry.Retry.class, description = "Testcase for managing footer details")
	public void manageFooterTextUpdate() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		String newAddress = ExcelUtility.getStringData(1, 0, "ManageFooterTextPage");
		String newEmail = ExcelUtility.getStringData(2, 0, "ManageFooterTextPage");
		String newPhone = ExcelUtility.getStringData(3, 0, "ManageFooterTextPage");
		ManageFooterTextPage managefootertextpage = new ManageFooterTextPage(driver);
		managefootertextpage.clickingMoreInfoForManageFooterText();
		managefootertextpage.clickingFooterTextActionBtn();
		managefootertextpage.clickingAddressFieldinFooterTextInformationsPage(newAddress);
		managefootertextpage.clickingEmailFieldinFooterTextInformationsPage(newEmail);
		managefootertextpage.clickingPhoneFieldinFooterTextInformationsPage(newPhone);
		managefootertextpage.clickingUpdateBtninFooterTextInformationsPage();
		boolean footerTextSuccess = managefootertextpage.alertVaidationforFooterTextSuccess();
		Assert.assertTrue(footerTextSuccess,Constant.MANAGEFOOTERTEXT);
	}
	
	@Test( retryAnalyzer=retry.Retry.class, description = "Testcase for validating button in Manage Footer")
	public void validateUpdateBtnPresent() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		ManageFooterTextPage managefootertextpage = new ManageFooterTextPage(driver);
		managefootertextpage.clickingMoreInfoForManageFooterText();
		managefootertextpage.clickingFooterTextActionBtn();
		boolean updateBtn = managefootertextpage.validatingUpdateBtn();
		Assert.assertTrue(updateBtn,Constant.MANAGEFOOTERPAGEBUTTON);
	}
}

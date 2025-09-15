package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
	ManageContactPage managecontactpage;
	LogoutPage logoutpage;

	@Test(groups = {
			"regression" }, retryAnalyzer = retry.Retry.class, description = "Testcase for updating contact details")
	public void managingContactDetails() throws Exception {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		// loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();
		String phone = ExcelUtility.getIntegerData(1, 0, "ManageContactPage");
		String email = ExcelUtility.getStringData(2, 0, "ManageContactPage");
		String address = ExcelUtility.getStringData(3, 0, "ManageContactPage");
		String delivery_time = ExcelUtility.getIntegerData(4, 0, "ManageContactPage");
		String delivery_charge_limit = ExcelUtility.getIntegerData(5, 0, "ManageContactPage");
		// ManageContactPage managecontactpage = new ManageContactPage(driver);
		managecontactpage = logoutpage.clickMoreInfoOfManageContact();
		managecontactpage.clickContactUsActionBtn().addingPhone(phone).addingEmail(email).addingAddress(address)
				.addingDeliveryTime(delivery_time).addingDeliveryChargeLimit(delivery_charge_limit).clickingUpdateBtn();
		/*
		 * '''managecontactpage.addingPhone(phone);
		 * managecontactpage.addingEmail(email);
		 * managecontactpage.addingAddress(address);
		 * managecontactpage.addingDeliveryTime(delivery_time);
		 * managecontactpage.addingDeliveryChargeLimit(delivery_charge_limit);
		 * managecontactpage.clickingUpdateBtn();
		 */
		boolean contactUpdated = managecontactpage.alertValidation();
		Assert.assertTrue(contactUpdated, Constant.MANAGECONTACT);
	}

	@Test(retryAnalyzer = retry.Retry.class, description = "TC for verifying Update button enabled or not")
	public void validateUpdateBtnAvailable() throws Exception {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		// loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();
		// ManageContactPage managecontactpage = new ManageContactPage(driver);
		managecontactpage = logoutpage.clickMoreInfoOfManageContact();
		managecontactpage.clickContactUsActionBtn();
		boolean contactUs = managecontactpage.validateUpdateBtn();
		Assert.assertTrue(contactUs, Constant.MANAGECONTACTBUTTON);
	}
}

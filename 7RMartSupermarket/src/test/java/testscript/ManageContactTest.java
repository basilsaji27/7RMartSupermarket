package testscript;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base{
	@Test
	public void managingContactDetails() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		String phone = ExcelUtility.getIntegerData(1, 0, "ManageContactPage");
		String email = ExcelUtility.getStringData(2, 0, "ManageContactPage");
		String address = ExcelUtility.getStringData(3, 0, "ManageContactPage");
		String delivery_time = ExcelUtility.getIntegerData(4, 0, "ManageContactPage");
		String delivery_charge_limit = ExcelUtility.getIntegerData(5, 0, "ManageContactPage");
		ManageContactPage managecontactpage = new ManageContactPage(driver);
		managecontactpage.clickMoreInfoOfManageContact();
		managecontactpage.clickContactUsActionBtn();
		managecontactpage.addingPhone(phone);
		managecontactpage.addingEmail(email);
		managecontactpage.addingAddress(address);
		managecontactpage.addingDeliveryTime(delivery_time);
		managecontactpage.addingDeliveryChargeLimit(delivery_charge_limit);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
		managecontactpage.clickingUpdateBtn();
		Boolean contactUpdated = managecontactpage.alertValidation();
		Assert.assertTrue(contactUpdated);
	}
}

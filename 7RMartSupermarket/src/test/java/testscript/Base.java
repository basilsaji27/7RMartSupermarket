package testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	WebDriver driver;
	@BeforeMethod
	public void browserInitialization() {
		driver = new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize();
	}
	
	//@AfterMethod
	public void browserQuit() {
		driver.quit();
	}
}

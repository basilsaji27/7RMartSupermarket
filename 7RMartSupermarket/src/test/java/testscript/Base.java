package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenShotUtility;
import utilities.WaitUtility;

public class Base {
	WebDriver driver;
	public Properties properties; //To read the URL
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void browserInitialization(String browser) throws Exception {
		try {
			properties = new Properties();
			FileInputStream fileinputstream = new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileinputstream);
		} catch (Exception e) {
			System.out.println("File Not Found!");
		}
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver()
		    .clearResolutionCache()
		    .forceDownload()
		    .setup();
			driver = new EdgeDriver();
		}
		else {
			throw new Exception("Select proper browser");
		}
		//driver = new ChromeDriver();
		driver.get(properties.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
			driver.manage().window().maximize();
	}
	
	@AfterMethod(alwaysRun = true)
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenShotUtility scrShot = new ScreenShotUtility(); // creating obj
			scrShot.getScreenShot(driver, iTestResult.getName());
		}
		driver.quit();
	}
}

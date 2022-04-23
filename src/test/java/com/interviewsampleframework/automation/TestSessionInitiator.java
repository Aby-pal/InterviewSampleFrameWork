package com.interviewsampleframework.automation;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.interviewsampleframework.automation.utils.ConfigPropertyReader;
import com.interviewsampleframework.automation.utils.TakeScreenshot;
import com.interviewsampleframework.automation.utils.YamlReader;
import interviewsampleframework.keywords.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;


public class TestSessionInitiator {

	// protected WebDriver driver;
	protected WebDriver driver;
	private final WebDriverFactory wdfactory;

	/**
	 * Initiating the page objects
	 */

	public SamplePage samplePage;
	public TakeScreenshot takescreenshot;
	private String testname;

	private void _initPage() {
		samplePage = new SamplePage(driver);
		
	}

	
	/**
	 * Page object Initiation done
	 *
	 * @param testname
	 */
	public TestSessionInitiator(String testname) {
		wdfactory = new WebDriverFactory();
		testInitiator(testname);
		this.testname = testname;
	}

	public TestSessionInitiator(String testname, String browserName) {
		wdfactory = new WebDriverFactory(browserName);
		testInitiator(testname);
		this.testname = testname;

	}

	private void testInitiator(String testname) {
		YamlReader.setYamlFilePath();
		_configureBrowser();
		_initPage();
		takescreenshot = new TakeScreenshot(testname, this.driver);
	}

	private void _configureBrowser() {
		driver = wdfactory.getDriver(_getSessionConfig());
		if (!_getSessionConfig().get("browser").toLowerCase().trim().equalsIgnoreCase("mobile")) {
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
		}
		driver.manage()
				.timeouts()
				.implicitlyWait(Integer.parseInt(ConfigPropertyReader.getProperty("timeout")),
						TimeUnit.SECONDS);
	}

	private Map<String, String> _getSessionConfig() {
		String[] configKeys = { "tier", "browser", "seleniumServer",
				"seleniumserverhost", "timeout", "driverpath", "appiumServer",
				"mobileDevice" };
		Map<String, String> config = new HashMap<>();
		for (String string : configKeys) {
			config.put(string, ConfigPropertyReader.getProperty("./Config.properties", string));
		}
		return config;
	}

	public void launchApplication(String base_url) {
		Reporter.log("\n[INFO]: The application url is :- " + base_url, true);
		driver.manage().deleteAllCookies();
		driver.get(base_url);
	}

	public void closeBrowserSession() {
		Reporter.log("[INFO]: The Test: " + this.testname.toUpperCase() + " COMPLETED!"
				+ "\n", true);
		try {
			driver.close();
			driver.close();

//			Thread.sleep(1000);// [INFO]: this to wait before you close every
								// thing
		} catch (Exception b) {
			b.getMessage();
		}
		
		
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public void takeScreenShotOnException(ITestResult result) {
		takescreenshot.takeScreenShotOnException(result);
	}

}

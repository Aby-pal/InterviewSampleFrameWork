/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interviewsampleframework.automation;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

public class WebDriverFactory {

	private String browser = "";
	static Process p=null;

	public WebDriverFactory() {
	}

	public WebDriverFactory(String browserName) {
		browser = browserName;
	}
	
	private static final DesiredCapabilities capabilities = new DesiredCapabilities();
	static FirefoxProfile firefoxProfile;

	//public WebDriver getDriver(Map<String, String> seleniumconfig) {
	public WebDriver getDriver(Map<String, String> seleniumconfig) {

		System.out.println("browser is :"+seleniumconfig.get("browser"));
		if (browser==null || browser.isEmpty()) {
			browser = seleniumconfig.get("browser").trim();
		}
		
			
		Reporter.log("[INFO]: The test Browser is " + browser.toUpperCase()
				+ " !!!", true);

		if (seleniumconfig.get("seleniumserver").equalsIgnoreCase("local")) {
			if (browser.equalsIgnoreCase("firefox")) {
				return getFirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				return getChromeDriver(seleniumconfig.get("driverpath"));
			} else if (browser.equalsIgnoreCase("Safari")) {
				return getSafariDriver();
			} else if ((browser.equalsIgnoreCase("ie"))
					|| (browser.equalsIgnoreCase("internetexplorer"))
					|| (browser.equalsIgnoreCase("internet explorer"))) {
				return getInternetExplorerDriver(seleniumconfig
						.get("driverpath"));
			}
			//TODO: treat mobile browser and separate instance on lines of remote driver
			else if (browser.equalsIgnoreCase("mobile")){
				return setMobileDriver(seleniumconfig);
				//return setAndroidDriver(seleniumconfig);
			}
		}
		if (seleniumconfig.get("seleniumserver").equalsIgnoreCase("remote")) {
			return setRemoteDriver(seleniumconfig);
		}
		return getFirefoxDriver();
	}

	private WebDriver setRemoteDriver(Map<String, String> selConfig) {
		DesiredCapabilities cap = null;
		if (browser.equalsIgnoreCase("firefox")) {
			cap = DesiredCapabilities.firefox();
		} else if (browser.equalsIgnoreCase("chrome")) {
			cap = DesiredCapabilities.chrome();
		} else if (browser.equalsIgnoreCase("Safari")) {
			cap = DesiredCapabilities.safari();
		} else if ((browser.equalsIgnoreCase("ie"))
				|| (browser.equalsIgnoreCase("internetexplorer"))
				|| (browser.equalsIgnoreCase("internet explorer"))) {
			cap = DesiredCapabilities.internetExplorer();
			System.setProperty("webdriver.ie.driver", "C:\\NEJM\\"
					+ "IEDriverServer.exe");
		}
		String seleniuhubaddress = selConfig.get("seleniumserverhost");
		URL selserverhost = null;
		try {
			selserverhost = new URL(seleniuhubaddress);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		cap.setJavascriptEnabled(true);
		
		return new RemoteWebDriver(selserverhost, cap);
	}

	private static WebDriver getChromeDriver(String driverpath) {
		if (driverpath.endsWith(".exe")) {
			System.setProperty("webdriver.chrome.driver", driverpath);
		} else {
			System.setProperty("webdriver.chrome.driver", driverpath
					+ "chromedriver.exe");
		}
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		return new ChromeDriver(cap);
	}

	private static WebDriver getInternetExplorerDriver(String driverpath) {
		
		if (driverpath.endsWith(".exe")) {
			System.setProperty("webdriver.ie.driver", driverpath);
		} else {
			System.setProperty("webdriver.ie.driver", driverpath
					+ "IEDriverServer.exe");
		}
		capabilities.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
		capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT,true);
		capabilities.setCapability("ignoreZoomSetting", true);
		
		try {
			 p = Runtime.getRuntime().exec("D:\\eReader_Git\\Harvard_eReader\\kill_IE_process.bat");
			 Reporter.log("[INFO]: Killed all existing IE driver processes",true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability("nativeEvents",false);
		
		return new InternetExplorerDriver(capabilities);
	}

	private static WebDriver getSafariDriver() {
		return new SafariDriver();
	}

	private static WebDriver getFirefoxDriver() {
		firefoxProfile = new FirefoxProfile();
		ProfilesIni profile = new ProfilesIni();
		firefoxProfile = profile.getProfile("default");
		return new FirefoxDriver(firefoxProfile);
	}

//	private WebDriver setMobileDriver(Map<String, String> selConfig) {
//		DesiredCapabilities cap = new DesiredCapabilities();
//		String [] appiumDeviceConfig = selConfig.get("mobileDevice").split(":"); 
//		
//		cap.setCapability("deviceName", appiumDeviceConfig[0]);
//		cap.setCapability("device", appiumDeviceConfig[1] );
//		cap.setCapability("platformName", appiumDeviceConfig[1]);
//		cap.setCapability("app", appiumDeviceConfig[2]);
//		cap.setCapability(CapabilityType.VERSION, "5.0.2");
//		cap.setCapability(CapabilityType.PLATFORM, "Windows");
//		capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
//		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"120");
//		
//		String appiumServerHostUrl = selConfig.get("appiumServer");
//		URL appiumServerHost = null;
//		try {
//			appiumServerHost = new URL(appiumServerHostUrl);
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
//		cap.setJavascriptEnabled(true);
//		System.out.println(appiumServerHostUrl);
//		
//        AndroidDriver driverAndroid =new AndroidDriver(appiumServerHost, cap);
//		
//		Set<String> contextNames = driverAndroid.getContextHandles();
//		for (String contextName : contextNames) {
//			System.out.println(contextName);
//			if (contextName.contains("WEBVIEW")) {
//				driverAndroid.context(contextName);
//			}
//		}
//		
//		WebDriver driver = driverAndroid;
//		
//		return driver;
//
//	 //return new  RemoteWebDriver(appiumServerHost, cap);
//		
//	}
	
	
	private WebDriver setMobileDriver(Map<String, String> selConfig) {
		DesiredCapabilities cap = new DesiredCapabilities();
		
		String apkpath="C:/Users/abhishekpalsingh/Downloads/presentation-dev-debug.apk";
		File app=new File(apkpath);
		
		String [] appiumDeviceConfig = selConfig.get("mobileDevice").split(":"); 
		
		cap.setCapability("deviceName", appiumDeviceConfig[0]);
		cap.setCapability("device", appiumDeviceConfig[1] );
		cap.setCapability("platformName", appiumDeviceConfig[1]);
		//cap.setCapability("app-package", "com.flipkart.android");
		//cap.setCapability("app-activity", "com.flipkart.android.activity.SplashActivity");
		cap.setCapability("app", app.getAbsolutePath());
		
		String appiumServerHostUrl = selConfig.get("appiumServer");
		URL appiumServerHost = null;
		try {
			appiumServerHost = new URL(appiumServerHostUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		cap.setJavascriptEnabled(true);
		System.out.println(appiumServerHostUrl);
		
        AndroidDriver driverAndroid =new AndroidDriver(appiumServerHost, cap);
		
		Set<String> contextNames = driverAndroid.getContextHandles();
//		for (String contextName : contextNames) {
//			System.out.println(contextName);
//			if (contextName.contains("NATIVE")) {
//				driverAndroid.context(contextName);
//			}
//		}
		
		WebDriver driver = driverAndroid;
		
		return driver;

	 //return new  RemoteWebDriver(appiumServerHost, cap);
		
	}
	
	private WebDriver setMobileDriver_IOS(Map<String, String> selConfig) {
		DesiredCapabilities cap = new DesiredCapabilities();
		String [] appiumDeviceConfig = selConfig.get("mobileDevice").split(":"); 
		
		cap.setCapability("deviceName", appiumDeviceConfig[0]);
		cap.setCapability("device", appiumDeviceConfig[1] );
		cap.setCapability("platformName", appiumDeviceConfig[1]);
		cap.setCapability("app", appiumDeviceConfig[2]);
		cap.setCapability(CapabilityType.VERSION, "5.0.2");
		cap.setCapability(CapabilityType.PLATFORM, "Windows");
		capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
		
		String appiumServerHostUrl = selConfig.get("appiumServer");
		URL appiumServerHost = null;
		try {
			appiumServerHost = new URL(appiumServerHostUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		cap.setJavascriptEnabled(true);
		System.out.println(appiumServerHostUrl);
		return new  RemoteWebDriver(appiumServerHost, cap);
		
	}
	
	private WebDriver setAndroidDriver(Map<String, String> selConfig) {
		DesiredCapabilities cap = new DesiredCapabilities();
		String [] appiumDeviceConfig = selConfig.get("mobileDevice").split(":"); 
		
		cap.setCapability("deviceName", appiumDeviceConfig[0]);
		cap.setCapability("device", appiumDeviceConfig[1] );
		cap.setCapability("platformName", appiumDeviceConfig[1]);
		cap.setCapability("app", appiumDeviceConfig[2]);
		cap.setCapability(CapabilityType.VERSION, "5.0.2");
		cap.setCapability(CapabilityType.PLATFORM, "Windows");
		String appiumServerHostUrl = selConfig.get("appiumServer");
		URL appiumServerHost = null;
		try {
			appiumServerHost = new URL(appiumServerHostUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		cap.setJavascriptEnabled(true);
		System.out.println(appiumServerHostUrl);
		return new  AndroidDriver(appiumServerHost, cap);
		
	}

}

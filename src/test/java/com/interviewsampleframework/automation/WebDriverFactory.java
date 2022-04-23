/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interviewsampleframework.automation;


import java.util.Map;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.Reporter;

public class WebDriverFactory {

    private String browser = "";

    public WebDriverFactory() {
    }

    public WebDriverFactory(String browserName) {
        browser = browserName;
    }


    public WebDriver getDriver(Map<String, String> seleniumConfig) {

        if (browser == null || browser.isEmpty()) {
            browser = seleniumConfig.get("browser").trim();
        }

        Reporter.log("[INFO]: The test Browser is " + browser.toUpperCase()
                + " !!!", true);

        if (seleniumConfig.get("seleniumServer").equalsIgnoreCase("local")) {
            if (browser.equalsIgnoreCase("chrome")) {
                return getChromeDriver();
            }
        }
        return null;
    }


    private static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}

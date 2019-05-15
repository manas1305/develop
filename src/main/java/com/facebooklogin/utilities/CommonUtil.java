package com.facebooklogin.utilities;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * This class holds the data for Common utility functions.
 *
 */
public class CommonUtil {

	/**
	 * Get Browser Driver Configuration.
	 * 
	 * @return {@link RemoteWebDriver}
	 */
	public  RemoteWebDriver getBrowserDriverConfiguration() {
		RemoteWebDriver driver = null;
		String browserType = PropertiesUtil.getProprty("Browser");
		if (browserType.equals("FF")) {
			driver = new FirefoxDriver();
			Assert.assertTrue("Firefox Driver Initiated successfully.", true);
		} else if (browserType.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			Assert.assertTrue("Chrome Driver Initiated successfully.", true);
		} else if (browserType.equals("Phantom")) {
			DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
			capabilities.setCapability("phantomjs.cli.args", Collections.singletonList("--ignore-ssl-errors=yes"));
			driver = new PhantomJSDriver(capabilities);
			Assert.assertTrue("Phantom Driver Initiated successfully.", true);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

}

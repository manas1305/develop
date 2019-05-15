package com.facebooklogin.pages;

import java.util.ArrayList;


import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import com.facebooklogin.utilities.Constants;



/**
 * This class holds the data for Launch Page.
 *
 */
public class LaunchPage extends com.facebooklogin.base.BasePage {
	/**
	 * Constructor with 4 parameters.
	 * 
	 * @param driver {@link RemoteWebDriver}
	 * @param testcaseName String
	 * @param screenShotNumber int
	 * @param TestStep {@link ArrayList}
	 */
	public LaunchPage(RemoteWebDriver driver, String testcaseName, int screenShotNumber, ArrayList<String> TestStep) {
		super(driver, testcaseName, screenShotNumber, TestStep);
	}

	/**
	 * Navigate to Facebook.
	 * 
	 * @return {@link SignupPage}
	 */
	public SignupPage navigateToFacebook() {
		// test.log(LogStatus.INFO, "Entering
		// URL--"+Constants.getEnvDetails().get("url"));
		try{
		driver.get(Constants.getEnvDetails().get("url"));
		
	
		Assert.assertTrue("Navigated to Facebook Page Successfully", true);
		SignupPage loginpage = new SignupPage(driver, testcaseName, screenShotNumber, TestStep);
		PageFactory.initElements(driver, loginpage);
		return loginpage;
		}
		catch(Throwable t){
			t.printStackTrace();
			Assert.assertFalse("Navigation to Facebook Page UnSuccessful", false);
			return null;
		}
	}
}
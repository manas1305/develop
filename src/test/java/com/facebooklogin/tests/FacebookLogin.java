package com.facebooklogin.tests;

import java.util.ArrayList;
import java.util.Hashtable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.facebooklogin.fetchdata.TestData;
import com.facebooklogin.utilities.CommonUtil;
import com.facebooklogin.utilities.Constants;
import com.facebooklogin.utilities.RandomNumberUtil;
import com.facebooklogin.pages.*;
public class FacebookLogin 
{

	public RemoteWebDriver driver;
	public String testcaseName = null;
	Hashtable<String, String> data;
	RandomNumberUtil random;
	public String firstName=null;
	public String lastName=null;
	public String mobileNumber=null;
	public String password=null;
	LaunchPage launchPage;
	SignupPage signupPage;
	@SuppressWarnings("static-access")
	@Before
	public void beforeTest()
	{
		 CommonUtil commonUtil = new CommonUtil();
		 driver = commonUtil.getBrowserDriverConfiguration();
		 testcaseName = "FacebookLogin";
		 System.out.println(testcaseName + " - initiated test");
		 TestData testData = new TestData(testcaseName);
		 data = testData.getTestData();
		 firstName=data.get("firstName")+random.generatefirstNameAndLastName();
		 lastName=data.get("lastName") + random.generatefirstNameAndLastName();
		 mobileNumber=random.generateMobileNumber(6);
		 password=random.generatePassword();
		 
	}
	@Test
	public void createFacebookAccount()
	{
		launchPage = new LaunchPage(driver, testcaseName, Constants.INTEGER_ONE, new ArrayList<String>());
		signupPage = launchPage.navigateToFacebook();
		signupPage.enterFirstName(firstName);
		signupPage.enterLasttName(lastName);
		signupPage.enterEmailId(mobileNumber);
		signupPage.enterPassword(password);
		signupPage.enterDay(Integer.parseInt(data.get("Day")));
		signupPage.enterMonth(Integer.parseInt(data.get("Month")));
		signupPage.enterYear(Integer.parseInt(data.get("Year")));
		signupPage.selectGenderFemale();
		signupPage.clickSignUp();
	}
	
	@After
	public void afterTest()
	{
		driver.quit();
	}
}

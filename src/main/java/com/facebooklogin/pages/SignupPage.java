package com.facebooklogin.pages;

import java.util.ArrayList;
import java.util.Hashtable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebooklogin.base.BasePage;
import com.facebooklogin.locators.Locators;
import com.facebooklogin.utilities.Constants;



/**
 * This class holds the data for Login Page.
 *
 */
@SuppressWarnings("unused")
public class SignupPage extends BasePage {
	@FindBy(xpath = Locators.firstName)
	public WebElement firstName;
	@FindBy(xpath = Locators.lastName)
	public WebElement lastName;
	@FindBy(xpath = Locators.emailID)
	public WebElement emailId;
	@FindBy(xpath = Locators.password)
	public WebElement password;
	
	@FindBy(xpath = Locators.day)
	public WebElement day;
	@FindBy(xpath = Locators.month)
	public WebElement month;
	@FindBy(xpath = Locators.year)
	public WebElement year;
	@FindBy(xpath = Locators.selectMale)
	public WebElement male;
	@FindBy(xpath = Locators.selectFemale)
	public WebElement female;
	@FindBy(xpath = Locators.signUp)
	public WebElement signUp;
	/**
	 * Constructor with 4 parameters.
	 * 
	 * @param driver {@link RemoteWebDriver}
	 * @param testcaseName {@link String}
	 * @param screenShotNumber int
	 * @param Teststep {@link ArrayList}
	 */
	public SignupPage(RemoteWebDriver driver, String testcaseName, int screenShotNumber, ArrayList<String> Teststep) {
		super(driver, testcaseName, screenShotNumber, Teststep);
	}
	
	public void enterFirstName(String name)
	{
		try{
		setValueInTextField(firstName, name);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void enterLasttName(String name)
	{
		try{
		setValueInTextField(lastName, name);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void enterEmailId(String mob)
	{
		
	try{
		setValueInTextField(emailId, mob);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void enterPassword(String pwd)
	{
		
	try{
		setValueInTextField(password, pwd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void enterDay(int count)
	{
		
	try{
		selectValueFromDropDownFieldByCount(day,count);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void enterMonth(int count)
	{
		
	try{
		selectValueFromDropDownFieldByCount(month, count);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void enterYear(int count)
	{
		
	try{
		selectValueFromDropDownFieldByCount(year, count);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void selectGenderFemale()
	{
		
	try{
		if(isElementDisabled(female))
			System.out.println("Element Enabled? "+isElementDisabled(female));
		waitForSeconds(5);
		click(female);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void selectGenderMale()
	{
		
	try{
		if(isElementDisabled(male))
			System.out.println("Element Enabled? "+isElementDisabled(male));
		waitForSeconds(5);
		click(male);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void clickSignUp()
	{
		
	try{
		waitForSeconds(10);
		click(signUp);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

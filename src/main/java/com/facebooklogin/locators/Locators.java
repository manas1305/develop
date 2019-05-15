package com.facebooklogin.locators;

/**
 * This class will contain locator information for all remedy pages.
 * 
 *
 */
public class Locators {
	
	public static final String firstName="//input[@name='firstname']";
	public static final String lastName="//input[@name='lastname']";
	public static final String emailID="//input[@name='reg_email__']";
	public static final String password="//input[@name='reg_passwd__']";
	public static final String day="//select[@aria-label='Day']";
	public static final String month="//select[@aria-label='Month']";
	public static final String year="//select[@aria-label='Year']";
	public static final String selectFemale="(//span[@data-name='gender_wrapper']//input[@name='sex'])[1]";
	public static final String selectMale="(//span[@data-name='gender_wrapper']//input[@name='sex'])[2]";
	public static final String signUp="//*[@type='submit'][@name='websubmit']";
	
}

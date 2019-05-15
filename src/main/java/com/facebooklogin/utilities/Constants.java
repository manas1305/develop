package com.facebooklogin.utilities;

import java.util.Hashtable;

import org.openqa.selenium.remote.RemoteWebDriver;



/**
 * This class will hold constant data.
 * 
 * @author manastandon
 *
 */
public final class Constants {
	public static final int INTEGER_ONE = 1;

		public static final String SCREENSHOT_PATH = System.getProperty("user.dir")
				+ PropertiesUtil.getProprty("screenshots");

		// Test Executable configurations
		public static String TEST_EXECUTABLE_YAML = System.getProperty("user.dir")
				+ PropertiesUtil.getProprty("testExecutableYamlpath");
		public static boolean REMEDYLOGIN_STATUS = false;
		public static final String RUNMODE_TESTDATA = "Runmode";

		public static String BROWSER = PropertiesUtil.getProprty("Browser");
		public static final String ENV = PropertiesUtil.currentEnvironment;
		
		public static int SCREENSHOT_NUMBER;
		public static String TESTCASENAME;
		public static RemoteWebDriver driver;
	
		// URL
		public static final String FaceBook_URL = PropertiesUtil.getProprty("FaceBook_URL");
		
		// Waits
		public static final int EXPLICIT_WAITSHORT = 2;
		public static final int EXPLICIT_WAITMEDIUM = 5;
		public static final int EXPLICIT_WAITLARGE = 10;
		public static final int IMPLICIT_WAIT = 30;
		public static final int IMPLICIT_WAITLARGE = 60;
		public static final int FLUENT_WAIT = 10;
		public static final int EXPLICIT_EXTREMELARGE = 960;
		public static final int EXPLICIT_MEDIUMLARGE = 600;
		public static final int EXPLICIT_EXTREMEMEDIUM = 180;
		
		//
		public static Hashtable<String, String> table = null;

		public static Hashtable<String, String> getEnvDetails() {
			if (table == null) {
				table = new Hashtable<String, String>();
				table.put("url", FaceBook_URL);
				
			}
			return table;
		}
		
		
}

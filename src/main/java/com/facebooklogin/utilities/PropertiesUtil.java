package com.facebooklogin.utilities;

import java.io.InputStream;
import java.util.Properties;

/**
 * This class holds the utility function for Property file data pickup.
 *
 */
@SuppressWarnings("serial")
public class PropertiesUtil extends Properties {

	public static String currentEnvironment = null;

	/**
	 * Get Current Environment Name.
	 * 
	 * @return String
	 */
	public static String getCurrentEnvironmentName() {
		// Below command to execute from command line parameter -Denv=ENV_NAME
		currentEnvironment ="loginData";

		if (currentEnvironment == null || currentEnvironment == "") {
			Properties propMainEnvFile = new Properties();
			InputStream inputStreamMain = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("configurations/loginData.properties");
			try {
				propMainEnvFile.load(inputStreamMain);
				currentEnvironment = propMainEnvFile.getProperty("loginData");
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}

		return currentEnvironment;
	}

	/**
	 * Get Property.
	 * 
	 * @param key String
	 * @return String
	 */
	public static String getProprty(String key) {
		String config = "configurations/" + getCurrentEnvironmentName() + ".properties";
		Properties properties = new Properties();
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(config);
		try {
			properties.load(inputStream);
			inputStream.close();
		} catch (Throwable t) {
			t.printStackTrace();
		}
		String value = properties.getProperty(key);
		return value;
	}

}

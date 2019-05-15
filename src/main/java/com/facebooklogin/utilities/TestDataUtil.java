package com.facebooklogin.utilities;

import java.util.ArrayList;
import java.util.Hashtable;



/**
 * This class holds the utility function for Test case data management.
 *
 */
public class TestDataUtil {
	
	PropertiesUtil propertiesUtil = new PropertiesUtil();
	

	/**
	 * Get Data from yml file.
	 * 
	 * @param yamlReader {@link YAMLUtil}
	 * @param mapName String
	 * @return Object
	 */
	@SuppressWarnings("unchecked")
	public static Object[][] getData(YAMLUtil yamlReader, String mapName) {
		ArrayList<String> testData = (ArrayList<String>) (yamlReader.map.get(mapName));
		Object[][] data = new Object[1][1];
		Hashtable<String, String> hashTable = new Hashtable<String, String>();
		for (int i = 0; i < testData.size(); i++) {
			String str = testData.get(i);
			String[] split = str.split(":");
			String key = split[0];
			String val = split[1];
			String actualValue = stringReplace(val);
			hashTable.put(key, actualValue);
		}
		data[0][0] = hashTable;
		return data;
	}

	/**
	 * Get Env Data.
	 * 
	 * @param yamlReader {@link YAMLUtil}
	 * @param testcaseName String
	 * @return {@link Hashtable}
	 */
	@SuppressWarnings("unused")
	public static Hashtable<String, String> getEnvData(YAMLUtil yamlReader, String testcaseName) {
		@SuppressWarnings("unchecked")
		ArrayList<String> testData = (ArrayList<String>) (yamlReader.map.get(testcaseName));
		Object[][] data = new Object[1][1];
		Hashtable<String, String> hashTable = new Hashtable<String, String>();
		for (int i = 0; i < testData.size(); i++) {
			String str = testData.get(i);
			String[] split = str.split(":");
			String key = split[0];
			String val = "";
			int splitLength = split.length;
			switch (splitLength) {
			case 2:
				val = split[1];
				break;
			case 3:
				val = split[1] + ":" + split[2];
				break;
			case 4:
				val = split[1] + ":" + split[2] + ":" + split[3];
				break;
			case 5:
				val = split[1] + ":" + split[2] + ":" + split[3] + ":" + split[4];
				break;
			}
			String actualValue = stringReplace(val);
			hashTable.put(key, actualValue);
		}
		return hashTable;
	}

	/**
	 * Get test Data.
	 * 
	 * @param yamlReader {@link YAMLUtil}
	 * @param testcaseName String
	 * @return {@link Hashtable}
	 */
	public static Hashtable<String, String> getTestData(YAMLUtil yamlReader, String testcaseName) {

		return getEnvData(yamlReader, testcaseName);
	}

	/**
	 * Set Data.
	 * 
	 * @param yamlReader {@link YAMLUtil}
	 * @param dataYaml String
	 * @param testcaseName String
	 * @param dataHeader String
	 * @param value String
	 */
	public static void setData(YAMLUtil yamlReader, String dataYaml, String testcaseName, String dataHeader,
			String value) {
		YAMLUtil.setData(yamlReader, dataYaml, testcaseName, dataHeader, value);
	}

	/**
	 * String Replace.
	 * 
	 * @param str String
	 * @return String
	 */
	public static String stringReplace(String str) {
		String reurnString = str.replace("'", "");
		return reurnString;
	}
 }

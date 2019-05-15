package com.facebooklogin.fetchdata;

import java.util.Hashtable;
import org.junit.Assert;
import com.facebooklogin.utilities.PropertiesUtil;
import com.facebooklogin.utilities.TestDataUtil;
import com.facebooklogin.utilities.YAMLUtil;




public class TestData {
	//private static final Logger logger = LogManager.getLogger(IncidentTestData.class.getName());
	private String testcaseName = null;
	private Hashtable<String, String> testData;
	

	public TestData(String testcaseName) {
		this.testcaseName = testcaseName;
	}

	/**
	 * Get Test Data including TestCase data from yml, CorrelationId and environment details.
	 * 
	 * @return {@link Hashtable} data in hashtable format
	 */
	public Hashtable<String, String> getTestData() {
		String createDataYamlpath = System.getProperty("user.dir") + PropertiesUtil.getProprty("DataYaml");
		YAMLUtil createDataYml = new YAMLUtil(createDataYamlpath);
		try {
			testData = TestDataUtil.getTestData(createDataYml, testcaseName);
			Assert.assertTrue("login Data is Fetched from YAML", true);
		} catch (Throwable t) {
			t.printStackTrace();
			Assert.assertFalse("login Data is not Fetched from YAML", false);
			
		}
		return testData;
	}

}

package com.facebooklogin.utilities;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;

/**
 * This class holds the utility function for XML file processing details.
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
public class YAMLUtil {

	public YamlReader reader = null;
	public Object object = null;
	public static YamlWriter writer = null;
	public Map<Object, Object> map = null;

	/**
	 * Constructor.
	 * 
	 * @param path String
	 */
	public YAMLUtil(String path) {
		try {
			reader = new YamlReader(new FileReader(path));
			object = reader.read();
			map = (Map) object;
			reader.close();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	/**
	 * @param yamlReader {@link YAMLUtil}
	 * @param dataYamlPath String
	 * @param arrayList String
	 * @param dataHeader String
	 * @param value String
	 */
	public static void setData(YAMLUtil yamlReader, String dataYamlPath, String arrayList, String dataHeader,
			String value) {

		try {
			ArrayList<String> testData = (ArrayList<String>) (yamlReader.map.get(arrayList));
			Hashtable<String, String> hashTable = new Hashtable<String, String>();
			for (int i = 0; i < testData.size(); i++) {
				String str = testData.get(i);
				String[] split = str.split(":");
				String key = split[0];
				if (key.equals(dataHeader)) {
					testData.set(i, key + ":'" + value + "'");
					break;
				}
			}
			writer = new YamlWriter(new FileWriter(dataYamlPath));
			writer.write(yamlReader.map);
			writer.close();
		} catch (Throwable t) {
			t.printStackTrace();
		}

	}

}

package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * Configuration Reader
 * Responsible for:
 * - Reading configuration values
 * - Loading config.properties file
 */
public class ConfigReader {

	private static Properties properties;

	static {

		try {

			properties = new Properties();

			FileInputStream file = new FileInputStream("src/test/resources/config/config.properties");

			properties.load(file);

		} catch (IOException e) {

			throw new RuntimeException("Failed to load config.properties file", e);
		}
	}

	public static String getProperty(String key) {

		return properties.getProperty(key);
	}
}
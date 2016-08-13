package com.im.framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SqlReader {

	private static final Logger LOGGER = LoggerFactory.getLogger(SqlReader.class);

	public static String fileName = "sql/sql.properties";
	
	private static SqlReader sqlReader = new SqlReader();

	private static Properties properties;

	/**
	 * Instantiates a new CEP error resource bundle.
	 * 
	 * @throws IOException
	 */
	private SqlReader (){

		properties = new Properties();
		InputStream inputStream = SqlReader.class.getClassLoader().getResourceAsStream(fileName);
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			LOGGER.error("Unable to load CEPErrors properties" + e.getMessage());
		}
	}

	/**
	 * Gets the single instance of CEPErrorResourceBundle.
	 *
	 * @return single instance of CEPErrorResourceBundle
	 */
	public static SqlReader getInstance () {
		return sqlReader;
	}

	/**
	 * Gets the error message by key.
	 *
	 * @param key
	 *            the key
	 * @return the message by key
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static String getMessageByKey (String key) {

		return (String) properties.get(key);
	}
	
	

}

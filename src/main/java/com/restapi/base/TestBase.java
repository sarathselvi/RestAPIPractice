package com.restapi.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestBase {
	public static Properties prop;
	public int RESPONSE_STATUS_CODE_200 = 200;
	public int RESPONSE_STATUS_CODE_500 = 500;
	public int RESPONSE_STATUS_CODE_400 = 400;
	public int RESPONSE_STATUS_CODE_401 = 401;
	public int RESPONSE_STATUS_CODE_201 = 201;

	public TestBase() {

		System.out.println("insidae const");

		try {

			prop = new Properties();
			InputStream ip = new FileInputStream(
					"C:\\Users\\Sarath\\git\\RestAPIPractice\\src\\main\\java\\com\\restapi\\config\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String testMethod() {
		return prop.getProperty("url");
	}

}

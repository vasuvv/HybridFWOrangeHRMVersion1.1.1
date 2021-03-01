package com.computech.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProvider {
	
	Properties pro;
	
	public ConfigProvider() {
		try {
			FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\Config\\Configuration.properties"));
			pro = new Properties();
			pro.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public String getValue(String key) {
		//return pro.getProperty(key);
		String value = pro.getProperty(key);
		return value;
	}
	public String getStagingURL() {
		return pro.getProperty("StagingUrl");
	}
	public String getBrowser() {
		return pro.getProperty("browser");
	}
	public void loadConfigurationFile() {
		
	}
}

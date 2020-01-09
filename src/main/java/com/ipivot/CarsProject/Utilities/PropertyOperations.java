package com.ipivot.CarsProject.Utilities;

import java.util.Properties;

public class PropertyOperations {

	Properties prop = new Properties();
	public PropertyOperations() {
		try {
			prop.load(PropertyOperations.class.getResourceAsStream("/propertiesFiles/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getPropertyValueByKey(String key) {
		String str = prop.getProperty(key);
		if(str == null || str =="") {
			System.out.println("Value found null or blank in properties file for key:" + key);
		}
		return str;
	}
	
}

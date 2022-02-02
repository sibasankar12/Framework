package com.crm.generic;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {

	/**
	 * this is used to read the data from commonData.properties file based on key which you pass as an argument
	 * @param key
	 * @return
	 * @throws Throwable
	 */
		public String getPropertyKeyValue(String key) throws Throwable 
		{
			FileInputStream fis=new FileInputStream("./ExternalData/Commondata.property");
	         Properties p=new Properties();
	         p.load(fis);
	         String value = p.getProperty(key);
	         return value;
	         
		}

	}
	
	
	

package com.crm.autodesk.GenericLibraries;

import java.io.FileInputStream;
import java.util.Properties;

/*
 * 
 * this class contains generic method to read data from property file
 * @author girija
 * 
 * 
 */




public class PropertyFileutility {
	/*
	 * this method read data from property file
	 * @throws throwable
	 * 
	 */
 public String getPropertyFileData(String key) throws Throwable {
	 FileInputStream fis =new FileInputStream(IPathConstants.PropertyFilePath);
	 Properties p = new Properties();
	 p.load(fis);
	 String value = p.getProperty(key);
	 return value;
	 
 }
}

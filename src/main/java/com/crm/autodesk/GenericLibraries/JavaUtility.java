package com.crm.autodesk.GenericLibraries;

import java.util.Random;

/*
 * this class contains generic methods pertaining to java
 * @author girija
 * 
 * 
 */
public class JavaUtility {
	/*
	 * 
	 * this method generate random number
	 */
	public int getRandomNumber() {
		Random ran = new Random();
		int RandomNum = ran.nextInt(1000);
		return RandomNum;
	}

}

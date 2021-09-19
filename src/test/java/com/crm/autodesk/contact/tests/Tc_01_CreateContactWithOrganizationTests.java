package com.crm.autodesk.contact.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLibraries.ExcelUtility;
import com.crm.autodesk.GenericLibraries.JavaUtility;
import com.crm.autodesk.GenericLibraries.Jsonutility;
import com.crm.autodesk.GenericLibraries.WebdriverUtility;

public class Tc_01_CreateContactWithOrganizationTests {
	WebDriver driver;
	@Test
	public void createContactWithOrganization() throws Throwable{
		
		
		//read all the necessary data
		Jsonutility jsu = new Jsonutility();
		JavaUtility ju = new JavaUtility();
		WebdriverUtility wu = new WebdriverUtility();
		ExcelUtility eu = new ExcelUtility();
		
		String URL =jsu.readDATAFromJSON("url");
		String USERNAME =jsu.readDATAFromJSON("username");
		String PASSWORD =jsu.readDATAFromJSON("password");
		String BROWSER =jsu.readDATAFromJSON("browser");
		
		String contactname =eu.getDataFromExcel("contacts", 1, 1);
		String orgname =eu.getDataFromExcel("contacts",1, 3);
		
		//Launch the browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			
		} else if(BROWSER.equalsIgnoreCase("firefox")){

			driver = new FirefoxDriver();
		}else {
			System.out.println("invalid browser");
		}
		
		//wu.waitUntilPageLoad(driver);
		wu.maximizeWindow(driver);
		driver.get(URL);
		
		//login to application 
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("submitButton")).click();
		
		//click on contact
		 driver.findElement(By.linkText("Contacts")).click();
		 
		 //click on create contact
		 driver.findElement(By.xpath("//img[@title ='Create Contact...']")).click();
		 
		 //create contact
		 driver.findElement(By.name("lastname")).sendKeys(contactname);
		 driver.findElement(By.xpath("//img[@title='Select']")).click();
		 
		 //switch to child window
		 wu.switchToWindow(driver, "Accounts");
		 driver.findElement(By.id("search_txt")).sendKeys(orgname);
		 driver.findElement(By.name("search")).click();
		 driver.findElement(By.linkText("Dormitary")).click();
		 
		 //switch back to parent window
		 wu.switchToWindow(driver, "Contacts");
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		// wu.waitForElementToBeVisible(driver, );
		//logout
		 WebElement ele = driver.findElement(By.xpath
			        ("//span[text()=' Administrator']/../following-sibling::td[1]/img"));
		 wu.mouseOver(driver, ele);
		 
		 driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
		 
		 driver.close();
		 
	}
}


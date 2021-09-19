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

public class TC_02_CreateOrganizationWithIndustry {
	WebDriver driver;
	@Test
	public void createOrganization() throws Throwable {
		
		//read all the necessary data
				Jsonutility jsu = new Jsonutility();
				JavaUtility ju = new JavaUtility();
				WebdriverUtility wu = new WebdriverUtility();
				ExcelUtility eu = new ExcelUtility();
				
				String URL =jsu.readDATAFromJSON("url");
				String USERNAME =jsu.readDATAFromJSON("username");
				String PASSWORD =jsu.readDATAFromJSON("password");
				String BROWSER =jsu.readDATAFromJSON("browser");
				
				
				String orgname =eu.getDataFromExcel("productname", 1, 3);
				
				//Launch the browser
				if (BROWSER.equalsIgnoreCase("chrome")) {
					driver = new ChromeDriver();
					
				} else if(BROWSER.equalsIgnoreCase("firefox")){

					driver = new FirefoxDriver();
				}else {
					System.out.println("invalid browser");
				}
				
				wu.waitUntilPageLoad(driver);
				wu.maximizeWindow(driver);
				driver.get(URL);
				
				//login to application 
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				 driver.findElement(By.id("submitButton")).click();
				
				 //click on organization
				 driver.findElement(By.linkText("Organizations")).click();
				 
				 //click on create organization
				 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
				 
				 //create organization with industry type as education
				 driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys
				 														(orgname + ju.getRandomNumber());
				 WebElement edu = driver.findElement(By.name("industry"));
				 wu.select(edu, "Education");
				 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				 
				 WebElement Wb = driver.findElement(By.className("dvHeaderText"));
//				 wu.waitForElementToBeVisible(driver, Wb);
				 //logout
				 WebElement ele = driver.findElement(By.xpath
					        ("//span[text()=' Administrator']/../following-sibling::td[1]/img"));
				 wu.mouseOver(driver, ele);
				 
				 driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
				 driver.close();

 }
}


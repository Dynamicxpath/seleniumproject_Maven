package com.crm.autodesk.contact.tests;

import java.util.List;

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

public class Tc_03_CreateProductWithProductsPartNumberTests {
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
				
				String productname  = eu.getDataFromExcel("PART", 1, 2);
				String partnumber = eu.getDataFromExcel("PART", 1, 3);
				
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
				 
				 //click on products
				 driver.findElement(By.linkText("Products")).click();
				 
				 //click on create product
				 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
				 
				 //create product with part number
				 driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productname);
				 driver.findElement(By.xpath("//input[@id='productcode']")).sendKeys(partnumber);
				 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				 
				 
				 
				 //capture product number
				 String pr= driver.findElement(By.xpath("(//td[@class='dvtCellInfo'])[2]")).getText();
				 System.out.println(pr);
				 
				 //click on products
				 driver.findElement(By.linkText("Products")).click();
				 
				 driver.findElement(By.cssSelector("[name='search_text']")).sendKeys(partnumber);
				 //search for product created 
				 WebElement wb = driver.findElement(By.xpath("//select[@name='search_field']"));
				// wu.select(wb, "Part Number");
				 wu.select(wb, "productcode");
				 
				 driver.findElement(By.xpath("(//input[@class='crmbutton small create'])[1]")).click();
				 
				// driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(productname);
				 List<WebElement> abc = driver.findElements(By.xpath("//tr[@bgcolor='white']/td[2]"));

				 for(WebElement s : abc)
				 {
				 if(pr.contains(s.getText()))
				 {
				 System.out.println("test script pass");
				 break;
				 }
				 }

				 WebElement ele = driver.findElement(By.xpath
					        ("//span[text()=' Administrator']/../following-sibling::td[1]/img"));
				 wu.mouseOver(driver, ele);
				 
				 driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
				 driver.close();

				 
	}
}


package com.crm.autodesk.GenericLibraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.autodesk.contact.elementRepository.HomePage;
import com.crm.autodesk.contact.elementRepository.LoginPage;

public class BaseClass {
	
	public Jsonutility jsu = new Jsonutility();
	public JavaUtility ju = new JavaUtility();
	public WebdriverUtility wu = new WebdriverUtility();
	public ExcelUtility eu = new ExcelUtility();
    //public DatabaseUtility dbLip = new DatabaseUtility();
    
	 public WebDriver driver;
	 public static WebDriver staticdriver;
	 
	 
	 @BeforeSuite(groups= {"SmokeSuite","RegressionSuite"} )
	 public void connectDB()
	 {
		 //dbLip.connectToDB();
		 System.out.println("=====makeDBconnected======");
		 
	 }
	 
	 @BeforeClass(groups= {"SmokeSuite","RegressionSuite"} )
	 public void launchBrowser() throws Throwable {
		 System.out.println("=====launchBrowser======");
		 String BROWSER = jsu.readDATAFromJSON("browser");
		 String URL = jsu.readDATAFromJSON("url");
		 
		   System.out.println("Launch the browser");
		   
			if (BROWSER.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
				
			} else if(BROWSER.equalsIgnoreCase("firefox")){

				driver = new FirefoxDriver();
			}else {
				System.out.println("invalid browser");
			}
			wu.maximizeWindow(driver);
			wu.waitUntilPageLoad(driver);
			staticdriver= driver;
			driver.get(URL);
			
	 }
	 @BeforeMethod(groups= {"SmokeSuite","RegressionSuite"} )
	 public void loginToApp() throws Throwable {
		 System.out.println("======LOGINTOAPP=======");
		String USERNAME = jsu.readDATAFromJSON("username");
		 String PASSWORD = jsu.readDATAFromJSON("password");
		 LoginPage lp = new LoginPage(driver);
		 lp.login(USERNAME, PASSWORD);
		 
	 }
	 
	 @AfterMethod(groups= {"SmokeSuite","RegressionSuite"} )
	 public void logoutFromApp() throws Throwable {
		 System.out.println("====logout from app=====");
		 HomePage hp = new HomePage(driver);
		 hp.signout(driver);
	 }
	 @AfterClass(groups= {"SmokeSuite","RegressionSuite"} )
	 public void closeTheBrowser() {
	 driver.close();
	 
	 
	 }
	 @AfterSuite(groups= {"SmokeSuite","RegressionSuite"} )
	 public void closeTheDB() {
		// dblip.conne
		 System.out.println("=====makeDBClosed======");
	 }
	 public String getscreenshot(String name) throws IOException {
	 File srcfile = ((TakesScreenshot) staticdriver).getScreenshotAs(OutputType.FILE);
	 String destfile = System.getProperty("user.dir")+"/Screenshots/" + name+".png";
	 File finaldest = new File (destfile);
	 FileUtils.copyFile(srcfile,finaldest);
	 return destfile;
}
}

	 
	 


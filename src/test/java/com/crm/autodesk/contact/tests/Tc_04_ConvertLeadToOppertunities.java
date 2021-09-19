package com.crm.autodesk.contact.tests;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLibraries.BaseClass;
import com.crm.autodesk.contact.elementRepository.ConvertLead;
import com.crm.autodesk.contact.elementRepository.CreatingNewLead;
import com.crm.autodesk.contact.elementRepository.HomePage;
import com.crm.autodesk.contact.elementRepository.LeadPage;
import com.crm.autodesk.contact.elementRepository.LeadPageInfo;



//@Listeners(com.crm.autodesk.GenericLibraries.Listener.class)
public class Tc_04_ConvertLeadToOppertunities extends BaseClass {

	@Test(groups= "SmokeSuite",retryAnalyzer =com.crm.autodesk.GenericLibraries.RetryAnalyser.class )
	public void convertLeadToOppertunities() throws Throwable{
		
	//read all the necessary data
//			 Jsonutility jsu = new Jsonutility();
//			 JavaUtility ju = new JavaUtility();
//			 WebdriverUtility wu = new WebdriverUtility();
//		     ExcelUtility eu = new ExcelUtility();
//			
//			String URL =jsu.readDATAFromJSON("url");
//			String USERNAME =jsu.readDATAFromJSON("username");
//			String PASSWORD =jsu.readDATAFromJSON("password");
//			String BROWSER =jsu.readDATAFromJSON("browser");
//			
//			String lastname =eu.getDataFromExcel("lead", 1, 2);
//			String companyname =eu.getDataFromExcel("lead",1, 3);
//			
//			
//			 
//		//Launch the browse
//			if (BROWSER.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//				
//			} else if(BROWSER.equalsIgnoreCase("firefox")){
//
//				driver = new FirefoxDriver();
//			}else {
//				System.out.println("invalid browser");
//			}
//			wu.waitUntilPageLoad(driver);
//			wu.maximizeWindow(driver);
//			driver.get(URL);
//			
//           LoginPage lp = new LoginPage(driver);
//            lp.login(USERNAME, PASSWORD);
			
		    HomePage hp= new HomePage(driver);
			hp.clickOnLeads();
			
			LeadPage Lp = new LeadPage(driver); 
			Lp.CreateLeadimg();
			
			CreatingNewLead cml = new CreatingNewLead(driver);
			cml.enterlastname("lastname");
			cml.entercompanyname("company");
			cml.clickonsubmitbtn();
			
			LeadPageInfo lp1 = new LeadPageInfo(driver);
			String msg =lp1.getLeadInfo1();
			System.out.println(msg);
			lp1.getConvertInfo1();
		
			
			//wu.switchFrame(driver, "genHeaderSmall");
			//wu.switchToWindow(driver, "Convert Lead");
			ConvertLead cl = new ConvertLead(driver);
			String message=cl.convertmsg1();
			Thread.sleep(2000);
			cl.submitBtn1();
	
			//wu.switchToWindow(driver, "Leads");
		
			//cl.clickoncontactcheckbox();
			//cl.clickonorganizationcheckbox();
			
		
			
			System.out.println("pass");
			
		Assert.fail();
			
			
			
			
			
			
			

}
}
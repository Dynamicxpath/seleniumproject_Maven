package com.crm.autodesk.contact.tests;

import org.testng.annotations.Test;

import com.crm.autodesk.GenericLibraries.BaseClass;
import com.crm.autodesk.contact.elementRepository.ConvertLead;
import com.crm.autodesk.contact.elementRepository.CreatingNewLead;
import com.crm.autodesk.contact.elementRepository.HomePage;
import com.crm.autodesk.contact.elementRepository.LeadPage;
import com.crm.autodesk.contact.elementRepository.LeadPageInfo;

public class Tc_07_CreateLeadToOppertunitiesBySelectingAllCheckBox extends BaseClass {
	
	@Test(groups= {"RegressionSuite"})
	public void convertLeadToOppertunities() throws Throwable{
		
	//      read all the necessary data
//			Jsonutility jsu = new Jsonutility();
//			JavaUtility ju = new JavaUtility();
//			WebdriverUtility wu = new WebdriverUtility();
//			ExcelUtility eu = new ExcelUtility();
//			
//			String URL =jsu.readDATAFromJSON("url");
//			String USERNAME =jsu.readDATAFromJSON("username");
//			String PASSWORD =jsu.readDATAFromJSON("password");
//			String BROWSER =jsu.readDATAFromJSON("browser");
//			
//			String lastname =eu.getDataFromExcel("lead", 1, 2) + ju.getRandomNumber();
//			String companyname =eu.getDataFromExcel("lead",1, 3) + ju.getRandomNumber();
//			
//			//Launch the browser
//			if (BROWSER.equalsIgnoreCase("chrome")) {
//				driver = new ChromeDriver();
//				
//			} else if(BROWSER.equalsIgnoreCase("firefox")){
//
//				driver = new FirefoxDriver();
//			}else {
//				System.out.println("invalid browser");
//			}
//			wu.maximizeWindow(driver);
//			driver.get(URL);
//			LoginPage lp = new LoginPage(driver);
//			lp.login(USERNAME, PASSWORD);
			
			HomePage hp= new HomePage(driver);
			hp.clickOnLeads();
			
			LeadPage Lp = new LeadPage(driver); 
			Lp.CreateLeadimg();
			
			CreatingNewLead cml = new CreatingNewLead(driver);
			cml.enterlastname("Nanda");
			cml.entercompanyname("pencil");
			cml.clickonsubmitbtn();
			
			LeadPageInfo lp1 = new LeadPageInfo(driver);
			String msg =lp1.getLeadInfo1();
			System.out.println(msg);
			lp1.getConvertInfo1();
			
			ConvertLead cl = new ConvertLead(driver);
			String msg1=cl.convertmsg1();
			cl.clickonOppertunityCheckbox();
			//cl.clickoncontactcheckbox();
			//cl.clickonorganizationcheckbox();
			cl.submitBtn1();
			String alertmsg =wu.printalertmsg(driver);
			System.out.println(alertmsg);
			wu.acceptAlert(driver);
			
			System.out.println("pass");
		
			
			
	}
}
		





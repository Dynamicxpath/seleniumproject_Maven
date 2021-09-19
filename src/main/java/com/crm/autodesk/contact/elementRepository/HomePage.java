package com.crm.autodesk.contact.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericLibraries.WebdriverUtility;

public class HomePage extends WebdriverUtility{
	WebDriver driver;
	

	@FindBy(linkText="Organizations")
	private WebElement organizationLnk;
	
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorimg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactslnk;
	
	@FindBy(linkText="Emails")
	private WebElement emaillnk;
	
	@FindBy(linkText="Products")
	private WebElement productlnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement Oppurtunitylnk;
	
	@FindBy(linkText="Leads")
	private WebElement leadlnk;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//generate getters
	public WebElement getOrganizitionLnk() {
		return organizationLnk;
	}
	public WebElement getAdministratorImg() {
		return administratorimg;
	}
	public WebElement getSignoutLnk() {
		return signoutLnk;
	}
				
	public WebElement getContactLnk() {
		return contactslnk;
	}
	public WebElement getProductsLnk() {
	    return productlnk;
	}
	public WebElement getOppurtunityLnk() {
		return  Oppurtunitylnk;
	}
	public WebElement getLeadsLnk() {
		return  leadlnk;
	}
	public void clickOnOrganization(){
		organizationLnk.click();
	}
	public void clickOnContacts() {
		contactslnk.click();
	}
	public void clickOnLeads() {
		leadlnk.click();
		
	}
	public void signout(WebDriver driver ) throws Throwable {
		Thread.sleep(5000);
		//waitForElementVisibility(driver, administratorimg);
		mouseOver(driver,administratorimg);
		signoutLnk.click();
		
	}
}
		



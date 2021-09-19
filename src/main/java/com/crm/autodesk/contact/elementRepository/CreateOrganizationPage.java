package com.crm.autodesk.contact.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericLibraries.WebdriverUtility;

public class CreateOrganizationPage extends WebdriverUtility{

		WebDriver driver;
		
		//constructor
		public CreateOrganizationPage(WebDriver driver) {
			
			PageFactory.initElements(driver, this);
		}
		
		//locate all elements
		@FindBy(name = "accountname")
		private WebElement OrgNameEdt;

		@FindBy(name = "industry")
		private WebElement industryDropDown;
		
		@FindBy(xpath = "//input[@value='T']")
		private WebElement assignedToGroupbtn;
		
		@FindBy(name="assigned_group_id")
		private WebElement assignedToDropDown;
			
		@FindBy(name="rating")
		private WebElement ratingDropDown;
			
		@FindBy(name="notify_owner")
		private WebElement notifyownerCheckbox;

		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;

		//provide getters
		public WebElement getOrgNameEdt() {
			return OrgNameEdt;
		}

		public WebElement getIndustryDropDown() {
			return industryDropDown;
		}
		public WebElement getSaveBtn() {
			return saveBtn;
		}	
		
		public void createOrganization(String OrgName) {
			OrgNameEdt.sendKeys(OrgName);
			saveBtn.click();
		}

		//Business logic 1
		/**
		 * This method will create Organization by choosing as industry type
		 */
		public void createOrganizationWithIndustry(String OrgName, String indType) {
			OrgNameEdt.sendKeys(OrgName);
			select(industryDropDown, indType);
				}
		
		//Business logic 2
		/**
		 * This method will create Organization by choosing as Assigned to Group radio btn
		 * @param OrgName
		 * @param MarGroup
		 */
		public void createOrganizationWithAssignedToMarketingGroup
		(String OrgName, String MarGroup)
		{
			OrgNameEdt.sendKeys(OrgName);
			assignedToGroupbtn.click();
			select(assignedToDropDown, MarGroup);
			
		}
		
		// Business logic 3
		public void createOrganizationWithRating(String OrgName, String ActiveRating) {
			OrgNameEdt.sendKeys(OrgName);
			select(ratingDropDown, ActiveRating);

		}
		//ratingDropDown.clear();

		// Business logic 4
		public void createOrganizationWithNotify(String OrgName) {
			OrgNameEdt.sendKeys(OrgName);
			notifyownerCheckbox.click();
		}
		public void createOrganizationWithNotifyUnSelect() {
			notifyownerCheckbox.click();
		}
		public void saveButton() {
			saveBtn.click();
		}
}

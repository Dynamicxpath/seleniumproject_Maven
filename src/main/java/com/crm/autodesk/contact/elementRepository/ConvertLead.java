package com.crm.autodesk.contact.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConvertLead {
	
	
	public ConvertLead(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//form[@name='ConvertLead']//td[contains(text(),'Convert Lead')]")
	private WebElement convertmsg;
	
	public WebElement getConvertmsg() {
		return convertmsg;
	}
	public String convertmsg1() {
		String value =convertmsg.getText();
		return value;
	}
	
	@FindBy(xpath="//input[@name='Save' and @type ='submit' and @value='Save' ] ")
	private WebElement submitBtn;
	
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
		
		public void submitBtn1() {
			 submitBtn.click();
	}
		@FindBy(xpath="//div[@id='orgLay']/table/tbody/descendant::input[@value='Accounts' and @id='select_account']")
		private WebElement clickonorganizationcheckbox;

		@FindBy(xpath="//div[@id='orgLay']/table/tbody/descendant::input[@value='Potentials' and @id='select_potential']")
		private WebElement clickonOppertunitycheckbox;
		
		@FindBy(xpath="//div[@id='orgLay']/table/tbody/descendant::input[@value='Contacts' and @id='select_contact']")
		private WebElement clickoncontactcheckbox;

		public WebElement getClickonorganizationcheckbox() {
			return clickonorganizationcheckbox;
		}
			
		public WebElement getClickonOppertunitycheckbox() {
			return clickonOppertunitycheckbox;
			
		}
		public WebElement getClickoncontactcheckbox() {
			return clickoncontactcheckbox;
		}
		
		public void clickonorganizationcheckbox()
		{
		clickonorganizationcheckbox.click();
		
		}
		public void clickonOppertunityCheckbox() 
		{
			clickonOppertunitycheckbox.click();
		}

		public void clickoncontactcheckbox()
		{
		clickoncontactcheckbox.click();
		}
	
			
		}


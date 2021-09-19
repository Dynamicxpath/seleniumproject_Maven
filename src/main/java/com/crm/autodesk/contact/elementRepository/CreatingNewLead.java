package com.crm.autodesk.contact.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewLead {
		
		@FindBy(name="lastname")
		private WebElement Surname;
		
		@FindBy(name="company")
		private WebElement cmpname;
		
		@FindBy(xpath="//input[@type='submit']")
		private WebElement submitbtn1;
		
		public CreatingNewLead(WebDriver driver) {
			PageFactory.initElements(driver, this);
}

		public WebElement getSurname() {
			return Surname;
		}

		public WebElement getCmpname() {
			return cmpname;
		}

		public WebElement getSubmitbtn1() {
			return submitbtn1;
		}
		
		public void enterlastname(String value)
		{
			Surname.sendKeys(value);
		}
		
		public void entercompanyname(String value)
		{
			cmpname.sendKeys(value);
		}
		
		public void clickonsubmitbtn()
		{
			submitbtn1.click();
		}
		
}

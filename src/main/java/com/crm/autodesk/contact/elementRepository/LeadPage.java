package com.crm.autodesk.contact.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {

	@FindBy(xpath="//img[@alt='Create Lead....']")
	private WebElement createLeadImg;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name= "submit")
	private WebElement submitBtn;
	
	
	public LeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement getCreateLeadImg() {
		return createLeadImg;
	}
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public void CreateLeadimg() {
		createLeadImg.click();
	}
	
}

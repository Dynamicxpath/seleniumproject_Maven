package com.crm.autodesk.contact.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgmsg;

	
	
	public WebElement getOrgmsg() {
		return orgmsg;
	}
	
	public String msg2()
	{
		String value = orgmsg.getText();
		return value;
	}
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgImg;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name= "submit")
	private WebElement submitBtn;
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public void CreateOrgImg() {
		createOrgImg.click();
	}
}

package com.crm.autodesk.contact.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPageInfo {
	
	//constructor
	public LeadPageInfo(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	//locate all elements
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement leadInfo;
	
	@FindBy(xpath = "//a[text()='Convert Lead']")
	private WebElement convertInfo;

	// provide getters
	public WebElement getLeadInfo() {
		return leadInfo;
	}

	public WebElement getConvertInfo() {
		return convertInfo;
	}
	
	/**
	 * get organization information
	 */
	public String getLeadInfo1() {
		
		String value = leadInfo.getText();		
		return value;
	}
	/**
	 * convert information
	 */
	public void getConvertInfo1() {
		
		 convertInfo.click();
	}

}




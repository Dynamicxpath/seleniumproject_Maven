package com.crm.autodesk.contact.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {   //  create a separate class for every page
	
	// create  object repository for every webelement by using @findBy ,@findBys and @findAll method
	
	@FindBy(name="user_name")
	private WebElement username;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id= "submitButton")
	private WebElement loginBtn;
	
	
	
	// use pagefactory class to initialize page objects
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// declare all the Webelements as private and use getters method
	public WebElement getusername() {

		return username;
	}
	public WebElement getpasswordEdt() {
		return passwordEdt;
		
	}
    public WebElement getloginBtn() {
    	return loginBtn;
    }
    public void login(String un, String pwd) {
    	username.sendKeys(un);
    	passwordEdt.sendKeys(pwd);
    	loginBtn.click();
    }
}


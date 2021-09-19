package com.crm.autodesk.GenericLibraries;

import java.util.Iterator;
import java.util.Set;

/*
 * 
 * 
 * this contains all webdriver
 * @author girija
 * 
 * 
 * 
 * 
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {

	/**
	 * this method wait for 20 sec for page loading
	 * 
	 */
   public void waitUntilPageLoad(WebDriver driver)
   {
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   
   }
   
   /**
    * This method wait for the element to be visible
    * 
    * 
    * 
    */
   public void waitForElementVisibility(WebDriver driver,WebElement element)
   {
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.visibilityOf(element));
   }
   /**
    * this methods enables user to handle dropdown using visible text
    * 
    *
    */
       
   public void select(WebElement element, String option)
   {
	   Select select=new Select(element);
	   select.selectByVisibleText(option);
	   
   }
   
   /**
    * this methods enables user to handle dropdown using index
    *
    * 
    */
      
   public void select(WebElement element, int index)
   {
	   Select select=new Select(element);
	   select.selectByIndex(index);   
   }
   
   /**
    * This method will perform mouse over action
    *
    * 
    */
   
   public void mouseOver(WebDriver driver,WebElement element)
   {
	   Actions act = new Actions(driver);
	   act.moveToElement(element).perform();
	   
   }
   /*
    * 
    * this method is done to double click
    * 
    * 
    * 
    */
   public void doubleClick(WebDriver driver,WebElement element)
   {
	   Actions act = new Actions(driver);
	   act.moveToElement(element);
   }
   /**
    * This method performs right click operation 
    * 
    * 
    */
   public void rightClick(WebDriver driver,WebElement element)
   {
	   Actions act = new Actions(driver);
	   act.contextClick(element).perform();
   }
   
   /**
    * This method helps to switch from one window to another
    * 
    * 
    */
   public void switchToWindow(WebDriver driver, String partialWinTitle)
   {
	   Set<String> window = driver.getWindowHandles();
	   Iterator<String> it = window.iterator();
	   while(it.hasNext())
	   {
		   String winId=it.next();
		   String title=driver.switchTo().window(winId).getTitle();
           if(title.contains(partialWinTitle))
           {
        	   break;
           }
		   
	   }
	   
   }
   
   /*
    * 
    * this method is for switch windows
    * 
    * 
    * 
    * 
    */
   public void switchToWindow(WebDriver driver, String mainid, String allid, Set<String> Strings) {
	   String mainid1= driver.getWindowHandle();
	   Set<String> allid1=driver.getWindowHandles();
	   System.out.println(allid1.size());
	   for(String id : allid1) {
		   if(!mainid1.equals(id)) {
			   driver.switchTo().window(id);
		   }
	   }
	   
   }
   /*
    * 
    * this method will print the alert msg
    * 
    * 
    * 
    */
   public String printalertmsg(WebDriver driver) {
	   String value=driver.switchTo().alert().getText();
	   return value;
   }
   /**
    * Accept alert 
    *
    */
   
   public void acceptAlert(WebDriver driver)
   {
	   driver.switchTo().alert().accept();
   }
   
   /**
    * Cancel Alert
    * 
    */
   public void dismissAlert(WebDriver driver)
   {
	   driver.switchTo().alert().dismiss();
   }
   /**
    * This method used for scrolling action in a webpage
    * 
    * 
    */
   
   
    public void switchFrame(WebDriver driver,int index) {
    	driver.switchTo().frame(index);
    }   
    
    public void switchFrame(WebDriver driver,WebElement element) {
    	driver.switchTo().frame(element);
    } 
	
    public void switchFrame(WebDriver driver,String id) {
    	driver.switchTo().frame(id);
    } 


    
    /**
     * pass enter Key appertain in to Browser
     * 
     */
   public void passEnterKey(WebDriver driver) {
	   Actions act = new Actions(driver);
	   act.sendKeys(Keys.ENTER).perform();
   } 

/*
 * 
 * this method will maximize the window
 * 
 * 
 */
    public void maximizeWindow(WebDriver driver)
    {
    	driver.manage().window().maximize();
    }
}





	   
	   




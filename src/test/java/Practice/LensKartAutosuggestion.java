package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLibraries.BaseClass;

public class LensKartAutosuggestion extends BaseClass {
	@Test
	public void lensKartAutoSuggestions() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","E:\\selenium webdriver\\All DRIVERS\\chromedriver.exe");
		
	    WebDriver driver = new ChromeDriver();
	   
	    driver.get("https://www.lenskart.com/");
	    
	    driver.manage().window().maximize();
	    
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("//input[@type='text']")).click();
	    driver.findElement(By.name("q")).click();
	     
	    List <WebElement> lst =driver.findElements(By.xpath("//a"));
	    
	    Thread.sleep(2000);
	    for (WebElement wb:lst) {
	    	System.out.println(wb.getText());
	    }
	    
	    driver.close();
	    
	    Thread.sleep(2000);
	    driver.close();
}

}


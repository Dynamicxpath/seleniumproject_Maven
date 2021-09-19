package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLibraries.Jsonutility;

public class dynamicwebtable {
	
	
	public static void main(String [] args) throws Throwable{
		WebDriver driver = null;

	
	Jsonutility jfu = new Jsonutility();
	String browser = jfu.readDATAFromJSON("browser");
	String url = jfu.readDATAFromJSON("url");
	String username= jfu.readDATAFromJSON("username");
	String password= jfu.readDATAFromJSON("password");
	
	if (browser.equalsIgnoreCase("chrome"))
	{
		 driver = new ChromeDriver();
		
	}
	else if (browser.equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
	
	} else
	{
		System.out.println("invalid browser");
	}
	
	driver.get(url);
	
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.linkText("organizations")).click();
	List<WebElement> list=  driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selectall']"));
	
	for (WebElement s: list)

	{
		s.click();
		break;
	}
	driver.findElement(By.xpath("//table[@class ='lvt small']/tbody/tr[12]/td[1]/input")).click();
}
}

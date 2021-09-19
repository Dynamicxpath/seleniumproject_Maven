package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchGoogleChrome {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\selenium webdriver\\All DRIVERS\\chromedriver.exe");
		
	    WebDriver driver = new ChromeDriver();
	   
	    driver.get("https://www.google.com/");
	    System.out.println(driver.getTitle());

	}

}

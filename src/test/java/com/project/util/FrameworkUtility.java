package com.project.util;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FrameworkUtility {

	public WebDriver launchBrowser(String strExplorer, WebDriver driver){
		if(strExplorer.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\BrowsersExeFiles\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else{
			if(strExplorer.equalsIgnoreCase("IE")){
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\BrowsersExeFiles\\IEDriverServer.exe" );
				driver = new InternetExplorerDriver();
			}
			else{
				driver=new FirefoxDriver();
			}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
}










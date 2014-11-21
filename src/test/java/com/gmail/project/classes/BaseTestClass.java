package com.gmail.project.classes;

import java.util.concurrent.TimeUnit;

//import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.gmail.project.util.Logs;

public class BaseTestClass {
	public WebDriver driver;

	@BeforeMethod
	public void setup(){
//		DOMConfigurator.configure("log4j.xml");
		BasicConfigurator.configure();
		Logs.dynamicApp(System.getProperty("user.dir")+"\\src\\test\\resources\\Logs\\","gmail");
		Logs.start("GMAIL LOGIN");
		driver=new FirefoxDriver();
		Logs.info("driver initialized");
		driver.manage().window().maximize();
		Logs.info("window maximized");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://gmail.com");
		Logs.info("browser launched");
	}
	@AfterMethod
	public void destroy(){
		driver.quit();
		Logs.info("browser closed");
		Logs.end();
	}
}
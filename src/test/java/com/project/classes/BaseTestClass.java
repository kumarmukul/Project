package com.project.classes;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.project.beans.FrameworkUtilityPOJO;
import com.project.util.FrameworkUtility;
import com.project.util.Logs;
import com.project.util.PropertyFile;

public class BaseTestClass {
	public WebDriver driver;

	@BeforeMethod
	public void setup(){
		PropertyFile propertyFile = new PropertyFile();

		// Object Declaration
		FrameworkUtilityPOJO frameworkUtilityPOJO = new FrameworkUtilityPOJO();
		frameworkUtilityPOJO = propertyFile.getFrameworkUtilityPOJO();
		//		DOMConfigurator.configure("log4j.xml");
		BasicConfigurator.configure();
		FrameworkUtility frameworkUtility=new FrameworkUtility();
		//Logs.dynamicApp(System.getProperty("user.dir")+PropertyFile.read("logFilePath","config"),PropertyFile.read("logFileName","config"));
		Logs.dynamicApp(System.getProperty("user.dir")+frameworkUtilityPOJO.getStrLogFilePath(),frameworkUtilityPOJO.getStrLogFileName());
		Logs.start("GMAIL LOGIN");
		//driver=framework.setBrowser(PropertyFile.read("browser","Framework"), driver);	
		Logs.info("window maximized");
		driver = frameworkUtility.launchBrowser(frameworkUtilityPOJO.getStrExplorer(),driver);
		//System.out.println(PropertyFile.read("application","Application"));
		driver.get(frameworkUtilityPOJO.getStrAppURL());
		//driver.get(PropertyFile.read("application","Application"));
		Logs.info("browser launched");
	}

	@AfterMethod
	public void destroy(){
		driver.quit();
		Logs.info("browser closed");
		Logs.end();
	}
}
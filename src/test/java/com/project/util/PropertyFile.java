package com.project.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import com.project.beans.FrameworkUtilityPOJO;
import com.project.beans.LoginPOJO;
import com.project.beans.TestLinkPOJO;



public class PropertyFile {
	// Object Declaration 
	FrameworkUtilityPOJO frameworkUtilityPOJO ;
	LoginPOJO loginPOJO;
	Properties p=new Properties();
	public  Properties read(){
		try {
			p.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Data\\config.properties"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public  FrameworkUtilityPOJO getFrameworkUtilityPOJO()
	{
		p = this.read();
		frameworkUtilityPOJO = new FrameworkUtilityPOJO();
		frameworkUtilityPOJO.setStrExplorer(p.getProperty("browser"));
		frameworkUtilityPOJO.setStrAppURL(p.getProperty("application"));
		frameworkUtilityPOJO.setStrLogFilePath(p.getProperty("logFilePath"));
		frameworkUtilityPOJO.setStrLogFileName(p.getProperty("logFileName"));
		frameworkUtilityPOJO.setStrExcelSheetPath(p.getProperty("excelSheetPath"));
		frameworkUtilityPOJO.setStrExcelSheetName(p.getProperty("excelSheetName"));
		return  frameworkUtilityPOJO;
	}
	
	public LoginPOJO getLoginPOJO(){
		p = this.read();
		loginPOJO = new LoginPOJO();
		loginPOJO.setStrUserName(p.getProperty("username"));
		loginPOJO.setStrPwd(p.getProperty("password"));
		return loginPOJO;
		
	}
	
	public TestLinkPOJO getTestLinkPOJO(){
		p=this.read();
		TestLinkPOJO testLinkPOJO =new TestLinkPOJO();
		testLinkPOJO.setStrTestProject(p.getProperty("testProject"));
		testLinkPOJO.setStrTestPlan(p.getProperty("testPlan"));
		testLinkPOJO.setStrTestCase(p.getProperty("testCase"));
		testLinkPOJO.setStrBuild(p.getProperty("build"));
		return testLinkPOJO;
	}
	
	
}




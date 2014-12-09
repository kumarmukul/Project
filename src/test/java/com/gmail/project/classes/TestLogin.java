package com.gmail.project.classes;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import org.testng.Assert;
import org.testng.annotations.Test;

import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;
import com.gmail.project.pages.HomePage;
import com.gmail.project.pages.LoginPage;
import com.gmail.project.util.Excel;
import com.gmail.project.util.Logs;
import com.gmail.project.util.PropertyFile;
import com.gmail.project.util.ScreenShot;
import com.gmail.project.util.TestLink;

public class TestLogin extends BaseTestClass{ 
	String username = PropertyFile.read("username"); //reading username from property file
	String password = PropertyFile.read("password"); //reading password from property file

	@Test
	public void login() throws IOException, TestLinkAPIException{
		LoginPage login=new LoginPage();
		String notes="",results="",value="";
		HomePage home=new HomePage();
		//setting excel
		Excel.setExcel(System.getProperty("user.dir")+PropertyFile.read("excelSheetPath"), PropertyFile.read("excelSheetName"));
		login.enterUsername(driver,username);
		Logs.info("username entered");
		login.enterPassword(driver,password);
		Logs.info("password entered");
		ScreenShot.screenshots(driver);
		login.signInClicked(driver);
		Logs.info("SignIn button clicked");
		ScreenShot.screenshots(driver);

		DateFormat format=new SimpleDateFormat(" z dd-MM-yyyy hh:mm:ss");
		Date d=new Date();
		String date=format.format(d);
		System.out.println(d);
		try{
			home.searchField(driver);
			Logs.info("Logged in successfully");
			ScreenShot.screenshots(driver);
			results=TestLinkAPIResults.TEST_PASSED; //updating test case status in testlink
			Logs.info("results updated in try block");
			notes="Successfully executed at"+date; //updating notes section in testlink
			Logs.info("notes updated in try block");
			Logs.info("TestCase Passed in try block");
			value="Passed"; //value to be written in Excel

		}
		catch (Exception e) {
			results=TestLinkAPIResults.TEST_FAILED; //upating test case status in testlink
			Logs.info("results updated in catch block");
			notes="Execution failed at"+date +"\n" +e; //updating notes section in testlink
			Logs.info("notes updated in catch block");
			Logs.error("TestCase Failed in catch block");
			value="Failed"; // value to written in Excel

		}
		finally{
			//TestLink.reportResult("GmailNew", "SampleTestPlan", "Login_Valid_Credentials","SampleBuild",notes,results);
			int row=Excel.sheet.getLastRowNum()+1; //calculating number of rows
			int col=Excel.sheet.getRow(0).getLastCellNum(); //calculating number of columns
			for(int i=2;i<row;i++){
				String a[]=new String[col-1];
				for(int j=1;j<col;j++){
					a[j-1]=Excel.getCellValue(i,j);
				}
				TestLink.reportResult(a[0],a[1],a[2],a[3],notes,results); //updating complete test case in testlink	
				Logs.info("finally block executed");
				Logs.info("test case updated in TestLink");
				Excel.putCellValue(System.getProperty("user.dir")+PropertyFile.read("excelSheetPath"),2,5,value); //updating excel sheet 
			}
		}
	}
}



package com.project.util;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

//import testlink.api.java.client.TestLinkAPIClient;
//import testlink.api.java.client.TestLinkAPIException;
//import testlink.api.java.client.TestLinkAPIResults;

import testlink.api.java.client.*;

import com.project.beans.FrameworkUtilityPOJO;
import com.project.beans.LoginPOJO;
import com.project.beans.TestLinkPOJO;
import com.project.classes.BaseTestClass;
import com.project.pages.HomePage;
import com.project.pages.LoginPage;

public class ApplicationUtility extends BaseTestClass
{
	LoginPOJO loginPOJO = new LoginPOJO();
	public boolean launchAppliation(WebDriver driver) throws TestLinkAPIException{
		// Application Objects
		LoginPage loginPage=new LoginPage();
		HomePage home=new HomePage();
		// Bean Object
		LoginPOJO  loginPOJO = new LoginPOJO();
		FrameworkUtilityPOJO frameworkUtilityPOJO=new FrameworkUtilityPOJO();
		// Variable Declaration 
		String notes="",results="",value="",date= "";
		boolean flag=true;
		// Common Objects
		Date d=new Date();
		PropertyFile propertyFile = new PropertyFile();
		try{
			//setting excel
			//Excel.setExcel(System.getProperty("user.dir")+propertyFile.frameworkUtilityPOJO.getStrExcelSheetPath(), propertyFile.frameworkUtilityPOJO.getStrExcelSheetName());
			loginPOJO = propertyFile.getLoginPOJO();
			loginPage.enterUsername(driver,loginPOJO);
			loginPage.enterPassword(driver,loginPOJO);
			ScreenShot.screenshots(driver);
			loginPage.signInClicked(driver);
			Logs.info("SignIn button clicked");
			ScreenShot.screenshots(driver);

			DateFormat format=new SimpleDateFormat(" z dd-MM-yyyy hh:mm:ss");

			date=format.format(d);
			System.out.println(d);
			frameworkUtilityPOJO=propertyFile.getFrameworkUtilityPOJO();
			home.searchField(driver);
			Logs.info("Logged in successfully");
			ScreenShot.screenshots(driver);
			results=TestLinkAPIResults.TEST_PASSED; //updating test case status in testlink
			Logs.info("results updated in try block");
			notes="Successfully executed on "+frameworkUtilityPOJO.getStrExplorer()+" at " +date; //updating notes section in testlink
			Logs.info("notes updated in try block");
			Logs.info("TestCase Passed in try block");
			value="Passed"; //value to be written in Excel

		}
		catch (Exception e) {
			frameworkUtilityPOJO=propertyFile.getFrameworkUtilityPOJO();
			results=TestLinkAPIResults.TEST_FAILED; //upating test case status in testlink
			Logs.info("results updated in catch block");
			notes="Execution failed on "+frameworkUtilityPOJO.getStrExplorer()+" at " +date +"\n" +e; //updating notes section in testlink
			Logs.info("notes updated in catch block");
			Logs.error("TestCase Failed in catch block");
			value="Failed"; // value to written in Excel
			flag=false;

		}
		finally{
			loginPOJO = null;
			home = null;
			loginPage = null;
			TestLinkPOJO testLinkPOJO=propertyFile.getTestLinkPOJO();
			final String APIkey="8ec695eecde6b586ed7934b856ba0662";
			final String url="http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
			propertyFile.read();
			TestLinkAPIClient api=new TestLinkAPIClient(APIkey, url);
			
			System.out.println(propertyFile.getTestLinkPOJO().getStrTestProject()+propertyFile.getTestLinkPOJO().getStrTestPlan()+propertyFile.getTestLinkPOJO().getStrTestCase()+propertyFile.getTestLinkPOJO().getStrBuild());
			api.reportTestCaseResult(testLinkPOJO.getStrTestProject(),testLinkPOJO.getStrTestPlan(),testLinkPOJO.getStrTestCase(),testLinkPOJO.getStrBuild(),notes,results);
			
		}
	
	/*int row=Excel.sheet.getLastRowNum()+1; //calculating number of rows
			int col=Excel.sheet.getRow(0).getLastCellNum(); //calculating number of columns
			for(int i=2;i<row;i++){
				String a[]=new String[col-1];
				for(int j=1;j<col;j++){
					a[j-1]=Excel.getCellValue(i,j);
				}
				//TestLink.reportResult(a[0],a[1],a[2],a[3],notes,results); //updating complete test case in testlink	
				Logs.info("finally block executed");
				Logs.info("test case updated in TestLink");
				//Excel.putCellValue(System.getProperty("user.dir")+PropertyFile.read("excelSheetPath","config"),2,5,value); //updating excel sheet 
	 */			



	return flag;
}

}


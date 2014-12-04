package com.gmail.project.classes;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import org.testng.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;
import com.gmail.project.pages.HomePage;
import com.gmail.project.pages.LoginPage;
import com.gmail.project.util.Logs;
import com.gmail.project.util.PropertyFile;
import com.gmail.project.util.ScreenShot;
import com.gmail.project.util.TestLink;

public class TestLogin extends BaseTestClass{
	String username = PropertyFile.read("username");
	String password = PropertyFile.read("password");

	@Test
	public void login() throws IOException, TestLinkAPIException{
		LoginPage login=new LoginPage();
		Actions builder=new Actions(driver);
		String notes="",results="";
		HomePage home=new HomePage();
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
			builder.keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();
			Logs.info("Logged in successfully");
			ScreenShot.screenshots(driver);
			results=TestLinkAPIResults.TEST_PASSED;
			Logs.info("results updated in try block");
			notes="Successfully executed at"+date;
			Logs.info("notes updated in try block");
			Logs.info("TestCase Passed");
		}
		catch (Exception e) {
			results=TestLinkAPIResults.TEST_FAILED;
			Logs.info("results updated in catch block");
			notes="Execution failed at"+date;
			Logs.info("notes updated in catch block");
			Logs.info("TestCase Failed");
		}
		finally{
			TestLink.reportResult("GmailNew", "SampleTestPlan", "GmailLogin1","SampleBuild",notes,results);
			Logs.info("finally block executed");
			Logs.info("test case updated in TestLink");
		}

	}
}


package com.gmail.project.classes;
import java.io.IOException;
//import org.testng.Assert;
import org.testng.annotations.Test;

import testlink.api.java.client.TestLinkAPIResults;

//import testlink.api.java.client.TestLinkAPIException;
//import testlink.api.java.client.TestLinkAPIResults;

import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;

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
	public void login() throws InterruptedException, IOException, TestLinkAPIException, testlink.api.java.client.TestLinkAPIException{
		LoginPage login=new LoginPage();
		String notes="",results="";
		HomePage home=new HomePage();
		login.enterUsername(driver,username);
		Logs.info("username entered");
		login.enterPassword(driver,password);
		Logs.info("password entered");
		ScreenShot.screenshots(driver);
		login.signInClicked(driver);
		Logs.info("SignIn button clicked");
		home.searchField(driver);
		Logs.info("Logged in successfully");
		ScreenShot.screenshots(driver);

		try{
			home.searchField(driver);
			Logs.info("Logged in successfully");
			ScreenShot.screenshots(driver);
			results=TestLinkAPIResults.TEST_PASSED;
			notes="Successfully executed";
			Logs.info("TestCase Passed");
		}
		catch (Exception e) {

			results=TestLinkAPIResults.TEST_FAILED;
			notes="Execution failed";
			Logs.info("TestCase Failed");
		}
		finally{
			TestLink.reportResult("GmailNew", "SampleTestPlan", "GmailLogin1","SampleBuild",notes,results);

		}

	}
}


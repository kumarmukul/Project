package com.project.classes;
import java.io.IOException;

//import org.testng.Assert;
import org.testng.Assert;
import org.testng.annotations.Test;

import testlink.api.java.client.TestLinkAPIException;

import com.project.pages.LoginPage;
import com.project.util.ApplicationUtility;
import com.project.util.Logs;
public class TestLogin extends BaseTestClass{ 
	@Test
	public void login() throws IOException, TestLinkAPIException{
		// Declaration of Common Objects
		ApplicationUtility applicationUtility = new ApplicationUtility(); 
		Logs.info("STEP 1:- Login to GMAIL Applciation");
		Assert.assertTrue(applicationUtility.launchAppliation(driver));	
		
	}
}



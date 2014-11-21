package com.gmail.project.classes;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gmail.project.pages.HomePage;
import com.gmail.project.pages.LoginPage;
import com.gmail.project.util.Logs;
import com.gmail.project.util.PropertyFile;
import com.gmail.project.util.ScreenShot;

public class TestLogin extends BaseTestClass{
	String username = PropertyFile.read("username");
	String password = PropertyFile.read("password");
	@Test
	public void login() throws InterruptedException, IOException{
		LoginPage login=new LoginPage();
		HomePage home=new HomePage();
		login.enterUsername(driver,username);
		login.enterPassword(driver,password);
		ScreenShot.screenshots(driver);
		login.signInClicked(driver);
		Logs.info("Homefield");
		home.searchField(driver);
		ScreenShot.screenshots(driver);
		Assert.assertEquals(driver.getCurrentUrl(), "https://mail.google.com/mail/u/0/#inbox");
	}
}

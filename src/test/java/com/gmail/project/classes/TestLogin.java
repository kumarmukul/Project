package com.gmail.project.classes;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.gmail.project.pages.LoginPage;
import com.gmail.project.util.PropertyFile;
import com.gmail.project.util.ScreenShot;

public class TestLogin extends BaseTestClass{
	String username = PropertyFile.read("username");
	String password = PropertyFile.read("password");
	@Test
	public void login() throws InterruptedException, IOException{
		
		LoginPage login=new LoginPage();
		login.enterUsername(driver,username);
		login.enterPassword(driver,password);
		ScreenShot.screenshots(driver);
		login.signInClicked(driver);
		driver.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys("Gmail");
		ScreenShot.screenshots(driver);
		//Assert.assertEquals(driver.getCurrentUrl(), "https://mail.google.com/mail/u/0/#inbox");
	}
}

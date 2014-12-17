package com.project.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.project.beans.LoginPOJO;
import com.project.util.Logs;

public class LoginPage {
	private final By usernameLoc=By.id("Email");
	private final By passwordLoc=By.id("Passwd");
	private final By signinButton=By.id("signIn");


	public void enterUsername(WebDriver driver,LoginPOJO loginPOJO){
		if(driver.findElement(usernameLoc)!= null ){
			driver.findElement(usernameLoc).sendKeys(loginPOJO.getStrUserName());
			Logs.info("SUCCESSFULLY Entered user name");
		}else
			Logs.error("FAILED to Entered user name");
	}

	public void enterPassword(WebDriver driver,LoginPOJO loginPOJO){
		if(null != driver.findElement(passwordLoc) ){
			driver.findElement(passwordLoc).sendKeys(loginPOJO.getStrPwd());	
			Logs.info("SUCCESSFULLY Entered PWD ");
		}else
			Logs.error("FAILED to Entered PWD ");
	}


	public void signInClicked(WebDriver driver){
		if(null!=driver.findElement(signinButton)){
			driver.findElement(signinButton).click();
			Logs.info("SUCCESSFULLY clicked SignIn button");
		}else
			Logs.error("FAILED to click on SignIn button");
	}
}	


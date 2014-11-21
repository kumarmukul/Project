package com.gmail.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private final By usernameLoc=By.id("Email");
	private final By passwordLoc=By.id("Passwd");
	private final By signinButton=By.id("signIn");
	
	
	public void enterUsername(WebDriver driver,String username){
		driver.findElement(usernameLoc).sendKeys(username);
	}
	public void enterPassword(WebDriver driver,String password){
		driver.findElement(passwordLoc).sendKeys(password);	
	}
	public void signInClicked(WebDriver driver){
		driver.findElement(signinButton).click();		
	}	
}

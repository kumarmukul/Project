package com.gmail.project.classes;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.gmail.project.util.ScreenShot;

public class TestLogin extends BaseTestClass{
	@Test
	public void login() throws InterruptedException, IOException{
		driver.findElement(By.id("Email")).sendKeys("pawan");
		ScreenShot.screenshots(driver);
		Thread.sleep(2000);
	}
}

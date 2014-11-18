package com.gmail.project.classes;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestLogin extends BaseTestClass{
	@Test
	public void login() throws InterruptedException{
		driver.findElement(By.id("Email")).sendKeys("pawan");
		Thread.sleep(2000);
	}
}

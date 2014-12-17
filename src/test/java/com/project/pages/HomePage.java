package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private final By searchFieldLoc=By.xpath("//input[@aria-label='Search']");
	
	public void searchField(WebDriver driver){
		driver.findElement(searchFieldLoc).sendKeys("Gmail");
	}

}

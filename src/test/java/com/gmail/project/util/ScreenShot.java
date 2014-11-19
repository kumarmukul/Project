package com.gmail.project.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	public static void screenshots(WebDriver driver) throws IOException{
		
		DateFormat format=new SimpleDateFormat("dd-mm-yyyy_HH_mm_ss");
		Date d=new Date();
		String date=format.format(d); 
		Logs.info(date);
		Logs.info("//src//test//resources//Screenshots//login"+date.trim().toString()+".png");
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir")+"//src//test//resources//Screenshots//login"+date.trim().toString()+".png"));
				
	}
	
	

}

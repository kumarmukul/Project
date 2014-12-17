package com.project.util;

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
	public static void screenshots(WebDriver driver) {
		
		DateFormat format=new SimpleDateFormat("dd-MM-yyyy HH_mm_ss");
		Date d=new Date();
		String date=format.format(d);
		Logs.info("Screenshotdate with modified date="+date);
		Logs.info("//src//test//resources//Screenshots//login"+date+".png");
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir")+"//src//test//resources//Screenshots//login_"+date+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
	

}

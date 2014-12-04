package com.gmail.project.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	public static String read(String key){
		Properties p=new Properties();
		Logs.info(System.getProperty("user.dir")+"\\src\\test\\resources\\Data\\config.properties");
		try {
			p.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Data\\config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p.getProperty(key);
	}
}



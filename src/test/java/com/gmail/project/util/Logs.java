package com.gmail.project.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

public class Logs {
	public  static Logger log=LogManager.getLogger(Logs.class.getName());


	public static void start(String testcasename){
		log.info("****************************************");
		log.info("****************************************");
		log.info("************"+testcasename+"************");
		log.info("****************************************");
		log.info("****************************************");
	}
	public static void end(){
		log.info("*****************************************");
		log.info("*****************************************");
		log.info("*************-E-N-D-*********************");
		log.info("*****************************************");
		log.info("*****************************************");

	}
	public static void info(String message){
		log.info(message);
	}
	public static void warn(String message){
		log.warn(message);
	}
	public static void error(String message){
		log.error(message);
	}
	public static void fatal(String message){
		log.fatal(message);
	}
	public static void dynamicApp(String filePath,String fileName){
		//log.setLevel(Level(Level).INFO);
		LogManager.getRootLogger().setLevel(Level.INFO);
		log.removeAppender("fileAppender");
		RollingFileAppender appender=new RollingFileAppender();
		appender.setName("dynamicAppender");
		appender.setAppend(true);
		appender.setMaxBackupIndex(1);
		appender.setMaxFileSize("1MB");

		DateFormat format=new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
		Date d=new Date();
		String date=format.format(d);
		appender.setFile(filePath+fileName + "_"+date+ ".log");
		Logs.info("Log file created at: "+filePath+fileName + "_"+date+ ".log");
		appender.activateOptions();  // Must for the logger object to consider your dynamic appender object.
		PatternLayout layOut = new PatternLayout();
		layOut.setConversionPattern("%d %-5p [%c{1}] %m %n");
		appender.setLayout(layOut);
		Logger.getRootLogger().addAppender(appender); 


	}
}

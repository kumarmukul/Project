package com.gmail.project.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Logs {
	private static Logger log=LogManager.getLogger(Logs.class.getName());
	
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
}

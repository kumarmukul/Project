package com.gmail.project.util;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

//
//import testlink.api.java.client.TestLinkAPIClient;
//import testlink.api.java.client.TestLinkAPIException;

public class TestLink {

	public static String APIkey="09db76469e073b7af5a45a939ecb1332";
	public static String url="http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";

	public static void reportResult(String TestProject, String TestPlan, String TestCase, String build, String Notes, String Result) throws TestLinkAPIException{
		TestLinkAPIClient api=new TestLinkAPIClient(APIkey, url);
		api.reportTestCaseResult(TestProject,TestPlan,TestCase,build,Notes,Result);
	}
}

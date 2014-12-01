package com.gmail.project.util;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLink {

	public static String APIkey="054e593d4141dbb5ac65414d2a3a5eb0";
	public static String url="http://localhost/testlink/index.php";

	public static void reportResult(String TestProject, String TestPlan, String TestCase, String build, String Notes, String Result) throws TestLinkAPIException{
		TestLinkAPIClient api=new TestLinkAPIClient(APIkey, url);
		api.reportTestCaseResult(TestProject,TestPlan,TestCase,build,Notes,Result);
	}
}

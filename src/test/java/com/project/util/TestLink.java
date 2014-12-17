//package com.project.util;
//import testlink.api.java.client.TestLinkAPIClient;
//import com.project.beans.TestLinkPOJO;
//
//public class TestLink {
//	public void reportResult(){
//		PropertyFile propertyFile=new PropertyFile();
//		TestLinkPOJO testLinkPOJO=propertyFile.getTestLinkPOJO();
//		final String APIkey="09db76469e073b7af5a45a939ecb1332";
//		final String url="http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
//		TestLinkAPIClient api=new TestLinkAPIClient(APIkey, url);
//
//		//System.out.println(getTestLinkPOJO().getStrTestProject()+propertyFile.getTestLinkPOJO().getStrTestPlan()+propertyFile.getTestLinkPOJO().getStrTestCase()+propertyFile.getTestLinkPOJO().getStrBuild());
//		api.reportTestCaseResult(testLinkPOJO.getStrTestProject(),testLinkPOJO.getStrTestPlan(),testLinkPOJO.getStrTestCase(),testLinkPOJO.getStrBuild(),notes,results);
//
//	}
//}
//
//
//
////
////
////import com.project.beans.TestLinkPOJO;
////
////import testlink.api.java.client.TestLinkAPIClient;
////import testlink.api.java.client.TestLinkAPIException;
////
////public class TestLink {
////
////	public static String APIkey="09db76469e073b7af5a45a939ecb1332";
////	public static String url="http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
////
////	public static void reportResult(TestLinkPOJO testLinkPOJO, String notes, String results) throws TestLinkAPIException{
////		TestLinkAPIClient api=new TestLinkAPIClient(APIkey, url);
////		api.reportTestCaseResult(testLinkPOJO.getStrTestProject(),testLinkPOJO.getStrTestPlan(),testLinkPOJO.getStrTestCase(),testLinkPOJO.getStrBuild(),notes,results);
////	}
////}


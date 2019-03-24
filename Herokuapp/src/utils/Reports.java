package utils;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import browser.BrowserFactory;

public class Reports {
	
	static ExtentReports extent;
	static ExtentTest test;
	static String strExtentReportsPath = "C:\\Users\\uma\\Desktop\\Reports\\FinalReport_New.html";
	
	public static void configureAndPrepareReport() {
		
		extent = new ExtentReports(strExtentReportsPath, true);
		extent.addSystemInfo("Selenium version", "3.14.0");
		extent.addSystemInfo("Automation Engineer", "Praveen Pandey");
		extent.addSystemInfo("Browser", ((RemoteWebDriver)BrowserFactory.driver).getCapabilities().getBrowserName());
		extent.addSystemInfo("Browser Version", ((RemoteWebDriver)BrowserFactory.driver).getCapabilities().getVersion());
	}
	
	public static void startTest(String testName, String className) {
		
		test = extent.startTest(testName, "<b><u>Current Page:</u></b> " + className);
	}
	

	public static void logStatus(LogStatus logStatus, String stepName) {

		test.log(logStatus, stepName, "");
	}
	
	public static void logStatus(LogStatus logStatus, String stepName, String details) {
		
		test.log(logStatus, stepName, details);
	}
	
	public static void logStatus(LogStatus logStatus, String stepName, Object strActual, Object strExpected) {
		
		test.log(logStatus, stepName, "<b><u>ACTUAL:</u></b> " + strActual + "<br><b><u>EXPECTED:</u></b> " + strExpected);
	}
	
	public static void writeToHTML() {
		
		extent.endTest(test);
		extent.flush();
	}
	
	public static void closeHTMLReport() {
		
		extent.close();//Call it just once in the entire project
	}
}
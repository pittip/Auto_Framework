package generic;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import browser.BrowserFactory;
import utils.ExcelData;
import utils.Reports;

public class Annotation {

	@BeforeSuite
	public void startSuite() {

		System.out.println("Regression suite started...");
		BrowserFactory.startBrowser(ExcelData.getBrowserTypeFromExcel());
	}

	@BeforeTest
	public void beforeTest() {

		Reports.configureAndPrepareReport();// We want the blank html report to be prepared before any test case run
											// starts
	}

	@AfterMethod
	public void afterMethod() {

		Reports.writeToHTML();// Call it after every test case
		BrowserFactory.driver.get(ExcelData.getAppURL());
	}

	@AfterTest
	public void afterTest() {

		BrowserFactory.driver.quit();
	}

	@AfterSuite
	public void afterSuite() {

		System.out.println("Regression ended.");
		Reports.closeHTMLReport();
		System.out.println("Automated regression ended. Closing browser instances now...");
		
		try {
			Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
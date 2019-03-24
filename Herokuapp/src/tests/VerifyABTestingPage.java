package tests;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import browser.BrowserFactory;
import pages.ABTestingPage;
import pages.MainPage;
import utils.Reports;
import utils.Verification;

public class VerifyABTestingPage extends BrowserFactory {
	
	private String strExpectedHeader = "A/B Test Control";
	private String strExpectedBody = "Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).";
	private String className;
	private ABTestingPage objABTestingPage;
	
	@BeforeClass
	public void beforeClass() {
		
		objABTestingPage = new ABTestingPage(driver);
		className = this.getClass().getSimpleName().substring(6);
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		
		Reports.startTest(method.getName(), className);
		MainPage.goToABTestingPage();
	}
	
	@Test(priority = 1)
	public void verifyABTestingPageHeader() {

		Verification.verifyText(objABTestingPage.txtHeader.getText(), strExpectedHeader, "Compare page headers");
	}
	
	@Test(priority = 2)
	public void verifyABTestingPageBody() {

		Verification.verifyText(objABTestingPage.txtBody.getText(), strExpectedBody, "Compare page body contents");
	}
}
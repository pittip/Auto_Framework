package tests;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.LogStatus;

import browser.BrowserFactory;
import pages.ChallengingDOMPage;
import pages.MainPage;
import utils.Reports;

public class VerifyChallengingDOMPage extends BrowserFactory {
	
	private String className;
	private ChallengingDOMPage objChallengingDOMPage;
	
	@BeforeClass
	public void beforeClass() {
		
		objChallengingDOMPage = new ChallengingDOMPage(driver);
		className = this.getClass().getSimpleName().substring(6);
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		
		Reports.startTest(method.getName(), className);
		MainPage.goToChallengingDOM();
	}
	
	@Test
	public void verifyPresenceOfThreeButtons() {
		
		if(objChallengingDOMPage.lstButtons.get(0).isDisplayed()) {
			Reports.logStatus(LogStatus.PASS, "Verifying the presence of 1st button", objChallengingDOMPage.lstButtons.get(0).isDisplayed(), true);
		}
		else {
			Reports.logStatus(LogStatus.FAIL, "Verifying the presence of 1st button", objChallengingDOMPage.lstButtons.get(0).isDisplayed(), true);
		}
		
		if(objChallengingDOMPage.lstButtons.get(1).isDisplayed()) {
			Reports.logStatus(LogStatus.PASS, "Verifying the presence of 2nd button", objChallengingDOMPage.lstButtons.get(1).isDisplayed(), true);
		}
		else {
			Reports.logStatus(LogStatus.FAIL, "Verifying the presence of 2nd button", objChallengingDOMPage.lstButtons.get(1).isDisplayed(), true);
		}
		
		if(objChallengingDOMPage.lstButtons.get(2).isDisplayed()) {
			Reports.logStatus(LogStatus.PASS, "Verifying the presence of 1st button", objChallengingDOMPage.lstButtons.get(2).isDisplayed(), true);
		}
		else {
			Reports.logStatus(LogStatus.FAIL, "Verifying the presence of 1st button", objChallengingDOMPage.lstButtons.get(2).isDisplayed(), true);
		}
	}
}
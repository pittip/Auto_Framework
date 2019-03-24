package tests;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.LogStatus;

import browser.BrowserFactory;
import pages.CheckboxesPage;
import pages.MainPage;
import utils.Reports;
import utils.Verification;

public class VerifyCheckboxesPage extends BrowserFactory {
	
	String strExpectedHeader = "Checkboxes";
	
	private String className;
	private CheckboxesPage objCheckboxesPage;
	
	@BeforeClass
	public void beforeClass() {

		objCheckboxesPage 	= new CheckboxesPage(BrowserFactory.driver);
		className 		= this.getClass().getSimpleName().substring(6);
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		
		Reports.startTest(method.getName(), className);
		MainPage.goToCheckboxesPage();
	}
	
	@Test(priority = 1)
	public void verifyCheckboxesPageHeader() {
		
		Verification.verifyText(objCheckboxesPage.txtHeader.getText(), strExpectedHeader, "Compare page headers");
	}
	
	@Test(priority = 2)
	public void verifyStateOfCheckboxes() {
		
		if(!objCheckboxesPage.chkCheckboxes.get(0).isSelected()) {
			Reports.logStatus(LogStatus.PASS, "Check that the 1st checkbox is not set", "Checkbox is NOT set");
		}
		else {
			Reports.logStatus(LogStatus.FAIL, "Check that the 1st checkbox is not set", "Checkbox is set");
		}
		
		if(objCheckboxesPage.chkCheckboxes.get(1).isSelected()) {
			Reports.logStatus(LogStatus.PASS, "Check that the 2nd checkbox is set", "Checkbox is set");
		}
		else {
			Reports.logStatus(LogStatus.FAIL, "Check that the 2nd checkbox is set", "Checkbox is NOT set");
		}
	}
	
	@Test(priority = 3)
	public void verifyCountOfCheckboxes() {
		
		Verification.verifyText(Integer.toString(objCheckboxesPage.chkCheckboxes.size()), "2", "Check the total number of checkboxes on the page");
	}
}
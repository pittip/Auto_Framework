package tests;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.LogStatus;

import browser.BrowserFactory;
import pageSpecificFunctions.GenericBrokenImages;
import pages.BrokenImagesPage;
import pages.MainPage;
import utils.Reports;

public class VerifyBrokenImagesPage extends BrowserFactory {
	
	private String className;
	private BrokenImagesPage objBrokenImagesPage;
	
	@BeforeClass
	public void beforeClass() {
		
		objBrokenImagesPage = new BrokenImagesPage(BrowserFactory.driver);
		className = this.getClass().getSimpleName().substring(6);
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		
		Reports.startTest(method.getName(), className);
		MainPage.goToBrokenImagesPage();
	}
	
	@Test
	public void verifyIfImagesAreBroken() {
		
		if(GenericBrokenImages.isImageBroken(objBrokenImagesPage.lstImages.get(0))) {
			Reports.logStatus(LogStatus.PASS, "Verify if the 1st image is broken", objBrokenImagesPage.lstImages.get(0).getAttribute("naturalWidth"), "0");
		}
		else {
			Reports.logStatus(LogStatus.FAIL, "Verify if the 1st image is broken", objBrokenImagesPage.lstImages.get(0).getAttribute("naturalWidth"), "0");
		}
		
		if(GenericBrokenImages.isImageBroken(objBrokenImagesPage.lstImages.get(1))) {
			Reports.logStatus(LogStatus.PASS, "Verify if the 2nd image is broken", objBrokenImagesPage.lstImages.get(1).getAttribute("naturalWidth"), "0");
		}
		else {
			Reports.logStatus(LogStatus.FAIL, "Verify if the 2nd image is broken", objBrokenImagesPage.lstImages.get(1).getAttribute("naturalWidth"), "0");
		}
		
		if(!GenericBrokenImages.isImageBroken(objBrokenImagesPage.lstImages.get(2))) {
			Reports.logStatus(LogStatus.PASS, "Verify if the 3rd image is broken", objBrokenImagesPage.lstImages.get(2).getAttribute("naturalWidth"), "Non-zero");
		}
		else {
			Reports.logStatus(LogStatus.FAIL, "Verify if the 3rd image is broken", objBrokenImagesPage.lstImages.get(2).getAttribute("naturalWidth"), "Non-zero");
		}
	}
}
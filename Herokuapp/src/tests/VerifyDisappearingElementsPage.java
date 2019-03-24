package tests;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import browser.BrowserFactory;
import pages.DisappearingElementsPage;
import pages.MainPage;
import utils.Reports;
import utils.Verification;

public class VerifyDisappearingElementsPage extends BrowserFactory {
	
	private String className;
	private DisappearingElementsPage objDisappearingElementsPage;
	
	@BeforeClass
	public void beforeClass() {
		
		objDisappearingElementsPage = new DisappearingElementsPage(driver);
		className = this.getClass().getSimpleName().substring(6);
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		
		Reports.startTest(method.getName(), className);
		MainPage.goToDisappearingElementsPage();
	}
	
	@Test(priority = 1)
	public void verifyHomeTabExists() {
		
		Verification.verifyWebObjectsPresence(objDisappearingElementsPage.tabHome, "Verify that Home tab exists");
	}
	
	@Test(priority = 2)
	public void verifyAboutTabExists() {
		
		Verification.verifyWebObjectsPresence(objDisappearingElementsPage.tabAbout, "Verify that About tab exists");
	}
	
	@Test(priority = 3)
	public void verifyContactUsTabExists() {

		Verification.verifyWebObjectsPresence(objDisappearingElementsPage.tabContactUs, "Verify that Contact Us tab exists");
	}
	
	@Test(priority = 4)
	public void verifyPortfolioTabExists() {

		Verification.verifyWebObjectsPresence(objDisappearingElementsPage.tabPortfolio, "Verify that Portfolio tab exists");
	}
	
	@Test(priority = 5)
	public void verifyGalleryTabExists() {

		Verification.verifyWebObjectsPresence(objDisappearingElementsPage.tabGallery, "Verify that Gallery tab exists");
	}
}
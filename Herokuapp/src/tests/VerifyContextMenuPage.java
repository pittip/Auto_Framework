package tests;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import browser.BrowserFactory;
import pages.ContextMenuPage;
import pages.MainPage;
import utils.Reports;
import utils.Verification;

public class VerifyContextMenuPage extends BrowserFactory {
	
	String className;
	ContextMenuPage objContextMenuPage;
	
	@BeforeClass
	private void beforeClass() {
		
		objContextMenuPage = new ContextMenuPage(driver);
		className = this.getClass().getSimpleName().substring(6);
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		
		Reports.startTest(method.getName(), className);
		MainPage.goToContextMenuPage();
	}
	
	@Test
	public void verifyPopUpAfterRightClickOperation() {
		
		objContextMenuPage.rightClickInDottedBox();
		Verification.verifyText(BrowserFactory.driver.switchTo().alert().getText(), "You selected a context menu", "Verify pop up text");
	}
}
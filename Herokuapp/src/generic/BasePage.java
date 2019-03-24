package generic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import browser.BrowserFactory;
import utils.Reports;

public class BasePage {
	
	public static void waitForPageToLoad() {
		
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				
				return ((JavascriptExecutor)(driver)).executeScript("return document.readyState").equals("complete");
			}
		};
		
		WebDriverWait wait = new WebDriverWait(BrowserFactory.driver, 50);
		wait.until(pageLoadCondition);
		
		Reports.logStatus(LogStatus.INFO, "<i>Wait for page to load...</i>", "<i>Page loaded</i>");
	}
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import browser.BrowserFactory;
import utils.Reports;

public class MainPage {
	
	private static WebElement lnkABTesting;
	private static WebElement lnkBasicAuth;
	private static WebElement lnkBrokenImages;
	private static WebElement lnkChallengingDOM;
	private static WebElement lnkCheckboxes;
	private static WebElement lnkContextMenu;
	private static WebElement lnkDisappearingElements;
	
	private static WebDriverWait wait = new WebDriverWait(BrowserFactory.driver, 10);
	
	public static void goToABTestingPage() {
		
		lnkABTesting = BrowserFactory.driver.findElement(By.cssSelector("a[href='/abtest']"));
		wait.until(ExpectedConditions.elementToBeClickable(lnkABTesting)).click();
		Reports.logStatus(LogStatus.INFO, "<i>Click on AB Testing link</i>", "<i>Clicked...</i>");
		ABTestingPage.waitForPageToLoad();
	}
	
	public static void goToBrokenImagesPage() {
		
		lnkBrokenImages = BrowserFactory.driver.findElement(By.cssSelector("a[href*='broken_images']"));
		wait.until(ExpectedConditions.elementToBeClickable(lnkBrokenImages)).click();
		Reports.logStatus(LogStatus.INFO, "<i>Click on Broken Images link</i>", "<i>Clicked...</i>");
		BrokenImagesPage.waitForPageToLoad();
	}
	
	// TODO
	public static void goToBasicAuthPage(Boolean withLogin) {
		
		lnkBasicAuth = BrowserFactory.driver.findElement(By.cssSelector("a[href*=basic_auth]"));
		wait.until(ExpectedConditions.elementToBeClickable(lnkBasicAuth)).click();
		
		if(withLogin) {
			
		}
		else {
			BrowserFactory.driver.switchTo().alert().dismiss();	
		}
	}
	
	public static void goToChallengingDOM() {
		
		lnkChallengingDOM = BrowserFactory.driver.findElement(By.cssSelector("a[href*='challenging_dom']"));
		wait.until(ExpectedConditions.elementToBeClickable(lnkChallengingDOM)).click();
		Reports.logStatus(LogStatus.INFO, "<i>Click on Challenging DOM link</i>", "<i>Clicked...</i>");
		ChallengingDOMPage.waitForPageToLoad();
	}
	
	public static void goToCheckboxesPage() {
		
		lnkCheckboxes = BrowserFactory.driver.findElement(By.cssSelector("a[href*=checkboxes]"));
		wait.until(ExpectedConditions.elementToBeClickable(lnkCheckboxes)).click();
		Reports.logStatus(LogStatus.INFO, "<i>Click on Checkboxes link</i>", "<i>Clicked...</i>");
		CheckboxesPage.waitForPageToLoad();
	}
	
	public static void goToContextMenuPage() {
		
		lnkContextMenu = BrowserFactory.driver.findElement(By.cssSelector("a[href*='context_menu']"));
		wait.until(ExpectedConditions.elementToBeClickable(lnkContextMenu)).click();
		Reports.logStatus(LogStatus.INFO, "<i>Click on Context Menu link</i>", "<i>Clicked...</i>");
		ContextMenuPage.waitForPageToLoad();
	}
	
	public static void goToDisappearingElementsPage() {
		
		lnkDisappearingElements = BrowserFactory.driver.findElement(By.cssSelector("a[href*='disappearing_elements']"));
		wait.until(ExpectedConditions.elementToBeClickable(lnkDisappearingElements)).click();
		Reports.logStatus(LogStatus.INFO, "<i>Click on Disappearing Elements link</i>", "<i>Clicked...</i>");
		DisappearingElementsPage.waitForPageToLoad();
	}
}
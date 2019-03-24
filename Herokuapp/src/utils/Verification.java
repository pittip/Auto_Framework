package utils;

import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class Verification {
	
	public static void verifyText(String strActual, String strExpected, String strVerificationStatement) {
		
		if(strActual.equals(strExpected)) {
			Reports.logStatus(LogStatus.PASS, strVerificationStatement, "<b><u>ACTUAL:</u></b> " + strActual + "<br><b><u>EXPECTED:</u></b> " + strExpected);
		}
		else {
			Reports.logStatus(LogStatus.FAIL, strVerificationStatement, "<b><u>ACTUAL:</u></b> " + strActual + "<br><b><u>EXPECTED:</u></b> " + strExpected);
		}
	}
	
	public static void verifyWebObjectsPresence(WebElement element, String strVerificationStatement) {
		
		if(element.isDisplayed()) {
			Reports.logStatus(LogStatus.PASS, strVerificationStatement, element.getSize(), "Non-zero size implies object exists");
		}
		else {
			Reports.logStatus(LogStatus.FAIL, strVerificationStatement, element.getSize(), "Zero size implies object does not exist");
		}
	}
}
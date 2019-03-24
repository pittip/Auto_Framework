package pageSpecificFunctions;

import org.openqa.selenium.WebElement;

public class GenericBrokenImages {
	
	public static boolean isImageBroken(WebElement image) {
		
		if(image.getAttribute("naturalWidth").equals("0")) {
			return true;
		}
		else {
			return false;
		}
	}
}

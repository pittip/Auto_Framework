package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class BasicAuthPage extends BasePage {
	
	private WebDriver driver;
	
	@FindBy(css="p")
	public WebElement txtSuccessfullyAuthorisedMsg; 
	
	@FindBy(xpath="//body[contains(text(),'Not authorized')]")
	public WebElement txtNotAuthorized;
	
	public BasicAuthPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

}

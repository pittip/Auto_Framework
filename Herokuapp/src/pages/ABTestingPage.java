package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class ABTestingPage extends BasePage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//h3[contains(text(),'A/B Test')]")
	public WebElement txtHeader;
	
	@FindBy(css="p")
	public WebElement txtBody;
	
	public ABTestingPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class DisappearingElementsPage extends BasePage {
	
	private WebDriver driver;
	
	@FindBy(css="a[href='/']")
	public WebElement tabHome;
	
	@FindBy(css="a[href*='about']")
	public WebElement tabAbout;
	
	@FindBy(css="a[href*='contact-us']")
	public WebElement tabContactUs;
	
	@FindBy(css="a[href*='portfolio']")
	public WebElement tabPortfolio;
	
	@FindBy(css="a[href*='gallery']")
	public WebElement tabGallery;
	
	public DisappearingElementsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
}
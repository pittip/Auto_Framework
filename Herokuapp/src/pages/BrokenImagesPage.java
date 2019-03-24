package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class BrokenImagesPage extends BasePage {
	
	private WebDriver driver;
	
	@FindAll({@FindBy(css="img[src$=jpg]")})
	public List<WebElement> lstImages;
	
	public BrokenImagesPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

}

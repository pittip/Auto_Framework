package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class CheckboxesPage extends BasePage {
	
	private WebDriver driver;
	
	@FindBy(css="h3")
	public WebElement txtHeader;
	
	@FindBy(css="input[type='checkbox']")
	public List<WebElement> chkCheckboxes;
	
	public CheckboxesPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
}
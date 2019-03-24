package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class ChallengingDOMPage extends BasePage {
	
	private WebDriver driver;
	
	//@FindAll({@FindBy(xpath="//a[@class='button' or @class='button alert' or @class='button success']")})
	@FindAll({@FindBy(css="a[class='button'],[class='button alert'],[class='button success']")})
	public List<WebElement> lstButtons;
	
	@FindBy(css="table>thead>tr>th")
	public List<WebElement> tableCols;
	
	@FindBy(css="table>tbody>tr")
	public List<WebElement> tableRows;
	
	public ChallengingDOMPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
}
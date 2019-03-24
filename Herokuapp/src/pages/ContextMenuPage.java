package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import browser.BrowserFactory;
import generic.BasePage;

public class ContextMenuPage extends BasePage {

	private WebDriver driver;

	@FindBy(css = "#hot-spot")
	public WebElement rightClickArea;

	public ContextMenuPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void rightClickInDottedBox() {

		// TODO
		try {
			Actions action = new Actions(BrowserFactory.driver);
			/*
			 * action.contextClick(rightClickArea).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.
			 * ARROW_DOWN)
			 * .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN
			 * ).sendKeys(Keys.RETURN) .perform();
			 */
			/*
			 * action.contextClick(rightClickArea).sendKeys( Keys.chord(Keys.ARROW_DOWN,
			 * Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN))
			 * .perform();
			 */
			Thread.sleep(2000);
			action.contextClick(rightClickArea).perform();
			int x = rightClickArea.getLocation().getX();
			int y = rightClickArea.getLocation().getY();
			action.moveToElement(rightClickArea, x + 100, y + 100);
			/*
			 * action.sendKeys(rightClickArea,
			 * Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
			 * .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).
			 * perform();
			 */
			// action.keyDown(rightClickArea, Keys.DOWN).sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);

			/*
			 * for(int i = 1; i <=5; i++) { //rightClickArea.sendKeys(Keys.ARROW_DOWN);
			 * rightClickArea.sendKeys(Keys.DOWN); Thread.sleep(1000); }
			 */

			// rightClickArea.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
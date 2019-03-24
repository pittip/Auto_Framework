package browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import generic.Annotation;
import utils.ExcelData;

public class BrowserFactory extends Annotation {
	
	public static WebDriver driver;
	
	private static String strFirefoxDriverPath 	= "E:\\Software setups\\selenium_browser_drivers\\geckodriver-v0.23.0-win32\\geckodriver.exe";
	private static String strChromeDriverPath 	= "E:\\Software setups\\selenium_browser_drivers\\chromedriver_win32\\chromedriver.exe";
	private static String strIEDriverPath 		= "E:\\Software setups\\selenium_browser_drivers\\IEDriverServer_Win32_3.4.0\\IEDriverServer.exe";
	
	public static void startBrowser(String browser) {
		
		switch (browser) {
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", strFirefoxDriverPath);
			driver = new FirefoxDriver();
			break;
		
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", strChromeDriverPath);
			driver = new ChromeDriver();
			break;
			
		case "IE":
			System.setProperty("webdriver.ie.driver", strIEDriverPath);
			driver = new InternetExplorerDriver();
			break;

		default:
			System.out.println("Invalid browser. Exiting...");
			System.exit(0);
			break;
		}
		
		driver.manage().window().maximize();
		driver.get(ExcelData.getAppURL());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
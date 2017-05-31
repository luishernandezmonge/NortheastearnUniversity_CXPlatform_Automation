package northeasternuniversity.cxplatform.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.safari.SafariDriver;

import northeasternuniversity.cxplatform.constants.ConstantsPropertiesManager;
import northeasternuniversity.cxplatform.constants.FilesLocations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;

public class WebDriverManager {

	WebDriver driver;
	ConstantsPropertiesManager constantsPropertiesManager;

	public void openConnection() {
		constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		String webBrowserProperty = constantsPropertiesManager.getSharedExecutionConstants().getProperty("webBrowser");

		if (webBrowserProperty.equalsIgnoreCase("PhantomJS")) {

			System.setProperty("phantomjs.binary.path",
					constantsPropertiesManager.getSharedExecutionConstants().getProperty("phantomjsExec"));
			driver = new PhantomJSDriver();
		}

		else if (webBrowserProperty.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
					constantsPropertiesManager.getSharedExecutionConstants().getProperty("chromeExec"));
			driver = new ChromeDriver();

		}

		else if (webBrowserProperty.equalsIgnoreCase("Safari"))
			driver = new SafariDriver();
		else {
			// if not recognized web browser, it run by default with Firefox
			driver = new FirefoxDriver();
		}

		driver.get(constantsPropertiesManager.getSharedExecutionConstants().getProperty("northeastern.edu_baseUrl"));
	}

	public void closeConnection() {
		this.driver.close();
		this.driver.quit();
	}

	public void maximizeWindow() {
		// driver.manage().window().maximize();
		Dimension d = new Dimension(1400, 1600);
		// Resize current window to the set dimension
		driver.manage().window().setSize(d);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void driverWait() {
		long wait = Long
				.parseLong(constantsPropertiesManager.getSharedExecutionConstants().getProperty("defaultWaitTime"));
		this.driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
		try {
			Thread.sleep(wait);
		} catch (InterruptedException ie1) {
			ie1.printStackTrace();
		}
	}
}

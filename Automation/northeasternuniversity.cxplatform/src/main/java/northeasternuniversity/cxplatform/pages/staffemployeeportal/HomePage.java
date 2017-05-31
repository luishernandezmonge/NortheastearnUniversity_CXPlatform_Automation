/**
 * 
 */
package northeasternuniversity.cxplatform.pages.staffemployeeportal;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import northeasternuniversity.cxplatform.constants.ConstantsPropertiesManager;
import northeasternuniversity.cxplatform.constants.UIElementsPropertiesManager;
import northeasternuniversity.cxplatform.webdriver.WebDriverManager;

/**
 * @author luishernandez
 *
 */
public class HomePage {
	private WebDriverManager driverManager;
	private UIElementsPropertiesManager uIElementsManager;
	private WebDriver driver;
	private ConstantsPropertiesManager constantsPropertiesManager;

	private String appsAndLinksLocator;	

	/**
	 * 
	 */

	public HomePage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager,
			ConstantsPropertiesManager constantsPropertiesManager) {
		this.driverManager = driverManager;
		this.uIElementsManager = UIElementsPropertiesManager;
		this.constantsPropertiesManager = constantsPropertiesManager;
		this.driver = this.driverManager.getDriver();

		appsAndLinksLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.homepage.appsandlinkslink");

	}

	public boolean isElementPresent(String path) {
		boolean isElementPresent = true;

		try {
			@SuppressWarnings("unused")
			WebElement webElement = driverManager.getDriver().findElement(By.xpath(path));
		} catch (NoSuchElementException e) {
			isElementPresent = false;
		}

		return isElementPresent;
	}

	public Boolean isAppsAndLinksLinkElementPresent() {
		return this.isElementPresent(appsAndLinksLocator);
	}

	public void appsAndLinksLocatorClick() {
		WebElement appsAndLinksLinkWebElement = driverManager.getDriver().findElement(By.xpath(appsAndLinksLocator));
		appsAndLinksLinkWebElement.click();
	}

	public void goToHomePage() {
		driverManager.driverWait();
		this.driver
				.get(constantsPropertiesManager.getSharedExecutionConstants().getProperty("northeastern.edu_homepageurl"));
	}

	public WebDriverManager getDriverManager() {
		return driverManager;
	}

	public void setDriverManager(WebDriverManager driverManager) {
		this.driverManager = driverManager;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	

}

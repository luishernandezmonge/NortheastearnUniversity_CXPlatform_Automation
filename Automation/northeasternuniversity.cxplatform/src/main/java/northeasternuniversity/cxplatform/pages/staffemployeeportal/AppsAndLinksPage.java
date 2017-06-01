/**
 * 
 */
package northeasternuniversity.cxplatform.pages.staffemployeeportal;

import java.util.List;
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
public class AppsAndLinksPage {
	private WebDriverManager driverManager;
	private UIElementsPropertiesManager uIElementsManager;
	private WebDriver driver;
	private ConstantsPropertiesManager constantsPropertiesManager;

	private String recentLinksListDivLocator;
	private String quickLinksListDivLocator;

	/**
	 * 
	 */

	public AppsAndLinksPage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager,
			ConstantsPropertiesManager constantsPropertiesManager) {
		this.driverManager = driverManager;
		this.uIElementsManager = UIElementsPropertiesManager;
		this.constantsPropertiesManager = constantsPropertiesManager;
		this.driver = this.driverManager.getDriver();

		recentLinksListDivLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.recentlinkslistdiv");
		
		quickLinksListDivLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.quicklinkslistdiv");

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

	public Boolean isRecentLinksListDivElementPresent() {
		return this.isElementPresent(recentLinksListDivLocator);
	}

	public Boolean isQuickLinksListDivElementPresent() {
		return this.isElementPresent(quickLinksListDivLocator);
	}

	public Boolean hasRecentLinks() {
		int recentlinksListSize = this.driverManager.getDriver().findElements(By.xpath(recentLinksListDivLocator))
				.size();
		if (isRecentLinksListDivElementPresent()) {
			if (recentlinksListSize > 0)
				return true;
			else
				return false;
		} else
			return false;

	}

	public Boolean hasQuickLinks() {
		int recentlinksListSize = this.driverManager.getDriver().findElements(By.xpath(quickLinksListDivLocator))
				.size();
		if (isRecentLinksListDivElementPresent()) {
			if (recentlinksListSize > 0)
				return true;
			else
				return false;
		} else
			return false;

	}

	public List<WebElement> getAllElementsOnRecentLinksList() {
		List<WebElement> listOfRecentLinks;
		listOfRecentLinks = this.driverManager.getDriver().findElements(By.xpath(recentLinksListDivLocator));
		return listOfRecentLinks;
	}

	public List<WebElement> getAllElementsOnQuickLinksList() {
		List<WebElement> listOfQuickLinks;
		listOfQuickLinks = this.driverManager.getDriver().findElements(By.xpath(quickLinksListDivLocator));
		return listOfQuickLinks;
	}

	public void pinARecentLinkToQuickLinks() {
		List<WebElement> recentLinkslist = this.getAllElementsOnRecentLinksList();
		for (WebElement element : recentLinkslist) {
			String elementText = element.getText();
			String xpathOfPinElement = recentLinksListDivLocator + "ul/li/a[contains(text(),'" + elementText
					+ "')]/../i";
			WebElement pinElement = this.driverManager.getDriver().findElement(By.xpath(xpathOfPinElement));
			pinElement.click();
			driverManager.driverShortWait();
		}

	}

	public void goToAppsAndLinksPage() {
		this.driver.get(constantsPropertiesManager.getSharedExecutionConstants()
				.getProperty("northeastern.edu_appsandlinkspageurl"));
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

	public boolean isElementOnQuickLinks(String elementToFind) {
		Boolean result = false;

		List<WebElement> quickLinkslist = this.getAllElementsOnQuickLinksList();

		for (WebElement element : quickLinkslist) {
			String elementText = element.getText();

			if (elementText.equalsIgnoreCase(elementToFind))
				result = true;

		}

		return result;
	}

}

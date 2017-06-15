/**
 * 
 */
package northeasternuniversity.cxplatform.pages.staffemployeeportal;

import java.util.concurrent.TimeUnit;

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
	private String appsAndLinksFooterLinkLocator;
	private String homeFooterLinkLocator;
	private String humanResourcesFooterLinkLocator;
	private String directoryFooterLinkLocator;
	private String communityFooterLinkLocator;
	private String copyrightFooterLocator;

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
		appsAndLinksFooterLinkLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.homepage.footer.appsandlinkslink");
		homeFooterLinkLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.homepage.footer.homelink");
		humanResourcesFooterLinkLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.homepage.footer.humanresourceslink");
		directoryFooterLinkLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.homepage.footer.directorylink");
		communityFooterLinkLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.homepage.footer.comunitylink");
		copyrightFooterLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.homepage.footer.copyright");

	}

	public boolean isElementPresent(String path) {
		boolean isElementPresent = true;

		try {

			this.driverManager.getDriver().manage().timeouts().implicitlyWait(1200, TimeUnit.MILLISECONDS);
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

	public Boolean isHomeFooterLinkElementPresent() {
		return this.isElementPresent(homeFooterLinkLocator);
	}

	public Boolean isHumanResourcesFooterLinkElementPresent() {
		return this.isElementPresent(humanResourcesFooterLinkLocator);
	}

	public Boolean isAppsAndLinksFooterLinkElementPresent() {
		return this.isElementPresent(appsAndLinksFooterLinkLocator);
	}

	public Boolean isDirectoryFooterLinkElementPresent() {
		return this.isElementPresent(directoryFooterLinkLocator);
	}

	public Boolean isComunityFooterLinkElementPresent() {
		return this.isElementPresent(communityFooterLinkLocator);
	}

	public Boolean isCopyrightFooterElementPresent() {
		return this.isElementPresent(copyrightFooterLocator);
	}

	public Boolean isTheCorrectCopyright(String expectedCopyRightData) {
		Boolean result = false;
		if (isCopyrightFooterElementPresent()) {
			WebElement copyrightElement = driverManager.getDriver().findElement(By.xpath(copyrightFooterLocator));
			String copyrightdata = copyrightElement.getText();
			if (copyrightdata.equalsIgnoreCase(expectedCopyRightData))
				result = true;
		}

		return result;
	}

	public Boolean isTheCorrectURLOfLink(String expectedURL, WebElement elementToVerify) {
		Boolean result = false;
		String HREFValue = elementToVerify.getAttribute("href");
		if (HREFValue.equalsIgnoreCase(expectedURL))
			result = true;
		return result;
	}

	public Boolean isTheCorrectURLForFooterHomeLink(String expectedURL) {
		Boolean result = false;
		if (isHomeFooterLinkElementPresent()) {
			WebElement webElement = driverManager.getDriver().findElement(By.xpath(homeFooterLinkLocator));
			if (isTheCorrectURLOfLink(expectedURL, webElement))
				result = true;
		}
		return result;
	}

	public Boolean isTheCorrectURLForFooterHumanResourcesLink(String expectedURL) {
		Boolean result = false;
		if (isHumanResourcesFooterLinkElementPresent()) {
			WebElement webElement = driverManager.getDriver().findElement(By.xpath(humanResourcesFooterLinkLocator));
			if (isTheCorrectURLOfLink(expectedURL, webElement))
				result = true;
		}
		return result;
	}

	public Boolean isTheCorrectURLForFooterAppsAndLinksLink(String expectedURL) {
		Boolean result = false;
		if (isAppsAndLinksFooterLinkElementPresent()) {
			WebElement webElement = driverManager.getDriver().findElement(By.xpath(appsAndLinksFooterLinkLocator));
			if (isTheCorrectURLOfLink(expectedURL, webElement))
				result = true;
		}
		return result;
	}

	public Boolean isTheCorrectURLForFooterDirectoryLink(String expectedURL) {
		Boolean result = false;
		if (isDirectoryFooterLinkElementPresent()) {
			WebElement webElement = driverManager.getDriver().findElement(By.xpath(directoryFooterLinkLocator));
			if (isTheCorrectURLOfLink(expectedURL, webElement))
				result = true;
		}
		return result;
	}

	public Boolean isTheCorrectURLForFooterCommunityLink(String expectedURL) {
		Boolean result = false;
		if (isComunityFooterLinkElementPresent()) {
			WebElement webElement = driverManager.getDriver().findElement(By.xpath(communityFooterLinkLocator));
			if (isTheCorrectURLOfLink(expectedURL, webElement))
				result = true;
		}
		return result;
	}

	public void appsAndLinksTabClick() {
		WebElement appsAndLinksLinkWebElement = driverManager.getDriver().findElement(By.xpath(appsAndLinksLocator));
		if (appsAndLinksLinkWebElement.isDisplayed())
			appsAndLinksLinkWebElement.click();
	}

	public void goToHomePage() {
		this.driver.get(
				constantsPropertiesManager.getSharedExecutionConstants().getProperty("northeastern.edu_homepageurl"));
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

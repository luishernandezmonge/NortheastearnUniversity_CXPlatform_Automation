/**
 * 
 */
package northeasternuniversity.cxplatform.pages.staffemployeeportal;

import java.util.List;
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
	private String appsPortletAddAppLinkLocator;
	private String addAppModalLocator;
	private String addAppModalCloseLocator;
	private String appsPortletLocator;
	private String latestNewsPortletLocator;
	private String latestNewsViewAllLinkLocator;
	private String latestNewsDivsListItemsLocator;
	private String latestNewsDivContainerLocator;
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
		appsPortletAddAppLinkLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.dashboardpage.appsaddlink");
		addAppModalLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.dashboardpage.addtomyapps.modaltitle");
		addAppModalCloseLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.dashboardpage.addtomyapps.modalxbutton");
		appsPortletLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.dashboardpage.appsportlet");
		latestNewsViewAllLinkLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.dashboardpage.latestnews.vewAllNewsLink");
		latestNewsPortletLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.dashboardpage.latestnewsportlet");
		latestNewsDivsListItemsLocator=  uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.dashboardpage.latestnewsdivlistitems");
		latestNewsDivContainerLocator=  uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.dashboardpage.latestnewsdivcontainer");
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

	public Boolean isAddNewAppLinkElementPresent() {
		return this.isElementPresent(appsPortletAddAppLinkLocator);
	}

	public Boolean isViewNewsPageLinkPresent() {
		return this.isElementPresent(latestNewsViewAllLinkLocator);
	}

	public Boolean isMyAppsPortletPresent() {
		return this.isElementPresent(appsPortletLocator);
	}

	public Boolean isLatestNewsPortletPresent() {
		return this.isElementPresent(latestNewsPortletLocator);
	}

	public Boolean isLatestNewsPortletDivContainerPresent() {
		return this.isElementPresent(latestNewsDivContainerLocator);
	}
	public Boolean hasLastesNewsLinks() {
		int latestNewsLinksSize = this.driverManager.getDriver()
				.findElements(By.xpath(latestNewsDivsListItemsLocator)).size();
		if (isLatestNewsPortletDivContainerPresent()) {
			if (latestNewsLinksSize > 0)
				return true;
			else
				return false;
		} else
			return false;
	}
	
	public List<WebElement> getAllElementsOnLatestNewsPortlet() {
		List<WebElement> listOfLatestNews;
		listOfLatestNews = this.driverManager.getDriver().findElements(By.xpath(latestNewsDivsListItemsLocator));
		return listOfLatestNews;
	}

	public Boolean isAddAppModalDisplayedAndPresent() {
		Boolean result = false;
		if (isElementPresent(addAppModalLocator)) {
			WebElement element = driverManager.getDriver().findElement(By.xpath(addAppModalLocator));
			if (element.isDisplayed())
				result = true;
		}

		return result;
	}

	public Boolean isAddAppModalClosePresent() {
		return this.isElementPresent(addAppModalCloseLocator);
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

	public boolean hyperLinkHasTargetBlankAttribute(WebElement elementToValidate) {
		boolean result = false;

		if (elementToValidate.getAttribute("target").equalsIgnoreCase("_blank"))
			result = true;

		return result;

	}

	public void appsAndLinksTabClick() {
		WebElement appsAndLinksLinkWebElement = driverManager.getDriver().findElement(By.xpath(appsAndLinksLocator));
		if (appsAndLinksLinkWebElement.isDisplayed())
			appsAndLinksLinkWebElement.click();
	}

	public void addNewAppLinkClick() {
		WebElement addNewAppLinkElement = driverManager.getDriver().findElement(By.xpath(appsPortletAddAppLinkLocator));
		if (addNewAppLinkElement.isDisplayed())
			addNewAppLinkElement.click();
	}

	public void viewNewsPageLinkClick() {
		WebElement viewNewsPageLinkElement = driverManager.getDriver()
				.findElement(By.xpath(latestNewsViewAllLinkLocator));
		if (viewNewsPageLinkElement.isDisplayed())
			viewNewsPageLinkElement.click();
	}

	public void addAppModalCloseLinkClick() {
		WebElement addAppModalCloseLinkElement = driverManager.getDriver()
				.findElement(By.xpath(addAppModalCloseLocator));
		if (addAppModalCloseLinkElement.isDisplayed())
			addAppModalCloseLinkElement.click();
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

	public WebElement getViewAllNewsPageElement() {
		return driverManager.getDriver().findElement(By.xpath(latestNewsViewAllLinkLocator));
	}

}

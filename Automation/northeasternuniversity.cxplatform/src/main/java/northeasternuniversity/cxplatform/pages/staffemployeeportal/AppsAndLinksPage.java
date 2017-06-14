/**
 * 
 */
package northeasternuniversity.cxplatform.pages.staffemployeeportal;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

	private String recentLinksListULLocator;
	private String quickLinksListULLocator;
	private String recentLinksListLocator;
	private String quickLinksListLocator;
	private String appsDivListLocator;
	private String appsportletlistcontainerLocator;
	private String seeAllOtherHumanResourcesLinkLocator;
	private String mostRelevantHumanResourcesDivLocator;
	private String mostRelevantHumanResourcesLinksLocator;
	private String relatedCategoriesHumanResourcesDivLocator;
	private String relatedCategoriesHumanResourcesLinksLocator;
	private String seeAllOtherBenefitsLinkLocator;
	private String mostRelevantBenefitsDivLocator;
	private String mostRelevantBenefitsLinksLocator;
	private String relatedCategoriesBenefitsDivLocator;
	private String relatedCategoriesBenefitsLinksLocator;

	/**
	 * 
	 */

	public AppsAndLinksPage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager,
			ConstantsPropertiesManager constantsPropertiesManager) {
		this.driverManager = driverManager;
		this.uIElementsManager = UIElementsPropertiesManager;
		this.constantsPropertiesManager = constantsPropertiesManager;
		this.driver = this.driverManager.getDriver();

		recentLinksListULLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.recentlinkslistul");
		quickLinksListULLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.quicklinkslistul");
		recentLinksListLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.recentlinkslist");
		quickLinksListLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.quicklinkslist");
		appsDivListLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.appsdivslist");
		appsportletlistcontainerLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.appsportletlistcontainer");
		seeAllOtherHumanResourcesLinkLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.seeallothersonhumanresources");
		mostRelevantHumanResourcesDivLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.mostrelevanhumanresourceslistcontainer");
		mostRelevantHumanResourcesLinksLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.mostrelevanhumanresourceslinks");
		relatedCategoriesHumanResourcesDivLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.relatedCategorieshumanresourceslistcontainer");
		relatedCategoriesHumanResourcesLinksLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.relatedCategorieshumanresourceslinks");
		seeAllOtherBenefitsLinkLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.seeallothersonbenefits");
		mostRelevantBenefitsDivLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.mostrelevanbenefitslistcontainer");
		mostRelevantBenefitsLinksLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.mostrelevanbenefitslinks");
		relatedCategoriesBenefitsDivLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.relatedCategoriesbenefitslistcontainer");
		relatedCategoriesBenefitsLinksLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.relatedCategoriesbenefitslinks");

	}

	public boolean isElementPresent(String path) {
		boolean isElementPresent = true;

		try {
			this.driverManager.getDriver().manage().timeouts().implicitlyWait(2200, TimeUnit.MILLISECONDS);
			@SuppressWarnings("unused")
			WebElement webElement = this.driverManager.getDriver().findElement(By.xpath(path));

		} catch (NoSuchElementException exception) {
			isElementPresent = false;
		}

		return isElementPresent;
	}

	public Boolean isRecentLinksListULElementPresent() {
		return this.isElementPresent(recentLinksListULLocator);
	}

	public Boolean isQuickLinksListULElementPresent() {
		return this.isElementPresent(quickLinksListULLocator);
	}

	public Boolean isAppsPortletDivElementPresent() {
		return this.isElementPresent(appsportletlistcontainerLocator);
	}

	public Boolean isMostRelevantHumanResourcesDivElementPresent() {
		return this.isElementPresent(mostRelevantHumanResourcesDivLocator);
	}

	public Boolean isRelatedCategoriesHumanResourcesDivElementPresent() {
		return this.isElementPresent(relatedCategoriesHumanResourcesDivLocator);
	}

	public Boolean isSeeAllOthersHumanResourcesLinkElementPresent() {
		return this.isElementPresent(seeAllOtherHumanResourcesLinkLocator);
	}

	public void seeAllOthersHumanResourcesLinkClick() {
		WebElement seeAllOthersHumanResourcesLinkElement = driverManager.getDriver()
				.findElement(By.xpath(seeAllOtherHumanResourcesLinkLocator));
		if (seeAllOthersHumanResourcesLinkElement.isDisplayed())
			seeAllOthersHumanResourcesLinkElement.click();
	}

	public Boolean hasMostRelevantHumanResourcesLinks() {
		int mostRelevantHumanResourcesLinksSize = this.driverManager.getDriver()
				.findElements(By.xpath(mostRelevantHumanResourcesLinksLocator)).size();
		if (isMostRelevantHumanResourcesDivElementPresent()) {
			if (mostRelevantHumanResourcesLinksSize > 0)
				return true;
			else
				return false;
		} else
			return false;

	}

	public Boolean hasRelatedCategoriesHumanResourcesLinks() {
		int relatedCategoriesHumanResourcesLinksSize = this.driverManager.getDriver()
				.findElements(By.xpath(relatedCategoriesHumanResourcesLinksLocator)).size();
		if (isRelatedCategoriesHumanResourcesDivElementPresent()) {
			if (relatedCategoriesHumanResourcesLinksSize > 0)
				return true;
			else
				return false;
		} else
			return false;
	}

	public Boolean isMostRelevantBenefitsDivElementPresent() {
		return this.isElementPresent(mostRelevantBenefitsDivLocator);
	}

	public Boolean isRelatedCategoriesBenefitsDivElementPresent() {
		return this.isElementPresent(relatedCategoriesBenefitsDivLocator);
	}

	public Boolean isSeeAllOthersBenefitsLinkElementPresent() {
		return this.isElementPresent(seeAllOtherBenefitsLinkLocator);
	}

	public void seeAllOthersBenefitsLinkClick() {
		WebElement seeAllOthersBenefitsLinkElement = driverManager.getDriver()
				.findElement(By.xpath(seeAllOtherBenefitsLinkLocator));
		if (seeAllOthersBenefitsLinkElement.isDisplayed())
			seeAllOthersBenefitsLinkElement.click();
	}

	public Boolean hasMostRelevantBenefitsLinks() {
		int mostRelevantBenefitsLinksSize = this.driverManager.getDriver()
				.findElements(By.xpath(mostRelevantBenefitsLinksLocator)).size();
		if (isMostRelevantBenefitsDivElementPresent()) {
			if (mostRelevantBenefitsLinksSize > 0)
				return true;
			else
				return false;
		} else
			return false;

	}

	public Boolean hasRelatedCategoriesBenefitsLinks() {
		int relatedCategoriesBenefitsLinksSize = this.driverManager.getDriver()
				.findElements(By.xpath(relatedCategoriesBenefitsLinksLocator)).size();
		if (isRelatedCategoriesBenefitsDivElementPresent()) {
			if (relatedCategoriesBenefitsLinksSize > 0)
				return true;
			else
				return false;
		} else
			return false;
	}

	public Boolean hasRecentLinks() {
		int recentlinksListSize = this.driverManager.getDriver().findElements(By.xpath(recentLinksListLocator)).size();
		if (isRecentLinksListULElementPresent()) {
			if (recentlinksListSize > 0)
				return true;
			else
				return false;
		} else
			return false;

	}

	public Boolean hasQuickLinks() {
		int recentlinksListSize = this.driverManager.getDriver().findElements(By.xpath(quickLinksListLocator)).size();
		if (isQuickLinksListULElementPresent()) {
			if (recentlinksListSize > 0)
				return true;
			else
				return false;
		} else
			return false;

	}

	public Boolean hasAppsElements() {
		int appsListSize = this.driverManager.getDriver().findElements(By.xpath(appsDivListLocator)).size();
		if (isAppsPortletDivElementPresent()) {
			if (appsListSize > 0)
				return true;
			else
				return false;
		} else
			return false;

	}

	public List<WebElement> getAllElementsOnRelatedCategoriesHumanResourcesLinks() {
		List<WebElement> listOfRelatedCategoriesHumanResourcesList;
		listOfRelatedCategoriesHumanResourcesList = this.driverManager.getDriver()
				.findElements(By.xpath(relatedCategoriesHumanResourcesLinksLocator));
		return listOfRelatedCategoriesHumanResourcesList;
	}

	public List<WebElement> getAllElementsOnMostRelevanHumanResourcesLinks() {
		List<WebElement> listOfMostRelevantHumanResourcesList;
		listOfMostRelevantHumanResourcesList = this.driverManager.getDriver()
				.findElements(By.xpath(mostRelevantHumanResourcesLinksLocator));
		return listOfMostRelevantHumanResourcesList;
	}

	public List<WebElement> getAllElementsOnRelatedCategoriesBenefitsLinks() {
		List<WebElement> listOfRelatedCategoriesBenefitsList;
		listOfRelatedCategoriesBenefitsList = this.driverManager.getDriver()
				.findElements(By.xpath(relatedCategoriesBenefitsLinksLocator));
		return listOfRelatedCategoriesBenefitsList;
	}

	public List<WebElement> getAllElementsOnMostRelevanBenefitsLinks() {
		List<WebElement> listOfMostRelevantBenefitsList;
		listOfMostRelevantBenefitsList = this.driverManager.getDriver()
				.findElements(By.xpath(mostRelevantBenefitsLinksLocator));
		return listOfMostRelevantBenefitsList;
	}

	public List<WebElement> getAllElementsOnAppsPortletList() {
		List<WebElement> listOfApps;
		listOfApps = this.driverManager.getDriver().findElements(By.xpath(appsDivListLocator));
		return listOfApps;
	}

	public Boolean compareHREFAttributeOfAppClickableDivElements(WebElement webElementExpected,
			WebElement webElementToCompare) {
		Boolean result = false;
		if (getHREFAttributeOfAElement(webElementExpected)
				.equalsIgnoreCase(getHREFAttributeOfAElement(webElementToCompare)))
			result = true;
		return result;
	}

	public String getHREFAttributeOfAElement(WebElement element) {
		return element.getAttribute("href");
	}

	public List<WebElement> getAllElementsOnRecentLinksList() {
		List<WebElement> listOfRecentLinks;
		listOfRecentLinks = this.driverManager.getDriver().findElements(By.xpath(recentLinksListLocator));
		return listOfRecentLinks;
	}

	public LinkedList<String> getAllElementTextsOnRecentLinksList() {
		LinkedList<String> listOfRecentLinksTexts = new LinkedList<String>();

		List<WebElement> recentLinkslist = this.getAllElementsOnRecentLinksList();
		for (WebElement element : recentLinkslist) {
			String elementText = element.getText();
			listOfRecentLinksTexts.add(elementText);
		}

		return listOfRecentLinksTexts;
	}

	public List<WebElement> getAllElementsOnQuickLinksList() {
		List<WebElement> listOfQuickLinks;
		listOfQuickLinks = this.driverManager.getDriver().findElements(By.xpath(quickLinksListLocator));
		return listOfQuickLinks;
	}

	public void pinARecentLinkToQuickLinks() {
		List<WebElement> recentLinkslist = this.getAllElementsOnRecentLinksList();
		for (WebElement element : recentLinkslist) {
			String elementText = element.getText();
			String xpathOfPinElement = recentLinksListLocator + "/a[contains(text(),'" + elementText + "')]/../i";
			WebElement pinElement = this.driverManager.getDriver().findElement(By.xpath(xpathOfPinElement));
			pinElement.click();
			driverManager.driverShortWait();
		}

	}

	public void unpinFromQuickLinks(WebElement ElementToUnpin) {
		List<WebElement> quicklinkslist = this.getAllElementsOnQuickLinksList();
		for (WebElement element : quicklinkslist) {
			String elementText = element.getText();

			// move over the element
			Actions actions = new Actions(this.getDriverManager().getDriver());
			actions.moveToElement(element).build().perform();

			if (elementText.equalsIgnoreCase(ElementToUnpin.getText())) {
				String xpathOfUnPinElement = quickLinksListLocator + "/a[contains(text(),'" + elementText + "')]/../i";
				WebElement unpinElement = this.driverManager.getDriver().findElement(By.xpath(xpathOfUnPinElement));
				unpinElement.click();
				driverManager.driverShortWait();
				break;
			}
		}

	}

	public WebElement getElementFromQuickLinks(String elementToFind) {
		WebElement elementToReturn = null;

		List<WebElement> quicklinkslist = this.getAllElementsOnQuickLinksList();
		for (WebElement element : quicklinkslist) {
			String webelementText = element.getText();

			if (webelementText.equalsIgnoreCase(elementToFind))
				elementToReturn = element;

		}

		return elementToReturn;
	}

	public LinkedList<WebElement> getAllQuickLinksHyperlinks() {
		List<WebElement> quicklinks = this.getAllElementsOnQuickLinksList();
		LinkedList<WebElement> hyperlinks = new LinkedList<>();

		for (WebElement element : quicklinks) {
			String elementText = element.getText();
			String hyperlinkXPath = quickLinksListLocator + "/a[contains(text(),'" + elementText + "')]";
			WebElement hyperLinkElement = this.driverManager.getDriver().findElement(By.xpath(hyperlinkXPath));
			hyperlinks.add(hyperLinkElement);
		}

		return hyperlinks;
	}

	public LinkedList<WebElement> getAllRecentLinksHyperlinks() {
		List<WebElement> recentlinks = this.getAllElementsOnRecentLinksList();
		LinkedList<WebElement> hyperlinks = new LinkedList<>();

		for (WebElement element : recentlinks) {
			String elementText = element.getText();
			String hyperlinkXPath = quickLinksListLocator + "/a[contains(text(),'" + elementText + "')]";
			WebElement hyperLinkElement = this.driverManager.getDriver().findElement(By.xpath(hyperlinkXPath));
			hyperlinks.add(hyperLinkElement);
		}

		return hyperlinks;
	}

	public boolean hyperLinkHasTargetBlankAttribute(WebElement elementToValidate) {
		boolean result = false;

		if (elementToValidate.getAttribute("target").equalsIgnoreCase("_blank"))
			result = true;

		return result;

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

	public boolean isElementOnRecentLinks(String elementToFind) {
		Boolean result = false;

		List<WebElement> recentLinkslist = this.getAllElementsOnRecentLinksList();

		for (WebElement element : recentLinkslist) {
			String elementText = element.getText();

			if (elementText.equalsIgnoreCase(elementToFind))
				result = true;

		}

		return result;
	}

}

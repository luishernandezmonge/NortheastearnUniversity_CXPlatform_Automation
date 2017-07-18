/**
 * 
 */
package northeasternuniversity.cxplatform.pages.staffemployeeportal;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	private String seeAllOtherLibraryLinkLocator;
	private String mostRelevantLibraryDivLocator;
	private String mostRelevantLibraryLinksLocator;
	private String relatedCategoriesLibraryDivLocator;
	private String relatedCategoriesLibraryLinksLocator;
	private String seeAllOtherAcademicResourcesLinkLocator;
	private String mostRelevantAcademicResourcesDivLocator;
	private String mostRelevantAcademicResourcesLinksLocator;
	private String relatedCategoriesAcademicResourcesDivLocator;
	private String relatedCategoriesAcademicResourcesLinksLocator;
	private String heroTextLocator;
	private String heroTitleLocator;
	private String profileManagementPortletDiv;
	private String profileManagementLink;
	private String profileManagementPopUp;
	private String profileManagementPopUpTitle;
	private String profileManagementPopUpCloseButton;
	private String appsSearchPortletContainerLocator;
	private String appsSearchBoxLocator;
	private String appsSearchResultsListLocator;
	private String appsSearchResultsListItemsLocator;
	private String appsSearchResultsCloseButtonLocator;
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
		seeAllOtherLibraryLinkLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.seeallothersonlibrary");
		mostRelevantLibraryDivLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.mostrelevanlibrarylistcontainer");
		mostRelevantLibraryLinksLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.mostrelevanlibrarylinks");
		relatedCategoriesLibraryDivLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.relatedCategorieslibrarylistcontainer");
		relatedCategoriesLibraryLinksLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.relatedCategorieslibrarylinks");
		seeAllOtherAcademicResourcesLinkLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.seeallothersonacademicresources");
		mostRelevantAcademicResourcesDivLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.mostrelevanacademicresourceslistcontainer");
		mostRelevantAcademicResourcesLinksLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.mostrelevanacademicresourceslinks");
		relatedCategoriesAcademicResourcesDivLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.relatedCategoriesacademicresourceslistcontainer");
		relatedCategoriesAcademicResourcesLinksLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.relatedCategoriesacademicresourceslinks");
		heroTextLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.herotext");
		heroTitleLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.herotitle");
		profileManagementPortletDiv = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.profilemanagementcontainer");
		profileManagementLink = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.profilemanagementLink");
		profileManagementPopUp = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.profilemanagementpopupcontainer");
		profileManagementPopUpTitle = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.profilemanagementpopuptitle");
		profileManagementPopUpCloseButton = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.profilemanagementpopupclosebutton");
		appsSearchPortletContainerLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.appssearchportletcontainer");
		appsSearchBoxLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.appssearchbox");
		appsSearchResultsListLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.appssearchresultslistcontainer");
		appsSearchResultsListItemsLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.appssearchresultslist");
		appsSearchResultsCloseButtonLocator = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("northeastern.edu.appsandlinkspage.appssearchresultsclosebutton");
	}

	public boolean isElementPresent(String path) {
		boolean isElementPresent = true;

		try {
			this.driverManager.getDriver().manage().timeouts().implicitlyWait(1200, TimeUnit.MILLISECONDS);
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

	public boolean isHeroTextElementPresent() {
		return this.isElementPresent(heroTextLocator);
	}

	public boolean isHeroTitleElementPresent() {
		return this.isElementPresent(heroTitleLocator);
	}

	public Boolean isTheCorrectData(String expectedData, WebElement elementToVerify) {
		Boolean result = false;
		String elementText = elementToVerify.getText().toLowerCase().trim();
		if (expectedData.toLowerCase().trim().equalsIgnoreCase(elementText)){
			result = true;}

		return result;
	}

	public Boolean isTheCorrectDataForHeroTitle(String expectedData) {
		Boolean result = false;
		if (isHeroTitleElementPresent()) {
			WebElement heroTitleElement = driverManager.getDriver().findElement(By.xpath(heroTitleLocator));

			if (isTheCorrectData(expectedData, heroTitleElement))
				result = true;
		}

		return result;
	}

	public Boolean isTheCorrectDataForHeroText(String expectedData) {
		Boolean result = false;
		if (isHeroTextElementPresent()) {
			WebElement heroTextElement = driverManager.getDriver().findElement(By.xpath(heroTextLocator));
			if (isTheCorrectData(expectedData, heroTextElement))
				result = true;
		}

		return result;
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

	public Boolean isMostRelevantLibraryDivElementPresent() {
		return this.isElementPresent(mostRelevantLibraryDivLocator);
	}

	public Boolean isRelatedCategoriesLibraryDivElementPresent() {
		return this.isElementPresent(relatedCategoriesLibraryDivLocator);
	}

	public Boolean isSeeAllOthersLibraryLinkElementPresent() {
		return this.isElementPresent(seeAllOtherLibraryLinkLocator);
	}

	public void seeAllOthersLibraryLinkClick() {
		WebElement seeAllOthersLibraryLinkElement = driverManager.getDriver()
				.findElement(By.xpath(seeAllOtherLibraryLinkLocator));
		if (seeAllOthersLibraryLinkElement.isDisplayed())
			seeAllOthersLibraryLinkElement.click();
	}

	public Boolean hasMostRelevantLibraryLinks() {
		int mostRelevantLibraryLinksSize = this.driverManager.getDriver()
				.findElements(By.xpath(mostRelevantLibraryLinksLocator)).size();
		if (isMostRelevantLibraryDivElementPresent()) {
			if (mostRelevantLibraryLinksSize > 0)
				return true;
			else
				return false;
		} else
			return false;

	}

	public Boolean hasRelatedCategoriesLibraryLinks() {
		int relatedCategoriesLibraryLinksSize = this.driverManager.getDriver()
				.findElements(By.xpath(relatedCategoriesLibraryLinksLocator)).size();
		if (isRelatedCategoriesLibraryDivElementPresent()) {
			if (relatedCategoriesLibraryLinksSize > 0)
				return true;
			else
				return false;
		} else
			return false;
	}

	public Boolean isMostRelevantAcademicResourcesDivElementPresent() {
		return this.isElementPresent(mostRelevantAcademicResourcesDivLocator);
	}

	public Boolean isRelatedCategoriesAcademicResourcesDivElementPresent() {
		return this.isElementPresent(relatedCategoriesAcademicResourcesDivLocator);
	}

	public Boolean isSeeAllOthersAcademicResourcesLinkElementPresent() {
		return this.isElementPresent(seeAllOtherAcademicResourcesLinkLocator);
	}

	public void seeAllOthersAcademicResourcesLinkClick() {
		WebElement seeAllOthersAcademicResourcesLinkElement = driverManager.getDriver()
				.findElement(By.xpath(seeAllOtherAcademicResourcesLinkLocator));
		if (seeAllOthersAcademicResourcesLinkElement.isDisplayed())
			seeAllOthersAcademicResourcesLinkElement.click();
	}

	public Boolean hasMostRelevantAcademicResourcesLinks() {
		int mostRelevantAcademicResourcesLinksSize = this.driverManager.getDriver()
				.findElements(By.xpath(mostRelevantLibraryLinksLocator)).size();
		if (isMostRelevantAcademicResourcesDivElementPresent()) {
			if (mostRelevantAcademicResourcesLinksSize > 0)
				return true;
			else
				return false;
		} else
			return false;

	}

	public Boolean hasRelatedCategoriesAcademicResourcesLinks() {
		int relatedCategoriesAcademicResourcesLinksSize = this.driverManager.getDriver()
				.findElements(By.xpath(relatedCategoriesAcademicResourcesLinksLocator)).size();
		if (isRelatedCategoriesAcademicResourcesDivElementPresent()) {
			if (relatedCategoriesAcademicResourcesLinksSize > 0)
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

	public List<WebElement> getAllElementsOnRelatedCategoriesLibraryLinks() {
		List<WebElement> listOfRelatedCategoriesLibraryList;
		listOfRelatedCategoriesLibraryList = this.driverManager.getDriver()
				.findElements(By.xpath(relatedCategoriesLibraryLinksLocator));
		return listOfRelatedCategoriesLibraryList;
	}

	public List<WebElement> getAllElementsOnMostRelevanLibraryLinks() {
		List<WebElement> listOfMostRelevantLibraryList;
		listOfMostRelevantLibraryList = this.driverManager.getDriver()
				.findElements(By.xpath(mostRelevantLibraryLinksLocator));
		return listOfMostRelevantLibraryList;
	}

	public List<WebElement> getAllElementsOnRelatedCategoriesAcademicResourcesLinks() {
		List<WebElement> listOfRelatedCategoriesAcademicResourcesList;
		listOfRelatedCategoriesAcademicResourcesList = this.driverManager.getDriver()
				.findElements(By.xpath(relatedCategoriesAcademicResourcesLinksLocator));
		return listOfRelatedCategoriesAcademicResourcesList;
	}

	public List<WebElement> getAllElementsOnMostRelevanAcademicResourcesLinks() {
		List<WebElement> listOfMostRelevantAcademicResourcesList;
		listOfMostRelevantAcademicResourcesList = this.driverManager.getDriver()
				.findElements(By.xpath(mostRelevantAcademicResourcesLinksLocator));
		return listOfMostRelevantAcademicResourcesList;
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

	public boolean isProfileManagementPortletPresent() {
		return this.isElementPresent(profileManagementPortletDiv);
	}

	public boolean isProfileManagementLinkPresent() {
		return this.isElementPresent(profileManagementLink);
	}

	public void profileManagementLinkClick() {
		WebElement profileManagementLink = driverManager.getDriver().findElement(By.xpath(this.profileManagementLink));
		if (profileManagementLink.isDisplayed())
			profileManagementLink.click();
	}

	public boolean isProfileManagementPopupPresentAndDisplayed() {
		Boolean result = false;
		if (isElementPresent(profileManagementPopUp)) {
			WebElement element = driverManager.getDriver().findElement(By.xpath(profileManagementPopUp));
			if (element.isDisplayed())
				result = true;
		}

		return result;
	}

	public boolean isProfileManagementPopupTitle() {
		return this.isElementPresent(profileManagementPopUpTitle);
	}

	public boolean isProfileManagementPopupCloseButton() {
		return this.isElementPresent(profileManagementPopUpCloseButton);
	}

	public void profileManagementPopupCloseClick() {
		WebElement profileManagementPopupClose = driverManager.getDriver()
				.findElement(By.xpath(this.profileManagementPopUpCloseButton));
		if (profileManagementPopupClose.isDisplayed())
			profileManagementPopupClose.click();
	}

	public boolean isSearchAppsPortletPresent() {
		return this.isElementPresent(appsSearchPortletContainerLocator);
	}

	public boolean isSearchAppsBoxPresent() {
		return this.isElementPresent(appsSearchBoxLocator);
	}

	public void setAppsSearchCriteria(String criteria) {
		if (isSearchAppsBoxPresent()) {
			WebElement appsSearchBox = driverManager.getDriver().findElement(By.xpath(this.appsSearchBoxLocator));
			appsSearchBox.click();
			appsSearchBox.clear();
			appsSearchBox.sendKeys(criteria);
			appsSearchBox.sendKeys(Keys.RETURN);
			driverManager.driverShortWait();
		}
	}

	public boolean isSearchAppsResultsListPresentAndDisplayed() {
		Boolean result = false;
		if (isElementPresent(appsSearchResultsListLocator)) {
			WebElement element = driverManager.getDriver().findElement(By.xpath(appsSearchResultsListLocator));
			if (element.isDisplayed())
				result = true;
		}
		return result;
	}

	public Boolean hasAppsSearchResultItems() {
		int appsSearchResultsListSize = this.driverManager.getDriver()
				.findElements(By.xpath(appsSearchResultsListItemsLocator)).size();
		if (isSearchAppsResultsListPresentAndDisplayed()) {
			if (appsSearchResultsListSize > 0)
				return true;
			else
				return false;
		} else
			return false;

	}

	public List<WebElement> getAllAppsSearchResultItems() {
		List<WebElement> listOfAppsSerachResultsItems;
		listOfAppsSerachResultsItems = this.driverManager.getDriver()
				.findElements(By.xpath(appsSearchResultsListItemsLocator));
		return listOfAppsSerachResultsItems;
	}

	public boolean isSearchAppsCloseResultsButtonPresentAndDisplayed() {
		Boolean result = false;
		if (isElementPresent(appsSearchResultsCloseButtonLocator)) {
			WebElement element = driverManager.getDriver().findElement(By.xpath(appsSearchResultsCloseButtonLocator));
			if (element.isDisplayed())
				result = true;
		}
		return result;
	}

	public void searchAppsCloseResultsButtonClick() {
		WebElement searchAppsCloseResultsButtonElement = driverManager.getDriver()
				.findElement(By.xpath(appsSearchResultsCloseButtonLocator));
		if (searchAppsCloseResultsButtonElement.isDisplayed())
			searchAppsCloseResultsButtonElement.click();
	}

}
